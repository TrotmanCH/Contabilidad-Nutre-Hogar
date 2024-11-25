package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@ToString

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
public sealed abstract class MayorGenFilter permits MayorGenFilter.ByCuentaId, MayorGenFilter.ByNombreCuenta, MayorGenFilter.ByFechaRange, MayorGenFilter.All {
    private MayorGenFilter() {
    }

    /**
     * Filtra el Mayor General por código de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @ToString
    @AllArgsConstructor(staticName = "of")
    public static final class ByCuentaId extends MayorGenFilter {
        String id;

    }

    /**
     * Filtra el Mayor General por nombre de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @ToString
    @AllArgsConstructor(staticName = "of")
    public static final class ByNombreCuenta extends MayorGenFilter {
        String nombre;
    }

    /**
     * Filtra el Mayor General por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @ToString
    @AllArgsConstructor(staticName = "of")
    public static final class ByFechaRange extends MayorGenFilter {
        LocalDate startDate;
        LocalDate endDate;
    }
}