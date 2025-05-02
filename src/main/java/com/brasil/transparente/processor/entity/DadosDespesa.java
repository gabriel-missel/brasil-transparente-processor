package com.brasil.transparente.processor.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DadosDespesa {

    public DadosDespesa(String ministerio, String elementoDespesa, Double valor) {
        this.ministerio = ministerio;
        this.elementoDespesa = elementoDespesa;
        this.valor = valor;
    }

    private String ministerio;
    private String orgao;
    private String unidadeGestora;
    private String elementoDespesa;
    private Double valor;
}
