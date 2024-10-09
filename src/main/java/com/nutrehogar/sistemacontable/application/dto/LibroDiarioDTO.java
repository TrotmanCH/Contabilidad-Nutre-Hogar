package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LibroDiarioDTO(LocalDate fecha,
                             TipoDocumento tipoDocumento,
                             String codigoCuenta,
                             String concepto,
                             BigDecimal debe,
                             BigDecimal haber) {
}
