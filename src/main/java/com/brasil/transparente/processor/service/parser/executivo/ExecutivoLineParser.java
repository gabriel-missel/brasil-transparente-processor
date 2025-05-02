package com.brasil.transparente.processor.service.parser.executivo;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.service.parser.LineParser;
import com.brasil.transparente.processor.util.Constants;
import com.brasil.transparente.processor.util.Currency2024Constants;
import com.brasil.transparente.processor.util.EmbaixadasConstants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ExecutivoLineParser implements LineParser {

    @Override
    public Optional<DadosDespesa> parse(String[] rawList) {
        if (rawList.length == 47) {
            List<String> refinedList = convertToList(rawList);

            String nameMinisterio = refinedList.get(2);
            String nameOrgao = refinedList.get(4);
            String nameUnidadeGestora = refinedList.get(6);
            String nameUnidadeOrcamentaria = refinedList.get(10);
            String nameGrupoDeDespesa = refinedList.get(36);
            String nameElementoDespesa = refinedList.get(38);
            String valorPagoString = refinedList.get(43).replace(",", ".");
            String valorRestosAPagarString = refinedList.get(46).replace(",", ".");

            double valorPago = Double.parseDouble(valorPagoString) + Double.parseDouble(valorRestosAPagarString);

            if (Objects.equals(valorPago, Constants.ZERO_DOUBLE)
                    || Objects.equals(nameElementoDespesa, Constants.REPASSES)
                    || Objects.equals(nameGrupoDeDespesa, Constants.AMORTIZACAO_DIVIDA)) {
                return Optional.empty();
            }

            if (Objects.equals(nameMinisterio, Constants.SEM_INFORMACAO)) {
                nameMinisterio = replaceMinisteroName(nameUnidadeOrcamentaria);
                nameOrgao = Constants.SEM_INFORMACAO;
                nameUnidadeGestora = Constants.SEM_INFORMACAO;
            }

            if (Objects.equals(nameMinisterio, EmbaixadasConstants.MINISTERIO_RELACOES_EXTERIORES_ORIGINAL)) {
                valorPago = Currency2024Constants.convertCurrency(nameUnidadeGestora, valorPago);
                nameUnidadeGestora = EmbaixadasConstants.mergeEmbassyNames(nameUnidadeGestora);
            }

            DadosDespesa dadosDespesa = new DadosDespesa(nameMinisterio, nameOrgao, nameUnidadeGestora, nameElementoDespesa, valorPago);
            return Optional.of(dadosDespesa);
        }
        return Optional.empty();
    }

    private String replaceMinisteroName(String nameMinisterio) {
        return switch (nameMinisterio) {
            case EmbaixadasConstants.MINISTERIO_AGRICULTURA_CAPS -> EmbaixadasConstants.MINISTERIO_AGRICULTURA_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_TRABALHO_CAPS -> EmbaixadasConstants.MINISTERIO_TRABALHO_ORIGINAL;
            case EmbaixadasConstants.SECRETARIA_EMPREENDEDOR_CAPS -> EmbaixadasConstants.SECRETARIA_EMPREENDEDOR_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_ESPORTE_CAPS -> EmbaixadasConstants.MINISTERIO_ESPORTE_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_GESTAO_CAPS -> EmbaixadasConstants.MINISTERIO_GESTAO_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_ASSISTENCIA_SOCIAL_CAPS -> EmbaixadasConstants.MINISTERIO_ASSISTENCIA_SOCIAL_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_INDUSTRIA_CAPS -> EmbaixadasConstants.MINISTERIO_INDUSTRIA_ORIGINAL;
            case EmbaixadasConstants.PRESIDENCIA_REPUBLICA_CAPS -> EmbaixadasConstants.PRESIDENCIA_REPUBLICA_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_DESENV_AGRARIO_CAPS -> EmbaixadasConstants.MINISTERIO_DESENV_AGRARIO_ORIGINAL;
            case EmbaixadasConstants.MINISTERIO_EXTERIORES_CAPS -> EmbaixadasConstants.MINISTERIO_RELACOES_EXTERIORES_ORIGINAL;
            default -> nameMinisterio;
        };
    }
}
