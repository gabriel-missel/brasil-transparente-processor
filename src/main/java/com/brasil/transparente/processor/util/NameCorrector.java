package com.brasil.transparente.processor.util;

import com.brasil.transparente.processor.entity.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class NameCorrector {

    private final Map<String, String> corrections;

    public NameCorrector(ResourceLoader resourceLoader) {
        ObjectMapper mapper = new ObjectMapper();
        Resource resource = resourceLoader.getResource("classpath:name-correction.json");
        try (Reader reader = new InputStreamReader(
                resource.getInputStream(), StandardCharsets.ISO_8859_1)) {
            corrections = mapper.readValue(reader, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new UncheckedIOException("Erro ao carregar correções de ministérios", e);
        }
    }

    public void refactorNames(List<Poder> poderList) {
        log.info("Refatorando nomes");
        for (Poder poder : poderList) {
            for (Ministerio ministerio : poder.getListMinisterio()) {
                correctMinisterioNames(ministerio);
                for (Orgao orgao : ministerio.getListOrgao()) {
                    correctOrgaoNames(orgao);
                    for (UnidadeGestora unidadeGestora : orgao.getListUnidadeGestora()) {
                        correctUnidadeGestoraNames(unidadeGestora);
                        for (ElementoDespesa elementoDespesa : unidadeGestora.getListElementoDespesa()) {
                            correctElementDespesaNames(elementoDespesa);
                        }
                    }
                }
            }
        }
    }

    public void correctMinisterioNames(Ministerio ministerio) {
        String original = ministerio.getNameMinisterio();
        String corrected = corrections.getOrDefault(original, original);
        ministerio.setNameMinisterio(corrected);
    }

    public void correctOrgaoNames(Orgao orgao) {
        String original = orgao.getNameOrgao();
        String corrected = corrections.getOrDefault(original, original);
        orgao.setNameOrgao(corrected);
    }

    public void correctUnidadeGestoraNames(UnidadeGestora unidadeGestora) {
        String original = unidadeGestora.getNameUnidadeGestora();
        String corrected = corrections.getOrDefault(original, original);
        unidadeGestora.setNameUnidadeGestora(corrected);
    }

    public void correctElementDespesaNames(ElementoDespesa elementoDespesa) {
        String original = elementoDespesa.getNameElementoDespesa();
        String corrected = corrections.getOrDefault(original, original);
        elementoDespesa.setNameElementoDespesa(corrected);
    }

}
