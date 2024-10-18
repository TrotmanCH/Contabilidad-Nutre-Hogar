package com.nutrehogar.sistemacontable.persistence.repository;

/*
import com.nutrehogar.sistemacontable.application.dto.BalanceComprobacionDTO;
import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.dto.LibroMayorDTO;
import com.nutrehogar.sistemacontable.application.dto.MayorGeneralDTO;
import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Transaccion;
import com.nutrehogar.sistemacontable.domain.util.filter.BalanceComprobacionFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroMayorFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGeneralFilter;
import com.nutrehogar.sistemacontable.domain.util.order.*;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
*/
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


    /**
     * Busca registros del Libro Diario aplicando filtros y ordenamientos dinámicos.
     *
     * @param filters        Criterio de filtrado.
     * @param orderField     Campo por el cual ordenar.
     * @param orderDirection Tipo de ordenamiento (ascendente o descendente).
     * @return Lista de {@code LibroDiarioDTO} que cumplen con los criterios.
     */
    /*
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
            Join<Asiento, Cuenta> cuenta = asientos.join("cuenta");

            // Alias
            Path<LocalDate> fechaPath = transaccion.get("fecha");
            Path<TipoDocumento> tipoDocumentoPath = transaccion.get("tipoDocumento");
            Path<String> codigoCuentaPath = cuenta.get("codigoCuenta");
            Path<String> comprobantePath = asientos.get("comprobante");
            Path<String> referenciaPath = asientos.get("referencia");
            Path<BigDecimal> debePath = asientos.get("debe");
            Path<BigDecimal> haberPath = asientos.get("haber");

            // Selección de campos para el DTO
            cq.select(cb.construct(LibroDiarioDTO.class, fechaPath, tipoDocumentoPath, codigoCuentaPath, comprobantePath, referenciaPath, debePath, haberPath));

            // Aplicar filtros
            List<Predicate> predicates = new ArrayList<>();

            filters.forEach(filter -> {
                if (filter instanceof LibroDiarioFilter.ByFechaRange byFechaRange) {
                    predicates.add(cb.between(fechaPath, byFechaRange.getStartDate(), byFechaRange.getEndDate()));
                } else if (filter instanceof LibroDiarioFilter.ByReferencia byReferencia) {
                    predicates.add(cb.like(cb.lower(referenciaPath), "%" + byReferencia.getReferencia().toLowerCase() + "%"));
                }else if (filter instanceof LibroDiarioFilter.ByComprobante byComprobante) {
                    predicates.add(cb.like(cb.lower(comprobantePath), "%" + byComprobante.getComprobante().toLowerCase() + "%"));
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
                case COMPROBANTE -> comprobantePath;
                case REFERENCIA -> referenciaPath;
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
    */
    /**
     * Busca registros del Libro Mayor aplicando filtros y ordenamientos dinámicos.
     *
     * @param filters        Criterio de filtrado.
     * @param orderField     Campo por el cual ordenar.
     * @param orderDirection Tipo de ordenamiento (ascendente o descendente).
     * @return Lista de {@code LibroMayorDTO} que cumplen con los criterios.
     */
    /*
    public Optional<List<LibroMayorDTO>> findLibroMayor(List<LibroMayorFilter> filters, LibroMayorOrderField orderField, OrderDirection orderDirection) {
        List<LibroMayorDTO> libroMayorDTOS = null;
        Session session = null; // Inicializar la sesión aquí

        try {
            session = HibernateUtil.getSession(); // Obtiene la sesión
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<LibroMayorDTO> cq = cb.createQuery(LibroMayorDTO.class);
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, Asiento> asientos = cuenta.join("asientos", JoinType.LEFT);
            Join<Asiento, Transaccion> transaccion = asientos.join("transaccion");


            // Alias
            Path<String> codigoCuentaPath = cuenta.get("codigoCuenta");
            Path<String> nombreCuentaPath = cuenta.get("nombreCuenta");
            Path<TipoCuenta> tipoCuentaPath = cuenta.get("tipoCuenta");
            Path<BigDecimal> debePath = asientos.get("debe");
            Path<BigDecimal> haberPath = asientos.get("haber");
            Path<LocalDate> fechaPath = transaccion.get("fecha");

            // Selección de campos para el DTO
            cq.select(cb.construct(LibroMayorDTO.class, codigoCuentaPath, nombreCuentaPath, tipoCuentaPath, debePath, haberPath));

            List<Predicate> predicates = new ArrayList<>();

            // Aplicar filtros

            filters.forEach(filter -> {
                if (filter instanceof LibroMayorFilter.ByCodigoCuenta byCodigoCuenta) {
                    predicates.add(cb.equal(codigoCuentaPath, byCodigoCuenta.getCodigoCuenta()));
                } else if (filter instanceof LibroMayorFilter.ByNombreCuenta byNombreCuenta) {
                    predicates.add(cb.like(cb.lower(nombreCuentaPath), "%" + byNombreCuenta.getNombreCuenta().toLowerCase() + "%"));
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

    public Optional<List<BalanceComprobacionDTO>> findBalanceComprobacion(List<BalanceComprobacionFilter> filters, BalanceComprobacionOrderField orderField, OrderDirection orderDirection) {
        List<BalanceComprobacionDTO> BalanceComprobacionDTOS = null;
        Session session = null; // Inicializar la sesión aquí

        try {
            session = HibernateUtil.getSession(); // Obtiene la sesión
            session.beginTransaction();
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BalanceComprobacionDTO> cq = cb.createQuery(BalanceComprobacionDTO.class);
            Root<Cuenta> cuenta = cq.from(Cuenta.class);
            Join<Cuenta, Asiento> asientos = cuenta.join("asientos");
            Join<Asiento, Transaccion> transaccion = asientos.join("transaccion");


            // Alias

            Path<BigDecimal> debePath = asientos.get("debe");
            Path<BigDecimal> haberPath = asientos.get("haber");
            Path<LocalDate> fechaPath = transaccion.get("fecha");
            Path<TipoDocumento> tipoDocumentoPath = transaccion.get("tipoDocumento");
            Path<String> codigoCuentaPath = cuenta.get("codigoCuenta");
            Path<String> nombreCuentaPath = cuenta.get("nombreCuenta");
            Path<String> referenciaPath = asientos.get("referencia");
            Path<String> comprobantePath = asientos.get("comprobante");

            // Selección de campos para el DTO
            cq.select(cb.construct(
                    BalanceComprobacionDTO.class,
                    fechaPath,
                    tipoDocumentoPath,
                    codigoCuentaPath,
                    nombreCuentaPath,
                    comprobantePath,
                    referenciaPath,
                    debePath,
                    haberPath));

            List<Predicate> predicates = new ArrayList<>();

            // Aplicar filtros

            filters.forEach(filter -> {
                if (filter instanceof BalanceComprobacionFilter.ByFechaRange byFechaRange) {
                    predicates.add(cb.between(fechaPath, byFechaRange.getStartDate(), byFechaRange.getEndDate()));
                } else if (filter instanceof BalanceComprobacionFilter.ByNombreCuenta byNombreCuenta) {
                    predicates.add(cb.like(cb.lower(nombreCuentaPath), "%" + byNombreCuenta.getNombreCuenta().toLowerCase() + "%"));
                } else if (filter instanceof BalanceComprobacionFilter.ByCodigoCuenta byCodigoCuenta) {
                    predicates.add(cb.like(cb.lower(codigoCuentaPath), "%" + byCodigoCuenta.getCodigoCuenta().toLowerCase() + "%"));
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
                case TIPO_DOCUMENTO -> tipoDocumentoPath;
                case DEBE -> debePath;
                case HABER -> haberPath;
                case FECHA -> fechaPath;
                case REFERENCIA -> referenciaPath;
            };

            Order order = orderDirection == OrderDirection.ASCENDING ? cb.asc(orderPath) : cb.desc(orderPath);
            cq.orderBy(order);

            TypedQuery<BalanceComprobacionDTO> query = session.createQuery(cq);
            BalanceComprobacionDTOS = query.getResultList();

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
        return Optional.ofNullable(BalanceComprobacionDTOS);
    }
    */

}