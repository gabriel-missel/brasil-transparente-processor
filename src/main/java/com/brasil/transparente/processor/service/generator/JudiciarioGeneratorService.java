package com.brasil.transparente.processor.service.generator;

import com.brasil.transparente.processor.entity.Poder;
import com.brasil.transparente.processor.service.CsvReaderService;
import com.brasil.transparente.processor.service.GeneralGeneratorService;
import com.brasil.transparente.processor.service.parser.judiciario.JudiciarioStandardJusticeLineParser;
import com.brasil.transparente.processor.service.parser.judiciario.JudiciarioStfLineParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Slf4j
@Service
public class JudiciarioGeneratorService implements Generator {
    private final CsvReaderService csvReaderService;
    private final JudiciarioStfLineParser judiciarioStfLineParser;
    private final JudiciarioStandardJusticeLineParser judiciarioStandardJusticeLineParser;
    private final GeneralGeneratorService generalGeneratorService;
    private final Poder poder = new Poder(JUDICIARIO);
    private final String csvPath;

    private static final String JUDICIARIO = "Poder Judiciário";
    private static final String SUPERIOR_TRIBUNAL_JUSTICA = "Superior Tribunal de Justiça";
    private static final String JUSTICA_MILITAR = "Justiça Militar";
    private static final String JUSTICA_FEDERAL = "Justiça Federal";
    private static final String JUSTICA_ELEITORAL = "Justiça Eleitoral";
    private static final String JUSTICA_TRABALHO = "Justiça do Trabalho";
    private static final String JUSTICA_DF_TERRITORIOS = "Justiça do Distrito Federal e Territórios";
    private static final String CONSELHO_NACIONAL_JUSTICA = "Conselho Nacional de Justiça";

    @Autowired
    public JudiciarioGeneratorService(CsvReaderService csvReaderService,
                                      JudiciarioStfLineParser judiciarioStfLineParser,
                                      JudiciarioStandardJusticeLineParser judiciarioStandardJusticeLineParser,
                                      GeneralGeneratorService generalGeneratorService,
                                      @Value("${CSV_PATH}") String csvPath) {
        this.csvPath = csvPath;
        this.csvReaderService = csvReaderService;
        this.judiciarioStfLineParser = judiciarioStfLineParser;
        this.judiciarioStandardJusticeLineParser = judiciarioStandardJusticeLineParser;
        this.generalGeneratorService = generalGeneratorService;
    }

    @Override
    public Poder generate(String year) {
        log.info("Poder Judiciário - Iniciando");
        generateSuperiorTribunalFederal();
        generateStandardJustice(year, SUPERIOR_TRIBUNAL_JUSTICA);
        generateStandardJustice(year, JUSTICA_MILITAR);
        generateStandardJustice(year, JUSTICA_FEDERAL);
        generateStandardJustice(year, JUSTICA_ELEITORAL);
        generateStandardJustice(year, JUSTICA_TRABALHO);
        generateStandardJustice(year, JUSTICA_DF_TERRITORIOS);
        generateStandardJustice(year, CONSELHO_NACIONAL_JUSTICA);
        generalGeneratorService.aggregateAllPowerSpending(poder);
        generalGeneratorService.setRelationships(poder);
        log.info("Poder Judiciário - Finalizado");
        return poder;
    }

    private void generateSuperiorTribunalFederal() {
        log.info("Lendo arquivo do STF e criando estrutura de despesas");
        String delimiter = ",";
        String stfFilePath = Paths.get(csvPath, "/Judiciario/Supremo Tribunal Federal/STF.csv").toString();
        csvReaderService.processCsv(stfFilePath, delimiter, judiciarioStfLineParser, poder);
    }

    private void generateStandardJustice(String year,String tribunal) {
        String delimiter = "\t";
        String basePath = csvPath + "/Judiciario" + tribunal + "/despesas" + year;
        csvReaderService.processMonthlyFiles(basePath, year, delimiter, judiciarioStandardJusticeLineParser, poder);
    }
}
