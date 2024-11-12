package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
public sealed abstract class MayorGeneralFilter permits MayorGeneralFilter.ByCodigoCuenta, MayorGeneralFilter.ByNombreCuenta, MayorGeneralFilter.ByFechaRange, MayorGeneralFilter.All {
    private MayorGeneralFilter() {
    }

    /**
     * Filtra el Mayor General por código de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCodigoCuenta extends MayorGeneralFilter {
        String codigoCuenta;

        public ByCodigoCuenta(String codigoCuenta) {
            this.codigoCuenta = codigoCuenta;
        }
    }

    /**
     * Filtra el Mayor General por nombre de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByNombreCuenta extends MayorGeneralFilter {
        String nombreCuenta;

        public ByNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
        }
    }

    /**
     * Filtra el Mayor General por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends MayorGeneralFilter {
        LocalDate startDate;
        LocalDate endDate;

        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Mayor General.
     */
    public static final class All extends MayorGeneralFilter {
        private static All instance;

        private All() {
        }

        public static All getInstance() {
            if (instance == null) {
                instance = new All();
            }
            return instance;
        }
    }
}