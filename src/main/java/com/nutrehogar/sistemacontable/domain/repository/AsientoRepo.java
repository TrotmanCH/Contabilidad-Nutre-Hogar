package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class AsientoRepo {
    private static final Session session = HibernateUtil.getSession();
    private static AsientoRepo instance;

    private AsientoRepo() {
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
            Transaccions = Collections.emptyList();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public Asiento findById(Integer id) {
        return session.find(Asiento.class, id);
    }

    public void save(Asiento asiento) {
        try {
            session.beginTransaction();
            session.persist(asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Asiento> asientos) {
        try {
            session.beginTransaction();
            asientos.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Asiento asiento) {
        try {
            session.beginTransaction();

            session.remove(session.contains(asiento) ? asiento : session.merge(asiento));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(session.find(Asiento.class, id)).ifPresent(session::remove);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Asiento asiento) {
        try {
            session.beginTransaction();
            session.merge(asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
