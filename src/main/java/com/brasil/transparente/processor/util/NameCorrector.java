package com.brasil.transparente.processor.util;

import com.brasil.transparente.processor.entity.*;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@NoArgsConstructor
public class NameCorrector {

    public void refactorNames(List<Poder> poderList) {
        log.info("Refatorando nomes");
        for (Poder poder : poderList) {
            for (Ministerio ministerio : poder.getListMinisterio()) {
                correctMinisterioNames(ministerio);
                for (Orgao orgao : ministerio.getListOrgao()) {
                    correctOrgaoNames(orgao);
                    for (UnidadeGestora unidadeGestora : orgao.getListUnidadeGestora()) {
                        correctUnidadeGestoraNames1(unidadeGestora);
                        correctUnidadeGestoraNames2(unidadeGestora);
                        correctUnidadeGestoraNames3(unidadeGestora);
                        correctUnidadeGestoraNames4(unidadeGestora);
                        for (ElementoDespesa elementoDespesa : unidadeGestora.getListElementoDespesa()) {
                            correctElementDespesaNames(elementoDespesa);
                        }
                    }
                }
            }
        }
    }

    private void correctMinisterioNames(Ministerio ministerio) {
        String updatedName = switch (ministerio.getNameMinisterio()) {
            case "Ministério do Desenvolvimento e Assistência" ->
                    "Ministério do Desenvolvimento e Assistência Social, Família e Combate à Fome";
            case "Ministério da Integração e do Desenvolvime" ->
                    "Ministério da Integração e do Desenvolvimento Regional";
            case "Ministério da Gestão e da Inovação em Ser" ->
                    "Ministério da Gestão e da Inovação em Serviços Públicos";
            case "Ministério da Ciência. Tecnologia e Inovaç", "Ministério da Ciência, Tecnologia e Inovaç" ->
                    "Ministério da Ciência, Tecnologia e Inovação";
            case "Ministério do Desenvolvimento. Indústria, C", "Ministério do Desenvolvimento, Indústria, C" ->
                    "Ministério do Desenvolvimento, Indústria, Comércio e Serviços";
            case "Ministério do Meio Ambiente e Mudança do Cl" -> "Ministério do Meio Ambiente e Mudança do Clima";
            case "Ministério do Desenvolvimento Agrário e Agr" -> "Ministério do Desenvolvimento Agrário e Agricultura";
            case "Banco Central do Brasil - Orçamento Fiscal e" ->
                    "Banco Central do Brasil - Orçamento Fiscal e de Investimentos";
            case "JUSTICA DO TRABALHO" -> "Justiça do Trabalho";
            case "JUSTICA FEDERAL" -> "Justiça Federal";
            case "JUSTICA ELEITORAL" -> "Justiça Eleitoral";
            case "JUSTICA DO DISTRITO FEDERAL E DOS TERRITORIOS" -> "Justiça do Distrito Federal e dos Territorios";
            case "SUPERIOR TRIBUNAL DE JUSTICA" -> "Superior Tribunal de Justiça";
            case "CONSELHO NACIONAL DE JUSTICA" -> "Conselho Nacional de Justiça";
            case "JUSTICA MILITAR" -> "Justiça Militar";
            default -> ministerio.getNameMinisterio();
        };
        ministerio.setNameMinisterio(updatedName);
    }

    private void correctOrgaoNames(Orgao orgao) {
        String updatedName = switch (orgao.getNameOrgao()) {
            case "Constituição ou Aumento de Capital de Empre" -> "Constituição ou Aumento de Capital de Empresas";
            case "Ministério do Desenvolvimento e Assistência Social. Família e Combate à Fome - Unidades com vín" ->
                    "Ministério do Desenvolvimento e Assistência Social. Família e Combate à Fome - Unidades com vínculo direto";
            case "TRIBUNAL REGIONAL FEDERAL DA 1A. REGIAO" -> "Tribunal Regional Federal da 1ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 4A. REGIAO" -> "Tribunal Regional Federal da 4ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 5A. REGIAO" -> "Tribunal Regional Federal da 5ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 3A. REGIAO" -> "Tribunal Regional Federal da 3ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 2A. REGIAO" -> "Tribunal Regional Federal da 2ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 6A. REGIAO" -> "Tribunal Regional Federal da 6ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 2A. REGIAO" -> "Tribunal Regional do Trabalho da 2ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 1A. REGIAO" -> "Tribunal Regional do Trabalho da 1ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 4A. REGIAO" -> "Tribunal Regional do Trabalho da 4ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 15A. REGIAO" -> "Tribunal Regional do Trabalho da 15ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 3A. REGIAO" -> "Tribunal Regional do Trabalho da 3ª Região";
            case "TRIBUNAL SUPERIOR DO TRABALHO" -> "Tribunal Superior do Trabalho";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 9A. REGIAO" -> "Tribunal Regional do Trabalho da 9ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 5A. REGIAO" -> "Tribunal Regional do Trabalho da 5ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 12A. REGIAO" -> "Tribunal Regional do Trabalho da 12ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 6A. REGIAO" -> "Tribunal Regional do Trabalho da 6ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 10A. REGIAO" -> "Tribunal Regional do Trabalho da 10ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 7A. REGIAO" -> "Tribunal Regional do Trabalho da 7ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 8A. REGIAO" -> "Tribunal Regional do Trabalho da 8ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 13A. REGIAO" -> "Tribunal Regional do Trabalho da 13ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 18A. REGIAO" -> "Tribunal Regional do Trabalho da 18ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 11A. REGIAO" -> "Tribunal Regional do Trabalho da 11ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 23A. REGIAO" -> "Tribunal Regional do Trabalho da 23ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 21A. REGIAO" -> "Tribunal Regional do Trabalho da 21ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 17A. REGIAO" -> "Tribunal Regional do Trabalho da 17ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 14A. REGIAO" -> "Tribunal Regional do Trabalho da 14ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 19A. REGIAO" -> "Tribunal Regional do Trabalho da 19ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 16A. REGIAO" -> "Tribunal Regional do Trabalho da 16ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 24A. REGIAO" -> "Tribunal Regional do Trabalho da 24ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 20A. REGIAO" -> "Tribunal Regional do Trabalho da 20ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 22A. REGIAO" -> "Tribunal Regional do Trabalho da 22ª Região";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU" -> "Justiça Federal de Primeiro Grau";
            case "FUNDO PARTIDARIO" -> "Fundo Partidário";
            case "TRIBUNAL REGIONAL ELEITORAL DE SAO PAULO" -> "Tribunal Regional Eleitoral de São Paulo";
            case "TRIBUNAL SUPERIOR ELEITORAL" -> "Tribunal Superior Eleitoral";
            case "TRIBUNAL REGIONAL ELEITORAL DE MINAS GERAIS" -> "Tribunal Regional Eleitoral de Minas Gerais";
            case "TRIBUNAL REGIONAL ELEITORAL DO RIO DE JANEIRO" -> "Tribunal Regional Eleitoral do Rio de Janeiro";
            case "TRIBUNAL REGIONAL ELEITORAL DA BAHIA" -> "Tribunal Regional Eleitoral da Bahia";
            case "TRIBUNAL REGIONAL ELEITORAL DO PARANA" -> "Tribunal Regional Eleitoral do Paraná";
            case "TRIBUNAL REGIONAL ELEITORAL DO RIO G. DO SUL" -> "Tribunal Regional Eleitoral do Rio Grande do Sul";
            case "TRIBUNAL REGIONAL ELEITORAL DO PARA" -> "Tribunal Regional Eleitoral do Pará";
            case "TRIBUNAL REGIONAL ELEITORAL DE PERNAMBUCO" -> "Tribunal Regional Eleitoral de Pernambuco";
            case "TRIBUNAL REGIONAL ELEITORAL DO CEARA" -> "Tribunal Regional Eleitoral do Ceará";
            case "TRIBUNAL REGIONAL ELEITORAL DO MARANHAO" -> "Tribunal Regional Eleitoral do Maranhão";
            case "TRIBUNAL REGIONAL ELEITORAL DE SANTA CATARINA" -> "Tribunal Regional Eleitoral de Santa Catarina";
            case "TRIBUNAL REGIONAL ELEITORAL DE GOIAS" -> "Tribunal Regional Eleitoral de Goiás";
            case "TRIBUNAL REGIONAL ELEITORAL DO PIAUI" -> "Tribunal Regional Eleitoral do Piauí";
            case "TRIBUNAL REGIONAL ELEITORAL DA PARAIBA" -> "Tribunal Regional Eleitoral da Paraíba";
            case "TRIBUNAL REGIONAL ELEITORAL DO RIO G.DO NORTE" ->
                    "Tribunal Regional Eleitoral do Rio Grande do Norte";
            case "TRIBUNAL REGIONAL ELEITORAL DO AMAZONAS" -> "Tribunal Regional Eleitoral do Amazonas";
            case "TRIBUNAL REGIONAL ELEITORAL DE MATO GROSSO" -> "Tribunal Regional Eleitoral de Mato Grosso";
            case "TRIBUNAL REGIONAL ELEITORAL DO ESPIRITO SANTO" -> "Tribunal Regional Eleitoral do Espírito Santo";
            case "TRIBUNAL REGIONAL ELEITORAL DE MATO G. DO SUL" -> "Tribunal Regional Eleitoral de Mato Grosso do Sul";
            case "TRIBUNAL REGIONAL ELEITORAL DO DIST. FEDERAL" -> "Tribunal Regional Eleitoral do Distrito Federal";
            case "TRIBUNAL REGIONAL ELEITORAL DE ALAGOAS" -> "Tribunal Regional Eleitoral de Alagoas";
            case "TRIBUNAL REGIONAL ELEITORAL DE TOCANTINS" -> "Tribunal Regional Eleitoral de Tocantins";
            case "TRIBUNAL REGIONAL ELEITORAL DE SERGIPE" -> "Tribunal Regional Eleitoral de Sergipe";
            case "TRIBUNAL REGIONAL ELEITORAL DE RONDONIA" -> "Tribunal Regional Eleitoral de Rondônia";
            case "TRIBUNAL REGIONAL ELEITORAL DE RORAIMA" -> "Tribunal Regional Eleitoral de Roraima";
            case "TRIBUNAL REGIONAL ELEITORAL DO ACRE" -> "Tribunal Regional Eleitoral do Acre";
            case "TRIBUNAL REGIONAL ELEITORAL DO AMAPA" -> "Tribunal Regional Eleitoral do Amapá";
            case "TRIBUNAL DE JUSTICA DO DISTRITO FEDERAL" -> "Tribunal de Justiça do Distrito Federal";
            case "JUSTICA DA INFANCIA E DA JUVENTUDE" -> "Justiça da Infância e da Juventude";
            case "SUPERIOR TRIBUNAL DE JUSTICA" -> "Superior Tribunal de Justiça";
            case "CONSELHO NACIONAL DE JUSTICA" -> "Conselho Nacional de Justiça";
            case "JUSTICA MILITAR" -> "Justiça Militar";
            default -> orgao.getNameOrgao();
        };
        orgao.setNameOrgao(updatedName);
    }

    private void correctUnidadeGestoraNames1(UnidadeGestora unidadeGestora) {
        String updatedName = switch (unidadeGestora.getNameUnidadeGestora()) {
            case "COORDENACAO DE ORCAMENTO E FINANCAS DO FRGPS" -> "Coordenação de Orçamento e Finanças do FRGPS";
            case "FRGPS - SUPERINTENDENCIA REGIONAL SUL" -> "FRGPS - Superintendência Regional Sul";
            case "FRGPS - SUPERINTENDENCIA REGIONAL SUDESTE I" -> "FRGPS - Superintendência Regional Sudeste I";
            case "FRGPS - SUPERINTENDENCIA REGIONAL NORTE/CENTR" -> "FRGPS - Superintendência Regional Norte/Centro";
            case "FRGPS - SUPERINTENDENCIA REGIONAL NORDESTE" -> "FRGPS - Superintendência Regional Nordeste";
            case "FRGPS - SUPERINTENDENCIA REGIONAL SUDESTE II" -> "FRGPS - Superintendência Regional Sudeste II";
            case "FRGPS - SUPERINTENDENCIA REGIONAL SUDESTE III" -> "FRGPS - Superintendência Regional Sudeste III";
            case "COORD.GERAL DE ORCAMENTO, FINANCAS E CONTAB." ->
                    "Coordenação-Geral de Orçamento, Finanças e Contabilidade";
            case "COORD. EXECUCAO ORC. FINANC E CONT RPPU" -> "Coordenação de Execução Orçamentária e Financeira RPPU";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS" -> "Coordenação-Geral de Gestão de Pessoas";
            case "COORDENACAO DE EXEC.ORCAMENTARIA E FINANCEIRA" -> "Coordenação de Execução Orçamentária e Financeira";
            case "SUPERINTENDENCIA REGIONAL SUDESTE III" -> "Superintendência Regional Sudeste III";
            case "SUPERINTENDENCIA REGIONAL SUDESTE I" -> "Superintendência Regional Sudeste I";
            case "SUPERINTENDENCIA REGIONAL NORDESTE" -> "Superintendência Regional Nordeste";
            case "SUPERINTENDENCIA REGIONAL NORTE/CENTRO-OESTE" -> "Superintendência Regional Norte/Centro-Oeste";
            case "SUPERINTENDENCIA REGIONAL SUL" -> "Superintendência Regional Sul";
            case "SUPERINTENDENCIA REGIONAL SUDESTE II" -> "Superintendência Regional Sudeste II";
            case "FOLHA DE PAGAMENTO - MPS" -> "Folha de Pagamento - MPS";
            case "COORD. GERAL DE GESTAO E ADMINISTRACAO - CGGA" ->
                    "Coordenação-Geral de Gestão e Administração - CGGA";
            case "SECRETARIA DE PREVIDENCIA-MPS" -> "Secretaria de Previdência - MPS";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MPS" -> "Centro de Serviços Compartilhados - MPS";
            case "COORDENACAO GERAL DE RECURSOS HUMANOS PREVIC" -> "Coordenação-Geral de Recursos Humanos - Previc";
            case "COORDENACAO GERAL DE PATRIMONIO E LOGISTICA" -> "Coordenação-Geral de Patrimônio e Logística";
            case "COORD.GERAL DE CONTROLE DA DIVIDA PUBLICA" -> "Coordenação-Geral de Controle da Dívida Pública";
            case "FUNDO SOCIAL - CALAMIDADE PUBLICA" -> "Fundo Social - Calamidade Pública";
            case "COORD.GERAL DE CONTR.E EXEC.DE OPER.FISCAIS." ->
                    "Coordenação-Geral de Controle e Execução de Operações Fiscais";
            case "COORD. ANALISE E INF TRANS FIN INTERGOV/STN" ->
                    "Coordenação de Análise e Informações Transacionais Financeiras Intergovernamentais/STN";
            case "FOLHA DE PAGAMENTO - MF" -> "Folha de Pagamento - MF";
            case "SECRET. ESPECIAL DA RECEITA FEDERAL DO BRASIL" -> "Secretaria Especial da Receita Federal do Brasil";
            case "SUBSECRETARIA DE GESTAO,TEC.DA INF. ORCAMENTO" ->
                    "Subsecretaria de Gestão, Tecnologia da Informação e Orçamento";
            case "PROCURADORIA GERAL DA FAZENDA NACIONAL" -> "Procuradoria-Geral da Fazenda Nacional";
            case "SUBSECRETARIA DE ASSUNTOS CORPORATIVOS- SUCOP" -> "Subsecretaria de Assuntos Corporativos - SUCOP";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 9A RF" -> "Superintendência Regional da RFB na 9ª RF";
            case "UCP/SE/MF-PNAFM III" -> "UCP/SE/MF-PNAFM III";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 8A RF" -> "Superintendência Regional da RFB na 8ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 1A RF" -> "Superintendência Regional da RFB na 1ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 7A RF" -> "Superintendência Regional da RFB na 7ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 2A RF" -> "Superintendência Regional da RFB na 2ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 6A RF" -> "Superintendência Regional da RFB na 6ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 10A RF" -> "Superintendência Regional da RFB na 10ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 4A RF" -> "Superintendência Regional da RFB na 4ª RF";
            case "ALFANDEGA DA RFB EM SAO PAULO" -> "Alfândega da RFB em São Paulo";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 5A RF" -> "Superintendência Regional da RFB na 5ª RF";
            case "SUPERINTENDENCIA REGIONAL DA RFB NA 3A RF" -> "Superintendência Regional da RFB na 3ª RF";
            case "ALFANDEGA DA RFB PORTO DE SANTOS" -> "Alfândega da RFB no Porto de Santos";
            case "CONSELHO ADMINISTRATIVO DE RECURSOS FISCAIS" -> "Conselho Administrativo de Recursos Fiscais";
            case "DELEGACIA DA RFB EM BAURU" -> "Delegacia da RFB em Bauru";
            case "DELEGACIA DA RFB EM RIBEIRAO PRETO" -> "Delegacia da RFB em Ribeirão Preto";
            case "DELEGACIA DA RFB EM VITORIA DA CONQUISTA" -> "Delegacia da RFB em Vitória da Conquista";
            case "DELEGACIA DA RFB EM SANTA MARIA" -> "Delegacia da RFB em Santa Maria";
            case "DELEGACIA DA RFB EM CAXIAS DO SUL" -> "Delegacia da RFB em Caxias do Sul";
            case "COORDENACAO GERAL DE CONTABILIDADE" -> "Coordenação-Geral de Contabilidade";
            case "DELEGACIA DA RFB EM JUNDIAI" -> "Delegacia da RFB em Jundiaí";
            case "DELEGACIA DA RFB EM S.JOSE DOS CAMPOS" -> "Delegacia da RFB em São José dos Campos";
            case "DELEGACIA DA RFB EM SAO LUIS" -> "Delegacia da RFB em São Luís";
            case "DELEGACIA DA RFB EM SANTO ANDRE" -> "Delegacia da RFB em Santo André";
            case "DELEGACIA DE ADM.TRIBUTARIA DA RFB EM S.PAULO" ->
                    "Delegacia de Administração Tributária da RFB em São Paulo";
            case "DELEGACIA DA RFB EM MANAUS" -> "Delegacia da RFB em Manaus";
            case "COORDENACAO-GERAL DE PESQ.INVESTIGACAO DA RFB" ->
                    "Coordenação-Geral de Pesquisa e Investigação da RFB";
            case "DELEGACIA DA RFB EM FEIRA DE SANTANA" -> "Delegacia da RFB em Feira de Santana";
            case "DELEGACIA DA RFB EM VARGINHA" -> "Delegacia da RFB em Varginha";
            case "DELEGACIA DA RFB EM ARACAJU" -> "Delegacia da RFB em Aracaju";
            case "DELEGACIA DA RFB EM NATAL" -> "Delegacia da RFB em Natal";
            case "DELEGACIA DA RFB EM UBERLANDIA" -> "Delegacia da RFB em Uberlândia";
            case "DELEGACIA DA RFB EM GOIANIA" -> "Delegacia da RFB em Goiânia";
            case "DELEGACIA DA RFB EM TERESINA" -> "Delegacia da RFB em Teresina";
            case "DELEGACIA DA RFB EM MACEIO" -> "Delegacia da RFB em Maceió";
            case "DELEGACIA DA RFB EM CAMPO GRANDE" -> "Delegacia da RFB em Campo Grande";
            case "DELEGACIA DA RFB EM PORTO VELHO" -> "Delegacia da RFB em Porto Velho";
            case "CORREGEDORIA-GERAL DA RFB" -> "Corregedoria-Geral da RFB";
            case "DELEGACIA DA RFB EM JOAO PESSOA" -> "Delegacia da RFB em João Pessoa";
            case "DELEGACIA DA RFB EM RIO BRANCO" -> "Delegacia da RFB em Rio Branco";
            case "DELEGACIA DA RFB EM CAMPINAS" -> "Delegacia da RFB em Campinas";
            case "DELEGACIA DA RFB EM PALMAS" -> "Delegacia da RFB em Palmas";
            case "DELEGACIA DA RFB EM CUIABA" -> "Delegacia da RFB em Cuiabá";
            case "ALFANDEGA DA RFB EM FOZ DO IGUACU" -> "Alfândega da RFB em Foz do Iguaçu";
            case "DELEGACIA DA RFB EM JUIZ DE FORA" -> "Delegacia da RFB em Juiz de Fora";
            case "DELEGACIA DA RFB EM VITORIA" -> "Delegacia da RFB em Vitória";
            case "COORDENACAO GERAL DE HAVERES FINANCEIROS" -> "Coordenação-Geral de Haveres Financeiros";
            case "DELEGACIA DA RFB EM NITEROI" -> "Delegacia da RFB em Niterói";
            case "DELEGACIA DA RFB EM BOA VISTA" -> "Delegacia da RFB em Boa Vista";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MF" -> "Centro de Serviços Compartilhados - MF";
            case "DELEGACIA DA RFB EM SANTAREM" -> "Delegacia da RFB em Santarém";
            case "DELEGACIA DA RFB EM MACAPA" -> "Delegacia da RFB em Macapá";
            case "SECRETARIA DE POLITICA ECONOMICA" -> "Secretaria de Política Econômica";
            case "DELEGACIA DA RFB EM FLORIANOPOLIS" -> "Delegacia da RFB em Florianópolis";
            case "DELEGACIA DA RFB EM NOVA IGUACU" -> "Delegacia da RFB em Nova Iguaçu";
            case "DELEGACIA DA RFB EM PIRACICABA" -> "Delegacia da RFB em Piracicaba";
            case "DELEGACIA DA RFB EM LONDRINA" -> "Delegacia da RFB em Londrina";
            case "DELEGACIA DA RFB EM JOACABA" -> "Delegacia da RFB em Joaçaba";
            case "DELEGACIA DA RFB EM OSASCO" -> "Delegacia da RFB em Osasco";
            case "DELEGACIA DA RFB EM JOINVILLE" -> "Delegacia da RFB em Joinville";
            case "FCDF - SECRETARIA DE SAUDE" -> "FCDF - Secretaria de Saúde";
            case "FCDF-PMDF-DEPARTAMENTO DE GESTAO DE PESSOAL" -> "FCDF-PMDF - Departamento de Gestão de Pessoal";
            case "FCDF - SECRETARIA DE EDUCACAO" -> "FCDF - Secretaria de Educação";
            case "FCDF±SSP ± POLICIA CIVIL DO DF" -> "FCDF-SSP - Polícia Civil do DF";
            case "FCDF±SSP±CORPO BOMBEIRO MILITAR DO DF" -> "FCDF-SSP - Corpo de Bombeiros Militar do DF";
            case "DEPARTAMENTO DE SAUDE E ASSIST. DE PESSOAL" -> "Departamento de Saúde e Assistência de Pessoal";
            case "FCDF - CBMDF - ASSISTENCIA MEDICA" -> "FCDF-CBMDF - Assistência Médica";
            case "FCDF±SSP ± POLICIA MILITAR DO DF" -> "FCDF-SSP - Polícia Militar do DF";
            case "FUNDO DE GARANTIA A EXPORTACAO-BNDES" -> "Fundo de Garantia à Exportação - BNDES";
            case "FUNDO DE COMPENSACAO E VARIACAO SALARIAL" -> "Fundo de Compensação e Variação Salarial";
            case "SUPERINTENDENCIA DE SEGUROS PRIVADOS - RJ" -> "Superintendência de Seguros Privados - RJ";
            case "COMISSAO DE VALORES MOBILIARIOS" -> "Comissão de Valores Mobiliários";
            case "FUNDO DE ESTABILIDADE DO SEGURO RURAL" -> "Fundo de Estabilidade do Seguro Rural";
            case "DIRETORIA EXECUTIVA DO FUNDO NAC. DE SAUDE" -> "Diretoria Executiva do Fundo Nacional de Saúde";
            case "DEPARTAMENTO DE LOGISTICA EM SAUDE - DLOG" -> "Departamento de Logística em Saúde - DLOG";
            case "SECR. DE GESTAO DO TRAB. E DA EDUC. NA SAUDE" ->
                    "Secretaria de Gestão do Trabalho e da Educação na Saúde";
            case "SUBSECRETARIA DE ASSUNTOS ADMINISTRATIVOS/MS" -> "Subsecretaria de Assuntos Administrativos/MS";
            case "INSTITUTO NACIONAL DO CANCER - RJ" -> "Instituto Nacional do Câncer - RJ";
            case "CEF-PROGRAMAS DO MINISTERIO DA SAUDE" -> "CEF - Programas do Ministério da Saúde";
            case "SECRETARIA DE ATENCAO PRIMARIA A SAUDE" -> "Secretaria de Atenção Primária à Saúde";
            case "INST. NACIONAL DE TRAUMATOLOGIA E ORTOPEDIA" -> "Instituto Nacional de Traumatologia e Ortopedia";
            case "HOSPITAL FEDERAL DOS SERVIDORES DO ESTADO" -> "Hospital Federal dos Servidores do Estado";
            case "DISTRITO SANIT.ESP.INDIGENA - YANOMAMI" -> "Distrito Sanitário Especial Indígena - Yanomami";
            case "HOSPITAL FEDERAL DE BONSUCESSO" -> "Hospital Federal de Bonsucesso";
            case "HOSPITAL FEDERAL DO ANDARAI" -> "Hospital Federal do Andaraí";
            case "INSTITUTO NACIONAL DE CARDIOLOGIA" -> "Instituto Nacional de Cardiologia";
            case "HOSPITAL FEDERAL DE IPANEMA" -> "Hospital Federal de Ipanema";
            case "HOSPITAL FEDERAL CARDOSO FONTES" -> "Hospital Federal Cardoso Fontes";
            case "HOSPITAL FEDERAL DA LAGOA" -> "Hospital Federal da Lagoa";
            case "DISTRITO SANIT.ESP.INDIGENA MATO GROSSO SUL" ->
                    "Distrito Sanitário Especial Indígena Mato Grosso Sul";
            case "INSTITUTO EVANDRO CHAGAS" -> "Instituto Evandro Chagas";
            case "DISTRITO SANIT.ESP.INDIGENA GUAMA TOCANTINS" ->
                    "Distrito Sanitário Especial Indígena Guamá Tocantins";
            case "DISTRITO SANIT.ESP.INDIGENA - LESTE RR" -> "Distrito Sanitário Especial Indígena - Leste RR";
            case "DISTRITO SANIT.ESP.INDIGENA - INTERIOR SUL" -> "Distrito Sanitário Especial Indígena - Interior Sul";
            case "DISTRITO SANIT.ESP.INDIGENA - AMAPA" -> "Distrito Sanitário Especial Indígena - Amapá";
            case "DISTRITO SANIT.ESP.INDIGENA - CUIABA" -> "Distrito Sanitário Especial Indígena - Cuiabá";
            case "DISTRITO SANIT.ESP.INDIGENA - MANAUS" -> "Distrito Sanitário Especial Indígena - Manaus";
            case "DISTRITO SANIT.ESP.INDIGENA - PARINTINS" -> "Distrito Sanitário Especial Indígena - Parintins";
            case "DISTRITO SANIT.ESP.INDIGENA - LITORAL SUL" -> "Distrito Sanitário Especial Indígena - Litoral Sul";
            case "SECRETARIA DE ATENCAO ESPECIALIZADA A SAUDE" -> "Secretaria de Atenção Especializada à Saúde";
            case "DISTRITO SANIT.ESP.INDIGENA - MARANHAO" -> "Distrito Sanitário Especial Indígena - Maranhão";
            case "DISTRITO SANIT.ESP.INDIGENA - XINGU" -> "Distrito Sanitário Especial Indígena - Xingu";
            case "DISTRITO SANIT.ESP.INDIGENA - ALTO RIO NEGRO" ->
                    "Distrito Sanitário Especial Indígena - Alto Rio Negro";
            case "DISTRITO SANIT.ESP.INDIGENA - KAIAPO REDENCAO" ->
                    "Distrito Sanitário Especial Indígena - Kaiapó Redenção";
            case "DISTRITO SANIT.ESP.INDIGENA - PORTO VELHO" -> "Distrito Sanitário Especial Indígena - Porto Velho";
            case "DISTRITO SANIT.ESP.INDIGENA - MG/ES" -> "Distrito Sanitário Especial Indígena - MG/ES";
            case "DISTRITO SANIT.ESP.INDIGENA - BAHIA" -> "Distrito Sanitário Especial Indígena - Bahia";
            case "DISTRITO SANIT.ESP.INDIGENA - PERNAMBUCO" -> "Distrito Sanitário Especial Indígena - Pernambuco";
            case "DISTRITO SANIT.ESP.INDIGENA - XAVANTE" -> "Distrito Sanitário Especial Indígena - Xavante";
            case "DISTRITO SANIT.ESP.INDIGENA - ALTO SOLIMOES" ->
                    "Distrito Sanitário Especial Indígena - Alto Solimões";
            case "DISTRITO SANIT.ESP.INDIGENA - CEARA" -> "Distrito Sanitário Especial Indígena - Ceará";
            case "SUPERINTENDENCIA ESTADUAL DO MS/RJ" -> "Superintendência Estadual do MS/RJ";
            case "DISTRITO SANIT.ESP.INDIGENA - TOCANTINS" -> "Distrito Sanitário Especial Indígena - Tocantins";
            case "DISTRITO SANIT.ESP.INDIGENA KAIAPO MT GROSSO" ->
                    "Distrito Sanitário Especial Indígena Kaiapó Mato Grosso";
            case "DISTRITO SANIT.ESP.INDIGENA - VILHENA" -> "Distrito Sanitário Especial Indígena - Vilhena";
            case "DISTRITO SANIT.ESP.INDIGENA - MEDIO PURUS" -> "Distrito Sanitário Especial Indígena - Médio Purus";
            case "DISTRITO SANIT.ESP.INDIGENA - ARAGUAIA" -> "Distrito Sanitário Especial Indígena - Araguaia";
            case "DISTRITO SANIT.ESP.INDIGENA - TAPAJOS" -> "Distrito Sanitário Especial Indígena - Tapajós";
            case "DISTRITO SANIT.ESP.INDIGENA - JAVARI" -> "Distrito Sanitário Especial Indígena - Javari";
            case "DISTRITO SANIT.ESP.INDIGENA AL/SE" -> "Distrito Sanitário Especial Indígena AL/SE";
            case "DISTRITO SANIT.ESP.INDIGENA - ALTO PURUS" -> "Distrito Sanitário Especial Indígena - Alto Purus";
            case "DISTRITO SANIT.ESP.INDIGENA - ALTAMIRA" -> "Distrito Sanitário Especial Indígena - Altamira";
            case "DISTRITO SANIT.ESP.INDIGENA - ALTO RIO JURUA" ->
                    "Distrito Sanitário Especial Indígena - Alto Rio Juruá";
            case "CENTRO NACIONAL DE PRIMATAS" -> "Centro Nacional de Primatas";
            case "DISTRITO SANIT.ESP.INDIGENA - MEDIO SOLIMOES" ->
                    "Distrito Sanitário Especial Indígena - Médio Solimões";
            case "DISTRITO SANIT.ESP.INDIGENA - POTIGUARA" -> "Distrito Sanitário Especial Indígena - Potiguara";
            case "SUPERINTENDENCIA ESTADUAL DO MS/AM" -> "Superintendência Estadual do MS/AM";
            case "SUPERINTENDENCIA ESTADUAL DO MS/GO" -> "Superintendência Estadual do MS/GO";
            case "SUPERINTENDENCIA ESTADUAL DO MS/MA" -> "Superintendência Estadual do MS/MA";
            case "SUPERINTENDENCIA ESTADUAL DO MS/MG" -> "Superintendência Estadual do MS/MG";
            case "SUPERINTENDENCIA ESTADUAL DO MS/PR" -> "Superintendência Estadual do MS/PR";
            case "SUPERINTENDENCIA ESTADUAL DO MS/SP" -> "Superintendência Estadual do MS/SP";
            case "SUPERINTENDENCIA ESTADUAL DO MS/TO" -> "Superintendência Estadual do MS/TO";
            case "SUPERINTENDENCIA ESTADUAL DO MS/SE" -> "Superintendência Estadual do MS/SE";
            case "SUPERINTENDENCIA ESTADUAL DO MS/PI" -> "Superintendência Estadual do MS/PI";
            case "SUPERINTENDENCIA ESTADUAL DO MS/RN" -> "Superintendência Estadual do MS/RN";
            case "SUPERINTENDENCIA ESTADUAL DO MS/PB" -> "Superintendência Estadual do MS/PB";
            case "SUPERINTENDENCIA ESTADUAL DO MS/RS" -> "Superintendência Estadual do MS/RS";
            case "SECRETARIA EXECUTIVA DO CNS" -> "Secretaria Executiva do CNS";
            case "SUPERINTENDENCIA ESTADUAL DO MS/ES" -> "Superintendência Estadual do MS/ES";
            case "SUPERINTENDENCIA ESTADUAL DO MS/CE" -> "Superintendência Estadual do MS/CE";
            case "SUPERINTENDENCIA ESTADUAL DO MS/SC" -> "Superintendência Estadual do MS/SC";
            case "SUPERINTENDENCIA ESTADUAL DO MS/RO" -> "Superintendência Estadual do MS/RO";
            case "SUPERINTENDENCIA ESTADUAL DO MS/AC" -> "Superintendência Estadual do MS/AC";
            case "SUPERINTENDENCIA ESTADUAL DO MS/RR" -> "Superintendência Estadual do MS/RR";
            case "SUPERINTENDENCIA ESTADUAL DO MS/PE" -> "Superintendência Estadual do MS/PE";
            case "SUPERINTENDENCIA ESTADUAL DO MS/MT" -> "Superintendência Estadual do MS/MT";
            case "SUPERINTENDENCIA ESTADUAL DO MS/BA" -> "Superintendência Estadual do MS/BA";
            case "GABINETE DO MINISTRO - MS" -> "Gabinete do Ministro - MS";
            case "SUPERINTENDENCIA ESTADUAL DO MS/AP" -> "Superintendência Estadual do MS/AP";
            case "SECRETARIA DE VIGILANCIA EM SAUDE E AMBIENTE" -> "Secretaria de Vigilância em Saúde e Ambiente";
            case "SECRETARIA DE SAUDE INDIGENA - SESAI" -> "Secretaria de Saúde Indígena - SESAI";
            case "SUPERINTENDENCIA ESTADUAL DO MS/AL" -> "Superintendência Estadual do MS/AL";
            case "SUPERINTENDENCIA ESTADUAL DO MS/PA" -> "Superintendência Estadual do MS/PA";
            case "SUPERINTENDENCIA ESTADUAL DO MS/MS" -> "Superintendência Estadual do MS/MS";
            case "SECR.DE CIENCIA,TECNO.INV.COMP-ECO IND.SAUDE" ->
                    "Secretaria de Ciência, Tecnologia, Inovação e Comércio - Eco Indústria Saúde";
            case "SECRETARIA DE INFORMACAO E SAUDE DIGITAL" -> "Secretaria de Informação e Saúde Digital";
            case "FUNDACAO OSWALDO CRUZ" -> "Fundação Oswaldo Cruz";
            case "INSTITUTO DE TECNOLOGIA EM IMUNOBIOLOGICOS" -> "Instituto de Tecnologia em Imunobiológicos";
            case "INSTITUTO DE TECNOLOGIA EM FARMACOS" -> "Instituto de Tecnologia em Fármacos";
            case "COORDENACAO GERAL DE INFRAESTRUTURA DOS CAMPI" -> "Coordenação-Geral de Infraestrutura dos Campi";
            case "ESCOLA NAC. DE SAUDE PUBLICA SERGIO AROUCA" -> "Escola Nacional de Saúde Pública Sérgio Arouca";
            case "INST NACIONAL DE SAUDE FERNANDES FIGUEIRA" -> "Instituto Nacional de Saúde Fernandes Figueira";
            case "INST.NACIONAL DE INFECTOLOGIA EVANDRO CHAGAS" -> "Instituto Nacional de Infectologia Evandro Chagas";
            case "INSTITUTO OSWALDO CRUZ" -> "Instituto Oswaldo Cruz";
            case "CASA DE OSWALDO CRUZ" -> "Casa de Oswaldo Cruz";
            case "INSTITUTO LEONIDAS E MARIA DEANE" -> "Instituto Leonidas e Maria Deane";
            case "INSTITUTO DE CIENCIA E TEC. EM BIOMODELOS" -> "Instituto de Ciência e Tecnologia em Biomodelos";
            case "INSTITUTO AGGEU MAGALHAES" -> "Instituto Aggeu Magalhães";
            case "INSTITUTO GONCALO MONIZ" -> "Instituto Gonçalo Moniz";
            case "INSTITUTO NAC. DE CONTROLE E QUALID. EM SAUDE" ->
                    "Instituto Nacional de Controle e Qualidade em Saúde";
            case "INSTITUTO RENNE RACHOU" -> "Instituto René Rachou";
            case "HOSPITAL NOSSA SENHORA DA CONCEICAO S/A" -> "Hospital Nossa Senhora da Conceição S/A";
            case "FUNDACAO NACIONAL DE SAUDE - DF" -> "Fundação Nacional de Saúde - DF";
            case "FUNDACAO NACIONAL DE SAUDE - RJ" -> "Fundação Nacional de Saúde - RJ";
            case "FUNDACAO NACIONAL DE SAUDE - BA" -> "Fundação Nacional de Saúde - BA";
            case "FUNDACAO NACIONAL DE SAUDE - PE" -> "Fundação Nacional de Saúde - PE";
            case "FUNDACAO NACIONAL DE SAUDE - MG" -> "Fundação Nacional de Saúde - MG";
            case "FUNDACAO NACIONAL DE SAUDE - AL" -> "Fundação Nacional de Saúde - AL";
            case "FUNDACAO NACIONAL DE SAUDE - PI" -> "Fundação Nacional de Saúde - PI";
            case "FUNDACAO NACIONAL DE SAUDE - MT" -> "Fundação Nacional de Saúde - MT";
            case "FUNDACAO NACIONAL DE SAUDE - CE" -> "Fundação Nacional de Saúde - CE";
            case "FUNDACAO NACIONAL DE SAUDE - SC" -> "Fundação Nacional de Saúde - SC";
            case "FUNDACAO NACIONAL DE SAUDE - MA" -> "Fundação Nacional de Saúde - MA";
            case "FUNDACAO NACIONAL DE SAUDE - PA" -> "Fundação Nacional de Saúde - PA";
            case "FUNDACAO NACIONAL DE SAUDE - GO" -> "Fundação Nacional de Saúde - GO";
            case "FUNDACAO NACIONAL DE SAUDE - AC" -> "Fundação Nacional de Saúde - AC";
            case "FUNDACAO NACIONAL DE SAUDE - SE" -> "Fundação Nacional de Saúde - SE";
            case "FUNDACAO NACIONAL DE SAUDE - MS" -> "Fundação Nacional de Saúde - MS";
            case "FUNDACAO NACIONAL DE SAUDE - TO" -> "Fundação Nacional de Saúde - TO";
            case "FUNDACAO NACIONAL DE SAUDE - RR" -> "Fundação Nacional de Saúde - RR";
            case "FUNDACAO NACIONAL DE SAUDE - PB" -> "Fundação Nacional de Saúde - PB";
            case "FUNDACAO NACIONAL DE SAUDE - ES" -> "Fundação Nacional de Saúde - ES";
            case "FUNDACAO NACIONAL DE SAUDE - RS" -> "Fundação Nacional de Saúde - RS";
            case "AGENCIA NACIONAL DE VIGILANCIA SANITARIA" -> "Agência Nacional de Vigilância Sanitária";
            case "COORD.VIG.SANIT.DE PORTOS,AER.E FRONTEIRAS-SP" ->
                    "Coordenação de Vigilância Sanitária de Portos, Aeroportos e Fronteiras - SP";
            case "COORD.VIG.SANIT.DE PORTOS,AER.E FRONTEIRAS-PE" ->
                    "Coordenação de Vigilância Sanitária de Portos, Aeroportos e Fronteiras - PE";
            case "COORD.VIG.SANIT.DE PORTOS,AER.E FRONTEIRAS-AL" ->
                    "Coordenação de Vigilância Sanitária de Portos, Aeroportos e Fronteiras - AL";
            case "AGENCIA NACIONAL DE SAUDE SUPLEMENTAR" -> "Agência Nacional de Saúde Suplementar";
            case "AGENCIA NACIONAL DE SAUDE S. - DF" -> "Agência Nacional de Saúde Suplementar - DF";
            case "FUNDO NACIONAL DE DESENVOLVIMENTO DA EDUCACAO" -> "Fundo Nacional de Desenvolvimento da Educação";
            case "NOVO FIES/CEF" -> "Novo FIES/CEF";
            case "FUNDO DE FINANCIAMENTO ESTUDANTIL" -> "Fundo de Financiamento Estudantil";
            case "FNDE - BIRD" -> "FNDE - BIRD";
            case "EMPRESA BRASILEIRA DE SERVICOS HOSPITALARES" -> "Empresa Brasileira de Serviços Hospitalares";
            case "HOSPITAL DE CLINICAS DE UBERLANDIA" -> "Hospital de Clínicas de Uberlândia";
            case "HOSPITAL UNIVERSITARIO DA UFMA" -> "Hospital Universitário da UFMA";
            case "HOSPITAL DAS CLINICAS DA UFMG" -> "Hospital das Clínicas da UFMG";
            case "EBSERH CHC-UFPR" -> "EBSERH CHC-UFPR";
            case "HOSPITAL UNIVERSITARIO DE BRASILIA" -> "Hospital Universitário de Brasília";
            case "HOSPITAL DE CLINICAS DA UFTM" -> "Hospital de Clínicas da UFTM";
            case "EBSERH COMPLEXO HOSPITALAR DO CEARA" -> "EBSERH Complexo Hospitalar do Ceará";
            case "HOSP UNIVERSITARIO CASSIANO ANTONIO DE MORAES" -> "Hospital Universitário Cassiano Antônio de Moraes";
            case "HOSPITAL UNIVERSITARIO PROF. EDGARD SANTOS" -> "Hospital Universitário Professor Edgard Santos";
            case "EBSERH HC-UFPE" -> "EBSERH HC-UFPE";
            case "COMPLEXO HOSP UNIVERSIT DA UFPA (HUBFS/HUJBB)" ->
                    "Complexo Hospitalar Universitário da UFPA (HUBFS/HUJBB)";
            case "HOSPITAL UNIVERSITARIO ANTONIO PEDRO" -> "Hospital Universitário Antônio Pedro";
            case "HOSPITAL DAS CLINICAS DA UFG" -> "Hospital das Clínicas da UFG";
            case "HOSP UNIVERSITARIO MARIA APARECIDA PEDROSSIAN" -> "Hospital Universitário Maria Aparecida Pedrossian";
            case "HOSPITAL UNIVERSITARIO DE SANTA MARIA" -> "Hospital Universitário de Santa Maria";
            case "HOSPITAL UNIVERSITARIO DO PIAUI" -> "Hospital Universitário do Piauí";
            case "HOSPITAL UNIVERSITARIO DA UFSC" -> "Hospital Universitário da UFSC";
            case "HOSPITAL UNIVERSITARIO GAFFREE E GUINLE" -> "Hospital Universitário Gaffrée e Guinle";
            case "EBSERH HU-UFGD" -> "EBSERH HU-UFGD";
            case "HOSPITAL UNIVERSITARIO LAURO WANDERLEY" -> "Hospital Universitário Lauro Wanderley";
            case "HOSPITAL ESCOLA DA UFPEL" -> "Hospital Escola da UFPEL";
            case "HOSPITAL UNIVERSITARIO DA UNIV. FED. DO AMAPA" ->
                    "Hospital Universitário da Universidade Federal do Amapá";
            case "HOSP DE ENSINO DR WASHINGTON ANTONIO DE BARRO" ->
                    "Hospital de Ensino Dr. Washington Antônio de Barros";
            case "HOSPITAL UNIVERSITARIO ONOFRE LOPES" -> "Hospital Universitário Onofre Lopes";
            case "HOSPITAL UNIVERSITARIO DA UFJF" -> "Hospital Universitário da UFJF";
            case "HOSPITAL UNIVERSITARIO PROF ALBERTO ANTUNES" -> "Hospital Universitário Professor Alberto Antunes";
            case "HOSPITAL UNIV. DR. MIGUEL RIET CORREA JR." -> "Hospital Universitário Dr. Miguel Riet Corrêa Jr.";
            case "HOSPITAL UNIVERSITARIO DA UFS" -> "Hospital Universitário da UFS";
            case "MATERNIDADE ESCOLA JANUARIO CICCO" -> "Maternidade Escola Januário Cicco";
            case "MATERNIDADE CLIMERIO DE OLIVEIRA" -> "Maternidade Climério de Oliveira";
            case "HOSPITAL UNIVERSITARIO DA UFSCAR" -> "Hospital Universitário da UFSCAR";
            case "HOSPITAL UNIVERSITARIO JULIO MULLER" -> "Hospital Universitário Júlio Muller";
            case "HOSPITAL UNIVERSITARIO GETULIO VARGAS" -> "Hospital Universitário Getúlio Vargas";
            case "HOSPITAL UNIVERSITARIO DE LAGARTO" -> "Hospital Universitário de Lagarto";
            case "HOSPITAL UNIVERSITARIO ALCIDES CARNEIRO" -> "Hospital Universitário Alcides Carneiro";
            case "COMPLEXO HOSPITALAR DA UFRJ" -> "Complexo Hospitalar da UFRJ";
            case "HOSPITAL UNIVERSITARIO JULIO BANDEIRA" -> "Hospital Universitário Júlio Bandeira";
            case "HOSPITAL UNIVERSITARIO ANA BEZERRA" -> "Hospital Universitário Ana Bezerra";
            case "HOSPITAL DE DOENCAS TROPICAIS" -> "Hospital de Doenças Tropicais";
            case "UND.COORD.DE APERF.DE PESSOAL NIVEL SUPERIOR" ->
                    "Unidade de Coordenação de Aperfeiçoamento de Pessoal de Nível Superior";
            case "FUND.COORD.DE APERF.DE PESSOAL NIVEL SUPERIOR" ->
                    "Fundação Coordenadora de Aperfeiçoamento de Pessoal de Nível Superior";
            case "UNIVERSIDADE FEDERAL DO RIO DE JANEIRO" -> "Universidade Federal do Rio de Janeiro";
            case "SUP.GERAL DO COMPLEXO HOSP.E DE SAUDE DA UFRJ" ->
                    "Superintendência-Geral do Complexo Hospitalar e de Saúde da UFRJ";
            case "HOSPITAL UNIVERSITARIO DA UFRJ" -> "Hospital Universitário da UFRJ";
            case "MATERNIDADE ESCOLA DA UFRJ" -> "Maternidade Escola da UFRJ";
            case "INSTITUTO PUERIC. PED MAT. GESTEIRA DA UFRJ" ->
                    "Instituto Pueri de Pediatria e Maternidade Gesteira da UFRJ";
            case "MUSEU NACIONAL DA UFRJ" -> "Museu Nacional da UFRJ";
            case "DECANATO DO CENTRO DE TECNOLOGIA DA UFRJ" -> "Decanato do Centro de Tecnologia da UFRJ";
            case "INSTITUTO DE PSIQUIATRIA DA UFRJ" -> "Instituto de Psiquiatria da UFRJ";
            case "DECANATO DO CENTRO DE CIENC.DA SAUDE DA UFRJ" -> "Decanato do Centro de Ciências da Saúde da UFRJ";
            case "DECANATO DO CENTRO DE LETRAS E ARTES DA UFRJ" -> "Decanato do Centro de Letras e Artes da UFRJ";
            case "DECANATO DO CENT DE FILOSOF. E C HUM. DA UFRJ" ->
                    "Decanato do Centro de Filosofia e Ciências Humanas da UFRJ";
            case "DECANATO DO CENTRO DE CIEN MATEM E DA NATUREZ" ->
                    "Decanato do Centro de Ciências Matemáticas e da Natureza";
            case "HOSPITAL ESCOLA SAO FRANCISCO DE ASSIS" -> "Hospital Escola São Francisco de Assis";
            case "DECANATO DO CENTRO DE C JUR E ECONOM. DA UFRJ" ->
                    "Decanato do Centro de Ciências Jurídicas e Econômicas da UFRJ";
            case "FORUM DE CIENCIA E CULTURA DA UFRJ" -> "Fórum de Ciência e Cultura da UFRJ";
            case "INSTITUTO DE BIOFISICA DA UFRJ" -> "Instituto de Biofísica da UFRJ";
            case "INSTITUTO DE GINECOLOGIA DA UFRJ" -> "Instituto de Ginecologia da UFRJ";
            case "INSTITUTO DE DOENCAS DO TORAX DA UFRJ" -> "Instituto de Doenças do Tórax da UFRJ";
            case "INSTITUTO DE NEUROL. DEOLINDO COUTO DA UFRJ" -> "Instituto de Neurologia Deolindo Couto da UFRJ";
            case "FACULDADE DE MEDICINA DA UFRJ" -> "Faculdade de Medicina da UFRJ";
            case "CAMPUS DE MACAE DA UFRJ" -> "Campus de Macaé da UFRJ";
            case "PREFEITURA DA UNIVERSIDADE DA UFRJ" -> "Prefeitura da Universidade da UFRJ";
            case "CAMPUS UFRJ D. CAXIAS PROF GERALDO CIDADE" -> "Campus UFRJ Duque de Caxias Professor Geraldo Cidade";
            case "UNIVERSIDADE FEDERAL DE MINAS GERAIS" -> "Universidade Federal de Minas Gerais";
            case "FACULDADE DE EDUCACAO/UFMG" -> "Faculdade de Educação/UFMG";
            case "ADMINISTRACAO GERAL/UFMG" -> "Administração Geral/UFMG";
            case "FACULDADE DE MEDICINA/UFMG" -> "Faculdade de Medicina/UFMG";
            case "ESCOLA DE ARQUITETURA/UFMG" -> "Escola de Arquitetura/UFMG";
            case "PRO-REITORIA DE PESQUISA/UFMG" -> "Pró-Reitoria de Pesquisa/UFMG";
            case "FACULDADE DE FILOSOFIA E CIENC. HUMANAS/UFMG" -> "Faculdade de Filosofia e Ciências Humanas/UFMG";
            case "DEPARTAMENTO MANUT. OPER.INFRA-ESTRUTURA/UFMG" ->
                    "Departamento de Manutenção e Operação de Infraestrutura/UFMG";
            case "PRO-REITORIA DE GRADUACAO/UFMG" -> "Pró-Reitoria de Graduação/UFMG";
            case "DIRETORIA DE TECNOLOGIA DA INFORMACAO" -> "Diretoria de Tecnologia da Informação";
            case "ESCOLA DE ENFERMAGEM/UFMG" -> "Escola de Enfermagem/UFMG";
            case "PRO-REITORIA DE EXTENSAO/UFMG" -> "Pró-Reitoria de Extensão/UFMG";
            case "FACULDADE DE CIENCIAS ECONOMICAS/UFMG" -> "Faculdade de Ciências Econômicas/UFMG";
            case "PRO-REITORIA DE CULTURA DA UFMG" -> "Pró-Reitoria de Cultura da UFMG";
            case "INSTITUTO DE CIENCIAS EXATAS/UFMG" -> "Instituto de Ciências Exatas/UFMG";
            case "ESCOLA DE ENGENHARIA/UFMG" -> "Escola de Engenharia/UFMG";
            case "DEPARTAMENTO DE OBRAS/UFMG" -> "Departamento de Obras/UFMG";
            case "INSTITUTO DE CIENCIAS BIOLOGICAS/UFMG" -> "Instituto de Ciências Biológicas/UFMG";
            case "ESCOLA DE VETERINARIA/UFMG" -> "Escola de Veterinária/UFMG";
            case "FACULDADE DE ODONTOLOGIA/UFMG" -> "Faculdade de Odontologia/UFMG";
            case "FACULDADE DE FARMACIA/UFMG" -> "Faculdade de Farmácia/UFMG";
            case "BIBLIOTECA UNIVERSITARIA/UFMG" -> "Biblioteca Universitária/UFMG";
            case "INSTITUTO DE GEO-CIENCIAS/UFMG" -> "Instituto de Geociências/UFMG";
            case "INSTITUTO DE CIENCIAS AGRARIAS/UFMG" -> "Instituto de Ciências Agrárias/UFMG";
            case "COLEGIO TECNICO/UFMG" -> "Colégio Técnico/UFMG";
            case "ESCOLA EDUCACAO FISICA FISIOT.TERAP.OCUP/UFMG" ->
                    "Escola de Educação Física, Fisioterapia e Terapia Ocupacional/UFMG";
            case "PRO-REITORIA DE POS-GRADUACAO/UFMG" -> "Pró-Reitoria de Pós-Graduação/UFMG";
            case "FACULDADE DE LETRAS/UFMG" -> "Faculdade de Letras/UFMG";
            case "CENTRO DE COMUNICACAO DA UFMG" -> "Centro de Comunicação da UFMG";
            case "ESCOLA DE MUSICA/UFMG" -> "Escola de Música/UFMG";
            case "CENTRO PEDAGOGICO/UFMG" -> "Centro Pedagógico/UFMG";
            case "PRO-REITORIA DE ADMINISTRACAO/UFMG" -> "Pró-Reitoria de Administração/UFMG";
            case "CENTRO ESPORTIVO UNIVERSITARIO/UFMG" -> "Centro Esportivo Universitário/UFMG";
            case "ESCOLA DE BELAS ARTES/UFMG" -> "Escola de Belas Artes/UFMG";
            case "IMPRENSA UNIVERSITARIA/UFMG" -> "Imprensa Universitária/UFMG";
            case "ESCOLA DE CIENCIA DA INFORMACAO/UFMG" -> "Escola de Ciência da Informação/UFMG";
            case "DIRETORIA DE EDUC A DISTANCIA E EDUC DIGITAL" ->
                    "Diretoria de Educação a Distância e Educação Digital";
            case "FACULDADE DE DIREITO/UFMG" -> "Faculdade de Direito/UFMG";
            case "EDITORA DA UFMG" -> "Editora da UFMG";
            case "MUSEU HISTORICO NATURAL/UFMG" -> "Museu Histórico Natural/UFMG";
            case "PRO-REITORIA DE PLANEJ.E DESENVOLVIMENTO/UFMG" ->
                    "Pró-Reitoria de Planejamento e Desenvolvimento/UFMG";
            case "UNIVERSIDADE FEDERAL FLUMINENSE" -> "Universidade Federal Fluminense";
            case "COORD. DE PROJ. C/A FUND. DE APOIO" -> "Coordenação de Projetos com a Fundação de Apoio";
            case "PRO-REITORIA DE ADMINISTRACAO/UFF" -> "Pró-Reitoria de Administração/UFF";
            case "PRO-REITORIA DE ASSUNTOS ESTUDANTIS" -> "Pró-Reitoria de Assuntos Estudantis";
            case "PRO-REITORIA DE GRADUACAO" -> "Pró-Reitoria de Graduação";
            case "PRO-REIT.DE PESQ.E POS-GRAD. E INOVACAO" -> "Pró-Reitoria de Pesquisa e Pós-Graduação e Inovação";
            case "INST.CIENCIAS HUMANAS E SOCIAIS VOLTA REDONDA" ->
                    "Instituto de Ciências Humanas e Sociais de Volta Redonda";
            case "SUBCOORD.DA UNID.AVANC.J.VERISSIMO" -> "Subcoordenação da Unidade Avançada João Veríssimo";
            case "UNIVERSIDADE FEDERAL DO RIO GRANDE DO SUL" -> "Universidade Federal do Rio Grande do Sul";
            case "FUNDACAO UNIVERSIDADE DE BRASILIA - UNB" -> "Fundação Universidade de Brasília - UNB";
            case "HOSPITAL UNIVERSITARIO DE BRASILIA - HUB" -> "Hospital Universitário de Brasília - HUB";
            case "CENTRO DE APOIO AO DESENVOLV. TECNOLOGICO-CDT" ->
                    "Centro de Apoio ao Desenvolvimento Tecnológico - CDT";
            case "CENTRO DE SEL.E DE PROM DE EVENTOS (CESPE)" -> "Centro de Seleção e de Promoção de Eventos - CESPE";
            case "EDITORA UNIVERSIDADE DE BRASILIA - EDU" -> "Editora Universidade de Brasília - EDU";
            case "UNIVERSIDADE FEDERAL DA BAHIA" -> "Universidade Federal da Bahia";
            case "COMPLEXO HOSPITALAR E DE SAUDE DA UFBA" -> "Complexo Hospitalar e de Saúde da UFBA";
            case "COMPLEXO HOSP UNIVERS PROF EDGARD SANTOS" ->
                    "Complexo Hospitalar Universitário Professor Edgard Santos";
            case "UNIVERSIDADE FEDERAL DE SANTA CATARINA" -> "Universidade Federal de Santa Catarina";
            case "HOSPITAL UNIVERSITARIO - UFSC" -> "Hospital Universitário - UFSC";
            case "UNIVERSIDADE FEDERAL DA PARAIBA" -> "Universidade Federal da Paraíba";
            case "SUPERINTENDENCIA DE ORCAMENTO E FINANCAS/UFPB" -> "Superintendência de Orçamento e Finanças/UFPB";
            case "CENTRO DE CIENC.HUMA. SOC. E AGRARIAS DA UFPB" ->
                    "Centro de Ciências Humanas, Sociais e Agrárias da UFPB";
            case "CENTRO DE CIENCIAS AGRARIAS DA UFPB" -> "Centro de Ciências Agrárias da UFPB";
            case "UNIVERSIDADE FEDERAL DE PERNAMBUCO" -> "Universidade Federal de Pernambuco";
            case "HOSPITAL DAS CLINICAS - UFPE" -> "Hospital das Clínicas - UFPE";
            case "SUPERINTENDENCIA DE INFRAESTRUTURA DA UFPE" -> "Superintendência de Infraestrutura da UFPE";
            case "PRO-REITORIA DE ASSUNTOS ESTUDANTIS - PROAES" -> "Pró-Reitoria de Assuntos Estudantis - PROAES";
            case "DIRET.DO CENTRO DE EDUCACAO DA UFPE" -> "Diretoria do Centro de Educação da UFPE";
            case "PROREITORIA DE GESTAO ADMINISTRATIVA" -> "Pró-Reitoria de Gestão Administrativa";
            case "SUPERINTENDENCIA DE SEGURANCA INSTITUCIONAL" -> "Superintendência de Segurança Institucional";
            case "CENTRO ACADEMICO DO AGRESTE DA UFPE" -> "Centro Acadêmico do Agreste da UFPE";
            case "PRO-REITORIA DE PESQUISA E INOVACAO-PROPESQI" -> "Pró-Reitoria de Pesquisa e Inovação - PROPESQI";
            case "DIRETORIA DO CENTRO DE INFORMATICA - UFPE" -> "Diretoria do Centro de Informática - UFPE";
            case "SUPERINTENDENCIA DE TECNOLOGIA DA INFORMACAO" -> "Superintendência de Tecnologia da Informação";
            case "PRO-REITORIA DE EXTENSAO" -> "Pró-Reitoria de Extensão";
            case "DIRET.CENTRO DE FILOSOFIA E C.HUMANAS - UFPE" ->
                    "Diretoria do Centro de Filosofia e Ciências Humanas - UFPE";
            case "DIRET.DO CENTRO DE TECNOLOGIA DA UFPE" -> "Diretoria do Centro de Tecnologia da UFPE";
            case "CENTRO ACADEMICO VITORIA DE SANTO ANTAO-UFPE" -> "Centro Acadêmico Vitória de Santo Antão - UFPE";
            case "DIRET.DO CENTRO DE ARTES E COMUNICACAO-UFPE" -> "Diretoria do Centro de Artes e Comunicação - UFPE";
            case "PRO-REIT.GEST.DE PESSOAS E QUAL.VIDA-PROGEPE" ->
                    "Pró-Reitoria de Gestão de Pessoas e Qualidade de Vida - PROGEPE";
            case "PRO-REITORIA DE POS-GRADUACAO." -> "Pró-Reitoria de Pós-Graduação";
            case "DIRET.DO CENTRO DE CIENCIAS DA SAUDE DA UFPE" -> "Diretoria do Centro de Ciências da Saúde da UFPE";
            case "COLEGIO DE APLICACAO DA UFPE" -> "Colégio de Aplicação da UFPE";
            case "DIRET.CENTRO DE CIENCIAS SOC.APLICADAS- UFPE" ->
                    "Diretoria do Centro de Ciências Sociais Aplicadas - UFPE";
            case "BIBLIOTECA CENTRAL DA UFPE" -> "Biblioteca Central da UFPE";
            case "CENTRO DE CIENCIAS MEDICAS DA UFPE-CCM" -> "Centro de Ciências Médicas da UFPE - CCM";
            case "CENTRO DE BIOCIENCIAS DA UFPE" -> "Centro de Biociências da UFPE";
            case "DIRET.DO CENTRO DE CIENC.EXATAS E NAT.DA UFPE" ->
                    "Diretoria do Centro de Ciências Exatas e da Natureza da UFPE";
            case "EDITORA UNIVERSITARIA DA UFPE" -> "Editora Universitária da UFPE";
            case "2IRET.DO CENTRO DE CIENCIAS JURIDICAS - UFPE" -> "Diretoria do Centro de Ciências Jurídicas - UFPE";
            case "SUPERINTENDENCIA DE COMUNICACAO DA UFPE." -> "Superintendência de Comunicação da UFPE";
            case "PRO-REITORIA DE PLAN. ORCAMENTARIO E FINANCAS" ->
                    "Pró-Reitoria de Planejamento Orçamentário e Finanças";
            case "INSTITUTO KEIZO ASAMI - ILIKA" -> "Instituto Keizo Asami - ILIKA";
            case "UNIVERSIDADE FEDERAL DO PARANA" -> "Universidade Federal do Paraná";
            case "HOSPITAL DE CLINICAS DA UFPR" -> "Hospital de Clínicas da UFPR";
            case "UNIVERSIDADE FEDERAL DO RIO GRANDE DO NORTE" -> "Universidade Federal do Rio Grande do Norte";
            case "UFRN - COMPLEXO HOSPITALAR DE SAUDE" -> "UFRN - Complexo Hospitalar de Saúde";
            case "CENTRO DE CIENCIAS DA SAUDE DA UFRN" -> "Centro de Ciências da Saúde da UFRN";
            case "CENTRO DE ENSINO SUPERIOR DO SERIDO/UFRN" -> "Centro de Ensino Superior do Seridó/UFRN";
            case "CENTRO DE BIOCIENCIAS DA UFRN" -> "Centro de Biociências da UFRN";
            case "CENTRO DE CIENCIAS HUM.E LETRAS ARTES DA UFRN" ->
                    "Centro de Ciências Humanas, Letras e Artes da UFRN";
            case "CENTRO DE CIENCIAS SOCIAIS APLICADAS DA UFRN" -> "Centro de Ciências Sociais Aplicadas da UFRN";
            case "HOSPITAL DE CLINICAS DE PORTO ALEGRE" -> "Hospital de Clínicas de Porto Alegre";
            case "UNIVERSIDADE FEDERAL DO CEARA" -> "Universidade Federal do Ceará";
            case "HOSPITAL UNIVERSITARIO WALTER CANTIDIO" -> "Hospital Universitário Walter Cantídio";
            case "MATERNIDADE ESCOLA ASSIS CHATEAUBRIAND" -> "Maternidade Escola Assis Chateaubriand";
            case "UNIVERSIDADE FEDERAL DO PARA" -> "Universidade Federal do Pará";
            case "HOSPITAL UNIVERSITARIO BETTINA FERRO DE SOUZA" -> "Hospital Universitário Bettina Ferro de Souza";
            case "HOSPITAL UNIVERSITARIO JOAO DE BARROS BARRETO" -> "Hospital Universitário João de Barros Barreto";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE UBERLANDIA" -> "Fundação Universidade Federal de Uberlândia";
            case "HOSPITAL DE CLINICAS DA UFU" -> "Hospital de Clínicas da UFU";
            case "UNIVERSIDADE FEDERAL DE SANTA MARIA" -> "Universidade Federal de Santa Maria";
            case "UNIVERSIDADE FEDERAL DE SANTA MARIA - HUSM" -> "Universidade Federal de Santa Maria - HUSM";
            case "UNIFESP-UNIVERSIDADE FEDERAL DE SAO PAULO" -> "UNIFESP - Universidade Federal de São Paulo";
            case "UNIFESP-HOSP. UNIVERSITARIO" -> "UNIFESP - Hospital Universitário";
            case "UNIVERSIDADE FEDERAL DE GOIAS" -> "Universidade Federal de Goiás";
            case "HOSPITAL DAS CLINICAS DA UFGO" -> "Hospital das Clínicas da UFGO";
            case "SUBSECRETARIA DE GESTAO ADMINISTRATIVA/MEC" -> "Subsecretaria de Gestão Administrativa/MEC";
            case "SECRETARIA DE EDUCACAO SUPERIOR" -> "Secretaria de Educação Superior";
            case "INSTITUTO NACIONAL DE EDUCACAO DE SURDOS-RJ" -> "Instituto Nacional de Educação de Surdos - RJ";
            case "SUBSECRETARIA DE TEC. DA INF. E COMUNICACAO" ->
                    "Subsecretaria de Tecnologia da Informação e Comunicação";
            case "INSTITUTO BENJAMIN CONSTANT-RJ" -> "Instituto Benjamin Constant - RJ";
            case "SECR. ED. CONT, ALF. DE JV E AD, DIV. E INC" ->
                    "Secretaria de Educação Continuada, Alfabetização, Diversidade e Inclusão";
            case "SECRETARIA DE EDUCACAO BASICA" -> "Secretaria de Educação Básica";
            case "SECRETARIA DE ART. INT. C/ OS SIST. DE ENSINO" ->
                    "Secretaria de Articulação com os Sistemas de Ensino";
            case "SECRETARIA DE EDUCACAO BASICA/ACORDO BIRD" -> "Secretaria de Educação Básica/Acordo BIRD";
            case "SECRETARIA DE EDUC.PROFISSIONAL E TECNOLOGICA" -> "Secretaria de Educação Profissional e Tecnológica";
            case "SECRETARIA REG. E SUPERVISAO DA ED. SUPERIOR" ->
                    "Secretaria de Regulação e Supervisão da Educação Superior";
            case "INSTITUTO FEDERAL DE SAO PAULO" -> "Instituto Federal de São Paulo";
            case "IFSP - CAMPUS SAO PAULO" -> "IFSP - Campus São Paulo";
            case "IFSP - CAMPUS AVARE" -> "IFSP - Campus Avaré";
            case "IFSP - CAMPUS HORTOLANDIA" -> "IFSP - Campus Hortolândia";
            case "IFSP - CAMPUS BARRETOS" -> "IFSP - Campus Barretos";
            case "IFSP - CAMPUS ITAPETININGA" -> "IFSP - Campus Itapetininga";
            case "IFSP - CAMPUS SAO JOSE DOS CAMPOS" -> "IFSP - Campus São José dos Campos";
            case "IFSP - CAMPUS ARARAQUARA" -> "IFSP - Campus Araraquara";
            case "IFSP - CAMPUS CUBATAO" -> "IFSP - Campus Cubatão";
            case "IFSP - CAMPUS SERTAOZINHO" -> "IFSP - Campus Sertãozinho";
            case "IFSP - CAMPUS SAO ROQUE" -> "IFSP - Campus São Roque";
            case "IFSP - CAMPUS SUZANO" -> "IFSP - Campus Suzano";
            case "IFSP - CAMPUS CATANDUVA" -> "IFSP - Campus Catanduva";
            case "IFSP - CAMPUS MATAO" -> "IFSP - Campus Matão";
            case "IFSP - CAMPUS VOTUPORANGA" -> "IFSP - Campus Votuporanga";
            case "IFSP - CAMPUS BIRIGUI" -> "IFSP - Campus Birigui";
            case "IFSP - CAMPUS SAO PAULO PIRITUBA" -> "IFSP - Campus São Paulo Pirituba";
            case "IFSP - CAMPUS SALTO" -> "IFSP - Campus Salto";
            case "IFSP - CAMPUS BOITUVA" -> "IFSP - Campus Boituva";
            case "IFSP - CAMPUS SAO JOAO DA BOA VISTA" -> "IFSP - Campus São João da Boa Vista";
            case "IFSP - CAMPUS PIRACICABA" -> "IFSP - Campus Piracicaba";
            case "IFSP - CAMPUS PRESIDENTE EPITACIO" -> "IFSP - Campus Presidente Epitácio";
            case "IFSP - CAMPUS JACAREI" -> "IFSP - Campus Jacareí";
            case "IFSP - CAMPUS SOROCABA" -> "IFSP - Campus Sorocaba";
            case "IFSP - CAMPUS CAMPINAS" -> "IFSP - Campus Campinas";
            case "IFSP - CAMPUS ITAQUAQUECETUBA" -> "IFSP - Campus Itaquaquecetuba";
            case "IFSP - CAMPUS GUARULHOS" -> "IFSP - Campus Guarulhos";
            case "IFSP - CAMPUS REGISTRO" -> "IFSP - Campus Registro";
            case "IFSP - CAMPUS SAO CARLOS" -> "IFSP - Campus São Carlos";
            case "IFSP - CAMPUS CARAGUATATUBA" -> "IFSP - Campus Caraguatatuba";
            case "IFSP - CAMPUS CAPIVARI" -> "IFSP - Campus Capivari";
            case "IFSP - CAMPUS BRAGANCA PAULISTA" -> "IFSP - Campus Bragança Paulista";
            case "IFSP - CAMPUS CAMPOS DO JORDAO" -> "IFSP - Campus Campos do Jordão";
            case "IFSP - CAMPUS SAO JOSE DO RIO PRETO" -> "IFSP - Campus São José do Rio Preto";
            case "UNIVERSIDADE FEDERAL DE JUIZ DE FORA" -> "Universidade Federal de Juiz de Fora";
            case "HOSPITAL UNIVERSITARIO" -> "Hospital Universitário";
            case "UNIVERSIDADE FEDERAL DO ESPIRITO SANTO" -> "Universidade Federal do Espírito Santo";
            case "HOSPITAL UNIVERSITARIO C. ANTONIO MORAIS/UFES" ->
                    "Hospital Universitário Cassiano Antônio Moraes/UFES";
            case "RESTAURANTE CENTRAL DA UFES" -> "Restaurante Central da UFES";
            case "UFES - COORDENACAO DE ADM. SUL ESPIRITO SANTO" ->
                    "UFES - Coordenação de Administração Sul Espírito Santo";
            case "CENTRO UNIVERSITARIO NORTE DO ESPIRITO SANTO." -> "Centro Universitário Norte do Espírito Santo";
            case "UNIVERSIDADE TECNOLOGICA FEDERAL DO PARANA" -> "Universidade Tecnológica Federal do Paraná";
            case "UTFPR - CAMPUS CURITIBA" -> "UTFPR - Campus Curitiba";
            case "UTFPR - CAMPUS PATO BRANCO" -> "UTFPR - Campus Pato Branco";
            case "UTFPR - CAMPUS CORNELIO PROCOPIO" -> "UTFPR - Campus Cornélio Procópio";
            case "UTFPR - CAMPUS DOIS VIZINHOS" -> "UTFPR - Campus Dois Vizinhos";
            case "UTFPR - CAMPUS GUARAPUAVA" -> "UTFPR - Campus Guarapuava";
            case "UTFPR - CAMPUS MEDIANEIRA" -> "UTFPR - Campus Medianeira";
            case "UTFPR - CAMPUS TOLEDO" -> "UTFPR - Campus Toledo";
            case "UTFPR - CAMPUS CAMPO MOURAO" -> "UTFPR - Campus Campo Mourão";
            case "UTFPR - CAMPUS LONDRINA" -> "UTFPR - Campus Londrina";
            case "UTFPR - CAMPUS PONTA GROSSA" -> "UTFPR - Campus Ponta Grossa";
            case "CAMPUS APUCARANA" -> "Campus Apucarana";
            case "UTFPR- CAMPUS FRANCISCO BELTRAO" -> "UTFPR - Campus Francisco Beltrão";
            case "UTFPR CAMPUS SANTA HELENA" -> "UTFPR - Campus Santa Helena";
            case "UNIVERSIDADE FEDERAL DE ALAGOAS" -> "Universidade Federal de Alagoas";
            case "FUNDACAO UNIV.FED. DE MATO GROSSO DO SUL" -> "Fundação Universidade Federal de Mato Grosso do Sul";
            case "PROGRAMA DE ASSISTENCIA A SAUDE DA UFMS" -> "Programa de Assistência à Saúde da UFMS";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO MARANHAO" -> "Fundação Universidade Federal do Maranhão";
            case "UNIVERSIDADE FEDERAL DE VICOSA" -> "Universidade Federal de Viçosa";
            case "UFV - CAMPUS FLORESTAL" -> "UFV - Campus Florestal";
            case "CENTRAL DE EXP.PESQ.E EXT.DO TRIANG.MIN./UFV" ->
                    "Central de Experimentação, Pesquisa e Extensão do Triângulo Mineiro/UFV";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE MATO GROSSO" -> "Fundação Universidade Federal de Mato Grosso";
            case "HOSPITAL UNIVERSITARIO JULIO MULLER DA FUFMT" -> "Hospital Universitário Júlio Muller da FUFMT";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO CEARA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Ceará";
            case "CAMPUS FORTALEZA/IFCE" -> "Campus Fortaleza/IFCE";
            case "CAMPUS MARACANAU/IFCE" -> "Campus Maracanaú/IFCE";
            case "CAMPUS MARANGUAPE/IFCE" -> "Campus Maranguape/IFCE";
            case "CAMPUS JUAZEIRO DO NORTE/IFCE" -> "Campus Juazeiro do Norte/IFCE";
            case "CAMPUS CRATEUS/IFCE" -> "Campus Crateús/IFCE";
            case "CAMPUS SOBRAL/IFCE" -> "Campus Sobral/IFCE";
            case "CAMPUS IGUATU/IFCE" -> "Campus Iguatu/IFCE";
            case "CAMPUS CRATO/IFCE" -> "Campus Crato/IFCE";
            case "CAMPUS LIMOEIRO DO NORTE/IFCE" -> "Campus Limoeiro do Norte/IFCE";
            case "CAMPUS CEDRO/IFCE" -> "Campus Cedro/IFCE";
            case "CAMPUS TABULEIRO DO NORTE/IFCE" -> "Campus Tabuleiro do Norte/IFCE";
            case "CAMPUS BOA VIAGEM/IFCE" -> "Campus Boa Viagem/IFCE";
            case "CAMPUS ARACATI/IFCE" -> "Campus Aracati/IFCE";
            case "CAMPUS CAUCAIA/IFCE" -> "Campus Caucaia/IFCE";
            case "CAMPUS QUIXADA/IFCE" -> "Campus Quixadá/IFCE";
            case "CAMPUS TAUA/IFCE" -> "Campus Tauá/IFCE";
            case "CAMPUS ACOPIARA/IFCE" -> "Campus Acopiara/IFCE";
            case "CAMPUS CANINDE/IFCE" -> "Campus Canindé/IFCE";
            case "CAMPUS UMIRIM/IFCE" -> "Campus Umirim/IFCE";
            case "CAMPUS ACARAU/IFCE" -> "Campus Acaraú/IFCE";
            case "CAMPUS TIANGUA/IFCE" -> "Campus Tianguá/IFCE";
            case "CAMPUS ITAPIPOCA/IFCE" -> "Campus Itapipoca/IFCE";
            case "CAMPUS BATURITE/IFCE" -> "Campus Baturité/IFCE";
            case "CAMPUS JAGUARIBE/IFCE" -> "Campus Jaguaribe/IFCE";
            case "CAMPUS MORADA NOVA/IFCE" -> "Campus Morada Nova/IFCE";
            case "CAMPUS CAMOCIM/IFCE" -> "Campus Camocim/IFCE";
            case "CAMPUS PARACURU/IFCE" -> "Campus Paracuru/IFCE";
            case "CAMPUS UBAJARA/IFCE" -> "Campus Ubajara/IFCE";
            case "CAMPUS PECEM/IFCE" -> "Campus Pecém/IFCE";
            case "CAMPUS HORIZONTE/IFCE" -> "Campus Horizonte/IFCE";
            case "INST.NACIONAL DE EST.E PESQUISAS EDUCACIONAIS" ->
                    "Instituto Nacional de Estudos e Pesquisas Educacionais";
            case "FUNDACAO UNIVERSIDADE DO AMAZONAS" -> "Fundação Universidade do Amazonas";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE SERGIPE" -> "Fundação Universidade Federal de Sergipe";
            case "HOSPITAL UNIVERSITARIO DA FUFSE" -> "Hospital Universitário da FUFSE";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE PELOTAS" -> "Fundação Universidade Federal de Pelotas";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO PIAUI" -> "Fundação Universidade Federal do Piauí";
            case "HOSPITAL UNIVERSITARIO DA UFPI" -> "Hospital Universitário da UFPI";
            case "INST. FED. DO MARANHAO" -> "Instituto Federal do Maranhão";
            case "IFMA/CAMPUS MONTE CASTELO" -> "IFMA/Campus Monte Castelo";
            case "IFMA/CAMPUS S.R.MANGABEIRAS" -> "IFMA/Campus São Raimundo Mangabeiras";
            case "IFMA/CAMPUS CODO" -> "IFMA/Campus Codó";
            case "IFMA/CAMPUS CAXIAS" -> "IFMA/Campus Caxias";
            case "IFMA/CAMPUS MACARANA" -> "IFMA/Campus Macarana";
            case "IFMA/CAMPUS ZE DOCA" -> "IFMA/Campus Zé Doca";
            case "IFMA/CAMPUS TIMON" -> "IFMA/Campus Timon";
            case "IFMA/CAMPUS B.DO CORDA" -> "IFMA/Campus Barra do Corda";
            case "IFMA/CAMPUS COELHO NETO" -> "IFMA/Campus Coelho Neto";
            case "IFMA/CAMPUS IMPERATRIZ" -> "IFMA/Campus Imperatriz";
            case "IFMA/CAMPUS C.HISTORICO" -> "IFMA/Campus Centro Histórico";
            case "IFMA/CAMPUS PEDREIRAS" -> "IFMA/Campus Pedreiras";
            case "IFMA/CAMPUS SANTA INES" -> "IFMA/Campus Santa Inês";
            case "IFMA/CAMPUS ACAILANDIA" -> "IFMA/Campus Açailândia";
            case "IFMA/CAMPUS PRES.DUTRA" -> "IFMA/Campus Presidente Dutra";
            case "IFMA/CAMPUS GRAJAU" -> "IFMA/Campus Grajaú";
            case "IFMA/CAMPUS S.JOAO DOS PATOS" -> "IFMA/Campus São João dos Patos";
            case "IFMA/CAMPUS BARREIRINHAS" -> "IFMA/Campus Barreirinhas";
            case "IFMA/CAMPUS BURITICUPU" -> "IFMA/Campus Buriticupu";
            case "IFMA/CAMPUS BACABAL" -> "IFMA/Campus Bacabal";
            case "IFMA/CAMPUS PINHEIRO" -> "IFMA/Campus Pinheiro";
            case "IFMA/CAMPUS ITAPECURU MIRIM" -> "IFMA/Campus Itapecuru Mirim";
            case "IFMA/CAMPUS SJ DE RIBAMAR" -> "IFMA/Campus São José de Ribamar";
            case "IFMA/CAMPUS ALCANTARA" -> "IFMA/Campus Alcântara";
            case "IFMA/CAMPUS VIANA" -> "IFMA/Campus Viana";
            case "IFMA/CAMPUS ARAIOSES" -> "IFMA/Campus Araioses";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO ESP.SANTO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Espírito Santo";
            case "INST.FED. ESPIRITO SANTO/CAMPUS VITORIA" -> "Instituto Federal Espírito Santo/Campus Vitória";
            case "INST.FED. ESPIRITO SANTO/CAMPUS ALEGRE" -> "Instituto Federal Espírito Santo/Campus Alegre";
            case "INST.FED. ESPIRITO SANTO/CAMPUS ITAPINA" -> "Instituto Federal Espírito Santo/Campus Itapina";
            case "INST.FED. ESPIRITO SANTO/CAMPUS SANTA TERESA" ->
                    "Instituto Federal Espírito Santo/Campus Santa Teresa";
            case "INST.FED. ESPIRITO SANTO/CAMPUS NOVA VENECIA" ->
                    "Instituto Federal Espírito Santo/Campus Nova Venécia";
            case "IFES/CAMPUS PIUMA" -> "IFES/Campus Piuma";
            case "INST.FED. ESPIRITO SANTO/CAMPUS CACHOEIRO" -> "Instituto Federal Espírito Santo/Campus Cachoeiro";
            case "INST.FED.ESPIRITO SANTO/CAMPUS MONTANHA" -> "Instituto Federal Espírito Santo/Campus Montanha";
            case "INST.FED. ESPIRITO SANTO/CAMPUS V.N. DO IMIGR" ->
                    "Instituto Federal Espírito Santo/Campus Vila Nova do Imigrante";
            case "INST.FED. ESPIRITO SANTO/CAMPUS VILA VELHA" -> "Instituto Federal Espírito Santo/Campus Vila Velha";
            case "INST.FED.ESPIRITO SANTO/CAMPUS CENTRO SERRANO" ->
                    "Instituto Federal Espírito Santo/Campus Centro Serrano";
            case "INST.FED. ESPIRITO SANTO/CAMPUS SERRA" -> "Instituto Federal Espírito Santo/Campus Serra";
            case "INST.FED. ESPIRITO SANTO/CAMPUS CARIACICA" -> "Instituto Federal Espírito Santo/Campus Cariacica";
            case "INST.FED. ESPIRITO SANTO/CAMPUS ARACRUZ" -> "Instituto Federal Espírito Santo/Campus Aracruz";
            case "INST.FED.DO ESPIRITO SANTO/CAMPUS GUARAPARI" -> "Instituto Federal Espírito Santo/Campus Guarapari";
            case "INST.FED. ESPIRITO SANTO/CAMPUS SAO MATEUS" -> "Instituto Federal Espírito Santo/Campus São Mateus";
            case "INST.FED. ESPIRITO SANTO/CAMPUS COLATINA" -> "Instituto Federal Espírito Santo/Campus Colatina";
            case "INST.FED.ESPIRITO SANTO/CAMPUS BARRA SAO FRAN" ->
                    "Instituto Federal Espírito Santo/Campus Barra de São Francisco";
            case "INST.FED. ESPIRITO SANTO/CAMPUS LINHARES" -> "Instituto Federal Espírito Santo/Campus Linhares";
            case "INST.FED. ESPIRITO SANTO/CAMPUS IBATIBA" -> "Instituto Federal Espírito Santo/Campus Ibatiba";
            case "UNIVERSIDADE FEDERAL DE CAMPINA GRANDE" -> "Universidade Federal de Campina Grande";
            case "HOSPITAL UNIVERSITARIO ALCIDES CARNEIRO/UFCG" -> "Hospital Universitário Alcides Carneiro/UFCG";
            case "CENTRO DE FORMACAO DE PROFESSORES DA UFCG" -> "Centro de Formação de Professores da UFCG";
            case "CENTRO DE SAUDE E TECNOLOGIA RURAL DA UFCG" -> "Centro de Saúde e Tecnologia Rural da UFCG";
            case "CENTRO DE EDUCACAO E SAUDE DA UFCG" -> "Centro de Educação e Saúde da UFCG";
            case "CENTRO DESENV SUSTENTAVEL DO SEMIARIDO-UFCG" ->
                    "Centro de Desenvolvimento Sustentável do Semiárido-UFCG";
            case "CENTRO DE CIENCIAS JURIDICAS E SOCIAIS/UFCG" -> "Centro de Ciências Jurídicas e Sociais/UFCG";
            case "CENTRO DE CIENCIAS E TECNOLOGIA AGROALIMENTAR" -> "Centro de Ciências e Tecnologia Agroalimentar";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO RN" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Norte";
            case "INST.FED.DO RN/CAMPUS NATAL - CENTRAL" ->
                    "Instituto Federal do Rio Grande do Norte/Campus Natal - Central";
            case "INST.FED. DO RN/CAMPUS CAICO" -> "Instituto Federal do Rio Grande do Norte/Campus Caicó";
            case "INST. FED. DO RN / CAMPUS PARNAMIRIM" -> "Instituto Federal do Rio Grande do Norte/Campus Parnamirim";
            case "INST.FED DO RN/CAMPUS MOSSORO" -> "Instituto Federal do Rio Grande do Norte/Campus Mossoró";
            case "INST.FED.DO RN/CAMPUS PAU DOS FERROS" ->
                    "Instituto Federal do Rio Grande do Norte/Campus Pau dos Ferros";
            case "INST.FED.DO RN/CAMPUS MACAU" -> "Instituto Federal do Rio Grande do Norte/Campus Macau";
            case "INST. FED. DO RN / CAMPUS NATAL - CIDADE ALTA" ->
                    "Instituto Federal do Rio Grande do Norte/Campus Natal - Cidade Alta";
            case "INST.FED.DO RN/CAMPUS NATAL - ZONA NORTE" ->
                    "Instituto Federal do Rio Grande do Norte/Campus Natal - Zona Norte";
            case "INST.FED.DO RN/CAMPUS IPANGUACU" -> "Instituto Federal do Rio Grande do Norte/Campus Ipanguaçu";
            case "INST.FED.DO RN/CAMPUS APODI" -> "Instituto Federal do Rio Grande do Norte/Campus Apodi";
            case "INST.FED. DO RN/CAMPUS CURRAIS NOVOS" ->
                    "Instituto Federal do Rio Grande do Norte/Campus Currais Novos";
            case "INST.FED.DO RN/CAMPUS JOAO CAMARA" -> "Instituto Federal do Rio Grande do Norte/Campus João Câmara";
            case "INST FED RN / CAMPUS SAO GONCALO DO AMARANTE" ->
                    "Instituto Federal do Rio Grande do Norte/Campus São Gonçalo do Amarante";
            case "INST.FED.DO RN/CAMPUS SANTA CRUZ" -> "Instituto Federal do Rio Grande do Norte/Campus Santa Cruz";
            case "CPST FED RN / CAMPUS CANGUARETAMA" -> "Instituto Federal do Rio Grande do Norte/Campus Canguaretama";
            case "INST FED RN / CAMPUS CEARA-MIRIM" -> "Instituto Federal do Rio Grande do Norte/Campus Ceará-Mirim";
            case "INSTITUTO FEDERAL DO RN - CAMPUS NOVA CRUZ" ->
                    "Instituto Federal do Rio Grande do Norte/Campus Nova Cruz";
            case "INST FED RN / CAMPUS SAO PAULO DO POTENGI" ->
                    "Instituto Federal do Rio Grande do Norte/Campus São Paulo do Potengi";
            case "UNIVERSIDADE FEDERAL RURAL DO RIO DE JANEIRO" -> "Universidade Federal Rural do Rio de Janeiro";
            case "COLEGIO PEDRO II" -> "Colégio Pedro II";
            case "COLEGIO PEDRO II - CAMPUS REALENGO II" -> "Colégio Pedro II/Campus Realengo II";
            case "COLEGIO PEDRO II - CAMPUS ENGENHO NOVO II" -> "Colégio Pedro II/Campus Engenho Novo II";
            case "COLEGIO PEDRO II - CAMPUS SAO CRISTOVAO III" -> "Colégio Pedro II/Campus São Cristóvão III";
            case "COLEGIO PEDRO II - CAMPUS TIJUCA II" -> "Colégio Pedro II/Campus Tijuca II";
            case "COLEGIO PEDRO II - CAMPUS TIJUCA I" -> "Colégio Pedro II/Campus Tijuca I";
            case "COLEGIO PEDRO II - CAMPUS HUMAITA I" -> "Colégio Pedro II/Campus Humaitá I";
            case "COLEGIO PEDRO II - CAMPUS REALENGO I" -> "Colégio Pedro II/Campus Realengo I";
            case "COLEGIO PEDRO II - CAMPUS CENTRO" -> "Colégio Pedro II/Campus Centro";
            case "COLEGIO PEDRO II - CAMPUS SAO CRISTOVAO I" -> "Colégio Pedro II/Campus São Cristóvão I";
            case "COLEGIO PEDRO II - CAMPUS DUQUE DE CAXIAS" -> "Colégio Pedro II/Campus Duque de Caxias";
            case "COLEGIO PEDRO II - CAMPUS SAO CRISTOVAO II" -> "Colégio Pedro II/Campus São Cristóvão II";
            case "COLEGIO PEDRO II - CAMPUS HUMAITA II" -> "Colégio Pedro II/Campus Humaitá II";
            case "COLEGIO PEDRO II - CAMPUS NITEROI" -> "Colégio Pedro II/Campus Niterói";
            case "COLEGIO PEDRO II - CAMPUS ENGENHO NOVO I" -> "Colégio Pedro II/Campus Engenho Novo I";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE SAO CARLOS" -> "Fundação Universidade Federal de São Carlos";
            case "FUFSCAR - SIN" -> "FUFSCAR - São Carlos";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DA BAHIA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia da Bahia";
            case "INST. FED. DA BAHIA/CAMPUS VIT. DA CONQUISTA" ->
                    "Instituto Federal da Bahia/Campus Vitória da Conquista";
            case "INST. FED. DA BAHIA/CAMPUS SALVADOR" -> "Instituto Federal da Bahia/Campus Salvador";
            case "INST. FED.DA BAHIA/CAMPUS SIMOES FILHO" -> "Instituto Federal da Bahia/Campus Simões Filho";
            case "INST. FED. DA BAHIA/CAMPUS BARREIRAS" -> "Instituto Federal da Bahia/Campus Barreiras";
            case "INST. FED. DA BAHIA/CAMPUS VALENCA" -> "Instituto Federal da Bahia/Campus Valença";
            case "INST. FED. DA BAHIA/CAMPUS PORTO SEGURO" -> "Instituto Federal da Bahia/Campus Porto Seguro";
            case "INST. FED. DA BAHIA/CAMPUS IRECE" -> "Instituto Federal da Bahia/Campus Irecê";
            case "INST. FED. DA BAHIA/CAMPUS SANTO AMARO" -> "Instituto Federal da Bahia/Campus Santo Amaro";
            case "INST. FED. DA BAHIA/CAMPUS CAMACARI" -> "Instituto Federal da Bahia/Campus Camaçari";
            case "INST. FED. DA BAHIA/CAMPUS JEQUIE" -> "Instituto Federal da Bahia/Campus Jequié";
            case "INST. FED. DA BAHIA/CAMPUS FEIRA DE SANTANA" -> "Instituto Federal da Bahia/Campus Feira de Santana";
            case "INST. FED. DA BAHIA/CAMPUS PAULO AFONSO" -> "Instituto Federal da Bahia/Campus Paulo Afonso";
            case "INST. FED. DA BAHIA/CAMPUS SEABRA" -> "Instituto Federal da Bahia/Campus Seabra";
            case "INST. FED. DA BAHIA/CAMPUS JACOBINA" -> "Instituto Federal da Bahia/Campus Jacobina";
            case "INTITUTO FEDERAL DA BAHIA-JUAZEIRO" -> "Instituto Federal da Bahia/Campus Juazeiro";
            case "INSTITUTO FEDERAL DA BAHIA-BRUMADO" -> "Instituto Federal da Bahia/Campus Brumado";
            case "INST. FED. DA BAHIA/CAMPUS EUNAPOLIS" -> "Instituto Federal da Bahia/Campus Eunápolis";
            case "INSTITUTO FEDERAL DA BAHIA- STO ANTONIO JESUS" ->
                    "Instituto Federal da Bahia/Campus Santo Antônio de Jesus";
            case "INST. FED. DA BAHIA/CAMPUS ILHEUS" -> "Instituto Federal da Bahia/Campus Ilhéus";
            case "UNIVERSIDADE FEDERAL RURAL DE PERNAMBUCO" -> "Universidade Federal Rural de Pernambuco";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE STA.CAT/IFSC" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Santa Catarina";
            case "IFPB - REITORIA" -> "IFPB - Reitoria";
            case "IFPB - CAMPUS JOAO PESSOA" -> "IFPB - Campus João Pessoa";
            case "IFPB - CAMPUS CAMPINA GRANDE" -> "IFPB - Campus Campina Grande";
            case "IFPB - CAMPUS SOUSA" -> "IFPB - Campus Sousa";
            case "IFPB - CAMPUS CAJAZEIRAS" -> "IFPB - Campus Cajazeiras";
            case "IFPB - CAMPUS PATOS" -> "IFPB - Campus Patos";
            case "IFPB - CAMPUS SANTA LUZIA" -> "IFPB - Campus Santa Luzia";
            case "IFPB - CAMPUS MONTEIRO" -> "IFPB - Campus Monteiro";
            case "IFPB - CAMPUS CATOLE DO ROCHA" -> "IFPB - Campus Catolé do Rocha";
            case "IFPB - CAMPUS CABEDELO" -> "IFPB - Campus Cabedelo";
            case "IFPB - CAMPUS PICUI" -> "IFPB - Campus Picuí";
            case "IFPB - CAMPUS GUARABIRA" -> "IFPB - Campus Guarabira";
            case "IFPB - CAMPUS PRINCESA ISABEL" -> "IFPB - Campus Princesa Isabel";
            case "IFPB - CAMPUS ESPERANCA" -> "IFPB - Campus Esperança";
            case "IFPB - CAMPUS ITABAIANA" -> "IFPB - Campus Itabaiana";
            case "IFPB - CAMPUS ITAPORANGA" -> "IFPB - Campus Itaporanga";
            case "IFPB - CAMPUS SANTA RITA" -> "IFPB - Campus Santa Rita";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE PERNAMBUCO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Pernambuco";
            case "IFPE - CAMPUS RECIFE" -> "IFPE - Campus Recife";
            case "IFPE - CAMPUS VITORIA DE SANTO ANTAO" -> "IFPE - Campus Vitória de Santo Antão";
            case "IFPE - CAMPUS BARREIROS" -> "IFPE - Campus Barreiros";
            case "IFPE - CAMPUS BELO JARDIM" -> "IFPE - Campus Belo Jardim";
            case "IFPE - CAMPUS CARUARU" -> "IFPE - Campus Caruaru";
            case "IFPE - CAMPUS CABO DE SANTO AGOSTINHO" -> "IFPE - Campus Cabo de Santo Agostinho";
            case "IFPE - CAMPUS AFOGADOS DA INGAZEIRA" -> "IFPE - Campus Afogados da Ingazeira";
            case "IFPE - CAMPUS PALMARES" -> "IFPE - Campus Palmares";
            case "IFPE - CAMPUS IGARASSU" -> "IFPE - Campus Igarassu";
            case "IFPE - CAMPUS PAULISTA" -> "IFPE - Campus Paulista";
            case "IFPE - CAMPUS GARANHUNS" -> "IFPE - Campus Garanhuns";
            case "IFPE - CAMPUS ABREU E LIMA" -> "IFPE - Campus Abreu e Lima";
            case "IFPE - CAMPUS PESQUEIRA" -> "IFPE - Campus Pesqueira";
            case "IFPE - CAMPUS OLINDA" -> "IFPE - Campus Olinda";
            case "IFPE - CAMPUS IPOJUCA" -> "IFPE - Campus Ipojuca";
            case "IFPE - CAMPUS JABOATAO DOS GUARARAPES" -> "IFPE - Campus Jaboatão dos Guararapes";
            case "UNIVERSIDADE FEDERAL DO RIO GRANDE - FURG" -> "Universidade Federal do Rio Grande";
            case "UNIRIO UNIVERSIDADE FEDERAL DO ESTADO RJ" -> "Universidade Federal do Estado do Rio de Janeiro";
            case "HOSPITAL UNIV. GAFFREE E GUINLE DA UNIRIO" -> "Hospital Universitário Gaffrée e Guinle da UNIRIO";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO PARA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Pará";
            case "INST.FED.DO PARA/CAMPUS CASTANHAL" -> "Instituto Federal do Pará/Campus Castanhal";
            case "INST.FED.DO PARA/CAMPUS BELEM" -> "Instituto Federal do Pará/Campus Belém";
            case "INST.FED.DO PARA/CAMPUS MARABA RURAL" -> "Instituto Federal do Pará/Campus Marabá Rural";
            case "INST.FED.DO PARA/CAMPUS BRAGANCA" -> "Instituto Federal do Pará/Campus Bragança";
            case "INST.FED.DO PARA/CAMPUS SANTAREM" -> "Instituto Federal do Pará/Campus Santarém";
            case "INST.FED.DO PARA/CAMPUS CONCEIC. DO ARAGUAIA" ->
                    "Instituto Federal do Pará/Campus Conceição do Araguaia";
            case "6NST.FED.DO PARA/CAMPUS BREVES" -> "Instituto Federal do Pará/Campus Breves";
            case "INST.FED.DO PARA/CAMPUS MARABA INDUSTRIAL" -> "Instituto Federal do Pará/Campus Marabá Industrial";
            case "INST.FED.DO PARA/CAMPUS TUCURUI" -> "Instituto Federal do Pará/Campus Tucuruí";
            case "INST.FED.DO PARA/CAMPUS ABAETETUBA" -> "Instituto Federal do Pará/Campus Abaetetuba";
            case "INST.FED.DO PARA/CAMPUS PARAUAPEBAS" -> "Instituto Federal do Pará/Campus Parauapebas";
            case "INST.FED.DO PARA/CAMPUS PARAGOMINAS" -> "Instituto Federal do Pará/Campus Paragominas";
            case "INST.FED.DO PARA/CAMPUS ANANINDEUA" -> "Instituto Federal do Pará/Campus Ananindeua";
            case "INST.FED.DO PARA/CAMPUS OBIDOS" -> "Instituto Federal do Pará/Campus Óbidos";
            case "INST.FED.DO PARA/CAMPUS ITAITUBA" -> "Instituto Federal do Pará/Campus Itaituba";
            case "INST.FED.DO PARA/CAMPUS ALTAMIRA" -> "Instituto Federal do Pará/Campus Altamira";
            case "INST.FED.DO PARA/CAMPUS CAMETA" -> "Instituto Federal do Pará/Campus Cametá";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO PIAUI" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Piauí";
            case "INST. FED. PIAUI/CAMPUS TERESINA CENTRAL" -> "Instituto Federal do Piauí/Campus Teresina Central";
            case "INST. FED. PIAUI/CAMPUS FLORIANO" -> "Instituto Federal do Piauí/Campus Floriano";
            case "INST. FED. PIAUI/CAMPUS TERESINA ZONA SUL" -> "Instituto Federal do Piauí/Campus Teresina Zona Sul";
            case "INST. FED. PIAUI/CAMPUS PICOS" -> "Instituto Federal do Piauí/Campus Picos";
            case "INST. FED. PIAUI/CAMPUS URUCUI" -> "Instituto Federal do Piauí/Campus Uruçuí";
            case "INST. FED. PIAUI/CAMPUS CORRENTE" -> "Instituto Federal do Piauí/Campus Corrente";
            case "INST. FED. PIAUI/CAMPUS PARNAIBA" -> "Instituto Federal do Piauí/Campus Parnaíba";
            case "INST. FED. PIAUI/CAMPUS PIRIPIRI" -> "Instituto Federal do Piauí/Campus Piripiri";
            case "INST. FED. PIAUI/CAMPUS ANGICAL DO PIAUI" -> "Instituto Federal do Piauí/Campus Angical do Piauí";
            case "INST. FED. PIAUI/CAMPUS SAO RAIMUNDO NONATO" ->
                    "Instituto Federal do Piauí/Campus São Raimundo Nonato";
            case "INST. FED. PIAUI/CAMPUS PAULISTANA" -> "Instituto Federal do Piauí/Campus Paulistana";
            case "INST. FED. PIAUI/CAMPUS OEIRAS" -> "Instituto Federal do Piauí/Campus Oeiras";
            case "INST. FED. PIAUI/CAMPUS PEDRO II" -> "Instituto Federal do Piauí/Campus Pedro II";
            case "INST. FED. PIAUI/CAMPUS VALENCA DO PIAUI" -> "Instituto Federal do Piauí/Campus Valença do Piauí";
            case "INST. FED. PIAUI/CAMPUS COCAL" -> "Instituto Federal do Piauí/Campus Cocal";
            case "INST. FED. PIAUI/CAMPUS SAO JOAO DO PIAUI" -> "Instituto Federal do Piauí/Campus São João do Piauí";
            case "INST. FED. PIAUI/CAMPUS CAMPO MAIOR" -> "Instituto Federal do Piauí/Campus Campo Maior";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO MATO GROSSO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Mato Grosso";
            case "INST.FED.MATO GROSSO/CAMPUS CUIABA" -> "Instituto Federal de Mato Grosso/Campus Cuiabá";
            case "INST.FED.MATO GROSSO/CAMPUS SAO VICENTE" -> "Instituto Federal de Mato Grosso/Campus São Vicente";
            case "INST.FED.MATO GROSSO/CAMPUS PONTES LACERDA" ->
                    "Instituto Federal de Mato Grosso/Campus Pontes e Lacerda";
            case "INST.FED.MATO GROSSO/CAMPUS CACERES" -> "Instituto Federal de Mato Grosso/Campus Cáceres";
            case "INST.FED.MATO GROSSO/CAMPUS CONFRESA" -> "Instituto Federal de Mato Grosso/Campus Confresa";
            case "INST.FED.MATO GROSSO/CAMPUS ALTA FLORESTA" -> "Instituto Federal de Mato Grosso/Campus Alta Floresta";
            case "INST.FED.MATO GROSSO/CAMPUS BELA VISTA" -> "Instituto Federal de Mato Grosso/Campus Bela Vista";
            case "INST.FED.MATO GROSSO/CAMPUS JUINA" -> "Instituto Federal de Mato Grosso/Campus Juína";
            case "INST.FED.MATO GROSSO/CAMPUS CAMPO N. PARECIS" ->
                    "Instituto Federal de Mato Grosso/Campus Campo Novo do Parecis";
            case "INST.FED.MATO GROSSO/CAMPUS PRIMAV. DO LESTE" ->
                    "Instituto Federal de Mato Grosso/Campus Primavera do Leste";
            case "INST.FED.MATO GROSSO/CAMPUS BARRA DO GARCAS" ->
                    "Instituto Federal de Mato Grosso/Campus Barra do Garças";
            case "INST.FED.MATO GROSSO/CAMPUS SORRISO" -> "Instituto Federal de Mato Grosso/Campus Sorriso";
            case "INST.FED.MATO GROSSO/CAMPUS RONDONOPOLIS" -> "Instituto Federal de Mato Grosso/Campus Rondonópolis";
            case "INST.FED.MATO GROSSO/CAMPUS VARZEA GRANDE" -> "Instituto Federal de Mato Grosso/Campus Várzea Grande";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO RS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Rio Grande do Sul";
            case "INST.FED.DO RS/CAMPUS SERTAO" -> "Instituto Federal do Rio Grande do Sul/Campus Sertão";
            case "INST.FED.DO RS/CAMPUS RIO GRANDE" -> "Instituto Federal do Rio Grande do Sul/Campus Rio Grande";
            case "INST.FED.DO RS/CAMPUS PORTO ALEGRE" -> "Instituto Federal do Rio Grande do Sul/Campus Porto Alegre";
            case "INST.FED.DO RS/CAMPUS PORTO ALEGRE - RESTINGA" ->
                    "Instituto Federal do Rio Grande do Sul/Campus Porto Alegre - Restinga";
            case "INST.FED.DO RS/CAMPUS OSORIO" -> "Instituto Federal do Rio Grande do Sul/Campus Osório";
            case "INST.FED.DO RS/CAMPUS CAXIAS DO SUL" -> "Instituto Federal do Rio Grande do Sul/Campus Caxias do Sul";
            case "INST.FED.DO RS/CAMPUS ROLANTE" -> "Instituto Federal do Rio Grande do Sul/Campus Rolante";
            case "INST.FED.DO RS/CAMPUS IBIRUBA" -> "Instituto Federal do Rio Grande do Sul/Campus Ibirubá";
            case "INST.FED.DO RS/CAMPUS CANOAS" -> "Instituto Federal do Rio Grande do Sul/Campus Canoas";
            case "INST.FED.DO RS/CAMPUS ERECHIM" -> "Instituto Federal do Rio Grande do Sul/Campus Erechim";
            case "INST.FED.DO RS/CAMPUS BENTO GONCALVES" ->
                    "Instituto Federal do Rio Grande do Sul/Campus Bento Gonçalves";
            case "INST.FED.DO RS/CAMPUS VIAMAO" -> "Instituto Federal do Rio Grande do Sul/Campus Viamão";
            case "INST.FED.DO RS/CAMPUS FELIZ" -> "Instituto Federal do Rio Grande do Sul/Campus Feliz";
            case "INST.FED.DO RS/CAMPUS ALVORADA" -> "Instituto Federal do Rio Grande do Sul/Campus Alvorada";
            case "INST.FED.DO RS/CAMPUS VACARIA" -> "Instituto Federal do Rio Grande do Sul/Campus Vacaria";
            case "INST.FED.DO RS/CAMPUS FARROUPILHA" -> "Instituto Federal do Rio Grande do Sul/Campus Farroupilha";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE GOIAS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Goiás";
            case "INST.FED.DE GOIAS/CAMPUS GOIANIA" -> "Instituto Federal de Goiás/Campus Goiânia";
            case "INST.FED.DE GOIAS/CAMPUS APARECIDA DE GOIANIA" ->
                    "Instituto Federal de Goiás/Campus Aparecida de Goiânia";
            case "INST.FED.DE GOIAS/CAMPUS LUZIANIA" -> "Instituto Federal de Goiás/Campus Luziânia";
            case "INST.FED.DE GOIAS/CAMPUS JATAI" -> "Instituto Federal de Goiás/Campus Jataí";
            case "INST.FED.DE GOIAS/CAMPUS ITUMBIARA" -> "Instituto Federal de Goiás/Campus Itumbiara";
            case "INST.FED.DE GOIAS/CAMPUS ANAPOLIS" -> "Instituto Federal de Goiás/Campus Anápolis";
            case "INST.FED.DE GOIAS/CAMPUS INHUMAS" -> "Instituto Federal de Goiás/Campus Inhumas";
            case "INST.FED.DE GOIAS/CAMPUS URUACU" -> "Instituto Federal de Goiás/Campus Uruaçu";
            case "INST.FED.DE GOIAS/CAMPUS FORMOSA" -> "Instituto Federal de Goiás/Campus Formosa";
            case "INST.FED.DE GOIAS/CAMPUS VALPARAISO" -> "Instituto Federal de Goiás/Campus Valparaíso";
            case "INST.FED.DE GOIAS/CAMPUS AGUAS LINDAS" -> "Instituto Federal de Goiás/Campus Águas Lindas";
            case "INST.FED.DE GOIAS/CAMPUS SENADOR CANEDO" -> "Instituto Federal de Goiás/Campus Senador Canedo";
            case "INST.FED.DE GOIAS/CAMPUS CIDADE DE GOIAS" -> "Instituto Federal de Goiás/Campus Cidade de Goiás";
            case "INST.FED.DE GOIAS/CAMPUS GOIANIA OESTE" -> "Instituto Federal de Goiás/Campus Goiânia Oeste";
            case "UNIVERSIDADE FEDERAL DO TRIANGULO MINEIRO" -> "Universidade Federal do Triângulo Mineiro";
            case "INST. FED. DO PARANA/REITORIA" -> "Instituto Federal do Paraná/Reitoria";
            case "INST. FED. DO PARANA/CAMPUS LONDRINA" -> "Instituto Federal do Paraná/Campus Londrina";
            case "INST. FED. DO PARANA/CAMPUS PALMAS" -> "Instituto Federal do Paraná/Campus Palmas";
            case "INST. FED. DO PARANA/CAMPUS CURITIBA" -> "Instituto Federal do Paraná/Campus Curitiba";
            case "INST. FED. DO PARANA/CAMPUS UMUARAMA" -> "Instituto Federal do Paraná/Campus Umuarama";
            case "INST. FED. DO PARANA/CAMPUS FOZ DO IGUACU" -> "Instituto Federal do Paraná/Campus Foz do Iguaçu";
            case "INST. FED. DO PARANA/CAMPUS PARANAGUA" -> "Instituto Federal do Paraná/Campus Paranaguá";
            case "INST. FED. DO PARANA/CAMPUS PARANAVAI" -> "Instituto Federal do Paraná/Campus Paranavaí";
            case "INST. FED. DO PARANA/CAMPUS TELEMACO BORBA" -> "Instituto Federal do Paraná/Campus Telêmaco Borba";
            case "INST. FED. DO PARANA/CAMPUS CAPANEMA" -> "Instituto Federal do Paraná/Campus Capanema";
            case "INST. FED. DO PARANA/CAMPUS PITANGA" -> "Instituto Federal do Paraná/Campus Pitanga";
            case "INST. FED. DO PARANA/CAMPUS JACAREZINHO" -> "Instituto Federal do Paraná/Campus Jacarezinho";
            case "INSTITUTO DO PARANA/CAMPUS CASCAVEL" -> "Instituto Federal do Paraná/Campus Cascavel";
            case "INST. FED. DO PARANA/CAMPUS IVAIPORA" -> "Instituto Federal do Paraná/Campus Ivaiporã";
            case "INST. FED. DO PARANA/CAMPUS ASSIS CHATEAUBRIA" ->
                    "Instituto Federal do Paraná/Campus Assis Chateaubriand";
            case "INST. FED. DO PARANA/CAMPUS IRATI" -> "Instituto Federal do Paraná/Campus Irati";
            case "INST. FED. DO PARANA/CAMPUS COLOMBO" -> "Instituto Federal do Paraná/Campus Colombo";
            case "INST. FED. DO PARANA/CAMPUS PINHAIS" -> "Instituto Federal do Paraná/Campus Pinhais";
            case "INST. FED. DO PARANA/CAMPUS UNIAO DA VITORIA" ->
                    "Instituto Federal do Paraná/Campus União da Vitória";
            case "INST. FED. DO PARANA/CAMPUS JAGUARIAIVA" -> "Instituto Federal do Paraná/Campus Jaguariaíva";
            case "INST. FED. DO PARANA/CAMPUS CAMPO LARGO" -> "Instituto Federal do Paraná/Campus Campo Largo";
            case "INST.FED.DE EDUC.,CIE.E TEC.SUL-RIO-GRANDENSE" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia Sul-Rio-Grandense";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS PELOTAS" -> "Instituto Federal Sul-Rio-Grandense/Campus Pelotas";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS SAPUCAIA" -> "Instituto Federal Sul-Rio-Grandense/Campus Sapucaia";
            case "INST.FED.SUL-RIO-GRANDENSE/VISCONDE DA GRACA" ->
                    "Instituto Federal Sul-Rio-Grandense/Campus Visconde da Graça";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS CHARQUEADAS" ->
                    "Instituto Federal Sul-Rio-Grandense/Campus Charqueadas";
            case "INST.FED.SUL-RIO-GRANDENSE/VENANCIO AIRES" ->
                    "Instituto Federal Sul-Rio-Grandense/Campus Venâncio Aires";
            case "INST.FED.SUL-RIO-GRANDENSE/SANT.DO LIVRAMENTO" ->
                    "Instituto Federal Sul-Rio-Grandense/Campus Santana do Livramento";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS CAMAQUA" -> "Instituto Federal Sul-Rio-Grandense/Campus Camaquã";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS BAGE" -> "Instituto Federal Sul-Rio-Grandense/Campus Bagé";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS PASSO FUNDO" ->
                    "Instituto Federal Sul-Rio-Grandense/Campus Passo Fundo";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS SAPIRANGA" ->
                    "Instituto Federal Sul-Rio-Grandense/Campus Sapiranga";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS LAJEADO" -> "Instituto Federal Sul-Rio-Grandense/Campus Lajeado";
            case "INST.FED.SUL-RIO-GRANDENSE/CAMPUS GRAVATAI" -> "Instituto Federal Sul-Rio-Grandense/Campus Gravataí";
            case "UNIVERSIDADE FEDERAL DE OURO PRETO" -> "Universidade Federal de Ouro Preto";
            case "CENTRO FEDERAL DE EDUCACAO TECNOLOGICA DE MG" ->
                    "Centro Federal de Educação Tecnológica de Minas Gerais";
            case "INST.FED.DE EDUC.,CIENC.E TEC.FLUMINENSE" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia Fluminense";
            case "INST.FED. FLUMINENSE/CAMPUS CAMPOS-CENTRO" -> "Instituto Federal Fluminense/Campus Campos-Centro";
            case "INST.FED. FLUMINENSE/CAMPUS MACAE" -> "Instituto Federal Fluminense/Campus Macaé";
            case "INST.FED. FLUMINENSE/CAMPUS GUARUS" -> "Instituto Federal Fluminense/Campus Guarus";
            case "INST.FED. FLUMINENSE/CAMPUS CABO FRIO" -> "Instituto Federal Fluminense/Campus Cabo Frio";
            case "INST.FED. FLUMINENSE/CAMPUS B.JESUS DO ITABAP" ->
                    "Instituto Federal Fluminense/Campus Bom Jesus do Itabapoana";
            case "INST.FED. FLUMINENSE/CAMPUS ITAPERUNA" -> "Instituto Federal Fluminense/Campus Itaperuna";
            case "INST. FED. FLUMINENSE/CAMPUS QUISSAMA" -> "Instituto Federal Fluminense/Campus Quissamã";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE MINAS GERAIS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Minas Gerais";
            case "INST.FED.MINAS GERAIS/CAMPUS S.J.EVANGELISTA" ->
                    "Instituto Federal de Minas Gerais/Campus São João Evangelista";
            case "INST.FED.MINAS GERAIS/CAMPUS BAMBUI" -> "Instituto Federal de Minas Gerais/Campus Bambuí";
            case "INST.FED.MINAS GERAIS/CAMPUS BETIM" -> "Instituto Federal de Minas Gerais/Campus Betim";
            case "INST.FED. MINAS GERAIS/CAMPUS OURO PRETO" -> "Instituto Federal de Minas Gerais/Campus Ouro Preto";
            case "INST.FED. MINAS GERAIS/CAMPUS CONGONHAS" -> "Instituto Federal de Minas Gerais/Campus Congonhas";
            case "IFMG/CAMPUS RIBEIRAO DAS NEVES" -> "Instituto Federal de Minas Gerais/Campus Ribeirão das Neves";
            case "INSTITUTO FED. MINAS GERAIS/SANTA LUZIA" -> "Instituto Federal de Minas Gerais/Campus Santa Luzia";
            case "INST.FED.MINAS GERAIS/GOVERNADOR VALADARES" ->
                    "Instituto Federal de Minas Gerais/Campus Governador Valadares";
            case "INST.FED.MINAS GERAIS/CAMPUS IBIRITE" -> "Instituto Federal de Minas Gerais/Campus Ibirité";
            case "INST.FED. MINAS GERAIS/CAMPUS FORMIGA" -> "Instituto Federal de Minas Gerais/Campus Formiga";
            case "INST.FED.MINAS GERAIS/CAMPUS OURO BRANCO" -> "Instituto Federal de Minas Gerais/Campus Ouro Branco";
            case "INST.FED.MINAS GERAIS/SABARA" -> "Instituto Federal de Minas Gerais/Campus Sabará";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO R.DE JANEIRO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Rio de Janeiro";
            case "CAMPUS NILOPOLIS" -> "Campus Nilópolis";
            case "CAMPUS PINHEIRAL" -> "Campus Pinheiral";
            case "CAMPUS RIO DE JANEIRO" -> "Campus Rio de Janeiro";
            case "CAMPUS PARACAMBI" -> "Campus Paracambi";
            case "CAMPUS VOLTA REDONDA" -> "Campus Volta Redonda";
            case "CAMPUS SAO GONCALO" -> "Campus São Gonçalo";
            case "CAMPUS REALENGO" -> "Campus Realengo";
            case "CAMPUS DUQUE DE CAXIAS" -> "Campus Duque de Caxias";
            case "CAMPUS ARRAIAL DO CABO" -> "Campus Arraial do Cabo";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO AMAZONAS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Amazonas";
            case "IFAM - CAMPUS MANAUS CENTRO" -> "Instituto Federal do Amazonas/Campus Manaus Centro";
            case "IFAM - CAMPUS MANAUS ZONA LESTE" -> "Instituto Federal do Amazonas/Campus Manaus Zona Leste";
            case "IFAM - CAMPUS SAO GABRIEL DA CACHOEIRA" ->
                    "Instituto Federal do Amazonas/Campus São Gabriel da Cachoeira";
            case "IFAM - CAMPUS MANAUS DISTRITO INDUSTRIAL" ->
                    "Instituto Federal do Amazonas/Campus Manaus Distrito Industrial";
            case "IFAM - CAMPUS PARINTINS" -> "Instituto Federal do Amazonas/Campus Parintins";
            case "IFAM - CAMPUS COARI" -> "Instituto Federal do Amazonas/Campus Coari";
            case "IFAM - CAMPUS MAUES" -> "Instituto Federal do Amazonas/Campus Maués";
            case "IFAM - CAMPUS EIRUNEPE" -> "Instituto Federal do Amazonas/Campus Eirunepé";
            case "IFAM - CAMPUS PRESIDENTE FIGUEIREDO" -> "Instituto Federal do Amazonas/Campus Presidente Figueiredo";
            case "IFAM - CAMPUS TABATINGA" -> "Instituto Federal do Amazonas/Campus Tabatinga";
            case "IFAM - CAMPUS LABREA" -> "Instituto Federal do Amazonas/Campus Lábrea";
            case "IFAM - CAMPUS AVANCADO IRANDUBA" -> "Instituto Federal do Amazonas/Campus Avançado Iranduba";
            case "IFAM - CAMPUS HUMAITA" -> "Instituto Federal do Amazonas/Campus Humaitá";
            case "IFAM - CAMPUS TEFE" -> "Instituto Federal do Amazonas/Campus Tefé";
            case "IFAM - CAMPUS MANACAPURU" -> "Instituto Federal do Amazonas/Campus Manacapuru";
            case "IFAM - CAMPUS ITACOATIARA" -> "Instituto Federal do Amazonas/Campus Itacoatiara";
            case "IFAM - CAMPUS AVANCADO BOCA DO ACRE" -> "Instituto Federal do Amazonas/Campus Avançado Boca do Acre";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE ALAGOAS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Alagoas";
            case "INST.FED.DE ALAGOAS/CAMPUS MACEIO" -> "Instituto Federal de Alagoas/Campus Maceió";
            case "INST.FED. ALAGOAS/CAMPUS SATUBA" -> "Instituto Federal de Alagoas/Campus Satuba";
            case "INST.FED.DE ALAGOAS/CAMPUS MARECHAL DEODORO" ->
                    "Instituto Federal de Alagoas/Campus Marechal Deodoro";
            case "INST.FED.DE ALAGOAS/CAMPUS PALMEIRA DOS IND." ->
                    "Instituto Federal de Alagoas/Campus Palmeira dos Índios";
            case "INST.FED.DE ALAGOAS/CAMPUS PIRANHAS" -> "Instituto Federal de Alagoas/Campus Piranhas";
            case "INST.FED.DE ALAGOAS/CAMPUS PENEDO" -> "Instituto Federal de Alagoas/Campus Penedo";
            case "INST.FED.DE ALAGOAS/CAMPUS BATALHA" -> "Instituto Federal de Alagoas/Campus Batalha";
            case "INST.FED.DE ALAGOAS/CAMPUS SANTANA DO IPANEMA" ->
                    "Instituto Federal de Alagoas/Campus Santana do Ipanema";
            case "INST.FED.DE ALAGOAS/CAMPUS ARAPIRACA" -> "Instituto Federal de Alagoas/Campus Arapiraca";
            case "INST.FED.DE ALAGOAS/CAMPUS CORURIPE" -> "Instituto Federal de Alagoas/Campus Coruripe";
            case "INST.FED.DE ALAGOAS/CAMPUS RIO LARGO" -> "Instituto Federal de Alagoas/Campus Rio Largo";
            case "INST.FED.DE ALAGOAS/CAMPUS MURICI" -> "Instituto Federal de Alagoas/Campus Murici";
            case "INST.FED.DE ALAGOAS/CAMPUS VICOSA" -> "Instituto Federal de Alagoas/Campus Viçosa";
            case "INST.FED.DE ALAGOAS/CAMPUS MARAGOGI" -> "Instituto Federal de Alagoas/Campus Maragogi";
            case "INST.FED.DE ALAGOAS/CAMPUS SAO MIGUEL CAMPOS" ->
                    "Instituto Federal de Alagoas/Campus São Miguel dos Campos";
            case "UNIVERSIDADE FEDERAL DE LAVRAS" -> "Universidade Federal de Lavras";
            case "CENTRO FED.DE EDUC.TECNOL.CELSO S.DA FONSECA" ->
                    "Centro Federal de Educação Tecnológica Celso Suckow da Fonseca";
            case "INSTITUTO FEDERAL CATARINENSE - REITORIA" -> "Instituto Federal Catarinense/Reitoria";
            case "IF CATARINENSE - CAMPUS CONCORDIA" -> "Instituto Federal Catarinense/Campus Concórdia";
            case "IF CATARINENSE - CAMPUS RIO DO SUL" -> "Instituto Federal Catarinense/Campus Rio do Sul";
            case "IF CATARINENSE - CAMPUS CAMBORIU" -> "Instituto Federal Catarinense/Campus Camboriú";
            case "IF CATARINENSE - CAMPUS ARAQUARI" -> "Instituto Federal Catarinense/Campus Araquari";
            case "IF CATARINENSE - CAMPUS SANTA ROSA DO SUL" ->
                    "Instituto Federal Catarinense/Campus Santa Rosa do Sul";
            case "IF CATARINENSE - CAMPUS BLUMENAU" -> "Instituto Federal Catarinense/Campus Blumenau";
            default -> unidadeGestora.getNameUnidadeGestora();
        };
        unidadeGestora.setNameUnidadeGestora(updatedName);
    }

    private void correctUnidadeGestoraNames2(UnidadeGestora unidadeGestora) {
        String updatedName = switch (unidadeGestora.getNameUnidadeGestora()) {
            case "IF CATARINENSE - CAMPUS VIDEIRA" -> "Instituto Federal Catarinense/Campus Videira";
            case "IF CATARINENSE - CAMPUS S. FRANCISCO DO SUL" ->
                    "Instituto Federal Catarinense/Campus São Francisco do Sul";
            case "IF CATARINENSE - CAMPUS BRUSQUE" -> "Instituto Federal Catarinense/Campus Brusque";
            case "IF CATARINENSE - CAMPUS SAO BENTO DO SUL" -> "Instituto Federal Catarinense/Campus São Bento do Sul";
            case "IF CATARINENSE - CAMPUS LUZERNA" -> "Instituto Federal Catarinense/Campus Luzerna";
            case "IF CATARINENSE - CAMPUS FRAIBURGO" -> "Instituto Federal Catarinense/Campus Fraiburgo";
            case "IF CATARINENSE - CAMPUS IBIRAMA" -> "Instituto Federal Catarinense/Campus Ibirama";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO ACRE" -> "Fundação Universidade Federal do Acre";
            case "IF GOIANO - REITORIA" -> "Instituto Federal Goiano/Reitoria";
            case "IF GOIANO - CAMPUS RIO VERDE" -> "Instituto Federal Goiano/Campus Rio Verde";
            case "IF GOIANO - CAMPUS URUTAI" -> "Instituto Federal Goiano/Campus Urutaí";
            case "IF GOIANO - CAMPUS CERES" -> "Instituto Federal Goiano/Campus Ceres";
            case "IF GOIANO - CAMPUS IPORA" -> "Instituto Federal Goiano/Campus Iporá";
            case "IF GOIANO - CAMPUS MORRINHOS" -> "Instituto Federal Goiano/Campus Morrinhos";
            case "IF GOIANO - CAMPUS AVANCADO CATALAO" -> "Instituto Federal Goiano/Campus Avançado Catalão";
            case "IF GOIANO - CAMPUS CRISTALINA" -> "Instituto Federal Goiano/Campus Cristalina";
            case "IF GOIANO - CAMPUS POSSE" -> "Instituto Federal Goiano/Campus Posse";
            case "IF GOIANO - CAMPUS TRINDADE" -> "Instituto Federal Goiano/Campus Trindade";
            case "IF GOIANO - CAMPUS CAMPOS BELOS" -> "Instituto Federal Goiano/Campus Campos Belos";
            case "INST FED DE EDUC CIENC E TECNOLOGIA BAIANO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia Baiano";
            case "INST. FED. BAIANO - CAMPUS GUANAMBI" -> "Instituto Federal Baiano/Campus Guanambi";
            case "INST.FED.BAIANO/CAMPUS SENHOR DO BONFIM" -> "Instituto Federal Baiano/Campus Senhor do Bonfim";
            case "IF BAIANO CAMPUS VALENCA" -> "Instituto Federal Baiano/Campus Valença";
            case "INST. FED. BAIANO - CAMPUS GOV. MANGABEIRA" ->
                    "Instituto Federal Baiano/Campus Governador Mangabeira";
            case "INST.FED.BAIANO / CAMPUS XIQUE-XIQUE" -> "Instituto Federal Baiano/Campus Xique-Xique";
            case "INST. FED. BAIANO - CAMPUS URUCUCA" -> "Instituto Federal Baiano/Campus Uruçuca";
            case "INST.FED.BAIANO/CAMPUS SANTA INES" -> "Instituto Federal Baiano/Campus Santa Inês";
            case "INST.FED.BAIANO / CAMPUS ITABERABA" -> "Instituto Federal Baiano/Campus Itaberaba";
            case "INST.FED.BAIANO / CAMPUS TEIXEIRA DE FREITAS" ->
                    "Instituto Federal Baiano/Campus Teixeira de Freitas";
            case "INST.FED.BAIANO/CAMPUS CATU" -> "Instituto Federal Baiano/Campus Catu";
            case "INSTITUTO FEDERAL BAIANO - CAMPUS ITAPETINGA" -> "Instituto Federal Baiano/Campus Itapetinga";
            case "IF BAIANO CAMPUS BOM JESUS DA LAPA" -> "Instituto Federal Baiano/Campus Bom Jesus da Lapa";
            case "INST.FED.BAIANO / CAMPUS SERRINHA" -> "Instituto Federal Baiano/Campus Serrinha";
            case "INST.FED.BAIANO / CAMPUS ALAGOINHAS" -> "Instituto Federal Baiano/Campus Alagoinhas";
            case "UNIVERSIDADE FEDERAL DO RECONCAVO DA BAHIA" -> "Universidade Federal do Recôncavo da Bahia";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE S.J.DEL-REI" -> "Fundação Universidade Federal de São João del-Rei";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO PAMPA" -> "Fundação Universidade Federal do Pampa";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO ABC" -> "Fundação Universidade Federal do ABC";
            case "INST.FED.DE EDUC.,CIENC.E TEC.FARROUPILHA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia Farroupilha";
            case "INST.FED.FARROUPILHA/CAMPUS SAO VICENTE SUL" ->
                    "Instituto Federal Farroupilha/Campus São Vicente do Sul";
            case "INST.FED.FARROUPILHA/CAMPUS SANTO AUGUSTO" -> "Instituto Federal Farroupilha/Campus Santo Augusto";
            case "CAMPUS FREDERICO WESTPHALEN" -> "Instituto Federal Farroupilha/Campus Frederico Westphalen";
            case "INST.FED.FARROUPILHA/CAMPUS DE ALEGRETE" -> "Instituto Federal Farroupilha/Campus Alegrete";
            case "INST.FED.FARROUPILHA/CAMPUS SANTO ANGELO" -> "Instituto Federal Farroupilha/Campus Santo Ângelo";
            case "INSTITUTO FEDERAL FARROUPILH CAMPUS SAO BORJA" -> "Instituto Federal Farroupilha/Campus São Borja";
            case "INST.FED.FARROUPILHA CAMPUS PANAMBI" -> "Instituto Federal Farroupilha/Campus Panambi";
            case "INST.FEDERAL FARROUPILHA CAMPUS JAGUARI" -> "Instituto Federal Farroupilha/Campus Jaguarão";
            case "CAMPUS DE SANTA ROSA" -> "Instituto Federal Farroupilha/Campus Santa Rosa";
            case "INST.FED.FARROUPILHA/CAMPUS JULIO CASTILHOS" ->
                    "Instituto Federal Farroupilha/Campus Júlio de Castilhos";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO TOCANTINS" -> "Fundação Universidade Federal do Tocantins";
            case "UNIVERSIDADE FEDERAL RURAL DO SEMI-ARIDO - RN" -> "Universidade Federal Rural do Semi-Árido";
            case "UNIV.FED.RURAL DO S.ARIDO/CAMPUS ANGICOS" ->
                    "Universidade Federal Rural do Semi-Árido/Campus Angicos";
            case "UNIV.FED.RURAL SEMI-ARIDO/CAMP.PAU DOS FERROS" ->
                    "Universidade Federal Rural do Semi-Árido/Campus Pau dos Ferros";
            case "UNIV.FED. RURAL DO SEMI-ARIDO CAMP.CARAUBAS" ->
                    "Universidade Federal Rural do Semi-Árido/Campus Caraúbas";
            case "INST.FED.DE EDUC.CIENCIA TEC DO SUL DE MINAS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Sul de Minas";
            case "IFSULDEMINAS - CAMPUS MUZAMBINHO" -> "Instituto Federal do Sul de Minas/Campus Muzambinho";
            case "IFSULDEMINAS - CAMPUS MACHADO" -> "Instituto Federal do Sul de Minas/Campus Machado";
            case "IFSULDEMINAS - CAMPUS POUSO ALEGRE" -> "Instituto Federal do Sul de Minas/Campus Pouso Alegre";
            case "IFSULDEMINAS - CAMPUS INCONFIDENTES" -> "Instituto Federal do Sul de Minas/Campus Inconfidentes";
            case "IFSULDEMINAS - CAMPUS PASSOS" -> "Instituto Federal do Sul de Minas/Campus Passos";
            case "IFSULDEMINAS - CAMPUS POCOS DE CALDAS" -> "Instituto Federal do Sul de Minas/Campus Poços de Caldas";
            case "FUNDACAO UNIVERSIDADE FEDERAL DE RONDONIA" -> "Fundação Universidade Federal de Rondônia";
            case "INSTITUTO FED CIENCIA TECNOL SUDESTE MG" ->
                    "Instituto Federal de Ciência e Tecnologia do Sudeste de Minas Gerais";
            case "INST FED SUDESTE DE MG/CAMPUS BARBACENA" ->
                    "Instituto Federal do Sudeste de Minas Gerais/Campus Barbacena";
            case "INST FED SUDESTE DE MG/CAMPUS RIO POMBA" ->
                    "Instituto Federal do Sudeste de Minas Gerais/Campus Rio Pomba";
            case "INST FED SUDESTE DE MG/CAMPUS JUIZ DE FORA" ->
                    "Instituto Federal do Sudeste de Minas Gerais/Campus Juiz de Fora";
            case "INST FED SUDESTE DE MG/CAMPUS MURIAE" -> "Instituto Federal do Sudeste de Minas Gerais/Campus Muriaé";
            case "INST FED SUDESTE MG CAMPUS S. J. DEL REI" ->
                    "Instituto Federal do Sudeste de Minas Gerais/Campus São João del-Rei";
            case "INST FED SUDESTE DE MG/CAMPUS MANHUACU" ->
                    "Instituto Federal do Sudeste de Minas Gerais/Campus Manhuaçu";
            case "INST FED SUDESTE MG CAMPUS SANTOS DUMONT" ->
                    "Instituto Federal do Sudeste de Minas Gerais/Campus Santos Dumont";
            case "UNIVERSIDADE FEDERAL DA FRONTEIRA SUL" -> "Universidade Federal da Fronteira Sul";
            case "UNIVERSIDADE FED.VALES JEQUITINHONHA E MUCURI" ->
                    "Universidade Federal dos Vales do Jequitinhonha e Mucuri";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO NORTE DE MG" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Norte de Minas";
            case "INST.FED.DO NORTE DE MG/CAMPUS JANUARIA" -> "Instituto Federal do Norte de Minas/Campus Januária";
            case "INST.FED.DO NORTE DE MG/CAMPUS SALINAS" -> "Instituto Federal do Norte de Minas/Campus Salinas";
            case "INST.FED.DO NORTE DE MG/CAMPUS ARINOS" -> "Instituto Federal do Norte de Minas/Campus Araçuaí";
            case "INST.FED.DO NORTE DE MG/CAMPUS ALMENARA" -> "Instituto Federal do Norte de Minas/Campus Almenara";
            case "INST.FED.DO NORTE DE MG/CAMPUS MONTES CLAROS" ->
                    "Instituto Federal do Norte de Minas/Campus Montes Claros";
            case "INST. FED. NORTE DE MG / CAMPUS TEOFILO OTONI" ->
                    "Instituto Federal do Norte de Minas/Campus Teófilo Otoni";
            case "INST.FED DO NORTE DE MG/CAMPUS ARACUAI" -> "Instituto Federal do Norte de Minas/Campus Araçuaí";
            case "INST.FED.DO NORTE DE MG/CAMPUS PIRAPORA" -> "Instituto Federal do Norte de Minas/Campus Pirapora";
            case "INST. FED. DO NORTE DE MG/CAMPUS DIAMANTINA" ->
                    "Instituto Federal do Norte de Minas/Campus Diamantina";
            case "FUNDACAO UNIVERSIDADE FED. DA GRANDE DOURADOS" -> "Fundação Universidade Federal da Grande Dourados";
            case "HOSPITAL UNIVERSITARIO (HU/UFGD)" ->
                    "Hospital Universitário da Universidade Federal da Grande Dourados";
            case "INST. FED. DE EDUC.,CIENC. E TEC. DE RONDONIA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Rondônia";
            case "INST.FED.RONDONIA/CAMPUS GUAJARA MIRIM" -> "Instituto Federal de Rondônia/Campus Guajará-Mirim";
            case "INST.FED.RONDONIA/CAMPUS COLORADO DO OESTE-RO" ->
                    "Instituto Federal de Rondônia/Campus Colorado do Oeste";
            case "INST.FED.RONDONIA/CAMPUS P. VELHO ZONA NORTE" ->
                    "Instituto Federal de Rondônia/Campus Porto Velho Zona Norte";
            case "INST.FED.RONDONIA/CAMPUS PORTO VELHO CALAMA" ->
                    "Instituto Federal de Rondônia/Campus Porto Velho Calama";
            case "INST.FED.RONDONIA/CAMPUS JI-PARANA" -> "Instituto Federal de Rondônia/Campus Ji-Paraná";
            case "INST.FED.RONDONIA/CAMPUS JARU" -> "Instituto Federal de Rondônia/Campus Jaru";
            case "INST.FED.RONDONIA/CAMPUS VILHENA" -> "Instituto Federal de Rondônia/Campus Vilhena";
            case "INST.FED.RONDONIA/CAMPUS ARIQUEMES-RO" -> "Instituto Federal de Rondônia/Campus Ariquemes";
            case "INST.FED.RONDONIA/CAMPUS CACOAL" -> "Instituto Federal de Rondônia/Campus Cacoal";
            case "IFB - REITORIA - BRASILIA-DF" -> "Instituto Federal de Brasília/Reitoria";
            case "IFB - CAMPUS BRASILIA" -> "Instituto Federal de Brasília/Campus Brasília";
            case "IFB - CAMPUS SAMAMBAIA" -> "Instituto Federal de Brasília/Campus Samambaia";
            case "IFB - CAMPUS TAGUATINGA NORTE" -> "Instituto Federal de Brasília/Campus Taguatinga Norte";
            case "IFB - CAMPUS PLANALTINA" -> "Instituto Federal de Brasília/Campus Planaltina";
            case "IFB - CAMPUS ESTRUTURAL" -> "Instituto Federal de Brasília/Campus Estrutural";
            case "IFB - CAMPUS CEILANDIA" -> "Instituto Federal de Brasília/Campus Ceilândia";
            case "IFB - CAMPUS SAO SEBASTIAO" -> "Instituto Federal de Brasília/Campus São Sebastião";
            case "IFB - CAMPUS RIACHO FUNDO" -> "Instituto Federal de Brasília/Campus Riacho Fundo";
            case "IFB - CAMPUS RECANTO DAS EMAS" -> "Instituto Federal de Brasília/Campus Recanto das Emas";
            case "IFB - CAMPUS GAMA" -> "Instituto Federal de Brasília/Campus Gama";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE SERGIPE" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Sergipe";
            case "INST. FED. DE SERGIPE/CAMPUS LAGARTO" -> "Instituto Federal de Sergipe/Campus Lagarto";
            case "INST. FED. DE SERGIPE/CAMPUS ESTANCIA" -> "Instituto Federal de Sergipe/Campus Estância";
            case "INST. FED. DE SERGIPE/CAMPUS ARACAJU" -> "Instituto Federal de Sergipe/Campus Aracaju";
            case "INST. FED. DE SERGIPE/CAMPUS ITABAIANA" -> "Instituto Federal de Sergipe/Campus Itabaiana";
            case "INST. FED. DE SERGIPE/CAMPUS SAO CRISTOVAO" -> "Instituto Federal de Sergipe/Campus São Cristóvão";
            case "INST. FED. SERGIPE/CAMPUS N. SRA. DO SOCORRO" ->
                    "Instituto Federal de Sergipe/Campus Nossa Senhora do Socorro";
            case "INST. FED. DE SERGIPE/CAMPUS N.Sª DA GLORIA" ->
                    "Instituto Federal de Sergipe/Campus Nossa Senhora da Glória";
            case "INSTITUTO FED. DE SERGIPE - CAMPUS PROPRIA" -> "Instituto Federal de Sergipe/Campus Propriá";
            case "INSTIT FED. DE SERGIPE/CAMPUS TOBIAS BARRETO" -> "Instituto Federal de Sergipe/Campus Tobias Barreto";
            case "FUND. UNIVERSIDADE FEDERAL VALE SAO FRANCISCO" ->
                    "Fundação Universidade Federal do Vale do São Francisco";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DE TOCANTINS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Tocantins";
            case "INST.FED.DO TOCANTINS/CAMPUS PALMAS" -> "Instituto Federal do Tocantins/Campus Palmas";
            case "INST.FED.DO TOCANTINS/CAMPUS ARAGUATINS" -> "Instituto Federal do Tocantins/Campus Araguatins";
            case "INST.FED.DO TOCANTINS/CAMPUS ARAGUAINA" -> "Instituto Federal do Tocantins/Campus Araguaína";
            case "INST.FED.DO TOCANTINS/CAMPUS GURUPI" -> "Instituto Federal do Tocantins/Campus Gurupi";
            case "INST.FED.DO TOCANTINS/CAMPUS PORTO NACIONAL" ->
                    "Instituto Federal do Tocantins/Campus Porto Nacional";
            case "INST.FED.DO TOCANTINS/CAMPUS PARAISO DO TO" ->
                    "Instituto Federal do Tocantins/Campus Paraíso do Tocantins";
            case "INST.FED.DO TOCANTINS/CAMPUS DIANOPOLIS" -> "Instituto Federal do Tocantins/Campus Dianópolis";
            case "INST.FED.DO TOCANTINS/CAMPUS COLINAS DO TO" ->
                    "Instituto Federal do Tocantins/Campus Colinas do Tocantins";
            case "FUNDACAO UNIVERSIDADE FEDERAL DO AMAPA" -> "Fundação Universidade Federal do Amapá";
            case "UNIVERSIDADE FEDERAL DE RORAIMA" -> "Universidade Federal de Roraima";
            case "UNIVERSIDADE FEDERAL DE ALFENAS" -> "Universidade Federal de Alfenas";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO TRIA.MINEIRO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Triângulo Mineiro";
            case "INST.FED.TRIANGULO MINEIRO/CAMPUS UBERABA" -> "Instituto Federal Triângulo Mineiro/Campus Uberaba";
            case "INST.FED.TRIANG.MINEIRO/CAMPUS PATOS DE MINAS" ->
                    "Instituto Federal Triângulo Mineiro/Campus Patos de Minas";
            case "INST.FED.TRIANGULO MINEIRO/CAMPUS UBERLANDIA" ->
                    "Instituto Federal Triângulo Mineiro/Campus Uberlândia";
            case "INST.FED.TRIA.MIN./CAMPUS UBERLANDIA CENTRO" ->
                    "Instituto Federal Triângulo Mineiro/Campus Uberlândia Centro";
            case "INST.FED.TRIANGULO MINEIRO/CAMPUS ITUIUTABA" ->
                    "Instituto Federal Triângulo Mineiro/Campus Ituiutaba";
            case "INST.FED.TRIANGULO MINEIRO/CAMPUS PARACATU" -> "Instituto Federal Triângulo Mineiro/Campus Paracatu";
            case "INST.FED.TRIANGULO MINEIRO/CAMPUS PATROCINIO" ->
                    "Instituto Federal Triângulo Mineiro/Campus Patrocínio";
            case "UNIVERSIDADE FEDERAL RURAL DA AMAZONIA" -> "Universidade Federal Rural da Amazônia";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO MAT.G.DO SUL" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Mato Grosso do Sul";
            case "INST. FED. DO MS/CAMPUS NOVA ANDRADINA" ->
                    "Instituto Federal do Mato Grosso do Sul/Campus Nova Andradina";
            case "INST. FED. DO MS/CAMPUS CAMPO GRANDE" ->
                    "Instituto Federal do Mato Grosso do Sul/Campus Campo Grande";
            case "INST. FED. DO MS/CAMPUS TRES LAGOAS" -> "Instituto Federal do Mato Grosso do Sul/Campus Três Lagoas";
            case "INST.FED.DO MS/CAMPUS NAVIRAI" -> "Instituto Federal do Mato Grosso do Sul/Campus Naviraí";
            case "INST. FED. DO MS/CAMPUS CORUMBA" -> "Instituto Federal do Mato Grosso do Sul/Campus Corumbá";
            case "INST.FED.DO MS/CAMPUS AQUIDAUANA" -> "Instituto Federal do Mato Grosso do Sul/Campus Aquidauana";
            case "INST. FED. DO MS/CAMPUS PONTA PORA" -> "Instituto Federal do Mato Grosso do Sul/Campus Ponta Porã";
            case "INST.FED.DO MS/CAMPUS JARDIM" -> "Instituto Federal do Mato Grosso do Sul/Campus Jardim";
            case "INST. FED. DO MS/CAMPUS COXIM" -> "Instituto Federal do Mato Grosso do Sul/Campus Coxim";
            case "INST.FED.DO MS/CAMPUS DOURADOS" -> "Instituto Federal do Mato Grosso do Sul/Campus Dourados";
            case "UNIVERSIDADE FEDERAL DE ITAJUBA" -> "Universidade Federal de Itajubá";
            case "UNIVERSIDADE FEDERAL ITAJUBA-CAMPUS ITABIRA" -> "Universidade Federal de Itajubá/Campus Itabira";
            case "UNIVERSIDADE FEDERAL DO OESTE DO PARA" -> "Universidade Federal do Oeste do Pará";
            case "INST.FED.DE ED.,CIENC.E TEC.DO S.PERNAMBUCANO" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Sertão Pernambucano";
            case "INST.FED.SERTAO PERNAMBUCANO/CAMPUS PETROLINA" ->
                    "Instituto Federal Sertão Pernambucano/Campus Petrolina";
            case "IF SERTAO PE/CAMPUS OURICURI" -> "Instituto Federal Sertão Pernambucano/Campus Ouricuri";
            case "INST.FED.S.PERNAMB./CAMPUS PETROLINA Z.RURAL" ->
                    "Instituto Federal Sertão Pernambucano/Campus Petrolina Zona Rural";
            case "IF SERTAO PE CAMPUS SERRA TALHADA" -> "Instituto Federal Sertão Pernambucano/Campus Serra Talhada";
            case "IF SERTAO PE/CAMPUS SALGUEIRO" -> "Instituto Federal Sertão Pernambucano/Campus Salgueiro";
            case "IF SERTAO PE CAMPUS SANTA MARIA DA BOA VISTA" ->
                    "Instituto Federal Sertão Pernambucano/Campus Santa Maria da Boa Vista";
            case "IF SERTAOPE/CAMPUS FLORESTA" -> "Instituto Federal Sertão Pernambucano/Campus Floresta";
            case "UNIV. FEDERAL DA INTEGRACAO-LATINO-AMERICANA" ->
                    "Universidade Federal da Integração Latino-Americana";
            case "FUND.UNIV.FED.DE.CIENC.DA SAUDE DE P.ALEGRE" ->
                    "Fundação Universidade Federal de Ciências da Saúde de Porto Alegre";
            case "UNIV.DA INTEG.INTERN.DA LUSOF.AFRO-BRASILEIRA" ->
                    "Universidade da Integração Internacional da Lusofonia Afro-Brasileira";
            case "UNILAB/CAMPUS DOS MALES" ->
                    "Universidade da Integração Internacional da Lusofonia Afro-Brasileira/Campus dos Malês";
            case "INSTITUTO FEDERAL EDUC.CIENC.E TEC.DE RORAIMA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia de Roraima";
            case "INST.FED.RORAIMA - CAMPUS AMAJARI" -> "Instituto Federal de Roraima/Campus Amajari";
            case "INST.FED.RORAIMA - CAMPUS NOVO PARAISO" -> "Instituto Federal de Roraima/Campus Novo Paraíso";
            case "INST.FED.RORAIMA - CAMPUS BOA VISTA" -> "Instituto Federal de Roraima/Campus Boa Vista";
            case "INST.FED.RORAIMA - CAMPUS ZONA OESTE" -> "Instituto Federal de Roraima/Campus Zona Oeste";
            case "UNIVERSIDADE FEDERAL DO SUL E SUDESTE DO PARA" -> "Universidade Federal do Sul e Sudeste do Pará";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO ACRE" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Acre";
            case "UNIVERSIDADE FEDERAL DO CARIRI" -> "Universidade Federal do Cariri";
            case "UNIVERSIDADE FEDERAL DO SUL DA BAHIA" -> "Universidade Federal do Sul da Bahia";
            case "UNIVERSIDADE FEDERAL DO OESTE DA BAHIA - UFOB" -> "Universidade Federal do Oeste da Bahia";
            case "UNIVERSIDADE FEDERAL DE CATALAO" -> "Universidade Federal de Catalão";
            case "FUNDACAO JOAQUIM NABUCO" -> "Fundação Joaquim Nabuco";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO AMAPA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Amapá";
            case "INST.FED. DO AMAPA -CAMPUS MACAPA" -> "Instituto Federal do Amapá/Campus Macapá";
            case "INST.FED.DO AMAPA - CAMPUS LARANJAL JARI." -> "Instituto Federal do Amapá/Campus Laranjal do Jari";
            case "INSTITUTO FED DO AP CAMPUS AGRIC PORTO GRANDE" -> "Instituto Federal do Amapá/Campus Porto Grande";
            case "INSTITUTO FED DO AMAPA - SANTANA" -> "Instituto Federal do Amapá/Campus Santana";
            case "UNIVERSIDADE FEDERAL DE JATAI" -> "Universidade Federal de Jataí";
            case "UNIVERSIDADE FEDERAL DO NORTE DE TOCANTINS" -> "Universidade Federal do Norte do Tocantins";
            case "UNIVERSIDADE FEDERAL DE RONDONOPOLIS" -> "Universidade Federal de Rondonópolis";
            case "UNIVERSIDADE FEDERAL DO DELTA DO PARNAIBA" -> "Universidade Federal do Delta do Parnaíba";
            case "UNIVERSIDADE FEDERAL DO AGRESTE DE PERNAMBUCO" -> "Universidade Federal do Agreste de Pernambuco";
            case "SECRETARIA NACIONAL DE RENDA DA CIDADANIA" -> "Secretaria Nacional de Renda de Cidadania";
            case "SECRETARIA NAC. DE SEGUR. ALIMENTAR E NUTRIC." ->
                    "Secretaria Nacional de Segurança Alimentar e Nutricional";
            case "COORDENACAO GERAL DE LICITACOES E CONTRATOS." -> "Coordenação Geral de Licitações e Contratos";
            case "DPTO. APOIO E ACOLHIM. AT. EM ALCOOL E DROGAS" ->
                    "Departamento de Apoio e Acolhimento aos Atendidos em Álcool e Drogas";
            case "PROJETO DE OPERACION. DOS PROGRAMAS DA SNAS" ->
                    "Projeto de Operacionalização dos Programas da Secretaria Nacional de Assistência Social";
            case "SAA/SE/MC - CONDOMINIO BLOCO A" -> "SAA/SE/MC - Condomínio Bloco A";
            case "SECRETARIA DE INCLUSAO SOCIOECONOMICA" -> "Secretaria de Inclusão Socioeconômica";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS/MDS" -> "Coordenação Geral de Gestão de Pessoas/MDS";
            case "SECRETARIA NACIONAL DE ASSISTENCIA SOCIAL." -> "Secretaria Nacional de Assistência Social";
            case "DIRECAO NACIONAL DE PROJETOS-DNP - MC" -> "Direção Nacional de Projetos - DNP - MC";
            case "PROJETO DE OPERACIONALIZ. DOS PROGRAMAS SESAN" ->
                    "Projeto de Operacionalização dos Programas da Secretaria Especial de Segurança Alimentar e Nutricional";
            case "SECRETARIA NACIONAL DE CUIDADOS E FAMILIA" -> "Secretaria Nacional de Cuidados e da Família";
            case "SEC. EXTRAORD. DE COMBATE A POBREZA E A FOME" ->
                    "Secretaria Extraordinária de Combate à Pobreza e à Fome";
            case "DPTO. DE RESOLUCAO DE AUXILIOS DESCONTINUADOS" ->
                    "Departamento de Resolução de Auxílios Descontinuados";
            case "FUNDO NACIONAL DE ASSISTENCIA SOCIAL" -> "Fundo Nacional de Assistência Social";
            case "Sem informação" -> "Sem Informação";
            case "CENTRO DE PAGAMENTO DO EXERCITO" -> "Centro de Pagamento do Exército";
            case "COMISSAO DO EXERCITO BRASILEIRO EM WASHINGTON" -> "Comissão do Exército Brasileiro em Washington";
            case "CENTRO DE OBTENCOES DO EXERCITO" -> "Centro de Obtenções do Exército";
            case "BASE ADMINISTRATIVA DO C COM G EX" -> "Base Administrativa do Comando e Controle do Exército";
            case "ESCRITORIO REGIONAL OP C PIPA/7ª RM" ->
                    "Escritório Regional de Operações e Proteção da 7ª Região Militar";
            case "BASE ADM DA BRIGADA DE INFANTARIA PQDT" ->
                    "Base Administrativa da Brigada de Infantaria Paraquedista";
            case "ESCRITORIO REGIONAL OP C PIPA/1º GPT E" ->
                    "Escritório Regional de Operações e Proteção da 1ª Região Militar";
            case "COMANDO DA 1 REGIAO MILITAR" -> "Comando da 1ª Região Militar";
            case "72º BATALHAO DE INFANTARIA DE CAATINGA" -> "72º Batalhão de Infantaria de Caatinga";
            case "ACADEMIA MILITAR DAS AGULHAS NEGRAS" -> "Academia Militar das Agulhas Negras";
            case "2 BATALHAO FERROVIARIO" -> "2º Batalhão Ferroviário";
            case "COMANDO DA 11A. REGIAO MILITAR" -> "Comando da 11ª Região Militar";
            case "CMDO DA 10ª RM - ER OP C PIPA/10ª RM" ->
                    "Comando da 10ª Região Militar - Escritório Regional de Operações e Proteção da 10ª Região Militar";
            case "CENTRO TECNOLOGICO DO EXERCITO" -> "Centro Tecnológico do Exército";
            case "LABORATORIO QUIMICO FARMACEUTICO DO EXERCITO" -> "Laboratório Químico Farmacêutico do Exército";
            case "DIRETORIA DE FABRICACAO" -> "Diretoria de Fabricação";
            case "COMISSAO REGIONAL DE OBRAS/11" -> "Comissão Regional de Obras da 11ª Região Militar";
            case "ER OP C PIPA/6ª RM" -> "Escritório Regional de Operações e Proteção da 6ª Região Militar";
            case "28º BATALHAO DE CACADORES" -> "28º Batalhão de Caçadores";
            case "BASE ADMINISTRATIVA DO QGEX" -> "Base Administrativa do Quartel-General do Exército";
            case "2º BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "2º Batalhão de Engenharia de Construção";
            case "COMISSAO REGIONAL DE OBRAS/12" -> "Comissão Regional de Obras da 12ª Região Militar";
            case "COMANDO 12 REGIAO MILITAR" -> "Comando da 12ª Região Militar";
            case "9º GRUPAMENTO LOGISTICO" -> "9º Grupamento Logístico";
            case "CENTRO INTEGRADO DE TELEMATICA DO EXERCITO" -> "Centro Integrado de Telemática do Exército";
            case "COMANDO DA 2 REGIAO MILITAR" -> "Comando da 2ª Região Militar";
            case "COMANDO DA 6ª REGIAO MILITAR" -> "Comando da 6ª Região Militar";
            case "3º BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "3º Batalhão de Engenharia de Construção";
            case "ESCRITORIO AVANCADO DA OP C PIPA 7ª RM" ->
                    "Escritório Avançado de Operações e Proteção da 7ª Região Militar";
            case "CENTRO DE INTELIGENCIA DO EXERCITO" -> "Centro de Inteligência do Exército";
            case "COMANDO 5ª REGIAO MILITAR" -> "Comando da 5ª Região Militar";
            case "COMISSAO REGIONAL DE OBRAS/1" -> "Comissão Regional de Obras da 1ª Região Militar";
            case "BASE ADMINISTRATIVA DO CURADO" -> "Base Administrativa do Curado";
            case "6 BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "6º Batalhão de Engenharia de Construção";
            case "ESCRITORIO AVANCADO OP C PIPA DA 10ª RM" ->
                    "Escritório Avançado de Operações e Proteção da 10ª Região Militar";
            case "COMANDO DO COMANDO MILITAR DA AMAZONIA" -> "Comando do Comando Militar da Amazônia";
            case "B ADM GU N/ER OP C PIPA/7ª BDA INF MTZ" ->
                    "Base Administrativa do Grupamento Norte/Escritório Regional de Operações e Proteção da 7ª Brigada de Infantaria de Montanha";
            case "3 BATALHAO DE SUPRIMENTO" -> "3º Batalhão de Suprimento";
            case "BASE DE AVIACAO DE TAUBATE" -> "Base de Aviação de Taubaté";
            case "1 BATALHAO FERROVIARIO" -> "1º Batalhão Ferroviário";
            case "ESCOLA DE APERFEICOAMENTO DE OFICIAIS" -> "Escola de Aperfeiçoamento de Oficiais";
            case "PREFEITURA MILITAR DE BRASILIA" -> "Prefeitura Militar de Brasília";
            case "COMANDO 7 REGIAO MILITAR/7 DIV DE EXERCITO" -> "Comando da 7ª Região Militar/7ª Divisão de Exército";
            case "COMISSAO REGIONAL DE OBRAS/2" -> "Comissão Regional de Obras da 2ª Região Militar";
            case "BASE DE ADMINISTRACAO E APOIO DO CMO" -> "Base de Administração e Apoio do Comando Militar do Oeste";
            case "ESCOLA DE CMDO E ESTADO-MAIOR DO EXERCITO" -> "Escola de Comando e Estado-Maior do Exército";
            case "CENTRO DE CAP.FISIC.DO EXERC. FORT.SAO JOAO" ->
                    "Centro de Capacitação Física do Exército Forte São João";
            case "COMANDO DA 4ª REGIAO MILITAR" -> "Comando da 4ª Região Militar";
            case "1º BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "1º Batalhão de Engenharia de Construção";
            case "COMANDO DA 8 REGIAO MILITAR/8 DE" -> "Comando da 8ª Região Militar/8ª Divisão de Exército";
            case "BASE ADMINISTRATIVA DO CMDO DE OP ESPECIAIS" ->
                    "Base Administrativa do Comando de Operações Especiais";
            case "COMISSAO REGIONAL DE OBRAS/3" -> "Comissão Regional de Obras da 3ª Região Militar";
            case "ESCOLA DE SARGENTOS DAS ARMAS" -> "Escola de Sargentos das Armas";
            case "COMANDO DA 2A BRIGADA DE INFANTARIA DE SELVA" -> "Comando da 2ª Brigada de Infantaria de Selva";
            case "9 BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "9º Batalhão de Engenharia de Construção";
            case "3 CENTRO DE TELEMATICA DE AREA" -> "3º Centro de Telemática de Área";
            case "8º BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "8º Batalhão de Engenharia de Construção";
            case "ESCOLA DE SARGENTOS DE LOGISTICA" -> "Escola de Sargentos de Logística";
            case "BASE DE ADMINISTRACAO E APOIO DA 1 RM" -> "Base de Administração e Apoio da 1ª Região Militar";
            case "7º BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "7º Batalhão de Engenharia de Construção";
            case "COMANDO/1A BRIGADA DE INFANTARIA DE SELVA" -> "Comando da 1ª Brigada de Infantaria de Selva";
            case "COMISSAO REGIONAL DE OBRAS/5" -> "Comissão Regional de Obras da 5ª Região Militar";
            case "COMANDO 2 GRUPAMENTO ENGENHARIA" -> "Comando do 2º Grupamento de Engenharia";
            case "BASE ADM DA GUARNICAO DE SANTA MARIA" -> "Base Administrativa da Guarnição de Santa Maria";
            case "GABINETE DO COMANDANTE DO EXERCITO" -> "Gabinete do Comandante do Exército";
            case "COMANDO DA 3ª REGIAO MILITAR" -> "Comando da 3ª Região Militar";
            case "DEPOSITO DE SUBSISTENCIA SANTA MARIA" -> "Depósito de Subsistência de Santa Maria";
            case "COMANDO DO 5º GRUPAMENTO DE ENGENHARIA" -> "Comando do 5º Grupamento de Engenharia";
            case "COMANDO DA 16A BRIGADA DE INFANTARIA DE SELVA" -> "Comando da 16ª Brigada de Infantaria de Selva";
            case "COMANDO 10ª REGIAO MILITAR" -> "Comando da 10ª Região Militar";
            case "ESCOLA DE SAUDE E FORMACAO COMPLEMENTAR DO EX" ->
                    "Escola de Saúde e Formação Complementar do Exército";
            case "COMANDO DA 17 BRIGADA DE INFANTARIA DE SELVA" -> "Comando da 17ª Brigada de Infantaria de Selva";
            case "INSTITUTO MILITAR DE ENGENHARIA" -> "Instituto Militar de Engenharia";
            case "HOSPITAL CENTRAL DO EXERCITO" -> "Hospital Central do Exército";
            case "12º BATALHAO DE ENG. DE COMBATE BLINDADO" -> "12º Batalhão de Engenharia de Combate Blindado";
            case "BASE DE ADMINISTRACAO E APOIO DA 8ª RM" -> "Base de Administração e Apoio da 8ª Região Militar";
            case "COMANDO 23ª BRIGADA DE INFANTARIA DE SELVA" -> "Comando da 23ª Brigada de Infantaria de Selva";
            case "ARSENAL DE GUERRA DO RIO" -> "Arsenal de Guerra do Rio de Janeiro";
            case "5 BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "5º Batalhão de Engenharia de Construção";
            case "DEPOSITO DE SUBSISTENCIA SANTO ANGELO" -> "Depósito de Subsistência de Santo Ângelo";
            case "BASE DE ADMINISTRACAO E APOIO DO IBIRAPUERA" -> "Base de Administração e Apoio do Ibirapuera";
            case "COMANDO DA 22ª BRIGADA DE INFANTARIA DE SELV" -> "Comando da 22ª Brigada de Infantaria de Selva";
            case "COMANDO DE FRONTEIRA DE RORAIMA/7 BIS" ->
                    "Comando de Fronteira de Roraima/7º Batalhão de Infantaria de Selva";
            case "3 BATALHAO DE ENGENHARIA DE COMBATE" -> "3º Batalhão de Engenharia de Combate";
            case "23º BATALHAO LOGISTICO DE SELVA" -> "23º Batalhão Logístico de Selva";
            case "BASE ADMINISTRATIVA DA GUARNICAO DE NATAL" -> "Base Administrativa da Guarnição de Natal";
            case "COMISSAO REGIONAL DE OBRAS DA 9ª RM" -> "Comissão Regional de Obras da 9ª Região Militar";
            case "COMISSAO REGIONAL DE OBRAS DA 8ª RM" -> "Comissão Regional de Obras da 8ª Região Militar";
            case "CENTRO DE EMBARCACOES DO COM.MIL.DA AMAZONIA" ->
                    "Centro de Embarcações do Comando Militar da Amazônia";
            case "ESCOLA PREPARATORIA DE CADETES DO EXERCITO" -> "Escola Preparatória de Cadetes do Exército";
            case "DEPARTAMENTO DE ENGENHARIA E CONSTRUCAO" -> "Departamento de Engenharia e Construção";
            case "4º BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "4º Batalhão de Engenharia de Construção";
            case "COMANDO 11 BRIGADA INFANTARIA LEVE (GLO)" ->
                    "Comando da 11ª Brigada de Infantaria Leve (Grupamento de Logística)";
            case "COMANDO DA 1ª DIVISAO DE EXERCITO" -> "Comando da 1ª Divisão de Exército";
            case "6 BATALHAO DE ENGENHARIA DE COMBATE" -> "6º Batalhão de Engenharia de Combate";
            case "ESTADO-MAIOR DO EXERCITO" -> "Estado-Maior do Exército";
            case "BASE DE ADMINISTRACAO E APOIO DA 5ª RM" -> "Base de Administração e Apoio da 5ª Região Militar";
            case "COMANDO DA 4A BDA DE INFANTARIA LEVE MONTANHA" ->
                    "Comando da 4ª Brigada de Infantaria Leve de Montanha";
            case "1 REGIMENTO DE CAVALARIA DE GUARDA" -> "1º Regimento de Cavalaria de Guarda";
            case "BASE DE ADMINISTRACAO E APOIO DO CMP" ->
                    "Base de Administração e Apoio do Comando Militar do Planalto";
            case "COMANDO 4 BRIGADA DE CAVALARIA MECANIZADA" -> "Comando da 4ª Brigada de Cavalaria Mecanizada";
            case "7º BATALHAO DE ENGENHARIA DE COMBATE" -> "7º Batalhão de Engenharia de Combate";
            case "2 REGIMENTO DE CAVALARIA MECANIZADO" -> "2º Regimento de Cavalaria Mecanizado";
            case "8º BATALHAO DE SUPRIMENTO DE SELVA" -> "8º Batalhão de Suprimento de Selva";
            case "COMANDO 1º GRUPAMENTO DE ENGENHARIA" -> "Comando do 1º Grupamento de Engenharia";
            case "2º BATALHAO DE INFANTARIA DE SELVA" -> "2º Batalhão de Infantaria de Selva";
            case "21 COMPANHIA DE ENGENHARIA CONSTRUCAO" -> "21ª Companhia de Engenharia de Construção";
            case "COMANDO DE OPERACOES TERRESTRES - UG" -> "Comando de Operações Terrestres - Unidade de Gestão";
            case "COMANDO DO COMANDO MILITAR DO SUL" -> "Comando do Comando Militar do Sul";
            case "ESTABELECIMENTO CENTRAL DE TRANSPORTE" -> "Estabelecimento Central de Transporte";
            case "COMANDO DE FRONTEIRA SOLIMOES/8 BIS" ->
                    "Comando de Fronteira Solimões/8º Batalhão de Infantaria de Selva";
            case "1º BATALHAO DE ENGENHARIA DE COMBATE" -> "1º Batalhão de Engenharia de Combate";
            case "5 BATALHAO LOGISTICO" -> "5º Batalhão Logístico";
            case "COMANDO 15 BRIGADA DE INFANTARIA MECANIZADA" -> "Comando da 15ª Brigada de Infantaria Mecanizada";
            case "16 BATALHAO LOGISTICO" -> "16º Batalhão Logístico";
            case "COMANDO 13 BDA DE INFANTARIA MOTORIZADA" -> "Comando da 13ª Brigada de Infantaria Motorizada";
            case "BASE ADMINISTRATIVA DA GUARNICAO DE JP" -> "Base Administrativa da Guarnição de João Pessoa";
            case "COMANDO DA 9A.REGIAO MILITAR" -> "Comando da 9ª Região Militar";
            case "COLEGIO MILITAR DO RIO DE JANEIRO" -> "Colégio Militar do Rio de Janeiro";
            case "DEPARTAMENTO DE EDUCACAO E CULTURA DO EXERCITO" -> "Departamento de Educação e Cultura do Exército";
            case "7º CENTRO DE TELEMATICA DE AREA" -> "7º Centro de Telemática de Área";
            case "4 BATALHAO DE AVIACAO DO EXERCITO" -> "4º Batalhão de Aviação do Exército";
            case "11. DEPOSITO DE SUPRIMENTO" -> "11º Depósito de Suprimento";
            case "DEPARTAMENTO DE CIENCIA E TECNOLOGIA" -> "Departamento de Ciência e Tecnologia";
            case "DEPARTAMENTO-GERAL DO PESSOAL" -> "Departamento Geral do Pessoal";
            case "17 BATALHAO DE FRONTEIRA" -> "17º Batalhão de Fronteira";
            case "HOSPITAL MILITAR DE AREA DE SAO PAULO" -> "Hospital Militar de Área de São Paulo";
            case "COMANDO DO COMANDO MILITAR DO LESTE" -> "Comando do Comando Militar do Leste";
            case "COLEGIO MILITAR DE BRASILIA" -> "Colégio Militar de Brasília";
            case "27 BATALHAO LOGISTICO" -> "27º Batalhão Logístico";
            case "COMANDO DA 12 BRIG.DE INFANT.LEVE (AEROMOVEL)" ->
                    "Comando da 12ª Brigada de Infantaria Leve (Aeromóvel)";
            case "COMANDO DE FRONTEIRA JAURU / 66º BI MTZ" ->
                    "Comando de Fronteira Jauru/66º Batalhão de Infantaria de Montanha";
            case "59 BATALHAO DE INFANTARIA MOTORIZADO" -> "59º Batalhão de Infantaria Motorizado";
            case "ESCOLA DE INSTRUCAO ESPECIALIZADA" -> "Escola de Instrução Especializada";
            case "SECRETARIA-GERAL DO EXERCITO" -> "Secretaria Geral do Exército";
            case "15 BATALHAO LOGISTICO" -> "15º Batalhão Logístico";
            case "COMANDO DE ARTILHARIA DO EXERCITO" -> "Comando de Artilharia do Exército";
            case "2º BATALHAO DE SUPRIMENTO" -> "2º Batalhão de Suprimento";
            case "COMANDO DE FRONTEIRA ACRE/4 BIS" -> "Comando de Fronteira Acre/4º Batalhão de Infantaria de Selva";
            case "53º BATALHAO DE INFANTARIA DE SELVA" -> "53º Batalhão de Infantaria de Selva";
            case "BATALHAO DE POLICIA DO EXERCITO DE BRASILIA" -> "Batalhão de Polícia do Exército de Brasília";
            case "COMANDO DO COMANDO MILITAR DO NORDESTE" -> "Comando do Comando Militar do Nordeste";
            case "2º REGIMENTO DE CAVALARIA DE GUARDAS" -> "2º Regimento de Cavalaria de Guardas";
            case "17 REGIMENTO DE CAVALARIA MECANIZADO" -> "17º Regimento de Cavalaria Mecanizado";
            case "1º DEPOSITO DE SUPRIMENTO" -> "1º Depósito de Suprimento";
            case "BATALHAO CENTRAL DE MANUTENCAO E SUPRIMENTO" -> "Batalhão Central de Manutenção e Suprimento";
            case "2º BATALHAO LOGISTICO LEVE" -> "2º Batalhão Logístico Leve";
            case "ARSENAL DE GUERRA DE SAO PAULO" -> "Arsenal de Guerra de São Paulo";
            case "25º BATALHAO DE CACADORES" -> "25º Batalhão de Caçadores";
            case "COMANDO DA 18 BRIGADA DE INF DE PANTANAL" -> "Comando da 18ª Brigada de Infantaria do Pantanal";
            case "BASE DE APOIO LOGISTICO DO EXERCITO" -> "Base de Apoio Logístico do Exército";
            case "ESCOLA DE APERFEICOAMENTO DE SARGENTOS" -> "Escola de Aperfeiçoamento de Sargentos";
            case "COMANDO DE FRONTEIRA JURUA E 61º BIS" ->
                    "Comando de Fronteira Juruá e 61º Batalhão de Infantaria de Selva";
            case "2º CENTRO DE GEOINFORMACAO" -> "2º Centro de Geoinformação";
            case "9 BATALHAO DE ENGENHARIA DE COMBATE" -> "9º Batalhão de Engenharia de Combate";
            case "PARQUE REGIONAL DE MANUTENCAO/12" -> "Parque Regional de Manutenção da 12ª Região Militar";
            case "24º BATALHAO DE INFANTARIA DE SELVA" -> "24º Batalhão de Infantaria de Selva";
            case "10 REGIMENTO DE CAVALARIA MECANIZADO" -> "10º Regimento de Cavalaria Mecanizado";
            case "4. DEPOSITO DE SUPRIMENTO" -> "4º Depósito de Suprimento";
            case "23º BATALHAO DE CACADORES - PATRIMONIAL" -> "23º Batalhão de Caçadores - Patrimonial";
            case "51 BATALHAO DE INFANTARIA DE SELVA" -> "51º Batalhão de Infantaria de Selva";
            case "BATALHAO DE GUARDA PRESIDENCIAL" -> "Batalhão de Guarda Presidencial";
            case "9 BATALHAO LOGISTICO" -> "9º Batalhão Logístico";
            case "2 BATALHAO DE ENGENHARIA DE COMBATE" -> "2º Batalhão de Engenharia de Combate";
            case "7º DEPOSITO DE SUPRIMENTO" -> "7º Depósito de Suprimento";
            case "CENTRO DE AVALIACOES DO EXERCITO" -> "Centro de Avaliações do Exército";
            case "COMANDO DE FRONTEIRA RONDONIA/6 BIS" ->
                    "Comando de Fronteira Rondônia/6º Batalhão de Infantaria de Selva";
            case "HOSPITAL DE GUARN. DE S. GABRIEL DA CACHOEIRA" -> "Hospital de Guarnição de São Gabriel da Cachoeira";
            case "DEPOSITO CENTRAL DE MUNICAO" -> "Depósito Central de Munição";
            case "8 BATALHAO LOGISTICO" -> "8º Batalhão Logístico";
            case "1 BATALHAO DE INFANTARIA DE SELVA(AEROMOVEL)" -> "1º Batalhão de Infantaria de Selva (Aeromóvel)";
            case "CENTRO DE INSTRUCAO DE GUERRA NA SELVA" -> "Centro de Instrução de Guerra na Selva";
            case "3 REGIMENTO DE CAVALARIA DE GUARDA" -> "3º Regimento de Cavalaria de Guarda";
            case "ARSENAL DE GUERRA GENERAL CAMARA" -> "Arsenal de Guerra General Câmara";
            case "4 BATALHAO DE INFANTARIA LEVE" -> "4º Batalhão de Infantaria Leve";
            case "38º BATALHAO DE INFANTARIA" -> "38º Batalhão de Infantaria";
            case "COMANDO DE ARTILHARIA DIVISIONARIA DA 1 DE" ->
                    "Comando de Artilharia Divisionária da 1ª Divisão de Exército";
            case "1 BATALHAO DE GUARDA" -> "1º Batalhão de Guarda";
            case "20 REGIMENTO DE CAVALARIA BLINDADO" -> "20º Regimento de Cavalaria Blindado";
            case "PARQUE REGIONAL DE MANUTENCAO/3" -> "Parque Regional de Manutenção da 3ª Região Militar";
            case "HOSPITAL MILITAR DE AREA DE PORTO ALEGRE" -> "Hospital Militar de Área de Porto Alegre";
            case "14ª COMPANHIA DE ENGENHARIA DE COMBATE" -> "14ª Companhia de Engenharia de Combate";
            case "2º BATALHAO DE INFANTARIA LEVE" -> "2º Batalhão de Infantaria Leve";
            case "3 BATALHAO LOGISTICO" -> "3º Batalhão Logístico";
            case "1 BATALHAO DE POLICIA DO EXERCITO" -> "1º Batalhão de Polícia do Exército";
            case "6º BATALHAO DE POLICIA DO EXERCITO" -> "6º Batalhão de Polícia do Exército";
            case "CENTRO DE PREP. DE OFICIAIS DA RESERVA DE BH" ->
                    "Centro de Preparação de Oficiais da Reserva de Belo Horizonte";
            case "BATALHAO MANUTENCAO E SUPRIMENTO DE ARMAMENTO" -> "Batalhão de Manutenção e Suprimento de Armamento";
            case "36º BATALHAO DE INFANTARIA MECANIZADO" -> "36º Batalhão de Infantaria Mecanizado";
            case "55 BATALHAO DE INFANTARIA" -> "55º Batalhão de Infantaria";
            case "COLEGIO MILITAR DE FORTALEZA" -> "Colégio Militar de Fortaleza";
            case "2 BATALHAO DE POLICIA DO EXERCITO" -> "2º Batalhão de Polícia do Exército";
            case "19 BATALHAO DE INFANTARIA MOTORIZADO" -> "19º Batalhão de Infantaria Motorizado";
            case "4 BATALHAO LOGISTICO" -> "4º Batalhão Logístico";
            case "34º BATALHAO DE INFANTARIA MECANIZADO" -> "34º Batalhão de Infantaria Mecanizado";
            case "12. BATALHAO DE SUPRIMENTO" -> "12º Batalhão de Suprimento";
            case "MUSEU HISTORICO DO EXERCITO FORTE COPACABANA" -> "Museu Histórico do Exército Forte Copacabana";
            case "54 BATALHAO DE INFANTARIA DE SELVA" -> "54º Batalhão de Infantaria de Selva";
            case "CENTRO DE EST.DE PES.E FORTE DUQUE DE CAXIAS" ->
                    "Centro de Estudos de Pessoal e Forte Duque de Caxias";
            case "2 COMPANHIA DE FRONTEIRA" -> "2ª Companhia de Fronteira";
            case "5º BATALHAO DE ENGENHARIA DE COMBATE BLINDAD" -> "5º Batalhão de Engenharia de Combate Blindado";
            case "COMISSAO REGIONAL DE OBRAS/7" -> "Comissão Regional de Obras da 7ª Região Militar";
            case "10º DEPOSITO DE SUPRIMENTO" -> "10º Depósito de Suprimento";
            case "10 BATALHAO LOGISTICO" -> "10º Batalhão Logístico";
            case "COLEGIO MILITAR DE BELEM" -> "Colégio Militar de Belém";
            case "1º BATALHAO DE INFANTARIA MECANIZADO (ES)" ->
                    "1º Batalhão de Infantaria Motorizado (Estado de São Paulo)";
            case "17º BATALHAO LOGISTICO DE SELVA" -> "17º Batalhão Logístico de Selva";
            case "22 BATALHAO DE INFANTARIA" -> "22º Batalhão de Infantaria";
            case "9.BATALHAO DE SUPRIMENTO" -> "9º Batalhão de Suprimento";
            case "71º BATALHAO DE INFANTARIA MOTORIZADO" -> "71º Batalhão de Infantaria Motorizado";
            case "9 GRUPO DE ARTILHARIA DE CAMPANHA" -> "9º Grupo de Artilharia de Campanha";
            case "11 REGIMENTO DE CAVALARIA MECANIZADO" -> "11º Regimento de Cavalaria Mecanizado";
            case "PARQUE REGIONAL DE MANUTENCAO/6" -> "Parque Regional de Manutenção da 6ª Região Militar";
            case "3º BATALHAO DE INFANTARIA DE SELVA" -> "3º Batalhão de Infantaria de Selva";
            case "20 BATALHAO DE INFANTARIA BLINDADO" -> "20º Batalhão de Infantaria Blindado";
            case "11º BATALHAO DE INFANTARIA DE MONTANHA" -> "11º Batalhão de Infantaria de Montanha";
            case "47 BATALHAO DE INFANTARIA" -> "47º Batalhão de Infantaria";
            case "30º BATALHAO DE INFANTARIA MECANIZADO" -> "30º Batalhão de Infantaria Mecanizado";
            case "COLEGIO MILITAR DE MANAUS" -> "Colégio Militar de Manaus";
            case "BASE ADM DO COMPLEXO DE SAUDE DO RJ" -> "Base Administrativa do Complexo de Saúde do Rio de Janeiro";
            case "COMANDO 1 BRIGADA DE CAVALARIA MECANIZADA" -> "Comando da 1ª Brigada de Cavalaria Mecanizada";
            case "6º DEPOSITO DE SUPRIMENTO" -> "6º Depósito de Suprimento";
            case "PARQUE REGIONAL DE MANUTENCAO/7" -> "Parque Regional de Manutenção da 7ª Região Militar";
            case "BASE ADMINISTRATIVA DA GUARNICAO DE FORTALEZA" -> "Base Administrativa da Guarnição de Fortaleza";
            case "HOSPITAL MILITAR DE AREA DE RECIFE" -> "Hospital Militar de Área de Recife";
            case "32 GRUPO DE ARTILHARIA DE CAMPANHA" -> "32º Grupo de Artilharia de Campanha";
            case "31 GRUPO DE ARTILHARIA DE CAMPANHA (ES)" ->
                    "31º Grupo de Artilharia de Campanha (Estado de São Paulo)";
            case "13 BATALHAO DE INFANTARIA BLINDADO" -> "13º Batalhão de Infantaria Blindado";
            case "COLEGIO MILITAR DE RECIFE" -> "Colégio Militar de Recife";
            case "50 BATALHAO DE INFANTARIA DE SELVA" -> "50º Batalhão de Infantaria de Selva";
            case "57 BATALHAO DE INFANTARIA MOTORIZADO (ES)" ->
                    "57º Batalhão de Infantaria Motorizado (Estado de São Paulo)";
            case "58 BATALHAO DE INFANTARIA MOTORIZADO" -> "58º Batalhão de Infantaria Motorizado";
            case "1 REGIMENTO DE CARROS DE COMBATE" -> "1º Regimento de Carros de Combate";
            case "CENTRO PREPARACAO OFICIAIS RESERVA/RECIFE" -> "Centro de Preparação de Oficiais da Reserva de Recife";
            case "2 BATALHAO DE INFANTARIA MOTORIZADO (ES)" ->
                    "2º Batalhão de Infantaria Motorizado (Estado de São Paulo)";
            case "PREFEITURA MILITAR DA ZONA SUL" -> "Prefeitura Militar da Zona Sul";
            case "8º BATALHAO DE MANUTENCAO DE SELVA" -> "8º Batalhão de Manutenção de Selva";
            case "5º BATALHAO DE INFANTARIA LEVE" -> "5º Batalhão de Infantaria Leve";
            case "5. BATALHAO DE SUPRIMENTO" -> "5º Batalhão de Suprimento";
            case "6 REGIMENTO DE CAVALARIA BLINDADO" -> "6º Regimento de Cavalaria Blindado";
            case "15 COMPANHIA DE ENGENHARIA DE COMBATE" -> "15ª Companhia de Engenharia de Combate";
            case "14 BATALHAO LOGISTICO" -> "14º Batalhão Logístico";
            case "HOSPITAL DE GUARNICAO DE TABATINGA" -> "Hospital de Guarnição de Tabatinga";
            case "9 BATALHAO DE INFANTARIA MOTORIZADO" -> "9º Batalhão de Infantaria Motorizado";
            case "41 BATALHAO DE INFANTARIA MOTORIZADO" -> "41º Batalhão de Infantaria Motorizado";
            case "CMDO GRUPAMENTO UNID.ESCOLA/9ª BDA INF MTZ" ->
                    "Comando do Grupamento de Unidades Escola da 9ª Brigada de Infantaria de Montanha";
            case "13º REGIMENTO DE CAVALARIA MECANIZADO" -> "13º Regimento de Cavalaria Mecanizado";
            case "CENTRO DE PREPARACAO OFICIAIS RESERVA/RJ" ->
                    "Centro de Preparação de Oficiais da Reserva do Rio de Janeiro";
            case "5 REGIMENTO DE CARROS DE COMBATE" -> "5º Regimento de Carros de Combate";
            case "COMANDO 5º BRIGADA DE CAVALARIA BLINDADA" -> "Comando da 5ª Brigada de Cavalaria Blindada";
            case "COLEGIO MILITAR DE CAMPO GRANDE" -> "Colégio Militar de Campo Grande";
            case "1º BATALHAO LOGISTICO DE SELVA" -> "1º Batalhão Logístico de Selva";
            case "15º REGIMENTO DE CAVALARIA MECANIZADO(ESCOLA" -> "15º Regimento de Cavalaria Mecanizado (Escola)";
            case "3 BATALHAO DE POLICIA DO EXERCITO" -> "3º Batalhão de Polícia do Exército";
            case "COUDELARIA DE RINCAO" -> "Coudelaria de Rincão";
            case "23 BATALHAO DE INFANTARIA" -> "23º Batalhão de Infantaria";
            case "3 REGIMENTO DE CAVALARIA MECANIZADO" -> "3º Regimento de Cavalaria Mecanizado";
            case "ESCOLA DE ARTILHARIA DE COSTA E ANTIAEREA" -> "Escola de Artilharia de Costa e Antiaérea";
            case "19º BATALHAO DE CACADORES" -> "19º Batalhão de Caçadores";
            case "25 BATALHAO LOGISTICO (ES)" -> "25º Batalhão Logístico (Estado de São Paulo)";
            case "18 GRUPO DE ARTILHARIA DE CAMPANHA" -> "18º Grupo de Artilharia de Campanha";
            case "CENTRO DE INSTRUCAO DE OPERACOES ESPECIAIS" -> "Centro de Instrução de Operações Especiais";
            case "4º CENTRO DE GEOINFORMACAO" -> "4º Centro de Geoinformação";
            case "SECRETARIA DE ECONOMIA E FINANCAS" -> "Secretaria de Economia e Finanças";
            case "21 GRUPO DE ARTILHARIA CAMPANHA" -> "21º Grupo de Artilharia de Campanha";
            case "PARQUE REGIONAL DE MANUTENCAO/5" -> "Parque Regional de Manutenção da 5ª Região Militar";
            case "14 GRUPO DE ARTILHARIA DE CAMPANHA" -> "14º Grupo de Artilharia de Campanha";
            case "7 BATALHAO DE INFANTARIA BLINDADO" -> "7º Batalhão de Infantaria Blindado";
            case "COLEGIO MILITAR DE CURITIBA" -> "Colégio Militar de Curitiba";
            case "40º BATALHAO DE INFANTARIA" -> "40º Batalhão de Infantaria";
            case "62 BATALHAO DE INFANTARIA" -> "62º Batalhão de Infantaria";
            case "3 COMPANHIA DE ENGENHARIA DE COM. MECANIZADO" -> "3ª Companhia de Engenharia de Combate Mecanizado";
            case "63 BATALHAO DE INFANTARIA" -> "63º Batalhão de Infantaria";
            case "17º BATALHAO LOGISTICO LEVE-MONTANHA" -> "17º Batalhão Logístico Leve de Montanha";
            case "22 BATALHAO LOGISTICO LEVE" -> "22º Batalhão Logístico Leve";
            case "CENTRO DE LOGISTICA DE MISSEIS E FOGUETES" -> "Centro de Logística de Mísseis e Foguetes";
            case "COMANDO 14 BRIGADA INFANTARIA MOTORIZADA" -> "Comando da 14ª Brigada de Infantaria Motorizada";
            case "2 GRUPO DE ARTILHARIA ANTIAEREA" -> "2º Grupo de Artilharia Antiaérea";
            case "COLEGIO MILITAR DE SANTA MARIA" -> "Colégio Militar de Santa Maria";
            case "5 GRUPO DE ARTILHARIA DE CAMPANHA/AP" -> "5º Grupo de Artilharia de Campanha (Amapá)";
            case "HOSPITAL GERAL DE BELEM" -> "Hospital Geral de Belém";
            case "1 BATALHAO DE COMUNICACOES" -> "1º Batalhão de Comunicações";
            case "7 REGIMENTO DE CAVALARIA MECANIZADO" -> "7º Regimento de Cavalaria Mecanizado";
            case "12 GRUPO DE ARTILHARIA DE CAMPANHA" -> "12º Grupo de Artilharia de Campanha";
            case "COMANDO 2 BRIGADA DE CAVALARIA MECANIZADA" -> "Comando da 2ª Brigada de Cavalaria Mecanizada";
            case "14 REGIMENTO DE CAVALARIA MECANIZADO" -> "14º Regimento de Cavalaria Mecanizado";
            case "18 BATALHAO DE INFANTARIA MOTORIZADO" -> "18º Batalhão de Infantaria Motorizado";
            case "32º BATALHAO DE INFANTARIA LEVE-MONTANHA" -> "32º Batalhão de Infantaria Leve de Montanha";
            case "COLEGIO MILITAR DE PORTO ALEGRE" -> "Colégio Militar de Porto Alegre";
            case "1 GRUPO DE ARTILHARIA ANTIAEREA" -> "1º Grupo de Artilharia Antiaérea";
            case "COMANDO DA 3A BDA DE INFANTARIA  MOTORIZADA" -> "Comando da 3ª Brigada de Infantaria Motorizada";
            case "23 ESQUADRAO DE CAVALARIA DE SELVA" -> "23º Esquadrão de Cavalaria de Selva";
            case "CENTRO DE DESENVOLVIMENTO DE SISTEMAS" -> "Centro de Desenvolvimento de Sistemas";
            case "3º REGIMENTO DE CARROS DE COMBATE" -> "3º Regimento de Carros de Combate";
            case "4 REGIMENTO DE CARRROS DE COMBATE" -> "4º Regimento de Carros de Combate";
            case "37º BATALHAO DE INFANTARIA LEVE" -> "37º Batalhão de Infantaria Leve";
            case "BATALHAO ESCOLA DE COMUNICACOES" -> "Batalhão Escola de Comunicações";
            case "1 REGIMENTO DE CAVALARIA MECANIZADO" -> "1º Regimento de Cavalaria Mecanizado";
            case "4 BATALHAO DE ENGENHARIA DE COMBATE" -> "4º Batalhão de Engenharia de Combate";
            case "29 BATALHAO DE INFANTARIA BLINDADO" -> "29º Batalhão de Infantaria Blindado";
            case "12 REGIMENTO DE CAVALARIA MECANIZADO" -> "12º Regimento de Cavalaria Mecanizado";
            case "9 REGIMENTO DE CAVALARIA BLINDADO" -> "9º Regimento de Cavalaria Blindado";
            case "COMANDO 8 BRIGADA DE INFANTARIA MOTORIZADA" -> "Comando da 8ª Brigada de Infantaria Motorizada";
            case "4 REGIMENTO DE CAVALARIA BLINDADO" -> "4º Regimento de Cavalaria Blindado";
            case "CMDO DE DEFESA ANTIAEREA DO EXERCITO" -> "Comando de Defesa Antiaérea do Exército";
            case "35º BATALHAO DE INFANTARIA" -> "35º Batalhão de Infantaria";
            case "11 GRUPO DE ARTILHARIA ANTIAEREA" -> "11º Grupo de Artilharia Antiaérea";
            case "5 REGIMENTO DE CAVALARIA MECANIZADO" -> "5º Regimento de Cavalaria Mecanizado";
            case "20 GRUPO DE ARTILHARIA DE CAMPANHA LEVE" -> "20º Grupo de Artilharia de Campanha Leve";
            case "111 COMPANHIA DE APOIO DE MATERIAL BELICO" -> "111ª Companhia de Apoio de Material Bélico";
            case "COMANDO LOGISTICO" -> "Comando Logístico";
            case "19 REGIMENTO DE CAVALARIA MECANIZADO" -> "19º Regimento de Cavalaria Mecanizado";
            case "1ª COMPANHIA DE INFANTARIA" -> "1ª Companhia de Infantaria";
            case "HOSPITAL MILITAR DE AREA DE MANAUS" -> "Hospital Militar de Área de Manaus";
            case "4ª COMPANHIA DE ENGENHARIA COMBATE MECANIZAD" -> "4ª Companhia de Engenharia de Combate Mecanizada";
            case "31º BATALHAO DE INFANTARIA MOTORIZADO" -> "31º Batalhão de Infantaria Motorizado";
            case "12º BATALHAO DE INFANTARIA LEVE-MONTANHA" -> "12º Batalhão de Infantaria Leve de Montanha";
            case "PARQUE REGIONAL DE MANUTENCAO/10" -> "Parque Regional de Manutenção da 10ª Região Militar";
            case "CENTRO DE PREPARACAO OFICIAIS RESERVA/PA" -> "Centro de Preparação de Oficiais da Reserva do Pará";
            case "HOSPITAL MILITAR DE AREA DE BRASILIA" -> "Hospital Militar de Área de Brasília";
            case "3 GRUPO DE ARTILHARIA ANTIAEREA" -> "3º Grupo de Artilharia Antiaérea";
            case "19 GRUPO DE ARTILHARIA DE CAMPANHA" -> "19º Grupo de Artilharia de Campanha";
            case "4 GRUPO DE ARTILHARIA ANTIAEREA" -> "4º Grupo de Artilharia Antiaérea";
            case "15ª COMPANHIA DE INFANTARIA MOTORIZADA" -> "15ª Companhia de Infantaria Motorizada";
            case "1º CENTRO DE GEOINFORMACAO" -> "1º Centro de Geoinformação";
            case "28 GRUPO DE ARTILHARIA DE CAMPANHA" -> "28º Grupo de Artilharia de Campanha";
            case "29 GRUPO DE ARTILHARIA DE CAMPANHA AP" -> "29º Grupo de Artilharia de Campanha (Amapá)";
            case "COMANDO 3 BRIGADA DE CAVALARIA MECANIZADA" -> "Comando da 3ª Brigada de Cavalaria Mecanizada";
            case "HOSPITAL DA GUARNICAO DE MARABA" -> "Hospital da Guarnição de Marabá";
            case "15º GRUPO DE ARTILHARIA DE CAMPANHA AP" -> "15º Grupo de Artilharia de Campanha (Amapá)";
            case "8 REGIMENTO DE CAVALARIA MECANIZADO" -> "8º Regimento de Cavalaria Mecanizado";
            case "COMANDO DE ARTILHARIA DIVISIONARIA/3" ->
                    "Comando de Artilharia Divisionária da 3ª Divisão de Exército";
            case "6 GRUPO DE ARTILHARIA DE CAMPANHA" -> "6º Grupo de Artilharia de Campanha";
            case "HOSPITAL GERAL DO RIO DE JANEIRO" -> "Hospital Geral do Rio de Janeiro";
            case "2º GRUPO DE ARTILHARIA DE CAMPANHA LEVE" -> "2º Grupo de Artilharia de Campanha Leve";
            case "COLEGIO MILITAR DE JUIZ DE FORA" -> "Colégio Militar de Juiz de Fora";
            case "3º CENTRO DE GEOINFORMACAO" -> "3º Centro de Geoinformação";
            case "3ª BATERIA DE ARTILHARIA ANTIAEREA" -> "3ª Bateria de Artilharia Antiaérea";
            case "BIBLIOTECA DO EXERCITO" -> "Biblioteca do Exército";
            case "6 BATALHAO DE COMUNICACOES" -> "6º Batalhão de Comunicações";
            case "11 GRUPO DE ARTILHARIA DE CAMPANHA" -> "11º Grupo de Artilharia de Campanha";
            case "26 GRUPO DE ARTILHARIA DE CAMPANHA" -> "26º Grupo de Artilharia de Campanha";
            case "5º CENTRO DE GEOINFORMACAO" -> "5º Centro de Geoinformação";
            case "25 GRUPO DE ARTILHARIA DE CAMPANHA" -> "25º Grupo de Artilharia de Campanha";
            case "HOSPITAL MILITAR DE AREA DE CAMPO GRANDE" -> "Hospital Militar de Área de Campo Grande";
            case "13 GRUPO DE ARTILHARIA DE CAMPANHA" -> "13º Grupo de Artilharia de Campanha";
            case "3 GRUPO DE ARTILHARIA DE CAMPANHA/AP" -> "3º Grupo de Artilharia de Campanha (Amapá)";
            case "3 BATALHAO DE COMUNICACOES E GUERRA ELETRONIC" -> "3º Batalhão de Comunicações e Guerra Eletrônica";
            case "27 GRUPO DE ARTILHARIA DE CAMPANHA" -> "27º Grupo de Artilharia de Campanha";
            case "10ª COMPANHIA DE ENGENHARIA DE COMBATE" -> "10ª Companhia de Engenharia de Combate";
            case "22 GRUPO DE ARTILHARIA DE CAMP AUTOPROPULSADO" -> "22º Grupo de Artilharia de Campo Autopropulsado";
            case "2ª COMPANHIA DE INFANTARIA" -> "2ª Companhia de Infantaria";
            case "23 COMPANHIA DE ENGENHARIA DE COMBATE" -> "23ª Companhia de Engenharia de Combate";
            case "CAMPO DE INSTRUCAO DE GERICINO" -> "Campo de Instrução de Gericinó";
            case "HOSPITAL GERAL DE CURITIBA" -> "Hospital Geral de Curitiba";
            case "HOSPITAL DE GUARNICAO DE PORTO VELHO" -> "Hospital de Guarnição de Porto Velho";
            case "HOSPITAL DE GUARNICAO DE NATAL" -> "Hospital de Guarnição de Natal";
            case "POLICLINICA MILITAR DO RIO DE JANEIRO" -> "Policlínica Militar do Rio de Janeiro";
            case "HOSPITAL DE GUARNICAO DE BAGE" -> "Hospital de Guarnição de Bagé";
            case "9ª BATERIA DE ARTILHARIA ANTIAEREA" -> "9ª Bateria de Artilharia Antiaérea";
            case "COMISSAO ESPECIAL DE OBRAS DA AMAN" -> "Comissão Especial de Obras da Amazônia Azul";
            case "HOSPITAL GERAL DE FORTALEZA" -> "Hospital Geral de Fortaleza";
            case "16º ESQUADRAO DE CAVALARIA MECANIZADO" -> "16º Esquadrão de Cavalaria Mecanizado";
            case "HOSPITAL GERAL DE JUIZ DE FORA" -> "Hospital Geral de Juiz de Fora";
            case "DIRETORIA DE SISTEMAS E MATERIAL DE EMP MIL" ->
                    "Diretoria de Sistemas e Materiais de Emprego Militar";
            case "4ª COMPANHIA DE COMUNICACOES LEVE-MONTANHA" -> "4ª Companhia de Comunicações Leve de Montanha";
            case "8 ESQUADRAO DE CAVALARIA MECANIZADO" -> "8º Esquadrão de Cavalaria Mecanizado";
            case "1º ESQUADRAO DE CAVALARIA LEVE" -> "1º Esquadrão de Cavalaria Leve";
            case "12º CENTRO DE GESTAO, CONTABILIDADE E FIN EX" ->
                    "12º Centro de Gestão, Contabilidade e Finanças do Exército";
            case "HOSPITAL DE GUARNICAO DE FLORIANOPOLIS" -> "Hospital de Guarnição de Florianópolis";
            case "12 COMPANHIA DE COMUNICACOES MECANIZADA" -> "12ª Companhia de Comunicações Mecanizada";
            case "3 ESQUADRAO DE CAVALARIA MECANIZADO" -> "3º Esquadrão de Cavalaria Mecanizado";
            case "2 BATERIA DE ARTILHARIA ANTIAEREA" -> "2ª Bateria de Artilharia Antiaérea";
            case "HOSPITAL GERAL DE SANTA MARIA" -> "Hospital Geral de Santa Maria";
            case "HOSPITAL DE GUARNICAO DE JOAO PESSOA" -> "Hospital de Guarnição de João Pessoa";
            case "POLICLINICA MILITAR DE PORTO ALEGRE" -> "Policlínica Militar de Porto Alegre";
            case "HOSPITAL GERAL DE SALVADOR" -> "Hospital Geral de Salvador";
            case "GRAFICA DO EXERCITO" -> "Gráfica do Exército";
            case "13 COMPANHIA DEPOSITO ARMAMENTO E MUNICAO" -> "13ª Companhia de Depósito de Armamento e Munição";
            case "HOSPITAL MILITAR DE RESENDE" -> "Hospital Militar de Resende";
            case "13 COMPANHIA DE COMUNICACOES MECANIZADA" -> "13ª Companhia de Comunicações Mecanizada";
            case "5 COMPANHIA DE COMUNICACOES BLINDADA" -> "5ª Companhia de Comunicações Blindada";
            case "5º ESQUADRAO DE CAVALARIA MECANIZADO" -> "5º Esquadrão de Cavalaria Mecanizado";
            case "INSTITUTO DE BIOLOGIA DO EXERCITO" -> "Instituto de Biologia do Exército";
            case "HOSPITAL DA GUARNICAO DE ALEGRETE" -> "Hospital da Guarnição de Alegrete";
            case "HOSPITAL DE GUARNICAO DE SANTIAGO" -> "Hospital de Guarnição de Santiago";
            case "BASE DE APOIO REGIONAL DE RIBEIRAO PRETO" -> "Base de Apoio Regional de Ribeirão Preto";
            case "POLICLINICA MILITAR DE NITEROI" -> "Policlínica Militar de Niterói";
            case "3º CENTRO DE GESTAO, CONT. E FIN. DO EXERCITO" ->
                    "3º Centro de Gestão, Contabilidade e Finanças do Exército";
            case "ODONTOCLINICA CENTRAL DO EXERCITO" -> "Odontoclínica Central do Exército";
            case "BASE DE APOIO REGIONAL DE BAURU" -> "Base de Apoio Regional de Bauru";
            case "BASE DE APOIO REGIONAL DE SOROCABA" -> "Base de Apoio Regional de Sorocaba";
            case "POLICLINICA MILITAR DA PRAIA VERMELHA" -> "Policlínica Militar da Praia Vermelha";
            case "44 BATALHAO INFANTARIA MTZ PATRIMONIAL" -> "44º Batalhão de Infantaria de Montanha Patrimonial";
            case "SUBDIRETORIA DE PAGAMENTO DE PESSOAL/PAIS" -> "Subdiretoria de Pagamento de Pessoal/País";
            case "COMISSAO AERONAUTICA BRASILEIRA NA EUROPA" -> "Comissão Aeronáutica Brasileira na Europa";
            case "CENTRO LOGISTICO DA AERONAUTICA" -> "Centro Logístico da Aeronáutica";
            case "CENTRO DE AQUISICOES ESPECIFICAS" -> "Centro de Aquisições Específicas";
            case "COMISSAO AERONAUTICA BRASILEIRA EM WASHINGTON" -> "Comissão Aeronáutica Brasileira em Washington";
            case "DIRETORIA DE ECON E FINANCAS DA AERONAUTICA" -> "Diretoria de Economia e Finanças da Aeronáutica";
            case "GRUPAMENTO DE APOIO DO RIO DE JANEIRO" -> "Grupamento de Apoio do Rio de Janeiro";
            case "SUBDIRETORIA DE PAGAMENTO DE PESSOAL/EXTERIOR" -> "Subdiretoria de Pagamento de Pessoal/Exterior";
            case "GRUPAMENTO DE APOIO DE BRASILIA" -> "Grupamento de Apoio de Brasília";
            case "DEPARTAMENTO DE CONTROLE DO ESPACO AEREO" -> "Departamento de Controle do Espaço Aéreo";
            case "GRUPAMENTO DE APOIO DO DISTRITO FED" -> "Grupamento de Apoio do Distrito Federal";
            case "GRUPAMENTO DE APOIO DO GALEAO" -> "Grupamento de Apoio do Galeão";
            case "GRUPAMENTO DE APOIO DE S J CAMPOS" -> "Grupamento de Apoio de São José dos Campos";
            case "GRUPAMENTO DE APOIO DE SAO PAULO" -> "Grupamento de Apoio de São Paulo";
            case "GRUPAMENTO DE APOIO DE BELEM" -> "Grupamento de Apoio de Belém";
            case "GRUPAMENTO DE APOIO DOS AFONSOS" -> "Grupamento de Apoio dos Afonsos";
            case "GRUPAMENTO DE APOIO DE RECIFE" -> "Grupamento de Apoio de Recife";
            case "GRUPAMENTO DE APOIO DE MANAUS" -> "Grupamento de Apoio de Manaus";
            case "SEGUNDO CENTRO INT.DEF.AEREA CONTR.TFG.AEREO" ->
                    "Segundo Centro Integrado de Defesa Aérea e Controle de Tráfego Aéreo";
            case "BASE AEREA DE NATAL" -> "Base Aérea de Natal";
            case "GRUPAMENTO DE APOIO DE CANOAS" -> "Grupamento de Apoio de Canoas";
            case "ACADEMIA DA FORCA AEREA" -> "Academia da Força Aérea";
            case "GRUPAMENTO DE APOIO DE LAGOA SANTA" -> "Grupamento de Apoio de Lagoa Santa";
            case "ESCOLA DE ESPECIALISTAS DE AERONAUTICA" -> "Escola de Especialistas de Aeronáutica";
            case "CENTRO DE LANCAMENTO DE ALCANTARA" -> "Centro de Lançamento de Alcântara";
            case "BASE AEREA DE DE ANAPOLIS" -> "Base Aérea de Anápolis";
            case "BASE AEREA DE SANTA CRUZ" -> "Base Aérea de Santa Cruz";
            case "BASE AEREA DE CAMPO GRANDE" -> "Base Aérea de Campo Grande";
            case "BASE AEREA DE SANTA MARIA" -> "Base Aérea de Santa Maria";
            case "BASE AEREA DE SALVADOR" -> "Base Aérea de Salvador";
            case "BASE AEREA DE FORTALEZA" -> "Base Aérea de Fortaleza";
            case "BASE AEREA DE PORTO VELHO" -> "Base Aérea de Porto Velho";
            case "ESCOLA PREPARATORIA DE CADETES DO AR" -> "Escola Preparatória de Cadetes do Ar";
            case "BASE AEREA DE FLORIANOPOLIS" -> "Base Aérea de Florianópolis";
            case "GABINETE DO COMANDANTE DA AERONAUTICA" -> "Gabinete do Comandante da Aeronáutica";
            case "BASE AEREA DE BOA VISTA" -> "Base Aérea de Boa Vista";
            case "BASE DE RECEPCAO DE VETERANOS" -> "Base de Recepção de Veteranos";
            case "CENTRO DE TRANSPORTE LOGISTICO DA AERONAUTICA" -> "Centro de Transporte Logístico da Aeronáutica";
            case "PAGADORIA DE PESSOAL DA MARINHA - PAPEM-PAIS" -> "Pagadoria de Pessoal da Marinha - PAPEM-País";
            case "COORD-GERAL PROG. DESENV. SUBMAR. NUCLEAR" ->
                    "Coordenação Geral de Programas de Desenvolvimento Submarino Nuclear";
            case "COMISSAO NAVAL BRASILEIRA NA EUROPA - LONDRES" -> "Comissão Naval Brasileira na Europa - Londres";
            case "PAGADORIA DE PESSOAL DA MARINHA EXTERIOR." -> "Pagadoria de Pessoal da Marinha Exterior";
            case "CENTRO DE OBTENCAO DA MARINHA NO R.J." -> "Centro de Obtenção da Marinha no Rio de Janeiro";
            case "HOSPITAL NAVAL MARCILIO DIAS" -> "Hospital Naval Marcílio Dias";
            case "CENTRO DE INTENDENCIA TECNOLOGICO DA MARINHA" -> "Centro de Intendência Tecnológico da Marinha";
            case "DIR. DE GESTAO ORCAMENTARIA OP. DE CREDITO" ->
                    "Diretoria de Gestão Orçamentária e Operações de Crédito";
            case "COMISSAO NAVAL BRASILEIRA EM WASHINGTON" -> "Comissão Naval Brasileira em Washington";
            case "ARSENAL DE MARINHA_DO RIO DE JANEIRO" -> "Arsenal de Marinha do Rio de Janeiro";
            case "BASE NAVAL DA ILHA DAS COBRAS" -> "Base Naval da Ilha das Cobras";
            case "BASE NAVAL DO RIO DE JANEIRO" -> "Base Naval do Rio de Janeiro";
            case "HOSPITAL NAVAL DE NATAL" -> "Hospital Naval de Natal";
            case "CENTRO LOGISTICO DO MATERIAL DA MARINHA" -> "Centro Logístico do Material da Marinha";
            case "HOSPITAL NAVAL DE BRASILIA" -> "Hospital Naval de Brasília";
            case "ESCOLA DE APRENDIZES-MARINHEIROS DO CEARA" -> "Escola de Aprendizes-Marinheiros do Ceará";
            case "LABORATORIO FARMACEUTICO DA MARINHA" -> "Laboratório Farmacêutico da Marinha";
            case "HOSPITAL NAVAL DE RECIFE" -> "Hospital Naval de Recife";
            case "CENTRO DE INTENDEN. DA MARINHA EM NITEROI" -> "Centro de Intendência da Marinha em Niterói";
            case "CENTRO DE INTENDENCIA DA MARINHA EM BELEM" -> "Centro de Intendência da Marinha em Belém";
            case "CENTRO TECNOLOGICO DA MARINHA NO RIO DE JANEIRO" -> "Centro Tecnológico da Marinha no Rio de Janeiro";
            case "COMANDO DO 1.DISTRITO NAVAL" -> "Comando do 1º Distrito Naval";
            case "CENTRO DE INTENDENCIA DA MARINHA EM RIO GRAND" -> "Centro de Intendência da Marinha em Rio Grande";
            case "CENTRO DE INTENDENCIA DA MARINHA EM MANAUS" -> "Centro de Intendência da Marinha em Manaus";
            case "BASE DE ABASTEC. DA MARINHA NO RIO DE JANEIRO" ->
                    "Base de Abastecimento da Marinha no Rio de Janeiro";
            case "HOSPITAL NAVAL_DE SALVADOR" -> "Hospital Naval de Salvador";
            case "CENTRO DE INTEND. DA MARINHA EM S.PEDRO DA AL" ->
                    "Centro de Intendência da Marinha em São Pedro da Aldeia";
            case "SERVICO DE VETERANOS E PENS. DA MARINHA" -> "Serviço de Veteranos e Pensões da Marinha";
            case "ESCOLA DE APRENDIZES-MARINHEIROS DO ES" -> "Escola de Aprendizes-Marinheiros do Espírito Santo";
            case "CENTRO DE INTENDENCIA DA MARINHA EM BRASILIA" -> "Centro de Intendência da Marinha em Brasília";
            case "SANATORIO NAVAL DE NOVA FRIBURGO" -> "Sanatório Naval de Nova Friburgo";
            case "CENTRO DE INSTRUCAO ALMIRANTE ALEXANDRINO" -> "Centro de Instrução Almirante Alexandrino";
            case "BASE DE FUZILEIROS NAVAIS DA I. DO GOVERNADOR" -> "Base de Fuzileiros Navais da Ilha do Governador";
            case "SERVICO DE ASSISTENCIA SOCIAL DA MARINHA" -> "Serviço de Assistência Social da Marinha";
            case "ESCOLA DE APRENDIZES-MARINHEIROS DE SC" -> "Escola de Aprendizes-Marinheiros de Santa Catarina";
            case "COMANDO DO 8.DISTRITO NAVAL" -> "Comando do 8º Distrito Naval";
            case "HOSPITAL NAVAL DE BELEM" -> "Hospital Naval de Belém";
            case "BASE DE HIDROGRAFIA DA MARINHA EM NITEROI" -> "Base de Hidrografia da Marinha em Niterói";
            case "BASE AEREA NAVAL DE SAO PEDRO DA ALDEIA" -> "Base Aérea Naval de São Pedro da Aldeia";
            case "CENTRO DE INTENDENCIA DA MARINHA EM LADARIO" -> "Centro de Intendência da Marinha em Ladário";
            case "HOSPITAL NAVAL DE LADARIO" -> "Hospital Naval de Ladário";
            case "CENTRO DE INTEND. DA MARINHA PARADA DE LUCAS" -> "Centro de Intendência da Marinha Parada de Lucas";
            case "BATALHAO NAVAL" -> "Batalhão Naval";
            case "CENTRO DE INSTRUCAO ALMIRANTE GRACA ARANHA" -> "Centro de Instrução Almirante Graça Aranha";
            case "CENTRO DE INTENDENCIA DA MARINHA EM NATAL" -> "Centro de Intendência da Marinha em Natal";
            case "CENTRO DE INTENDENCIA DA MARINHA EM SALVADOR" -> "Centro de Intendência da Marinha em Salvador";
            case "CENTRO DE EDUCACAO FISICA ALTE ADALBE. NUNES" ->
                    "Centro de Educação Física Almirante Adalberto Nunes";
            case "CAPITANIA DOS PORTOS DA PARAIBA" -> "Capitania dos Portos da Paraíba";
            case "ESTACAO NAVAL DO RIO NEGRO" -> "Estação Naval do Rio Negro";
            case "ESCOLA NAVAL" -> "Escola Naval";
            case "DIRETORIA DE FINANCAS DA MARINHA - EXTERIOR" -> "Diretoria de Finanças da Marinha - Exterior";
            case "DIRETORIA DE PORTOS E COSTAS" -> "Diretoria de Portos e Costas";
            case "DIRETORIA DE SISTEMAS DE ARMAS DA MARINHA" -> "Diretoria de Sistemas de Armas da Marinha";
            case "GABINETE DO COMANDANTE DA MARINHA" -> "Gabinete do Comandante da Marinha";
            case "CAPITANIA DOS PORTOS DE ALAGOAS" -> "Capitania dos Portos de Alagoas";
            case "BASE NAVAL DE ARATU" -> "Base Naval de Aratu";
            case "GRUPAMENTO DE NAVIOS HIDROCEANOGRAFICOS" -> "Grupamento de Navios Hidroceanográficos";
            case "CENTRO MEDICO ASSISTENCIAL DA MARINHA" -> "Centro Médico Assistencial da Marinha";
            case "BASE NAVAL DE NATAL" -> "Base Naval de Natal";
            case "BASE FLUVIAL DE LADARIO" -> "Base Fluvial de Ladário";
            case "BASE DE FUZILEIROS NAVAIS DA ILHA DAS FLORES" -> "Base de Fuzileiros Navais da Ilha das Flores";
            case "CAPITANIA DOS PORTOS DE SERGIPE" -> "Capitania dos Portos de Sergipe";
            case "BASE NAVAL DE VAL-DE-CAES" -> "Base Naval de Val-de-Cães";
            case "CAPITANIA DOS PORTOS DE SAO PAULO" -> "Capitania dos Portos de São Paulo";
            case "CAPITANIA DOS PORTOS DO MARANHAO" -> "Capitania dos Portos do Maranhão";
            case "ESTADO-MAIOR DA ARMADA" -> "Estado-Maior da Armada";
            case "DIRETORIA DE ABASTECIMENTO DA MARINHA" -> "Diretoria de Abastecimento da Marinha";
            case "ESTACAO NAVAL DO RIO GRANDE" -> "Estação Naval do Rio Grande";
            case "COMANDO DO MATERIAL DE FUZILEIROS NAVAIS" -> "Comando do Material de Fuzileiros Navais";
            case "CAPITANIA DOS PORTOS DO PARANA" -> "Capitania dos Portos do Paraná";
            case "CAPITANIA DOS PORTOS DO PIAUI" -> "Capitania dos Portos do Piauí";
            case "CENTRO DE INSTRUCAO ALTE. SYLVIO DE CAMARGO" -> "Centro de Instrução Almirante Sílvio de Camargo";
            case "CAPITANIA FLUVIAL DA AMAZONIA OCIDENTAL" -> "Capitania Fluvial da Amazônia Ocidental";
            case "ESCOLA DE GUERRA NAVAL" -> "Escola de Guerra Naval";
            case "POLICLINICA NAVAL NOSSA SENHORA DA GLORIA" -> "Policlínica Naval Nossa Senhora da Glória";
            case "DELEGACIA DA CAPITANIA DOS PORTOS EM ITAJAI" -> "Delegacia da Capitania dos Portos em Itajaí";
            case "CENTRO DE MANUTENCAO DE SISTEMAS DA MARINHA" -> "Centro de Manutenção de Sistemas da Marinha";
            case "INSTITUTO DE EST. DO MAR ALTE PAULO MOREIRA" -> "Instituto de Estudos do Mar Almirante Paulo Moreira";
            case "COMANDO DO GRUPAM. DE PATRULHA NAV. DO SUD" -> "Comando do Grupamento de Patrulha Naval do Sudeste";
            case "CENTRO TECNOLOGICO DO CORPO DE FUZ. NAVAIS" -> "Centro Tecnológico do Corpo de Fuzileiros Navais";
            case "COMANDO DE OPERACOES NAIS" -> "Comando de Operações Navais";
            case "CAPITANIA FLUVIAL DE PORTO ALEGRE" -> "Capitania Fluvial de Porto Alegre";
            case "CENTRO INST.ALMIRANTE MILCIADES PORTELA ALVES" ->
                    "Centro de Instrução Almirante Milcíades Portela Alves";
            case "COLEGIO NAVAL" -> "Colégio Naval";
            case "CAPITANIA FLUVIAL DE MINAS GERAIS" -> "Capitania Fluvial de Minas Gerais";
            case "CAPITANIA DOS PORTOS DO AMAPA" -> "Capitania dos Portos do Amapá";
            case "PAGADORIA DO PESSOAL DA MARINHA -PAPEM-OM" -> "Pagadoria do Pessoal da Marinha - PAPEM-OM";
            case "ESCOLA DE APREND.-MARINHEIROS DE PERNAMBUCO" -> "Escola de Aprendizes-Marinheiros de Pernambuco";
            case "CENTRO DE MISSEIS E ARMAS SUBMAR.DA MARINHA" -> "Centro de Mísseis e Armas Submarinas da Marinha";
            case "DEPOSITO DE COMBUSTIVEIS_DA MB NO RIO JANEIRO" ->
                    "Depósito de Combustíveis da Marinha no Rio de Janeiro";
            case "DIR. DE PATR. HIST. E DOCUMENTACAO DA MARINHA" ->
                    "Diretoria de Patrimônio Histórico e Documentação da Marinha";
            case "COMANDO DO GRUPAM. DE PATRULHA NAV DO SUL-SUD" -> "Comando do Grupamento de Patrulha Naval do Sul";
            case "CENTRO DE INTELIGENCIA DA MARINHA" -> "Centro de Inteligência da Marinha";
            case "CAPITANIA DOS PORTOS DO RIO DE JANEIRO." -> "Capitania dos Portos do Rio de Janeiro";
            case "CENTRO DE MUNICAO DA MARINHA" -> "Centro de Munição da Marinha";
            case "DIR-GERAL DE DESEN.NUCLEAR E TEC.DA MARINHA" ->
                    "Diretoria Geral de Desenvolvimento Nuclear e Tecnológico da Marinha";
            case "CAPITANIA FLUVIAL DO TIETE-PARANA" -> "Capitania Fluvial do Tietê-Paraná";
            case "CENTRO DE INSTRUCAO ALMIRANTE WANDENKOLK" -> "Centro de Instrução Almirante Wandenkolk";
            case "BASE DE SUBMARINOS DA ILHA DA MADEIRA" -> "Base de Submarinos da Ilha da Madeira";
            case "CENTRO DE MANUTENCAO DE EMBARCACOES MIUDAS" -> "Centro de Manutenção de Embarcações Miúdas";
            case "BATALHAO DE OPERACOES ESPECIAIS DE FN" -> "Batalhão de Operações Especiais de Fuzileiros Navais";
            case "UNIDADE INTEGRADA DE SAUDE MENTAL" -> "Unidade Integrada de Saúde Mental";
            case "COMANDO DA FORCA DE SUBMARINOS" -> "Comando da Força de Submarinos";
            case "HOSPITAL CENTRAL_DA MARINHA" -> "Hospital Central da Marinha";
            case "ESTACAO RADIO DA MARINHA_NO RIO DE JANEIRO" -> "Estação Rádio da Marinha no Rio de Janeiro";
            case "CENTRO DE AVALIACAO DA ILHA DA MARAMBAIA" -> "Centro de Avaliação da Ilha da Marambaia";
            case "ODONTOCLINICA CENTRAL DA MARINHA" -> "Odontoclínica Central da Marinha";
            case "DIRETORIA DE SAUDE DA MARINHA" -> "Diretoria de Saúde da Marinha";
            case "CAPITANIA FLUVIAL DE SANTAREM" -> "Capitania Fluvial de Santarém";
            case "SECRETARIA DA COMISSAO INTERMINIST.P/REC.MAR" ->
                    "Secretaria da Comissão Interministerial para Recursos Marinhos";
            case "DEL.DA CAPITANIA DOS PORTOS EM SAO SEBASTIAO" -> "Delegacia da Capitania dos Portos em São Sebastião";
            case "CAPITANIA DOS PORTOS DE SANTA CATARINA" -> "Capitania dos Portos de Santa Catarina";
            case "CAPITANIA FLUVIAL DE PORTO VELHO" -> "Capitania Fluvial de Porto Velho";
            case "BASE ALMIRANTE CASTRO E SILVA" -> "Base Almirante Castro e Silva";
            case "SERVICO DE IDENTIFICACAO DA MARINHA" -> "Serviço de Identificação da Marinha";
            case "CENTRO DE INST. E ADEST. ALM. NEWTON BRAGA" ->
                    "Centro de Instrução e Adestramento Almirante Newton Braga";
            case "SERVICO DE SELECAO DO PESSOAL DA MARINHA" -> "Serviço de Seleção do Pessoal da Marinha";
            case "TRIBUNAL MARITIMO" -> "Tribunal Marítimo";
            case "BASE DE FUZILEIROS NAVAIS DO RIO MERITI" -> "Base de Fuzileiros Navais do Rio Meriti";
            case "DELEGACIA FLUVIAL DE PIRAPORA" -> "Delegacia Fluvial de Pirapora";
            case "CAPITANIA DOS PORTOS DE MACAE" -> "Capitania dos Portos de Macaé";
            case "DELEG.CAPITANIA PORTOS EM ILHEUS" -> "Delegacia da Capitania dos Portos em Ilhéus";
            case "DIRETORIA DE ENSINO DA MARINHA" -> "Diretoria de Ensino da Marinha";
            case "DELEG. DA CAPITANIA DOS PORTOS EM ANGRA DOS REIS" ->
                    "Delegacia da Capitania dos Portos em Angra dos Reis";
            case "DELEGACIA FLUVIAL DE GUAIRA" -> "Delegacia Fluvial de Guaíra";
            case "DIRETORIA-GERAL DO PESSOAL DA MARINHA" -> "Diretoria Geral do Pessoal da Marinha";
            case "DELEG. DA CAP. DOS PORTOS EM ANGRA DOS REIS" -> "Delegacia da Capitania dos Portos em Angra dos Reis";
            case "CENTRO DE OB.DA MARINHA NO RJ APOIO BASE" ->
                    "Centro de Obtenção da Marinha no Rio de Janeiro - Apoio Base";
            case "GRUPAMENTO DE FUZILEIROS NAVAIS DE SANTOS" -> "Grupamento de Fuzileiros Navais de Santos";
            case "DELEGACIA FLUVIAL DE PRESIDENTE EPITACIO" -> "Delegacia Fluvial de Presidente Epitácio";
            case "ESTACAO RADIOGONIOMETRICA MB EM CAMPOS NOVOS" ->
                    "Estação Radiogoniométrica da Marinha em Campos Novos";
            case "CENTRO DE INSTR.E ADESTR.ALM.ATTILA M.ACHE" ->
                    "Centro de Instrução e Adestramento Almirante Attila Monteiro Aché";
            case "DELEG.CAPITANIA DOS PORTOS EM LAGUNA" -> "Delegacia da Capitania dos Portos em Laguna";
            case "COMISSAO DE PROMOCOES DE OFICIAIS" -> "Comissão de Promoções de Oficiais";
            case "DIRETORIA DE ASSISTENCIA SOCIAL DA MARINHA" -> "Diretoria de Assistência Social da Marinha";
            case "CENTRO DE ADESTRAMENTO ALM.MARQUES DE LEAO" -> "Centro de Adestramento Almirante Marques de Leão";
            case "CENTRO DE MEDICINA OPERATIVA DA MARINHA" -> "Centro de Medicina Operativa da Marinha";
            case "PROCURADORIA ESPECIAL DA MARINHA" -> "Procuradoria Especial da Marinha";
            case "24º BATALHAO DE INFANTARIA SELVA" -> "24º Batalhão de Infantaria de Selva";
            case "5 BATALHAO DE INFANTARIA LEVE - 5 B I L" -> "5º Batalhão de Infantaria Leve";
            case "11.BATALHAO DE INFANTARIA DE MONTANHA" -> "11º Batalhão de Infantaria de Montanha";
            case "72 BATALHAO DE INFANTARIA CAATINGA" -> "72º Batalhão de Infantaria de Caatinga";
            case "COMANDO DA 1ª REGIAO MILITAR" -> "Comando da 1ª Região Militar";
            case "71 BATALHAO DE INFANTARIA MOTORIZADO" -> "71º Batalhão de Infantaria Motorizado";
            case "COMANDO DA 8ª REGIAO MILITAR" -> "Comando da 8ª Região Militar";
            case "COMISSAO REGIONAL DE OBRAS DA 8ªRM" -> "Comissão Regional de Obras da 8ª Região Militar";
            case "ESCOLA DE FORMACAO COMPLEMENTAR DO EXERCITO" -> "Escola de Formação Complementar do Exército";
            case "BASE DE ADMINISTRACAO E APOIO DA 1ª RM" -> "Base de Administração e Apoio da 1ª Região Militar";
            case "51º BATALHAO DE INFANTARIA DE SELVA" -> "51º Batalhão de Infantaria de Selva";
            case "BASE DE ADM E APOIO DO CMDO MILITAR DO OESTE" ->
                    "Base de Administração e Apoio do Comando Militar do Oeste";
            case "7.DEPOSITO DE SUPRIMENTO" -> "7º Depósito de Suprimento";
            case "CENTRO DE CAP.FISIC DO EXERC.E FORT.SAO JOAO" ->
                    "Centro de Capacitação Física do Exército Forte São João";
            case "10. COMPANHIA DE ENGENHARIA DE COMBATE" -> "10ª Companhia de Engenharia de Combate";
            case "1 ESQUADRAO DE CAVALARIA LEVE" -> "1º Esquadrão de Cavalaria Leve";
            case "CPOR E COLEGIO MILITAR DE SAO PAULO" -> "CPOR e Colégio Militar de São Paulo";
            case "2 BATALHAO DE INFANTARIA DE SELVA" -> "2º Batalhão de Infantaria de Selva";
            case "CENTRO DE AVALIACAO DO EXERCITO" -> "Centro de Avaliações do Exército";
            case "COMANDO DE FRONT.-RR E 7.BAT.DE INF.DE SELVA" ->
                    "Comando de Fronteira Roraima e 7º Batalhão de Infantaria de Selva";
            case "12º BATALHAO DE ENGENHARIA DE COM.BLINDADO" -> "12º Batalhão de Engenharia de Combate Blindado";
            case "1 BATALHAO DE INFANTARIA DE SELVA (AEROMOVEL)" -> "1º Batalhão de Infantaria de Selva (Aeromóvel)";
            case "BATALHAO ESCOLA DE ENGENHARIA" -> "Batalhão Escola de Engenharia";
            case "4ªCOMPANHIA DE COMUNICACOES LEVE-MONTANHA" -> "4ª Companhia de Comunicações Leve de Montanha";
            case "20 GRUPO DE ARTILHARIA DE CAMPANHA" -> "20º Grupo de Artilharia de Campanha";
            case "29 GRUPO DE ARTILHARIA DE C.AUTO PROPULSADO" -> "29º Grupo de Artilharia de Campanha Autopropulsado";
            case "7 BATALHAO DE ENGENHARIA DE CONSTRUCAO" -> "7º Batalhão de Engenharia de Construção";
            case "11º GRUPO DE ARTILHARIA DE CAMPANHA" -> "11º Grupo de Artilharia de Campanha";
            case "21 COMPANHIA DE ENGENHARIA DE CONSTRUCAO" -> "21ª Companhia de Engenharia de Construção";
            case "DEPARTAMENTO DO PROGRAMA CALHA NORTE" -> "Departamento do Programa Calha Norte";
            case "HOSPITAL DAS FORCAS ARMADAS" -> "Hospital das Forças Armadas";
            case "SECRETARIA EXECUTIVA/OPERACAO ACOLHIDA" -> "Secretaria Executiva/Operação Acolhida";
            case "DEPARTAMENTO DE ADMINISTRACAO INTERNA-MD" -> "Departamento de Administração Interna - MD";
            case "CENTRO GESTOR OP. SISTEMA PROTECAO AMAZONIA" ->
                    "Centro Gestor de Operações do Sistema de Proteção da Amazônia";
            case "ESCOLA SUPERIOR DE DEFESA" -> "Escola Superior de Defesa";
            case "ESCOLA SUPERIOR DE GUERRA" -> "Escola Superior de Guerra";
            case "REPRESENT.DO BRASIL NA JUNTA INTERAM.DEFESA" ->
                    "Representação do Brasil na Junta Interamericana de Defesa";
            case "AMAZONIA AZUL TECNOL. DE DEFESA S.A - AMAZUL" -> "Amazônia Azul Tecnologia de Defesa S.A - Amazul";
            case "INDUSTRIA DE MATERIAL BELICO DO BRASIL - UA" -> "Indústria de Material Bélico do Brasil - UA";
            case "INDUSTRIA DE MATERIAL BELICO DO BRASIL/FJF" -> "Indústria de Material Bélico do Brasil/FJF";
            case "INDUSTRIA DE MATERIAL BELICO DO BRASIL/FI" -> "Indústria de Material Bélico do Brasil/FI";
            case "INDUSTRIA DE MATERIAL BELICO DO BRASIL/FPV" -> "Indústria de Material Bélico do Brasil/FPV";
            case "INDUSTRIA DE MATERIAL BELICO DO BRASIL/FE" -> "Indústria de Material Bélico do Brasil/FE";
            case "INDUSTRIA DE MATERIAL BELICO DO BRASIL/FMCE" -> "Indústria de Material Bélico do Brasil/FMCE";
            case "CCCPM - OPERAC. DOS FIN. IMOB E SIMP" ->
                    "CCCPM - Operações dos Financiamentos Imobiliários e Simples";
            case "CAIXA DE CONSTR DE CASAS P/ O PESSOAL DA MARI" ->
                    "Caixa de Construção de Casas para o Pessoal da Marinha";
            case "FUNDACAO OSORIO" -> "Fundação Osório";
            case "CAIXA FINANCIAMENTO IMOBILIARIO AERONAUTICA" -> "Caixa de Financiamento Imobiliário da Aeronáutica";
            case "COORD-GERAL DE RECURSOS DO FAT - CGFAT" -> "Coordenação Geral de Recursos do FAT - CGFAT";
            case "SECRETARIA DE QUALIFICACAO FOMENTO G EMP REND" ->
                    "Secretaria de Qualificação, Fomento, Geração de Emprego e Renda";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/AL" -> "Superintendência Regional do Trabalho/Alagoas";
            case "DEPARTAMENTO DE GESTAO DE PESSOAS-DGP" -> "Departamento de Gestão de Pessoas - DGP";
            case "COORDENACAO-GERAL DE RECURSOS LOGISTICOS" -> "Coordenação Geral de Recursos Logísticos";
            case "COORD-GERAL DE GESTAO DE PESSOAS - COGEP" -> "Coordenação Geral de Gestão de Pessoas - COGEP";
            case "CEF - CONTRIBUICOES SOCIAIS - LC N. 110/2001" ->
                    "CEF - Contribuições Sociais - Lei Complementar nº 110/2001";
            case "SECRETARIA NACIONAL DE ECON POPULAR E SOLIDAR" ->
                    "Secretaria Nacional de Economia Popular e Solidária";
            case "SECRETARIA EXECUTIVA/MTE" -> "Secretaria Executiva/MTE";
            case "SECRETARIA DE INSPECAO DO TRABALHO - SIT" -> "Secretaria de Inspeção do Trabalho - SIT";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/SP" -> "Superintendência Regional do Trabalho/São Paulo";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/MG" -> "Superintendência Regional do Trabalho/Minas Gerais";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/MS" ->
                    "Superintendência Regional do Trabalho/Mato Grosso do Sul";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/PA" -> "Superintendência Regional do Trabalho/Pará";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/AM" -> "Superintendência Regional do Trabalho/Amazonas";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/BA" -> "Superintendência Regional do Trabalho/Bahia";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/GO" -> "Superintendência Regional do Trabalho/Goiás";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/ES" -> "Superintendência Regional do Trabalho/Espírito Santo";
            case "SECRETARIA DE RELACOES DO TRABALHO - SRT" -> "Secretaria de Relações do Trabalho - SRT";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/MA" -> "Superintendência Regional do Trabalho/Maranhão";
            case "UCP/SE/MF-PNAFM III" ->
                    "Unidade Central de Pagamento da Secretaria de Estado da Fazenda do Ministério da Fazenda - PNAFM III";
            case "FNDE - BIRD" -> "Fundo Nacional de Desenvolvimento da Educação - BIRD";
            case "EBSERH CHC-UFPR" ->
                    "Empresa Brasileira de Serviços Hospitalares - Complexo Hospital de Clínicas da Universidade Federal do Paraná";
            case "EBSERH HC-UFPE" ->
                    "Empresa Brasileira de Serviços Hospitalares - Hospital das Clínicas da Universidade Federal de Pernambuco";
            case "EBSERH HU-UFGD" ->
                    "Empresa Brasileira de Serviços Hospitalares - Hospital Universitário da Universidade Federal da Grande Dourados";
            case "FUNDACAO UNIVERS.FED. DE MATO GROSSO DO SUL" -> "Fundação Universidade Federal de Mato Grosso do Sul";
            case "INST.FED. DO RN/CAMPUS IPANGUACU" -> "Instituto Federal do Rio Grande do Norte - Campus Ipanguaçu";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DA BAHIA" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia da Bahia";
            case "INST.FED.DE EDUC.,CIENC.E TEC.DO TOCANTINS" ->
                    "Instituto Federal de Educação, Ciência e Tecnologia do Tocantins";
            case "CENTRO DE CAP.FISIC.DO EXERCIT. FORT.SAO JOAO" ->
                    "Centro de Capacitação Física do Exército - Forte São João";
            case "DEPARTAMENTO DE EDUCACAO E CULTURA DO EXERCIT" -> "Departamento de Educação e Cultura do Exército";
            case "CPOR E COLEGIO MILILTAR DE SAO PAULO" ->
                    "Corpo de Preparação de Oficiais da Reserva e Colégio Militar de São Paulo";
            case "3 COMPANHIA DE ENGENHARIA DE COMB. MECANIZADO" -> "3ª Companhia de Engenharia de Combate Mecanizado";
            case "3º CENTRO DE GESTAO, CONT. E FIN. DO EXERCIT" ->
                    "3º Centro de Gestão, Controle e Finanças do Exército";
            case "CENTRO TECNOLOGICO DA MARINHA NO RIO DE JANEI" -> "Centro Tecnológico da Marinha no Rio de Janeiro";
            case "COMANDO DO GRUPAMENTO DE PATRULHA NAV. DO SUD" -> "Comando do Grupamento de Patrulha Naval do Sul";
            case "COMANDO DE OPERACOES NAVAIS" -> "Comando de Operações Navais";
            case "CAPITANIA FLUVIAL DO RIO PARANA" -> "Capitania Fluvial do Rio Paraná";
            case "DELEGACIA DA CP EM SAO FRANCISCO DO SUL" ->
                    "Delegacia da Capitania dos Portos em São Francisco do Sul";
            case "CAPITANIA DOS PORTOS DO ESPIRITO SANTO" -> "Capitania dos Portos do Espírito Santo";
            case "DIRETORIA DO PESSOAL DA MARINHA" -> "Diretoria do Pessoal da Marinha";
            case "CENTRO DE COMUNICACAO SOCIAL DA MARINHA" -> "Centro de Comunicação Social da Marinha";
            case "SECRETARIA-GERAL DA MARINHA" -> "Secretaria-Geral da Marinha";
            case "COMANDO DO 7.DN" -> "Comando do 7º Distrito Naval";
            case "GRUPAMENTO DE FUZILEIROS NAVAIS_DO RJ" -> "Grupamento de Fuzileiros Navais do Rio de Janeiro";
            case "CASA DO MARINHEIRO" -> "Casa do Marinheiro";
            case "DELEG. DA CAPITANIA DOS PORTOS EM ITACURUCA" -> "Delegacia da Capitania dos Portos em Itacuruçá";
            case "DELEG. DA CAPIT. DOS PORTOS EM ANGRA DOS REIS" ->
                    "Delegacia da Capitania dos Portos em Angra dos Reis";
            case "DIRETORIA DO PESSOAL DA MARINHA BRASILIA DPM" -> "Diretoria do Pessoal da Marinha - Brasília DPM";
            case "12º BATALHAO DE ENGENHARIA DE COMB.BLINDADO" -> "12º Batalhão de Engenharia de Combate Blindado";
            case "SECRETARIA DE PROTECAO AO TRABALHADOR" -> "Secretaria de Proteção ao Trabalhador";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/RJ" ->
                    "Superintendência Regional do Trabalho no Rio de Janeiro";
            case "SUPERINT. DO DESENVOLVIMENTO DA AMAZONIA" -> "Superintendência do Desenvolvimento da Amazônia";
            case "SUPERINT. DO DESENVOLVIMENTO DO CENTRO-OESTE" ->
                    "Superintendência do Desenvolvimento do Centro-Oeste";
            case "SUPERINTENDENCIA DO DESENVOLV. DO NORDESTE" -> "Superintendência do Desenvolvimento do Nordeste";
            case "SUPERINT. REG. ADM. DO MGI - GOIAS/TOCANTINS" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Goiás/Tocantins";
            case "SUPERINT. REG. ADM. DO MGI - RIO DE JANEIRO" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Rio de Janeiro";
            case "SUPERINT.REG. ADM.DO MGI - RIO GRANDE SUL" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Rio Grande do Sul";
            case "SUPERINTENDENCIA REG. ADM. DO MGI-PERNANBUCO" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Pernambuco";
            case "SUPERINT. REG. ADM. DO MGI - SANTA CATARINA" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Santa Catarina";
            case "SUPERINT. REG. ADM. DO MGI-MATO GROSSO DO SUL" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Mato Grosso do Sul";
            case "SUPERINT.REG.ADM.DO MGI-RIO GRANDE DO NORTE" ->
                    "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Rio Grande do Norte";
            case "CIA.BRASILEIRA DE TRENS URBANOS-STU/REC" ->
                    "Companhia Brasileira de Trens Urbanos - Superintendência de Trens Urbanos em Recife";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO RJ" -> "Superintendência Regional no Estado do Rio de Janeiro";
            case "SUPERINTENDENCIA REG DE POLICIA FEDERAL EM MG" ->
                    "Superintendência Regional da Polícia Federal em Minas Gerais";
            case "SUPERINTENDENCIA DA PRF NO RIO GRANDE DO NORT" ->
                    "Superintendência da Polícia Rodoviária Federal no Rio Grande do Norte";
            case "CENTRO DE TECN. DA INF. RENATO ARCHER - CTI" ->
                    "Centro de Tecnologia da Informação Renato Archer - CTI";
            case "SUPERINTENDENCIA REG. NO ESTADO PI - DNIT" -> "Superintendência Regional no Estado do Piauí - DNIT";
            case "CONAB - SEDE SUREG SAO PAULO" ->
                    "Companhia Nacional de Abastecimento - Superintendência Regional de São Paulo";
            case "MO - MG" -> "Minas Gerais";
            case "UNID. MERC. OPCOES PIAUI" -> "Unidade de Mercado de Opções do Piauí";
            case "NUCLEO ESTOQUE REGULADOR/AC - PGPM" -> "Núcleo de Estoque Regulador do Acre - PGPM";
            case "SUPERINT.REGIONAL DO R.GRANDE DO NORTE SR(RN)" ->
                    "Superintendência Regional do Rio Grande do Norte - SR(RN)";
            case "SUPERINT. REG. DO OESTE DO PARA - SR(PA/O)" ->
                    "Superintendência Regional do Oeste do Pará - SR(PA/O)";
            case "SUPERINT. REG. DO RIO DE JANEIRO - SR(RJ)" -> "Superintendência Regional do Rio de Janeiro - SR(RJ)";
            case "FNC - SEFIC" -> "Fundo Nacional de Cultura - Secretaria de Fomento e Incentivo à Cultura";
            case "FNC - SCDC" -> "Fundo Nacional de Cultura - Secretaria de Cidadania e Diversidade Cultural";
            case "FNC - SEEC" -> "Fundo Nacional de Cultura - Secretaria Especial de Economia Criativa";
            case "FNC - SAV" -> "Fundo Nacional de Cultura - Secretaria de Articulação e Vinculação";
            case "COORD.GERAL DE LICIT., CONTRAT. E REC. LOGIST" ->
                    "Coordenação-Geral de Licitações, Contratos e Recursos Logísticos";
            case "SECRETARIA NACIONAL DE JUVENTUDE/PR" ->
                    "Secretaria Nacional de Juventude da Presidência da República";
            case "COGEP - MTUR" -> "Coordenação-Geral de Gestão de Pessoas do Ministério do Turismo";
            case "COORDENACAO REG. DO ALTO SOLIMOES/AM" -> "Coordenação Regional do Alto Solimões no Amazonas";
            case "FUNAI-COORDENACAO REGIONAL DO LITORAL SUL/SC" ->
                    "Fundação Nacional do Índio - Coordenação Regional do Litoral Sul em Santa Catarina";
            case "COORD. REG. RIBEIRAO CASCALHEIRA/MT" -> "Coordenação Regional de Ribeirão Cascalheira em Mato Grosso";
            case "COORD.REG.DE MINAS GERAIS E ESPIRITO SANTO/MG" ->
                    "Coordenação Regional de Minas Gerais e Espírito Santo";
            case "GESTAO TERRITORIAL INDIGENA SARARE - MT" -> "Gestão Territorial Indígena Sararé em Mato Grosso";
            case "UHE BELO MONTE TI ARAWETE IGARAPE IPIXUNA" ->
                    "Usina Hidrelétrica de Belo Monte - Terra Indígena Araweté Igarapé Ipixuna";
            case "UHE BELO MONTE TI TRINCHEIRA BACAJA" ->
                    "Usina Hidrelétrica de Belo Monte - Terra Indígena Trincheira Bacajá";
            case "RENDA INDIGENA - FUNAI - SEDE" -> "Renda Indígena - Fundação Nacional do Índio - Sede";
            case "UHE BELO MONTE TI JURUNA KM 17" -> "Usina Hidrelétrica de Belo Monte - Terra Indígena Juruna KM 17";
            case "CAIXA/MMFDH" -> "Caixa Econômica Federal - Ministério da Mulher, da Família e dos Direitos Humanos";
            case "JUSTIÇA FEDERAL DE PRIMEIRO GRAU - PB" -> "Justiça Federal de Primeiro Grau na Paraíba";
            case "JUSTIÇA FEDERAL DE PRIMEIRO GRAU - MT" -> "Justiça Federal de Primeiro Grau em Mato Grosso";
            case "JUSTIÇA FEDERAL DE PRIMEIRO GRAU - AM" -> "Justiça Federal de Primeiro Grau no Amazonas";
            default -> unidadeGestora.getNameUnidadeGestora();
        };
        unidadeGestora.setNameUnidadeGestora(updatedName);
    }

    private void correctUnidadeGestoraNames3(UnidadeGestora unidadeGestora) {
        String updatedName = switch (unidadeGestora.getNameUnidadeGestora()) {
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/RS" ->
                    "Superintendência Regional do Trabalho/Rio Grande do Sul";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/SC" -> "Superintendência Regional do Trabalho/Santa Catarina";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/AC" -> "Superintendência Regional do Trabalho/Acre";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/RN" ->
                    "Superintendência Regional do Trabalho/Rio Grande do Norte";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/MT" -> "Superintendência Regional do Trabalho/Mato Grosso";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/PR" -> "Superintendência Regional do Trabalho/Paraná";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/AP" -> "Superintendência Regional do Trabalho/Amapá";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/CE" -> "Superintendência Regional do Trabalho/Ceará";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/RO" -> "Superintendência Regional do Trabalho/Rondônia";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/SE" -> "Superintendência Regional do Trabalho/Sergipe";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/PB" -> "Superintendência Regional do Trabalho/Paraíba";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/PI" -> "Superintendência Regional do Trabalho/Piauí";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/TO" -> "Superintendência Regional do Trabalho/Tocantins";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/PE" -> "Superintendência Regional do Trabalho/Pernambuco";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/RR" -> "Superintendência Regional do Trabalho/Roraima";
            case "SUPERINTENDENCIA REGIONAL DO TRABALHO/DF" -> "Superintendência Regional do Trabalho/Distrito Federal";
            case "GABINETE DO MINISTRO - GM" -> "Gabinete do Ministro";
            case "FUNDACENTRO - FUND.JORGE DUPRAT/CTN/SEDE - SP" ->
                    "Fundacentro - Fundação Jorge Duprat/CTN/Sede - São Paulo";
            case "FUNDACENTRO/ESCRITORIO AVANCADO NO EST. DE MG" ->
                    "Fundacentro/Escritório Avançado no Estado de Minas Gerais";
            case "FUNDACENTRO/UNIDADE DESC. CAMPINAS/SP" -> "Fundacentro/Unidade Descentralizada em Campinas/SP";
            case "FUNDACENTRO/ESCRITORIO AVANCADO NO EST. DO PE" ->
                    "Fundacentro/Escritório Avançado no Estado de Pernambuco";
            case "FUNDACENTRO/ESCRITORIO AVANCADO NO EST. DO RJ" ->
                    "Fundacentro/Escritório Avançado no Estado do Rio de Janeiro";
            case "FUNDACENTRO/ESCRITORIO AVANCADO NO EST. DE SC" ->
                    "Fundacentro/Escritório Avançado no Estado de Santa Catarina";
            case "TRIBUNAL REGIONAL FEDERAL DA 1A.REG.-PREC.RPV" ->
                    "Tribunal Regional Federal da 1ª Região - Presidência";
            case "TRIBUNAL REGIONAL FEDERAL 4ª REGIAO-PREC/RPVS" ->
                    "Tribunal Regional Federal da 4ª Região - Presidência";
            case "Supremo Tribunal Federal" -> "Supremo Tribunal Federal";
            case "TRIBUNAL REGIONAL FEDERAL 5A REGIãO-PREC/RPV" ->
                    "Tribunal Regional Federal da 5ª Região - Presidência";
            case "TRIBUNAL REGIONAL FEDERAL DA 3A.REGIAO-PR.RPV" ->
                    "Tribunal Regional Federal da 3ª Região - Presidência";
            case "TRIBUNAL REGIONAL FEDERAL DA 2A. REG.-PR. RPV" ->
                    "Tribunal Regional Federal da 2ª Região - Presidência";
            case "TRIBUNAL REGIONAL FEDERAL 6A REGIAO-PREC/RPV" ->
                    "Tribunal Regional Federal da 6ª Região - Presidência";
            case "FUNDO CONSTITUCIONAL DE FINANCIAM.DO NORDESTE" -> "Fundo Constitucional de Financiamento do Nordeste";
            case "SECRETARIA NACIONAL PROTECAO E DEFESA CIVIL" -> "Secretaria Nacional de Proteção e Defesa Civil";
            case "SECRETARIA NACIONAL DE SEGURANCA HIDRICA SNSH" -> "Secretaria Nacional de Segurança Hídrica";
            case "CAIXA ECONOMICA FEDERAL - MI" -> "Caixa Econômica Federal - MI";
            case "SEC. NAC. POLIT. DESENV. REG. E TERRITORIAL" ->
                    "Secretaria Nacional de Política de Desenvolvimento Regional e Territorial";
            case "MIDR/ADMINISTRACAO GERAL" -> "MIDR/Administração Geral";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS/MIDR" -> "Coordenação Geral de Gestão de Pessoas/MIDR";
            case "FUNDO CONSTITUCIONL DO CENTRO OESTE" -> "Fundo Constitucional do Centro-Oeste";
            case "FUNDO CONSTITUCIONAL FINANCIAMENTO NORTE" -> "Fundo Constitucional de Financiamento do Norte";
            case "CIA DE DES.DOS VALES DO S.FRANC.E DO PARNAIBA" ->
                    "Companhia de Desenvolvimento dos Vales do São Francisco e do Parnaíba";
            case "CIA DE DES.DOS VALES DO S.FRANC E DO PARNAIBA" ->
                    "Companhia de Desenvolvimento dos Vales do São Francisco e do Parnaíba";
            case "DEPARTAMENTO NACIONAL DE OBRAS CONT.AS SECAS" -> "Departamento Nacional de Obras Contra as Secas";
            case "DNOCS - CEST/BA - SALVADOR - BA" -> "DNOCS - Centro Estadual de Salvador - BA";
            case "DNOCS - CEST/PB - JOAO PESSOA - PB" -> "DNOCS - Centro Estadual de João Pessoa - PB";
            case "DNOCS CEST/CE - FORTALEZA-CE" -> "DNOCS - Centro Estadual de Fortaleza - CE";
            case "DNOCS - CEST/AL-PALMEIRA DOS INDIOS" -> "DNOCS - Centro Estadual de Palmeira dos Índios - AL";
            case "DNOCS CEST/PI-TERESINA-PI" -> "DNOCS - Centro Estadual de Teresina - PI";
            case "DNOCS - CEST/SE ARACAJU - SE" -> "DNOCS - Centro Estadual de Aracaju - SE";
            case "DNOCS - CEST/RN - NATAL-RN" -> "DNOCS - Centro Estadual de Natal - RN";
            case "DNOCS - CEST/MG - MONTES CLAROS-MG" -> "DNOCS - Centro Estadual de Montes Claros - MG";
            case "DNOCS - CEST/PE - RECIFE-PE" -> "DNOCS - Centro Estadual de Recife - PE";
            case "FUNDO DE DESENVOLVIMENTO DO NORDESTE" -> "Fundo de Desenvolvimento do Nordeste";
            case "FUNDO DE DESENVOLVIMENTO DA AMAZONIA" -> "Fundo de Desenvolvimento da Amazônia";
            case "AGENCIA NACIONAL DE AGUAS E SANEAMENTO BASICO" -> "Agência Nacional de Águas e Saneamento Básico";
            case "GESTAO RECURSOS HIDRICOS - CEF" -> "Gestão de Recursos Hídricos - CEF";
            case "FUNDO DE DESENVOLVIMENTO DO CENTRO-OESTE" -> "Fundo de Desenvolvimento do Centro-Oeste";
            case "SUPERINTENDENCIA DO DESENVOLVIMENTO DA AMAZONIA" -> "Superintendência do Desenvolvimento da Amazônia";
            case "SUPERINTENDENCIA DO DESENVOLV. DO CENTRO-OESTE" ->
                    "Superintendência do Desenvolvimento do Centro-Oeste";
            case "CAIXA ECONOMICA FEDERAL - SUDECO" -> "Caixa Econômica Federal - SUDECO";
            case "SUPERINTENDENCIA DO DESENVOLVIMENTO DO NORDESTE" -> "Superintendência do Desenvolvimento do Nordeste";
            case "DIR. CENTRAL.SERV.INATIVOS,PENSIONIST.ORG.EXT" ->
                    "Direção Central de Serviços Inativos, Pensionistas e Organizações Externas";
            case "DIVISAO DE PESSOAL EX-TERRITORIO DO AMAPA" -> "Divisão de Pessoal do Ex-Território do Amapá";
            case "FOLHA DE PAGAMENTO - MGI" -> "Folha de Pagamento - MGI";
            case "DIVISAO DE PESSOAL EX-TERRITORIO DE RONDONIA" -> "Divisão de Pessoal do Ex-Território de Rondônia";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MGI" -> "Centro de Serviços Compartilhados - MGI";
            case "ANTIGO ESTADO DO DISTRITO FEDERAL - RJ" -> "Antigo Estado do Distrito Federal - RJ";
            case "DIVISAO DE PESSOAL EX-TERRITORIO DE RORAIMA" -> "Divisão de Pessoal do Ex-Território de Roraima";
            case "CENTRAL DE COMPRAS" -> "Central de Compras";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - SAO PAULO" ->
                    "Superintendência Regional Administrativa do MGI - São Paulo";
            case "SUPERINTENDENCIA REG.ADM.DO MGI-MINAS GERAIS" ->
                    "Superintendência Regional Administrativa do MGI - Minas Gerais";
            case "SUPERINT. REG. ADM. DO MGI - ESPIRITO SANTO" ->
                    "Superintendência Regional Administrativa do MGI - Espírito Santo";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS - MF" -> "Coordenação Geral de Gestão de Pessoas - MF";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - GOIAS/TOCANTINS" ->
                    "Superintendência Regional Administrativa do MGI - Goiás/Tocantins";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - RIO DE JANEIRO" ->
                    "Superintendência Regional Administrativa do MGI - Rio de Janeiro";
            case "ARQUIVO NACIONAL" -> "Arquivo Nacional";
            case "COORDENACAO-GERAL DE PAGAMENTOS" -> "Coordenação Geral de Pagamentos";
            case "DIVISAO DE DIARIAS E PASSAGENS - DAL/ME" -> "Divisão de Diárias e Passagens - DAL/ME";
            case "SECRETARIA DO PATRIMONIO DA UNIAO" -> "Secretaria do Patrimônio da União";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - BAHIA" ->
                    "Superintendência Regional Administrativa do MGI - Bahia";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - RIO GRANDE SUL" ->
                    "Superintendência Regional Administrativa do MGI - Rio Grande do Sul";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - CEARA" ->
                    "Superintendência Regional Administrativa do MGI - Ceará";
            case "SUPERINTENDENCIA REG. ADM. DO MGI-MATO GROSSO" ->
                    "Superintendência Regional Administrativa do MGI - Mato Grosso";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - PARANA" ->
                    "Superintendência Regional Administrativa do MGI - Paraná";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - SANTA CATARINA" ->
                    "Superintendência Regional Administrativa do MGI - Santa Catarina";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - PARA" -> "Superintendência Regional Administrativa do MGI - Pará";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - MARANHAO" ->
                    "Superintendência Regional Administrativa do MGI - Maranhão";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - ALAGOAS" ->
                    "Superintendência Regional Administrativa do MGI - Alagoas";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - PIAUI" ->
                    "Superintendência Regional Administrativa do MGI - Piauí";
            case "SUPERINTENDENCIA REG. ADM. DO MGI-MATO GROSSO DO SUL" ->
                    "Superintendência Regional Administrativa do MGI - Mato Grosso do Sul";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - PARAIBA" ->
                    "Superintendência Regional Administrativa do MGI - Paraíba";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - ACRE" -> "Superintendência Regional Administrativa do MGI - Acre";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - AMAZONAS" ->
                    "Superintendência Regional Administrativa do MGI - Amazonas";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - RORAIMA" ->
                    "Superintendência Regional Administrativa do MGI - Roraima";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - RONDONIA" ->
                    "Superintendência Regional Administrativa do MGI - Rondônia";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - SERGIPE" ->
                    "Superintendência Regional Administrativa do MGI - Sergipe";
            case "SUPERINTENDENCIA REG. ADM. DO MGI - AMAPA" ->
                    "Superintendência Regional Administrativa do MGI - Amapá";
            case "SECRETARIA DE GESTAO E INOVACAO" -> "Secretaria de Gestão e Inovação";
            case "SECRETARIA DE GESTAO DE PESSOAS" -> "Secretaria de Gestão de Pessoas";
            case "SECRET.DE COORD.E GOVERNANCA DAS EMP.ESTATAIS" ->
                    "Secretaria de Coordenação e Governança das Empresas Estatais";
            case "SECRETARIA DE RELACOES DE TRABALHO" -> "Secretaria de Relações do Trabalho";
            case "FUNDACAO ESCOLA NACIONAL DE ADM. PUBLICA" -> "Fundação Escola Nacional de Administração Pública";
            case "INSTITUTO NAC.DE TECNOLOGIA DA INFORMACAO ITI" ->
                    "Instituto Nacional de Tecnologia da Informação - ITI";
            case "SECRETARIA NACIONAL DE HABITACAO" -> "Secretaria Nacional de Habitação";
            case "SECRETARIA NACIONAL DE SANEAMENTO AMBIENTAL" -> "Secretaria Nacional de Saneamento Ambiental";
            case "CAIXA ECONOMICA FEDERAL - PROGRAMAS SOCIAIS" -> "Caixa Econômica Federal - Programas Sociais";
            case "CAIXA ECON.FEDERAL-PROG.NAC.HAB.RURAL/PMCMV" ->
                    "Caixa Econômica Federal - Programa Nacional de Habitação Rural/PMCMV";
            case "COORDENACAO-GERAL DE SUPORTE LOGISTICO - MCID" -> "Coordenação Geral de Suporte Logístico - MCID";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS - MCID" -> "Coordenação Geral de Gestão de Pessoas - MCID";
            case "SECRETARIA NACIONAL DE PERIFERIAS - SNP" -> "Secretaria Nacional de Periferias - SNP";
            case "CIA BRASILEIRA DE TRENS URBANOS-ADM.CENTRAL" ->
                    "Companhia Brasileira de Trens Urbanos - Administração Central";
            case "CIA.BRASILEIRA DE TRENS URBANOS-STU/NAT" -> "Companhia Brasileira de Trens Urbanos - STU/Natal";
            case "CIA.BRASILEIRA DE TRENS URBANOS-STU/MAC" -> "Companhia Brasileira de Trens Urbanos - STU/Maceió";
            case "CIA. BRASILEIRA DE TRENS URBANOS - STU/JOP" ->
                    "Companhia Brasileira de Trens Urbanos - STU/João Pessoa";
            case "EMPRESA DE TRENS URBANOS DE PORTO ALEGRE S/A" -> "Empresa de Trens Urbanos de Porto Alegre S/A";
            case "SECRETARIA NACIONAL DE HABITACAO - FNHIS" -> "Secretaria Nacional de Habitação - FNHIS";
            case "CAIXA ECONOMICA FEDERAL - FNHIS" -> "Caixa Econômica Federal - FNHIS";
            case "COORDENACAO GERAL DE ADMINISTRACAO CGAD/DLOG/" -> "Coordenação Geral de Administração - CGAD/DLOG";
            case "DIRETORIA DE TECNOLOGIA DA INFORM.E INOVACAO" -> "Diretoria de Tecnologia da Informação e Inovação";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE SP" -> "Superintendência Regional no Estado de São Paulo";
            case "DIRETORIA TECNICO-CIENTIFICA-DITEC/DPF" -> "Diretoria Técnico-Científica - DITEC/DPF";
            case "DIRETORIA DE GESTAO DE PESSOAS" -> "Diretoria de Gestão de Pessoas";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO RS" ->
                    "Superintendência Regional no Estado do Rio Grande do Sul";
            case "DELEGACIA DE POLICIA FEDERAL EM FOZ DO IGUACU" -> "Delegacia de Polícia Federal em Foz do Iguaçu";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO MS" ->
                    "Superintendência Regional no Estado do Mato Grosso do Sul";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO PA" -> "Superintendência Regional no Estado do Pará";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO AM" -> "Superintendência Regional no Estado do Amazonas";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DA BA" -> "Superintendência Regional no Estado da Bahia";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE PE" -> "Superintendência Regional no Estado de Pernambuco";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO PR" -> "Superintendência Regional no Estado do Paraná";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE SC" -> "Superintendência Regional no Estado de Santa Catarina";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO AC" -> "Superintendência Regional no Estado do Acre";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE RR" -> "Superintendência Regional no Estado de Roraima";
            case "DIRETORIA DE ENSINO DA ANP/PF" -> "Diretoria de Ensino da Academia Nacional de Polícia";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE RO" -> "Superintendência Regional no Estado de Rondônia";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE GO" -> "Superintendência Regional no Estado de Goiás";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO CE" -> "Superintendência Regional no Estado do Ceará";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO RN" ->
                    "Superintendência Regional no Estado do Rio Grande do Norte";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO MT" -> "Superintendência Regional no Estado do Mato Grosso";
            case "SUPERINTENDENCIA REGIONAL NO DISTRITO FEDERAL" -> "Superintendência Regional no Distrito Federal";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO ES" -> "Superintendência Regional no Estado do Espírito Santo";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DA PB" -> "Superintendência Regional no Estado da Paraíba";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO MA" -> "Superintendência Regional no Estado do Maranhão";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO AP" -> "Superintendência Regional no Estado do Amapá";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE TO" -> "Superintendência Regional no Estado do Tocantins";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DO PI" -> "Superintendência Regional no Estado do Piauí";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE SE" -> "Superintendência Regional no Estado de Sergipe";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO DE AL" -> "Superintendência Regional no Estado de Alagoas";
            case "SERVICO DE ORCAMENTO E FINANCAS DE PESSOAL" -> "Serviço de Orçamento e Finanças de Pessoal";
            case "POLICIA RODOVIARIA FEDERAL" -> "Polícia Rodoviária Federal";
            case "SUPERINTENDENCIA DA PRF NO RIO DE JANEIRO" -> "Superintendência da PRF no Rio de Janeiro";
            case "SUPERINTENDENCIA DA PRF NO PARANA" -> "Superintendência da PRF no Paraná";
            case "SUPERINTENDENCIA DA PRF NO RIO GRANDE DO SUL" -> "Superintendência da PRF no Rio Grande do Sul";
            case "SUPERINTENDENCIA REG. POL. RODV. FEDERAL-MS" ->
                    "Superintendência Regional da Polícia Rodoviária Federal no Mato Grosso do Sul";
            case "SUPERINTENDENCIA DA PRF NA BAHIA" -> "Superintendência da PRF na Bahia";
            case "UNIVERSIDADE DA POLICIA RODOVIARIA FEDERAL" -> "Universidade da Polícia Rodoviária Federal";
            case "SUPERINTENDENCIA DA PRF EM SAO PAULO" -> "Superintendência da PRF em São Paulo";
            case "SUPERINTENDENCIA DA PRF EM PERNAMBUCO" -> "Superintendência da PRF em Pernambuco";
            case "COORDENACAO-GERAL DE OPERACOES" -> "Coordenação Geral de Operações";
            case "SUPERINTENDENCIA DA PRF EM MINAS GERAIS" -> "Superintendência da PRF em Minas Gerais";
            case "SUPERINTENDENCIA DA PRF NO CEARA" -> "Superintendência da PRF no Ceará";
            case "SUPERINTENDENCIA DA PRF EM GOIAS" -> "Superintendência da PRF em Goiás";
            case "SUPERINTENDENCIA DA PRF NO MATO GROSSO" -> "Superintendência da PRF no Mato Grosso";
            case "SUPERINTENDENCIA DA PRF EM SANTA CATARINA" -> "Superintendência da PRF em Santa Catarina";
            case "SUPERINTENDENCIA DA PRF NO MARANHAO." -> "Superintendência da PRF no Maranhão";
            case "SUPERINTENDENCIA DA PRF NO RIO GRANDE DO NORTE" -> "Superintendência da PRF no Rio Grande do Norte";
            case "SUPERINTENDENCIA DA PRF NA PARAIBA" -> "Superintendência da PRF na Paraíba";
            case "SUPERINTENDENCIA REG. POL. RODV. FEDERAL-PA" ->
                    "Superintendência Regional de Polícia Rodoviária Federal - Pará";
            case "SUPERINTENDENCIA DA PRF NO PIAUI" -> "Superintendência da PRF no Piauí";
            case "SUPERINTENDENCIA DA PRF EM RONDONIA" -> "Superintendência da PRF em Rondônia";
            case "SUPERINTENDENCIA DA PRF NO DISTRITO FEDERAL" -> "Superintendência da PRF no Distrito Federal";
            case "SUPERINTENDENCIA DA PRF NO AMAPA" -> "Superintendência da PRF no Amapá";
            case "SUPERINTENDENCIA DA PRF NO ESPIRITO SANTO" -> "Superintendência da PRF no Espírito Santo";
            case "SUPERINTENDENCIA DA PRF EM ALAGOAS" -> "Superintendência da PRF em Alagoas";
            case "SUPERINTENDENCIA DA PRF EM SERGIPE" -> "Superintendência da PRF em Sergipe";
            case "SUPERINTENDENCIA DA PRF EM RORAIMA" -> "Superintendência da PRF em Roraima";
            case "SUPERINTENDENCIA DA PRF NO TOCANTINS" -> "Superintendência da PRF no Tocantins";
            case "SUPERINTENDENCIA DA PRF NO ACRE" -> "Superintendência da PRF no Acre";
            case "SUPERINTENDENCIA DA PRF NO AMAZONAS" -> "Superintendência da PRF no Amazonas";
            case "DIRETORIA DE INTELIGENCIA DA PRF" -> "Diretoria de Inteligência da PRF";
            case "COORDENACAO-GERAL DE PLANEJ. E MODERNIZACAO" -> "Coordenação-Geral de Planejamento e Modernização";
            case "CORREGEDORIA-GERAL" -> "Corregedoria-Geral";
            case "FUNDO NACIONAL DE SEG.PUBLICA-FNSP/SEGEN" -> "Fundo Nacional de Segurança Pública - FNSP/SEGEN";
            case "FUNDO NACIONAL DE SEGURANCA PUBLICA - FNSP" -> "Fundo Nacional de Segurança Pública - FNSP";
            case "CEF - SENASP/MJ" -> "Caixa Econômica Federal - SENASP/MJ";
            case "CEF - PROGRAMA HABITE SEGURO" -> "Caixa Econômica Federal - Programa Habite Seguro";
            case "COORDENACAO DE PAG. E EXEC.ORC.FIN. PESSOAL" ->
                    "Coordenação de Pagamento e Execução Orçamentária e Financeira de Pessoal";
            case "SECRETARIA NACIONAL DE SEG. PUBLICA - SENASP" -> "Secretaria Nacional de Segurança Pública - SENASP";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS-CGGP" -> "Coordenação-Geral de Gestão de Pessoas - CGGP";
            case "COORDENACAO-GERAL DE LOGISTICA E CONTRATOS/MJ" -> "Coordenação-Geral de Logística e Contratos/MJ";
            case "SECRETARIA NACIONAL DE JUSTICA - SENAJUS" -> "Secretaria Nacional de Justiça - SENAJUS";
            case "SECRETARIA DE ACESSO A JUSTICA - SAJU" -> "Secretaria de Acesso à Justiça - SAJU";
            case "SECRETARIA NACIONAL DO CONSUMIDOR - SENACON" -> "Secretaria Nacional do Consumidor - SENACON";
            case "DEPEN/DIRETORIA DE POLITICAS PENITENCIARIAS" -> "DEPEN - Diretoria de Políticas Penitenciárias";
            case "CGOF-COORD.GERAL DE ORC.FIN.PLA.CONT/SENAPPEN" ->
                    "CGOF - Coordenação-Geral de Orçamento, Finanças, Planejamento e Controle/SENAPPEN";
            case "DEPEN - DIRETORIA EXECUTIVA" -> "DEPEN - Diretoria Executiva";
            case "DEPEN/DIRETORIA DO SISTEMA PENITENC. FEDERAL" -> "DEPEN - Diretoria do Sistema Penitenciário Federal";
            case "DIRETORIA DE CIDADANIA E ALTERNATIVAS PENAIS" -> "Diretoria de Cidadania e Alternativas Penais";
            case "DIPEN - DIR. DE INTELIGENCIA PENITENCIARIA" -> "DIPEN - Diretoria de Inteligência Penitenciária";
            case "PENITENCIARIA FEDERAL EM PORTO VELHO - RO" -> "Penitenciária Federal em Porto Velho - RO";
            case "CEF - DEPARTAMENTO PENITENCIARIO NACIONAL-MJ" ->
                    "Caixa Econômica Federal - Departamento Penitenciário Nacional - MJ";
            case "PENITENCIARIA FEDERAL DE CAMPO GRANDE - MS" -> "Penitenciária Federal de Campo Grande - MS";
            case "PENITENCIARIA FEDERAL EM CATANDUVAS - PR" -> "Penitenciária Federal em Catanduvas - PR";
            case "PENITENCIARIA FEDERAL EM MOSSORO - RN" -> "Penitenciária Federal em Mossoró - RN";
            case "PENITENCIARIA FEDERAL EM BRASILIA" -> "Penitenciária Federal em Brasília";
            case "CONSELHO ADMINISTRATIVO DE DEFESA ECONOMICA" -> "Conselho Administrativo de Defesa Econômica";
            case "FUNDO NACIONAL ANTIDROGAS" -> "Fundo Nacional Antidrogas";
            case "FUNDO DE DEFESA DE DIREITOS DIFUSOS" -> "Fundo de Defesa de Direitos Difusos";
            case "CEF/FDD - CONTRATO DE REPASSE" -> "Caixa Econômica Federal/FDD - Contrato de Repasse";
            case "AUTORIDADE NACIONAL DE PROTECAO DE DADOS" -> "Autoridade Nacional de Proteção de Dados";
            case "FUNDO NAC.DE DESENV. CIENT. E TECNOLOGICO" ->
                    "Fundo Nacional de Desenvolvimento Científico e Tecnológico";
            case "INSTITUTO NACIONAL DE PESQ. ESPACIAIS-INPE" -> "Instituto Nacional de Pesquisas Espaciais - INPE";
            case "COORDENACAO-GERAL DE TRANSFER. VOLUNTARIAS" -> "Coordenação-Geral de Transferências Voluntárias";
            case "INSTIT.NACIONAL DE PESQUISA DA AMAZONIA-INPA" -> "Instituto Nacional de Pesquisas da Amazônia - INPA";
            case "INST.BRAS.DE INFORM. EM CIENCIA E TECNOLOGIA" ->
                    "Instituto Brasileiro de Informação em Ciência e Tecnologia";
            case "CENTRO BRASILEIRO DE PESQUISAS FISICAS" -> "Centro Brasileiro de Pesquisas Físicas";
            case "MUSEU PARAENSE EMILIO GOELDI" -> "Museu Paraense Emílio Goeldi";
            case "LABORATORIO NACIONAL DE COMPUTACAO CIENTIFICA" -> "Laboratório Nacional de Computação Científica";
            case "LABORATORIO NACIONAL DE ASTROFISICA" -> "Laboratório Nacional de Astrofísica";
            case "CENTRO NAC.DE MONIT.E ALERT.DE DESASTRES NATU" ->
                    "Centro Nacional de Monitoramento e Alerta de Desastres Naturais";
            case "CENTRO DE TECNOLOGIA MINERAL" -> "Centro de Tecnologia Mineral";
            case "INSTITUTO NACIONAL DE TECNOLOGIA - INT" -> "Instituto Nacional de Tecnologia - INT";
            case "CENTRO DE TEC. DA INF. RENATO ARCHER - CTI" ->
                    "Centro de Tecnologia da Informação Renato Archer - CTI";
            case "OBSERVATORIO NACIONAL" -> "Observatório Nacional";
            case "CENTRO DE TECNOLOGIAS ESTRATEG. DO NORDESTE" -> "Centro de Tecnologias Estratégicas do Nordeste";
            case "INSTITUTO NACIONAL DO SEMIARIDO" -> "Instituto Nacional do Semiárido";
            case "INSTITUTO NACIONAL DA MATA ATLANTICA" -> "Instituto Nacional da Mata Atlântica";
            case "MUSEU DE ASTRONOMIA E CIENCIAS AFINS" -> "Museu de Astronomia e Ciências Afins";
            case "SECRET. DE C & T P/ INCLUSAO SOCIAL/MCT - CEF" ->
                    "Secretaria de Ciência e Tecnologia para Inclusão Social/MCT - CEF";
            case "INSTITUTO NACIONAL DE PESQUISA DO PANTANAL" -> "Instituto Nacional de Pesquisa do Pantanal";
            case "CONSELHO NAC DE DESENV CIENT E TECNOLOGICO" ->
                    "Conselho Nacional de Desenvolvimento Científico e Tecnológico";
            case "CNPQ - ATIVIDADES NO EXTERIOR" -> "CNPq - Atividades no Exterior";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR" -> "Comissão Nacional de Energia Nuclear";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-IPEN" -> "Comissão Nacional de Energia Nuclear - IPEN";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-CDTN" -> "Comissão Nacional de Energia Nuclear - CDTN";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-IRD" -> "Comissão Nacional de Energia Nuclear - IRD";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-IEN" -> "Comissão Nacional de Energia Nuclear - IEN";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-CRCN-NE" -> "Comissão Nacional de Energia Nuclear - CRCN-NE";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-LAPOC" -> "Comissão Nacional de Energia Nuclear - LAPOC";
            case "COMISSAO NACIONAL DE ENERGIA NUCLEAR-CRCN-CO" -> "Comissão Nacional de Energia Nuclear - CRCN-CO";
            case "CENTRO NACIONAL DE TECNOLOGIA ELETRONICA AVAN" -> "Centro Nacional de Tecnologia Eletrônica Avançada";
            case "AGENCIA ESPACIAL BRASILEIRA/AEB" -> "Agência Espacial Brasileira - AEB";
            case "FINEP/CONTRATOS E CONVENIOS" -> "FINEP - Contratos e Convênios";
            case "DEPART.NAC.INFRA ESTRUTURA TRANSPORTES." -> "Departamento Nacional de Infraestrutura de Transportes";
            case "SUPERINTENDENCIA REG. NO ESTADO SC - DNIT" ->
                    "Superintendência Regional no Estado de Santa Catarina - DNIT";
            case "SUPERINTENDENCIA REGIONAL NO ESTADO PA - DNIT" ->
                    "Superintendência Regional no Estado do Pará - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO BA - DNIT" -> "Superintendência Regional no Estado da Bahia - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO MG - DNIT" ->
                    "Superintendência Regional no Estado de Minas Gerais - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO ES - DNIT" ->
                    "Superintendência Regional no Estado do Espírito Santo - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO SP - DNIT" ->
                    "Superintendência Regional no Estado de São Paulo - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO TO - DNIT" ->
                    "Superintendência Regional no Estado do Tocantins - DNIT";
            case "SUPERINTEND. REG. NOS ESTADOS AM - DNIT" ->
                    "Superintendência Regional nos Estados do Amazonas - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO MS - DNIT" ->
                    "Superintendência Regional no Estado de Mato Grosso do Sul - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO PE - DNIT" ->
                    "Superintendência Regional no Estado de Pernambuco - DNIT";
            case "SUPERINTEND. REG. NO ESTADO DE RO-DNIT" -> "Superintendência Regional no Estado de Rondônia - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO CE - DNIT" -> "Superintendência Regional no Estado do Ceará - DNIT";
            case "SUPERINTEND.REG. NOS ESTADOS GO/DF - DNIT" ->
                    "Superintendência Regional nos Estados de Goiás e Distrito Federal - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO MT - DNIT" ->
                    "Superintendência Regional no Estado de Mato Grosso - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO PB - DNIT" -> "Superintendência Regional no Estado da Paraíba - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO AL - DNIT" -> "Superintendência Regional no Estado de Alagoas - DNIT";
            case "SUPERINTENDENCIA REG.NO ESTADO DE RR - DNIT" ->
                    "Superintendência Regional no Estado de Roraima - DNIT";
            case "SUPERINTENDENCIA RG.NO ESTADO DO AP - DNIT" -> "Superintendência Regional no Estado do Amapá - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO RS - DNIT" ->
                    "Superintendência Regional no Estado do Rio Grande do Sul - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO RJ - DNIT" ->
                    "Superintendência Regional no Estado do Rio de Janeiro - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO DO AC - DNIT" -> "Superintendência Regional no Estado do Acre - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO PR - DNIT" -> "Superintendência Regional no Estado do Paraná - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO RN - DNIT" ->
                    "Superintendência Regional no Estado do Rio Grande do Norte - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO MA - DNIT" ->
                    "Superintendência Regional no Estado do Maranhão - DNIT";
            case "SUPERINTENDENCIA REG. NO ESTADO SE - DNIT" -> "Superintendência Regional no Estado de Sergipe - DNIT";
            case "AGENCIA NACIONAL DE TRANSPORTES TERRESTRES" -> "Agência Nacional de Transportes Terrestres";
            case "VALEC ENGENHARIA, CONSTRUCOES E FERROVIAS S.A" -> "Valec Engenharia, Construções e Ferrovias S.A.";
            case "SUBSECRETARIA PLAN.,ORC.E ADM.-ADMINISTRATIVO" ->
                    "Subsecretaria de Planejamento, Orçamento e Administração - Administrativo";
            case "SUBSEC DE GESTAO ESTRATEGICA, TECN E INOVACAO" ->
                    "Subsecretaria de Gestão Estratégica, Tecnologia e Inovação";
            case "COORDENACAO GERAL DE RECURSOS LOGISTICOS-CGRL" -> "Coordenação-Geral de Recursos Logísticos - CGRL";
            case "SECRETARIA NACIONAL DE TRANSPORTE RODOVIARIO" -> "Secretaria Nacional de Transporte Rodoviário";
            case "FUNDO NACIONAL DE SEG. E EDUCACAO DE TRANSITO" ->
                    "Fundo Nacional de Segurança e Educação de Trânsito";
            case "COORD. DE EXECUCAO DE PAGAMENTO DE PESSOAL" -> "Coordenação de Execução de Pagamento de Pessoal";
            case "SECRETARIA DE POLITICA AGRICOLA" -> "Secretaria de Política Agrícola";
            case "SUBSECRETARIA DE ORCAMENTO,PLANEJAMENTO E ADM" ->
                    "Subsecretaria de Orçamento, Planejamento e Administração";
            case "CAIXA ECONOMICA FEDERAL/MA" -> "Caixa Econômica Federal - MA";
            case "COORD.-GERAL DE EXECUCAO ORC.E FIN./DA/MAPA" ->
                    "Coordenação-Geral de Execução Orçamentária e Financeira - MAPA";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/RS" -> "Superintendência de Agricultura e Pecuária - SFA/RS";
            case "LABORATORIO FEDERAL DE DEFESA AGROPECUARIA/MG" -> "Laboratório Federal de Defesa Agropecuária - MG";
            case "LABORATORIO FEDERAL DE DEFESA AGROPECUARIA/SP" -> "Laboratório Federal de Defesa Agropecuária - SP";
            case "LABORATORIO FEDERAL DE DEFESA AGROPECUARIA/RS" -> "Laboratório Federal de Defesa Agropecuária - RS";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/AP" -> "Superintendência de Agricultura e Pecuária - SFA/AP";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/RR" -> "Superintendência de Agricultura e Pecuária - SFA/RR";
            case "INSTITUTO NACIONAL DE METEOROLOGIA" -> "Instituto Nacional de Meteorologia";
            case "SECRETARIA DE COMERCIO E RELACOES INTERNACION" -> "Secretaria de Comércio e Relações Internacionais";
            case "SECRETARIA DE DEFESA AGROPECUARIA/MAPA" -> "Secretaria de Defesa Agropecuária - MAPA";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/SP" -> "Superintendência de Agricultura e Pecuária - SFA/SP";
            case "COMISSAO EXEC. DO PLANO DA LAV.CACAUEIRA/DF" ->
                    "Comissão Executiva do Plano da Lavoura Cacaueira - DF";
            case "LABORATORIO FEDERAL DE DEFESA AGROPECUARIA/PE" -> "Laboratório Federal de Defesa Agropecuária - PE";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/RO" -> "Superintendência de Agricultura e Pecuária - SFA/RO";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/MG" -> "Superintendência de Agricultura e Pecuária - SFA/MG";
            case "LABORATORIO FEDERAL DE DEFESA AGROPECUARIA/GO" -> "Laboratório Federal de Defesa Agropecuária - GO";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/ES" -> "Superintendência de Agricultura e Pecuária - SFA/ES";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/PA" -> "Superintendência de Agricultura e Pecuária - SFA/PA";
            case "LABORATORIO FEDERAL DE DEFESA AGROPECUARIA/PA" -> "Laboratório Federal de Defesa Agropecuária - PA";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/PR" -> "Superintendência de Agricultura e Pecuária - SFA/PR";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/BA" -> "Superintendência de Agricultura e Pecuária - SFA/BA";
            case "SECRET.DE INOV.,DESENV.SUSTENT.,IRRIG. E COOP" ->
                    "Secretaria de Inovação, Desenvolvimento Sustentável, Irrigação e Cooperativismo";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/MT" -> "Superintendência de Agricultura e Pecuária - SFA/MT";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/MS" -> "Superintendência de Agricultura e Pecuária - SFA/MS";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/PE" -> "Superintendência de Agricultura e Pecuária - SFA/PE";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/GO" -> "Superintendência de Agricultura e Pecuária - SFA/GO";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/SC" -> "Superintendência de Agricultura e Pecuária - SFA/SC";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/PI" -> "Superintendência de Agricultura e Pecuária - SFA/PI";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/RJ" -> "Superintendência de Agricultura e Pecuária - SFA/RJ";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/TO" -> "Superintendência de Agricultura e Pecuária - SFA/TO";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/CE" -> "Superintendência de Agricultura e Pecuária - SFA/CE";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/PB" -> "Superintendência de Agricultura e Pecuária - SFA/PB";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/MA" -> "Superintendência de Agricultura e Pecuária - SFA/MA";
            case "SECRETARIA DE AGRIC. FAM.E COOPERATIVIS/CEF" ->
                    "Secretaria de Agricultura Familiar e Cooperativismo - CEF";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/AM" -> "Superintendência de Agricultura e Pecuária - SFA/AM";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/DF" -> "Superintendência de Agricultura e Pecuária - SFA/DF";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/AC" -> "Superintendência de Agricultura e Pecuária - SFA/AC";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/RN" -> "Superintendência de Agricultura e Pecuária - SFA/RN";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/AL" -> "Superintendência de Agricultura e Pecuária - SFA/AL";
            case "SUPERINT.DE AGRICULTURA E PECUARIA - SFA/SE" -> "Superintendência de Agricultura e Pecuária - SFA/SE";
            case "MINIST.DA AGRIC.,PEC.E ABASTECIMENTO-GM/MAPA" ->
                    "Ministério da Agricultura, Pecuária e Abastecimento - GM/MAPA";
            case "FUNDO DE DEFESA DA ECON.CAFEEIRA/FUNCAFE/SPA" -> "Fundo de Defesa da Economia Cafeeira - FUNCAFÉ/SPA";
            case "EMBRAPA/GEAF" -> "Embrapa - GEAF";
            case "EMBRAPA/CPAC" -> "Embrapa - CPAC";
            case "EMBRAPA/CAFE" -> "Embrapa - Café";
            case "EMBRAPA/CPATSA" -> "Embrapa - CPATSA";
            case "EMBRAPA/CNAT" -> "Embrapa - CNAT";
            case "EMBRAPA/CNPSA" -> "Embrapa - CNPSA";
            case "EMBRAPA/CNPSO" -> "Embrapa - CNPSO";
            case "EMBRAPA/CPACT" -> "Embrapa - CPACT";
            case "EMBRAPA/CPATU" -> "Embrapa - CPATU";
            case "EMBRAPA/CENARGEN" -> "Embrapa - CENARGEN";
            case "EMBRAPA/CPAFRR" -> "Embrapa - CPAFRR";
            case "EMBRAPA/CPPSE" -> "Embrapa - CPPSE";
            case "EMBRAPA/CNPTIA" -> "Embrapa - CNPTIA";
            case "EMBRAPA/CNPAF" -> "Embrapa - CNPAF";
            case "EMBRAPA/CNPGL" -> "Embrapa - CNPGL";
            case "EMBRAPA/CNPASA" -> "Embrapa - CNPASA";
            case "EMBRAPA/CNPH" -> "Embrapa - CNPH";
            case "EMBRAPA/CNPMF" -> "Embrapa - CNPMF";
            case "EMBRAPA/CPATC" -> "Embrapa - CPATC";
            case "EMBRAPA/CPAMN" -> "Embrapa - CPAMN";
            case "EMBRAPA/CNPMA" -> "Embrapa - CNPMA";
            case "EMBRAPA/CPPSUL" -> "Embrapa - CPPSUL";
            case "EMBRAPA/CNPA" -> "Embrapa - CNPA";
            case "EMBRAPA/CNPF" -> "Embrapa - CNPF";
            case "EMBRAPA/CNPGC" -> "Embrapa - CNPGC";
            case "EMBRAPA/CNPMS" -> "Embrapa - CNPMS";
            case "EMBRAPA/CNPT" -> "Embrapa - CNPT";
            case "EMBRAPA/CPAF-AMAPA" -> "Embrapa - CPAF-Amapá";
            case "EMBRAPA/CNPDIA" -> "Embrapa - CNPDIA";
            case "EMBRAPA/CNPAB" -> "Embrapa - CNPAB";
            case "EMBRAPA/CNPAT" -> "Embrapa - CNPAT";
            case "EMBRAPA/CPAF-ACRE" -> "Embrapa - CPAF-Acre";
            case "EMBRAPA/CNPM" -> "Embrapa - CNPM";
            case "EMBRAPA/CPAA" -> "Embrapa - CPAA";
            case "EMBRAPA/CNPUV" -> "Embrapa - CNPUV";
            case "EMBRAPA/CNPC" -> "Embrapa - CNPC";
            case "EMBRAPA/CTAA" -> "Embrapa - CTAA";
            case "EMBRAPA/CPAO" -> "Embrapa - CPAO";
            case "EMBRAPA/CPAP" -> "Embrapa - CPAP";
            case "EMBRAPA/CPAMT" -> "Embrapa - CPAMT";
            case "EMBRAPA/CPAF-RO" -> "Embrapa - CPAF-RO";
            case "EMBRAPA/CNPS" -> "Embrapa - CNPS";
            case "EMBRAPA/AGROENERGIA" -> "Embrapa - Agroenergia";
            case "EMBRAPA/CPACP" -> "Embrapa - CPACP";
            case "EMBRAPA/UEP/RECIFE" -> "Embrapa - UEP/Recife";
            case "EMBRAPA CLIMA TEMPERADO-ESTAC. EXP. CANOINHAS" ->
                    "Embrapa Clima Temperado - Estação Experimental de Canoinhas";
            case "EMBRAPA/CIGV" -> "Embrapa - CIGV";
            case "FUNDO NACIONAL SOBRE MUDANCA DO CLIMA" -> "Fundo Nacional sobre Mudança do Clima";
            case "IBAMA-INST.BRAS.DO MEIO AMB.E DOS REC.NAT.REN" ->
                    "IBAMA - Instituto Brasileiro do Meio Ambiente e dos Recursos Naturais Renováveis";
            case "IBAMA - SUPERINTENDENCIA DE RONDONIA/RO" -> "IBAMA - Superintendência de Rondônia - RO";
            case "IBAMA - SUPERINTENDENCIA DO MATO GROSSO/MT" -> "IBAMA - Superintendência de Mato Grosso - MT";
            case "IBAMA - SUPERINTENDENCIA DO RIO DE JANEIRO/RJ" -> "IBAMA - Superintendência do Rio de Janeiro - RJ";
            case "IBAMA - SUPERINTENDENCIA DE MINAS GERAIS/MG" -> "IBAMA - Superintendência de Minas Gerais - MG";
            case "IBAMA - SUPERINTENDENCIA DO CEARA/CE" -> "IBAMA - Superintendência do Ceará - CE";
            case "IBAMA - SUPERINTENDENCIA DO PARA/PA" -> "IBAMA - Superintendência do Pará - PA";
            case "IBAMA - SUPERINTENDENCIA DO MARANHAO/MA" -> "IBAMA - Superintendência do Maranhão - MA";
            case "IBAMA - SUPERINTENDENCIA DO RIO GRANDE SUL/RS" ->
                    "IBAMA - Superintendência do Rio Grande do Sul - RS";
            case "IBAMA - SUPERINTENDENCIA DE RORAIMA/RR" -> "IBAMA - Superintendência de Roraima - RR";
            case "IBAMA - SUPERINTENDENCIA DE SANTA CATARINA/SC" -> "IBAMA - Superintendência de Santa Catarina - SC";
            case "IBAMA - SUPERINTENDENCIA DE ALAGOAS/AL" -> "IBAMA - Superintendência de Alagoas - AL";
            case "IBAMA - SUPERINTENDENCIA DO ACRE/AC" -> "IBAMA - Superintendência do Acre - AC";
            case "IBAMA - SUPERINTENDENCIA DO AMAZONAS/AM" -> "IBAMA - Superintendência do Amazonas - AM";
            case "IBAMA - SUPERINTENDENCIA DO PIAUI/PI" -> "IBAMA - Superintendência do Piauí - PI";
            case "IBAMA - SUPERINTENDENCIA RIO GRANDE NORTE/RN" ->
                    "IBAMA - Superintendência do Rio Grande do Norte - RN";
            case "IBAMA - SUPERINTENDENCIA DE GOIAS/GO" -> "IBAMA - Superintendência de Goiás - GO";
            case "IBAMA - SUPERINTENDENCIA MATO GROSSO SUL/MS" -> "IBAMA - Superintendência de Mato Grosso do Sul - MS";
            case "IBAMA - SUPERINTENDENCIA DO TOCANTINS/TO" -> "IBAMA - Superintendência do Tocantins - TO";
            case "IBAMA - SUPERINTENDENCIA DE SERGIPE/SE" -> "IBAMA - Superintendência de Sergipe - SE";
            case "IBAMA - SUPERINTENDENCIA DA PARAIBA/PB" -> "IBAMA - Superintendência da Paraíba - PB";
            case "IBAMA - SUPERINTENDENCIA DO AMAPA/AP" -> "IBAMA - Superintendência do Amapá - AP";
            case "IBAMA - SUPERINTENDENCIA DO PARANA/PR" -> "IBAMA - Superintendência do Paraná - PR";
            case "IBAMA - SUPERINTENDENCIA DA BAHIA/BA" -> "IBAMA - Superintendência da Bahia - BA";
            case "IBAMA - SUPERINTENDENCIA DE PERNAMBUCO/PE" -> "IBAMA - Superintendência de Pernambuco - PE";
            case "IBAMA - SUPERINTENDENCIA DE SAO PAULO/SP" -> "IBAMA - Superintendência de São Paulo - SP";
            case "IBAMA - SUPERINTENDENCIA DO ESPIRITO SANTO/ES" -> "IBAMA - Superintendência do Espírito Santo - ES";
            case "IBAMA - SUPERINTENDENCIA DISTRITO FEDERAL/DF" -> "IBAMA - Superintendência do Distrito Federal - DF";
            case "INSTITUTO CHICO MENDES - SEDE" -> "Instituto Chico Mendes - Sede";
            case "ICMBIO GR3 CENTRO OESTE" -> "ICMBio - GR3 Centro-Oeste";
            case "ICMBIO SEINFRA" -> "ICMBio - SEINFRA";
            case "ICMBIO KFW" -> "ICMBio - KFW";
            case "ICMBIO GR4 SUDESTE" -> "ICMBio - GR4 Sudeste";
            case "ICMBIO GR2 NORDESTE" -> "ICMBio - GR2 Nordeste";
            case "ICMBIO DIAC" -> "ICMBio - DIAC";
            case "ICMBIO GR1 NORTE" -> "ICMBio - GR1 Norte";
            case "ICMBIO GR5 SUL" -> "ICMBio - GR5 Sul";
            case "SUBSECRET.DE PLANEJ.,ORC.E ADMINIST.±SPOA/MM" ->
                    "Subsecretaria de Planejamento, Orçamento e Administração - SPOA/MM";
            case "BOLSA VERDE - SEDR" -> "Bolsa Verde - SEDR";
            case "SEC.BIODIVERSID.,FLORESTAS E DIREITOS ANIMAIS" ->
                    "Secretaria de Biodiversidade, Florestas e Direitos dos Animais";
            case "SEC.MEIO AMBIENTE URBANO QUALIDADE AMBIENTAL" ->
                    "Secretaria de Meio Ambiente Urbano e Qualidade Ambiental";
            case "DEPARTAMENTO DE EDUCACAO AMBIENT. E CIDADANIA" -> "Departamento de Educação Ambiental e Cidadania";
            case "SEC.POVOS COMUNID TRAD E DESENV.RURAL SUSTENT" ->
                    "Secretaria de Povos e Comunidades Tradicionais e Desenvolvimento Rural Sustentável";
            case "SEC.EXTRA.CONTR.DESMAT.ORDENAM.AMBIENT.TERRIT" ->
                    "Secretaria Extraordinária de Controle do Desmatamento, Ordenamento Ambiental e Territorial";
            case "CEF/MMA CONTRATOS DE REPASSE" -> "Caixa Econômica Federal - MMA Contratos de Repasse";
            case "SEC. DE MUDANCA DO CLIMA" -> "Secretaria de Mudança do Clima";
            case "SECRETARIA NACIONAL DE BIOECONOMIA" -> "Secretaria Nacional de Bioeconomia";
            case "INST. DE PESQUISAS JARDIM BOTANICO DO RJ/JBRJ" ->
                    "Instituto de Pesquisas Jardim Botânico do Rio de Janeiro - JBRJ";
            case "SERVICO FLORESTAL BRASILEIRO" -> "Serviço Florestal Brasileiro";
            case "KFW SERVICO FLORESTAL BRASILEIRO" -> "KFW - Serviço Florestal Brasileiro";
            case "FUNDO AMAZONIA-SERVICO FLORESTAL BRASILEIRO" -> "Fundo Amazônia - Serviço Florestal Brasileiro";
            case "FUNDO NACIONAL DO MEIO AMBIENTE" -> "Fundo Nacional do Meio Ambiente";
            case "ESCRITORIO FINANCEIRO EM NOVA IORQUE" -> "Escritório Financeiro em Nova Iorque";
            case "DEPARTAMENTO DO SERVICO EXTERIOR - MRE" -> "Departamento do Serviço Exterior - MRE";
            case "EMBAIXADA DO BRASIL EM BEIRUTE" -> "Embaixada do Brasil em Beirute";
            case "DEPTO DE TECNOLOGIA E GESTAO DA INFORMACAO" -> "Departamento de Tecnologia e Gestão da Informação";
            case "DELEGACAO DO BRASIL/MRE JUNTO A ONU" -> "Delegação do Brasil junto à ONU - MRE";
            case "EMBAIXADA DO BRASIL EM ASSUNCAO" -> "Embaixada do Brasil em Assunção";
            case "DIVISAO DE RECURSOS LOGISTICOS" -> "Divisão de Recursos Logísticos";
            case "EMBAIXADA DO BRASIL EM PARIS" -> "Embaixada do Brasil em Paris";
            case "AGENCIA BRASILEIRA DE COOPERACAO - ABC" -> "Agência Brasileira de Cooperação - ABC";
            case "EMBAIXADA DO BRASIL EM BERLIM" -> "Embaixada do Brasil em Berlim";
            case "CONSULADO GERAL EM NOVA IORQUE" -> "Consulado-Geral em Nova Iorque";
            case "PRESIDENCIA BRASILEIRA DO G20, EM 2024" -> "Presidência Brasileira do G20, em 2024";
            case "EMBAIXADA DO BRASIL BUENOS AIRES" -> "Embaixada do Brasil em Buenos Aires";
            case "DELEGACAO PERMANENTE EM GENEBRA" -> "Delegação Permanente em Genebra";
            case "EMBAIXADA DO BRASIL EM ROMA" -> "Embaixada do Brasil em Roma";
            case "MRE - ESCRITORIO DE RPRES.NO RIO DE JANEIRO" -> "MRE - Escritório de Representação no Rio de Janeiro";
            case "CONSULADO-GERAL DO BRASIL EM ISTAMBUL" -> "Consulado-Geral do Brasil em Istambul";
            case "EMBAIXADA DO BRASIL EM LONDRES" -> "Embaixada do Brasil em Londres";
            case "ESCRITORIO DE REPRESENTACAO EM RAMALA" -> "Escritório de Representação em Ramala";
            case "EMBAIXADA DO BRASIL EM WASHINGTON" -> "Embaixada do Brasil em Washington";
            case "DIVISAO DE INFRAESTRUTURA" -> "Divisão de Infraestrutura";
            case "ESCRITORIO FINANCEIRO EM NEW YORK" -> "Escritório Financeiro em Nova Iorque";
            case "EMBAIXADA DO BRASIL EM LISBOA" -> "Embaixada do Brasil em Lisboa";
            case "CONSULADO-GERAL DO BRASIL EM MIAMI" -> "Consulado-Geral do Brasil em Miami";
            case "DEL.DO BRASIL JUNTO A ORG.MUNDIAL DO COMERCIO" ->
                    "Delegação do Brasil junto à Organização Mundial do Comércio";
            case "EMBAIXADA DO BRASIL EM PEQUIM" -> "Embaixada do Brasil em Pequim";
            case "EMBAIXADA DO BRASIL EM VARSOVIA" -> "Embaixada do Brasil em Varsóvia";
            case "CONSULADO-GERAL EM PARIS" -> "Consulado-Geral em Paris";
            case "CONSULADO-GERAL DO BRASIL EM BOSTON" -> "Consulado-Geral do Brasil em Boston";
            case "CONSULADO-GERAL EM LONDRES" -> "Consulado-Geral em Londres";
            case "EMBAIXADA DO BRASIL EM MADRI" -> "Embaixada do Brasil em Madri";
            case "CONSULADO-GERAL DO BRASIL EM LOS ANGELES" -> "Consulado-Geral do Brasil em Los Angeles";
            case "EMBAIXADA DO BRASIL EM SANTIAGO" -> "Embaixada do Brasil em Santiago";
            case "EMBAIXADA DO BRASIL EM TEL AVIV - ML" -> "Embaixada do Brasil em Tel Aviv - ML";
            case "EMBAIXADA DO BRASIL EM TOQUIO" -> "Embaixada do Brasil em Tóquio";
            case "CONSULADO-GERAL DO BRASIL EM MILAO" -> "Consulado-Geral do Brasil em Milão";
            case "COORDENACAO-GERAL DE ADMINISTRACAO CONSULAR" -> "Coordenação-Geral de Administração Consular";
            case "EMBAIXADA DO BRASIL NO MEXICO" -> "Embaixada do Brasil no México";
            case "CONSULADO-GERAL DO BRASIL EM SAO FRANCISCO" -> "Consulado-Geral do Brasil em São Francisco";
            case "EMBAIXADA DO BRASIL EM LIMA" -> "Embaixada do Brasil em Lima";
            case "CONSULADO-GERAL DO BRASIL EM LISBOA" -> "Consulado-Geral do Brasil em Lisboa";
            case "CONSULADO-GERAL DO BRASIL EM BARCELONA" -> "Consulado-Geral do Brasil em Barcelona";
            case "CERIMONIAL" -> "Cerimonial";
            case "CONSULADO-GERAL DO BRASIL EM TOQUIO" -> "Consulado-Geral do Brasil em Tóquio";
            case "CONSULADO-GERAL DO BRASIL EM EDIMBURGO" -> "Consulado-Geral do Brasil em Edimburgo";
            case "EMBAIXADA DO BRASIL EM PRETORIA" -> "Embaixada do Brasil em Pretória";
            case "CONSULADO-GERAL DO BRASIL EM WASHINGTON" -> "Consulado-Geral do Brasil em Washington";
            case "DELEGACAO - BRASIL JUNTO A UNIAO EUROPEIA-MRE" -> "Delegação do Brasil junto à União Europeia - MRE";
            case "EMBAIXADA DO BRASIL EM VIENA" -> "Embaixada do Brasil em Viena";
            case "EMBAIXADA DO BRASIL EM MONTEVIDEU" -> "Embaixada do Brasil em Montevidéu";
            case "CONSULADO-GERAL DO BRASIL EM GENEBRA" -> "Consulado-Geral do Brasil em Genebra";
            case "CONSULADO-GERAL EM CHICAGO" -> "Consulado-Geral em Chicago";
            case "EMBAIXADA DO BRASIL EM AMA" -> "Embaixada do Brasil em Amã";
            case "EMBAIXADA DO BRASIL EM LUANDA" -> "Embaixada do Brasil em Luanda";
            case "CONSULADO GERAL DO BRASIL EM MADRI" -> "Consulado-Geral do Brasil em Madri";
            case "EMBAIXADA DO BRASIL EM BOGOTA" -> "Embaixada do Brasil em Bogotá";
            case "MISSAO DO BRASIL JUNTO A OEA - WASHINGTON-MRE" -> "Missão do Brasil junto à OEA - Washington - MRE";
            case "EMBAIXADA DO BRASIL EM SEUL" -> "Embaixada do Brasil em Seul";
            case "CONSULADO-GERAL EM NAGOIA" -> "Consulado-Geral em Nagóia";
            case "DELEGACAO DO BRASIL/MRE JUNTO A UNESCO" -> "Delegação do Brasil junto à UNESCO - MRE";
            case "EMBAIXADA DO BRASIL EM QUITO" -> "Embaixada do Brasil em Quito";
            case "EMBAIXADA DO BRASIL EM LA PAZ" -> "Embaixada do Brasil em La Paz";
            case "CONSULADO-GERAL EM HONG KONG" -> "Consulado-Geral em Hong Kong";
            case "CONSULADO-GERAL DO BRASIL EM ZURIQUE" -> "Consulado-Geral do Brasil em Zurique";
            case "EMBAIXADA DO BRASIL NA HAIA" -> "Embaixada do Brasil em Haia";
            case "EMBAIXADA DO BRASIL EM BRUXELAS" -> "Embaixada do Brasil em Bruxelas";
            case "EMBAIXADA DO BRASIL EM DUBLIN" -> "Embaixada do Brasil em Dublin";
            case "CONSULADO-GERAL EM BUENOS AIRES" -> "Consulado-Geral em Buenos Aires";
            case "CONSULADO-GERAL DO BRASIL EM SYDNEY" -> "Consulado-Geral do Brasil em Sydney";
            case "EMBAIXADA DO BRASIL NO VATICANO" -> "Embaixada do Brasil no Vaticano";
            case "EMBAIXADA DO BRASIL EM SINGAPURA" -> "Embaixada do Brasil em Singapura";
            case "CONSULADO-GERAL EM XANGAI" -> "Consulado-Geral em Xangai";
            case "CONSULADO-GERAL DO BRASIL EM PORTO" -> "Consulado-Geral do Brasil em Porto";
            case "CONSULADO-GERAL DO BRASIL EM ROMA" -> "Consulado-Geral do Brasil em Roma";
            case "CONSULADO-GERAL DO BRASIL EM AMSTERDA" -> "Consulado-Geral do Brasil em Amsterdã";
            case "CONSULADO DO BRASIL EM HOUSTON" -> "Consulado do Brasil em Houston";
            case "CONSULADO-GERAL DO BRASIL EM MUNIQUE" -> "Consulado-Geral do Brasil em Munique";
            case "DELEGACAO DO BRASIL JUNTO A ALADI - MERCOSUL" -> "Delegação do Brasil junto à ALADI - MERCOSUL";
            case "EMBAIXADA DO BRASIL EM BERNA" -> "Embaixada do Brasil em Berna";
            case "CONSULADO-GERAL DO BRASIL EM FRANKFURT" -> "Consulado-Geral do Brasil em Frankfurt";
            case "CONSULADO-GERAL DO BRASIL EM BRUXELAS" -> "Consulado-Geral do Brasil em Bruxelas";
            case "CONSULADO-GERAL DO BRASIL EM ATLANTA" -> "Consulado-Geral do Brasil em Atlanta";
            case "CONSULADO-GERAL DO BRASIL EM TORONTO" -> "Consulado-Geral do Brasil em Toronto";
            case "CONSULADO-GERAL DO BRASIL EM ORLANDO" -> "Consulado-Geral do Brasil em Orlando";
            case "EMBAIXADA DO BRASIL EM CAMBERRA" -> "Embaixada do Brasil em Camberra";
            case "EMBAIXADA DO BRASIL EM NOVA DELHI" -> "Embaixada do Brasil em Nova Délhi";
            case "EMBAIXADA DO BRASIL EM HELSINQUE" -> "Embaixada do Brasil em Helsinque";
            case "EMBAIXADA DO BRASIL EM PRAGA" -> "Embaixada do Brasil em Praga";
            case "EMBAIXADA DO BRASIL EM COPENHAGUE" -> "Embaixada do Brasil em Copenhague";
            case "CONSULADO-GERAL DO BRASIL EM MONTREAL" -> "Consulado-Geral do Brasil em Montreal";
            case "EMBAIXADA DO BRASIL EM OTTAWA" -> "Embaixada do Brasil em Ottawa";
            case "REPRESENTACAO DO BRASIL/MRE JUNTO A FAO" -> "Representação do Brasil junto à FAO - MRE";
            case "CONSULADO-GERAL DO BRASIL EM HAMAMATSU" -> "Consulado-Geral do Brasil em Hamamatsu";
            case "CONSULADO-GERAL DO BRASIL EM VANCOUVER" -> "Consulado-Geral do Brasil em Vancouver";
            case "CONSULADO-GERAL DO BRASIL EM HARTFORD" -> "Consulado-Geral do Brasil em Hartford";
            case "EMBAIXADA DO BRASIL EM TEL AVIV" -> "Embaixada do Brasil em Tel Aviv";
            case "DELEGACAO DO BRASIL/MRE JUNTO A CPLP" -> "Delegação do Brasil junto à CPLP - MRE";
            case "CONSULADO-GERAL DO BRASIL EM FARO" -> "Consulado-Geral do Brasil em Faro";
            case "EMBAIXADA DO BRASIL EM OSLO" -> "Embaixada do Brasil em Oslo";
            case "EMBAIXADA DO BRASIL NO PANAMA" -> "Embaixada do Brasil no Panamá";
            case "EMBAIXADA DO BRASIL EM WELLINGTON" -> "Embaixada do Brasil em Wellington";
            case "CONSULADO - GERAL DO BRASIL EM MONTEVIDEU" -> "Consulado-Geral do Brasil em Montevidéu";
            case "EMBAIXADA DO BRASIL EM BUDAPESTE" -> "Embaixada do Brasil em Budapeste";
            case "EMBAIXADA DO BRASIL BRATISLAVA" -> "Embaixada do Brasil em Bratislava";
            case "CONSULADO-GERAL EM CANTAO" -> "Consulado-Geral em Cantão";
            case "DELEGACAO PERMANENTE DO BRASIL JUNTO A OACI" -> "Delegação Permanente do Brasil junto à OACI";
            case "CONSULADO-GERAL DO BRASIL EM SANTIAGO" -> "Consulado-Geral do Brasil em Santiago";
            case "EMBAIXADA DO BRASIL EM SOFIA" -> "Embaixada do Brasil em Sófia";
            case "EMBAIXADA DO BRASIL EM TALIN" -> "Embaixada do Brasil em Talim";
            case "ESCRITORIO DE REPRESENTACAO EM RAMALA - ML" -> "Escritório de Representação em Ramala - ML";
            case "CONSULADO-GERAL DO BRASIL EM ASSUNCAO" -> "Consulado-Geral do Brasil em Assunção";
            case "CONSULADO EM PASO DE LOS LIBRES" -> "Consulado em Paso de los Libres";
            case "CONSULADO-GERAL DO BRASIL EM ISTAMBUL - ML" -> "Consulado-Geral do Brasil em Istambul - ML";
            case "GESTAO DE MORADIAS FUNCIONAIS GEIMF" -> "Gestão de Moradias Funcionais - GEIMF";
            case "INSTITUTO RIO-BRANCO" -> "Instituto Rio Branco";
            case "ESCRIT.DE REP.DO MINIST.RELAC.EXTERIORES/SP" ->
                    "Escritório de Representação do Ministério das Relações Exteriores - SP";
            case "INSTITUTO GUIMARAES ROSA" -> "Instituto Guimarães Rosa";
            case "DIVISAO ADM. DE AUXILIARES LOCAIS-DAUX" -> "Divisão Administrativa de Auxiliares Locais - DAUX";
            case "1A.COMISSAO BRASILEIRA DEMARCADORA DE LIMITES" -> "1ª Comissão Brasileira Demarcadora de Limites";
            case "EMBAIXADA DO BRASIL EM BANGKOK" -> "Embaixada do Brasil em Bangkok";
            case "ESCRITORIO DE REPRES. NA REG.NORDESTE-ERENE" ->
                    "Escritório de Representação na Região Nordeste - ERENE";
            case "2A.COMISSAO BRASILEIRA DEMARCADORA DE LIMITES" -> "2ª Comissão Brasileira Demarcadora de Limites";
            case "FUNDACAO ALEXANDRE DE GUSMAO" -> "Fundação Alexandre de Gusmão";
            case "SECRETARIA DE ASSUNTOS ADMINISTRATIVOS-MEMPE" -> "Secretaria de Assuntos Administrativos - MEMPE";
            case "FOLHA DE PAGAMENTO - MEMP" -> "Folha de Pagamento - MEMP";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MEMP" -> "Centro de Serviços Compartilhados - MEMP";
            case "FUNDACAO IBGE-ADMINISTRACAO CENTRAL/RJ" -> "Fundação IBGE - Administração Central - RJ";
            case "SUPERINTENDENCIA ESTADUAL IBGE MINAS GERAIS" -> "Superintendência Estadual do IBGE em Minas Gerais";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO MARANHAO" -> "Superintendência Estadual do IBGE no Maranhão";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO PARA" -> "Superintendência Estadual do IBGE no Pará";
            case "SUPERINTENDENCIA ESTADUAL IBGE PERNAMBUCO" -> "Superintendência Estadual do IBGE em Pernambuco";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO PARANA" -> "Superintendência Estadual do IBGE no Paraná";
            case "SUPERINTENDENCIA DO IBGE NO DISTRITO FEDERAL" -> "Superintendência do IBGE no Distrito Federal";
            case "SUPERINTENDENCIA DO IBGE EM GOIAS" -> "Superintendência do IBGE em Goiás";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO AMAZONAS" -> "Superintendência Estadual do IBGE no Amazonas";
            case "SUPERINTENDENCIA DO IBGE NO RIO GRANDE DO SUL" -> "Superintendência do IBGE no Rio Grande do Sul";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NA BAHIA" -> "Superintendência Estadual do IBGE na Bahia";
            case "SUPERINTENDENCIA ESTADUAL IBGE NO MATO GROSSO" -> "Superintendência Estadual do IBGE no Mato Grosso";
            case "SUPERINTENDENCIA ESTADUAL IBGE EM SAO PAULO" -> "Superintendência Estadual do IBGE em São Paulo";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO CEARA" -> "Superintendência Estadual do IBGE no Ceará";
            case "SUPERINTENDENCIA ESTADUAL IBGE SANTA CATARINA" ->
                    "Superintendência Estadual do IBGE em Santa Catarina";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO RJ" -> "Superintendência Estadual do IBGE no Rio de Janeiro";
            case "UNIDADE ESTADUAL DO IBGE NO PIAUI" -> "Unidade Estadual do IBGE no Piauí";
            case "SUPERINTENDENCIA ESTADUAL EM TOCANTINS" -> "Superintendência Estadual do IBGE no Tocantins";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE EM RONDONIA" -> "Superintendência Estadual do IBGE em Rondônia";
            case "UNIDADE ESTADUAL DO IBGE NA PARAIBA" -> "Unidade Estadual do IBGE na Paraíba";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO ES" -> "Superintendência Estadual do IBGE no Espírito Santo";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE EM ALAGOAS" -> "Superintendência Estadual do IBGE em Alagoas";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE ACRE" -> "Superintendência Estadual do IBGE no Acre";
            case "SUPERINTENDENCIA ESTADUAL EM RORAIMA-SES-RR" -> "Superintendência Estadual do IBGE em Roraima";
            case "UNIDADE ESTADUAL DO IBGE NO RIO G. NORTE" -> "Unidade Estadual do IBGE no Rio Grande do Norte";
            case "SUPERINTENDENCIA DO IBGE NO MATO GROSSO SUL" -> "Superintendência do IBGE no Mato Grosso do Sul";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE EM SERGIPE" -> "Superintendência Estadual do IBGE em Sergipe";
            case "SUPERINTENDENCIA ESTADUAL DO IBGE NO AMAPA" -> "Superintendência Estadual do IBGE no Amapá";
            case "SEC.DE ASSUNTOS INTERN. E DESENVOLVIMENTO" ->
                    "Secretaria de Assuntos Internacionais e Desenvolvimento";
            case "FOLHA DE PAGAMENTO - MPO" -> "Folha de Pagamento - MPO";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MPO" -> "Centro de Serviços Compartilhados - MPO";
            case "MINISTERIO DO PLANEJAMENTO E ORCAMENTO" -> "Ministério do Planejamento e Orçamento";
            case "INSTITUTO DE PESQUISA ECONOMICA APLICADA" -> "Instituto de Pesquisa Econômica Aplicada";
            case "COMPANHIA NACIONAL DE ABASTECIMENTO" -> "Companhia Nacional de Abastecimento";
            case "UNIDADE MERCADO DE OPCOES - SEDE" -> "Unidade Mercado de Opções - Sede";
            case "CONAB SEDE SUREG BAHIA" -> "CONAB - Sede Superintendência Regional da Bahia";
            case "CONAB SEDE SUREG MARANHAO" -> "CONAB - Sede Superintendência Regional do Maranhão";
            case "CONAB SEDE SUREG RIO GRANDE DO SUL" -> "CONAB - Sede Superintendência Regional do Rio Grande do Sul";
            case "CONAB SEDE SUREG MATO GROSSO" -> "CONAB - Sede Superintendência Regional de Mato Grosso";
            case "CONAB SEDE SUREG PERNAMBUCO" -> "CONAB - Sede Superintendência Regional de Pernambuco";
            case "CONAB SEDE SUREG MINAS GERAIS" -> "CONAB - Sede Superintendência Regional de Minas Gerais";
            case "CONAB SEDE/SUREG PI" -> "CONAB - Sede Superintendência Regional do Piauí";
            case "CONAB SEDE SUREG GOIAS" -> "CONAB - Sede Superintendência Regional de Goiás";
            case "CONAB SEDE SUREG AMAZONAS" -> "CONAB - Sede Superintendência Regional do Amazonas";
            case "CONAB SEDE SUREG ALAGOAS" -> "CONAB - Sede Superintendência Regional de Alagoas";
            case "CONAB SEDE SUREG SAO PAULO" -> "CONAB - Sede Superintendência Regional de São Paulo";
            case "CONAB SEDE SUREG PARAIBA" -> "CONAB - Sede Superintendência Regional da Paraíba";
            case "CONAB SEDE SUREG PARA" -> "CONAB - Sede Superintendência Regional do Pará";
            case "CONAB SEDE SUREG RIO GRANDE DO NORTE" ->
                    "CONAB - Sede Superintendência Regional do Rio Grande do Norte";
            case "CONAB SEDE SUREG CEARA" -> "CONAB - Sede Superintendência Regional do Ceará";
            case "CONAB SEDE SUREG ACRE" -> "CONAB - Sede Superintendência Regional do Acre";
            case "CONAB SEDE SUREG RORAIMA" -> "CONAB - Sede Superintendência Regional de Roraima";
            case "CONAB SEDE SUREG RIO DE JANEIRO" -> "CONAB - Sede Superintendência Regional do Rio de Janeiro";
            case "CONAB SEDE SUREG PARANA" -> "CONAB - Sede Superintendência Regional do Paraná";
            case "CONAB SEDE SUREG MATO GROSSO DO SUL" ->
                    "CONAB - Sede Superintendência Regional de Mato Grosso do Sul";
            case "CONAB SEDE SUREG AMAPA" -> "CONAB - Sede Superintendência Regional do Amapá";
            case "CONAB SEDE SUREG ES" -> "CONAB - Sede Superintendência Regional do Espírito Santo";
            case "CONAB SEDE SUREG RONDONIA" -> "CONAB - Sede Superintendência Regional de Rondônia";
            case "CONAB SEDE SUREG SANTA CATARINA" -> "CONAB - Sede Superintendência Regional de Santa Catarina";
            case "CONAB SEDE SUREG SERGIPE" -> "CONAB - Sede Superintendência Regional de Sergipe";
            case "CONAB SEDE SUREG TOCANTINS" -> "CONAB - Sede Superintendência Regional do Tocantins";
            case "CONAB SEDE SUREG DISTRITO FEDERAL E ENTORNO" ->
                    "CONAB - Sede Superintendência Regional do Distrito Federal e Entorno";
            case "NUCLEO ESTOQUE REGULADOR/PI - PGPM" -> "Núcleo de Estoque Regulador - PI - PGPM";
            case "NUCLEO ESTOQUE REGULADOR/PE - PGPM" -> "Núcleo de Estoque Regulador - PE - PGPM";
            case "NUCLEO ESTOQUE REGULADOR/PB - PGPM" -> "Núcleo de Estoque Regulador - PB - PGPM";
            case "MO/MG" -> "MO - MG";
            case "NUCLEO ESTOQUE REGULADOR - SEDE" -> "Núcleo de Estoque Regulador - Sede";
            case "MO/ACRE" -> "MO - Acre";
            case "UNIDADE CONAB PAA BAHIA" -> "Unidade CONAB PAA - Bahia";
            case "UA/ANANINDEUA" -> "UA - Ananindeua";
            case "UA/CAMBE" -> "UA - Cambé";
            case "UNIDADE CONAB PAA PERNAMBUCO" -> "Unidade CONAB PAA - Pernambuco";
            case "UNIDADE CONAB PAA SAO PAULO" -> "Unidade CONAB PAA - São Paulo";
            case "UNID.CENT.IRECE" -> "Unidade Central - IRECE";
            case "NUCLEO ESTOQUE REGULADOR/RO - PGPM" -> "Núcleo de Estoque Regulador - RO - PGPM";
            case "NUCLEO ESTOQUE REGULADOR/DF - PGPM" -> "Núcleo de Estoque Regulador - DF - PGPM";
            case "NUCLEO ESTOQUE REGULADOR/GO" -> "Núcleo de Estoque Regulador - GO";
            case "NUCLEO ESTOQUE REGULADOR/RR - PGPM" -> "Núcleo de Estoque Regulador - RR - PGPM";
            case "COMPANHIA NAC. DE ABASTECIMENTO - UA/CACOAL" -> "Companhia Nacional de Abastecimento - UA - Cacoal";
            case "UA/BERNARDINO DE CAMPOS" -> "UA - Bernardino de Campos";
            case "UA/PARNAIBA" -> "UA - Parnaíba";
            case "UNIDADE CONAB PAA MATO GROSSO" -> "Unidade CONAB PAA - Mato Grosso";
            case "UNIDADE ARMAZENADORA RIBEIRA DO POMBAL" -> "Unidade Armazenadora - Ribeira do Pombal";
            case "UNIDADE ARMAZENADORA DE PATOS" -> "Unidade Armazenadora - Patos";
            case "UNIDADE CONAB PAA MINAS GERAIS" -> "Unidade CONAB PAA - Minas Gerais";
            case "UNIDADE CONAB PAA RIO GRANDE DO NORTE" -> "Unidade CONAB PAA - Rio Grande do Norte";
            case "UA/S.L.MONTES BELO" -> "UA - São Lourenço Montes Belo";
            case "UNIDADE CONAB PAA RIO DE JANEIRO" -> "Unidade CONAB PAA - Rio de Janeiro";
            case "UNIDADE CONAB PAA MATO GROSSO DO SUL" -> "Unidade CONAB PAA - Mato Grosso do Sul";
            case "UA/SENADOR POMPEU" -> "UA - Senador Pompeu";
            case "UA/MOSSORO" -> "UA - Mossoró";
            case "UNIDADE CONAB PAA SERGIPE" -> "Unidade CONAB PAA - Sergipe";
            case "UNIDADE CONAB PAA RORAIMA" -> "Unidade CONAB PAA - Roraima";
            case "UNID.ESTOQUE ESTRATEGICO/RO" -> "Unidade de Estoque Estratégico - RO";
            case "UNIDADE CONAB PAA SANTA CATARINA" -> "Unidade CONAB PAA - Santa Catarina";
            case "DIV.EXECUTIVA DE FINANCAS-DAF.2 INCRA-SEDE/DF" ->
                    "Divisão Executiva de Finanças - DAF.2 INCRA - Sede - DF";
            case "CREDITO INSTALACAO - INCRA/MDA" -> "Crédito Instalação - INCRA/MDA";
            case "SUPERINT. REG.DO NORDESTE DO PARA - SR(PA/NE)" ->
                    "Superintendência Regional do Nordeste do Pará - SR(PA/NE)";
            case "SUPERINTENDENCIA REGIONAL DA BAHIA - SR(BA)" -> "Superintendência Regional da Bahia - SR(BA)";
            case "SUPERINT. REGIONAL DO DF E ENTORNO - SR(DF)" -> "Superintendência Regional do DF e Entorno - SR(DF)";
            case "SUPERINTENDENCIA REG. DO AMAZONAS - SR(AM)" -> "Superintendência Regional do Amazonas - SR(AM)";
            case "SUPERINTENDENCIA REG. DE RONDONIA - SR(RO)" -> "Superintendência Regional de Rondônia - SR(RO)";
            case "SUPERINTENDENCIA REG. DO MARANHAO - SR(MA)" -> "Superintendência Regional do Maranhão - SR(MA)";
            case "SUPERINTENDENCIA REGIONAL DO ACRE SR(AC)" -> "Superintendência Regional do Acre - SR(AC)";
            case "SUPERINTENDENCIA REGIONAL DE RORAIMA - SR(RR)" -> "Superintendência Regional de Roraima - SR(RR)";
            case "SUPERINTENDENCIA REGIONAL DO CEARA - SR(CE)" -> "Superintendência Regional do Ceará - SR(CE)";
            case "SUPERINT. REG. DO SUDESTE DO PARA - SR(PA/SE)" ->
                    "Superintendência Regional do Sudeste do Pará - SR(PA/SE)";
            case "SUPERINTENDENCIA REG. DE PERNAMBUCO - SR(PE)" -> "Superintendência Regional de Pernambuco - SR(PE)";
            case "SUPERINT. REG. DO RIO GRANDE DO SUL - SR(RS)" ->
                    "Superintendência Regional do Rio Grande do Sul - SR(RS)";
            case "SUPERINTENDENCIA REG. DE SERGIPE - SR(SE)" -> "Superintendência Regional de Sergipe - SR(SE)";
            case "SUPERINTENDENCIA REG. DE SAO PAULO - SR(SP)" -> "Superintendência Regional de São Paulo - SR(SP)";
            case "SUPERINTENDENCIA REGIONAL DO PARANA - SR(PR)" -> "Superintendência Regional do Paraná - SR(PR)";
            case "SUPERINTEND.REGIONAL DO R.GRANDE DO NORTE SR(RN)" ->
                    "Superintendência Regional do Rio Grande do Norte - SR(RN)";
            case "SUPERINTEND. REGIONAL DE TOCANTINS - SR(TO)" -> "Superintendência Regional do Tocantins - SR(TO)";
            case "SUPERINTEND. REGIONAL DE MAT0 GROSSO - SR(MT)" -> "Superintendência Regional de Mato Grosso - SR(MT)";
            case "SUPERINTEND. REG. DO OESTE DO PARA - SR(PA/O)" ->
                    "Superintendência Regional do Oeste do Pará - SR(PA/O)";
            case "SUPERINTENDENCIA REG.DE MINAS GERAIS - SR(MG)" ->
                    "Superintendência Regional de Minas Gerais - SR(MG)";
            case "SUPERINTENDENCIA REGIONAL DO PIAUI - SR(PI)" -> "Superintendência Regional do Piauí - SR(PI)";
            case "SUPERINTENDENCIA REGIONAL DO AMAPA - SR(AP)" -> "Superintendência Regional do Amapá - SR(AP)";
            case "SUPERINT. REG. DE MATO GROSS0 DO SUL - SR(MS)" ->
                    "Superintendência Regional de Mato Grosso do Sul - SR(MS)";
            case "SUPERINTENDENCIA REGIONAL DE GOIAS - SR(GO)" -> "Superintendência Regional de Goiás - SR(GO)";
            case "SUPERINTEND. REG. DO RIO DE JANEIRO - SR(RJ)" ->
                    "Superintendência Regional do Rio de Janeiro - SR(RJ)";
            case "SUPERINTENDENCIA REGIONAL DE ALAGOAS - SR(AL)" -> "Superintendência Regional de Alagoas - SR(AL)";
            case "SUPERINTENDENCIA REGIONAL DA PARAIBA - SR(PB)" -> "Superintendência Regional da Paraíba - SR(PB)";
            case "SUPERINT. REGIONAL DE SANTA CATARINA - SR(SC)" ->
                    "Superintendência Regional de Santa Catarina - SR(SC)";
            case "SUPERINT. REGIONAL DO ESPIRITO SANTO - SR(ES)" ->
                    "Superintendência Regional do Espírito Santo - SR(ES)";
            case "UNIDADE AVANCADA ESPECIAL DE ALTAMIRA" -> "Unidade Avançada Especial de Altamira";
            case "SUPERINT.REG.DO MEDIO SAO FRANCISCO - SR(MSF)" ->
                    "Superintendência Regional do Médio São Francisco - SR(MSF)";
            case "UNIDADE AVANCADA VALE DO ARAGUAIA" -> "Unidade Avançada Vale do Araguaia";
            case "UNIDADE AVANCADA TUCURUI" -> "Unidade Avançada Tucuruí";
            case "UNIDADE AVANCADA CONCEICAO DO ARAGUAIA" -> "Unidade Avançada Conceição do Araguaia";
            case "UNIDADE AVANCADA IMPERATRIZ" -> "Unidade Avançada Imperatriz";
            case "UNIDADE AVANCADA PARAGOMINAS" -> "Unidade Avançada Paragominas";
            case "UNIDADE AVANCADA SAO GERALDO DO ARAGUAIA" -> "Unidade Avançada São Geraldo do Araguaia";
            case "UNIDADE AVANCADA BARRA DO CORDA" -> "Unidade Avançada Barra do Corda";
            case "UNIDADE AVANCADA SAO FELIX DO XINGU" -> "Unidade Avançada São Félix do Xingu";
            case "SEC. DE AGRICULTURA FAMILIAR E AGROECOLOGIA" -> "Secretaria de Agricultura Familiar e Agroecologia";
            case "MIN. DESENV. AGRARIO E AGRICULTURA FAMILIAR" ->
                    "Ministério do Desenvolvimento Agrário e Agricultura Familiar";
            case "COORDENACAO DE GESTAO DE PESSOAS/MDA" -> "Coordenação de Gestão de Pessoas - MDA";
            case "SUBSECRETARIA DE MULHERES RURAIS/MDA" -> "Subsecretaria de Mulheres Rurais - MDA";
            case "SEC. DE GOV. FUND., DES. TERR. E SOCIOAMBIENT" ->
                    "Secretaria de Governança Fundiária, Desenvolvimento Territorial e Socioambiental";
            case "PROJETO DOM HELDER CAMARA II - FIDA" -> "Projeto Dom Helder Câmara II - FIDA";
            case "CREDITO FUNDIARIO" -> "Crédito Fundiário";
            case "DIRETORIA DE LOGISTICA E GESTAO DOCUMENTAL" -> "Diretoria de Logística e Gestão Documental";
            case "SUPERINTENDENCIA REG. DE ADMIN. DA 1ª REGIAO" ->
                    "Superintendência Regional de Administração da 1ª Região";
            case "SUPERINTENDENCIA REG. DE ADMIN. DA 5ª REGIAO" ->
                    "Superintendência Regional de Administração da 5ª Região";
            case "SUPERINTENDENCIA REG. DE ADMIN. DA 3ª REGIAO" ->
                    "Superintendência Regional de Administração da 3ª Região";
            case "SUPERINTENDENCIA REG. DE ADMIN. DA 2ª REGIAO" ->
                    "Superintendência Regional de Administração da 2ª Região";
            case "SUPERINTENDENCIA REG. DE ADMIN. DA 4ª REGIAO" ->
                    "Superintendência Regional de Administração da 4ª Região";
            case "SUPERINTENDENCIA REG. DE ADMIN. DA 6ª REGIAO" ->
                    "Superintendência Regional de Administração da 6ª Região";
            case "DIVISAO DE DIARIAS E PASSAGENS DA AGU" -> "Divisão de Diárias e Passagens da AGU";
            case "ESCOLA SUPERIOR AGU MINIST. VICTOR NUNES LEAL" -> "Escola Superior AGU Ministro Victor Nunes Leal";
            case "BANCO CENTRAL DO BRASIL" -> "Banco Central do Brasil";
            case "CONSELHO DE CONTROLE DE ATIVIDADE FINANCEIRA" -> "Conselho de Controle de Atividades Financeiras";
            case "AGENCIA NACIONAL DO CINEMA" -> "Agência Nacional do Cinema";
            case "FNC - SEFIC" -> "FNC - SEFIC";
            case "SECRETARIA DE FORMACAO, LIVRO E LEITURA" -> "Secretaria de Formação, Livro e Leitura";
            case "FNC - SCDC" -> "FNC - SCDC";
            case "SEC. ECONOMIA CRIATIVA E FOMENTO CULTURAL/FNC" ->
                    "Secretaria de Economia Criativa e Fomento Cultural - FNC";
            case "SECRETARIA DO AUDIOVISUAL/FNC" -> "Secretaria do Audiovisual - FNC";
            case "SEC. CIDADANIA E DIVERSIDADE CULTURAL/FNC" -> "Secretaria de Cidadania e Diversidade Cultural - FNC";
            case "FNC - SEEC" -> "FNC - SEEC";
            case "FNC - SAV" -> "FNC - SAV";
            case "SUBSECRETARIA DE ESPACOS E EQUIP. CULTURAIS" -> "Subsecretaria de Espaços e Equipamentos Culturais";
            case "SECRETARIA EXECUTIVA/FNC" -> "Secretaria Executiva - FNC";
            case "COORDENACAO GERAL DE GESTAO DE PESSOAS" -> "Coordenação-Geral de Gestão de Pessoas";
            case "COORD-GERAL DE LICIT., CONTRAT. E REC. LOGIST" ->
                    "Coordenação-Geral de Licitação, Contratação e Recursos Logísticos";
            case "SCDC - CONVENIOS" -> "SCDC - Convênios";
            case "SECRETARIA DOS COMITES DE CULTURA" -> "Secretaria dos Comitês de Cultura";
            case "SUBSECRETARIA DE TECNOLOGIA DA INF. E INOV." ->
                    "Subsecretaria de Tecnologia da Informação e Inovação";
            case "SAV - CONTRATOS" -> "SAV - Contratos";
            case "ASSESSORIA ESPECIAL DE COMUNICACAO SOCIAL" -> "Assessoria Especial de Comunicação Social";
            case "SECRETARIA DO AUDIOVISUAL/MINC" -> "Secretaria do Audiovisual - MINC";
            case "CENTRO TECNICO AUDIOVISUAL-CTAV" -> "Centro Técnico Audiovisual - CTAV";
            case "GABINETE DO MINISTRO" -> "Gabinete do Ministro";
            case "SEFIC - CONVENIOS" -> "SEFIC - Convênios";
            case "SEEC - CONTRATOS" -> "SEEC - Contratos";
            case "SECRETARIA EXECUTIVA - MINC" -> "Secretaria Executiva - MINC";
            case "CAIXA - CULTURA" -> "Caixa - Cultura";
            case "SECRETARIA-EXECUTIVA/MC" -> "Secretaria Executiva - MC";
            case "SECRETARIA CIDADANIA E DIVERSIDADE CULTURAL" -> "Secretaria de Cidadania e Diversidade Cultural";
            case "SEFIC - CONTRATOS" -> "SEFIC - Contratos";
            case "CAIXA ECONOMICA FEDERAL - PAC/PRACAS/MINC" -> "Caixa Econômica Federal - PAC/PRACAS/MINC";
            case "SECRET. DE FOMENTO E INCENTIVO A CULTURA/MINC" ->
                    "Secretaria de Fomento e Incentivo à Cultura - MINC";
            case "SAV - CONVENIOS" -> "SAV - Convênios";
            case "SUBSEC. DE ESPACOS E EQUIPAMENTOS CULTURAIS" -> "Subsecretaria de Espaços e Equipamentos Culturais";
            case "CENTRO TECNICO DO AUDIOVISUAL" -> "Centro Técnico do Audiovisual";
            case "SEEC - CONVENIOS" -> "SEEC - Convênios";
            case "SUBSECRETARIA DE GESTAO ESTRATEGICA" -> "Subsecretaria de Gestão Estratégica";
            case "SEC. DE DIR. AUTORAIS E INTELECTUAIS" -> "Secretaria de Direitos Autorais e Intelectuais";
            case "COORDENACAO-GERAL DE GESTAO ESTRAT.DE PESSOAS" ->
                    "Coordenação-Geral de Gestão Estratégica de Pessoas";
            case "IPHAN - EXECUCAO ORCAMENTARIA E FINANCEIRA" -> "IPHAN - Execução Orçamentária e Financeira";
            case "SUPERINTENDENCIA DO IPHAN M. GERAIS, IPHAN-MG" ->
                    "Superintendência do IPHAN em Minas Gerais - IPHAN-MG";
            case "SUPERINTENDENCIA DO IPHAN PERNAMBUCO,IPHAN-PE" ->
                    "Superintendência do IPHAN em Pernambuco - IPHAN-PE";
            case "SUPERINTENDENCIA DO IPHAN RIO DE JANEIRO-RJ" ->
                    "Superintendência do IPHAN no Rio de Janeiro - IPHAN-RJ";
            case "SUPERINTENDENCIA DO IPHAN NA BAHIA, IPHAN-BA" -> "Superintendência do IPHAN na Bahia - IPHAN-BA";
            case "SUPERINTENDENCIA DO IPHAN R.G.DO SUL,IPHAN-RS" ->
                    "Superintendência do IPHAN no Rio Grande do Sul - IPHAN-RS";
            case "CENTRO NACIONAL DE FOLCLORE E CULTURA POPULAR" -> "Centro Nacional de Folclore e Cultura Popular";
            case "SUPERINTENDENCIA DO IPHAN SAO PAULO, IPHAN-SP" -> "Superintendência do IPHAN em São Paulo - IPHAN-SP";
            case "CENTRO CULTURAL SITIO ROBERTO BURLE MARX-RJ" -> "Centro Cultural Sítio Roberto Burle Marx - RJ";
            case "CENTRO LUCIO COSTA - CLC" -> "Centro Lúcio Costa - CLC";
            case "SUPERINTENDENCIA DO IPHAN NO CEARA, IPHAN-CE" -> "Superintendência do IPHAN no Ceará - IPHAN-CE";
            case "SUPERINTENDENCIA DO IPHAN S.CATARINA,IPHAN-SC" ->
                    "Superintendência do IPHAN em Santa Catarina - IPHAN-SC";
            case "SUPERINTENDENCIA DO IPHAN EM ALAGOAS,IPHAN-AL" -> "Superintendência do IPHAN em Alagoas - IPHAN-AL";
            case "SUPERINTENDENCIA DO IPHAN EM SERGIPE,IPHAN-SE" -> "Superintendência do IPHAN em Sergipe - IPHAN-SE";
            case "SUPERINTENDENCIA DO IPHAN NO PARANA, IPHAN-PR" -> "Superintendência do IPHAN no Paraná - IPHAN-PR";
            case "SUPERINTENDENCIA DO IPHAN NO E.SANTO,IPHAN-ES" ->
                    "Superintendência do IPHAN no Espírito Santo - IPHAN-ES";
            case "SUPERINTENDENCIA DO IPHAN EM GOIAS, IPHAN-GO" -> "Superintendência do IPHAN em Goiás - IPHAN-GO";
            case "SUPERINTENDENCIA DO IPHAN D. FEDERAL,IPHAN-DF" ->
                    "Superintendência do IPHAN no Distrito Federal - IPHAN-DF";
            case "SUPERINTENDENCIA DO IPHAN NO PARA, IPHAN-PA" -> "Superintendência do IPHAN no Pará - IPHAN-PA";
            case "SUPERINTENDENCIA DO IPHAN M.G.DO SUL,IPHAN-MS" ->
                    "Superintendência do IPHAN em Mato Grosso do Sul - IPHAN-MS";
            case "CONDOMINIO DO PALACIO GUSTAVO CAPANEMA" -> "Condomínio do Palácio Gustavo Capanema";
            case "SUPERINTENDENCIA DO IPHAN NA PARAIBA,IPHAN-PB" -> "Superintendência do IPHAN na Paraíba - IPHAN-PB";
            case "CAIXA ECONOMICA FEDERAL - DPE - IPHAN" -> "Caixa Econômica Federal - DPE - IPHAN";
            case "SUPERINTENDENCIA DO IPHAN RONDONIA, IPHAN-RO" -> "Superintendência do IPHAN em Rondônia - IPHAN-RO";
            case "SUPERINTENDENCIA DO IPHAN MARANHAO, IPHAN-MA" -> "Superintendência do IPHAN no Maranhão - IPHAN-MA";
            case "SUPERINTENDENCIA DO IPHAN NO PIAUI, IPHAN-PI" -> "Superintendência do IPHAN no Piauí - IPHAN-PI";
            case "CENTRO CULTURAL PACO IMPERIAL-RJ" -> "Centro Cultural Paço Imperial - RJ";
            case "SUPERINTENDENCIA DO IPHAN NO ACRE-AC" -> "Superintendência do IPHAN no Acre - IPHAN-AC";
            case "SUPERINTENDENCIA DO IPHAN NO AMAPA-AP" -> "Superintendência do IPHAN no Amapá - IPHAN-AP";
            case "SUPERINTENDENCIA DO IPHAN AMAZONAS, IPHAN-AM" -> "Superintendência do IPHAN no Amazonas - IPHAN-AM";
            case "SUPERINTENDENCIA DO IPHAN NO MATO GROSSO - MT" ->
                    "Superintendência do IPHAN em Mato Grosso - IPHAN-MT";
            case "SUPERINTENDENCIA DO IPHAN EM TOCANTINS - TO" -> "Superintendência do IPHAN no Tocantins - IPHAN-TO";
            case "SUPERINTENDENCIA DO IPHAN EM RORAIMA - RR" -> "Superintendência do IPHAN em Roraima - IPHAN-RR";
            case "SUPERINTENDENCIA DO IPHAN NO RIO G. NORTE/RN" ->
                    "Superintendência do IPHAN no Rio Grande do Norte - IPHAN-RN";
            case "COORDENACAO DE GESTAO DE PESSOAS" -> "Coordenação de Gestão de Pessoas";
            case "ESCRITORIO DE REPRESENTACAO DO IBRAM/RJ" -> "Escritório de Representação do IBRAM - RJ";
            case "IBRAM - SEDE" -> "IBRAM - Sede";
            case "MUSEU IMPERIAL - PETROPOLIS" -> "Museu Imperial - Petrópolis";
            case "ESCRITORIO DE REPRESENTACAO DO IBRAM/MG-ES" -> "Escritório de Representação do IBRAM - MG/ES";
            case "MUSEU LASAR SEGALL - SAO PAULO" -> "Museu Lasar Segall - São Paulo";
            case "FUNDACAO NACIONAL DE ARTES" -> "Fundação Nacional de Artes";
            case "FUNDACAO BIBLIOTECA NACIONAL" -> "Fundação Biblioteca Nacional";
            case "FUNDACAO CASA DE RUI BARBOSA" -> "Fundação Casa de Rui Barbosa";
            case "FUNDACAO CULTURAL PALMARES" -> "Fundação Cultural Palmares";
            case "FUNDO DA MARINHA MERCANTE" -> "Fundo da Marinha Mercante";
            case "AGENCIA NACIONAL DE AVIACAO CIVIL" -> "Agência Nacional de Aviação Civil";
            case "SUPERINTENDENCIA DE GESTAO DE PESSOAS - ANAC" -> "Superintendência de Gestão de Pessoas - ANAC";
            case "REPRESENTACAO REGIONAL SAO PAULO-ANAC" -> "Representação Regional São Paulo - ANAC";
            case "REPRESENTACAO REGIONAL RIO DE JANEIRO - ANAC" -> "Representação Regional Rio de Janeiro - ANAC";
            case "FUNDO NACIONAL DE AVIACAO CIVIL" -> "Fundo Nacional de Aviação Civil";
            case "SECRETARIA NACIONAL DE PORTOS" -> "Secretaria Nacional de Portos";
            case "SECRETARIA EXECUTIVA" -> "Secretaria Executiva";
            case "GM-GABINETE DO MINISTRO" -> "Gabinete do Ministro - GM";
            case "AGENCIA NACIONAL DE TRANSPORTES AQUAVIARIOS" -> "Agência Nacional de Transportes Aquaviários";
            case "ESCRITORIO CENTRAL DA ANP" -> "Escritório Central da ANP";
            case "COMPANHIA DE PESQUISA DE RECURSOS MINERAIS" -> "Companhia de Pesquisa de Recursos Minerais";
            case "NUCLEBRAS EQUIPAMENTOS PESADOS S/A-NUCLEP" -> "Nuclebrás Equipamentos Pesados S/A - NUCLEP";
            case "AGENCIA NACIONAL DE MINERACAO - ANM - FOPAG" -> "Agência Nacional de Mineração - ANM - FOPAG";
            case "AGENCIA NACIONAL DE MINERACAO - DF" -> "Agência Nacional de Mineração - DF";
            case "GERENCIA REGIONAL DA ANM - RS" -> "Gerência Regional da ANM - RS";
            case "GERENCIA REGIONAL DA ANM - RJ" -> "Gerência Regional da ANM - RJ";
            case "AGENCIA NACIONAL DE ENERGIA ELETRICA" -> "Agência Nacional de Energia Elétrica";
            case "COORD.GERAL DE GESTAO DE PESSOAS/MME" -> "Coordenação-Geral de Gestão de Pessoas - MME";
            case "SECRET.NAC.PETR.GAS NAT.E BIOCOMBUSTIVEIS/MME" ->
                    "Secretaria Nacional de Petróleo, Gás Natural e Biocombustíveis - MME";
            case "PROJETO META II/SECRETARIA EXECUTIVA" -> "Projeto Meta II - Secretaria Executiva";
            case "SUBSECRETARIA DE TECNOLOGIA E INOVACAO/MME" -> "Subsecretaria de Tecnologia e Inovação - MME";
            case "SEC.NAC. DE TRANS. ENERG. E PLANEJAMENTO/MME" ->
                    "Secretaria Nacional de Transporte de Energia e Planejamento - MME";
            case "SECRETARIA NACIONAL DE ENERGIA ELETRICA/MME" -> "Secretaria Nacional de Energia Elétrica - MME";
            case "SECRET.NAC.DE GEOL.MINER.TRANS.MINERAL/MME" ->
                    "Secretaria Nacional de Geologia, Mineração e Transformação Mineral - MME";
            case "EMPRESA DE PESQUISA ENERGETICA" -> "Empresa de Pesquisa Energética";
            case "AGENCIA BRASILEIRA DE INTELIGENCIA" -> "Agência Brasileira de Inteligência";
            case "SECRETARIA DE COMUNICACAO SOCIAL/PR" -> "Secretaria de Comunicação Social - PR";
            case "SECRETARIA DE ADMINISTRACAO/PR" -> "Secretaria de Administração - PR";
            case "GABINETE DE SEGURANCA INSTITUCIONAL/PR" -> "Gabinete de Segurança Institucional - PR";
            case "SECRETARIA ESPECIAL PARA A COP 30" -> "Secretaria Especial para a COP 30";
            case "SECRETARIA GERAL DA PRESIDENCIA DA REPUBLICA" -> "Secretaria-Geral da Presidência da República";
            case "SECRETARIA NACIONAL DA JUVENTUDE" -> "Secretaria Nacional da Juventude";
            case "SECRETARIA ESP.PROG.PARCERIAS E INVESTIMENTO" ->
                    "Secretaria Especial de Programas, Parcerias e Investimentos";
            case "SECRETARIA DE ADMINISTRACAO - PECULIARIDADES" -> "Secretaria de Administração - Peculiaridades";
            case "SECRETARIA RELACOES INSTITUCIONAIS/PR SCDP" -> "Secretaria de Relações Institucionais - PR - SCDP";
            case "SECRETARIA NACIONAL DA JUVENTUDE/PR" -> "Secretaria Nacional da Juventude - PR";
            case "SECRETARIA DE RELACOES INSTITUCIONAIS DA PR" -> "Secretaria de Relações Institucionais da PR";
            case "EMPRESA BRASIL DE COMUNICACAO S.A" -> "Empresa Brasil de Comunicação S.A.";
            case "FUNDO DE IMPRENSA NACIONAL/EXEC.ORC.FINANC." ->
                    "Fundo de Imprensa Nacional - Execução Orçamentária e Financeira";
            case "FUNDO DE IMPRENSA NACIONAL/COORD. REC. HUMAN." ->
                    "Fundo de Imprensa Nacional - Coordenação de Recursos Humanos";
            case "GABINETE DA VICE-PRESIDENCIA DA REPUBLICA" -> "Gabinete da Vice-Presidência da República";
            case "VICE-PRESIDENCIA DA REPUBLICA" -> "Vice-Presidência da República";
            case "SE/MDIC/ORCAMENTO E FINANCAS" -> "Secretaria Executiva - MDIC - Orçamento e Finanças";
            case "FOLHA DE PAGAMENTO - MDIC" -> "Folha de Pagamento - MDIC";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MDIC" -> "Centro de Serviços Compartilhados - MDIC";
            case "MDIC/CAIXA ECONOMICA FEDERAL" -> "MDIC - Caixa Econômica Federal";
            case "INSTITUTO NAC.DE METROLOG. QUALID. E TECNOLOG" ->
                    "Instituto Nacional de Metrologia, Qualidade e Tecnologia";
            case "SUPERINTENDENCIA DO INMETRO NO ESTADO DO RS" ->
                    "Superintendência do INMETRO no Estado do Rio Grande do Sul";
            case "SUPERINTENDENCIA DO INMETRO NO ESTADO DE GOIA" -> "Superintendência do INMETRO no Estado de Goiás";
            case "INSTITUTO NACIONAL DA PROPRIEDADE INDUSTRIAL" -> "Instituto Nacional da Propriedade Industrial";
            case "SUPERINTENDENCIA DA ZONA FRANCA DE MANAUS/AM" -> "Superintendência da Zona Franca de Manaus - AM";
            case "FUNDO DE GAR.P/PROMOC.DA COMPETITIVIDADE±FGP" ->
                    "Fundo de Garantia para Promoção da Competitividade - FGP";
            case "FUNDO DE UNIVERS.DOS SERV.TELECOMUNICACOES" ->
                    "Fundo de Universalização dos Serviços de Telecomunicações";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-SEDE" -> "Agência Nacional de Telecomunicações - Sede";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-RJ" -> "Agência Nacional de Telecomunicações - RJ";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-BA" -> "Agência Nacional de Telecomunicações - BA";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-CE" -> "Agência Nacional de Telecomunicações - CE";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-SP" -> "Agência Nacional de Telecomunicações - SP";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-PA" -> "Agência Nacional de Telecomunicações - PA";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-PE" -> "Agência Nacional de Telecomunicações - PE";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-RS" -> "Agência Nacional de Telecomunicações - RS";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-PR" -> "Agência Nacional de Telecomunicações - PR";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-GO" -> "Agência Nacional de Telecomunicações - GO";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-AM" -> "Agência Nacional de Telecomunicações - AM";
            case "AGENCIA NACIONAL DE TELECOMUNICACOES-MG" -> "Agência Nacional de Telecomunicações - MG";
            case "TELECOMUNICACOES BRASILEIRAS S/A" -> "Telecomunicações Brasileiras S/A";
            case "FUNDO P/O DESENV.TECNOL.DAS TELECOMUNICACOES" ->
                    "Fundo para o Desenvolvimento Tecnológico das Telecomunicações";
            case "FUNTTEL/FINEP - AGENTE FINANCEIRO DO FUNTTEL" -> "FUNTTEL/FINEP - Agente Financeiro do FUNTTEL";
            case "COORDENACAO-GERAL GESTAO DE PESSOAS" -> "Coordenação-Geral de Gestão de Pessoas";
            case "COORD-GERAL DE LICITACAO,CONTR.E DOCUMENTACAO" ->
                    "Coordenação-Geral de Licitação, Contratação e Documentação";
            case "COORD-GERAL DE ORCAM.,FINANC. E CONTABILIDADE" ->
                    "Coordenação-Geral de Orçamento, Finanças e Contabilidade";
            case "FUNDO GERAL DE TURISMO - NOVO FUNGETUR" -> "Fundo Geral de Turismo - NOVO FUNGETUR";
            case "CAIXA - SNINFRA" -> "Caixa - SNINFRA";
            case "SUBSECRETARIA DE ADMINISTRACAO - SAD" -> "Subsecretaria de Administração - SAD";
            case "COGEP/MTUR" -> "COGEP - MTUR";
            case "SNINFRA - CONTRATOS" -> "SNINFRA - Contratos";
            case "SNPTUR - CONVENIOS" -> "SNPTUR - Convênios";
            case "SNPTUR - CONTRATOS" -> "SNPTUR - Contratos";
            case "COORD-GERAL DE ORC,FINANCAS E CONTAB." -> "Coordenação-Geral de Orçamento, Finanças e Contabilidade";
            case "COORD-GERAL DE GESTAO DE PESSOAS E DESEMPENH0" ->
                    "Coordenação-Geral de Gestão de Pessoas e Desempenho";
            case "FUNDACAO NACIONAL DOS POVOS INDIGENAS" -> "Fundação Nacional do Índio - FUNAI";
            case "FUNAI-DIRETORIA DE PROTECAO TERRITORIAL" -> "FUNAI - Diretoria de Proteção Territorial";
            case "COORDENACAO REGIONAL RORAIMA/RR" -> "Coordenação Regional Roraima - RR";
            case "COORDENACAO REG. KAYAPO SUL DO PARA/PA" -> "Coordenação Regional Kayapó Sul do Pará - PA";
            case "COORDENACAO REGIONAL SUL DA BAHIA/BA" -> "Coordenação Regional Sul da Bahia - BA";
            case "COORDENACAO REGIONAL MARANHAO/MA" -> "Coordenação Regional Maranhão - MA";
            case "COORDENACAO REGIONAL DO RIO NEGRO/AM" -> "Coordenação Regional do Rio Negro - AM";
            case "COORDENACAO REGIONAL DE CUIABA/MT" -> "Coordenação Regional de Cuiabá - MT";
            case "COORDENACAO REGIONAL ARAGUAIA TOCANTINS/TO" -> "Coordenação Regional Araguaia Tocantins - TO";
            case "FUNAI-DIRETORIA DE PROM. AO DESENV. SUSTENT." ->
                    "FUNAI - Diretoria de Promoção ao Desenvolvimento Sustentável";
            case "COORDENACAO REG. DO VALE DO JAVARI/AM" -> "Coordenação Regional do Vale do Javari - AM";
            case "FUNAI-COORDENACAO REGIONAL DO MADEIRA/AM" -> "FUNAI - Coordenação Regional do Madeira - AM";
            case "COORDENACAO REG. DO LITORAL SUL/SC" -> "Coordenação Regional do Litoral Sul - SC";
            case "COORDENACAO REGIONAL MEDIO PURUS/AM" -> "Coordenação Regional Médio Purus - AM";
            case "FUNAI-COORDENACAO REGIONAL DE JI-PARANA/RO" -> "FUNAI - Coordenação Regional de Ji-Paraná - RO";
            case "COORD. REG. CENTRO-LESTE DO PARA/PA" -> "Coordenação Regional Centro-Leste do Pará - PA";
            case "COORD. REG. NOROESTE DO MATO GROSSO/MT" -> "Coordenação Regional Noroeste do Mato Grosso - MT";
            case "COORDENACAO REGIONAL NORDESTE 1/AL" -> "Coordenação Regional Nordeste 1 - AL";
            case "MUSEU DO INDIO - RIO DE JANEIRO" -> "Museu do Índio - Rio de Janeiro";
            case "COORDENACAO REGIONAL DE MANAUS/AM" -> "Coordenação Regional de Manaus - AM";
            case "COORDENACAO REGIONAL XAVANTE/MT" -> "Coordenação Regional Xavante - MT";
            case "COORDENACAO REGIONAL XINGU/MT" -> "Coordenação Regional Xingu - MT";
            case "COORDENACAO REG. LITORAL SUDESTE/SP" -> "Coordenação Regional Litoral Sudeste - SP";
            case "COORDENACAO REG.AMAPA E NORTE DO PARA/AP" -> "Coordenação Regional Amapá e Norte do Pará - AP";
            case "COORDENACAO REG. DE GUAJARA MIRIM/RO" -> "Coordenação Regional de Guajará-Mirim - RO";
            case "COORDENACAO REGIONAL DE GUARAPUAVA/PR" -> "Coordenação Regional de Guarapuava - PR";
            case "COORDENACAO REGIONAL DE CACOAL/RO" -> "Coordenação Regional de Cacoal - RO";
            case "COORDENACAO REGIONAL ALTO PURUS" -> "Coordenação Regional Alto Purus";
            case "COORDENACAO REGIONAL TAPAJOS/PA" -> "Coordenação Regional Tapajós - PA";
            case "COORDENACAO REGIONAL BAIXO TOCANTINS/PA" -> "Coordenação Regional Baixo Tocantins - PA";
            case "FUNAI-COORDENACAO REGIONAL DO JURUA/AC" -> "FUNAI - Coordenação Regional do Juruá - AC";
            case "COORDENACAO REGIONAL DOURADOS/MS" -> "Coordenação Regional Dourados - MS";
            case "COORDENACAO REGIONAL NORDESTE 2/CE" -> "Coordenação Regional Nordeste 2 - CE";
            case "COORD. REG. DE MINAS GERAIS E ESPIRITO SANTO/MG" ->
                    "Coordenação Regional de Minas Gerais e Espírito Santo - MG";
            case "COORDENACAO REGIONAL PASSO FUNDO/RS" -> "Coordenação Regional Passo Fundo - RS";
            case "FUNAI-COORDENACAO REGIONAL DE JOAO PESSOA/PB" -> "FUNAI - Coordenação Regional de João Pessoa - PB";
            case "FUNAI-COORDENACAO REGIONAL DE CAMPO GRANDE/MS" -> "FUNAI - Coordenação Regional de Campo Grande - MS";
            case "COORDENACAO REGIONAL INTERIOR SUL/SC" -> "Coordenação Regional Interior Sul - SC";
            case "COORDENACAO REG.BAIXO SAO FRANCISCO/BA" -> "Coordenação Regional Baixo São Francisco - BA";
            case "COORDENACAO REGIONAL DE PONTA PORA/MS" -> "Coordenação Regional de Ponta Porã - MS";
            case "COORDENACAO REG. NORTE DO MATO GROSSO/MT" -> "Coordenação Regional Norte do Mato Grosso - MT";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MPI" -> "Centro de Serviços Compartilhados - MPI";
            case "FOLHA DE PAGAMENTO - MPI" -> "Folha de Pagamento - MPI";
            case "PROJETO AVA-CANOEIRO - ROYALTIES - PALMAS-TO" -> "Projeto Ava-Canoeiro - Royalties - Palmas - TO";
            case "PROJETO RAPOSA SERRA DO SOL E SAO MARCOS" -> "Projeto Raposa Serra do Sol e São Marcos";
            case "PROJETO COMUNIDADE INDIGENA FULNI-O - PE" -> "Projeto Comunidade Indígena Fulni-ô - PE";
            case "PROJETO COMUNIDADE INDIGENA KAYAPO" -> "Projeto Comunidade Indígena Kayapó";
            case "PROGRAMA DE APOIO AOS AVA-CANOEIRO/CONVENIO" -> "Programa de Apoio aos Ava-Canoeiro - Convênio";
            case "UHE BELO MONTE INDIGENAS RIBEIRINHOS" -> "UHE Belo Monte Indígenas Ribeirinhos";
            case "PROJETO C.I. ASSURINI - TI TROCARA" -> "Projeto C.I. Assurini - TI Trocará";
            case "PROGRAMA PARESI PCH JURUENA TANGARA SERRA MT" -> "Programa Paresi PCH Juruena Tangará Serra - MT";
            case "UHE BELO MONTE INDIGENAS CITADINOS" -> "UHE Belo Monte Indígenas Cidadãos";
            case "UHE BELO MONTE TI PAQUICAMBA" -> "UHE Belo Monte TI Paquiçamba";
            case "UHE BELO MONTE TI KURUAYA" -> "UHE Belo Monte TI Kuruaya";
            case "PROJETO JUDICIAL - T.I ALTO TURIACU - MA" -> "Projeto Judicial - T.I Alto Turiaçu - MA";
            case "CEF/MINISTERIO DO ESPORTE" -> "Caixa Econômica Federal - Ministério do Esporte";
            case "SEC NAC ESP AMADOR, ED. LAZER E INC SOCIAL" ->
                    "Secretaria Nacional de Esporte, Amador, Educação, Lazer e Inclusão Social";
            case "SECRETARIA NACIONAL ESPORTES ALTO DESEMPENHO" -> "Secretaria Nacional de Esportes de Alto Desempenho";
            case "FOLHA DE PAGAMENTO" -> "Folha de Pagamento";
            case "COORDENACAO GERAL GESTAO DE INSTALACOES ESP" ->
                    "Coordenação-Geral de Gestão de Instalações Esportivas";
            case "SE NAC. DE FUTEBOL E DEFESA DIR. TORCEDOR" ->
                    "Secretaria Nacional de Futebol e Defesa dos Direitos do Torcedor";
            case "SECRETARIA NACIONAL DE PARADESPORTO" -> "Secretaria Nacional de Paradesporto";
            case "AUTORIDADE BRASILEIRA DE CONTROLE DE DOPAGEM" -> "Autoridade Brasileira de Controle de Dopagem";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MESP" -> "Centro de Serviços Compartilhados - MESP";
            case "DEPARTAMENTO DE INFRAESTRUTURA DE ESPORTE" -> "Departamento de Infraestrutura de Esporte";
            case "COORDENACAO-GERAL DE LOGISTICA - MDHC" -> "Coordenação-Geral de Logística - MDHC";
            case "SEC.NAC. DE PROMOCAO E DEFESA DOS DIR.HUMANOS" ->
                    "Secretaria Nacional de Promoção e Defesa dos Direitos Humanos";
            case "SEC.NAC. DOS DIR. P/A CRIANCA E O ADOLESCENTE" ->
                    "Secretaria Nacional dos Direitos da Criança e do Adolescente";
            case "COORDENACAO-GERAL DE GESTAO DE PESSOAS - MDHC" -> "Coordenação-Geral de Gestão de Pessoas - MDHC";
            case "SECRETARIA NAC. DIR. PESSOAS LGBTQIA+" -> "Secretaria Nacional de Direitos das Pessoas LGBTQIA+";
            case "SEC.NAC. DOS DIREITOS DA PESS.COM DEFICIENCIA" ->
                    "Secretaria Nacional dos Direitos da Pessoa com Deficiência";
            case "SEC.NAC. DE PROM. E DEF.DOS DIR.DA PESS.IDOSA" ->
                    "Secretaria Nacional de Promoção e Defesa dos Direitos da Pessoa Idosa";
            case "ASSESSORIA ESPECIAL ASSUNTOS INTERNACIONAIS" -> "Assessoria Especial de Assuntos Internacionais";
            case "ASSESSORIA ESP. EDUCACAO CULTURA DIR. HUMANOS" ->
                    "Assessoria Especial de Educação, Cultura e Direitos Humanos";
            case "ASSESSORIA ESP.DEF.DEMOCRACIA,MEMORIA VERDADE" ->
                    "Assessoria Especial de Defesa da Democracia, Memória e Verdade";
            case "CAIXA/MMULHERES" -> "Caixa - MMulheres";
            case "CONSELHO NACIONAL DOS DIREITOS HUMANOS" -> "Conselho Nacional dos Direitos Humanos";
            case "OUVIDORIA NACIONAL DE DIREITOS HUMANOS" -> "Ouvidoria Nacional de Direitos Humanos";
            case "COMISSAO DE ANISTIA" -> "Comissão de Anistia";
            case "FUNDO NACIONAL PARA A CRIANCA E O ADOLESCENTE" -> "Fundo Nacional para a Criança e o Adolescente";
            case "MMULHERES" -> "Ministério da Mulher";
            case "FOLHA DE PAGAMENTO - MM" -> "Folha de Pagamento - MM";
            case "CENTRO DE SERVICOS COMPARTILHADOS - MM" -> "Centro de Serviços Compartilhados - MM";
            case "MIR - IGUALDADE RACIAL" -> "MIR - Igualdade Racial";
            case "DIVISAO DE GESTAO DE PESSOAS - MIR" -> "Divisão de Gestão de Pessoas - MIR";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 2A.REGIAO" -> "Tribunal Regional do Trabalho da 2ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 1A.REGIAO" -> "Tribunal Regional do Trabalho da 1ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 4A.REGIAO" -> "Tribunal Regional do Trabalho da 4ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 15A.REGIAO" -> "Tribunal Regional do Trabalho da 15ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 3A.REGIAO" -> "Tribunal Regional do Trabalho da 3ª Região";
            case "TRIBUNAL SUPERIOR DO TRABALHO" -> "Tribunal Superior do Trabalho";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 9A.REGIAO" -> "Tribunal Regional do Trabalho da 9ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 5A.REGIAO" -> "Tribunal Regional do Trabalho da 5ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 12A.REGIAO" -> "Tribunal Regional do Trabalho da 12ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 6A.REGIAO" -> "Tribunal Regional do Trabalho da 6ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 10A.REGIAO" -> "Tribunal Regional do Trabalho da 10ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 7A.REGIAO" -> "Tribunal Regional do Trabalho da 7ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 8A.REGIAO" -> "Tribunal Regional do Trabalho da 8ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 13A.REGIAO" -> "Tribunal Regional do Trabalho da 13ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 18A.REGIAO" -> "Tribunal Regional do Trabalho da 18ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 11A.REGIAO" -> "Tribunal Regional do Trabalho da 11ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 23A.REGIAO" -> "Tribunal Regional do Trabalho da 23ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 21A.REGIAO" -> "Tribunal Regional do Trabalho da 21ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 17A.REGIAO" -> "Tribunal Regional do Trabalho da 17ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 14A.REGIAO" -> "Tribunal Regional do Trabalho da 14ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 19A.REGIAO" -> "Tribunal Regional do Trabalho da 19ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 16A.REGIAO" -> "Tribunal Regional do Trabalho da 16ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 24A.REGIAO" -> "Tribunal Regional do Trabalho da 24ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 20A.REGIAO" -> "Tribunal Regional do Trabalho da 20ª Região";
            case "TRIBUNAL REGIONAL DO TRABALHO DA 22A.REGIAO" -> "Tribunal Regional do Trabalho da 22ª Região";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - SP" -> "Justiça Federal de Primeiro Grau - SP";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - RJ" -> "Justiça Federal de Primeiro Grau - RJ";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - RS" -> "Justiça Federal de Primeiro Grau - RS";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - MG" -> "Justiça Federal de Primeiro Grau - MG";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - PR" -> "Justiça Federal de Primeiro Grau - PR";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - SC" -> "Justiça Federal de Primeiro Grau - SC";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - BA" -> "Justiça Federal de Primeiro Grau - BA";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - PE" -> "Justiça Federal de Primeiro Grau - PE";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - DF" -> "Justiça Federal de Primeiro Grau - DF";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - CE" -> "Justiça Federal de Primeiro Grau - CE";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - GO" -> "Justiça Federal de Primeiro Grau - GO";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - ES" -> "Justiça Federal de Primeiro Grau - ES";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - PA" -> "Justiça Federal de Primeiro Grau - PA";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - PB" -> "Justiça Federal de Primeiro Grau - PB";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - MA" -> "Justiça Federal de Primeiro Grau - MA";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - MT" -> "Justiça Federal de Primeiro Grau - MT";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - RN" -> "Justiça Federal de Primeiro Grau - RN";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - MS" -> "Justiça Federal de Primeiro Grau - MS";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - AL" -> "Justiça Federal de Primeiro Grau - AL";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - PI" -> "Justiça Federal de Primeiro Grau - PI";
            case "SECRETARIA DO CONSELHO DA JUSTICA FEDERAL" -> "Secretaria do Conselho da Justiça Federal";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - RO" -> "Justiça Federal de Primeiro Grau - RO";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - SE" -> "Justiça Federal de Primeiro Grau - SE";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - AM" -> "Justiça Federal de Primeiro Grau - AM";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - TO" -> "Justiça Federal de Primeiro Grau - TO";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - AP" -> "Justiça Federal de Primeiro Grau - AP";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - AC" -> "Justiça Federal de Primeiro Grau - AC";
            case "JUSTICA FEDERAL DE PRIMEIRO GRAU - RR" -> "Justiça Federal de Primeiro Grau - RR";
            case "TRIBUNAL REGIONAL FEDERAL DA 3A.REGIAO" -> "Tribunal Regional Federal da 3ª Região";
            case "ESCOLA DE MAGISTRADOS DA JUSTICA FEDERAL-3ª R" ->
                    "Escola de Magistrados da Justiça Federal - 3ª Região";
            case "SECRETARIA DO T.R.F. DA 1A. REGIAO" -> "Secretaria do TRF da 1ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 2A. REGIAO" -> "Tribunal Regional Federal da 2ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 4A.REGIAO" -> "Tribunal Regional Federal da 4ª Região";
            case "ESCOLA DA MAGISTRATURA DO TRF - 4ª REGIAO" -> "Escola da Magistratura do TRF - 4ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 5A.REGIAO" -> "Tribunal Regional Federal da 5ª Região";
            case "TRIBUNAL REGIONAL FEDERAL DA 6A. REGIAO" -> "Tribunal Regional Federal da 6ª Região";
            case "FUNDO PARTIDÁRIO - TSE" -> "Fundo Partidário - TSE";
            case "TRIBUNAL REGIONAL ELEITORAL DE SAO PAULO" -> "Tribunal Regional Eleitoral de São Paulo";
            case "TRIBUNAL SUPERIOR ELEITORAL - TSE" -> "Tribunal Superior Eleitoral - TSE";
            case "TRIBUNAL REGIONAL ELEITORAL DE MINAS GERAIS" -> "Tribunal Regional Eleitoral de Minas Gerais";
            case "TRIBUNAL REGIONAL ELEITORAL DO RIO DE JANEIRO" -> "Tribunal Regional Eleitoral do Rio de Janeiro";
            case "TRIBUNAL REGIONAL ELEITORAL DA BAHIA" -> "Tribunal Regional Eleitoral da Bahia";
            case "TRIBUNAL REGIONAL ELEITORAL DO PARANA" -> "Tribunal Regional Eleitoral do Paraná";
            case "TRIBUNAL REGIONAL ELEITORAL DO RIO G.DO SUL" -> "Tribunal Regional Eleitoral do Rio Grande do Sul";
            case "TRIBUNAL REGIONAL ELEITORAL DO PARA" -> "Tribunal Regional Eleitoral do Pará";
            case "TRIBUNAL REGIONAL ELEITORAL DE PERNAMBUCO" -> "Tribunal Regional Eleitoral de Pernambuco";
            case "TRIBUNAL REGIONAL ELEITORAL DO CEARA" -> "Tribunal Regional Eleitoral do Ceará";
            case "TRIBUNAL REGIONAL ELEITORAL DO MARANHAO" -> "Tribunal Regional Eleitoral do Maranhão";
            case "TRIBUNAL REGIONAL ELEITORAL DE SANTA CATARINA" -> "Tribunal Regional Eleitoral de Santa Catarina";
            case "TRIBUNAL REGIONAL ELEITORAL DE GOIAS" -> "Tribunal Regional Eleitoral de Goiás";
            case "TRIBUNAL REGIONAL ELEITORAL DO PIAUI" -> "Tribunal Regional Eleitoral do Piauí";
            case "TRIBUNAL REGIONAL ELEITORAL DA PARAIBA" -> "Tribunal Regional Eleitoral da Paraíba";
            case "TRIBUNAL REGIONAL ELEITORAL DO RIO G.DO NORTE" ->
                    "Tribunal Regional Eleitoral do Rio Grande do Norte";
            case "TRIBUNAL REGIONAL ELEITORAL DO AMAZONAS" -> "Tribunal Regional Eleitoral do Amazonas";
            case "TRIBUNAL REGIONAL ELEITORAL DE MATO GROSSO" -> "Tribunal Regional Eleitoral de Mato Grosso";
            case "TRIBUNAL REGIONAL ELEITORAL DO ESPIRITO SANTO" -> "Tribunal Regional Eleitoral do Espírito Santo";
            case "TRIBUNAL REGIONAL ELEITORAL DE MATO G.DO SUL" -> "Tribunal Regional Eleitoral de Mato Grosso do Sul";
            case "TRIBUNAL REGIONAL ELEITORAL DO D. FEDERAL" -> "Tribunal Regional Eleitoral do Distrito Federal";
            case "TRIBUNAL REGIONAL ELEITORAL DE ALAGOAS" -> "Tribunal Regional Eleitoral de Alagoas";
            case "TRIBUNAL REGIONAL ELEITORAL DE TOCANTINS" -> "Tribunal Regional Eleitoral do Tocantins";
            case "TRIBUNAL REGIONAL ELEITORAL DE SERGIPE" -> "Tribunal Regional Eleitoral de Sergipe";
            case "TRIBUNAL REGIONAL ELEITORAL DE RONDONIA" -> "Tribunal Regional Eleitoral de Rondônia";
            case "TRIBUNAL REGIONAL ELEITORAL DE RORAIMA" -> "Tribunal Regional Eleitoral de Roraima";
            case "TRIBUNAL REGIONAL ELEITORAL DO ACRE" -> "Tribunal Regional Eleitoral do Acre";
            case "TRIBUNAL REGIONAL ELEITORAL DO AMAPA" -> "Tribunal Regional Eleitoral do Amapá";
            case "TRIB.DE JUSTICA DO D.F. E DOS  TERRITORIOS" ->
                    "Tribunal de Justiça do Distrito Federal e dos Territórios";
            case "VARA DE ACOES PREVIDENCIARIAS TJDFT" -> "Vara de Ações Previdenciárias - TJDFT";
            case "COORDENADORIA DE CONC.DE PRECATORIOS-TJDFT" -> "Coordenadoria de Concessão de Precatórios - TJDFT";
            case "TRIB.DE JUSTICA DO DF-CORREGEDORIA DA JUSTICA" ->
                    "Tribunal de Justiça do Distrito Federal - Corregedoria da Justiça";
            case "VARA DA INFANCIA E DA JUVENTUDE DO D.F." -> "Vara da Infância e da Juventude do Distrito Federal";
            case "SECRETARIA DO SUPERIOR TRIBUNAL DE JUSTICA" -> "Secretaria do Superior Tribunal de Justiça";
            case "ESCOLA NACIONAL DE FOR E APERF DE MAGISTRADOS" ->
                    "Escola Nacional de Formação e Aperfeiçoamento de Magistrados";
            case "CONSELHO NACIONAL DE JUSTICA" -> "Conselho Nacional de Justiça";
            case "SUPERIOR TRIBUNAL MILITAR" -> "Superior Tribunal Militar";
            case "DIRETORIA DO FORO DA 11A CJM" -> "Diretoria do Foro da 11ª CJM";
            case "DIRETORIA DO FORO - 1A CJM" -> "Diretoria do Foro da 1ª CJM";
            case "DIRETORIA DO FORO - 2A. CJM" -> "Diretoria do Foro da 2ª CJM";
            case "AUDITORIA DA 10A. CJM" -> "Auditoria da 10ª CJM";
            case "AUDITORIA DA 7A. CJM" -> "Auditoria da 7ª CJM";
            case "AUDITORIA DA 9A. CJM" -> "Auditoria da 9ª CJM";
            case "AUDITORIA DA 12A. CJM" -> "Auditoria da 12ª CJM";
            case "AUDITORIA DA 8A. CJM" -> "Auditoria da 8ª CJM";
            case "AUDITORIA DA 6A. CJM" -> "Auditoria da 6ª CJM";
            case "2A. AUDITORIA DA 3A. CJM" -> "2ª Auditoria da 3ª CJM";
            case "AUDITORIA DA 5A. CJM" -> "Auditoria da 5ª CJM";
            case "3A. AUDITORIA DA 3A. CJM" -> "3ª Auditoria da 3ª CJM";
            case "AUDITORIA DA 4A. CJM" -> "Auditoria da 4ª CJM";
            case "1A. AUDITORIA DA 3A. CJM" -> "1ª Auditoria da 3ª CJM";
            case "TRIBUNAL DE CONTAS DA UNIAO" -> "Tribunal de Contas da União";
            case "SECRETARIA ESPECIALIZADA EM COMPRAS PUBLICAS" -> "Secretaria Especializada em Compras Públicas";
            case "INSTITUTO SERZEDELLO CORREA - ISC/TCU" -> "Instituto Serzedello Corrêa - ISC/TCU";
            case "SEAE - SECRETARIA DE APOIO ESPECIALIZADO" -> "SEAE - Secretaria de Apoio Especializado";
            default -> unidadeGestora.getNameUnidadeGestora();
        };
        unidadeGestora.setNameUnidadeGestora(updatedName);
    }

    private void correctUnidadeGestoraNames4(UnidadeGestora unidadeGestora) {
        String updatedName = switch (unidadeGestora.getNameUnidadeGestora()) {
            case "]NST.FED.DE EDUC.,CIENC.E TEC.DA BAHIA" -> "Instituto Federal de Educação, Ciência e Tecnologia da Bahia";
            case "SUPERINTEND. DO DESENVOLVIMENTO DA AMAZONIA" -> "Superintendência do Desenvolvimento da Amazônia";
            case "SUPERINT.REG. ADM. DO MGI - RIO GRANDE SUL" -> "Superintendência Regional de Administração do Ministério da Gestão e da Inovação em Serviços Públicos - Rio Grande do Sul";
            case "MO - MG" -> "Minas Gerais";
            case "COGEP - MTUR" -> "Coordenação-Geral de Gestão de Pessoas - Ministério do Turismo";
            default -> unidadeGestora.getNameUnidadeGestora();
        };
        unidadeGestora.setNameUnidadeGestora(updatedName);
    }

    private void correctElementDespesaNames(ElementoDespesa elementoDespesa) {
        String updatedName = switch (elementoDespesa.getNameElementoDespesa()) {
            case "Outros Auxílios Financeiros a Pessoas Físic" -> "Auxílios Financeiros a Pessoa Física";
            case "Outros Serviços de Terceiros - Pessoa Juríd" -> "Outros Serviços de Terceiros - Pessoa Jurídica";
            case "Serviços de Tecnologia da Informação e Com" -> "Serviços de Tecnologia da Informação e Comunicação";
            case "Contribuição a Entidades Fechadas de Previd" -> "Contribuição a Entidades Fechadas de Previdência";
            case "Premiações Culturais. Artísticas. Científ" -> "Premiações Culturais, Artísticas e Científicas";
            case "Outros Serviços de Terceiros - Pessoa Físic" -> "Outros Serviços de Terceiros - Pessoa Física";
            case "Juros. Deságios e Descontos da Dívida Mobil", "Juros, Deságios e Descontos da Dívida Mobil" ->
                    "Juros, Deságios e Descontos da Dívida Mobiliária";
            case "Ressarcimento de Despesas de Pessoal Requisit" -> "Ressarcimento de Despesas de Pessoal Requisitado";
            case "Transferências por meio de Contrato de Gest" -> "Transferências por meio de Contrato de Gestão";
            case "Vencimentos e Vantagens Fixas - Pessoal Milit" -> "Vencimentos e Vantagens Fixas - Pessoal Militar";
            case "Obrigações decorrentes de Política Monetá" -> "Obrigações decorrentes de Política Monetária";
            case "Aposentadorias. Reserva Remunerada e Reformas" -> "Aposentadorias, Reserva Remunerada e Reformas";
            case "Participação em Fundos, Organismos, ou Enti" -> "Participação em Fundos, Organismos ou Entidades";
            case "-" -> "Sem Informação";
            case "RESSARCIMENTO DE DESP. DE PESSOAL REQUISITADO" -> "Ressarcimento de despesas de pessoal requisitado";
            case "CONTRIB. A ENTIDADES FECHADAS DE PREVIDENCIA" -> "Contribuição a entidades fechadas de previdência";
            case "OUTROS BENEF.ASSIST. DO SERVIDOR E DO MILITAR" ->
                    "Outros benefícios assistenciais do servidor e do militar";
            case "RESSARC. DE DESPESAS DE PESSOAL REQUISITADO" -> "Ressarcimento de despesas de pessoal requisitado";
            case "OBRIG.TRIBUT.E CONTRIB-OP.INTRA-ORCAMENTARIAS" ->
                    "Obrigações tributárias e contribuições - Operações intra-orçamentárias";
            case "MATERIAL, BEM OU SERVICO P/ DISTRIB. GRATUITA" ->
                    "Material, bem ou serviço para distribuição gratuita";
            case "PREMIACOES CULT., ART., CIENT., DESP. E OUTR." ->
                    "Premiações culturais, artísticas, científicas, desportivas e outras";
            case "ENC.P/ HONRA DE AVAIS, GARANT.,SEGUROS E SIM." ->
                    "Encargos para honra de avais, garantias, seguros e similares";
            case "OBRIGACOES PATRONAIS - OP.INTRA-ORCAMENTARIAS" ->
                    "Obrigações patronais - Operações intra-orçamentárias";
            case "SERV.MEDICO-HOSPITAL.,ODONTOL.E LABORATORIAIS" ->
                    "Serviços médico-hospitalares, odontológicos e laboratoriais";
            case "SERVICOS DE BRIGADA DE INCENDIO." -> "Serviços de brigada de incêndio";
            case "MANUTENCAO E CONSERV. DE BENS IMOVEIS" -> "Manutenção e conservação de bens imóveis";
            case "INDENIZACOES E RESTITUICOES TRAB. ATIVO CIVIL" ->
                    "Indenizações e restituições ao trabalhador ativo civil";
            case "MANUT. E CONSERV. DE MAQUINAS E EQUIPAMENTOS" ->
                    "Manutenção e conservação de máquinas e equipamentos";
            case "MATERIAL DE LIMPEZA E PROD. DE HIGIENIZACAO" -> "Material de limpeza e produtos de higienização";
            case "SERV. DE APOIO ADMIN., TECNICO E OPERACIONAL" ->
                    "Serviços de apoio administrativo, técnico e operacional";
            case "MATERIAL P/ MANUT.DE BENS IMOVEIS/ INSTALACOES" ->
                    "Material para manutenção de bens imóveis/instalações";
            case "APARELHOS E EQUIP. P/ ESPORTES E DIVERSOES" -> "Aparelhos e equipamentos para esportes e diversões";
            case "MANUT.E CONS.DE B.MOVEIS DE OUTRAS NATUREZAS" ->
                    "Manutenção e conservação de bens móveis de outras naturezas";
            case "RESSARCIMENTO DE PASSAGENS E DESP.C/ LOCOMOCAO" ->
                    "Ressarcimento de passagens e despesas com locomoção";
            case "OUTROS BENEF.ASSIST.DO SERVIDOR E DO MILITAR" ->
                    "Outros benefícios assistenciais do servidor e do militar";
            case "MANUTENCAO E CONSERV. DE MAQ. E APARELHOS" -> "Manutenção e conservação de máquinas e aparelhos";
            case "APAR.EQUIP.UTENS.MED.,ODONT,LABOR.HOSPIT." ->
                    "Aparelhos, equipamentos e utensílios médicos, odontológicos, laboratoriais e hospitalares";
            case "INST.DE CARATER ASSIST.CULT.E EDUCACIONAL" ->
                    "Instituições de caráter assistencial, cultural e educacional";
            case "COMBUSTIVEIS E LUBRIF. P/ OUTRAS FINALIDADES" ->
                    "Combustíveis e lubrificantes para outras finalidades";
            case "INSTIT. DE CARATER CULTURAL OU EDUCACIONAL" -> "Instituições de caráter cultural ou educacional";
            case "PENS.INDENIZ.ORIUND.DEB.PERIOD.VINC.SENT.JUD" ->
                    "Pensões e indenizações oriundas de débitos periódicos vinculados a sentença judicial";
            case "MANUTENCAO E CONSERV. DE VEICULOS" -> "Manutenção e conservação de veículos";
            case "OUTROS SERVICOS DE TERCEIROS PJ - OP.INT.ORC." ->
                    "Outros serviços de terceiros - Pessoa jurídica - Operações intra-orçamentárias";
            case "OUTROS SERVICOS DE TERCEIROS - P.FISICA" -> "Outros serviços de terceiros - Pessoa física";
            case "MATERIAL, BEM OU SERVICO PARA DIST.GRATUITA" -> "Material, bem ou serviço para distribuição gratuita";
            case "RESSARCIMENTO DE PASSAGENS E DESP.C/LOCOMOCAO" ->
                    "Ressarcimento de passagens e despesas com locomoção";
            case "APOIO ADMINISTRATIVO. TECNICO E OPERACIONAL" -> "Apoio administrativo, técnico e operacional";
            case "SERV. DE APOIO ADMIN. TECNICO E OPERACIONAL" ->
                    "Serviços de apoio administrativo, técnico e operacional";
            case "SERV DE APOIO ADMIN. TECNICO E OPERACIONAL" ->
                    "Serviços de apoio administrativo, técnico e operacional";
            case "SENT.JUD.NAO TRANS JULG CARAT CONT AT CIVIL" ->
                    "Sentença judicial não transitada em julgado - Caráter contencioso - Ativo civil";
            case "SENT.JUD.NAO TRANS JULG CARAT CONT INAT CIVIL" ->
                    "Sentença judicial não transitada em julgado - Caráter contencioso - Inativo civil";
            case "MATERIAL P/ MANUT.DE BENS IMOVEIS/INSTALACOES" ->
                    "Material para manutenção de bens imóveis/instalações";
            case "OUTROS SERV.DE TERCEIROS PJ- PAGTO ANTECIPADO" ->
                    "Outros serviços de terceiros - Pessoa jurídica - Pagamento antecipado";
            case "CONTRIB.PREVIDENCIARIAS-SERVICOS DE TERCEIROS" ->
                    "Contribuições previdenciárias - Serviços de terceiros";
            case "Obrigações patronais – op. intra-orçamentárias" ->
                    "Obrigações patronais - Operações intra-orçamentárias";
            case "Aposent. RPPS, reser. remuner. e refor.militar" ->
                    "Aposentadorias RPPS, reserva remunerada e reforma militar";
            case "Outros (Gratif Exerc. Cumulativo Ofício)" -> "Outros (Gratificações Exercício Cumulativo de Ofício)";
            case "Outros serv.terceiros-pes.jurid-op.intra-orç." ->
                    "Outros serviços de terceiros - Pessoa jurídica - Operações intra-orçamentárias";
            case "Obrig.tribut.e contrib-op. Intra-orçamentárias" ->
                    "Obrigações tributárias e contribuições - Operações intra-orçamentárias";
            case "Ressarcimento de pass. e desp. c/ locomoção" -> "Ressarcimento de passagens e despesas com locomoção";
            case "Ressarcimento de desp. de pessoal requisitado" -> "Ressarcimento de despesa de pessoal requisitado";
            case "CONTRIBUICAO DA UNIAO. DE SUAS AUTARQUIAS E FUNDACOES PARA O CUSTEIO DO REGIME DE PREVIDENCIA DOS SERVIDORES PUBLICOS FEDERAIS" ->
                    "Contribuição da União, autarquias e fundações para o custeio da previdência dos servidores federais";
            case "RECURSOS PARA ATENDIMENTO DO ART. 169. ? 1.. INCISO II DA CONSTITUICAO FEDERAL. ANEXO V DA LOA - CONCURSOS E PROVIMENTOS - PRIMARIA" ->
                    "Recursos para art. 169, §1º, II da CF/88 - Concursos e provimentos - Primária";
            case "CPSS DECORRENTE DO ATENDIMENTO DO ART. 169. ? 1.. INCISO II DA CONSTITUICAO FEDERAL - CONCURSOS E PROVIMENTOS - FINANCEIRA" ->
                    "CPSS - Art. 169, §1º, II da CF/88 - Concursos e provimentos - Financeira";
            case "APOSENT ORIGINARIA DE SUBSIDIOS - PESSOAL CIV" ->
                    "Aposentadoria originária de subsídios - Pessoal civil";
            case "OUTROS BENEFÍCIOS ASSISTENCIAIS DO SERVIDOR E DO MILITAR" ->
                    "Outros Benefícios Assistenciais do Servidor e do Militar";
            case "SERVIÇOS DE TECNOLOGIA DA INFORMAÇÃO E COMUNICAÇÃO - PJ" ->
                    "Serviços de Tecnologia da Informação e Comunicação - Pessoa Jurídica";
            case "DIARIAS - PESSOAL CIVIL" -> "Diárias - Pessoal Civil";
            case "OUTROS SERVICOS DE TERCEIROS- PESSOA JURIDICA" -> "Outros Serviços de Terceiros - Pessoa Jurídica";
            case "MATERIAL, BEM OU SERVIÇO PARA DISTRIBUIÇÃO GRATUITA" ->
                    "Material, Bem ou Serviço para Distribuição Gratuita";
            case "OUTROS AUXILIOS FINANCEIROS A PESSOA FISICA" -> "Outros Auxílios Financeiros a Pessoa Física";
            case "PREMIACÕES CULTURAIS, ARTÍSTICAS, CIENTÍFICAS, DESPORTIVAS E OUTRAS" ->
                    "Premiações Culturais, Artísticas, Científicas, Desportivas e Outras";
            case "OUTROS SERVICOS DE TERCEIROS-PESSOA JURIDICA" -> "Outros Serviços de Terceiros - Pessoa Jurídica";
            case "OUTROS SERVIÇOS DE TERCEIROS - PESSOA JURÍDICA (INTRA)" ->
                    "Outros Serviços de Terceiros - Pessoa Jurídica (Intra)";
            case "OBRIGAÇÕES TRIBUTÁRIAS E CONTRIBUIÇÕES - OPERAÇÕES INTRA-ORÇAMENTÁRIAS" ->
                    "Obrigações Tributárias e Contribuições - Operações Intra-Orçamentárias";
            case "DIARIAS - PESSOAL MILITAR" -> "Diárias - Pessoal Militar";
            case "ENCARGOS PARA HONRA DE AVAIS, GARANTIAS, SEGUROS E SIMILARES" ->
                    "Encargos para Honra de AvaIs, Garantias, Seguros e Similares";
            case "CONTRIBUICAO A ENTIDADE FECHADA PREVIDENCIA" -> "Contribuição a Entidade Fechada de Previdência";
            case "PREMIACOES CULTURAIS, ARTISTICAS, CIENTIFICAS" -> "Premiações Culturais, Artísticas, Científicas";
            case "GRATIFICACAO POR EXERCICIO CUMULATIVO DE OFICIOS OU JURISDICAO" ->
                    "Gratificação por Exercício Cumulativo de Ofícios ou Jurisdição";
            case "SERVICOS EXTRAORDINARIOS" -> "Serviços Extraordinários";
            case "OUTROS AUXILIOS FINANCEIROS A PESSOAS FISICAS" -> "Outros Auxílios Financeiros a Pessoas Físicas";
            case "AUXÍLIO-MORADIA" -> "Auxílio-Moradia";
            case "SUBSIDIOS" -> "Subsídios";
            case "CONTRIBUICAO PATRONAL PARA O RPPS" -> "Contribuição Patronal para o RPPS";
            case "LOCACAO DE IMOVEIS" -> "Locação de Imóveis";
            case "APOIO ADMINISTRATIVO TECNICO E OPERACIONAL" -> "Apoio Administrativo, Técnico e Operacional";
            case "13º SALARIO" -> "13º Salário";
            case "AUXILIO-ALIMENTACAO CIVIS" -> "Auxílio-Alimentação - Civis";
            case "ESTAGIARIOS" -> "Estagiários";
            case "APOIO ADMINISTRATIVO, TECNICO E OPERACIONAL" -> "Apoio Administrativo, Técnico e Operacional";
            case "GRATIFICACAO POR EXERCICIO DE CARGO EFETIVO" -> "Gratificação por Exercício de Cargo Efetivo";
            case "APOSENTADORIAS RESERVA REMUNERADA E REFORMAS" -> "Aposentadorias, Reserva Remunerada e Reformas";
            case "VENCIMENTOS E SALARIOS" -> "Vencimentos e Salários";
            case "GRATIFICACOES ESPECIAIS" -> "Gratificações Especiais";
            case "FERIAS - 1/3 CONSTITUCIONAL" -> "Férias - 1/3 Constitucional";
            case "GRATIFICACAO P/EXERCICIO DE CARGO EM COMISSAO" -> "Gratificação por Exercício de Cargo em Comissão";
            case "APOSENTADORIA ORIGINARIA DE SUBSIDIOS - PESSOAL CIVIL" ->
                    "Aposentadoria Originária de Subsídios - Pessoal Civil";
            case "CONTRIBUICAO PATRONAL - FUNPRESP LEI 12618/12" -> "Contribuição Patronal - FUNPRESP Lei 12.618/12";
            case "PENSOES CIVIS" -> "Pensões Civis";
            case "VIGILANCIA OSTENSIVA" -> "Vigilância Ostensiva";
            case "CONDOMINIOS" -> "Condomínios";
            case "SUPORTE A USUARIOS DE TIC" -> "Suporte a Usuários de TIC";
            case "AUXILIO-CRECHE CIVIL" -> "Auxílio-Creche - Civil";
            case "LIMPEZA E CONSERVACAO" -> "Limpeza e Conservação";
            case "DIARIAS NO PAIS" -> "Diárias no País";
            case "SERVICOS DE ENERGIA ELETRICA" -> "Serviços de Energia Elétrica";
            case "TRANSPORTE DE SERVIDORES" -> "Transporte de Servidores";
            case "TRIBUTOS A CONTA DO LOCATARIO OU CESSIONARIO" -> "Tributos a Conta do Locatário ou Cessionário";
            case "GRATIFICACAO POR EXRCICIO CUMULATIVO DE OFICIOS OU  JU-RISDICAO" ->
                    "Gratificação por Exercício Cumulativo de Ofícios ou Jurisdição";
            case "AUXILIO-TRANSPORTE ESTAGIARIOS" -> "Auxílio-Transporte - Estagiários";
            case "PASSAGENS PARA O PAIS" -> "Passagens para o País";
            case "MANUTENCAO CORRETIVA/ADAPTATIVA E SUSTENTACAO SOFTWARES" ->
                    "Manutenção Corretiva/Adaptativa e Sustentação de Softwares";
            case "PNUD - PROGRAMA DAS NACOES UNIDAS P/ O DESENV" ->
                    "PNUD - Programa das Nações Unidas para o Desenvolvimento";
            case "PESSOAL REQUISITADO DE OUTROS ORGAOS DA APF" -> "Pessoal Requisitado de Outros Órgãos da APF";
            case "SERVICOS TECNICOS PROFISSIONAIS DE TIC" -> "Serviços Técnicos Profissionais de TIC";
            case "PROVENTOS - PESSOAL CIVIL" -> "Proventos - Pessoal Civil";
            case "SERVIÇOS DE APOIO ADMINISTRATIVO, TÉCNICO E OPERACIONAL" ->
                    "Serviços de Apoio Administrativo, Técnico e Operacional";
            case "TELEFONIA FIXA E MOVEL - PACOTE DE COMUNICACAO DE DADOS" ->
                    "Telefonia Fixa e Móvel - Pacote de Comunicação de Dados";
            case "13 SALARIO - PESSOAL CIVIL" -> "13 Salário - Pessoal Civil";
            case "FERIAS VENCIDAS E PROPORCIONAIS" -> "Férias Vencidas e Proporcionais";
            case "DESENVOLVIMENTO DE SOFTWARE" -> "Desenvolvimento de Software";
            case "INSTALACAO DE EQUIPAMENTOS DE TIC" -> "Instalação de Equipamentos de TIC";
            case "MANUTENÇÃO E CONSERVAÇÃO DE MÁQUINAS E EQUIPAMENTOS" ->
                    "Manutenção e Conservação de Máquinas e Equipamentos";
            case "SERVICOS TECNICOS PROFISSIONAIS" -> "Serviços Técnicos Profissionais";
            case "SUPORTE DE INFRAESTRUTURA DE TIC" -> "Suporte de Infraestrutura de TIC";
            case "13 SALARIO - PENSOES CIVIS" -> "13 Salário - Pensões Civis";
            case "MAQUINAS E EQUIPAMENTOS ENERGETICOS" -> "Máquinas e Equipamentos Energéticos";
            case "OUTSOURCING DE IMPRESSAO" -> "Outsourcing de Impressão";
            case "AQUISICAO DE SOFTWARE PRONTO" -> "Aquisição de Software Pronto";
            case "LOCACAO DE SOFTWARES" -> "Locação de Softwares";
            case "SERVICOS DE COMUNICACAO EM GERAL" -> "Serviços de Comunicação em Geral";
            case "COMPLEMENTACAO DE PENSOES - PESSOAL CIVIL" -> "Complementação de Pensões - Pessoal Civil";
            case "AUXILIO-TRANSPORTE CIVIS" -> "Auxílio-Transporte Civis";
            case "SERVICOS DE AGUA E ESGOTO" -> "Serviços de Água e Esgoto";
            case "COMPUTACAO EM NUVEM - PLATAFORMA COMO SERVICO (PAAS)" ->
                    "Computação em Nuvem - Plataforma como Serviço (PaaS)";
            case "DIARIAS NO EXTERIOR" -> "Diárias no Exterior";
            case "CONTRIBUICAO P/ CUSTEIO DE ILUMINACAO PUBLICA" -> "Contribuição para Custeio de Iluminação Pública";
            case "MATERIAL DE PROTECAO E SEGURANCA" -> "Material de Proteção e Segurança";
            case "ABONO DE PERMANENCIA" -> "Abono de Permanência";
            case "FRETES E TRANSPORTES DE ENCOMENDAS" -> "Fretes e Transportes de Encomendas";
            case "RESSARCIMENTO DE PASSAGENS E DESPC/LOCOMOCAO" -> "Ressarcimento de Passagens e Despesas/Locomoção";
            case "FERIAS - PAGAMENTO ANTECIPADO" -> "Férias - Pagamento Antecipado";
            case "CONTRIBUICOES PREVIDENCIARIAS - INSS" -> "Contribuições Previdenciárias - INSS";
            case "MANUTENÇÃO E CONSERVAÇÃO DE BENS IMÓVEIS" -> "Manutenção e Conservação de Bens Imóveis";
            case "PASSAGENS PARA O EXTERIOR" -> "Passagens para o Exterior";
            case "MANUT E CONSERV DE MAQUINAS E EQUIPAMENTOS" -> "Manutenção e Conservação de Máquinas e Equipamentos";
            case "ADICIONAL DE INSALUBRIDADE" -> "Adicional de Insalubridade";
            case "COMPUTACAO EM NUVEM - INFRAESTRUTURA COMO SERVICO(IAAS)" ->
                    "Computação em Nuvem - Infraestrutura como Serviço (IaaS)";
            case "MOBILIARIO EM GERAL" -> "Mobiliário em Geral";
            case "SERVICO DE SELECAO E TREINAMENTO" -> "Serviço de Seleção e Treinamento";
            case "RESSARCIMENTO CUSTOS-UTILIZACAO DEPENDENCIAS" ->
                    "Ressarcimento de Custos - Utilização de Dependências";
            case "PREMIACOES CULTURAIS ARTISTICAS CIENTIFICAS" -> "Premiações Culturais, Artísticas e Científicas";
            case "ADICIONAL POR TEMPO DE SERVICO PESSOAL CIVIL" -> "Adicional por Tempo de Serviço - Pessoal Civil";
            case "OUTROS SERVIÇOS DE TERCEIROS - PJ" -> "Outros Serviços de Terceiros - PJ";
            case "SENTENÇA JUDICIAL NÃO TRANSITADA EM JULGADO - CARÁTER CONTENCIOSO - ATIVO CIVIL" ->
                    "Sentença Judicial Não Transitada em Julgado - Caráter Contencioso - Ativo Civil";
            case "APARELHOS E UTENSILIOS DOMESTICOS" -> "Aparelhos e Utensílios Domésticos";
            case "SERVICOS DE OUTSOURCING - ALMOX VIRTUAL (IN 51/2021)" ->
                    "Serviços de Outsourcing - Almox Virtual (IN 51/2021)";
            case "COMPUTACAO EM NUVEM - SOFTWARE COMO SERVICO (SAAS)" ->
                    "Computação em Nuvem - Software como Serviço (SaaS)";
            case "MATERIAL DE COPA E COZINHA" -> "Material de Copa e Cozinha";
            case "COMUNICACAO DE DADOS E REDES EM GERAL" -> "Comunicação de Dados e Redes em Geral";
            case "ASSINATURAS DE PERIODICOS E ANUIDADES" -> "Assinaturas de Periódicos e Anuidades";
            case "MANUTENCAO E CONSERV DE BENS IMOVEIS" -> "Manutenção e Conservação de Bens Imóveis";
            case "JUROS E MULTA DE MORA" -> "Juros e Multa de Mora";
            case "SENTENÇA JUDICIAL NÃO TRANSITADA EM JULGADO - CARÁTER CONTENCIOSO - INATIVO CIVIL" ->
                    "Sentença Judicial Não Transitada em Julgado - Caráter Contencioso - Inativo Civil";
            case "EMISSAO DE CERTIFICADOS DIGITAIS" -> "Emissão de Certificados Digitais";
            case "PESSOAL REQUISITADO DE OUTROS ENTES" -> "Pessoal Requisitado de Outros Entes";
            case "GRATIFICACAO DE TEMPO DE SERVICO" -> "Gratificação de Tempo de Serviço";
            case "MATERIAL DE SINALIZACAO VISUAL E OUTROS" -> "Material de Sinalização Visual e Outros";
            case "AUXILIO NATALIDADE ATIVO CIVIL" -> "Auxílio Natalidade Ativo Civil";
            case "PRODUCOES JORNALISTICAS" -> "Produções Jornalísticas";
            case "MATERIAL PARA MANUTENÇÃO DE BENS IMÓVEIS/INSTALAÇÕES" ->
                    "Material para Manutenção de Bens Imóveis/Instalações";
            case "SENTJUDNAO TRANS JULG CARAT CONT AT CIVIL" ->
                    "Sentença Judicial Não Transitada em Julgado - Caráter Contencioso - Ativo Civil";
            case "FESTIVIDADES E HOMENAGENS" -> "Festividades e Homenagens";
            case "MATERIAL DE CONSUMO - PAGTO ANTECIPADO" -> "Material de Consumo - Pagamento Antecipado";
            case "EQUIPAMENTOS DE TIC - IMPRESSORAS" -> "Equipamentos de TIC - Impressoras";
            case "SEGUROS EM GERAL" -> "Seguros em Geral";
            case "SERVICOS GRAFICOS E EDITORIAIS" -> "Serviços Gráficos e Editoriais";
            case "MATERIAL DE EXPEDIENTE" -> "Material de Expediente";
            case "EXPOSICOES, CONGRESSOS E CONFERENCIAS" -> "Exposições, Congressos e Conferências";
            case "TAXAS" -> "Taxas";
            case "OUTSOURCING - ALMOX VIRTUAL" -> "Outsourcing - Almox Virtual";
            case "FERIAS VENCIDAS E PROPOR A APOSENTADOS CIVIS" ->
                    "Férias Vencidas e Proporcionais a Aposentados Civis";
            case "GENEROS DE ALIMENTACAO" -> "Gêneros de Alimentação";
            case "OUTROS SERVDE TERCEIROS PJ- PAGTO ANTECIPADO" ->
                    "Outros Serviços de Terceiros PJ - Pagamento Antecipado";
            case "SENTJUDNAO TRANS JULG CARAT CONT INAT CIVIL" ->
                    "Sentença Judicial Não Transitada em Julgado - Caráter Contencioso - Inativo Civil";
            case "GAS E OUTROS MATERIAIS ENGARRAFADOS" -> "Gás e Outros Materiais Engarrafados";
            case "OUTROS SERVIÇOS DE TERCEIROS - PESSOA JURÍDICA - PAGAMENTO ANTECIPADO" ->
                    "Outros Serviços de Terceiros - Pessoa Jurídica - Pagamento Antecipado";
            case "INCORPORACOES" -> "Incorporações";
            case "MATERIAL DE TIC - MATERIAL DE CONSUMO" -> "Material de TIC - Material de Consumo";
            case "FERIAS - ABONO PECUNIARIO" -> "Férias - Abono Pecuniário";
            case "TAXA DE ADMINISTRACAO" -> "Taxa de Administração";
            case "CONTRIBUIÇÕES PREVIDENCIÁRIAS - SERVIÇOS DE TERCEIROS" ->
                    "Contribuições Previdenciárias - Serviços de Terceiros";
            case "GRATIFICACAO/ADICIONAL DE LOCALIZACAO" -> "Gratificação/Adicional de Localização";
            case "CORRECAO MONETARIA" -> "Correção Monetária";
            case "CONTRIBPREVIDENCIARIAS-SERVICOS DE TERCEIROS" ->
                    "Contribuições Previdenciárias - Serviços de Terceiros";
            case "VANTAGENS INCORPORADAS - PESSOAL CIVIL" -> "Vantagens Incorporadas - Pessoal Civil";
            case "SERVIÇOS MÉDICO-HOSPITALARES, ODONTOLÓGICOS E LABORATORIAIS" ->
                    "Serviços Médico-Hospitalares, Odontológicos e Laboratoriais";
            case "REMUNERACAO NO PERIODO DE FERIAS" -> "Remuneração no Período de Férias";
            case "BENEFICIO ESPECIAL (LEI 12.618/2012) APROVADOS PELO TCU" ->
                    "Benefício Especial (Lei 12.618/2012) Aprovados pelo TCU";
            case "GRAT POR EXERCICIO DE FUNCOES COMISSIONADAS" -> "Gratificação por Exercício de Funções Comissionadas";
            case "INCENTIVO A QUALIFICACAO" -> "Incentivo à Qualificação";
            case "CONTRIBUICAO PATRONAL - FUNPRESP LEI" -> "Contribuição Patronal - FUNPRESP Lei";
            case "PROV ORIUNDOS ADICIONAL QUALIF - PES CIVIL" ->
                    "Proventos Oriundos de Adicional de Qualificação - Pessoal Civil";
            case "RESSARCIMENTO DE VERBA INDENIZATORIA" -> "Ressarcimento de Verba Indenizatória";
            case "VANTAGENS INCORPORADAS - PENSIONISTAS" -> "Vantagens Incorporadas - Pensionistas";
            case "RESSARCIMENTO ASSISTENCIA MEDICA/ ODONTOLOGICA" -> "Ressarcimento de Assistência Médica/Odontológica";
            case "LICENCA CAPACITACAO" -> "Licença Capacitação";
            case "SERVICOS DE AUDIO, VIDEO E FOTO" -> "Serviços de Áudio, Vídeo e Foto";
            case "SERVIÇOS DE BRIGADA DE INCÊNDIO" -> "Serviços de Brigada de Incêndio";
            case "MATERIAL P/ UTILIZACAO EM GRAFICA" -> "Material para Utilização em Gráfica";
            case "LOCACAO DE MEIOS DE TRANSPORTE" -> "Locação de Meios de Transporte";
            case "EQUIPAMENTOS DE TIC - COMPUTADORES" -> "Equipamentos de TIC - Computadores";
            case "INDENIZAÇÕES E RESTITUIÇÕES AO TRABALHADOR ATIVO CIVIL" ->
                    "Indenizações e Restituições ao Trabalhador Ativo Civil";
            case "SERVICOS DE APOIO AO ENSINO" -> "Serviços de Apoio ao Ensino";
            case "EQUIPAMENTOS DE TIC - SERVIDORES/ STORAGE" -> "Equipamentos de TIC - Servidores/Storage";
            case "INSTALACOES" -> "Instalações";
            case "MAQUINAS E EQUIPAMENTOS GRAFICOS" -> "Máquinas e Equipamentos Gráficos";
            case "APARELHOS E EQUIPAMENTOS DE COMUNICACAO" -> "Aparelhos e Equipamentos de Comunicação";
            case "AUXILIO-FUNERAL INATIVO CIVIL" -> "Auxílio-Funeral Inativo Civil";
            case "DIREITOS AUTORAIS" -> "Direitos Autorais";
            case "VANTAGEM PECUNIARIA INDIVIDUAL" -> "Vantagem Pecuniária Individual";
            case "EQUIPAMENTOS PARA AUDIO, VIDEO E FOTO" -> "Equipamentos para Áudio, Vídeo e Foto";
            case "LOCACAO DE EQUIPAMENTOS DE TIC - SERVIDORES/STORAGE" ->
                    "Locação de Equipamentos de TIC - Servidores/Storage";
            case "MATERIAL DE LIMPEZA E PRODUTOS DE HIGIENIZAÇÃO" -> "Material de Limpeza e Produtos de Higienização";
            case "APOIO ADMINISTRATIVO - MENORES- APRENDIZES" -> "Apoio Administrativo - Menores - Aprendizes";
            case "PENSOES DO RPPS E DO MILITAR" -> "Pensões do RPPS e do Militar";
            case "EQUIPAMENTOS DE TIC - TELEFONIA" -> "Equipamentos de TIC - Telefonia";
            case "ADICIONAL NOTURNO" -> "Adicional Noturno";
            case "ADICIONAL DE PERICULOSIDADE" -> "Adicional de Periculosidade";
            case "SERVICOS DE TELECOMUNICACOES" -> "Serviços de Telecomunicações";
            case "ESTUDOS E PROJETOS" -> "Estudos e Projetos";
            case "MANUTENCAO E CONSERVACAO DE BENS MOVEIS" -> "Manutenção e Conservação de Bens Móveis";
            case "EXPLOSIVOS E MUNICOES" -> "Explosivos e Munições";
            case "ENTIDADES DE INTERCAMBIO LEGISLATIVO" -> "Entidades de Intercâmbio Legislativo";
            case "MANUTENCAO E CONSERVACAO DE EQUIPAMENTOS DE TIC" -> "Manutenção e Conservação de Equipamentos de TIC";
            case "GRATIFICACAO POR ENCARGO DE CURSO E CONCURSO - GECC" ->
                    "Gratificação por Encargo de Curso e Concurso - GECC";
            case "MATERIAL ELETRICO E ELETRONICO" -> "Material Elétrico e Eletrônico";
            case "MANUTENCAO EVOLUTIVA DE SOFTWARE" -> "Manutenção Evolutiva de Software";
            case "MATERIAL P/ MANUTENCAO DE BENS MOVEIS" -> "Material para Manutenção de Bens Móveis";
            case "PENSOES ORIUNDAS DE ADIC DE QUALIFIC - CIVIS" ->
                    "Pensões Oriundas de Adicional de Qualificação - Civis";
            case "DIARIAS A COLABORADORES EVENTUAIS NO PAIS" -> "Diárias a Colaboradores Eventuais no País";
            case "APARELHOS E EQUIPAMENTOS PARA ESPORTES E DIVERSÕES" ->
                    "Aparelhos e Equipamentos para Esportes e Diversões";
            case "ARMAMENTOS" -> "Armamentos";
            case "MANUTENÇÃO E CONSERVAÇÃO DE BENS MÓVEIS DE OUTRAS NATUREZAS" ->
                    "Manutenção e Conservação de Bens Móveis de Outras Naturezas";
            case "LOCACAO DE MAQUINAS E EQUIPAMENTOS" -> "Locação de Máquinas e Equipamentos";
            case "ORDENS HONORIFICAS" -> "Ordens Honoríficas";
            case "TREINAMENTO/CAPACITACAO EM TIC" -> "Treinamento/Capacitação em TIC";
            case "EQUIPAMENTO DE PROTECAO, SEGURANCA E SOCORRO" -> "Equipamento de Proteção, Segurança e Socorro";
            case "PECAS NAO INCORPORAVEIS A IMOVEIS" -> "Peças Não Incorporáveis a Imóveis";
            case "MATERIAL P/ AUDIO, VIDEO E FOTO" -> "Material para Áudio, Vídeo e Foto";
            case "MATERIAL DE TIC (PERMANENTE)" -> "Material de TIC (Permanente)";
            case "SERVICOS DE COPIAS E REPRODUCAO DE DOCUMENTOS" -> "Serviços de Cópias e Reprodução de Documentos";
            case "COMBUSTIVEIS E LUBRIFICANTES AUTOMOTIVOS" -> "Combustíveis e Lubrificantes Automotivos";
            case "PENSOES ESPECIAIS - PESSOAL CIVIL" -> "Pensões Especiais - Pessoal Civil";
            case "PREMIACOES CULTURAIS" -> "Premiações Culturais";
            case "MATERIAL BIBLIOGRAFICO" -> "Material Bibliográfico";
            case "HOSPEDAGENS" -> "Hospedagens";
            case "BENEFICIO ESPECIAL LEI 12.618/2012 - PENSAO" -> "Benefício Especial Lei 12.618/2012 - Pensão";
            case "SERVICOS DE PUBLICIDADE LEGAL" -> "Serviços de Publicidade Legal";
            case "UNIFORMES, TECIDOS E AVIAMENTOS" -> "Uniformes, Tecidos e Aviamentos";
            case "MATERIAL DE ACONDICIONAMENTO E EMBALAGEM" -> "Material de Acondicionamento e Embalagem";
            case "SEMENTES, MUDAS DE PLANTAS E INSUMOS" -> "Sementes, Mudas de Plantas e Insumos";
            case "FORNECIMENTO DE ALIMENTACAO" -> "Fornecimento de Alimentação";
            case "MANUTENÇÃO E CONSERVAÇÃO DE MÁQUINAS E APARELHOS" ->
                    "Manutenção e Conservação de Máquinas e Aparelhos";
            case "AUXILIO-MORADIA (ACORDAO TCU 1690/2002)" -> "Auxílio-Moradia (Acórdão TCU 1690/2002)";
            case "MATERIAL FARMACOLOGICO" -> "Material Farmacológico";
            case "ALIMENTOS PARA ANIMAIS" -> "Alimentos para Animais";
            case "SERVICOS DE ANALISES E PESQUISAS CIENTIFICAS" -> "Serviços de Análises e Pesquisas Científicas";
            case "APARELHOS, EQUIPAMENTOS E UTENSÍLIOS MÉDICOS, ODONTOLÓGICOS, LABORATORIAIS E HOSPITALARES" ->
                    "Aparelhos, Equipamentos e Utensílios Médicos, Odontológicos, Laboratoriais e Hospitalares";
            case "OUTROS MATERIAIS DE CONSUMO" -> "Outros Materiais de Consumo";
            case "INSTITUIÇÕES DE CARÁTER ASSISTENCIAL, CULTURAL E EDUCACIONAL" ->
                    "Instituições de Caráter Assistencial, Cultural e Educacional";
            case "MATERIAL P/ FESTIVIDADES E HOMENAGENS" -> "Material para Festividades e Homenagens";
            case "CONTRIBUICAO PREVIDENCIARIA - SERVICOS TERCEIROS (PF)" ->
                    "Contribuição Previdenciária - Serviços Terceiros (PF)";
            case "MAQUINAS, UTENSILIOS E EQUIPAMENTOS DIVERSOS" -> "Máquinas, Utensílios e Equipamentos Diversos";
            case "VANTAGEM PESSOAL - LEI 8.216/91 PESSOAL CIVIL" -> "Vantagem Pessoal - Lei 8.216/91 Pessoal Civil";
            case "FERRAMENTAS" -> "Ferramentas";
            case "SERVICOS BANCARIOS" -> "Serviços Bancários";
            case "CONTRIBUICAO  FOMENTO DA RADIODIFUSAO PUBLICA" -> "Contribuição para Fomento da Radiodifusão Pública";
            case "SERVICOS DOMESTICOS" -> "Serviços Domésticos";
            case "OUTRAS DESPESAS DE PESSOAL - TERCEIRIZACAO" -> "Outras Despesas de Pessoal - Terceirização";
            case "MATERIAL HOSPITALAR" -> "Material Hospitalar";
            case "MATERIAL PARA DIVULGACAO" -> "Material para Divulgação";
            case "PESSOAL REQUISITADO DE OUTROS ENTES/ BENEFICIO" -> "Pessoal Requisitado de Outros Entes/Benefício";
            case "MATERIAL LABORATORIAL" -> "Material Laboratorial";
            case "MATERIAL DE COUDELARIA OU DE USO ZOOTECNICO" -> "Material de Coudelaria ou de Uso Zootécnico";
            case "MATERIAL EDUCATIVO E ESPORTIVO" -> "Material Educativo e Esportivo";
            case "COMBUSTÍVEIS E LUBRIFICANTES PARA OUTRAS FINALIDADES" ->
                    "Combustíveis e Lubrificantes para Outras Finalidades";
            case "MATERIAL DE CAMA, MESA E BANHO" -> "Material de Cama, Mesa e Banho";
            case "INSTITUIÇÕES DE CARÁTER CULTURAL OU EDUCACIONAL" -> "Instituições de Caráter Cultural ou Educacional";
            case "SERVICOS DE ESTACIONAMENTO DE VEICULOS" -> "Serviços de Estacionamento de Veículos";
            case "MATERIAL P/ MANUTENCAO DE VEICULOS" -> "Material para Manutenção de Veículos";
            case "VEICULOS DIVERSOS" -> "Veículos Diversos";
            case "SERVICOS FUNERARIOS" -> "Serviços Funerários";
            case "PENSÕES E INDENIZAÇÕES ORIUNDAS DE DÉBITOS PERIÓDICOS VINCULADOS A SENTENÇA JUDICIAL" ->
                    "Pensões e Indenizações Oriundas de Débitos Periódicos Vinculados a Sentença Judicial";
            case "PEDAGIOS" -> "Pedágios";
            case "MATERIAL TECNICO P/ SELECAO E TREINAMENTO" -> "Material Técnico para Seleção e Treinamento";
            case "MANUTENÇÃO E CONSERVAÇÃO DE VEÍCULOS" -> "Manutenção e Conservação de Veículos";
            case "MATERIAL PARA COMUNICACOES" -> "Material para Comunicações";
            case "SENTENCAS JUDICIAIS" -> "Sentenças Judiciais";
            case "DESPESAS DE EXERCICIOS ANTERIORES" -> "Despesas de Exercícios Anteriores";
            case "VENCIMENTOS E VANTAGENS FIXAS - PESSOAL CIVIL" -> "Vencimentos e Vantagens Fixas - Pessoal Civil";
            case "APOSENTADORIAS, RESERVA REMUNERADA E REFORMAS" -> "Aposentadorias, Reserva Remunerada e Reformas";
            case "OUTROS SERVICOS DE TERCEIROS - PESSOA JURIDICA" -> "Outros Serviços de Terceiros - Pessoa Jurídica";
            case "AUXILIO-ALIMENTACAO" -> "Auxílio-Alimentação";
            case "LOCACAO DE MAO-DE-OBRA" -> "Locação de Mão-de-Obra";
            case "OUTRAS DESPESAS VARIAVEIS - PESSOAL CIVIL" -> "Outras Despesas Variáveis - Pessoal Civil";
            case "PENSOES" -> "Pensões";
            case "EQUIPAMENTOS E MATERIAL PERMANENTE" -> "Equipamentos e Material Permanente";
            case "OUTROS SERVICOS DE TERCEIROS - PESSOA FISICA" -> "Outros Serviços de Terceiros - Pessoa Física";
            case "INDENIZACOES E RESTITUICOES" -> "Indenizações e Restituições";
            case "MATERIAL DE CONSUMO" -> "Material de Consumo";
            case "AUXILIO-TRANSPORTE" -> "Auxílio-Transporte";
            case "PASSAGENS E DESPESAS COM LOCOMOCAO" -> "Passagens e Despesas com Locomoção";
            case "OBRIGACOES TRIBUTARIAS E CONTRIBUTIVAS" -> "Obrigações Tributárias e Contributivas";
            case "SERVICOS DE CONSULTORIA" -> "Serviços de Consultoria";
            case "OBRAS E INSTALACOES" -> "Obras e Instalações";
            case "INDENIZACOES E RESTITUICOES TRABALHISTAS" -> "Indenizações e Restituições Trabalhistas";
            case "PENSOES ESPECIAIS" -> "Pensões Especiais";
            case "CONTRIBUICOES" -> "Contribuições";
            case "AQUISICAO DE IMOVEIS" -> "Aquisição de Imóveis";
            case "AUXILIO FINANCEIRO A ESTUDANTES" -> "Auxílio Financeiro a Estudantes";
            case "OBRIGACOES PATRONAIS" -> "Obrigações Patronais";
            case "SUBVENCOES SOCIAIS" -> "Subvenções Sociais";
            case "AUXILIO FINANCEIRO A PESQUISADORES" -> "Auxílio Financeiro a Pesquisadores";
            case "ATIVOS CIVIS DA UNIAO" -> "Ativos Civis da União";
            case "APOSENTADORIAS E PENSOES CIVIS DA UNIAO" -> "Aposentadorias e Pensões Civis da União";
            case "JULGAMENTO DE PROCESSOS" -> "Julgamento de Processos";
            case "SEGURANCA INSTITUCIONAL" -> "Segurança Institucional";
            case "ACOES DE INFORMATICA" -> "Ações de Informática";
            case "ASSISTENCIA MEDICA E ODONTOLOGICA DE CIVIS - COMPLEMENTACAO DA UNIAO" ->
                    "Assistência Médica e Odontológica de Civis - Complementação da União";
            case "AUXILIO-ALIMENTACAO DE CIVIS ATIVOS" -> "Auxílio-Alimentação de Civis Ativos";
            case "COMUNICACAO INSTITUCIONAL" -> "Comunicação Institucional";
            case "RECUPERACAO E MODERNIZACAO DAS INSTALACOES DO STF" ->
                    "Recuperação e Modernização das Instalações do STF";
            case "ASSISTENCIA PRE-ESCOLAR AOS DEPENDENTES DE SERVIDORES CIVIS E DE EMPREGADOS" ->
                    "Assistência Pré-Escolar aos Dependentes de Servidores Civis e de Empregados";
            case "BENEFICIO ESPECIAL" -> "Benefício Especial";
            case "AUXILIO-MORADIA PARA OUTROS AGENTES PUBLICOS - ATIVOS" ->
                    "Auxílio-Moradia para Outros Agentes Públicos - Ativos";
            case "CAPACITACAO DE RECURSOS HUMANOS" -> "Capacitação de Recursos Humanos";
            case "CONTRIBUICAO A COMISSAO EUROPEIA PARA A DEMOCRACIA PELO DIREITO" ->
                    "Contribuição à Comissão Europeia para a Democracia pelo Direito";
            case "AUXILIO-FUNERAL E NATALIDADE DE CIVIS" -> "Auxílio-Funeral e Natalidade de Civis";
            case "AUXILIO-TRANSPORTE DE CIVIS ATIVOS" -> "Auxílio-Transporte de Civis Ativos";
            case "CONTRIBUICAO A CONFERENCIA MUNDIAL SOBRE JUSTICA CONSTITUCIONAL" ->
                    "Contribuição à Conferência Mundial sobre Justiça Constitucional";
            case "SERVICOS DE TECNOLOGIA DA INFORMACAO E COMUNICACAO - PJ" ->
                    "Serviços de Tecnologia da Informação e Comunicação - PJ";
            case "RESSARCIMENTO DESPESAS PESSOAL REQUISITADO" -> "Ressarcimento de Despesas de Pessoal Requisitado";
            case "OUTRAS DESPESAS CORRENTES" -> "Outras Despesas Correntes";
            case "INVESTIMENTOS" -> "Investimentos";
            case "SUBSTITUICOES" -> "Substituições";
            case "OBRAS EM ANDAMENTO" -> "Obras em Andamento";
            case "RESTITUICOES" -> "Restituições";
            case "RESSARCIMENTO DE MENSALIDADES" -> "Ressarcimento de Mensalidades";
            case "RESSARCIMENTO DE PRESTACAO DE SERVICOS" -> "Ressarcimento de Prestação de Serviços";
            case "OUTROS SERVICOS DE TERCEIROS - PESSOA JURIDICA (INTRA)" ->
                    "Outros Serviços de Terceiros - Pessoa Jurídica (Intra)";
            case "RESSARCIMENTO ASSISTENCIA MEDICA/ODONTOLOGICA" -> "Ressarcimento de Assistência Médica/Odontológica";
            case "AJUDA DE CUSTO - PESSOAL CIVIL" -> "Ajuda de Custo - Pessoal Civil";
            case "INDENIZACOES" -> "Indenizações";
            case "INDENIZACAO DE MORADIA - PESSOAL CIVIL" -> "Indenização de Moradia - Pessoal Civil";
            case "INDENIZACAO DE TRANSPORTE - PESSOAL CIVIL" -> "Indenização de Transporte - Pessoal Civil";
            case "OUTROS SERVICOS DE TERCEIROS - PJ" -> "Outros Serviços de Terceiros - PJ";
            case "DIARIAS - CIVIL" -> "Diárias - Civil";
            case "SUBVENCOES ECONOMICAS" -> "Subvenções Econômicas";
            case "MANUTENCAO E CONSERVACAO DE BENS IMOVEIS" -> "Manutenção e Conservação de Bens Imóveis";
            default -> elementoDespesa.getNameElementoDespesa();
        };
        elementoDespesa.setNameElementoDespesa(updatedName);
    }

}
