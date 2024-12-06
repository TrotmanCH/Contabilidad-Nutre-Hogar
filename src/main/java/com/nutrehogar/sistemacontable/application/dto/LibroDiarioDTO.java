package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author Calcifer1331
 * @param asientoFecha
 * @param tipoDocumentoNombre
 * @param cuentaId
 * @param registroComprobante
 * @param registroReferencia
 * @param registroDebe
 * @param registroHaber
 */
public record LibroDiarioDTO(LocalDate asientoFecha,
                             String tipoDocumentoNombre,
                             String cuentaId,
                             String registroComprobante,
                             String registroReferencia,
                             BigDecimal registroDebe,
                             BigDecimal registroHaber) {
}
