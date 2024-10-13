package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LibroDiarioDTO(LocalDate fecha,
                             TipoDocumento tipoDocumento,
                             String codigoCuenta,
                             String comprobante,
                             String referencia,
                             BigDecimal debe,
                             BigDecimal haber) {
}
