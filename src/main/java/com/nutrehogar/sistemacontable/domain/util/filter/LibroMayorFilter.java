package com.nutrehogar.sistemacontable.domain.util.filter;


import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.util.order.LibroMayorOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Mayor.
 */
public sealed abstract class LibroMayorFilter extends Filter permits LibroMayorFilter.All, LibroMayorFilter.ByCodigoCuenta, LibroMayorFilter.ByFechaRange, LibroMayorFilter.ByNombreCuenta, LibroMayorFilter.ByTipoCuenta {

    protected LibroMayorFilter(OrderDirection direction, LibroMayorOrderField orderField) {
        super(direction, orderField);
    }

    /**
     * Filtra el Libro Mayor por código de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCodigoCuenta extends LibroMayorFilter {
        String codigoCuenta;

        public ByCodigoCuenta(OrderDirection direction, LibroMayorOrderField orderField, String codigoCuenta) {
            super(direction, orderField);
            this.codigoCuenta = codigoCuenta;
        }
    }

    /**
     * Filtra el Libro Mayor por nombre de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByNombreCuenta extends LibroMayorFilter {
        String nombreCuenta;

        public ByNombreCuenta(OrderDirection direction, LibroMayorOrderField orderField, String nombreCuenta) {
            super(direction, orderField);
            this.nombreCuenta = nombreCuenta;
        }
    }

    /**
     * Filtra el Libro Mayor por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends LibroMayorFilter {
        LocalDate startDate;
        LocalDate endDate;

        public ByFechaRange(OrderDirection direction, LibroMayorOrderField orderField, LocalDate startDate, LocalDate endDate) {
            super(direction, orderField);
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    /**
     * Filtra el Libro Mayor por Tipo de Cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByTipoCuenta extends LibroMayorFilter {
        TipoCuenta tipoCuenta;

        public ByTipoCuenta(OrderDirection direction, LibroMayorOrderField orderField, TipoCuenta tipoCuenta) {
            super(direction, orderField);
            this.tipoCuenta = tipoCuenta;
        }
    }

    public static final class All extends LibroMayorFilter {
        public All(OrderDirection direction, LibroMayorOrderField orderField) {
            super(direction, orderField);
        }
    }
}