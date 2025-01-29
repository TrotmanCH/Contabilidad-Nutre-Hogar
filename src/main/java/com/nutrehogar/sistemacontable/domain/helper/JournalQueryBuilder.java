package com.nutrehogar.sistemacontable.domain.helper;

import com.nutrehogar.sistemacontable.application.dto.JournalDTO;
import com.nutrehogar.sistemacontable.domain.model.*;
import com.nutrehogar.sistemacontable.domain.repository.JournalRepositoryImpl;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

public class JournalQueryBuilder {

    private final CriteriaBuilder cb;
    private final CriteriaQuery<JournalDTO> cq;
    private final Root<JournalEntry> journalEntryRoot;
    private final Join<JournalEntry, LedgerRecord> ledgerRecordJoin;
    private final Join<LedgerRecord, Account> accountJoin;

    public JournalQueryBuilder(@NotNull Session session) {
        this.cb = session.getCriteriaBuilder();
        this.cq = cb.createQuery(JournalDTO.class);
        this.journalEntryRoot = cq.from(JournalEntry.class);
        this.ledgerRecordJoin = journalEntryRoot.join("ledgerRecords");
        this.accountJoin = ledgerRecordJoin.join("account");
    }

    public CriteriaQuery<JournalDTO> buildQuery(JournalRepositoryImpl.Field orderField, OrderDirection orderDirection, JournalRepositoryImpl.Filter @NotNull ... filters) {
        // Selección de campos para el DTO
        cq.select(cb.construct(
                JournalDTO.class,
                journalEntryRoot.get("id"),
                journalEntryRoot.get("date"),
                ledgerRecordJoin.get("documentType"),
                accountJoin.get("id"),
                ledgerRecordJoin.get("voucher"),
                ledgerRecordJoin.get("reference"),
                ledgerRecordJoin.get("debit"),
                ledgerRecordJoin.get("credit")
        ));

        // Aplicar filtros
        Predicate predicate = cb.conjunction();
        for (JournalRepositoryImpl.Filter filter : filters) {
            predicate = cb.and(predicate, buildFilterPredicate(filter));
        }
        cq.where(predicate);

        // Aplicar orden
        if (orderField != null) {
            Path<?> orderPath = getOrderPath(orderField);
            if (orderDirection != null) {
                cq.orderBy(orderDirection == OrderDirection.ASCENDING ? cb.asc(orderPath) : cb.desc(orderPath));
            }
        }

        return cq;
    }

    private Predicate buildFilterPredicate(JournalRepositoryImpl.@NotNull Filter filter) {
        return switch (filter) {
            case JournalRepositoryImpl.Filter.ByDateRange date -> date.startDate() != null && date.endDate() != null
                    ? cb.between(journalEntryRoot.get("date"), date.startDate(), date.endDate())
                    : cb.conjunction();
            case JournalRepositoryImpl.Filter.ByReference reference -> reference.value() != null
                    ? cb.like(cb.lower(ledgerRecordJoin.get("reference")), "%" + reference.value().toLowerCase() + "%")
                    : cb.conjunction();
            case JournalRepositoryImpl.Filter.ByVoucher voucher -> voucher.value() != null
                    ? cb.like(cb.lower(ledgerRecordJoin.get("voucher")), "%" + voucher.value().toLowerCase() + "%")
                    : cb.conjunction();
        };
    }

    private Path<?> getOrderPath(JournalRepositoryImpl.@NotNull Field orderField) {
        return switch (orderField) {
            case JOURNAL_DATE -> journalEntryRoot.get("date");
            case JOURNAL_ENTRY_DOCUMENT_TYPE -> ledgerRecordJoin.get("documentType");
            case ACCOUNT_ID -> accountJoin.get("id");
            case LEDGER_RECORD_VOUCHER -> ledgerRecordJoin.get("voucher");
            case LEDGER_RECORD_REFERENCE -> ledgerRecordJoin.get("reference");
            case LEDGER_RECORD_DEBIT -> ledgerRecordJoin.get("debit");
            case LEDGER_RECORD_CREDIT -> ledgerRecordJoin.get("credit");
        };
    }
}