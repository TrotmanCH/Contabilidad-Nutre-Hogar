package com.nutrehogar.sistemacontable.domain.core;

import com.nutrehogar.sistemacontable.application.repository.crud.CRUDRepository;
import com.nutrehogar.sistemacontable.exception.RepositoryException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.OptimisticLockException;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.ObjectDeletedException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;

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
    public Optional<T> findById(ID id) throws RepositoryException {
        return Optional.ofNullable(getSession().find(entityClass, id));
    }

    @Override
    public List<T> findAll() throws RepositoryException {
        return executeInTransaction(() ->
                getSession().createQuery("from " + entityClass.getSimpleName() + " order by id", entityClass).list()
        );
    }

    @Override
    public void save(T entity) throws RepositoryException {
        executeInTransaction(() -> getSession().persist(entity));
    }

    @Override
    public void saveAll(List<T> entities) throws RepositoryException {
        executeInTransaction(() -> entities.forEach(getSession()::persist));
    }

    @Override
    public void update(T entity) throws RepositoryException {
        executeInTransaction(() -> getSession().merge(entity));
    }

    @Override
    public void delete(T entity) throws RepositoryException {
        executeInTransaction(() ->
                getSession().remove(getSession().contains(entity) ? entity : getSession().merge(entity))
        );
    }

    @Override
    public void deleteById(ID id) throws RepositoryException {
        findById(id).ifPresent(this::delete);
    }

    @Override
    public long count() throws RepositoryException {
        return executeInTransaction(() ->
                Optional.of(getSession().createQuery("select count(*) from " + entityClass.getSimpleName(), Long.class)
                        .uniqueResult()).orElse(0L)
        );
    }

    public boolean existsById(ID id) throws RepositoryException {
        return findById(id).isPresent();
    }
}