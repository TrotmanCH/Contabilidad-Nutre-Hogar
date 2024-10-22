package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class TipoDocumentoRepo {
    private static final Session session = HibernateUtil.getSession();
    private static TipoDocumentoRepo instance;

    protected TipoDocumentoRepo() {
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
            Transaccions = Collections.emptyList();
            e.printStackTrace();
        }
        return Transaccions;
    }

    public TipoDocumento findById(Integer id) {
        return session.find(TipoDocumento.class, id);
    }

    public void save(TipoDocumento tipoDocumento) {
        try {
            session.beginTransaction();
            session.persist(tipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<TipoDocumento> tipoDocumentos) {
        try {
            session.beginTransaction();
            tipoDocumentos.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(TipoDocumento tipoDocumento) {
        try {
            session.beginTransaction();

            session.remove(session.contains(tipoDocumento) ? tipoDocumento : session.merge(tipoDocumento));

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

    public void update(TipoDocumento tipoDocumento) {
        try {
            session.beginTransaction();
            session.merge(tipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
