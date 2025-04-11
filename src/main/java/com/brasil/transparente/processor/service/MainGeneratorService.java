package com.brasil.transparente.processor.service;

import com.brasil.transparente.processor.entity.Poder;
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

    List<Poder> poderList = new ArrayList<>();

    public void generateCompleteReportService(String year) {
        poderList.add(executivoGeneratorService.generateExecutiveBranch(year));
        poderList.add(judiciarioGeneratorService.generateJudiciaryBranch(year));
        poderList.add(legislativoGeneratorService.generateLegislativeBranch());
        poderList.add(orgaosAutonomosGeneratorService.generateOrgaosAutonomos(year));
        double gastoTotalValue = generalGeneratorService.aggregateAndSaveTotalExpense(poderList);
        generalGeneratorService.removeNegativeOrZeroExpenses(poderList);
        generalGeneratorService.setTotalPercentages(poderList, gastoTotalValue);
        nameCorrector.refactorNames(poderList);
        generalGeneratorService.saveStructure(poderList);
        simplifiedGeneratorService.generateSimplifiedReport();
        log.info("[FINALIZADO]");
    }

}
