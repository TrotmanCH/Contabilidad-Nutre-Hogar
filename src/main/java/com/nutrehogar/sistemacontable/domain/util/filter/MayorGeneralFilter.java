package com.nutrehogar.sistemacontable.domain.util.filter;


import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.domain.util.order.OrderField;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
public sealed abstract class MayorGeneralFilter extends Filter permits MayorGeneralFilter.ByCodigoCuenta, MayorGeneralFilter.ByNombreCuenta, MayorGeneralFilter.ByFechaRange, MayorGeneralFilter.All {
    protected MayorGeneralFilter(OrderDirection direction, OrderField orderField) {
        super(direction, orderField);
    }

    /**
     * Filtra el Mayor General por código de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCodigoCuenta extends MayorGeneralFilter {
        String codigoCuenta;

        public ByCodigoCuenta(OrderDirection direction, OrderField orderField, String codigoCuenta) {
            super(direction, orderField);
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

        public ByNombreCuenta(OrderDirection direction, OrderField orderField, String nombreCuenta) {
            super(direction, orderField);
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

        public ByFechaRange(OrderDirection direction, OrderField orderField, LocalDate startDate, LocalDate endDate) {
            super(direction, orderField);
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Mayor General.
     */
    public static final class All extends MayorGeneralFilter {
        public All(OrderDirection direction, OrderField orderField) {
            super(direction, orderField);
        }
    }
}