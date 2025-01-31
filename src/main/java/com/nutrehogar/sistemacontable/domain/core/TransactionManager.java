package com.nutrehogar.sistemacontable.domain.core;

import com.nutrehogar.sistemacontable.exception.RepositoryException;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.OptimisticLockException;
import jakarta.persistence.PersistenceException;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.HibernateException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import java.sql.SQLException;
import java.util.function.Supplier;

@Slf4j
@Getter
@Setter
public class TransactionManager {
    private final Session session;

    public TransactionManager(final Session session) {
        this.session = session;
    }

    public <R> R executeInTransaction(Supplier<R> operation) throws RepositoryException {
        Transaction transaction = session.getTransaction();
        try {
            if (!transaction.isActive()) {
                transaction.begin();
            }

            R result = operation.get();
            transaction.commit();
            return result;

        } catch (Exception e) { // Captura todas las excepciones
            String message;
            if (transaction != null && transaction.isActive()) {
                try {
                    transaction.rollback();
                } catch (Exception rollbackEx) {
                    log.error("Error al intentar hacer rollback de la transacción", rollbackEx);
                }
            }

            message = switch (e) {
                case ConstraintViolationException constraintViolationException ->
                        "Violación de restricción en la base de datos";
                case EntityExistsException entityExistsException -> "La entidad ya existe en la base de datos";
                case ObjectDeletedException objectDeletedException ->
                        "Se intentó operar sobre una entidad ya eliminada";
                case OptimisticLockException optimisticLockException -> "Error de concurrencia detectado";
                case EntityNotFoundException entityNotFoundException -> "Entidad no encontrada";
                case HibernateException hibernateException -> "Problema relacionado con Hibernate";
                case PersistenceException persistenceException -> "Error general de persistencia";
                case IllegalArgumentException illegalArgumentException -> "Argumento ilegal en la operación";
                case NullPointerException nullPointerException -> "Referencia nula detectada";
                default -> "Error inesperado en la transacción";
            };

            log.error(message, e);
            throw new RepositoryException(message, e);
        }
    }

    public void executeInTransaction(Runnable operation) {
        executeInTransaction(() -> {
            operation.run();
            return null;
        });
    }
}
