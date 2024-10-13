package com.nutrehogar.sistemacontable.domain.util.filter;


import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Mayor.
 */
public sealed abstract class LibroMayorFilter permits LibroMayorFilter.All, LibroMayorFilter.ByCodigoCuenta, LibroMayorFilter.ByFechaRange, LibroMayorFilter.ByNombreCuenta, LibroMayorFilter.ByTipoCuenta {
    protected LibroMayorFilter() {
    }

    /**
     * Filtra el Libro Mayor por código de cuenta.
     */

    public static final class ByCodigoCuenta extends LibroMayorFilter {
        public String getCodigoCuenta() {
            return codigoCuenta;
        }

        public ByCodigoCuenta(String codigoCuenta) {
            this.codigoCuenta = codigoCuenta;
        }

        private final String codigoCuenta;
    }

    /**
     * Filtra el Libro Mayor por nombre de cuenta.
     */

    public static final class ByNombreCuenta extends LibroMayorFilter {
        public String getNombreCuenta() {
            return nombreCuenta;
        }

        public ByNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
        }

        private final String nombreCuenta;
    }

    /**
     * Filtra el Libro Mayor por un rango de fechas.
     */

    public static final class ByFechaRange extends LibroMayorFilter {
        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        private final LocalDate startDate;
        private final LocalDate endDate;
    }

    /**
     * Filtra el Libro Mayor por Tipo de Cuenta.
     */

    public static final class ByTipoCuenta extends LibroMayorFilter {
        public TipoCuenta getTipoCuenta() {
            return tipoCuenta;
        }

        public ByTipoCuenta(TipoCuenta tipoCuenta) {
            this.tipoCuenta = tipoCuenta;
        }

        private final TipoCuenta tipoCuenta;
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Libro Mayor.
     */
    public static final class All extends LibroMayorFilter {
        private All() {
        }

        public static final All INSTANCE = new All();
    }
}