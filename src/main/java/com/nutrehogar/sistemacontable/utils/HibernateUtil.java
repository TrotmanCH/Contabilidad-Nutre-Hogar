package com.nutrehogar.sistemacontable.utils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import lombok.Getter;

/**
 * HibernateUtil es una clase de utilidad para gestionar la configuración de Hibernate y las sesiones.
 * Esta clase proporciona métodos para inicializar una única sesión de Hibernate y cerrarla adecuadamente,
 * así como la fábrica de sesiones.
 *
 * <p>
 * La clase se inicializa de forma estática, cargando la configuración desde el archivo {@code hibernate.cfg.xml}
 * y abriendo una sesión única que se puede utilizar durante el ciclo de vida de la aplicación.
 * </p>
 *
 * <h2>Ejemplo de uso:</h2>
 * <pre>
 * // Para obtener la sesión de Hibernate
 * Session session = HibernateUtil.getSession();
 *
 * // Para cerrar la sesión al finalizar el uso
 * HibernateUtil.closeSession();
 *
 * // Para cerrar la SessionFactory cuando la aplicación se cierra
 * HibernateUtil.closeSessionFactory();
 * </pre>
 */
public class HibernateUtil {
    private static SessionFactory sessionFactory;

    @Getter
    private static Session session;

    static {
        try {
            // Crea la configuración de Hibernate
            Configuration configuration = new Configuration();
            configuration.configure(); // Carga hibernate.cfg.xml
            sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession(); // Abre una única sesión
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Cierra la sesión de Hibernate si está abierta.
     * Este método debe ser llamado al finalizar el uso de la sesión
     * para liberar recursos y evitar fugas de memoria.
     */
    public static void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }

    /**
     * Cierra la SessionFactory de Hibernate.
     * Este método debe ser llamado al cerrar la aplicación para liberar
     * todos los recursos asociados con la SessionFactory.
     */
    public static void closeSessionFactory() {
        if (sessionFactory != null) {
            sessionFactory.close();
        }
    }
}
