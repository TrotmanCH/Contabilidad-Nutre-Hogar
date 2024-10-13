package com.nutrehogar.sistemacontable.domain.util.filter;


import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Balance de Comprobación.
 */
public sealed abstract class BalanceComprobacionFilter permits BalanceComprobacionFilter.All, BalanceComprobacionFilter.ByCodigoCuenta, BalanceComprobacionFilter.ByFechaRange, BalanceComprobacionFilter.ByNombreCuenta {
    protected BalanceComprobacionFilter() {
    }

    /**
     * Filtra por un rango de fechas.
     */

    public static final class ByFechaRange extends BalanceComprobacionFilter {
        private final LocalDate startDate;
        private final LocalDate endDate;

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
    }

    /**
     * Filtra el Balance de Comprobación por código de cuenta.
     */

    public static final class ByCodigoCuenta extends BalanceComprobacionFilter {
        private final String codigoCuenta;

        public String getCodigoCuenta() {
            return codigoCuenta;
        }

        public ByCodigoCuenta(String codigoCuenta) {
            this.codigoCuenta = codigoCuenta;
        }
    }

    /**
     * Filtra el Balance de Comprobación por nombre de cuenta.
     */

    public static final class ByNombreCuenta extends BalanceComprobacionFilter {
        public ByNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
        }

        public String getNombreCuenta() {
            return nombreCuenta;
        }

        private final String nombreCuenta;
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Balance de Comprobación.
     */
    public static final class All extends BalanceComprobacionFilter {
        private All() {
        }

        public static final All INSTANCE = new All();
    }
}