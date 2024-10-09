package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.application.dto.BalanceComprobacionDTO;
import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.dto.LibroMayorDTO;
import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.DetalleAsiento;
import com.nutrehogar.sistemacontable.domain.model.Transaccion;
import com.nutrehogar.sistemacontable.domain.util.filter.BalanceComprobacionFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroMayorFilter;
import com.nutrehogar.sistemacontable.domain.util.order.BalanceComprobacionOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.LibroMayorOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
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
     * @param filters        Criterio de filtrado.
     * @param orderField     Campo por el cual ordenar.
     * @param orderDirection Tipo de ordenamiento (ascendente o descendente).
     * @return Lista de {@code LibroDiarioDTO} que cumplen con los criterios.
     */
    public Optional<List<LibroDiarioDTO>> findLibroDiario(List<LibroDiarioFilter> filters, LibroDiarioOrderField orderField, OrderDirection orderDirection) {
        List<LibroDiarioDTO> libroDiarioDTOS = null;
        Session session = null; // Inicializar la sesión aquí

        try {
            session = HibernateUtil.getSession(); // Obtiene la sesión
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LibroDiarioDTO> cq = cb.createQuery(LibroDiarioDTO.class);// Datos que obtendremos
            Root<Transaccion> transaccion = cq.from(Transaccion.class);// cada query tiene un Root<T> y apunta a la entidad clave de la consulta
            Join<Transaccion, Asiento> asientos = transaccion.join("asientos");//
            Join<Asiento, DetalleAsiento> detallesAsientos = asientos.join("detallesAsientos");
            Join<DetalleAsiento, Cuenta> cuenta = detallesAsientos.join("cuenta");

            // Alias
            Path<LocalDate> fechaPath = transaccion.get("fecha");
            Path<TipoDocumento> tipoDocumentoPath = asientos.get("tipoDocumento");
            Path<String> codigoCuentaPath = cuenta.get("codigoCuenta");
            Path<String> conceptoPath = transaccion.get("concepto");
            Path<BigDecimal> debePath = detallesAsientos.get("debe");
            Path<BigDecimal> haberPath = detallesAsientos.get("haber");

            // Selección de campos para el DTO
            cq.select(cb.construct(LibroDiarioDTO.class, fechaPath, tipoDocumentoPath, codigoCuentaPath, conceptoPath, debePath, haberPath));

            // Aplicar filtros
            List<Predicate> predicates = new ArrayList<>();

            filters.forEach(filter -> {
                if (filter instanceof LibroDiarioFilter.ByFechaRange byFechaRange) {
                    predicates.add(cb.between(fechaPath, byFechaRange.getStartDate(), byFechaRange.getEndDate()));
                } else if (filter instanceof LibroDiarioFilter.ByConcepto byConcepto) {
                    predicates.add(cb.like(cb.lower(conceptoPath), "%" + byConcepto.getConcepto().toLowerCase() + "%"));
                }
            });

// Combina todos los predicados en uno solo
            Predicate predicate = cb.conjunction();
            if (!predicates.isEmpty()) {
                predicate = cb.and(predicates.toArray(new Predicate[0]));
            }

            cq.where(predicate);

            // Aplicar orden
            Path<?> orderPath = switch (orderField) {
                case FECHA -> fechaPath;
                case TIPO_DOCUMENTO -> tipoDocumentoPath;
                case CODIGO_CUENTA -> codigoCuentaPath;
                case CONCEPTO -> conceptoPath;
                case DEBE -> debePath;
                case HABER -> haberPath;
            };

            Order order = orderDirection == OrderDirection.ASCENDING ? cb.asc(orderPath) : cb.desc(orderPath);
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

    /**
     * Busca registros del Libro Mayor aplicando filtros y ordenamientos dinámicos.
     *
     * @param filters        Criterio de filtrado.
     * @param orderField     Campo por el cual ordenar.
     * @param orderDirection Tipo de ordenamiento (ascendente o descendente).
     * @return Lista de {@code LibroMayorDTO} que cumplen con los criterios.
     */
    public Optional<List<LibroMayorDTO>> findLibroMayor(List<LibroMayorFilter> filters, LibroMayorOrderField orderField, OrderDirection orderDirection) {
        List<LibroMayorDTO> libroMayorDTOS = null;
        Session session = null; // Inicializar la sesión aquí

        try {
            session = HibernateUtil.getSession(); // Obtiene la sesión
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LibroMayorDTO> cq = cb.createQuery(LibroMayorDTO.class);
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, DetalleAsiento> detallesAsientos = cuenta.join("detallesAsientos", JoinType.LEFT);
            Join<DetalleAsiento, Asiento> asientos = detallesAsientos.join("asiento");


            // Alias
            Path<String> codigoCuentaPath = cuenta.get("codigoCuenta");
            Path<String> nombreCuentaPath = cuenta.get("nombreCuenta");
            Path<TipoCuenta> tipoCuentaPath = cuenta.get("tipoCuenta");
            Path<BigDecimal> debePath = detallesAsientos.get("debe");
            Path<BigDecimal> haberPath = detallesAsientos.get("haber");
            Path<LocalDate> fechaPath = asientos.get("fechaAsiento");

            // Selección de campos para el DTO
            cq.select(cb.construct(LibroMayorDTO.class, codigoCuentaPath, nombreCuentaPath, tipoCuentaPath, debePath, haberPath));

            List<Predicate> predicates = new ArrayList<>();

            // Aplicar filtros

            filters.forEach(filter -> {
                if (filter instanceof LibroMayorFilter.ByCodigoCuenta byCodigoCuenta) {
                    predicates.add(cb.equal(cuenta.get("codigoCuenta"), byCodigoCuenta.getCodigoCuenta()));
                } else if (filter instanceof LibroMayorFilter.ByNombreCuenta byNombreCuenta) {
                    predicates.add(cb.like(cb.lower(cuenta.get("nombreCuenta")), "%" + byNombreCuenta.getNombreCuenta().toLowerCase() + "%"));
                } else if (filter instanceof LibroMayorFilter.ByFechaRange byFechaRange) {
                    predicates.add(cb.between(fechaPath, byFechaRange.getStartDate(), byFechaRange.getEndDate()));
                } else if (filter instanceof LibroMayorFilter.ByTipoCuenta byTipoCuenta) {
                    predicates.add(cb.equal(tipoCuentaPath, byTipoCuenta.getTipoCuenta()));
                }
            });

            Predicate predicate = cb.conjunction();
            if (!predicates.isEmpty()) {
                predicate = cb.and(predicates.toArray(new Predicate[0]));
            }

            cq.where(predicate);
            // Aplicar orden
            Path<?> orderPath = switch (orderField) {
                case CODIGO_CUENTA -> codigoCuentaPath;
                case NOMBRE_CUENTA -> nombreCuentaPath;
                case TIPO_CUENTA -> tipoCuentaPath;
                case DEBE -> debePath;
                case HABER -> haberPath;
            };

            Order order = orderDirection == OrderDirection.ASCENDING ? cb.asc(orderPath) : cb.desc(orderPath);
            cq.orderBy(order);

            TypedQuery<LibroMayorDTO> query = session.createQuery(cq);
            libroMayorDTOS = query.getResultList();

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
        return Optional.ofNullable(libroMayorDTOS);
    }
    /**
     * Busca registros del Balance de Comprobación aplicando filtros y ordenamientos dinámicos.
     *
     * @param filters Criterio de filtrado.
     * @param orderField Campo por el cual ordenar.
     * @param orderDirection Tipo de ordenamiento (ascendente o descendente).
     * @return Lista de {@code BalanceComprobacionDTO} que cumplen con los criterios.
     */
    public List<BalanceComprobacionDTO> findBalanceComprobacion(List<BalanceComprobacionFilter> filters, BalanceComprobacionOrderField orderField, OrderDirection orderDirection) {

    }
}
