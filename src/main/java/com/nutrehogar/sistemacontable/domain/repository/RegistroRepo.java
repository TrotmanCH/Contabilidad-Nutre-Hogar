package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class RegistroRepo {
    private static final Session session = HibernateUtil.getSession();
    private static RegistroRepo instance;

    private RegistroRepo() {
    }

    public static RegistroRepo getInstance() {
        if (instance == null) {
            instance = new RegistroRepo();
        }
        return instance;
    }

    public List<Registro> findAll() {
        List<Registro> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from Registro", Registro.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = Collections.emptyList();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public Registro findById(Integer id) {
        return session.find(Registro.class, id);
    }

    public void save(Registro Registro) {
        try {
            session.beginTransaction();
            session.persist(Registro);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Registro> registros) {
        try {
            session.beginTransaction();
            registros.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Registro registro) {
        try {
            session.beginTransaction();

            session.remove(session.contains(registro) ? registro : session.merge(registro));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(findById(id)).ifPresent(session::remove);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void update(Registro registro) {
        try {
            session.beginTransaction();
            session.merge(registro);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
