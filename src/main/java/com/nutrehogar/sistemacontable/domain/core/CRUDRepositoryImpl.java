package com.nutrehogar.sistemacontable.domain.core;

import com.nutrehogar.sistemacontable.application.repository.crud.CRUDRepository;
import com.nutrehogar.sistemacontable.exception.RepositoryException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

public class CRUDRepositoryImpl<T, ID> extends TransactionManager implements CRUDRepository<T, ID> {

    private final Class<T> entityClass;

    public CRUDRepositoryImpl(Class<T> entityClass, Session session) {
        super(session);
        this.entityClass = entityClass;
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(getSession().find(entityClass, id));
    }

    @Override
    public List<T> findAll() {
        return executeInTransaction(() ->
                getSession().createQuery("from " + entityClass.getSimpleName() +" order by id", entityClass).list()
        );
    }

    @Override
    public void save(T entity) {
        executeInTransaction(() -> getSession().persist(entity));
    }

    @Override
    public void saveAll(List<T> entities) {
        executeInTransaction(() -> entities.forEach(getSession()::persist));
    }

    @Override
    public void update(T entity) {
        executeInTransaction(() -> getSession().merge(entity));
    }

    @Override
    public void delete(T entity) {
        executeInTransaction(() ->
                getSession().remove(getSession().contains(entity) ? entity : getSession().merge(entity))
        );
    }

    @Override
    public void deleteById(ID id) {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public long count() {
        return executeInTransaction(() ->
                Optional.of(getSession().createQuery("select count(*) from " + entityClass.getSimpleName(), Long.class)
                        .uniqueResult()).orElse(0L)
        );
    }
}