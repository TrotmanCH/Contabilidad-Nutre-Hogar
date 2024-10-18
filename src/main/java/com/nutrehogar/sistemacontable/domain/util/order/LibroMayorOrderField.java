package com.nutrehogar.sistemacontable.domain.util.order;


/**
 * Enum que define los campos por los cuales se puede ordenar el Libro Mayor.
 */
public enum LibroMayorOrderField implements OrderField {
    CODIGO_CUENTA("codigoCuenta"),
    NOMBRE_CUENTA("nombreCuenta"),
    TIPO_CUENTA("tipoCuenta"),
    DEBE("debe"),
    HABER("haber"),
    ;

    private final String fieldName;

    /**
     * Constructor de {@code LibroMayorOrderField}.
     *
     * @param fieldName Nombre del campo en la entidad Cuenta.
     */
    LibroMayorOrderField(String fieldName) {
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