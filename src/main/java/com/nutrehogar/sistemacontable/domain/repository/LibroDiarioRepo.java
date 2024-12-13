package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
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
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
/**
 * @author Calcifer1331
 */
public class LibroDiarioRepo {
    private static final Session session = HibernateUtil.getSession();

    public static @NotNull List<LibroDiarioDTO> find(Field orderField, OrderDirection orderDirection, Filter... filters) {
        List<LibroDiarioDTO> libroDiarioDTOS = List.of();
        System.out.println(Arrays.toString(filters));
        if (filters == null || filters.length == 0) return libroDiarioDTOS;

        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LibroDiarioDTO> cq = cb.createQuery(LibroDiarioDTO.class);// Datos que obtendremos
            Root<Asiento> asiento = cq.from(Asiento.class);// cada query tiene un Root<T> y apunta a la entidad clave de la consulta
            Join<Asiento, Registro> registro = asiento.join("registros");
            Join<Registro, Cuenta> cuenta = registro.join("cuenta");
            Join<Registro, TipoDocumento> tipoDocumento = registro.join("tipoDocumento");

            // Alias
            Path<LocalDate> fechaPath = asiento.get("fecha");
            Path<String> tipoDocumentoNombrePath = tipoDocumento.get("nombre");
            Path<String> codigoCuentaPath = cuenta.get("id");
            Path<String> comprobantePath = registro.get("comprobante");
            Path<String> referenciaPath = registro.get("referencia");
            Path<BigDecimal> debePath = registro.get("debe");
            Path<BigDecimal> haberPath = registro.get("haber");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    LibroDiarioDTO.class,
                    fechaPath,
                    tipoDocumentoNombrePath,
                    codigoCuentaPath,
                    comprobantePath,
                    referenciaPath,
                    debePath,
                    haberPath));

            Predicate predicate = cb.conjunction();
            for (Filter filter : filters) {
                Predicate filterPredicate = switch (filter) {
                    case Filter.ByFechaRange fecha -> fecha.startDate() != null && fecha.endDate() != null
                            ? cb.between(fechaPath, fecha.startDate(), fecha.endDate())
                            : cb.conjunction();
                    case Filter.ByComprobante comprobante -> comprobante.value() != null
                            ? cb.like(cb.lower(comprobantePath), "%" + comprobante.value().toLowerCase() + "%")
                            : cb.conjunction();
                    case Filter.ByReferencia referencia -> referencia.value() != null
                            ? cb.like(cb.lower(referenciaPath), "%" + referencia.value().toLowerCase() + "%")
                            : cb.conjunction();
                };
                predicate = cb.and(predicate, filterPredicate);
            }
            cq.where(predicate);

            // Aplicar orden
            if (orderField != null) {
                Path<?> orderPath = switch (orderField) {
                    case ASIENTO_FECHA -> fechaPath;
                    case TIPO_DOCUMENTO_NOMBRE -> tipoDocumentoNombrePath;
                    case CUENTA_ID -> codigoCuentaPath;
                    case REGISTRO_COMPROBANTE -> comprobantePath;
                    case REGISTRO_REFERENCIA -> referenciaPath;
                    case REGISTRO_DEBE -> debePath;
                    case REGISTRO_HABER -> haberPath;
                };
                if (orderDirection != null) {
                    cq.orderBy(switch (orderDirection) {
                        case ASCENDING -> cb.asc(orderPath);
                        case DESCENDING -> cb.desc(orderPath);
                    });
                }
            }

            TypedQuery<LibroDiarioDTO> query = session.createQuery(cq);
            libroDiarioDTOS = query.getResultList();

            // Completarmpletar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
            }
            e.printStackTrace();
        }
        return libroDiarioDTOS;
    }

    /**
     * Enum que define los campos por los cuales se puede ordenar el Libro Diario.
     * @author Calcifer1331
     */
    @Getter
    public enum Field {
        ASIENTO_FECHA("Fecha"),
        TIPO_DOCUMENTO_NOMBRE("Tipo Documento"),
        CUENTA_ID("Codigo Cuenta"),
        REGISTRO_COMPROBANTE("Comprobante"),
        REGISTRO_REFERENCIA("Referencia"),
        REGISTRO_DEBE("Debe"),
        REGISTRO_HABER("Haber");
        private final String fieldName;

        /**
         * Constructor de {@code LibroDiarioOrderField}.
         *
         * @param fieldName Nombre del campo en la entidad Transaccion.
         */
        Field(String fieldName) {
            this.fieldName = fieldName;
        }
    }

    /**
     * Clase sellada que define los criterios de filtrado para el Libro Diario.
     * @author Calcifer1331
     */
    public sealed interface Filter {

        /**
         * Filtra el Libro Diario por un rango de fechas.
         */
        record ByFechaRange(LocalDate startDate,
                            LocalDate endDate) implements Filter {
        }

        /**
         * Filtra el Libro Diario por concepto.
         */
        record ByReferencia(String value) implements Filter {
        }

        /**
         * Filtra el Libro Diario por comprobante.
         */

        record ByComprobante(String value) implements Filter {
        }
    }
}
