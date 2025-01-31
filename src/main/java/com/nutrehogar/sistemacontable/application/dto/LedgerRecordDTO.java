package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;

public record LedgerRecordDTO(String documentType,
                              String voucher,
                              String accountId,
                              String reference,
                              BigDecimal debit,
                              BigDecimal credit,
                              BigDecimal balance) {
}
