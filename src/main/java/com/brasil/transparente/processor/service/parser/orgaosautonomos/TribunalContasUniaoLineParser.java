package com.brasil.transparente.processor.service.parser.orgaosautonomos;

import com.brasil.transparente.processor.entity.DadosDespesa;
import com.brasil.transparente.processor.service.parser.LineParser;
import com.brasil.transparente.processor.util.Constants;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TribunalContasUniaoLineParser implements LineParser {
    private static final String TRIBUNAL_CONTAS_UNIAO = "Tribunal de Contas da União";

    @Override
    public Optional<DadosDespesa> parse(String[] rawList) {
        if (rawList.length == 14) {
            List<String> refinedList = convertToList(rawList);
            String unidadeGestora = refinedList.get(1);
            String valorString = refinedList.get(5);
            String elementoDespesa = refinedList.get(12);

            if (Objects.equals(valorString, "-")) {
                return Optional.empty();
            }

            valorString = valorString.replace(".", "");
            valorString = valorString.replace(",", ".");
            valorString = valorString.replace("R$", "");
            double valorPago = Double.parseDouble(valorString);

            if (Objects.equals(valorPago, Constants.ZERO_DOUBLE)) {
                return Optional.empty();
            }

            return Optional.of(new DadosDespesa(
                    TRIBUNAL_CONTAS_UNIAO,
                    TRIBUNAL_CONTAS_UNIAO,
                    unidadeGestora,
                    elementoDespesa,
                    valorPago
            ));
        }
        return Optional.empty();
    }
}
