package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.util.filter.BalanceComFilter;
import com.nutrehogar.sistemacontable.domain.util.order.BalanceComField;
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

/**
 * @author Jayson
 */
public class BalanceComRepo {

    private static final Session session = HibernateUtil.getSession();

    public static List<BalanceComDTO> find(BalanceComField orderField, OrderDirection orderDirection, BalanceComFilter... filters) {
        List<BalanceComDTO> BalanceComDTOS = List.of();
        if (filters == null || filters.length == 0) {
            return BalanceComDTOS;
        }
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BalanceComDTO> cq = cb.createQuery(BalanceComDTO.class);
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
                    BalanceComDTO.class,
                    fechaPath,
                    tipoDocumentoNombrePath,
                    codigoCuentaPath,
                    nombreCuentaPath,
                    referenciaPath,
                    debePath,
                    haberPath));

            Predicate predicate = cb.conjunction();
            for (BalanceComFilter filter : filters) {
                Predicate filterPredicate = switch (filter) {
                    case BalanceComFilter.ByFechaRange fecha ->
                        fecha.startDate() != null && fecha.endDate() != null
                        ? cb.between(fechaPath, fecha.startDate(), fecha.endDate())
                        : cb.conjunction();
                    case BalanceComFilter.ByNombreCuenta nombre ->
                        nombre.value() != null
                        ? cb.like(cb.lower(nombreCuentaPath), "%" + nombre.value().toLowerCase() + "%")
                        : cb.conjunction();
                    case BalanceComFilter.ByCodigoCuenta codigo ->
                        codigo.value() != null
                        ? cb.like(cb.lower(codigoCuentaPath), "%" + codigo.value().toLowerCase() + "%")
                        : cb.conjunction();
                };
                predicate = cb.and(predicate, filterPredicate);
            }
            cq.where(predicate);

            // Aplicar orden
            if (orderField != null) {
                Path<?> orderPath = switch (orderField) {
                    case CUENTA_ID ->
                        codigoCuentaPath;
                    case CUENTA_NOMBRE ->
                        nombreCuentaPath;
                    case TIPO_DOCUMENTO_NOMBRE ->
                        tipoDocumentoNombrePath;
                    case REGISTRO_DEBE ->
                        debePath;
                    case REGISTRO_HABER ->
                        haberPath;
                    case ASIENTO_FECHA ->
                        fechaPath;
                    case REGISTRO_REFERENCIA ->
                        referenciaPath;
                };

                if (orderDirection != null) {
                    cq.orderBy(switch (orderDirection) {
                        case ASCENDING ->
                            cb.asc(orderPath);
                        case DESCENDING ->
                            cb.desc(orderPath);
                    });
                }
            }

            TypedQuery<BalanceComDTO> query = session.createQuery(cq);
            BalanceComDTOS = query.getResultList();

            // Completarmpletar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
            }
            e.printStackTrace();
        }
        return BalanceComDTOS;
    }
}
