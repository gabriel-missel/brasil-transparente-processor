package com.brasil.transparente.processor.repository;

import com.brasil.transparente.processor.entity.DespesaSimplicada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespesaSimplificadaRepository extends JpaRepository<DespesaSimplicada, String> {

}
