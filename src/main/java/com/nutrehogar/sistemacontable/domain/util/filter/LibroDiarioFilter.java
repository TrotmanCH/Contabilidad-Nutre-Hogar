package com.nutrehogar.sistemacontable.domain.util.filter;


import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Diario.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public sealed abstract class LibroDiarioFilter extends Filter permits LibroDiarioFilter.All, LibroDiarioFilter.ByComprobante, LibroDiarioFilter.ByFechaRange, LibroDiarioFilter.ByReferencia {

    protected LibroDiarioFilter(OrderDirection direction, LibroDiarioOrderField orderField) {
        super(direction, orderField);
    }

    /**
     * Filtra el Libro Diario por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends LibroDiarioFilter {
        LocalDate starDate;
        LocalDate endDate;

        public ByFechaRange(OrderDirection direction, LibroDiarioOrderField order, LocalDate startDate, LocalDate endDate) {
            super(direction, order);
            this.starDate = startDate;
            this.endDate = endDate;
        }
    }

    /**
     * Filtra el Libro Diario por concepto.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByReferencia extends LibroDiarioFilter {
        String referencia;

        public ByReferencia(OrderDirection direction, LibroDiarioOrderField order, String referencia) {
            super(direction, order);
            this.referencia = referencia;
        }
    }

    /**
     * Filtra el Libro Diario por comprobante.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByComprobante extends LibroDiarioFilter {
        String comprobante;

        public ByComprobante(OrderDirection direction, LibroDiarioOrderField order, String comprobante) {
            super(direction, order);
            this.comprobante = comprobante;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro
     */
    public static final class All extends LibroDiarioFilter {
        public All(OrderDirection direction, LibroDiarioOrderField orderField) {
            super(direction, orderField);
        }
    }
}