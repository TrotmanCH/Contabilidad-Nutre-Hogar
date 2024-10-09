package com.nutrehogar.sistemacontable.domain.util.filter;


import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Mayor.
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public sealed abstract class LibroMayorFilter permits LibroMayorFilter.All, LibroMayorFilter.ByCodigoCuenta, LibroMayorFilter.ByFechaRange, LibroMayorFilter.ByNombreCuenta, LibroMayorFilter.ByTipoCuenta {

    /**
     * Filtra el Libro Mayor por código de cuenta.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCodigoCuenta extends LibroMayorFilter {
        String codigoCuenta;
    }

    /**
     * Filtra el Libro Mayor por nombre de cuenta.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByNombreCuenta extends LibroMayorFilter {
        String nombreCuenta;
    }

    /**
     * Filtra el Libro Mayor por un rango de fechas.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends LibroMayorFilter {
        LocalDate startDate;
        LocalDate endDate;
    }

    /**
     * Filtra el Libro Mayor por Tipo de Cuenta.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByTipoCuenta extends LibroMayorFilter {
        TipoCuenta tipoCuenta;
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Libro Mayor.
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class All extends LibroMayorFilter {
        public static final All INSTANCE = new All();
    }
}