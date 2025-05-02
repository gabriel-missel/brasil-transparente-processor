package com.brasil.transparente.processor.service.parser.judiciario;

import com.brasil.transparente.processor.entity.DadosDespesa;
import org.springframework.stereotype.Service;

@Service
public class ExecutivoStandardJusticeLineParser extends StandardJusticeLineParser {
    @Override
    public DadosDespesa criarDadosDespesa(String orgaoSuperior, String unidadeOrcamentaria, String unidadeGestora, String elementoDespesa, Double valor) {
        return new DadosDespesa(
                PRECATORIOS_RPVS,
                unidadeOrcamentaria,
                unidadeGestora,
                elementoDespesa,
                valor
        );
    }
}
