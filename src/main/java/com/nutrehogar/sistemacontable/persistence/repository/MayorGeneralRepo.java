package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.application.dto.MayorGeneralDTO;
import com.nutrehogar.sistemacontable.domain.model.*;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGeneralFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGeneralOrderField;
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

public class MayorGeneralRepo {
    private static final Session session = HibernateUtil.getSession();
    private static MayorGeneralRepo instance;

    private MayorGeneralRepo() {
    }

    public static MayorGeneralRepo getInstance() {
        if (instance == null) {
            instance = new MayorGeneralRepo();
        }
        return instance;
    }

    public Optional<List<MayorGeneralDTO>> find(List<MayorGeneralFilter> filters, MayorGeneralOrderField orderField, OrderDirection orderDirection) {
        List<MayorGeneralDTO> mayorGeneralDTOS = null;
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MayorGeneralDTO> cq = cb.createQuery(MayorGeneralDTO.class);// Datos que obtendremos
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, SubTipoCuenta> subTipoCuenta = cuenta.join("subTipoCuenta");
            Join<SubTipoCuenta, TipoCuenta> tipoCuenta = subTipoCuenta.join("tipoCuenta");
            Join<Cuenta, Registro> registro = cuenta.join("registros");
            Join<Registro, Asiento> asiento = registro.join("asiento");
            Join<Registro, TipoDocumento> tipoDocumento = registro.join("tipoDocumento");

            // Alias
            Path<LocalDate> fechaPath = asiento.get("fecha");
            Path<String> asientoNombrePath = asiento.get("nombre");
            Path<String> tipoDocumentoNombrePath = tipoDocumento.get("nombre");
            Path<String> nombreCuentaPath = cuenta.get("nombre");
            Path<String> codigoCuentaPath = cuenta.get("id");
            Path<Integer> idTipoCuentaPath = tipoCuenta.get("id");
            Path<String> referenciaPath = registro.get("referencia");
            Path<BigDecimal> debePath = registro.get("debe");
            Path<BigDecimal> haberPath = registro.get("haber");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    MayorGeneralDTO.class,
                    fechaPath,
                    asientoNombrePath,
                    tipoDocumentoNombrePath,
                    codigoCuentaPath,
                    idTipoCuentaPath,
                    referenciaPath,
                    debePath,
                    haberPath
            ));

            if (filters != null && !filters.isEmpty()) {
                List<Predicate> predicates = new ArrayList<>();

                filters.forEach(filter -> {
                    if (filter instanceof MayorGeneralFilter.ByFechaRange byFechaRange) {
                        predicates.add(cb.between(fechaPath, byFechaRange.getStartDate(), byFechaRange.getEndDate()));
                    } else if (filter instanceof MayorGeneralFilter.ByCodigoCuenta byCodigoCuenta) {
                        predicates.add(cb.like(cb.lower(codigoCuentaPath), "%" + byCodigoCuenta.getCodigoCuenta().toLowerCase() + "%"));
                    } else if (filter instanceof MayorGeneralFilter.ByNombreCuenta byNombreCuenta) {
                        predicates.add(cb.like(cb.lower(nombreCuentaPath), "%" + byNombreCuenta.getNombreCuenta().toLowerCase() + "%"));
                    }
                });

                Predicate predicate = cb.conjunction();
                if (!predicates.isEmpty()) {
                    predicate = cb.and(predicates.toArray(new Predicate[0]));
                }

                cq.where(predicate);
            }

            // Aplicar orden
            if (orderField != null) {
                Path<?> orderPath = switch (orderField) {
                    case FECHA -> fechaPath;
                    case TIPO_DOCUMENTO -> tipoDocumentoNombrePath;
                    case CODIGO_CUENTA -> codigoCuentaPath;
                    case REFERENCIA -> referenciaPath;
                    case DEBE -> debePath;
                    case HABER -> haberPath;
                };
                if (orderDirection != null) {
                    cq.orderBy(switch (orderDirection) {
                        case ASCENDING -> cb.asc(orderPath);
                        case DESCENDING -> cb.desc(orderPath);
                    });
                }
            }


            TypedQuery<MayorGeneralDTO> query = session.createQuery(cq);
            mayorGeneralDTOS = query.getResultList();

            // Completarmpletar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
            }
            e.printStackTrace();
        }
        return Optional.ofNullable(mayorGeneralDTOS);
    }
}
