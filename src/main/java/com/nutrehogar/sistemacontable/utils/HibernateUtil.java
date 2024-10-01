package com.nutrehogar.sistemacontable.utils;
import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.function.Consumer;

/**
 * Utilidad para manejar la configuración y creación de sesiones de Hibernate.
 * Proporciona métodos para ejecutar transacciones en la base de datos.
 */
public class HibernateUtil {

    @Getter
    private static SessionFactory sessionFactory;

    static {
        try {
            // Configura y construye la SessionFactory a partir del archivo de configuración de Hibernate.
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ejecuta una acción dentro de una transacción de Hibernate.
     *
     * @param action una función que recibe una sesión de Hibernate y contiene la lógica de negocio que se ejecutará
     *               dentro de la transacción.
     */
    public static void ejectaTransaction(Consumer<Session> action) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            action.accept(session); // Ejecutar la acción
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
}
