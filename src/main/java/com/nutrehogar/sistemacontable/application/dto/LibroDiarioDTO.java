package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LibroDiarioDTO(LocalDate fecha,
                             String tipoDocumentoNombre,
                             String codigoCuenta,
                             String comprobante,
                             String referencia,
                             BigDecimal debe,
                             BigDecimal haber) {


}
