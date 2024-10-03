package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.persistence.model.CuentaEntity;
import com.nutrehogar.sistemacontable.persistence.repository.interfaces.ICuentaRepository;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * {@link CuentaHibernateRepository} es una clase de servicio que proporciona métodos para gestionar
 * las operaciones relacionadas con la entidad {@link CuentaEntity}. Esto incluye
 * la creación, obtención, actualización y eliminación de cuentas en la base
 * de datos utilizando Hibernate.
 *
 * <p>
 * La clase utiliza un enfoque de transacción para asegurar la integridad de
 * los datos durante las operaciones CRUD (Crear, Leer, Actualizar, Eliminar).
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * CuentaService cuentaService = new CuentaService();
 *
 * // Crear una nueva cuenta
 * Cuenta nuevaCuenta = new Cuenta();
 * nuevaCuenta.setNoCuenta("001");
 * nuevaCuenta.setNombre("Cuenta de Ahorros");
 * cuentaService.guardarCuenta(nuevaCuenta);
 *
 * // Obtener una cuenta por ID
 * Cuenta cuentaExistente = cuentaService.obtenerCuenta(1);
 *
 * // Actualizar una cuenta existente
 * cuentaExistente.setNombre("Cuenta de Ahorros Actualizada");
 * cuentaService.actualizarCuenta(cuentaExistente);
 *
 * // Borrar una cuenta por ID
 * cuentaService.borrarCuenta(1);
 * </pre>
 */
public class CuentaHibernateRepository implements ICuentaRepository {

    private static CuentaHibernateRepository instance;
    private static final Session session = HibernateUtil.getSession();

    private CuentaHibernateRepository() {
    }

    /**
     * Metodo para optener la instacia unica de esta clase.
     * <p>
     * si se quiere utilizar esta clase no se puede usar {@code new}, se tiene que obtener la instancia a traves de este metodo
     * </p>
     *
     * @return instancia de la clase {@link CuentaHibernateRepository}
     */
    public static CuentaHibernateRepository getInstance() {
        if (instance == null) {
            instance = new CuentaHibernateRepository();
        }
        return instance;
    }

    /**
     * Obtiene una lista con todas la cuentas en la base de datos.
     *
     * @return lista de cuentas.
     */
    @Override
    public List<CuentaEntity> findAll() {
        List<CuentaEntity> cuentas;
        try {
            session.beginTransaction();
            cuentas = session.createQuery("from CuentaEntity ", CuentaEntity.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            cuentas = null;
            e.printStackTrace();
        }
        return cuentas;
    }

    /**
     * Obtiene una cuenta de la base de datos por su ID.
     *
     * @param id El ID de la cuenta a obtener.
     * @return la cuenta optenida.
     */
    @Override
    public CuentaEntity findById(Integer id) {
        return session.find(CuentaEntity.class, id);
    }

    /**
     * Guarda una nueva cuenta en la base de datos.
     *
     * <p>
     * Este método inicia una transacción, guarda la cuenta y confirma la transacción.
     * Si ocurre un error, se revierte la transacción.
     * </p>
     *
     * @param cuenta La cuenta a guardar en la base de datos.
     */
    @Override
    public void save(CuentaEntity cuenta) {
        try {
            session.beginTransaction();
            session.save(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<CuentaEntity> cuentas) {
        cuentas.forEach(this::save);
    }

    /**
     * Borra una cuenta de la base de datos por su ID.
     *
     * <p>
     * Este método inicia una transacción, obtiene la cuenta a eliminar,
     * y si existe, la elimina y confirma la transacción.
     * Si ocurre un error, se revierte la transacción.
     * </p>
     *
     * @param cuenta La cuenta a borrar.
     */
    @Override
    public void delete(CuentaEntity cuenta) {
        try {
            session.beginTransaction();

            session.delete(cuenta);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * Borra una cuenta de la base de datos por su ID.
     *
     * <p>
     * Este método inicia una transacción, obtiene la cuenta a eliminar,
     * y si existe, la elimina y confirma la transacción.
     * Si ocurre un error, se revierte la transacción.
     * </p>
     *
     * @param id El ID de la cuenta a borrar.
     */
    @Override
    public void deleteById(Integer id) {
        CuentaEntity cuenta = this.findById(id);
        if (cuenta != null) {
            delete(cuenta);
        }
    }

    /**
     * Actualiza una cuenta existente en la base de datos.
     *
     * <p>
     * Este método inicia una transacción, actualiza la cuenta y confirma la transacción.
     * Si ocurre un error, se revierte la transacción.
     * </p>
     *
     * @param cuenta La cuenta a actualizar en la base de datos.
     */
    @Override
    public void update(CuentaEntity cuenta) {
        try {
            session.beginTransaction();
            session.update(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
