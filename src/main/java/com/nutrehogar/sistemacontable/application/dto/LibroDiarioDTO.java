package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @param asientoFecha
 * @param tipoDocumentoNombre
 * @param cuentaId
 * @param registroComprobante
 * @param registroReferencia
 * @param registroDebe
 * @param registroHaber
 * @author Calcifer1331
 */
public record LibroDiarioDTO(Integer asientoId,
                             LocalDate asientoFecha,
                             String tipoDocumentoNombre,
                             String cuentaId,
                             String registroComprobante,
                             String registroReferencia,
                             BigDecimal registroDebe,
                             BigDecimal registroHaber) {
}
