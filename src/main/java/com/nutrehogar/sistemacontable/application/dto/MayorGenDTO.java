package com.nutrehogar.sistemacontable.application.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MayorGenDTO {
    Integer asientoId;
    LocalDate asientoFecha;
    String asientoNombre;
    String tipoDocumentoNombre;
    String cuentaId;
    Integer tipoCuentaId;
    String registroReferencia;
    BigDecimal registroDebe;
    BigDecimal registroHaber;
    @Setter
    BigDecimal saldo;

    public MayorGenDTO(Integer asientoId, LocalDate fecha, String asientoNombre, String tipoDocumentoNombre,
                       String codigoCuenta, Integer idTipoCuenta, String referencia, BigDecimal debe, BigDecimal haber) {
        this.asientoId = asientoId;
        this.asientoFecha = fecha;
        this.asientoNombre = asientoNombre;
        this.tipoDocumentoNombre = tipoDocumentoNombre;
        this.cuentaId = codigoCuenta;
        this.tipoCuentaId = idTipoCuenta;
        this.registroReferencia = referencia;
        this.registroDebe = debe;
        this.registroHaber = haber;
        this.saldo = BigDecimal.ZERO;
    }

    public MayorGenDTO(BigDecimal haber, BigDecimal debe, BigDecimal saldo) {
        this.saldo = saldo;
        this.registroDebe = debe;
        this.registroHaber = haber;
    }

}