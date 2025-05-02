package com.brasil.transparente.processor.service.generator;

import com.brasil.transparente.processor.entity.Poder;
import com.brasil.transparente.processor.service.GeneralGeneratorService;
import com.brasil.transparente.processor.util.NameCorrector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class MainGeneratorService {

    private final ExecutivoGeneratorService executivo2GeneratorService;
    private final JudiciarioGeneratorService judiciario2GeneratorService;
    private final LegislativoGeneratorService legislativo2GeneratorService;
    private final OrgaosAutonomosGeneratorService orgaos2AutonomosGeneratorService;
    private final SimplifiedGeneratorService simplifiedGeneratorService;
    private final GeneralGeneratorService generalGeneratorService;
    private final NameCorrector nameCorrector;

    @Autowired
    public MainGeneratorService(ExecutivoGeneratorService executivo2GeneratorService,
                                JudiciarioGeneratorService judiciario2GeneratorService,
                                LegislativoGeneratorService legislativo2GeneratorService,
                                OrgaosAutonomosGeneratorService orgaos2AutonomosGeneratorService,
                                SimplifiedGeneratorService simplifiedGeneratorService,
                                GeneralGeneratorService generalGeneratorService,
                                NameCorrector nameCorrector) {
        this.executivo2GeneratorService = executivo2GeneratorService;
        this.judiciario2GeneratorService = judiciario2GeneratorService;
        this.legislativo2GeneratorService = legislativo2GeneratorService;
        this.orgaos2AutonomosGeneratorService = orgaos2AutonomosGeneratorService;
        this.simplifiedGeneratorService = simplifiedGeneratorService;
        this.generalGeneratorService = generalGeneratorService;
        this.nameCorrector = nameCorrector;
    }

    List<Poder> poderList = new ArrayList<>();

    public void generateCompleteReportService(String year) {
        poderList.add(executivo2GeneratorService.generate(year));
        poderList.add(judiciario2GeneratorService.generate(year));
        poderList.add(legislativo2GeneratorService.generate(year));
        poderList.add(orgaos2AutonomosGeneratorService.generate(year));
        double gastoTotalValue = generalGeneratorService.aggregateAndSaveTotalExpense(poderList);
        generalGeneratorService.removeNegativeOrZeroExpenses(poderList);
        generalGeneratorService.setTotalPercentages(poderList, gastoTotalValue);
        nameCorrector.refactorNames(poderList);
        generalGeneratorService.saveStructure(poderList);
        simplifiedGeneratorService.generateSimplifiedReport();
        log.info("[FINALIZADO]");
    }

}
