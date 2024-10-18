package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CuentaRepo {
    private static final Session session = HibernateUtil.getSession();
    private static CuentaRepo instance;

    protected CuentaRepo() {
    }

    public static CuentaRepo getInstance() {
        if (instance == null) {
            instance = new CuentaRepo();
        }
        return instance;
    }

    public List<Cuenta> findAll() {
        List<Cuenta> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from Cuenta", Cuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = null;
            e.printStackTrace();
        }
        return Transaccions;
    }

    public Cuenta findById(String id) {
        return session.find(Cuenta.class, id);
    }

    public void save(Cuenta Cuenta) {
        try {
            session.beginTransaction();
            session.save(Cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Cuenta> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Cuenta Cuenta) {
        try {
            session.beginTransaction();

            session.delete(Cuenta);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(String id) {
        Cuenta Cuenta = this.findById(id);
        if (Cuenta != null) {
            delete(Cuenta);
        }
    }

    public void update(Cuenta Cuenta) {
        try {
            session.beginTransaction();
            session.update(Cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
