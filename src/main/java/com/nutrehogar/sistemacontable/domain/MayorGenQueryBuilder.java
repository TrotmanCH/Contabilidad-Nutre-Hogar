package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.model.*;
import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.MayorGenRepo;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

public class MayorGenQueryBuilder {

    private final CriteriaBuilder cb;
    private final CriteriaQuery<MayorGenDTO> cq;
    private final Root<Cuenta> cuenta;
    private final Join<Cuenta, SubTipoCuenta> subTipoCuenta;
    private final Join<SubTipoCuenta, TipoCuenta> tipoCuenta;
    private final Join<Cuenta, Registro> registro;
    private final Join<Registro, Asiento> asiento;
    private final Join<Registro, TipoDocumento> tipoDocumento;

    public MayorGenQueryBuilder(Session session) {
        this.cb = session.getCriteriaBuilder();
        this.cq = cb.createQuery(MayorGenDTO.class);
        this.cuenta = cq.from(Cuenta.class);
        this.subTipoCuenta = cuenta.join("subTipoCuenta");
        this.tipoCuenta = subTipoCuenta.join("tipoCuenta");
        this.registro = cuenta.join("registros");
        this.asiento = registro.join("asiento");
        this.tipoDocumento = registro.join("tipoDocumento");
    }

    public CriteriaQuery<MayorGenDTO> buildQuery(MayorGenRepo.Field orderField, OrderDirection orderDirection, MayorGenRepo.Filter... filters) {
        // Selección de campos para el DTO
        cq.select(cb.construct(
                MayorGenDTO.class,
                asiento.get("id"),
                asiento.get("fecha"),
                asiento.get("nombre"),
                tipoDocumento.get("nombre"),
                cuenta.get("id"),
                tipoCuenta.get("id"),
                registro.get("referencia"),
                registro.get("debe"),
                registro.get("haber")
        ));

        // Aplicar filtros
        Predicate predicate = cb.conjunction();
        for (MayorGenRepo.Filter filter : filters) {
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

    private Predicate buildFilterPredicate(MayorGenRepo.Filter filter) {
        return switch (filter) {
            case MayorGenRepo.Filter.ByFechaRange fecha -> fecha.startDate() != null && fecha.endDate() != null
                    ? cb.between(asiento.get("fecha"), fecha.startDate(), fecha.endDate())
                    : cb.conjunction();
            case MayorGenRepo.Filter.ByNombreCuenta nombre -> nombre.value() != null
                    ? cb.like(cb.lower(cuenta.get("nombre")), "%" + nombre.value().toLowerCase() + "%")
                    : cb.conjunction();
            case MayorGenRepo.Filter.ByCuentaId cuentaId -> cuentaId.value() != null
                    ? cb.like(cb.lower(cuenta.get("id")), "%" + cuentaId.value().toLowerCase() + "%")
                    : cb.conjunction();
        };
    }

    private Path<?> getOrderPath(MayorGenRepo.Field orderField) {
        return switch (orderField) {
            case ASIENTO_FECHA, SALDO -> asiento.get("fecha");
            case ASIENTO_NOMBRE -> asiento.get("nombre");
            case TIPO_DOCUMENTO_NOMBRE -> tipoDocumento.get("nombre");
            case CUENTA_ID -> cuenta.get("id");
            case REGISTRO_REFERENCIA -> registro.get("referencia");
            case REGISTRO_DEBE -> registro.get("debe");
            case REGISTRO_HABER -> registro.get("haber");
        };
    }
}