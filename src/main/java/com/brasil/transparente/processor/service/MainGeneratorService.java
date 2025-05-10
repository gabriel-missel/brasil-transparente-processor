package com.brasil.transparente.processor.service;

import com.brasil.transparente.processor.entity.Poder;
import com.brasil.transparente.processor.entity.UnidadeFederativa;
import com.brasil.transparente.processor.util.NameCorrector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MainGeneratorService {

    @Autowired
    private ExecutivoGeneratorService executivoGeneratorService;
    @Autowired
    private JudiciarioGeneratorService judiciarioGeneratorService;
    @Autowired
    private LegislativoGeneratorService legislativoGeneratorService;
    @Autowired
    private SimplifiedGeneratorService simplifiedGeneratorService;
    @Autowired
    private OrgaosAutonomosGeneratorService orgaosAutonomosGeneratorService;
    @Autowired
    private GeneralGeneratorService generalGeneratorService;
    @Autowired
    private NameCorrector nameCorrector;
    @Autowired
    private EstadoGeneratorService estadoGeneratorService;

    private static final String UNIAO_FEDERAL = "União Federal";
    List<Poder> poderList = new ArrayList<>();

    public void generateCompleteReportService(String year) {
        UnidadeFederativa unidadeFederativa = new UnidadeFederativa(UNIAO_FEDERAL, 1L);
        poderList.add(executivoGeneratorService.generateExecutiveBranch(year));
        poderList.add(judiciarioGeneratorService.generateJudiciaryBranch(year));
        poderList.add(legislativoGeneratorService.generateLegislativeBranch());
        poderList.add(orgaosAutonomosGeneratorService.generateOrgaosAutonomos(year));
        unidadeFederativa.setListPoder(poderList);
        generalGeneratorService.setRelationships(unidadeFederativa);
        double gastoTotalValue = generalGeneratorService.aggregateTotalExpense(unidadeFederativa);
        generalGeneratorService.removeNegativeOrZeroExpenses(unidadeFederativa.getListPoder());
        generalGeneratorService.setTotalPercentages(unidadeFederativa.getListPoder(), gastoTotalValue);
        nameCorrector.refactorNames(unidadeFederativa.getListPoder());
        generalGeneratorService.saveStructure(unidadeFederativa);
        simplifiedGeneratorService.generateSimplifiedReportUniao();
        log.info("Finalizado - União");
        estadoGeneratorService.generateStateExpenses(year, "RS");
        log.info("Finalizado - Estados");
        log.info("[FINALIZADO]");
    }

}
