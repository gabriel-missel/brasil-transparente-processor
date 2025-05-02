package com.brasil.transparente.processor.service.generator;

import com.brasil.transparente.processor.entity.Poder;
import com.brasil.transparente.processor.service.CsvReaderService;
import com.brasil.transparente.processor.service.GeneralGeneratorService;
import com.brasil.transparente.processor.service.parser.legislativo.CamaraDeputadosLineParser;
import com.brasil.transparente.processor.service.parser.legislativo.SenadoLineParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Slf4j
@Service
public class LegislativoGeneratorService implements Generator {
    @Value("${CSV_PATH}")
    private String csvPath;

    private final GeneralGeneratorService generalGeneratorService;
    private final CsvReaderService csvReaderService;
    private final SenadoLineParser senadoLineParser;
    private final CamaraDeputadosLineParser camaraDeputadosLineParser;

    private final Poder poder = new Poder(LEGISLATIVO);
    private static final String LEGISLATIVO = "Poder Legislativo";

    @Autowired
    public LegislativoGeneratorService(GeneralGeneratorService generalGeneratorService, CsvReaderService csvReaderService,
                                       SenadoLineParser senadoLineParser,
                                       CamaraDeputadosLineParser camaraDeputadosLineParser) {
        this.generalGeneratorService = generalGeneratorService;
        this.csvReaderService = csvReaderService;
        this.senadoLineParser = senadoLineParser;
        this.camaraDeputadosLineParser = camaraDeputadosLineParser;
    }
    @Override
    public Poder generate(String year) {
        log.info("Poder Legislativo - Iniciando");
        log.info("Camara de Deputados - Lendo arquivos de despesas e criando estrutura de despesa.");
        generateCamaraDeputados();
        log.info("Senado Federal - Lendo arquivos de despesas e criando estrutura de despesa.");
        generateSenado();
        generalGeneratorService.aggregateAllPowerSpending(poder);
        generalGeneratorService.setRelationships(poder);
        log.info("Poder Legislativo - Finalizado");
        return poder;
    }

    private void generateCamaraDeputados() {
        String delimiter = "\t";
        String camaraDeputadosFilePath = Paths.get(csvPath, "/Legislativo/CamaraDeputados.csv").toString();
        csvReaderService.processCsv(camaraDeputadosFilePath, delimiter, camaraDeputadosLineParser, poder);
    }

    private void generateSenado() {
        String delimiter = "\t";
        String senadoFilePath = Paths.get(csvPath, "/Legislativo/Senado.csv").toString();
        csvReaderService.processCsv(senadoFilePath, delimiter, senadoLineParser, poder);
    }
}
