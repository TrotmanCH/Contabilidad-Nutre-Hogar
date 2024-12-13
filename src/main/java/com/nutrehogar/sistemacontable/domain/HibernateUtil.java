package com.nutrehogar.sistemacontable.domain;

import lombok.Getter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * HibernateUtil es una clase de utilidad que gestiona la configuración de Hibernate
 * y proporciona una única instancia de SessionFactory y Session a lo largo de la vida de la aplicación.
 * Esta clase utiliza el patrón Singleton para asegurar que solo haya una sesión de Hibernate activa
 * en la aplicación de escritorio.
 *
 * <p>
 * Se recomienda cerrar la sesión y el SessionFactory al finalizar el uso de la aplicación.
 * </p>
 */
public class HibernateUtil {

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory(); // Instancia de SessionFactory
    private static Session session = null; // Instancia única de Session

    /**
     * Constructor protegido para evitar instanciación externa.
     */
    private HibernateUtil() {
    }

    /**
     * Construye el SessionFactory utilizando la configuración especificada en hibernate.cfg.xml.
     *
     * @return SessionFactory construida
     * @throws ExceptionInInitializerError si la configuración falla
     */
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration config = new Configuration().configure();
            return config.buildSessionFactory();

        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex); // Maneja errores en la construcción
        }
    }

    /**
     * Obtiene la sesión de Hibernate.
     * Si no hay una sesión activa, se crea una nueva.
     *
     * @return la sesión activa de Hibernate
     */
    public static Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession(); // Crea una nueva sesión si es necesario
        }
        return session; // Devuelve la sesión activa
    }


    /**
     * Cierra la sesión de Hibernate y el SessionFactory.
     * Debe ser llamado al finalizar el uso de la aplicación.
     */
    public static void shutdown() {
        if (session != null) {
            session.close(); // Cierra la sesión si está activa
        }
        sessionFactory.close(); // Cierra el SessionFactory
    }
}
