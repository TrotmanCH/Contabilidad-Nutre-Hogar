package com.nutrehogar.sistemacontable.domain.util.filter;


import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.domain.util.order.OrderField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Balance de Comprobación.
 */
public sealed abstract class BalanceComprobacionFilter extends Filter permits BalanceComprobacionFilter.All, BalanceComprobacionFilter.ByCodigoCuenta, BalanceComprobacionFilter.ByFechaRange, BalanceComprobacionFilter.ByNombreCuenta {
    protected BalanceComprobacionFilter(OrderDirection direction, OrderField orderField) {
        super(direction, orderField);
    }

    /**
     * Filtra por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends BalanceComprobacionFilter {
        LocalDate startDate;
        LocalDate endDate;

        public ByFechaRange(OrderDirection direction, OrderField orderField, LocalDate startDate, LocalDate endDate) {
            super(direction, orderField);
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

        public ByCodigoCuenta(OrderDirection direction, OrderField orderField, String codigoCuenta) {
            super(direction, orderField);
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

        public ByNombreCuenta(OrderDirection direction, OrderField orderField, String nombreCuenta) {
            super(direction, orderField);
            this.nombreCuenta = nombreCuenta;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Balance de Comprobación.
     */
    public static final class All extends BalanceComprobacionFilter {
        public All(OrderDirection direction, OrderField orderField) {
            super(direction, orderField);
        }
    }
}