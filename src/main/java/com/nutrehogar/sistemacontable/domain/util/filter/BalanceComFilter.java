package com.nutrehogar.sistemacontable.domain.util.filter;

import java.time.LocalDate;

/**
 * Clase sellada que define los criterios de filtrado para el Balance de
 * Comprobación.
 * 
 * @author jayson
 */
public sealed interface BalanceComFilter {

    record ByFechaRange(LocalDate startDate, LocalDate endDate) implements BalanceComFilter {

    }

    record ByNombreCuenta(String value) implements BalanceComFilter {

    }

    record ByCodigoCuenta(String value) implements BalanceComFilter {

    }
}
