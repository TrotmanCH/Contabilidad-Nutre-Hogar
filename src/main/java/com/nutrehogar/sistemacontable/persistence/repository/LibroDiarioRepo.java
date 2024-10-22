package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
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

public class LibroDiarioRepo {
    private static final Session session = HibernateUtil.getSession();
    private static LibroDiarioRepo instance;

    protected LibroDiarioRepo() {
    }

    public static LibroDiarioRepo getInstance() {
        if (instance == null) {
            instance = new LibroDiarioRepo();
        }
        return instance;
    }

    public Optional<List<LibroDiarioDTO>> find(List<LibroDiarioFilter> filters, LibroDiarioOrderField orderField, OrderDirection orderDirection) {
        List<LibroDiarioDTO> libroDiarioDTOS = null;


        try {
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LibroDiarioDTO> cq = cb.createQuery(LibroDiarioDTO.class);// Datos que obtendremos
            Root<Asiento> asiento = cq.from(Asiento.class);// cada query tiene un Root<T> y apunta a la entidad clave de la consulta
            Join<Asiento, Registro> registro = asiento.join("registros");
            Join<Registro, Cuenta> cuenta = registro.join("cuenta");
            Join<Asiento, TipoDocumento> tipoDocumento = asiento.join("tipoDocumento");

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

            if (filters != null && !filters.isEmpty()) {
                List<Predicate> predicates = new ArrayList<>();

                filters.forEach(filter -> {
                    if (filter instanceof LibroDiarioFilter.ByFechaRange byFechaRange) {
                        predicates.add(cb.between(fechaPath, byFechaRange.getStarDate(), byFechaRange.getEndDate()));
                    } else if (filter instanceof LibroDiarioFilter.ByComprobante byComprobante) {
                        predicates.add(cb.like(cb.lower(comprobantePath), "%" + byComprobante.getComprobante().toLowerCase() + "%"));
                    } else if (filter instanceof LibroDiarioFilter.ByReferencia byReferencia) {
                        predicates.add(cb.like(cb.lower(referenciaPath), "%" + byReferencia.getReferencia().toLowerCase() + "%"));
                    }
                });

                Predicate predicate = cb.conjunction();
                if (!predicates.isEmpty()) {
                    predicate = cb.and(predicates.toArray(new Predicate[0]));
                }

                cq.where(predicate);
            }

            // Aplicar orden
            Path<?> orderPath = switch (orderField) {
                case FECHA -> fechaPath;
                case TIPO_DOCUMENTO -> tipoDocumentoNombrePath;
                case CODIGO_CUENTA -> codigoCuentaPath;
                case COMPROBANTE -> comprobantePath;
                case REFERENCIA -> referenciaPath;
                case DEBE -> debePath;
                case HABER -> haberPath;
            };
            cq.orderBy(switch (orderDirection) {
                case ASCENDING -> cb.asc(orderPath);
                case DESCENDING -> cb.desc(orderPath);
            });

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
        return Optional.ofNullable(libroDiarioDTOS);
    }
}
