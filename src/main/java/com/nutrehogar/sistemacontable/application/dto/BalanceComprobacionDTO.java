package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;

public record BalanceComprobacionDTO(String codigoCuenta,
         String nombreCuenta,
         BigDecimal debe,
        BigDecimal haber) {
}
