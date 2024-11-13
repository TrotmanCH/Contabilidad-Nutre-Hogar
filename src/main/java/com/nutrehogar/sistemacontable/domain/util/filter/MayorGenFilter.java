package com.nutrehogar.sistemacontable.domain.util.filter;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Mayor General.
 */
public sealed abstract class MayorGenFilter permits MayorGenFilter.ByCuentaId, MayorGenFilter.ByNombreCuenta, MayorGenFilter.ByFechaRange, MayorGenFilter.All {
    private MayorGenFilter() {
    }

    /**
     * Filtra el Mayor General por código de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByCuentaId extends MayorGenFilter {
        String id;

        public ByCuentaId(String id) {
            this.id = id;
        }
    }

    /**
     * Filtra el Mayor General por nombre de cuenta.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByNombreCuenta extends MayorGenFilter {
        String nombre;

        public ByNombreCuenta(String nombre) {
            this.nombre = nombre;
        }
    }

    /**
     * Filtra el Mayor General por un rango de fechas.
     */
    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    public static final class ByFechaRange extends MayorGenFilter {
        LocalDate startDate;
        LocalDate endDate;

        public ByFechaRange(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
        }
    }

    /**
     * Representa la opción de no aplicar ningún filtro al Mayor General.
     */
    public static final class All extends MayorGenFilter {
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