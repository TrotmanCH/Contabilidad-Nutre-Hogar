package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Diario.
 */
//@AllArgsConstructor(access = AccessLevel.PROTECTED)
public sealed abstract class LibroDiarioFilter permits LibroDiarioFilter.All, LibroDiarioFilter.ByComprobante, LibroDiarioFilter.ByFechaRange, LibroDiarioFilter.ByReferencia {
    protected LibroDiarioFilter() {
    }

    /**
     * Filtra el Libro Diario por un rango de fechas.
     */
//    @Getter
//    @AllArgsConstructor
//    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends LibroDiarioFilter {
        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }

        private final LocalDate startDate;

        public LocalDate getStartDate() {
            return startDate;
        }

        public LocalDate getEndDate() {
            return endDate;
        }

        private final LocalDate endDate;

    }

    /**
     * Filtra el Libro Diario por concepto.
     */
//    @Getter
//    @AllArgsConstructor
//    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByReferencia extends LibroDiarioFilter {
        private  final String referencia;

        public String getReferencia() {
            return referencia;
        }

        public ByReferencia(String referencia) {
            this.referencia = referencia;
        }
    }

    /**
     * Filtra el Libro Diario por comprobante.
     */
//    @Getter
//    @AllArgsConstructor
//    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByComprobante extends LibroDiarioFilter {
        private final String comprobante;

        public String getComprobante() {
            return comprobante;
        }

        public ByComprobante(String comprobante) {
            this.comprobante = comprobante;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Libro Diario.
     */
//    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class All extends LibroDiarioFilter {
        private All() {
        }

        public static final All INSTANCE = new All();
    }
}