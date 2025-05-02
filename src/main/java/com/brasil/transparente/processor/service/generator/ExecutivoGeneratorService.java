package com.brasil.transparente.processor.service.generator;

import com.brasil.transparente.processor.entity.Poder;
import com.brasil.transparente.processor.service.CsvReaderService;
import com.brasil.transparente.processor.service.GeneralGeneratorService;
import com.brasil.transparente.processor.service.parser.executivo.ExecutivoLineParser;
import com.brasil.transparente.processor.service.parser.judiciario.ExecutivoStandardJusticeLineParser;
import com.brasil.transparente.processor.service.parser.judiciario.ExecutivoStfLineParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Slf4j
@Service
public class ExecutivoGeneratorService implements Generator {
    private static final String EXECUTIVO = "Poder Executivo";
    private final CsvReaderService csvReaderService;
    private final ExecutivoLineParser executivoLineParser;
    private final ExecutivoStfLineParser executivoStfLineParser;
    private final ExecutivoStandardJusticeLineParser executivoStandardJusticeLineParser;
    private final GeneralGeneratorService generalGeneratorService;
    @Value("${CSV_PATH}")
    private String csvPath;

    private final Poder poder = new Poder(EXECUTIVO);

    @Autowired
    public ExecutivoGeneratorService(CsvReaderService csvReaderService,
                                     ExecutivoLineParser executivoLineParser,
                                     ExecutivoStfLineParser executivoStfLineParser,
                                     ExecutivoStandardJusticeLineParser executivoStandardJusticeLineParser,
                                     GeneralGeneratorService generalGeneratorService) {
        this.csvReaderService = csvReaderService;
        this.executivoLineParser = executivoLineParser;
        this.executivoStfLineParser = executivoStfLineParser;
        this.executivoStandardJusticeLineParser = executivoStandardJusticeLineParser;
        this.generalGeneratorService = generalGeneratorService;
    }

    @Override
    public Poder generate(String year) {
        log.info("Poder Executivo - Iniciando");
        String executiveDelimiter = ";";
        String stfDelimiter = ",";
        String federalJusticeDelimiter = "\t";

        String executivoBasePath = csvPath + "/Executivo/despesas";
        String federalJusticeBasePath = "\\Judiciario\\Justiça Federal\\despesas";
        String stfFilePath = Paths.get(csvPath, "/Judiciario/Supremo Tribunal Federal/STF.csv").toString();

        log.info("Lendo arquivos do Poder Executivo e criando estrutura de despesa");
        csvReaderService.processMonthlyFiles(executivoBasePath, year, executiveDelimiter, executivoLineParser, poder);

        log.info("Justiça Federal - Lendo arquivos de despesas e criando estrutura de despesa");
        csvReaderService.processMonthlyFiles(federalJusticeBasePath, year, federalJusticeDelimiter, executivoStandardJusticeLineParser, poder);

        log.info("STF - Lendo arquivos de despesas e criando estrutura de despesa.");
        csvReaderService.processCsv(stfFilePath, stfDelimiter, executivoStfLineParser, poder);

        generalGeneratorService.aggregateAllPowerSpending(poder);
        generalGeneratorService.setRelationships(poder);
        log.info("Poder Executivo - Finalizado");
        return poder;
    }
}
