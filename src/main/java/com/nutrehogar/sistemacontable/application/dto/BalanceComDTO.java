package com.nutrehogar.sistemacontable.application.dto;

/**
 * @author Jayson
 */

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BalanceComDTO {
    Integer asientoId;
    LocalDate asientoFecha;
    String tipoDocumentoNombre;
    String cuentaId;
    String cuentaNombre;
    Integer tipoCuentaId;
    String registroReferencia;
    BigDecimal registroDebe;
    BigDecimal registroHaber;
    @Setter
    BigDecimal saldo;

    public BalanceComDTO(Integer asientoId, LocalDate asientoFecha, String tipoDocumentoNombre, String cuentaId, String cuentaNombre, Integer tipoCuentaId, String registroReferencia, BigDecimal registroDebe, BigDecimal registroHaber) {
        this.asientoId = asientoId;
        this.asientoFecha = asientoFecha;
        this.tipoDocumentoNombre = tipoDocumentoNombre;
        this.cuentaId = cuentaId;
        this.cuentaNombre = cuentaNombre;
        this.tipoCuentaId = tipoCuentaId;
        this.registroReferencia = registroReferencia;
        this.registroDebe = registroDebe;
        this.registroHaber = registroHaber;
        this.saldo = BigDecimal.ZERO;
    }

    public BalanceComDTO(Integer asientoId,LocalDate asientoFecha, String tipoDocumentoNombre, String cuentaId, String cuentaNombre, Integer tipoCuentaId, String registroReferencia, BigDecimal registroDebe, BigDecimal registroHaber, BigDecimal saldo) {
        this.asientoId = asientoId;
        this.asientoFecha = asientoFecha;
        this.tipoDocumentoNombre = tipoDocumentoNombre;
        this.cuentaId = cuentaId;
        this.cuentaNombre = cuentaNombre;
        this.tipoCuentaId = tipoCuentaId;
        this.registroReferencia = registroReferencia;
        this.registroDebe = registroDebe;
        this.registroHaber = registroHaber;
        this.saldo = saldo;
    }

    public BalanceComDTO(String registroReferencia, BigDecimal registroDebe, BigDecimal registroHaber, BigDecimal saldo) {
        this.registroReferencia = registroReferencia;
        this.registroDebe = registroDebe;
        this.registroHaber = registroHaber;
        this.saldo = saldo;
    }
}
