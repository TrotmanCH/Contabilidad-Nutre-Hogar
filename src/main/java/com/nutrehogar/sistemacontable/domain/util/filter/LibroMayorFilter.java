package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Mayor.
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public sealed abstract class LibroMayorFilter permits LibroMayorFilter.ByCodigoCuenta, LibroMayorFilter.ByNombreCuenta, LibroMayorFilter.All {

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
     * Representa la opción de no aplicar ningún filtro al Libro Mayor.
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class All extends LibroMayorFilter {
        public static final All INSTANCE = new All();
    }
}