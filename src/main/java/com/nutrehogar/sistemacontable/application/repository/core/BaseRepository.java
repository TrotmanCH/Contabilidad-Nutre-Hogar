package com.nutrehogar.sistemacontable.application.repository.core;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz base para repositorios que gestionan operaciones CRUD (Crear, Leer, Actualizar, Eliminar)
 * para una entidad específica.
 *
 * @param <T>  El tipo de la entidad gestionada por este repositorio.
 * @param <ID> El tipo del identificador único de la entidad.
 */
public interface BaseRepository<T, ID> {

    /**
     * Busca una entidad por su identificador único.
     *
     * @param id El identificador único de la entidad.
     * @return Un {@link Optional} que contiene la entidad si se encuentra, o vacío si no existe.
     */
    Optional<T> findById(ID id);

    /**
     * Obtiene todas las entidades gestionadas por este repositorio.
     *
     * @return Una lista de todas las entidades. Si no hay entidades, devuelve una lista vacía.
     */
    List<T> findAll();

    /**
     * Guarda una entidad en el repositorio.
     * Si la entidad ya existe, puede lanzar una excepción o actualizarla, dependiendo de la implementación.
     *
     * @param entity La entidad a guardar.
     * @throws IllegalArgumentException Si la entidad es nula.
     */
    void save(T entity);

    /**
     * Guarda una lista de entidades en el repositorio.
     * Si alguna entidad ya existe, puede lanzar una excepción o actualizarla, dependiendo de la implementación.
     *
     * @param entities La lista de entidades a guardar.
     * @throws IllegalArgumentException Si la lista de entidades es nula o contiene elementos nulos.
     */
    void saveAll(List<T> entities);

    /**
     * Actualiza una entidad existente en el repositorio.
     * Si la entidad no existe, puede lanzar una excepción o crearla, dependiendo de la implementación.
     *
     * @param entity La entidad a actualizar.
     * @throws IllegalArgumentException Si la entidad es nula.
     */
    void update(T entity);

    /**
     * Elimina una entidad del repositorio.
     * Si la entidad no existe, puede lanzar una excepción o no hacer nada, dependiendo de la implementación.
     *
     * @param entity La entidad a eliminar.
     * @throws IllegalArgumentException Si la entidad es nula.
     */
    void delete(T entity);

    /**
     * Elimina una entidad del repositorio por su identificador único.
     * Si la entidad no existe, puede lanzar una excepción o no hacer nada, dependiendo de la implementación.
     *
     * @param id El identificador único de la entidad a eliminar.
     * @throws IllegalArgumentException Si el identificador es nulo.
     */
    void deleteById(ID id);

    /**
     * Cuenta el número total de entidades gestionadas por este repositorio.
     *
     * @return El número total de entidades.
     */
    long count();
}