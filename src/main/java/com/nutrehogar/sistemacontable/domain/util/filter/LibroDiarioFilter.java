package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Libro Diario.
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public sealed abstract class LibroDiarioFilter permits LibroDiarioFilter.All, LibroDiarioFilter.ByComprobante, LibroDiarioFilter.ByFechaRange, LibroDiarioFilter.ByReferencia {

    protected LibroDiarioFilter() {

    }


    /**
     * Filtra el Libro Diario por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends LibroDiarioFilter {
        LocalDate starDate;
        LocalDate endDate;

        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
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

        public ByReferencia(String referencia) {
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

        public ByComprobante(String comprobante) {

            this.comprobante = comprobante;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro
     */
    public static final class All extends LibroDiarioFilter {
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