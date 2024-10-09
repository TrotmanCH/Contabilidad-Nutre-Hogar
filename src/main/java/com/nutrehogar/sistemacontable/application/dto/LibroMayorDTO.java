package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;

public record LibroMayorDTO(String codigoCuenta,
                            String nombreCuenta,
                            BigDecimal totalDebe,
                            BigDecimal totalHaber) {
}