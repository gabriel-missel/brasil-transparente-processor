package com.brasil.transparente.processor.service;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.util.constants.Constants;
import com.brasil.transparente.processor.util.NameCorrector;
import com.brasil.transparente.processor.util.constants.UnidadesFederativasConstants;
import com.brasil.transparente.processor.util.constants.estados.RSConstants;
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
    @Autowired
    private NameCorrector nameCorrector;
    @Autowired
    private DespesaSimplificadaGeneratorService despesaSimplificadaGeneratorService;
    @Value("${CSV_PATH}")
    private String csvPath;
    private final List<Poder> poderList = new ArrayList<>(Arrays.asList(
            new Poder("Poder Executivo"),
            new Poder("Poder Legislativo"),
            new Poder("Poder Judiciário"),
            new Poder("Órgãos Autônomos")
    ));

    public void generateStateExpenses(String year, String state) {
        UnidadeFederativa unidadeFederativa = new UnidadeFederativa(UnidadesFederativasConstants.RS, 22L);
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

        unidadeFederativa.setListPoder(poderList);
        for (Poder poder : poderList) {
            generalGeneratorService.aggregateAllPowerSpending(poder);
            generalGeneratorService.setRelationships(unidadeFederativa);
        }
        double gastoTotalValue = generalGeneratorService.aggregateTotalExpense(unidadeFederativa);
        generalGeneratorService.removeNegativeOrZeroExpenses(unidadeFederativa.getListPoder());
        generalGeneratorService.setTotalPercentages(unidadeFederativa.getListPoder(), gastoTotalValue);
        nameCorrector.refactorNames(unidadeFederativa.getListPoder());
        generalGeneratorService.saveStructure(unidadeFederativa);
        despesaSimplificadaGeneratorService.generateSimplifiedReportRS();
        log.info("Rio Grande do Sul - Finalizado");
    }

    private void createStateExpanseStructure(String filePath, String delimiter, int month, String state) {
        log.info("{} - Lendo arquivos e criando estrutura de despesas. Mês = {}", state, month);
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.ISO_8859_1))) {
            br.readLine();
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
                String unidadeGestora = refinedList.get(18);
                String elementoDespesa = refinedList.get(26);
                String valorString = refinedList.get(44);
                valorString = valorString.replace(",", ".");
                double valor = Double.parseDouble(valorString);

                if (Objects.equals(tipoGasto, Constants.LIQUIDACAO)
                        || Objects.equals(tipoGasto, Constants.EMPENHO)
                        || Objects.equals(tipoGasto, Constants.RETENCAO)
                        || Objects.equals(valor, Constants.ZERO_DOUBLE)) {
                    continue;
                }

                String ministerioRevisado = resolveMinisterio(ministerio);
                if (Objects.nonNull(ministerioRevisado)) {
                    orgao = ministerio;
                    ministerio = ministerioRevisado;
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

    private String resolveMinisterio(String ministerio) {
        return switch (ministerio) {
            case RSConstants.INSTITUTO_RIOGRANDENSE_ARROZ -> RSConstants.SECRETARIA_AGRICULTURA;
            case RSConstants.UERGS, RSConstants.FUNDACAO_ESCOLA_LIBERATO, RSConstants.CONSELHO_EDUCACAO -> RSConstants.SECRETARIA_EDUCACAO;
            case RSConstants.FUNDACAO_AMPARO_PESQUISA -> RSConstants.SECRETARIA_INOVACAO;
            case RSConstants.FUNDACAO_PROTECAO_AMBIENTAL_ROESSLER -> RSConstants.SECRETARIA_MEIO_AMBIENTE;
            case RSConstants.ESCRITORIO_DESENVOLVIMENTO_PROJETOS,
                 RSConstants.FUNDACAO_PLANEJAMENTO_METROPOLITANO_REGIONAL -> RSConstants.SECRETARIA_PLANEJAMENTO;
            case RSConstants.FUDACAO_ATENDIMENTO_SOCIO_EDUCATIVO, RSConstants.FUNDACAO_PROTECAO_ESPECIAL,
                 RSConstants.FUNDACAO_GAUCHA_TRABALHO_ACAO_SOCIAL, RSConstants.FUNDACAO_PPD_PPAH ->
                    RSConstants.SECRETARIA_DESENVOLVIMENTO_SOCIAL;
            case RSConstants.FUNDACAO_ORQUESTRA, RSConstants.FUNDACAO_TEATRO -> RSConstants.SECRETARIA_CULTURA;
            case RSConstants.DEPARTAMENTO_ESTADUAL_TRANSITO -> RSConstants.SECRETARIA_SEGURANCA_PUBLICA;
            case RSConstants.DEPARTAMENTO_ESTRADAS_RODAGEM -> RSConstants.SECRETARIA_LOGISTICA_TRANSPORTES;
            case RSConstants.JUNTA_COMERCIAL -> RSConstants.SECRETARIA_DESENVOLVIMENTO_ECONOMICO;
            case RSConstants.AGENCIA_DELEGADOS -> RSConstants.SECRETARIA_PARCERIAS_CONCESSOES;
            case RSConstants.INSTITUTO_PREVIDENCIA, RSConstants.INSTITUTO_ASSISTENCIA_SAUDE_SERVIDORES, RSConstants.ENCARGOS_FINANCEIROS ->
                    RSConstants.SECRETARIA_FAZENDA;
            default -> ministerio;
        };
    }
}
