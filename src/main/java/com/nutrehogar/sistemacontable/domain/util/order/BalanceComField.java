package com.nutrehogar.sistemacontable.domain.util.order;

/**
 * @author jayson 
 * Enum que define los campos por los cuales se puede ordenar el
 * Balance de Comprobación.
 */
public enum BalanceComField {
    ASIENTO_FECHA("Fecha"),
    TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
    CUENTA_ID("Codigo Cuenta"),
    CUENTA_NOMBRE("Nombre Cuenta"),
    REGISTRO_REFERENCIA("Referencia"),
    REGISTRO_DEBE("Debe"),
    REGISTRO_HABER("Haber"),
    SALDO("Saldo");


    private final String fieldName;

    /**
     * Constructor de {@code BalanceComprobacionOrderField}.
     *
     * @param fieldName Nombre del campo en la entidad Cuenta.
     */
    BalanceComField(String fieldName) {
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
