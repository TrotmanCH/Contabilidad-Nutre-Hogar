package com.nutrehogar.sistemacontable.domain.util.order;

/**
 * Interfaz que representa todos los Ordenamientos por campo que se usaran en las consultas contables
 */
public sealed interface OrderField permits BalanceComprobacionOrderField, LibroDiarioOrderField, LibroMayorOrderField, MayorGeneralOrderField {
}
