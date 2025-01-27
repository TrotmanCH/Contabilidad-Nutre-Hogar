package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.model.*;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.time.LocalDate;

public class BalanceCheckQueryBuilder {

    private final CriteriaBuilder cb;
    private final CriteriaQuery<BalanceComDTO> cq;
    private final Root<Cuenta> cuenta;
    private final Join<Cuenta, SubTipoCuenta> subTipoCuenta;
    private final Join<SubTipoCuenta, TipoCuenta> tipoCuenta;
    private final Join<Cuenta, Registro> registros;
    private final Join<Registro, Asiento> asiento;
    private final Join<Registro, TipoDocumento> tipoDocumento;

    public BalanceCheckQueryBuilder(Session session) {
        this.cb = session.getCriteriaBuilder();
        this.cq = cb.createQuery(BalanceComDTO.class);
        this.cuenta = cq.from(Cuenta.class);
        this.subTipoCuenta = cuenta.join("subTipoCuenta");
        this.tipoCuenta = subTipoCuenta.join("tipoCuenta");
        this.registros = cuenta.join("registros");
        this.asiento = registros.join("asiento");
        this.tipoDocumento = registros.join("tipoDocumento");
    }

    public CriteriaQuery<BalanceComDTO> buildQuery(BalanceCheckRepositoryImpl.Field orderField, OrderDirection orderDirection, BalanceCheckRepositoryImpl.Filter... filters) {
        // Selección de campos para el DTO
        cq.select(cb.construct(
                BalanceComDTO.class,
                asiento.get("id"),
                asiento.get("fecha"),
                tipoDocumento.get("nombre"),
                cuenta.get("id"),
                cuenta.get("nombre"),
                tipoCuenta.get("id"),
                registros.get("referencia"),
                registros.get("debe"),
                registros.get("haber")
        ));

        // Aplicar filtros
        Predicate predicate = cb.conjunction();
        for (BalanceCheckRepositoryImpl.Filter filter : filters) {
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

    private Predicate buildFilterPredicate(BalanceCheckRepositoryImpl.Filter filter) {
        return switch (filter) {
            case BalanceCheckRepositoryImpl.Filter.ByFechaRange fecha -> fecha.startDate() != null && fecha.endDate() != null
                    ? cb.between(asiento.get("fecha"), fecha.startDate(), fecha.endDate())
                    : cb.conjunction();
            case BalanceCheckRepositoryImpl.Filter.ByNombreCuenta nombre -> nombre.value() != null
                    ? cb.like(cb.lower(cuenta.get("nombre")), "%" + nombre.value().toLowerCase() + "%")
                    : cb.conjunction();
            case BalanceCheckRepositoryImpl.Filter.ByCodigoCuenta codigo -> codigo.value() != null
                    ? cb.like(cb.lower(cuenta.get("id")), "%" + codigo.value().toLowerCase() + "%")
                    : cb.conjunction();
        };
    }

    private Path<?> getOrderPath(BalanceCheckRepositoryImpl.Field orderField) {
        return switch (orderField) {
            case ASIENTO_FECHA -> asiento.get("fecha");
            case TIPO_DOCUMENTO_NOMBRE -> tipoDocumento.get("nombre");
            case CUENTA_ID -> cuenta.get("id");
            case CUENTA_NOMBRE -> cuenta.get("nombre");
            case REGISTRO_REFERENCIA -> registros.get("referencia");
            case REGISTRO_DEBE -> registros.get("debe");
            case REGISTRO_HABER -> registros.get("haber");
            case SALDO -> null; // No se puede ordenar por saldo directamente
        };
    }
}