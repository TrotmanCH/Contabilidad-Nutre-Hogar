package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

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
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends BalanceComprobacionFilter {
        LocalDate startDate;
        LocalDate endDate;

        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    /**
     * Filtra el Balance de Comprobación por código de cuenta.
     */
    @Getter

    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCodigoCuenta extends BalanceComprobacionFilter {
        String codigoCuenta;

        public ByCodigoCuenta(String codigoCuenta) {
            this.codigoCuenta = codigoCuenta;
        }
    }

    /**
     * Filtra el Balance de Comprobación por nombre de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByNombreCuenta extends BalanceComprobacionFilter {
        String nombreCuenta;

        public ByNombreCuenta(String nombreCuenta) {
            this.nombreCuenta = nombreCuenta;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Balance de Comprobación.
     */
    @Getter
    public static final class All extends BalanceComprobacionFilter {
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