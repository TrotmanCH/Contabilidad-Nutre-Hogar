package com.nutrehogar.sistemacontable.domain.util.filter;

import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.domain.util.order.OrderField;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;

/**
 * Clase que representa todos los filtros contables, Contiene un {@link OrderDirection} y un {@link OrderField}
 * <p>
 * La clase esta sellada para que no se instancie en una clase anonima
 * </p>
 */
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract sealed class Filter permits LibroDiarioFilter, LibroMayorFilter, BalanceComprobacionFilter, MayorGeneralFilter {
    OrderDirection direction;
    OrderField orderField;
}

