package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.dto.JournalDTO;
import com.nutrehogar.sistemacontable.application.repository.business.JournalRepository;
import com.nutrehogar.sistemacontable.domain.helper.OrderDirection;
import com.nutrehogar.sistemacontable.domain.core.TransactionManager;
import com.nutrehogar.sistemacontable.domain.helper.JournalQueryBuilder;
import jakarta.persistence.criteria.*;
import lombok.Getter;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

public class JournalRepositoryImpl extends TransactionManager implements JournalRepository {

    public JournalRepositoryImpl(Session session) {
        super(session);
    }

    public @NotNull List<JournalDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<JournalDTO> journalDTOS = List.of();
        if (filters == null || filters.length == 0) return journalDTOS;

        journalDTOS = executeInTransaction(() -> {
            JournalQueryBuilder queryBuilder = new JournalQueryBuilder(getSession());
            CriteriaQuery<JournalDTO> query = queryBuilder.buildQuery(orderField, orderDirection, filters);
            return getSession().createQuery(query).getResultList();
        });

        return journalDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Libro Diario.
     */
    @Getter
    public enum Field {
        JOURNAL_DATE("Fecha"),
        JOURNAL_ENTRY_DOCUMENT_TYPE("Tipo Documento"),
        ACCOUNT_ID("Código Cuenta"),
        LEDGER_RECORD_VOUCHER("Comprobante"),
        LEDGER_RECORD_REFERENCE("Referencia"),
        LEDGER_RECORD_DEBIT("Debe"),
        LEDGER_RECORD_CREDIT("Haber");

        private final String fieldName;

        Field(String fieldName) {
            this.fieldName = fieldName;
        }
    }

    /**
     * Clase sellada que define los criterios de filtrado para el Libro Diario.
     */
    public sealed interface Filter {
        record ByDateRange(LocalDate startDate, LocalDate endDate) implements Filter {
        }

        record ByReference(String value) implements Filter {
        }

        record ByVoucher(String value) implements Filter {
        }
    }
}