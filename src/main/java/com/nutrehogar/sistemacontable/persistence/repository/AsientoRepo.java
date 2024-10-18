package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class AsientoRepo {
    private static final Session session = HibernateUtil.getSession();
    private static AsientoRepo instance;

    protected AsientoRepo() {
    }

    public static AsientoRepo getInstance() {
        if (instance == null) {
            instance = new AsientoRepo();
        }
        return instance;
    }

    public List<Asiento> findAll() {
        List<Asiento> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from Asiento", Asiento.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = null;
            e.printStackTrace();
        }
        return Transaccions;
    }

    public Asiento findById(Integer id) {
        return session.find(Asiento.class, id);
    }

    public void save(Asiento Asiento) {
        try {
            session.beginTransaction();
            session.save(Asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Asiento> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Asiento Asiento) {
        try {
            session.beginTransaction();

            session.delete(Asiento);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        Asiento Asiento = this.findById(id);
        if (Asiento != null) {
            delete(Asiento);
        }
    }

    public void update(Asiento Asiento) {
        try {
            session.beginTransaction();
            session.update(Asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
