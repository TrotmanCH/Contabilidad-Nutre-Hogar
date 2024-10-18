package com.nutrehogar.sistemacontable.application.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

public record BalanceComprobacionDTO(
        LocalDate fecha,
        String tipoDocumentoNombre,
        String codigoCuenta,
        String nombreCuenta,
        String referencia,
        BigDecimal debe,
        BigDecimal haber) {
}
