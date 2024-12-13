package com.nutrehogar.sistemacontable.domain.config;

import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@NoArgsConstructor
public class HibernateUtil {
    private static volatile SessionFactory sessionFactory; // Instancia de SessionFactory
    private static Session session = null;
    private static final Object lock = new Object();//Objeto que bloquea el bloque de codigo

    public static void getSessionFactory() {
        if (sessionFactory == null) {
            synchronized (lock) {
                if (sessionFactory == null) {
                    sessionFactory = buildSessionFactory();
                }
            }
        }
    }

    private static SessionFactory buildSessionFactory() {
        System.out.println("HibernateUtil.buildSessionFactory");
        return new Configuration().configure().buildSessionFactory();
    }

    /**
     * Obtiene la sesión de Hibernate.
     * Si no hay una sesión activa, se crea una nueva.
     *
     * @return la sesión activa de Hibernate
     */
    public static Session getSession() {
        createSession();
        return session; // Devuelve la sesión activa
    }

    public static void createSession() {
        if (sessionFactory == null) {
            getSessionFactory();
        }
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession(); // Crea una nueva sesión si es necesario
            System.out.println("HibernateUtil.createSession: Session created");
        }
    }

    /**
     * Cierra la sesión de Hibernate y el SessionFactory.
     * Debe ser llamado al finalizar el uso de la aplicación.
     */
    public static void shutdown() {
        if (session != null) {
            session.close(); // Cierra la sesión si está activa
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        // Cierra el SessionFactory
        System.out.println("HibernateUtil.shutdown");
    }
}
