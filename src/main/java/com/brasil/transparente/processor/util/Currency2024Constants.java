package com.brasil.transparente.processor.util;

public class Currency2024Constants {

    public static final double USD = 5.36563;
    public static final double YUAN = 0.7393;
    public static final double BAHT = 0.14608;
    public static final double BOLIVIANO = 0.75389;
    public static final double ZLOTY = 1.31569;
    public static final double NAIRA = 0.00359;
    public static final double LIBRA_LIBANESA = 0.00006;
    public static final double PESO_ARGENTINO = 0.00595;
    public static final double EURO = 5.74497;

    public static double convertCurrency(String unidadeGestora, double valorPago) {
        if (unidadeGestora.contains("- USD")) {
            return valorPago * Currency2024Constants.USD;
        } else if (unidadeGestora.contains("- MOEDA LOCAL")) {
            return switch (unidadeGestora) {
                case EmbaixadasConstants.EMBAIXADA_CHINA_PEQUIM_LOCAL, EmbaixadasConstants.EMBAIXADA_CHINA_CANTAO_LOCAL,
                     EmbaixadasConstants.EMBAIXADA_CHINA_XANGAI_LOCAL -> valorPago * Currency2024Constants.YUAN;
                case EmbaixadasConstants.EMBAIXADA_BOLIVIA_LOCAL -> valorPago * Currency2024Constants.BOLIVIANO;
                case EmbaixadasConstants.EMBAIXADA_TAILANDIA_LOCAL -> valorPago * Currency2024Constants.BAHT;
                case EmbaixadasConstants.EMBAIXADA_POLONIA_LOCAL -> valorPago * Currency2024Constants.ZLOTY;
                case EmbaixadasConstants.EMBAIXADA_NIGERIA_LOCAL -> valorPago * Currency2024Constants.NAIRA;
                case EmbaixadasConstants.EMBAIXADA_BEIRUTE_LOCAL -> valorPago * Currency2024Constants.LIBRA_LIBANESA;
                case EmbaixadasConstants.EMBAIXADA_PASO_LOS_LIBRES_LOCAL -> valorPago * Currency2024Constants.PESO_ARGENTINO;
                case EmbaixadasConstants.EMBAIXADA_GENEBRA_EURO -> valorPago * Currency2024Constants.EURO;
                default -> valorPago;
            };
        }
        return valorPago;
    }
}
