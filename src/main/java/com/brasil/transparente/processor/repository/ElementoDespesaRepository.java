package com.brasil.transparente.processor.repository;

import com.brasil.transparente.processor.entity.ElementoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementoDespesaRepository extends JpaRepository<ElementoDespesa, String> {

    ElementoDespesa findByNameElementoDespesa(String nameElementoDespesa);

    @Query("SELECT SUM(ed.totalValueSpent) FROM ElementoDespesa ed " +
            "JOIN ed.unidadeGestora ug " +
            "JOIN ug.orgao org " +
            "JOIN org.ministerio mini " +
            "WHERE ed.nameElementoDespesa IN :elementoDespesaNameList " +
            "OR org.nameOrgao = :nameOrgao")
    double findByElementoDespesaNameListOrNameOrgao(
            @Param("elementoDespesaNameList") List<String> elementoDespesaNameList,
            @Param("nameOrgao") String nameOrgao
    );

    @Query("SELECT SUM(ed.totalValueSpent) FROM ElementoDespesa ed " +
            "JOIN ed.unidadeGestora ug " +
            "JOIN ug.orgao org " +
            "JOIN org.ministerio mini " +
            "WHERE mini.nameMinisterio = :nameMinisterio " +
            "AND ed.nameElementoDespesa IN :elementoDespesaNameList")
    double findByMinisterioAndElementoDespesaElementoDespesaNameList(
            @Param("nameMinisterio") String nameMinisterio,
            @Param("elementoDespesaNameList") List<String> elementoDespesaNameList
    );

    @Query("SELECT SUM(ed.totalValueSpent) FROM ElementoDespesa ed " +
            "JOIN ed.unidadeGestora ug " +
            "JOIN ug.orgao org " +
            "JOIN org.ministerio mini " +
            "WHERE mini.nameMinisterio = :nameMinisterio " +
            "AND ed.nameElementoDespesa NOT IN :elementoDespesaNameList")
    double findByMinisterioAndNotInElementoDespesaElementoDespesaNameList(
            @Param("nameMinisterio") String nameMinisterio,
            @Param("elementoDespesaNameList") List<String> elementoDespesaNameList
    );

    @Query("SELECT SUM(ed.totalValueSpent) FROM ElementoDespesa ed " +
            "JOIN ed.unidadeGestora ug " +
            "JOIN ug.orgao org " +
            "JOIN org.ministerio mini " +
            "WHERE mini.nameMinisterio = :nameMinisterio " +
            "AND ed.nameElementoDespesa NOT IN :elementoDespesaNameListNot " +
            "AND ed.nameElementoDespesa IN :elementoDespesaNameListIn")
    double findByMinisterioAndNotInElementoDespesaElementoDespesaNameListAndInElementoDespesaNameList(
            @Param("nameMinisterio") String nameMinisterio,
            @Param("elementoDespesaNameListNot") List<String> elementoDespesaNameListNot,
            @Param("elementoDespesaNameListIn") List<String> elementoDespesaNameListIn
    );

    @Query("SELECT SUM(ed.totalValueSpent) FROM ElementoDespesa ed " +
            "JOIN ed.unidadeGestora ug " +
            "JOIN ug.orgao org " +
            "JOIN org.ministerio mini " +
            "JOIN mini.poder pod " +
            "WHERE pod.namePoder = :namePoder " +
            "AND ed.nameElementoDespesa NOT IN :elementoDespesaNameList")
    double findByPoderAndNotInElementoDespesaElementoDespesaNameList(
            @Param("namePoder") String namePoder,
            @Param("elementoDespesaNameList") List<String> elementoDespesaNameList
    );

    @Query("SELECT SUM(ed.totalValueSpent) FROM ElementoDespesa ed " +
            "JOIN ed.unidadeGestora ug " +
            "JOIN ug.orgao org " +
            "JOIN org.ministerio mini " +
            "WHERE mini.nameMinisterio = :nameMinisterio")
    double findByMinisterio(
            @Param("nameMinisterio") String nameMinisterio
    );

}
