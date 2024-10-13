package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;

import java.math.BigDecimal;

/**
 * DTO que representa un registro en el Libro Mayor.
 */
public record LibroMayorDTO(String codigoCuenta,
                            String nombreCuenta,
                            TipoCuenta tipoCuenta,
                            BigDecimal debe,
                            BigDecimal haber) {
}