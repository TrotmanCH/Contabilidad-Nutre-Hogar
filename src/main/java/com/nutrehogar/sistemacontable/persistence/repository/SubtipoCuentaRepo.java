package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.SubtipoCuenta;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

public class SubtipoCuentaRepo {
    private static SubtipoCuentaRepo instance;
    private static final Session session = HibernateUtil.getSession();

    private SubtipoCuentaRepo() {
    }
    public static SubtipoCuentaRepo getInstance() {
        if (instance == null) {
            instance = new SubtipoCuentaRepo();
        }
        return instance;
    }

    public List<SubtipoCuenta> findAll() {
        List<SubtipoCuenta> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from SubtipoCuenta", SubtipoCuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = null;
            e.printStackTrace();
        }
        return Transaccions;
    }
    public SubtipoCuenta findById(String id) {
        return session.find(SubtipoCuenta.class, id);
    }
    public void save(SubtipoCuenta SubtipoCuenta) {
        try {
            session.beginTransaction();
            session.save(SubtipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    public void save(@NotNull List<SubtipoCuenta> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    public void delete(SubtipoCuenta SubtipoCuenta) {
        try {
            session.beginTransaction();

            session.delete(SubtipoCuenta);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
    public void deleteById(String id) {
        SubtipoCuenta SubtipoCuenta = this.findById(id);
        if (SubtipoCuenta != null) {
            delete(SubtipoCuenta);
        }
    }
    public void update(SubtipoCuenta SubtipoCuenta) {
        try {
            session.beginTransaction();
            session.update(SubtipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
