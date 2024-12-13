package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.model.*;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Calcifer1331
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MayorGenRepo {
    private static final Session session = HibernateUtil.getSession();

    public static @NotNull List<MayorGenDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<MayorGenDTO> mayorGeneralDTOS = List.of();
        System.out.println(filters);
        if (filters == null || filters.length == 0) return mayorGeneralDTOS;
        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<MayorGenDTO> cq = cb.createQuery(MayorGenDTO.class);// Datos que obtendremos
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, SubTipoCuenta> subTipoCuenta = cuenta.join("subTipoCuenta");
            Join<SubTipoCuenta, TipoCuenta> tipoCuenta = subTipoCuenta.join("tipoCuenta");
            Join<Cuenta, Registro> registro = cuenta.join("registros");
            Join<Registro, Asiento> asiento = registro.join("asiento");
            Join<Registro, TipoDocumento> tipoDocumento = registro.join("tipoDocumento");

            // Alias
            Path<LocalDate> asientoFechaPath = asiento.get("fecha");
            Path<String> asientoNombrePath = asiento.get("nombre");
            Path<String> tipoDocumentoNombrePath = tipoDocumento.get("nombre");
            Path<String> cuentaNombrePath = cuenta.get("nombre");
            Path<String> cuentaIdPath = cuenta.get("id");
            Path<Integer> tipoCuentaIdPath = tipoCuenta.get("id");
            Path<String> registroReferenciaPath = registro.get("referencia");
            Path<BigDecimal> registroDebePath = registro.get("debe");
            Path<BigDecimal> registroHaberPath = registro.get("haber");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    MayorGenDTO.class,
                    asientoFechaPath,
                    asientoNombrePath,
                    tipoDocumentoNombrePath,
                    cuentaIdPath,
                    tipoCuentaIdPath,
                    registroReferenciaPath,
                    registroDebePath,
                    registroHaberPath
            ));

            Predicate predicate = cb.conjunction();
            for (Filter filter : filters) {
                Predicate filterPredicate = switch (filter) {
                    case Filter.ByFechaRange fecha -> fecha.startDate() != null && fecha.endDate() != null
                            ? cb.between(asientoFechaPath, fecha.startDate(), fecha.endDate())
                            : cb.conjunction();
                    case Filter.ByNombreCuenta nombre -> nombre.value() != null
                            ? cb.like(cb.lower(cuentaNombrePath), "%" + nombre.value().toLowerCase() + "%")
                            : cb.conjunction();
                    case Filter.ByCuentaId cuentaId -> cuentaId.value() != null
                            ? cb.like(cb.lower(cuentaIdPath), "%" + cuentaId.value().toLowerCase() + "%")
                            : cb.conjunction();
                };
                predicate = cb.and(predicate, filterPredicate); // Combina con el acumulador
            }
            cq.where(predicate);

            // Aplicar orden
            if (orderField != null) {
                Path<?> orderPath = switch (orderField) {
                    case ASIENTO_FECHA, SALDO -> asientoFechaPath;
                    case ASIENTO_NOMBRE -> asientoNombrePath;
                    case TIPO_DOCUMENTO_NOMBRE -> tipoDocumentoNombrePath;
                    case CUENTA_ID -> cuentaIdPath;
                    case REGISTRO_REFERENCIA -> registroReferenciaPath;
                    case REGISTRO_DEBE -> registroDebePath;
                    case REGISTRO_HABER -> registroHaberPath;
                };
                if (orderDirection != null) {
                    cq.orderBy(switch (orderDirection) {
                        case ASCENDING -> cb.asc(orderPath);
                        case DESCENDING -> cb.desc(orderPath);
                    });
                }
            }


            TypedQuery<MayorGenDTO> query = session.createQuery(cq);
            mayorGeneralDTOS = query.getResultList();

            // Completarmpletar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
            }
            e.printStackTrace();
        }
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
