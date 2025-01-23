package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.model.*;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
/**
 * @author Jayson
 */
public class BalanceComRepo {
    private static final Logger logger = LoggerFactory.getLogger(BalanceComRepo.class);

    private static final Session session = HibernateUtil.getSession();

    public static List<BalanceComDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<BalanceComDTO> BalanceComDTOS = List.of();
        if (filters == null || filters.length == 0) return BalanceComDTOS;
        System.out.println("orderField: " + orderField);
        System.out.println("orderDirection: " + orderDirection);
        System.out.println("filters: " + Arrays.toString(filters));
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BalanceComDTO> cq = cb.createQuery(BalanceComDTO.class);
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, SubTipoCuenta> subTipoCuenta = cuenta.join("subTipoCuenta");
            Join<SubTipoCuenta, TipoCuenta> tipoCuenta = subTipoCuenta.join("tipoCuenta");
            Join<Cuenta, Registro> registros = cuenta.join("registros");
            Join<Registro, Asiento> asiento = registros.join("asiento");
            Join<Registro, TipoDocumento> tipoDocumento = registros.join("tipoDocumento");

            // Alias
            Path<Integer> asientoIdPath = asiento.get("id");
            Path<BigDecimal> debePath = registros.get("debe");
            Path<BigDecimal> haberPath = registros.get("haber");
            Path<LocalDate> fechaPath = asiento.get("fecha");
            Path<Integer> tipoCuentaIdPath = tipoCuenta.get("id");
            Path<String> tipoDocumentoNombrePath = tipoDocumento.get("nombre");
            Path<String> codigoCuentaPath = cuenta.get("id");
            Path<String> nombreCuentaPath = cuenta.get("nombre");
            Path<String> referenciaPath = registros.get("referencia");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    BalanceComDTO.class,
                    asientoIdPath,
                    fechaPath,
                    tipoDocumentoNombrePath,
                    codigoCuentaPath,
                    nombreCuentaPath,
                    tipoCuentaIdPath,
                    referenciaPath,
                    debePath,
                    haberPath));

            Predicate predicate = cb.conjunction();
            for (Filter filter : filters) {
                Predicate filterPredicate = switch (filter) {
                    case Filter.ByFechaRange fecha -> fecha.startDate() != null && fecha.endDate() != null
                            ? cb.between(fechaPath, fecha.startDate(), fecha.endDate())
                            : cb.conjunction();
                    case Filter.ByNombreCuenta nombre -> nombre.value() != null
                            ? cb.like(cb.lower(nombreCuentaPath), "%" + nombre.value().toLowerCase() + "%")
                            : cb.conjunction();
                    case Filter.ByCodigoCuenta codigo -> codigo.value() != null
                            ? cb.like(cb.lower(codigoCuentaPath), "%" + codigo.value().toLowerCase() + "%")
                            : cb.conjunction();
                };
                predicate = cb.and(predicate, filterPredicate);
            }
            cq.where(predicate);

            // Aplicar orden
            if (orderField != null) {
                Path<?> orderPath = switch (orderField) {
                    case CUENTA_ID -> codigoCuentaPath;
                    case CUENTA_NOMBRE -> nombreCuentaPath;
                    case TIPO_DOCUMENTO_NOMBRE -> tipoDocumentoNombrePath;
                    case REGISTRO_DEBE -> debePath;
                    case REGISTRO_HABER -> haberPath;
                    case ASIENTO_FECHA -> fechaPath;
                    case REGISTRO_REFERENCIA -> referenciaPath;
                    case SALDO -> null;
                };

                if (orderDirection != null) {
                    cq.orderBy(switch (orderDirection) {
                        case ASCENDING -> cb.asc(orderPath);
                        case DESCENDING -> cb.desc(orderPath);
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
            logger.error("Error finding balance com", e);
        }
        return BalanceComDTOS;
    }

    /**
     * @author jayson
     * Enum que define los campos por los cuales se puede ordenar el
     * Balance de Comprobación.
     */
    @Getter
    public enum Field {
        ASIENTO_FECHA("Fecha"),
        TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
        CUENTA_ID("Codigo Cuenta"),
        CUENTA_NOMBRE("Nombre Cuenta"),
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
         * Constructor de {@code BalanceComprobacionOrderField}.
         *
         * @param fieldName Nombre del campo en la entidad Cuenta.
         */
        Field(String fieldName) {
            this.fieldName = fieldName;
        }

    }

    /**
     * Clase sellada que define los criterios de filtrado para el Balance de
     * Comprobación.
     *
     * @author jayson
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
