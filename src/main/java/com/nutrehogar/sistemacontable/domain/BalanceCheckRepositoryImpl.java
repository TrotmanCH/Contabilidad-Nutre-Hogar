package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.repository.business.BalanceCheckRepository;
import com.nutrehogar.sistemacontable.domain.core.TransactionManager;
import lombok.Getter;
import org.hibernate.Session;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.model.*;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class BalanceCheckRepositoryImpl extends TransactionManager implements BalanceCheckRepository {

    public BalanceCheckRepositoryImpl(Session session) {
        super(session);
    }

    public @NotNull List<BalanceComDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<BalanceComDTO> balanceComDTOS = List.of();
        if (filters == null || filters.length == 0) return balanceComDTOS;

        balanceComDTOS = executeInTransaction(() -> {
            BalanceCheckQueryBuilder queryBuilder = new BalanceCheckQueryBuilder(getSession());
            CriteriaQuery<BalanceComDTO> query = queryBuilder.buildQuery(orderField, orderDirection, filters);
            return getSession().createQuery(query).getResultList();
        });

        return balanceComDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Balance de Comprobación.
     */
    @Getter
    public enum Field {
        ASIENTO_FECHA("Fecha"),
        TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
        CUENTA_ID("Código Cuenta"),
        CUENTA_NOMBRE("Nombre Cuenta"),
        REGISTRO_REFERENCIA("Referencia"),
        REGISTRO_DEBE("Debe"),
        REGISTRO_HABER("Haber"),
        SALDO("Saldo");

        private final String fieldName;

        Field(String fieldName) {
            this.fieldName = fieldName;
        }
    }

    /**
     * Clase sellada que define los criterios de filtrado para el Balance de Comprobación.
     */
    public sealed interface Filter {
        record ByFechaRange(LocalDate startDate, LocalDate endDate) implements Filter {
        }

        record ByNombreCuenta(String value) implements Filter {
        }

        record ByCodigoCuenta(String value) implements Filter {
        }
    }
}