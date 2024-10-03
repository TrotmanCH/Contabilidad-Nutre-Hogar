package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.persistence.model.TipoDocumentoEntity;
import com.nutrehogar.sistemacontable.persistence.repository.interfaces.ITipoDocumentoRepository;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class TipoDocumentoHibernateRepository implements ITipoDocumentoRepository {
    private static TipoDocumentoHibernateRepository instance;
    private static final Session session = HibernateUtil.getSession();

    private TipoDocumentoHibernateRepository() {
    }

    public static TipoDocumentoHibernateRepository getInstance() {
        if (instance == null) {
            instance = new TipoDocumentoHibernateRepository();
        }
        return instance;
    }

    @Override
    public List<TipoDocumentoEntity> findAll() {
        List<TipoDocumentoEntity> cuentas;
        try {
            session.beginTransaction();
            cuentas = session.createQuery("from TipoDocumentoEntity ", TipoDocumentoEntity.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            cuentas = null;
            e.printStackTrace();
        }
        return cuentas;
    }

    @Override
    public TipoDocumentoEntity findById(Integer id) {
        return session.find(TipoDocumentoEntity.class, id);

    }

    @Override
    public void save(TipoDocumentoEntity tipoDocumento) {
        try {
            session.beginTransaction();
            session.save(tipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(TipoDocumentoEntity tipoDocumento) {
        try {
            session.beginTransaction();

            session.delete(tipoDocumento);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        TipoDocumentoEntity tipoDocumento = this.findById(id);
        if (tipoDocumento != null) {
            delete(tipoDocumento);
        }
    }

    @Override
    public void update(TipoDocumentoEntity tipoDocumento) {
        try {
            session.beginTransaction();
            session.update(tipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
