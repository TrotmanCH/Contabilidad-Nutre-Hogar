package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TipoCuentaRepo {
    private static final Session session = HibernateUtil.getSession();

    public static List<TipoCuenta> findAll() {
        List<TipoCuenta> Transaccions = List.of();
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from TipoCuenta", TipoCuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public static TipoCuenta findById(Integer id) {
        return session.find(TipoCuenta.class, id);
    }

    public static void save(TipoCuenta tipoCuenta) {
        try {
            session.beginTransaction();
            session.persist(tipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void save(@NotNull List<TipoCuenta> tipoCuentas) {
        try {
            session.beginTransaction();
            tipoCuentas.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(TipoCuenta tipoCuenta) {
        try {
            session.beginTransaction();

            session.remove(session.contains(tipoCuenta) ? tipoCuenta : session.merge(tipoCuenta));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(session.find(TipoCuenta.class, id)).ifPresent(session::remove);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public static void update(TipoCuenta tipoCuenta) {
        try {
            session.beginTransaction();
            session.merge(tipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
