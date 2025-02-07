package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.dto.GeneralLedgerDTO;
import com.nutrehogar.sistemacontable.application.repository.business.GeneralLedgerRepository;
import com.nutrehogar.sistemacontable.domain.core.TransactionManager;
import com.nutrehogar.sistemacontable.domain.helper.GeneralLedgerQueryBuilder;
import com.nutrehogar.sistemacontable.domain.helper.OrderDirection;
import jakarta.persistence.criteria.CriteriaQuery;
import lombok.Getter;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

public class GeneralLedgerRepositoryImpl extends TransactionManager implements GeneralLedgerRepository {

    public GeneralLedgerRepositoryImpl(Session session) {
        super(session);
    }

    public @NotNull List<GeneralLedgerDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<GeneralLedgerDTO> mayorGeneralDTOS = List.of();
        if (filters == null || filters.length == 0) return mayorGeneralDTOS;
        mayorGeneralDTOS = executeInTransaction(() -> {
            GeneralLedgerQueryBuilder queryBuilder = new GeneralLedgerQueryBuilder(getSession());
            CriteriaQuery<GeneralLedgerDTO> query = queryBuilder.buildQuery(orderField, orderDirection, filters);
            return getSession().createQuery(query).getResultList();
        });
        return mayorGeneralDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Mayor General.
     */
    @Getter
    public enum Field {
        JOURNAL_ENTRY_DATE("Fecha"),
        JOURNAL_ENTRY_NAME("Nombre de Asiento"),
        LEDGER_RECORD_DOCUMENT_TYPE("Tipo Documento"),
        ACCOUNT_ID("Código Cuenta"),
        LEDGER_RECORD_REFERENCE("Referencia"),
        LEDGER_RECORD_DEBIT("Debe"),
        LEDGER_RECORD_CREDIT("Haber"),
        BALANCE("Saldo");

        /**
         * -- GETTER --
         * Obtiene el nombre del campo correspondiente en la entidad.
         *
         * @return Nombre del campo.
         */
        private final String fieldName;

        /**
         * Constructor de {@code MayorGeneralOrderField}.
         *
         * @param fieldName Nombre del campo en la entidad.
         */
        Field(String fieldName) {
            this.fieldName = fieldName;
        }

    }

    /**
     * Clase sellada que define los criterios de filtrado para el Mayor General.
     */
    public sealed interface Filter {
        /**
         * Filtra el Mayor General por código de cuenta.
         */
        record ByAccountId(Integer value) implements Filter {
        }

        /**
         * Filtra el Mayor General por nombre de cuenta.
         */
        record ByAccountName(String value) implements Filter {
        }

        /**
         * Filtra el Mayor General por un rango de fechas.
         */
        record ByDateRange(LocalDate startDate, LocalDate endDate) implements Filter {
        }
    }
}
