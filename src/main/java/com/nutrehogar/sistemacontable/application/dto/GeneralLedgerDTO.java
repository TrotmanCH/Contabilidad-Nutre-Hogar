package com.nutrehogar.sistemacontable.application.dto;


import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.DocumentType;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@ToString
@EqualsAndHashCode
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GeneralLedgerDTO {
    Integer journalEntryId;
    LocalDate journalEntryDate;
    String journalEntryName;
    DocumentType ledgerRecordDocumentType;
    Integer accountId;
    AccountType accountType;
    String ledgerRecordReference;
    BigDecimal ledgerRecordDebit;
    BigDecimal ledgerRecordCredit;
    @Setter
    BigDecimal balance;

    public GeneralLedgerDTO(Integer journalEntryId, LocalDate journalEntryDate, String journalEntryName, DocumentType ledgerRecordDocumentType, Integer accountId, AccountType accountType, String ledgerRecordReference, BigDecimal ledgerRecordDebit, BigDecimal ledgerRecordCredit) {
        this.journalEntryId = journalEntryId;
        this.journalEntryDate = journalEntryDate;
        this.journalEntryName = journalEntryName;
        this.ledgerRecordDocumentType = ledgerRecordDocumentType;
        this.accountId = accountId;
        this.accountType = accountType;
        this.ledgerRecordReference = ledgerRecordReference;
        this.ledgerRecordDebit = ledgerRecordDebit;
        this.ledgerRecordCredit = ledgerRecordCredit;
        this.balance = BigDecimal.ZERO;
    }

    public GeneralLedgerDTO(String ledgerRecordReference, BigDecimal ledgerRecordDebit, BigDecimal ledgerRecordCredit, BigDecimal balance) {
        this.ledgerRecordReference = ledgerRecordReference;
        this.ledgerRecordDebit = ledgerRecordDebit;
        this.ledgerRecordCredit = ledgerRecordCredit;
        this.balance = balance;
    }
}