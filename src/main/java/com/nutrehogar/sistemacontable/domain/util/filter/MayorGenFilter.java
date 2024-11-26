package com.nutrehogar.sistemacontable.domain.util.filter;


import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
public sealed interface MayorGenFilter {
    /**
     * Filtra el Mayor General por código de cuenta.
     */
    record ByCuentaId(String value) implements MayorGenFilter {
    }

    /**
     * Filtra el Mayor General por nombre de cuenta.
     */
    record ByNombreCuenta(String value) implements MayorGenFilter {
    }

    /**
     * Filtra el Mayor General por un rango de fechas.
     */
    record ByFechaRange(LocalDate startDate, LocalDate endDate) implements MayorGenFilter {
    }
}

