package com.nutrehogar.sistemacontable.Entities;
import com.nutrehogar.sistemacontable.HibernateUtil;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.function.Consumer;

public class TipoDocumentoService {
    public List<Transaccion> obtenerTransaccionesPorTipoDocumento(Integer tipoDocumentoId) {
        Transaction transaction = null;
        List<Transaccion> transacciones = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            String hql = "FROM Transaccion t WHERE t.tipoDocumento.id = :tipoDocumentoId";
            transacciones = session.createQuery(hql, Transaccion.class)
                    .setParameter("tipoDocumentoId", tipoDocumentoId)
                    .getResultList();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }

        return transacciones;
    }

}
