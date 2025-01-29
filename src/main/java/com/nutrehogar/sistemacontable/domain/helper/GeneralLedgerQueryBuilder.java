package com.nutrehogar.sistemacontable.domain.helper;

import com.nutrehogar.sistemacontable.application.dto.GeneralLedgerDTO;
import com.nutrehogar.sistemacontable.domain.model.*;
import com.nutrehogar.sistemacontable.domain.repository.GeneralLedgerRepositoryImpl;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

public class GeneralLedgerQueryBuilder {

    private final CriteriaBuilder cb;
    private final CriteriaQuery<GeneralLedgerDTO> cq;
    private final Root<Account> accountRoot;
    private final Join<Account, AccountSubtype> accountSubtypeJoin;
    private final Join<Account, LedgerRecord> ledgerRecordJoin;
    private final Join<LedgerRecord, JournalEntry> journalEntryJoin;

    public GeneralLedgerQueryBuilder(@NotNull Session session) {
        this.cb = session.getCriteriaBuilder();
        this.cq = cb.createQuery(GeneralLedgerDTO.class);
        this.accountRoot = cq.from(Account.class);
        this.accountSubtypeJoin = accountRoot.join("accountSubtype");
        this.ledgerRecordJoin = accountRoot.join("ledgerRecords");
        this.journalEntryJoin = ledgerRecordJoin.join("journalEntry");
    }

    public CriteriaQuery<GeneralLedgerDTO> buildQuery(GeneralLedgerRepositoryImpl.Field orderField, OrderDirection orderDirection, GeneralLedgerRepositoryImpl.Filter @NotNull ... filters) {
        // Selección de campos para el DTO
        cq.select(cb.construct(
                GeneralLedgerDTO.class,
                journalEntryJoin.get("id"),
                journalEntryJoin.get("date"),
                journalEntryJoin.get("name"),
                ledgerRecordJoin.get("documentType"),
                accountRoot.get("id"),
                accountSubtypeJoin.get("accountType"),
                ledgerRecordJoin.get("reference"),
                ledgerRecordJoin.get("debit"),
                ledgerRecordJoin.get("credit")
        ));

        // Aplicar filtros
        Predicate predicate = cb.conjunction();
        for (GeneralLedgerRepositoryImpl.Filter filter : filters) {
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

    private Predicate buildFilterPredicate(GeneralLedgerRepositoryImpl.@NotNull Filter filter) {
        return switch (filter) {
            case GeneralLedgerRepositoryImpl.Filter.ByDateRange date ->
                    date.startDate() != null && date.endDate() != null
                            ? cb.between(journalEntryJoin.get("date"), date.startDate(), date.endDate())
                            : cb.conjunction();
            case GeneralLedgerRepositoryImpl.Filter.ByAccountName name -> name.value() != null
                    ? cb.like(cb.lower(accountRoot.get("name")), "%" + name.value().toLowerCase() + "%")
                    : cb.conjunction();
            case GeneralLedgerRepositoryImpl.Filter.ByAccountId id -> id.value() != null
                    ? cb.equal(accountRoot.get("id"), id.value())
                    : cb.conjunction();
        };
    }

    private Path<?> getOrderPath(GeneralLedgerRepositoryImpl.Field orderField) {
        return switch (orderField) {
            case JOURNAL_ENTRY_DATE, BALANCE -> journalEntryJoin.get("date");
            case JOURNAL_ENTRY_NAME -> journalEntryJoin.get("name");
            case LEDGER_RECORD_DOCUMENT_TYPE -> ledgerRecordJoin.get("documentType");
            case ACCOUNT_ID -> accountRoot.get("id");
            case LEDGER_RECORD_REFERENCE -> ledgerRecordJoin.get("reference");
            case LEDGER_RECORD_DEBIT -> ledgerRecordJoin.get("debit");
            case LEDGER_RECORD_CREDIT -> ledgerRecordJoin.get("credit");
        };
    }
}