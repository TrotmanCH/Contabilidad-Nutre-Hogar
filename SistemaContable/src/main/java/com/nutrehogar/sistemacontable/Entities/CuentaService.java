package com.nutrehogar.sistemacontable.Entities;

import com.nutrehogar.sistemacontable.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class CuentaService {

    public List<Cuenta> mostrarCuentas() {
        Transaction transaction = null;

        List<Cuenta> cuentas = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            cuentas = session.createQuery("from Cuenta", Cuenta.class).list();

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            cuentas = null;
            System.err.println("Error al mostrar cuentas: " + e.getMessage());
            e.printStackTrace();
        }
        return cuentas;
    }

    public void agergarCuentas(Cuenta cuenta) {
        HibernateUtil.ejectaTransaction(session -> session.save(cuenta));
    }

    public void eliminarCuenta(Cuenta cuenta) {
        HibernateUtil.ejectaTransaction(session -> session.delete(cuenta));
    }

    public void actualizarCuenta(Cuenta cuenta) {
        HibernateUtil.ejectaTransaction(session -> session.update(cuenta));
    }
}
