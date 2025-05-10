package com.brasil.transparente.processor.repository;

import com.brasil.transparente.processor.entity.DespesaSimplificada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaSimplificadaRepository extends JpaRepository<DespesaSimplificada, String> {

    @Query("SELECT SUM(ds.totalValue) FROM DespesaSimplificada ds " +
            "WHERE ds.unidadeFederativaId = :unidadeFederativaId")
    double sumTotalValueByUnidadeFederativa(
            @Param("unidadeFederativaId") Long unidadeFederativaId
    );


}
