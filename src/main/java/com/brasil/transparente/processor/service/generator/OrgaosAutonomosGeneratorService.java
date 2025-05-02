package com.brasil.transparente.processor.service.generator;

import com.brasil.transparente.processor.entity.Poder;
import com.brasil.transparente.processor.service.CsvReaderService;
import com.brasil.transparente.processor.service.parser.orgaosautonomos.DefensoriaPublicaUniaoLineParser;
import com.brasil.transparente.processor.service.parser.orgaosautonomos.MinisterioPublicoUniaoLineParser;
import com.brasil.transparente.processor.service.parser.orgaosautonomos.TribunalContasUniaoLineParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.file.Paths;

@Slf4j
@Service
public class OrgaosAutonomosGeneratorService implements Generator {
    @Value("${CSV_PATH}")
    private String csvPath;

    private final TribunalContasUniaoLineParser tribunalContasUniaoLineParser;
    private final DefensoriaPublicaUniaoLineParser defensoriaPublicaUniaoLineParser;
    private final MinisterioPublicoUniaoLineParser ministerioPublicoUniaoLineParser;
    private final CsvReaderService csvReaderService;

    private final String delimiter = ";";
    private static final String ORGAOS_AUTONOMOS = "Órgãos Autônomos";
    private static final String TRIBUNAL_CONTAS_UNIAO = "Tribunal de Contas da União";
    private static final String MINISTERIO_PUBLICO_FEDERAL = "Ministério Público Federal";
    private static final String MINISTERIO_PUBLICO_TRABALHO = "Ministério Público do Trabalho";
    private static final String MINISTERIO_PUBLICO_MILITAR = "Ministério Público Militar";
    private static final String MINISTERIO_PUBLICO_DF_TERRITORIOS = "Ministério Público do Distrito Federal e Territórios";
    private static final String ESCOLA_SUPERIOR_MINISTERIO_PUBLICO_UNIAO = "Escola Superior do Ministério Público da União";
    private final Poder poder = new Poder(ORGAOS_AUTONOMOS);

    @Autowired
    public OrgaosAutonomosGeneratorService(TribunalContasUniaoLineParser tribunalContasUniaoLineParser,
                                           DefensoriaPublicaUniaoLineParser defensoriaPublicaUniaoLineParser,
                                           MinisterioPublicoUniaoLineParser ministerioPublicoUniaoLineParser,
                                           CsvReaderService csvReaderService) {
        this.tribunalContasUniaoLineParser = tribunalContasUniaoLineParser;
        this.defensoriaPublicaUniaoLineParser = defensoriaPublicaUniaoLineParser;
        this.ministerioPublicoUniaoLineParser = ministerioPublicoUniaoLineParser;
        this.csvReaderService = csvReaderService;
    }
    @Override
    public Poder generate(String year) {
        log.info("Orgãos Autônomos - Iniciando");
        log.info("Lendo Defensoria Publica da Uniao e criando estrutura de dados");
        generateDefensoriaPublicaUniao();

        log.info("{} - Lendo arquivos de despesas e criando estrutura de despesa.", TRIBUNAL_CONTAS_UNIAO);
        generateTribunalContasUniao();

        log.info("Lendo arquivos do Ministério Público e criando estrutura de dados");
        generateMinisterioPublico(MINISTERIO_PUBLICO_FEDERAL);
        generateMinisterioPublico(MINISTERIO_PUBLICO_TRABALHO);
        generateMinisterioPublico(MINISTERIO_PUBLICO_MILITAR);
        generateMinisterioPublico(MINISTERIO_PUBLICO_DF_TERRITORIOS);
        generateMinisterioPublico(ESCOLA_SUPERIOR_MINISTERIO_PUBLICO_UNIAO);
        log.info("Orgãos Autônomos - Finalizado");
        return poder;
    }

    private void generateDefensoriaPublicaUniao() {
        String defensoriaPublicaUniaoFilePath = Paths.get(csvPath, "/Orgaos Autonomos/Defensoria Publica da Uniao/2024.csv").toString();
        csvReaderService.processCsv(defensoriaPublicaUniaoFilePath, delimiter, defensoriaPublicaUniaoLineParser, poder);
    }

    private void generateTribunalContasUniao() {
        String tribunalContasUniaoFilePath = Paths.get(csvPath, "/Orgaos Autonomos/Tribunal de Contas da Uniao/despesas").toString();
        csvReaderService.processMonthlyFiles(tribunalContasUniaoFilePath, "2024", delimiter, tribunalContasUniaoLineParser, poder);
    }

    private void generateMinisterioPublico(String nameOrgao) {
        log.info("Lendo {} e criando estrutura de dados", nameOrgao);
        String filePath = Paths.get(csvPath, "/Orgaos Autonomos/Ministerio Publico/" + nameOrgao + "/2024.csv").toString();
        csvReaderService.processCsv(filePath, delimiter, ministerioPublicoUniaoLineParser, poder);
    }
}