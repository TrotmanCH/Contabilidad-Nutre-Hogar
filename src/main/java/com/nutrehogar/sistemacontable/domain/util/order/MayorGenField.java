package com.nutrehogar.sistemacontable.domain.util.order;


import lombok.Getter;

/**
 * Enum que define los campos por los cuales se puede ordenar el Mayor General.
 */
@Getter
public enum MayorGenField implements OrderField {
    ASIENTO_FECHA("Fecha"),
    ASIENTO_NOMBRE("Nombre de Asiento"),
    TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
    CUENTA_ID("Código Cuenta"),
    REGISTRO_REFERENCIA("Referencia"),
    REGISTRO_DEBE("Debe"),
    REGISTRO_HABER("Haber"),
    SALDO("Saldo");

    /**
     * -- GETTER --
     * Obtiene el nombre del campo correspondiente en la entidad.
     *
     * @return Nombre del campo.
     */
    private final String fieldName;

    /**
     * Constructor de {@code MayorGeneralOrderField}.
     *
     * @param fieldName Nombre del campo en la entidad.
     */
    MayorGenField(String fieldName) {
        this.fieldName = fieldName;
    }

}