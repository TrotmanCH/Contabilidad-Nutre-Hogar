package com.nutrehogar.sistemacontable.application.repository.core;

import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Proxy;
import java.util.Objects;

/**
 * Fábrica para crear instancias dinámicas de repositorios que implementan una interfaz específica.
 * Utiliza proxies dinámicos para delegar las llamadas a los métodos de la interfaz a una implementación concreta.
 *
 * <p>Esta clase es útil cuando se desea crear repositorios genéricos en tiempo de ejecución sin necesidad
 * de implementar manualmente cada interfaz de repositorio.</p>
 *
 * <p><b>Uso típico:</b></p>
 * <pre>
 * {@code
 * Session session = HibernateUtil.getSession();
 * AsientoRepository repository = RepositoryFactory.createRepository(AsientoRepository.class, Asiento.class, session);
 * }
 * </pre>
 */
public class RepositoryFactory {

    /**
     * Crea una instancia dinámica de un repositorio que implementa la interfaz especificada.
     * La implementación real de los métodos se delega a una instancia de {@link RepositoryImpl}.
     *
     * @param repositoryInterface La interfaz del repositorio que se desea implementar.
     * @param entityClass         La clase de la entidad gestionada por el repositorio.
     * @param session             La sesión de Hibernate utilizada para las operaciones de base de datos.
     * @param <T>                 El tipo de la entidad gestionada por el repositorio.
     * @param <ID>                El tipo del identificador único de la entidad.
     * @param <R>                 El tipo de la interfaz del repositorio.
     * @return Una instancia dinámica del repositorio que implementa la interfaz especificada.
     * @throws IllegalArgumentException Si alguno de los parámetros es nulo.
     */
    @SuppressWarnings("unchecked")
    public static <T, ID, R extends BaseRepository<T, ID>> @NotNull R createRepository(
            @NotNull Class<R> repositoryInterface,
            @NotNull Class<T> entityClass,
            @NotNull Session session) throws NullPointerException {

        Objects.requireNonNull(repositoryInterface, "La interfaz del repositorio nula.");
        Objects.requireNonNull(entityClass, "La classe del repositorio nula.");
        Objects.requireNonNull(session, "La session del repositorio nula.");

        return (R) Proxy.newProxyInstance(
                repositoryInterface.getClassLoader(),
                new Class<?>[]{repositoryInterface},
                (proxy, method, args) -> {
                    // Implementación dinámica de los métodos
                    RepositoryImpl<T, ID> repositoryImpl = new RepositoryImpl<>(entityClass, session);
                    return method.invoke(repositoryImpl, args);
                }
        );
    }
}