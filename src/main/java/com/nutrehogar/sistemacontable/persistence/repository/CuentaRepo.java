package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
            Transaccions = Collections.emptyList();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public Cuenta findById(String id) {
        return session.find(Cuenta.class, id);
    }

    public void save(Cuenta cuenta) {
        try {
            session.beginTransaction();
            session.persist(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Cuenta> cuentas) {
        try {
            session.beginTransaction();
            cuentas.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Cuenta cuenta) {
        try {
            session.beginTransaction();

            session.remove(session.contains(cuenta) ? cuenta : session.merge(cuenta));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            session.beginTransaction();
            Optional.ofNullable(session.find(Cuenta.class, id)).ifPresent(session::remove);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Cuenta cuenta) {
        try {
            session.beginTransaction();
            session.merge(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
