package com.brasil.transparente.processor.service.parser.judiciario;

import com.brasil.transparente.processor.entity.DadosDespesa;
import com.brasil.transparente.processor.service.parser.LineParser;
import com.brasil.transparente.processor.util.Constants;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

public abstract class BaseStfLineParser implements LineParser {
    protected static final String SUPREMO_TRIBUNAL_FEDERAL = "Supremo Tribunal Federal";
    protected static final String SENTENCAS_JUDICIAIS = "Sentenças Judiciais";
    protected static final String PRECATORIOS_RPVS = "Precatórios e Requisições de Pequeno Valor";

    @Override
    public Optional<DadosDespesa> parse(String[] rawList) {
        if (rawList.length == 8) {
            List<String> refinedList = convertToList(rawList);
            String planoOrcamentario = refinedList.get(4);
            String valorString = refinedList.get(7);
            valorString = valorString.replace("R$", "");
            double valor = Double.parseDouble(valorString);

            if (Objects.equals(planoOrcamentario, SENTENCAS_JUDICIAIS) || Objects.equals(valor, Constants.ZERO_DOUBLE)) {
                return Optional.empty();
            }

            DadosDespesa dadosDespesa = criarDadosDespesa(valor, planoOrcamentario);
            return Optional.of(dadosDespesa);
        }
        return Optional.empty();
    }

    abstract DadosDespesa criarDadosDespesa(Double valor, String planoOrcamentario);
}
