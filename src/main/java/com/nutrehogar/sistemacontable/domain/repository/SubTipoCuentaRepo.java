package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class SubTipoCuentaRepo {
    private static final Session session = HibernateUtil.getSession();
    private static SubTipoCuentaRepo instance;

    private SubTipoCuentaRepo() {
    }

    public static SubTipoCuentaRepo getInstance() {
        if (instance == null) {
            instance = new SubTipoCuentaRepo();
        }
        return instance;
    }

    public List<SubTipoCuenta> findAll() {
        List<SubTipoCuenta> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from SubTipoCuenta", SubTipoCuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = Collections.emptyList();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public SubTipoCuenta findById(String id) {
        return session.find(SubTipoCuenta.class, id);
    }

    public void save(SubTipoCuenta subTipoCuenta) {
        try {
            session.beginTransaction();
            session.persist(subTipoCuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<SubTipoCuenta> subTipoCuentas) {
        try {
            session.beginTransaction();
            subTipoCuentas.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(SubTipoCuenta subTipoCuenta) {
        try {
            session.beginTransaction();

            session.remove(session.contains(subTipoCuenta) ? subTipoCuenta : session.merge(subTipoCuenta));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(findById(id)).ifPresent(session::remove);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(SubTipoCuenta subTipoCuenta) {
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
