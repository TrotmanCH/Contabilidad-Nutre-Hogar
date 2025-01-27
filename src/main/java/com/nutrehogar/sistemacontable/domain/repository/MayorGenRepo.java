package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.application.repository.business.MayorGeneralRepository;
import com.nutrehogar.sistemacontable.domain.MayorGenQueryBuilder;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.core.TransactionManager;
import jakarta.persistence.criteria.*;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Calcifer1331
 */
@Slf4j
public class MayorGenRepo extends TransactionManager implements MayorGeneralRepository {

    public MayorGenRepo(Session session) {
        super(session);
    }

    public @NotNull List<MayorGenDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<MayorGenDTO> mayorGeneralDTOS = List.of();
        if (filters == null || filters.length == 0) return mayorGeneralDTOS;
        mayorGeneralDTOS = executeInTransaction(() -> {
            MayorGenQueryBuilder queryBuilder = new MayorGenQueryBuilder(getSession());
            CriteriaQuery<MayorGenDTO> query = queryBuilder.buildQuery(orderField, orderDirection, filters);
            return getSession().createQuery(query).getResultList();
        });
        return mayorGeneralDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Mayor General.
     */
    @Getter
    public enum Field {
        ASIENTO_FECHA("Fecha"),
        ASIENTO_NOMBRE("Nombre de Asiento"),
        TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
        CUENTA_ID("Código Cuenta"),
        REGISTRO_REFERENCIA("Referencia"),
        REGISTRO_DEBE("Debe"),
        REGISTRO_HABER("Haber"),
        SALDO("Saldo");

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
        record ByCuentaId(String value) implements Filter {
        }

        /**
         * Filtra el Mayor General por nombre de cuenta.
         */
        record ByNombreCuenta(String value) implements Filter {
        }

        /**
         * Filtra el Mayor General por un rango de fechas.
         */
        record ByFechaRange(LocalDate startDate, LocalDate endDate) implements Filter {
        }
    }
}
