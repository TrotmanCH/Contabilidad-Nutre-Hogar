package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

public class TipoCuentaRepo {
    private static TipoCuentaRepo instance;
    private static final Session session = HibernateUtil.getSession();

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
            Transaccions = null;
            e.printStackTrace();
        }
        return Transaccions;
    }
    public TipoCuenta findById(Integer id) {
        return session.find(TipoCuenta.class, id);
    }
    public void save(TipoCuenta TipoCuenta) {
        try {
            session.beginTransaction();
            session.save(TipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    public void save(@NotNull List<TipoCuenta> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    public void delete(TipoCuenta TipoCuenta) {
        try {
            session.beginTransaction();

            session.delete(TipoCuenta);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void deleteById(Integer id) {
        TipoCuenta TipoCuenta = this.findById(id);
        if (TipoCuenta != null) {
            delete(TipoCuenta);
        }
    }
    public void update(TipoCuenta TipoCuenta) {
        try {
            session.beginTransaction();
            session.update(TipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
