package com.nutrehogar.sistemacontable.service;
import com.nutrehogar.sistemacontable.entities.Transaccion;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
