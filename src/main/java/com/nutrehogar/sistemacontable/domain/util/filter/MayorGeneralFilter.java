package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
public sealed abstract class MayorGeneralFilter permits MayorGeneralFilter.ByCodigoCuenta, MayorGeneralFilter.ByNombreCuenta, MayorGeneralFilter.ByFechaRange, MayorGeneralFilter.All {
    protected MayorGeneralFilter() {
    }

    /**
     * Filtra el Mayor General por código de cuenta.
     */
    public static final class ByCodigoCuenta extends MayorGeneralFilter {
        public ByCodigoCuenta(String codigoCuenta) {
            this.codigoCuenta = codigoCuenta;
        }

        public String getCodigoCuenta() {
            return codigoCuenta;
        }

        private final String codigoCuenta;
    }

    /**
     * Filtra el Mayor General por nombre de cuenta.
     */

    public static final class ByNombreCuenta extends MayorGeneralFilter {
        public ByNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
        }

        public String getNombreCuenta() {
            return nombreCuenta;
        }

        private final String nombreCuenta;
    }


    public static final class ByFechaRange extends MayorGeneralFilter {
        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        private final LocalDate startDate;
        private final LocalDate endDate;
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Mayor General.
     */

    public static final class All extends MayorGeneralFilter {
        private All() {
        }

        public static final All INSTANCE = new All();
    }
}