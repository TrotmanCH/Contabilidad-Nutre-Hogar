package com.nutrehogar.sistemacontable.domain.util.order;


/**
 * Enum que define los campos por los cuales se puede ordenar el Libro Diario.
 */
public enum LibroDiarioOrderField {
    FECHA("fecha"),
    CONCEPTO("concepto"),
    DEBE("debe"),
    HABER("haber");

    private final String fieldName;

    /**
     * Constructor de {@code LibroDiarioOrderField}.
     *
     * @param fieldName Nombre del campo en la entidad Transaccion.
     */
    LibroDiarioOrderField(String fieldName) {
        this.fieldName = fieldName;
    }

    /**
     * Obtiene el nombre del campo correspondiente en la entidad.
     *
     * @return Nombre del campo.
     */
    public String getFieldName() {
        return fieldName;
    }
}