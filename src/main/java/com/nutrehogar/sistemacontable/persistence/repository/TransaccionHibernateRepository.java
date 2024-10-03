package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.persistence.model.TipoDocumentoEntity;
import com.nutrehogar.sistemacontable.persistence.model.TransaccionEntity;
import com.nutrehogar.sistemacontable.persistence.repository.interfaces.ITransaccionRepository;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class TransaccionHibernateRepository implements ITransaccionRepository {
    private static TransaccionHibernateRepository instance;
    private static final Session session = HibernateUtil.getSession();

    private TransaccionHibernateRepository() {
    }

    public static TransaccionHibernateRepository getInstance() {
        if (instance == null) {
            instance = new TransaccionHibernateRepository();
        }
        return instance;
    }
    @Override
    public List<TransaccionEntity> findAll() {
        List<TransaccionEntity> cuentas;
        try {
            session.beginTransaction();
            cuentas = session.createQuery("from TransaccionEntity ", TransaccionEntity.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            cuentas = null;
            e.printStackTrace();
        }
        return cuentas;
    }

    @Override
    public TransaccionEntity findById(Integer id) {
        return session.find(TransaccionEntity.class, id);
    }

    @Override
    public void save(TransaccionEntity transaccionEntity) {
        try {
            session.beginTransaction();
            session.save(transaccionEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }
    public void save(@NotNull List<TransaccionEntity> transaccion) {
        try {
            session.beginTransaction();
            transaccion.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    @Override
    public void delete(TransaccionEntity transaccionEntity) {
        try {
            session.beginTransaction();

            session.delete(transaccionEntity);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Integer id) {
        TransaccionEntity transaccionEntity = this.findById(id);
        if (transaccionEntity != null) {
            delete(transaccionEntity);
        }
    }

    @Override
    public void update(TransaccionEntity transaccionEntity) {
        try {
            session.beginTransaction();
            session.update(transaccionEntity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
