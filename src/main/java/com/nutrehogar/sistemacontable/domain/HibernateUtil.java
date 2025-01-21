package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.service.ConfigLoader;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;

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
@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class HibernateUtil {

    private static final Logger logger = LoggerFactory.getLogger(HibernateUtil.class);

    @Getter
    private static final SessionFactory sessionFactory = buildSessionFactory(); // Instancia de SessionFactory
    private static Session session = null; // Instancia única de Session

    /**
     * Construye el SessionFactory utilizando la configuración especificada en hibernate.cfg.xml.
     *
     * @return SessionFactory construida
     * @throws ExceptionInInitializerError si la configuración falla
     */
    private static SessionFactory buildSessionFactory() {
        logger.info("Building Hibernate SessionFactory");

        try {
            // Cargar la configuración de hibernate.cfg.xml
            Configuration configuration = new Configuration().configure();

            configuration.setProperty("hibernate.connection.url", "jdbc:sqlite:"+ConfigLoader.getDbPath());

            return configuration.buildSessionFactory();
        } catch (Exception e) {
            logger.error("Error building SessionFactory", e);

            JOptionPane.showMessageDialog(null,
                    "Error al iniciar la sesión de Hibernate: " + e.getMessage(),
                    "Error de Configuración",
                    JOptionPane.ERROR_MESSAGE);

            System.exit(1);
            return null;
        }
    }

    /**
     * Obtiene la sesión de Hibernate.
     * Si no hay una sesión activa, se crea una nueva.
     *
     * @return la sesión activa de Hibernate
     */
    public static synchronized Session getSession() {
        if (session == null || !session.isOpen()) {
            session = sessionFactory.openSession(); // Crea una nueva sesión si es necesario
            logger.info("Open session");
        }
        return session; // Devuelve la sesión activa
    }


    /**
     * Cierra la sesión de Hibernate y el SessionFactory.
     * Debe ser llamado al finalizar el uso de la aplicación.
     */
    public static synchronized void shutdown() {
        if (session != null) {
            session.close();
        }
        if (sessionFactory != null) {
            sessionFactory.close();
        }
        logger.info("Session closed");
    }
}
