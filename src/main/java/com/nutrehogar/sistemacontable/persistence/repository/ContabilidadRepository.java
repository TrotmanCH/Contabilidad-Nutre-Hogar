package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.DetalleAsiento;
import com.nutrehogar.sistemacontable.domain.model.Transaccion;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.Optional;

public class ContabilidadRepository {
    private static ContabilidadRepository instance;

    private ContabilidadRepository() {
    }

    public static synchronized ContabilidadRepository getInstance() {
        if (instance == null) {
            instance = new ContabilidadRepository();
        }
        return instance;
    }

//    public Optional<List<LibroDiarioDTO>> getLibroDiario() {
//        List<LibroDiarioDTO> libros = null;
//        Session session = null; // Inicializar la sesión aquí
//
//        try {
//            session = HibernateUtil.getSession(); // Obtiene la sesión
//            session.beginTransaction();
//
//            String hql = "SELECT new com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO(t.fecha, t.concepto, a.fechaAsiento, a.concepto, " +
//                    "d.debe, d.haber) " +
//                    "FROM Transaccion t " +
//                    "JOIN Asiento a ON t.idTransaccion = a.transaccion.id " +
//                    "JOIN DetalleAsiento d ON a.idAsiento = d.asiento.id " +
//                    "ORDER BY t.fecha ASC, a.fechaAsiento ASC";
//
//            Query<LibroDiarioDTO> query = session.createQuery(hql, LibroDiarioDTO.class);
//            libros = query.getResultList();
//
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            if (session != null && session.getTransaction() != null) {
//                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
//            }
//            e.printStackTrace();
//        } finally {
//            if (session != null) {
//                session.close(); // Cierra la sesión manualmente
//            }
//        }
//
//        return Optional.ofNullable(libros).filter(list -> !list.isEmpty());
//    }
//    public Optional<List<LibroMayorDTO>> getLibroMayor() {
//        List<LibroMayorDTO> librosMayor = null;
//
//        try (Session session = HibernateUtil.getSession()) {
//            // Comienza la transacción
//            session.beginTransaction();
//
//            // HQL para obtener el libro mayor agrupando por cuenta, sumando debe y haber
//            String hql = "SELECT new com.nutrehogar.sistemacontable.persistence.LibroMayorDTO( " +
//                    "c.codigoCuenta, c.nombreCuenta, " +
//                    "SUM(d.debe), SUM(d.haber)) " +
//                    "FROM Cuenta c " +
//                    "JOIN DetalleAsiento d ON c.idCuenta = d.cuenta.idCuenta " +
//                    "GROUP BY c.codigoCuenta, c.nombreCuenta " +
//                    "ORDER BY c.codigoCuenta ASC";
//
//            Query<LibroMayorDTO> query = session.createQuery(hql, LibroMayorDTO.class);
//            librosMayor = query.getResultList();
//
//            // Completar la transacción
//            session.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return Optional.ofNullable(librosMayor).filter(list -> !list.isEmpty());
//    }

    /**
     * Busca registros del Libro Diario aplicando filtros y ordenamientos dinámicos.
     *
     * @param filter         Criterio de filtrado.
     * @param orderField     Campo por el cual ordenar.
     * @param orderDirection Tipo de ordenamiento (ascendente o descendente).
     * @return Lista de {@code LibroDiarioDTO} que cumplen con los criterios.
     */
    public Optional<List<LibroDiarioDTO>> findLibroDiario(LibroDiarioFilter filter, LibroDiarioOrderField orderField, OrderDirection orderDirection) {
        List<LibroDiarioDTO> libroDiarioDTOS = null;
        Session session = null; // Inicializar la sesión aquí

        try {
            session = HibernateUtil.getSession(); // Obtiene la sesión
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LibroDiarioDTO> cq = cb.createQuery(LibroDiarioDTO.class);
            Root<Transaccion> transaccion = cq.from(Transaccion.class);
            Join<Transaccion, Asiento> asientos = transaccion.join("asientos");
            Join<Asiento, DetalleAsiento> detallesAsientos = asientos.join("detallesAsientos");
            Join<DetalleAsiento, com.nutrehogar.sistemacontable.domain.model.Cuenta> cuenta = detallesAsientos.join("cuenta");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    LibroDiarioDTO.class,
                    transaccion.get("fecha"),
                    transaccion.get("concepto"),
                    detallesAsientos.get("debe"),
                    detallesAsientos.get("haber")
            ));

            // Aplicar filtros
            Predicate predicate = cb.conjunction();

            if (filter instanceof LibroDiarioFilter.ByFechaRange byFechaRange) {
                predicate = cb.and(predicate,
                        cb.between(transaccion.get("fecha"), byFechaRange.getStartDate(), byFechaRange.getEndDate()));
            } else if (filter instanceof LibroDiarioFilter.ByConcepto byConcepto) {
                predicate = cb.and(predicate,
                        cb.like(cb.lower(transaccion.get("concepto")), "%" + byConcepto.getConcepto().toLowerCase() + "%"));
            }

            cq.where(predicate);

            // Aplicar orden
            Path<?> orderPath;
            switch (orderField) {
                case FECHA:
                    orderPath = transaccion.get("fecha");
                    break;
                case CONCEPTO:
                    orderPath = transaccion.get("concepto");
                    break;
                case DEBE:
                    orderPath = detallesAsientos.get("debe");
                    break;
                case HABER:
                    orderPath = detallesAsientos.get("haber");
                    break;
                default:
                    orderPath = transaccion.get("fecha");
            }

            Order order = orderDirection == OrderDirection.ASCENDING ?
                    cb.asc(orderPath) :
                    cb.desc(orderPath);
            cq.orderBy(order);

            TypedQuery<LibroDiarioDTO> query = session.createQuery(cq);
            libroDiarioDTOS = query.getResultList();

            // Completarmpletar la transacción
            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null && session.getTransaction() != null) {
                session.getTransaction().rollback(); // Deshacer la transacción en caso de error
            }
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close(); // Cierra la sesión manualmente
            }
        }
        return Optional.ofNullable(libroDiarioDTOS);
    }
}
