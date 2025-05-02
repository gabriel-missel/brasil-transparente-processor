package com.brasil.transparente.processor.service.parser.judiciario;

import com.brasil.transparente.processor.entity.DadosDespesa;
import org.springframework.stereotype.Service;

@Service
public class ExecutivoStfLineParser extends BaseStfLineParser {

    @Override
    DadosDespesa criarDadosDespesa(Double valor, String planoOrcamentario) {
        return new DadosDespesa(
                PRECATORIOS_RPVS,
                SUPREMO_TRIBUNAL_FEDERAL,
                SUPREMO_TRIBUNAL_FEDERAL,
                planoOrcamentario,
                valor
        );
    }

}
