package com.nutrehogar.sistemacontable.Entities;

import com.nutrehogar.sistemacontable.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

/**
 * Servicio para manejar operaciones relacionadas con la entidad Cuenta.
 * Proporciona métodos para mostrar, agregar, eliminar y actualizar cuentas en la base de datos.
 */
public class CuentaService {

    /**
     * Muestra todas las cuentas almacenadas en la base de datos.
     *
     * @return una lista de objetos Cuenta. Si ocurre un error, se devuelve null.
     */
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

    /**
     * Agrega una nueva cuenta a la base de datos.
     *
     * @param cuenta objeto Cuenta a ser guardado.
     */
    public void agregarCuentas(Cuenta cuenta) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(cuenta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Elimina una cuenta existente de la base de datos.
     *
     * @param cuenta objeto Cuenta a ser eliminado.
     */
    public void eliminarCuenta(Cuenta cuenta) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuenta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    /**
     * Actualiza una cuenta existente en la base de datos.
     *
     * @param cuenta objeto Cuenta con los datos actualizados.
     */
    public void actualizarCuenta(Cuenta cuenta) {
        Transaction transaction = null;

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(cuenta);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
