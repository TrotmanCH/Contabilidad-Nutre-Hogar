package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.repository.business.TrialBalanceRepository;
import com.nutrehogar.sistemacontable.domain.core.TransactionManager;
import com.nutrehogar.sistemacontable.domain.helper.TrialBalanceQueryBuilder;
import lombok.Getter;
import org.hibernate.Session;

import com.nutrehogar.sistemacontable.application.dto.TrialBalanceDTO;
import com.nutrehogar.sistemacontable.domain.helper.OrderDirection;
import jakarta.persistence.criteria.*;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

public class TrialBalanceRepositoryImpl extends TransactionManager implements TrialBalanceRepository {

    public TrialBalanceRepositoryImpl(Session session) {
        super(session);
    }

    public @NotNull List<TrialBalanceDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<TrialBalanceDTO> trialBalanceDTOS = List.of();
        if (filters == null || filters.length == 0) return trialBalanceDTOS;

        trialBalanceDTOS = executeInTransaction(() -> {
            TrialBalanceQueryBuilder queryBuilder = new TrialBalanceQueryBuilder(getSession());
            CriteriaQuery<TrialBalanceDTO> query = queryBuilder.buildQuery(orderField, orderDirection, filters);
            return getSession().createQuery(query).getResultList();
        });

        return trialBalanceDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Balance de Comprobación.
     */
    @Getter
    public enum Field {
        JOURNAL_DATE("Fecha"),
        LEDGE_RECORD_DOCUMENT_TYPE("Tipo Documento"),
        ACCOUNT_ID("Código Cuenta"),
        ACCOUNT_NAME("Nombre Cuenta"),
        LEDGE_RECORD_REFERENCE("Referencia"),
        LEDGE_RECORD_DEBIT("Debe"),
        LEDGE_RECORD_CREDIT("Haber"),
        BALANCE("Saldo");

        private final String fieldName;

        Field(String fieldName) {
            this.fieldName = fieldName;
        }
    }

    /**
     * Clase sellada que define los criterios de filtrado para el Balance de Comprobación.
     */
    public sealed interface Filter {
        record ByDateRange(LocalDate startDate, LocalDate endDate) implements Filter {
        }

        record ByAccountName(String value) implements Filter {
        }

        record ByAccountId(String value) implements Filter {
        }
    }
}