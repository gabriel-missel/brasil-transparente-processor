package com.brasil.transparente.processor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "despesa_simplificada")
public class DespesaSimplificada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long despesaSimplificadaId;
    private String name;
    private double totalValue;
    private double percentageOfTotal;
    private Long unidadeFederativaId;

    public DespesaSimplificada(String name, double totalValue, double percentageOfTotal, Long unidadeFederativaId) {
        this.name = name;
        this.totalValue = totalValue;
        this.percentageOfTotal = percentageOfTotal;
        this.unidadeFederativaId = unidadeFederativaId;
    }

    public DespesaSimplificada() {
    }

}
