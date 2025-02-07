package com.nutrehogar.sistemacontable.domain.helper;

import com.nutrehogar.sistemacontable.application.dto.TrialBalanceDTO;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import com.nutrehogar.sistemacontable.domain.model.JournalEntry;
import com.nutrehogar.sistemacontable.domain.model.LedgerRecord;
import com.nutrehogar.sistemacontable.domain.repository.TrialBalanceRepositoryImpl;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class TrialBalanceQueryBuilder {

    private final CriteriaBuilder cb;
    private final CriteriaQuery<TrialBalanceDTO> cq;
    private final Root<Account> accountRoot;
    private final Join<Account, AccountSubtype> accountSubtype;
    private final Join<Account, LedgerRecord> ledgerRecord;
    private final Join<LedgerRecord, JournalEntry> journalEntry;

    public TrialBalanceQueryBuilder(@NotNull Session session) {
        this.cb = session.getCriteriaBuilder();
        this.cq = cb.createQuery(TrialBalanceDTO.class);
        this.accountRoot = cq.from(Account.class);
        this.accountSubtype = accountRoot.join("accountSubtype");
        this.ledgerRecord = accountRoot.join("ledgerRecords");
        this.journalEntry = ledgerRecord.join("journalEntry");
    }

    public CriteriaQuery<TrialBalanceDTO> buildQuery(TrialBalanceRepositoryImpl.Field orderField, OrderDirection orderDirection, TrialBalanceRepositoryImpl.Filter @NotNull ... filters) {
        // Selección de campos para el DTO
        cq.select(cb.construct(
                TrialBalanceDTO.class,
                journalEntry.get("id"),
                journalEntry.get("date"),
                ledgerRecord.get("documentType"),
                accountRoot.get("id"),
                accountRoot.get("name"),
                accountSubtype.get("accountType"),
                ledgerRecord.get("reference"),
                ledgerRecord.get("debit"),
                ledgerRecord.get("credit")
        ));

        // Aplicar filtros
        Predicate predicate = cb.conjunction();
        for (TrialBalanceRepositoryImpl.Filter filter : filters) {
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

    private Predicate buildFilterPredicate(TrialBalanceRepositoryImpl.@NotNull Filter filter) {
        return switch (filter) {
            case TrialBalanceRepositoryImpl.Filter.ByDateRange date ->
                    date.startDate() != null && date.endDate() != null
                            ? cb.between(journalEntry.get("date"), date.startDate(), date.endDate())
                            : cb.conjunction();
            case TrialBalanceRepositoryImpl.Filter.ByAccountName name -> name.value() != null
                    ? cb.like(cb.lower(accountRoot.get("name")), "%" + name.value().toLowerCase() + "%")
                    : cb.conjunction();
            case TrialBalanceRepositoryImpl.Filter.ByAccountId id -> id.value() != null
                    ? cb.equal(accountRoot.get("id"), id.value())
                    : cb.conjunction();
        };
    }

    private @Nullable Path<?> getOrderPath(TrialBalanceRepositoryImpl.@NotNull Field orderField) {
        return switch (orderField) {
            case JOURNAL_DATE -> journalEntry.get("date");
            case LEDGE_RECORD_DOCUMENT_TYPE -> ledgerRecord.get("documentType");
            case ACCOUNT_ID -> accountRoot.get("id");
            case ACCOUNT_NAME -> accountRoot.get("name");
            case LEDGE_RECORD_REFERENCE -> ledgerRecord.get("reference");
            case LEDGE_RECORD_DEBIT -> ledgerRecord.get("debit");
            case LEDGE_RECORD_CREDIT -> ledgerRecord.get("credit");
            case BALANCE -> null; // No se puede ordenar por saldo directamente
        };
    }
}