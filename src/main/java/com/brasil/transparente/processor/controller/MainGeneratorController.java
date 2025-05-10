package com.brasil.transparente.processor.controller;

import com.brasil.transparente.processor.service.EstadoGeneratorService;
import com.brasil.transparente.processor.service.MainGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainGeneratorController {

    @Autowired
    private MainGeneratorService mainGeneratorService;
    @Autowired
    private EstadoGeneratorService estadoGeneratorService;

    @PostMapping("/processYear")
    public String processYearAndSaveOnDatabase(@RequestParam String year) {
        mainGeneratorService.generateCompleteReportService(year);
        return "[SAVED ON DATABASE]";
    }
}
