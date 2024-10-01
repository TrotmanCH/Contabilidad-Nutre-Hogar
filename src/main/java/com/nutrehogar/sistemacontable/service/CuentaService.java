package com.nutrehogar.sistemacontable.service;

import com.nutrehogar.sistemacontable.entities.Cuenta;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;


/**
 * CuentaService es una clase de servicio que proporciona métodos para gestionar
 * las operaciones relacionadas con la entidad {@link Cuenta}. Esto incluye
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

public class CuentaService {


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
    public void guardarCuenta(Cuenta cuenta) {
        try {
            HibernateUtil.getSession().beginTransaction();
            HibernateUtil.getSession().save(cuenta);
            HibernateUtil.getSession().getTransaction().commit();
        } catch (Exception e) {
            HibernateUtil.getSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void guardarCuenta(List<Cuenta> listadoCuentas) {
        listadoCuentas.forEach(this::guardarCuenta);
    }


        /**
         * Obtiene una cuenta de la base de datos por su ID.
         *
         * @param id El ID de la cuenta a obtener.
         * @return Un {@code Optinal} que contiene la cuenta correspondiente al ID proporcionado o null si no se encuentra.
         */
    public Optional<Cuenta> obtenerCuenta(Integer id) {
        return Optional.ofNullable(HibernateUtil.getSession().load(Cuenta.class, id));
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
    public void actualizarCuenta(Cuenta cuenta) {
        try {
            HibernateUtil.getSession().beginTransaction();
            HibernateUtil.getSession().update(cuenta);
            HibernateUtil.getSession().getTransaction().commit();
        } catch (Exception e) {
            HibernateUtil.getSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void actualizarCuenta(List<Cuenta> listadoCuentas) {
        listadoCuentas.forEach(this::actualizarCuenta);
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
    public void borrarCuenta(Integer id) {
        try {
            HibernateUtil.getSession().beginTransaction();
            Cuenta cuenta = HibernateUtil.getSession().get(Cuenta.class, id);
            if (cuenta != null) {
                HibernateUtil.getSession().delete(cuenta);
            }
            HibernateUtil.getSession().getTransaction().commit();
        } catch (Exception e) {
            HibernateUtil.getSession().getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void borrarCuenta(List<Integer> listadoId){
        listadoId.forEach(this::borrarCuenta);
    }
}
