package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record MayorGeneralDTO(
        LocalDate fecha,
        TipoDocumento tipoDocumento,
        String codigoCuenta,
        String referencia,
        BigDecimal debe,
        BigDecimal haber,
        BigDecimal saldo
) {
}
