package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.application.dto.BalanceComprobacionDTO;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.util.filter.BalanceComprobacionFilter;
import com.nutrehogar.sistemacontable.domain.util.order.BalanceComprobacionOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BalanceComprobacionRepo {
    private static final Session session = HibernateUtil.getSession();
    private static BalanceComprobacionRepo instance;

    private BalanceComprobacionRepo() {
    }

    public static BalanceComprobacionRepo getInstance() {
        if (instance == null) {
            instance = new BalanceComprobacionRepo();
        }
        return instance;
    }

    public Optional<List<BalanceComprobacionDTO>> find(List<BalanceComprobacionFilter> filters, BalanceComprobacionOrderField orderField, OrderDirection orderDirection) {
        List<BalanceComprobacionDTO> BalanceComprobacionDTOS = null;

        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BalanceComprobacionDTO> cq = cb.createQuery(BalanceComprobacionDTO.class);
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, Registro> registros = cuenta.join("registros");
            Join<Registro, Asiento> asiento = registros.join("asiento");
            Join<Registro, TipoDocumento> tipoDocumento = registros.join("tipoDocumento");


            // Alias

            Path<BigDecimal> debePath = registros.get("debe");
            Path<BigDecimal> haberPath = registros.get("haber");
            Path<LocalDate> fechaPath = asiento.get("fecha");
            Path<String> tipoDocumentoNombrePath = tipoDocumento.get("nombre");
            Path<String> codigoCuentaPath = cuenta.get("id");
            Path<String> nombreCuentaPath = cuenta.get("nombre");
            Path<String> referenciaPath = registros.get("referencia");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    BalanceComprobacionDTO.class,
                    fechaPath,
                    tipoDocumentoNombrePath,
                    codigoCuentaPath,
                    nombreCuentaPath,
                    referenciaPath,
                    debePath,
                    haberPath));

            if (filters != null && !filters.isEmpty()) {
                List<Predicate> predicates = new ArrayList<>();

//                filters.forEach(filter -> {
//                    if (filter instanceof BalanceComprobacionFilter.ByFechaRange byFechaRange) {
//                        predicates.add(cb.between(fechaPath, byFechaRange.getStartDate(), byFechaRange.getEndDate()));
//                    } else if (filter instanceof BalanceComprobacionFilter.ByNombreCuenta byNombreCuenta) {
//                        predicates.add(cb.like(cb.lower(nombreCuentaPath), "%" + byNombreCuenta.getNombreCuenta().toLowerCase() + "%"));
//                    } else if (filter instanceof BalanceComprobacionFilter.ByCodigoCuenta byCodigoCuenta) {
//                        predicates.add(cb.like(cb.lower(codigoCuentaPath), "%" + byCodigoCuenta.getCodigoCuenta().toLowerCase() + "%"));
//                    }
//                });

                Predicate predicate = cb.conjunction();
                if (!predicates.isEmpty()) {
                    predicate = cb.and(predicates.toArray(new Predicate[0]));
                }

                cq.where(predicate);
            }

            // Aplicar orden
            if (orderField != null) {
                Path<?> orderPath = switch (orderField) {
                    case CODIGO_CUENTA -> codigoCuentaPath;
                    case NOMBRE_CUENTA -> nombreCuentaPath;
                    case TIPO_DOCUMENTO -> tipoDocumentoNombrePath;
                    case DEBE -> debePath;
                    case HABER -> haberPath;
                    case FECHA -> fechaPath;
                    case REFERENCIA -> referenciaPath;
                };

                if (orderDirection != null) {
                    cq.orderBy(switch (orderDirection) {
                        case ASCENDING -> cb.asc(orderPath);
                        case DESCENDING -> cb.desc(orderPath);
                    });
                }
            }


            TypedQuery<BalanceComprobacionDTO> query = session.createQuery(cq);
            BalanceComprobacionDTOS = query.getResultList();

            // Completarmpletar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
            }
            e.printStackTrace();
        }
        return Optional.ofNullable(BalanceComprobacionDTOS);
    }
}
