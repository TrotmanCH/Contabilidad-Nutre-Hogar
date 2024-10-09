package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.Transaccion;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TransaccionRepository {
    private static TransaccionRepository instance;
    private static final Session session = HibernateUtil.getSession();


    private TransaccionRepository() {

    }

    public static TransaccionRepository getInstance() {
        if (instance == null) {
            instance = new TransaccionRepository();
        }
        return instance;
    }

    public List<Transaccion> findAll() {
        List<Transaccion> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from Transaccion", Transaccion.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = null;
            e.printStackTrace();
        }
        return Transaccions;
    }

    public Transaccion findById(Integer id) {
        return session.find(Transaccion.class, id);
    }

    public void save(Transaccion Transaccion) {
        try {
            session.beginTransaction();
            session.save(Transaccion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Transaccion> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Transaccion Transaccion) {
        try {
            session.beginTransaction();

            session.delete(Transaccion);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        Transaccion Transaccion = this.findById(id);
        if (Transaccion != null) {
            delete(Transaccion);
        }
    }

    public void update(Transaccion Transaccion) {
        try {
            session.beginTransaction();
            session.update(Transaccion);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
