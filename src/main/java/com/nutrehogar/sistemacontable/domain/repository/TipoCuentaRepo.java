package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TipoCuentaRepo {
    private static final Session session = HibernateUtil.getSession();
    private static TipoCuentaRepo instance;

    private TipoCuentaRepo() {
    }

    public static TipoCuentaRepo getInstance() {
        if (instance == null) {
            instance = new TipoCuentaRepo();
        }
        return instance;
    }

    public List<TipoCuenta> findAll() {
        List<TipoCuenta> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from TipoCuenta", TipoCuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = Collections.emptyList();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public TipoCuenta findById(Integer id) {
        return session.find(TipoCuenta.class, id);
    }

    public void save(TipoCuenta tipoCuenta) {
        try {
            session.beginTransaction();
            session.persist(tipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<TipoCuenta> tipoCuentas) {
        try {
            session.beginTransaction();
            tipoCuentas.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(TipoCuenta tipoCuenta) {
        try {
            session.beginTransaction();

            session.remove(session.contains(tipoCuenta) ? tipoCuenta : session.merge(tipoCuenta));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(session.find(TipoCuenta.class, id)).ifPresent(session::remove);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }


    public void update(TipoCuenta tipoCuenta) {
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
