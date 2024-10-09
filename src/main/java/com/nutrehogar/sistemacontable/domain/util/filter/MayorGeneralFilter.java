package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public sealed abstract class MayorGeneralFilter permits MayorGeneralFilter.ByCodigoCuenta, MayorGeneralFilter.ByNombreCuenta, MayorGeneralFilter.ByFechaRange, MayorGeneralFilter.All {


    /**
     * Filtra el Mayor General por código de cuenta.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCodigoCuenta extends MayorGeneralFilter {
        String codigoCuenta;
    }

    /**
     * Filtra el Mayor General por nombre de cuenta.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByNombreCuenta extends MayorGeneralFilter {
        String nombreCuenta;
    }

    /**
     * Filtra el Mayor General por un rango de fechas.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends MayorGeneralFilter {
        LocalDate startDate;
        LocalDate endDate;
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Mayor General.
     */
    @Getter
    @AllArgsConstructor
    public static final class All extends MayorGeneralFilter {
        public static final All INSTANCE = new All();
    }
}