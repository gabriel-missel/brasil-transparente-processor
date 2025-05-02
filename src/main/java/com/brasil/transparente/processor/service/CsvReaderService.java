package com.brasil.transparente.processor.service;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.service.parser.LineParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@Service
public class CsvReaderService {

    private final GeneralGeneratorService generalGeneratorService;

    @Autowired
    public CsvReaderService(GeneralGeneratorService generalGeneratorService) {
        this.generalGeneratorService = generalGeneratorService;
    }

    public void processCsv(String filePath, String delimiter, LineParser lineParser, Poder poder) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1))) {
            br.readLine(); // Pular cabeçalho
            String line;
            log.info("Lendo {}", filePath);
            while ((line = br.readLine()) != null) {
                processLine(line, delimiter, lineParser, poder, filePath);
            }
        } catch (IOException e) {
            generalGeneratorService.logExceptionMainFile(e);
        }
    }

    public void processMonthlyFiles(String basePath, String year, String delimiter, LineParser parser, Poder poder) {
        for (int month = 1; month <= 12; month++) {
            String monthPadded = String.format("%02d", month);
            String documentNumber = year + monthPadded;
            String filePath = basePath + year + "/" + documentNumber + ".csv";
            processCsv(filePath, delimiter, parser, poder);
        }
    }

    private void processLine(String line, String delimiter, LineParser lineParser, Poder poder, String filePath) {
        try {
            String[] rawList = line.split(delimiter);
            Optional<DadosDespesa> dadosDespesa =  lineParser.parse(rawList);
            dadosDespesa.ifPresent(despesa -> criarEstruturasDadosDespesa(despesa, poder, filePath));
        } catch (Exception e) {
            generalGeneratorService.logInvalidLine(line);
        }
    }

    private void criarEstruturasDadosDespesa(DadosDespesa dadosDespesa, Poder poder, String filePath) {

        if (dadosDespesa.getOrgao() != null) {
            Ministerio ministerio = generalGeneratorService.findOrCreateMinisterio(dadosDespesa.getMinisterio(), poder);
            Orgao orgao = generalGeneratorService.findOrCreateOrgao(dadosDespesa.getOrgao(), ministerio);
            UnidadeGestora ug = generalGeneratorService.findOrCreateUnidadeGestora(dadosDespesa.getUnidadeGestora(), orgao);
            ElementoDespesa ed = generalGeneratorService.findOrCreateNewElementoDespesa(dadosDespesa.getElementoDespesa(), ug);
            generalGeneratorService.updateTotalValueSpent(ministerio, orgao, ug, ed, dadosDespesa.getValor());
        }
        else {
            Pattern pattern = Pattern.compile("Ministerio Publico/(.*)/");
            Matcher matcher = pattern.matcher(filePath);
            matcher.find();
            String nameOrgao = matcher.group(1);
            Ministerio ministerio = generalGeneratorService.findOrCreateMinisterio(dadosDespesa.getMinisterio(), poder);
            Orgao orgao = generalGeneratorService.findOrCreateOrgao(nameOrgao, ministerio);
            UnidadeGestora ug = generalGeneratorService.findOrCreateUnidadeGestora(nameOrgao, orgao);
            ElementoDespesa ed = generalGeneratorService.findOrCreateNewElementoDespesa(dadosDespesa.getElementoDespesa(), ug);
            generalGeneratorService.updateTotalValueSpent(ministerio, orgao, ug, ed, dadosDespesa.getValor());
        }
    }
}

