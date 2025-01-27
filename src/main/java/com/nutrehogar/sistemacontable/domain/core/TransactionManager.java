package com.nutrehogar.sistemacontable.domain.core;

import com.nutrehogar.sistemacontable.exception.RepositoryException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import java.util.function.Supplier;

@Slf4j
@Getter
@Setter
public class TransactionManager {
    private final Session session;

    public TransactionManager(final Session session) {
        this.session = session;
    }

    public <R> R executeInTransaction(Supplier<R> operation) {
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

    public void executeInTransaction(Runnable operation) {
        executeInTransaction(() -> {
            operation.run();
            return null;
        });
    }
}
