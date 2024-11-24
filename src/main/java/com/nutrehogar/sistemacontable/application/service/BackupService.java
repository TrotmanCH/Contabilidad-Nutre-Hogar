package com.nutrehogar.sistemacontable.application.service;

import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.sql.Statement;
import java.time.LocalDateTime;

import static com.nutrehogar.sistemacontable.application.service.ConfigLoader.getBackupPath;
import static com.nutrehogar.sistemacontable.application.service.Util.getDateFormat;

/**
 * Servicio encargado de gestionar las operaciones de respaldo de la base de datos
 * utilizando Hibernate y las herramientas de conexión a base de datos.
 * Implementa el patrón Singleton para garantizar una única instancia.
 * @author Calci
 */
public class BackupService {

    /** Sesión de Hibernate para interactuar con la base de datos. */
    private final Session session = HibernateUtil.getSession();

    /** Instancia única de BackupService. */
    private static BackupService instance;

    /** Constructor privado para implementar el patrón Singleton. */
    private BackupService() {
    }

    /**
     * Devuelve la instancia única de BackupService. Si no existe, la crea.
     *
     * @return Instancia única de BackupService.
     */
    public static BackupService getInstance() {
        if (instance == null) {
            instance = new BackupService();
        }
        return instance;
    }

    /**
     * Realiza un respaldo de la base de datos actual. Utiliza el comando `VACUUM INTO`
     * para generar un archivo de respaldo en la ubicación especificada.
     */
    public void backup() {
        session.doWork(connection -> {
            try (Statement stmt = connection.createStatement()) {
                // Habilita el autocommit para ejecutar el comando VACUUM
                connection.setAutoCommit(true);

                // Ejecuta el comando VACUUM INTO para generar el archivo de respaldo
                stmt.execute("VACUUM INTO '" + getFilePathAndName() + "';");

                // Restaura el autocommit a su estado inicial
                connection.setAutoCommit(false);

                System.out.println("Respaldo completado.");
            } catch (Exception e) {
                // Manejo de errores durante el proceso de respaldo
                e.printStackTrace();
            }
        });
    }

    /**
     * Obtiene la ruta completa del archivo de respaldo, incluyendo su nombre generado
     * dinámicamente según la fecha y hora actual.
     *
     * @return Ruta completa del archivo de respaldo.
     */
    private @NotNull String getFilePathAndName() {
        return getBackupPath() + File.separator + getNameByDate();
    }

    /**
     * Genera un nombre de archivo único para el respaldo, basado en la fecha y hora actuales.
     *
     * @return Nombre del archivo de respaldo.
     */
    private @NotNull String getNameByDate() {
        return "backup_" + LocalDateTime.now().format(getDateFormat()) + ".sqlite";
    }

}
