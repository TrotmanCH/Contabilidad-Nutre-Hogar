package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record BalanceComprobacionDTO(
        LocalDate fecha,
        TipoDocumento tipoDocumento,
        String codigoCuenta,
        String nombreCuenta,
        String comprobante,
        String referencia,
        BigDecimal debe,
        BigDecimal haber) {
}
