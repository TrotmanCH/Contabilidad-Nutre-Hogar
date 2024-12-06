package com.nutrehogar.sistemacontable.domain.util.order;


import lombok.Getter;

/**
 * Enum que define los campos por los cuales se puede ordenar el Libro Diario.
 * @author Calcifer1331
 */
@Getter
public enum LibroDiarioField implements OrderField {
    ASIENTO_FECHA("Fecha"),
    TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
    CUENTA_ID("Codigo Cuenta"),
    REGISTRO_COMPROBANTE("Comprobante"),
    REGISTRO_REFERENCIA("Referencia"),
    REGISTRO_DEBE("Debe"),
    REGISTRO_HABER("Haber");

    private final String fieldName;

    /**
     * Constructor de {@code LibroDiarioOrderField}.
     *
     * @param fieldName Nombre del campo en la entidad Transaccion.
     */
    LibroDiarioField(String fieldName) {
        this.fieldName = fieldName;
    }
}