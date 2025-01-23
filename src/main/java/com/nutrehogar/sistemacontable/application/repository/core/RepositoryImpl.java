package com.nutrehogar.sistemacontable.application.repository.core;

import com.nutrehogar.sistemacontable.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@Slf4j
public class RepositoryImpl<T, ID> implements BaseRepository<T, ID> {

    private final Class<T> entityClass;
    private final Session session;

    public RepositoryImpl(Class<T> entityClass, Session session) {
        this.entityClass = entityClass;
        this.session = session;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(session.find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        return executeInTransaction(() ->
                session.createQuery("from " + entityClass.getSimpleName(), entityClass).list()
        );
    }

    @Override
    public void save(T entity) {
        executeInTransaction(() -> session.persist(entity));
    }

    @Override
    public void saveAll(List<T> entities) {
        executeInTransaction(() -> entities.forEach(session::persist));
    }

    @Override
    public void update(T entity) {
        executeInTransaction(() -> session.merge(entity));
    }

    @Override
    public void delete(T entity) {
        executeInTransaction(() ->
                session.remove(session.contains(entity) ? entity : session.merge(entity))
        );
    }

    @Override
    public void deleteById(ID id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public long count() {
        return executeInTransaction(() ->
                 Optional.of(session.createQuery("select count(*) from " + entityClass.getSimpleName(), Long.class)
                        .uniqueResult()).orElse(0L)
        );
    }

    private <R> R executeInTransaction(Supplier<R> operation) {
        try {
            session.beginTransaction();
            R result = operation.get();
            session.getTransaction().commit();
            return result;
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Error en la transacción", e);
            throw new RepositoryException("Error en la transacción", e);
        }
    }

    private void executeInTransaction(Runnable operation) {
        executeInTransaction(() -> {
            operation.run();
            return null;
        });
    }
}