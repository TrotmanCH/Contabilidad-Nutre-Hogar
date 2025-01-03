package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
@NoArgsConstructor(access = AccessLevel.PRIVATE)

public class SubTipoCuentaRepo {
    private static final Session session = HibernateUtil.getSession();

    public static List<SubTipoCuenta> findAll() {
        List<SubTipoCuenta> transaccions = List.of();
        try {
            session.beginTransaction();
            transaccions = session.createQuery("from SubTipoCuenta", SubTipoCuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return transaccions;
    }

    public static SubTipoCuenta findById(String id) {
        return session.find(SubTipoCuenta.class, id);
    }

    public static void save(SubTipoCuenta subTipoCuenta) {
        try {
            session.beginTransaction();
            session.persist(subTipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void save(@NotNull List<SubTipoCuenta> subTipoCuentas) {
        try {
            session.beginTransaction();
            subTipoCuentas.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(SubTipoCuenta subTipoCuenta) {
        try {
            session.beginTransaction();

            session.remove(session.contains(subTipoCuenta) ? subTipoCuenta : session.merge(subTipoCuenta));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void delete(String id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(findById(id)).ifPresent(session::remove);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void update(SubTipoCuenta subTipoCuenta) {
        try {
            session.beginTransaction();
            session.merge(subTipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
