package com.nutrehogar.sistemacontable.application.dto;

import java.time.LocalDate;
import java.util.List;

public record JournalEntryDTO(
        int id,
        String checkNumber,
        LocalDate date,
        String name,
        String concept,
        String amount,
        List<LedgerRecordDTO> ledgerRecords) {
}
