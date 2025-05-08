package com.brasil.transparente.processor.service;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.util.Constants;
import com.brasil.transparente.processor.util.UnidadesFederativasConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class EstadoGeneratorService {

    @Autowired
    private GeneralGeneratorService generalGeneratorService;
    @Value("${CSV_PATH}")
    private String csvPath;
    private final List<Poder> poderList = new ArrayList<>(Arrays.asList(
            new Poder("Poder Executivo"),
            new Poder("Poder Legislativo"),
            new Poder("Poder Judiciário"),
            new Poder("Órgãos Autônomos")
    ));

    public void generateStateExpenses(String year, String state) {
        UnidadeFederativa unidadeFederativa = new UnidadeFederativa(UnidadesFederativasConstants.RS);
        int month = 1;
        while (month <= 12) {
            String yearString = String.valueOf(year);
            String monthString = String.format("%02d", month);
            String documentNumber = yearString + monthString;
            String relativePath = "/Estados/" + state + "/" + documentNumber + ".csv";
            String filePath = Paths.get(csvPath, relativePath).toString();
            String delimiter = ";";
            createStateExpanseStructure(filePath, delimiter, month, state);
            month++;
        }

        for (Poder poder : poderList) {
            generalGeneratorService.aggregateAllPowerSpending(poder);
            generalGeneratorService.setRelationships(unidadeFederativa);
        }
        double gastoTotalValue = generalGeneratorService.aggregateTotalExpense(unidadeFederativa);
        generalGeneratorService.removeNegativeOrZeroExpenses(unidadeFederativa.getListPoder());
        generalGeneratorService.setTotalPercentages(unidadeFederativa.getListPoder(), gastoTotalValue);
        generalGeneratorService.saveStructure(unidadeFederativa);
        log.info("Rio Grande do Sul - Finalizado");
    }

    private void createStateExpanseStructure(String filePath, String delimiter, int month, String state) {
        log.info("{} - Lendo arquivos e criando estrutura de despesas. Mês = {}", state, month);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1))) {
            String firstLine = br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                String[] rawList = line.split(delimiter);
                List<String> refinedList = new ArrayList<>();
                for (String column : rawList) {
                    refinedList.add(column.replace("\"", "").trim());
                }
                String tipoGasto = refinedList.get(2);
                String poderString = refinedList.get(12);
                String ministerio = refinedList.get(16);
                String orgao = refinedList.get(18);
                String unidadeGestora = refinedList.get(26);
                String elementoDespesa = refinedList.get(28);
                String valorString = refinedList.get(44);
                valorString = valorString.replace(",", ".");
                double valor = Double.parseDouble(valorString);

                if (Objects.equals(tipoGasto, Constants.LIQUIDACAO)
                        || Objects.equals(tipoGasto, Constants.EMPENHO)
                        || Objects.equals(tipoGasto, Constants.RETENCAO)
                        || Objects.equals(valor, Constants.ZERO_DOUBLE)) {
                    continue;
                }

                Poder poder = definePoder(poderString);
                Ministerio ministerioReceived = generalGeneratorService.findOrCreateMinisterio(ministerio, poder);
                Orgao orgaoReceived = generalGeneratorService.findOrCreateOrgao(orgao, ministerioReceived);
                UnidadeGestora unidadeGestoraReceived = generalGeneratorService.findOrCreateUnidadeGestora(unidadeGestora, orgaoReceived);
                ElementoDespesa elementoDespesaReceived = generalGeneratorService.findOrCreateNewElementoDespesa(elementoDespesa, unidadeGestoraReceived);

                generalGeneratorService.updateTotalValueSpent(ministerioReceived, orgaoReceived, unidadeGestoraReceived, elementoDespesaReceived, valor);
            }
        } catch (IOException e) {
            generalGeneratorService.logExceptionMainFile(e);
        } catch (NumberFormatException e) {
            generalGeneratorService.logNumberFormatException(e);
        }
    }

    private Poder definePoder(String poder) {
        return switch (poder) {
            case Constants.EXECUTIVO -> poderList.getFirst();
            case Constants.LEGISLATIVO -> poderList.get(1);
            case Constants.JUDICIARIO -> poderList.get(2);
            case null, default -> poderList.get(3);
        };
    }
}
