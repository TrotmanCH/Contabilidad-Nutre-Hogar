package com.nutrehogar.sistemacontable.application.dto;

import com.nutrehogar.sistemacontable.domain.DocumentType;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @param journalEntryFecha
 * @param ledgerRecordDocumentType
 * @param accountId
 * @param registroComprobante
 * @param registroReferencia
 * @param registroDebe
 * @param registroHaber
 * @author Calcifer1331
 */
public record JournalDTO(Integer journalEntryId,
                         LocalDate journalEntryFecha,
                         DocumentType ledgerRecordDocumentType,
                         Integer accountId,
                         String ledgerRecordVoucher,
                         String ledgerRecordReference,
                         BigDecimal ledgerRecordDebit,
                         BigDecimal ledgerRecordCredit) {
}
