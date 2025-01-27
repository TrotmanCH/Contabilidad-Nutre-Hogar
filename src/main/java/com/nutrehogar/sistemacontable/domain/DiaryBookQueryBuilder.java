package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.model.*;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.time.LocalDate;

public class DiaryBookQueryBuilder {

    private final CriteriaBuilder cb;
    private final CriteriaQuery<LibroDiarioDTO> cq;
    private final Root<Asiento> asiento;
    private final Join<Asiento, Registro> registro;
    private final Join<Registro, Cuenta> cuenta;
    private final Join<Registro, TipoDocumento> tipoDocumento;

    public DiaryBookQueryBuilder(Session session) {
        this.cb = session.getCriteriaBuilder();
        this.cq = cb.createQuery(LibroDiarioDTO.class);
        this.asiento = cq.from(Asiento.class);
        this.registro = asiento.join("registros");
        this.cuenta = registro.join("cuenta");
        this.tipoDocumento = registro.join("tipoDocumento");
    }

    public CriteriaQuery<LibroDiarioDTO> buildQuery(DiaryBookRepositoryImpl.Field orderField, OrderDirection orderDirection, DiaryBookRepositoryImpl.Filter... filters) {
        // Selección de campos para el DTO
        cq.select(cb.construct(
                LibroDiarioDTO.class,
                asiento.get("id"),
                asiento.get("fecha"),
                tipoDocumento.get("nombre"),
                cuenta.get("id"),
                registro.get("comprobante"),
                registro.get("referencia"),
                registro.get("debe"),
                registro.get("haber")
        ));

        // Aplicar filtros
        Predicate predicate = cb.conjunction();
        for (DiaryBookRepositoryImpl.Filter filter : filters) {
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

    private Predicate buildFilterPredicate(DiaryBookRepositoryImpl.Filter filter) {
        return switch (filter) {
            case DiaryBookRepositoryImpl.Filter.ByFechaRange fecha ->
                    fecha.startDate() != null && fecha.endDate() != null
                            ? cb.between(asiento.get("fecha"), fecha.startDate(), fecha.endDate())
                            : cb.conjunction();
            case DiaryBookRepositoryImpl.Filter.ByReferencia referencia -> referencia.value() != null
                    ? cb.like(cb.lower(registro.get("referencia")), "%" + referencia.value().toLowerCase() + "%")
                    : cb.conjunction();
            case DiaryBookRepositoryImpl.Filter.ByComprobante comprobante -> comprobante.value() != null
                    ? cb.like(cb.lower(registro.get("comprobante")), "%" + comprobante.value().toLowerCase() + "%")
                    : cb.conjunction();
        };
    }

    private Path<?> getOrderPath(DiaryBookRepositoryImpl.Field orderField) {
        return switch (orderField) {
            case ASIENTO_FECHA -> asiento.get("fecha");
            case TIPO_DOCUMENTO_NOMBRE -> tipoDocumento.get("nombre");
            case CUENTA_ID -> cuenta.get("id");
            case REGISTRO_COMPROBANTE -> registro.get("comprobante");
            case REGISTRO_REFERENCIA -> registro.get("referencia");
            case REGISTRO_DEBE -> registro.get("debe");
            case REGISTRO_HABER -> registro.get("haber");
        };
    }
}