package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.repository.business.DiaryBookRepository;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.core.TransactionManager;
import com.nutrehogar.sistemacontable.domain.model.*;
import jakarta.persistence.criteria.*;
import lombok.Getter;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.List;

public class DiaryBookRepositoryImpl extends TransactionManager implements DiaryBookRepository {

    public DiaryBookRepositoryImpl(Session session) {
        super(session);
    }

    public @NotNull List<LibroDiarioDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<LibroDiarioDTO> libroDiarioDTOS = List.of();
        if (filters == null || filters.length == 0) return libroDiarioDTOS;

        libroDiarioDTOS = executeInTransaction(() -> {
            DiaryBookQueryBuilder queryBuilder = new DiaryBookQueryBuilder(getSession());
            CriteriaQuery<LibroDiarioDTO> query = queryBuilder.buildQuery(orderField, orderDirection, filters);
            return getSession().createQuery(query).getResultList();
        });

        return libroDiarioDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Libro Diario.
     */
    @Getter
    public enum Field {
        ASIENTO_FECHA("Fecha"),
        TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
        CUENTA_ID("Código Cuenta"),
        REGISTRO_COMPROBANTE("Comprobante"),
        REGISTRO_REFERENCIA("Referencia"),
        REGISTRO_DEBE("Debe"),
        REGISTRO_HABER("Haber");

        private final String fieldName;

        Field(String fieldName) {
            this.fieldName = fieldName;
        }
    }

    /**
     * Clase sellada que define los criterios de filtrado para el Libro Diario.
     */
    public sealed interface Filter {
        record ByFechaRange(LocalDate startDate, LocalDate endDate) implements Filter {
        }

        record ByReferencia(String value) implements Filter {
        }

        record ByComprobante(String value) implements Filter {
        }
    }
}