package com.brasil.transparente.processor.service.parser;

import com.brasil.transparente.processor.entity.DadosDespesa;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface LineParser {
    Optional<DadosDespesa> parse(String[] rawList);
    default List<String> convertToList(String[] rawList) {
        List<String> refinedList = new ArrayList<>();
        for (String column : rawList) {
            refinedList.add(column.replace("\"", "").trim());
        }
        return refinedList;
    }
}
