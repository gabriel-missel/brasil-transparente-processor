package com.brasil.transparente.processor.service.parser.judiciario;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.service.parser.LineParser;
import com.brasil.transparente.processor.util.Constants;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class StandardJusticeLineParser implements LineParser {
    private static final String PREC_RPV = "RPV";
    protected static final String PRECATORIOS_RPVS = "Precatórios e Requisições de Pequeno Valor";

    @Override
    public Optional<DadosDespesa> parse(String[] rawList) {

        if (rawList.length == 9) {
            List<String> refinedList = convertToList(rawList);
            String orgaoSuperior = refinedList.get(3);
            String unidadeOrcamentaria = refinedList.get(4);
            String unidadeGestora = refinedList.get(5);
            String elementoDespesa = refinedList.get(6);
            String valorString = refinedList.get(8);
            valorString = valorString.replace(",", ".");
            double valor = Double.parseDouble(valorString);

            if (unidadeGestora.contains(PREC_RPV) || Objects.equals(valor, Constants.ZERO_DOUBLE)) {
                return Optional.empty();
            }

            DadosDespesa dadosDespesa = criarDadosDespesa(orgaoSuperior, unidadeOrcamentaria, unidadeGestora, elementoDespesa, valor);
            return Optional.of(dadosDespesa);
        }
        return Optional.empty();
    }

    public abstract DadosDespesa criarDadosDespesa(String orgaoSuperior, String unidadeOrcamentaria, String unidadeGestora, String elementoDespesa, Double valor);
}
