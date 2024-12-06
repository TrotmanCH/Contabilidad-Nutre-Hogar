package com.nutrehogar.sistemacontable.domain.util.filter;


import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Diario.
 * @author Calcifer1331
 */
public sealed interface LibroDiarioFilter {

    /**
     * Filtra el Libro Diario por un rango de fechas.
     */
    record ByFechaRange(LocalDate startDate,
                        LocalDate endDate) implements LibroDiarioFilter {
    }

    /**
     * Filtra el Libro Diario por concepto.
     */
    record ByReferencia(String value) implements LibroDiarioFilter {
    }

    /**
     * Filtra el Libro Diario por comprobante.
     */

    record ByComprobante(String value) implements LibroDiarioFilter {
    }
}