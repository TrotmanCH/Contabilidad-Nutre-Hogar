package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;

import java.math.BigDecimal;

public record BalanceComprobacionDTO(
        BigDecimal fecha,
        TipoDocumento tipoDocumento,
        String codigoCuenta,
         String nombreCuenta,
         String referencia,
         BigDecimal debe,
        BigDecimal haber) {
}
