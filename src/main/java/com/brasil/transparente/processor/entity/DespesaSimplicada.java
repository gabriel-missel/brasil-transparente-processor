package com.brasil.transparente.processor.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "despesa_simplificada")
public class DespesaSimplicada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long despesaSimplificadaId;
    private String despesaSimplificadaName;
    private double despesaSimplificadaTotalValue;
    private double despesaSimplificadaPercentageOfTotal;

    public DespesaSimplicada(String despesaSimplificadaName, double despesaSimplificadaTotalValue, double despesaSimplificadaPercentageOfTotal) {
        this.despesaSimplificadaName = despesaSimplificadaName;
        this.despesaSimplificadaTotalValue = despesaSimplificadaTotalValue;
        this.despesaSimplificadaPercentageOfTotal = despesaSimplificadaPercentageOfTotal;
    }

    public DespesaSimplicada() {
    }

}
