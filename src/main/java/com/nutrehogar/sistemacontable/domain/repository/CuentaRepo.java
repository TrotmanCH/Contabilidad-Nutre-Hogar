package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CuentaRepo {

    private static final Logger logger = LoggerFactory.getLogger(CuentaRepo.class);


    private static final Session session = HibernateUtil.getSession();

    public static List<Cuenta> findAll() {
        List<Cuenta> transaccions = List.of();
        try {
            session.beginTransaction();
            transaccions = session.createQuery("from Cuenta", Cuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al consultar los cuentas", e);
        }
        return transaccions;
    }

    public static Cuenta findById(String id) {
        return session.find(Cuenta.class, id);
    }

    public static void save(Cuenta cuenta) {
        try {
            session.beginTransaction();
            session.persist(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al guardar los cuentas", e);
        }
    }

    public static void save(@NotNull List<Cuenta> cuentas) {
        try {
            session.beginTransaction();
            cuentas.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al guardar los cuentas", e);
        }
    }

    public static void delete(Cuenta cuenta) {
        try {
            session.beginTransaction();

            session.remove(session.contains(cuenta) ? cuenta : session.merge(cuenta));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al eliminar los cuentas", e);
        }
    }

    public static void delete(String id) {
        try {
            session.beginTransaction();
            Optional.ofNullable(session.find(Cuenta.class, id)).ifPresent(session::remove);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al eliminar los cuentas", e);
        }
    }

    public static void update(Cuenta cuenta) {
        try {
            session.beginTransaction();
            session.merge(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al actualizar los cuentas", e);
        }
    }
}
