package com.nutrehogar.sistemacontable.application.dto;

/**
 * @author Jayson
 */

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
public class TrialBalanceDTO {
    Integer journalId;
    LocalDate journalDate;
    DocumentType ledgeRecordDocumentType;
    Integer accountId;
    String accountName;
    AccountType accountType;
    String ledgerRecordReference;
    BigDecimal ledgerRecordDebit;
    BigDecimal ledgerRecordCredit;
    @Setter
    BigDecimal balance;

    public TrialBalanceDTO(Integer journalId, LocalDate journalDate, DocumentType ledgeRecordDocumentType, Integer accountId, String accountName, AccountType accountType, String ledgerRecordReference, BigDecimal ledgerRecordDebit, BigDecimal ledgerRecordCredit) {
        this.journalId = journalId;
        this.journalDate = journalDate;
        this.ledgeRecordDocumentType = ledgeRecordDocumentType;
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountType = accountType;
        this.ledgerRecordReference = ledgerRecordReference;
        this.ledgerRecordDebit = ledgerRecordDebit;
        this.ledgerRecordCredit = ledgerRecordCredit;
        this.balance = BigDecimal.ZERO;
    }

    public TrialBalanceDTO(Integer journalId, LocalDate journalDate, DocumentType ledgeRecordDocumentType, Integer accountId, String accountName, AccountType accountType, String ledgerRecordReference, BigDecimal ledgerRecordDebit, BigDecimal ledgerRecordCredit, BigDecimal balance) {
        this.journalId = journalId;
        this.journalDate = journalDate;
        this.ledgeRecordDocumentType = ledgeRecordDocumentType;
        this.accountId = accountId;
        this.accountName = accountName;
        this.accountType = accountType;
        this.ledgerRecordReference = ledgerRecordReference;
        this.ledgerRecordDebit = ledgerRecordDebit;
        this.ledgerRecordCredit = ledgerRecordCredit;
        this.balance = balance;
    }

    public TrialBalanceDTO(String ledgerRecordReference, BigDecimal ledgerRecordDebit, BigDecimal ledgerRecordCredit, BigDecimal balance) {
        this.ledgerRecordReference = ledgerRecordReference;
        this.ledgerRecordDebit = ledgerRecordDebit;
        this.ledgerRecordCredit = ledgerRecordCredit;
        this.balance = balance;
    }
}
