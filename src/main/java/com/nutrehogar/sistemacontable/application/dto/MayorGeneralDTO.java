package com.nutrehogar.sistemacontable.application.dto;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MayorGeneralDTO {
    final LocalDate fecha;
    final String asientoNombre;
    final String tipoDocumentoNombre;
    final String codigoCuenta;
    final Integer idTipoCuenta;
    final String referencia;
    final BigDecimal debe;
    final BigDecimal haber;
    @Setter
    BigDecimal saldo;

    public MayorGeneralDTO(LocalDate fecha, String asientoNombre, String tipoDocumentoNombre,
                           String codigoCuenta, Integer idTipoCuenta, String referencia, BigDecimal debe, BigDecimal haber) {
        this.fecha = fecha;
        this.asientoNombre = asientoNombre;
        this.tipoDocumentoNombre = tipoDocumentoNombre;
        this.codigoCuenta = codigoCuenta;
        this.idTipoCuenta = idTipoCuenta;
        this.referencia = referencia;
        this.debe = debe;
        this.haber = haber;
        this.saldo = BigDecimal.ZERO;
    }
}