package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Diario.
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public sealed abstract class LibroDiarioFilter permits LibroDiarioFilter.All, LibroDiarioFilter.ByComprobante, LibroDiarioFilter.ByFechaRange, LibroDiarioFilter.ByReferencia {

    /**
     * Filtra el Libro Diario por un rango de fechas.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends LibroDiarioFilter {
        LocalDate startDate;
        LocalDate endDate;
    }

    /**
     * Filtra el Libro Diario por concepto.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByReferencia extends LibroDiarioFilter {
        String referencia;
    }
    /**
     * Filtra el Libro Diario por comprobante.
     */
    @Getter
    @AllArgsConstructor
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByComprobante extends LibroDiarioFilter {
        String comprobante;
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Libro Diario.
     */
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static final class All extends LibroDiarioFilter {
        public static final All INSTANCE = new All();
    }

    public static class ByConcepto {
        public ByConcepto(String servi) {
        }
    }
}