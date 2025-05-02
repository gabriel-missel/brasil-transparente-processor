package com.brasil.transparente.processor.service.parser.legislativo;

import com.brasil.transparente.processor.entity.*;
import com.brasil.transparente.processor.service.parser.LineParser;
import com.brasil.transparente.processor.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class CamaraDeputadosLineParser implements LineParser {
    private static final String CAMARA_DEPUTADOS = "Câmara dos Deputados";

    @Override
    public Optional<DadosDespesa> parse(String[] rawList) {
        if (rawList.length == 2) {
            List<String> refinedList = convertToList(rawList);
            String elementoDespesa = refinedList.get(0);
            String valorString = refinedList.get(1);
            valorString = valorString.replace(",", "");
            double valor = Double.parseDouble(valorString);

            if (Objects.equals(valor, Constants.ZERO_DOUBLE)) {
                return Optional.empty();
            }

            return Optional.of(new DadosDespesa(
                    CAMARA_DEPUTADOS,
                    CAMARA_DEPUTADOS,
                    CAMARA_DEPUTADOS,
                    elementoDespesa,
                    valor
            ));
        }
        return Optional.empty();
    }
}
