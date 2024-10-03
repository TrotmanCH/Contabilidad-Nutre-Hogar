package com.nutrehogar.sistemacontable.persistence.repository.interfaces;

import com.nutrehogar.sistemacontable.persistence.model.CuentaEntity;

import java.util.List;

/**
 * {@link ICuentaRepository} es una interfaz que proporciona métodos para gestionar las operaciones relacionadas con {@link CuentaEntity}. Esto incluye la creación, obtención, actualización y eliminación de cuentas en la base de datos.
 */
public interface ICuentaRepository {
    /**
     * Optiene una lista de cuentas de la base de datos.
     *
     * @return la lista de cuentas optenidas de la base de datos.
     */
    List<CuentaEntity> findAll();

    CuentaEntity findById(Integer id);

    /**
     * Guarda una nueva cuenta en la base de datos.
     *
     * @param cuenta La cuenta a guardar en la base de datos.
     */
    void save(CuentaEntity cuenta);

    /**
     * Borra una cuenta de la base de datos.
     *
     * @param cuenta La cuenta a borrar de la base de datos.
     */
    void delete(CuentaEntity cuenta);

    /**
     * Borra una cuenta de la base de datos por su ID.
     *
     * @param id El ID de la cuenta a borrar.
     */
    void deleteById(Integer id);

    /**
     * Actualiza una cuenta existente en la base de datos.
     *
     * @param cuenta La cuenta a actualizar en la base de datos.
     */
    void update(CuentaEntity cuenta);
}
