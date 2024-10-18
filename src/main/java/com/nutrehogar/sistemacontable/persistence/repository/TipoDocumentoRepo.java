package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TipoDocumentoRepo {
    private static TipoDocumentoRepo instance;
    private static final Session session = HibernateUtil.getSession();

    private TipoDocumentoRepo() {
    }

    public static TipoDocumentoRepo getInstance() {
        if (instance == null) {
            instance = new TipoDocumentoRepo();
        }
        return instance;
    }

    public List<TipoDocumento> findAll() {
        List<TipoDocumento> Transaccions;
        try {
            session.beginTransaction();
            Transaccions = session.createQuery("from TipoDocumento", TipoDocumento.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            Transaccions = null;
            e.printStackTrace();
        }
        return Transaccions;
    }

    public TipoDocumento findById(Integer id) {
        return session.find(TipoDocumento.class, id);
    }

    public void save(TipoDocumento TipoDocumento) {
        try {
            session.beginTransaction();
            session.save(TipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<TipoDocumento> Transaccions) {
        try {
            session.beginTransaction();
            Transaccions.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(TipoDocumento TipoDocumento) {
        try {
            session.beginTransaction();

            session.delete(TipoDocumento);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        TipoDocumento TipoDocumento = this.findById(id);
        if (TipoDocumento != null) {
            delete(TipoDocumento);
        }
    }

    public void update(TipoDocumento TipoDocumento) {
        try {
            session.beginTransaction();
            session.update(TipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
