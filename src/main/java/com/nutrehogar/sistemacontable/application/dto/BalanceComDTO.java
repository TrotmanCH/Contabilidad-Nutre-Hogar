package com.nutrehogar.sistemacontable.application.dto;

/**
 *
 * @author Jayson
 */
import java.math.BigDecimal;
import java.time.LocalDate;

public record BalanceComDTO(
        LocalDate asientoFecha,
        String tipoDocumentoNombre,
        String cuentaId,
        String cuentaNombre,
        String registroReferencia,
        BigDecimal registroDebe,
        BigDecimal registroHaber) {

}
