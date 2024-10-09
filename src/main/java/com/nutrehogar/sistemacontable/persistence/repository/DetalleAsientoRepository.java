package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.DetalleAsiento;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DetalleAsientoRepository {
    private static DetalleAsientoRepository instance;
    private static final Session session = HibernateUtil.getSession();


    private DetalleAsientoRepository() {

    }

    public static DetalleAsientoRepository getInstance() {
        if (instance == null) {
            instance = new DetalleAsientoRepository();
        }
        return instance;
    }

    public List<DetalleAsiento> findAll() {
        List<DetalleAsiento> DetalleAsientos;
        try {
            session.beginTransaction();
            DetalleAsientos = session.createQuery("from DetalleAsiento", DetalleAsiento.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            DetalleAsientos = null;
            e.printStackTrace();
        }
        return DetalleAsientos;
    }

    public DetalleAsiento findById(Integer id) {
        return session.find(DetalleAsiento.class, id);
    }

    public void save(DetalleAsiento DetalleAsiento) {
        try {
            session.beginTransaction();
            session.save(DetalleAsiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<DetalleAsiento> DetalleAsientos) {
        try {
            session.beginTransaction();
            DetalleAsientos.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(DetalleAsiento DetalleAsiento) {
        try {
            session.beginTransaction();

            session.delete(DetalleAsiento);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        DetalleAsiento DetalleAsiento = this.findById(id);
        if (DetalleAsiento != null) {
            delete(DetalleAsiento);
        }
    }

    public void update(DetalleAsiento DetalleAsiento) {
        try {
            session.beginTransaction();
            session.update(DetalleAsiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
