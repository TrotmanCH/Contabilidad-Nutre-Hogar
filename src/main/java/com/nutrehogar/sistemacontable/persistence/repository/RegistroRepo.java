package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class RegistroRepo {
    private static final Session session = HibernateUtil.getSession();
    private static RegistroRepo instance;

    protected RegistroRepo() {
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
            Transaccions = null;
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
            session.save(Registro);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Registro> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Registro Registro) {
        try {
            session.beginTransaction();

            session.delete(Registro);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        Registro Registro = this.findById(id);
        if (Registro != null) {
            delete(Registro);
        }
    }

    public void update(Registro Registro) {
        try {
            session.beginTransaction();
            session.update(Registro);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
