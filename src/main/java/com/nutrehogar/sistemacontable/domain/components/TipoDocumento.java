package com.nutrehogar.sistemacontable.domain.components;

/**
 * Enum que representa los tipos de documentos contables.
 *
 * <p>Estos tipos de documentos indican la naturaleza del asiento contable y ayudan a clasificar las transacciones financieras.</p>
 *
 * <p><strong>Valores:</strong></p>
 * <ul>
 *     <li>{@code INGRESO}: Representa ingresos o entradas de dinero.</li>
 *     <li>{@code EGRESO}: Representa egresos o salidas de dinero.</li>
 *     <li>{@code AJUSTE}: Representa ajustes contables que corrigen o modifican asientos anteriores.</li>
 * </ul>
 */
public enum TipoDocumento {
    INGRESO,
    EGRESO,
    AJUSTE
}
