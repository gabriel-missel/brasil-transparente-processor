package com.brasil.transparente.processor.service;

import com.brasil.transparente.processor.entity.DespesaSimplicada;
import com.brasil.transparente.processor.entity.ElementoDespesa;
import com.brasil.transparente.processor.repository.*;
import com.brasil.transparente.processor.util.SimplifiedConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SimplifiedGeneratorService {

    @Autowired
    private MinisterioRepository ministerioRepository;
    @Autowired
    private OrgaoRepository orgaoRepository;
    @Autowired
    private UnidadeGestoraRepository unidadeGestoraRepository;
    @Autowired
    private ElementoDespesaRepository elementoDespesaRepository;
    @Autowired
    private UnidadeFederativaRepository unidadeFederativaRepository;
    @Autowired
    private DespesaSimplificadaRepository despesaSimplificadaRepository;
    private double allMoneySpent;

    public void generateSimplifiedReport() {
        log.info("Gerando estrutura simplificada");
        allMoneySpent = unidadeFederativaRepository.findAll().getFirst().getTotalValueSpent();
        calculateAndSave1();
        calculateAndSave2();
        calculateAndSave3();
        calculateAndSave4();
        calculateAndSave5();
        calculateAndSave6();
        calculateAndSave7();
        calculateAndSave8();
        calculateAndSave9();
        calculateAndSaveOutros();
    }

    private void calculateAndSave1() {
        double totalValueSpent = elementoDespesaRepository.findByElementoDespesaNameListOrNameOrgao
                (SimplifiedConstants.DESPESAS_APOSENTADORIAS,
                        SimplifiedConstants.FRGPS);
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.APOSENTADORIAS_PENSOES, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave2() {
        double totalValueSpent = elementoDespesaRepository.findByMinisterioAndElementoDespesaElementoDespesaNameList(
                SimplifiedConstants.MINISTERIO_FAZENDA,
                SimplifiedConstants.DESPESAS_JUROS_DIVIDA_PUBLICA
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.JUROS_DIVIDA_PUBLICA, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave3() {
        double totalValueSpent = elementoDespesaRepository.findByMinisterioAndNotInElementoDespesaElementoDespesaNameList(
                SimplifiedConstants.MINISTERIO_SAUDE,
                SimplifiedConstants.DESPESAS_APOSENTADORIAS
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.SAUDE, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave4() {
        double totalValueSpent = elementoDespesaRepository.findByMinisterioAndNotInElementoDespesaElementoDespesaNameListAndInElementoDespesaNameList(
                SimplifiedConstants.MINISTERIO_ASSISTENCIA_SOCIAL,
                SimplifiedConstants.DESPESAS_APOSENTADORIAS,
                SimplifiedConstants.AUXILIOS
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.TRANSFERENCIA_RENDA, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave5() {
        double totalValueSpent = elementoDespesaRepository.findByMinisterioAndNotInElementoDespesaElementoDespesaNameList(
                SimplifiedConstants.MINISTERIO_EDUCACAO,
                SimplifiedConstants.DESPESAS_APOSENTADORIAS
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.EDUCACAO, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave6() {
        double totalValueSpent = elementoDespesaRepository.findByMinisterio(
                SimplifiedConstants.PRECATORIOS_RPVS
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.PRECATORIOS_RPVS, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave7() {
        double totalValueSpent = elementoDespesaRepository.findByMinisterioAndNotInElementoDespesaElementoDespesaNameList(
                SimplifiedConstants.MINISTERIO_DEFESA,
                SimplifiedConstants.DESPESAS_APOSENTADORIAS
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.DEFESA, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave8() {
        ElementoDespesa elementoDespesa = elementoDespesaRepository.findByNameElementoDespesa(SimplifiedConstants.SEGURO_DESEMPREGO_ABONO_SALARIAL);
        double percentageOfTotal = getPercentageOfTotal(elementoDespesa.getTotalValueSpent());
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.BENEFICIOS_TRABALHISTAS, elementoDespesa.getTotalValueSpent(), percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSave9() {
        double totalValueSpent = elementoDespesaRepository.findByPoderAndNotInElementoDespesaElementoDespesaNameList(
                SimplifiedConstants.PODER_JUDICIARIO,
                SimplifiedConstants.DESPESAS_APOSENTADORIAS
        );
        double percentageOfTotal = getPercentageOfTotal(totalValueSpent);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.PODER_JUDICIARIO_FEDERAL, totalValueSpent, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private void calculateAndSaveOutros() {
        List<DespesaSimplicada> despesaSimplicadaList = despesaSimplificadaRepository.findAll();
        double gastosSimplificado = 0;
        for (DespesaSimplicada despesaSimplicada : despesaSimplicadaList) {
            gastosSimplificado += despesaSimplicada.getDespesaSimplificadaTotalValue();
        }
        double sobragastos = allMoneySpent - gastosSimplificado;
        double percentageOfTotal = getPercentageOfTotal(sobragastos);
        DespesaSimplicada despesaSimplificada = new DespesaSimplicada(SimplifiedConstants.OUTROS, sobragastos, percentageOfTotal);
        despesaSimplificadaRepository.save(despesaSimplificada);
    }

    private double getPercentageOfTotal(double totalValueSpent) {
        return (totalValueSpent/allMoneySpent)*100;
    }

}
