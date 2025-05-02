package com.brasil.transparente.processor.service.parser.orgaosautonomos;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.service.parser.LineParser;
import com.brasil.transparente.processor.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class DefensoriaPublicaUniaoLineParser implements LineParser {
    private static final String DEFENSORIA_PUBLICA_UNIAO = "Defensoria Pública da União";

    @Override
    public Optional<DadosDespesa> parse(String[] rawList) {
        if (rawList.length == 2) {
            List<String> refinedList = convertToList(rawList);
            String elementoDespesa = refinedList.get(0);
            String valorString = refinedList.get(1);
            double valor = Double.parseDouble(valorString);

            if (Objects.equals(valor, Constants.ZERO_DOUBLE)) {
                return Optional.empty();
            }

            return Optional.of(new DadosDespesa(
                    DEFENSORIA_PUBLICA_UNIAO,
                    DEFENSORIA_PUBLICA_UNIAO,
                    DEFENSORIA_PUBLICA_UNIAO,
                    elementoDespesa,
                    valor
            ));
        }
        return Optional.empty();
    }
}
