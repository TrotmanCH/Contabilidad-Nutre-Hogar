package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;

public record BalanceGeneralDTO(String codigoCuenta,
         String nombreCuenta,
         BigDecimal debe,
        BigDecimal haber) {
}
