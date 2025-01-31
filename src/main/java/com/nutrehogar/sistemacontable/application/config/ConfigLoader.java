package com.nutrehogar.sistemacontable.application.config;

import org.jetbrains.annotations.NotNull;

import java.io.*;


import static com.nutrehogar.sistemacontable.application.config.Constants.*;

/**
 * Clase encargada de gestionar la carga, el almacenamiento y la inicialización de configuraciones
 * mediante el uso de un archivo de propiedades. Utiliza un patrón Singleton para garantizar que solo
 * exista una instancia de esta clase.
 * </p>
 * Las propiedades se cargan del archivo {@code config.properties} que debe estar en los recursos del programa {@code src/main/resources/}.
 * Si no existe se asignarán unas propiedades por defecto, se creará él {@code .properties} y se guardara la configuración.
 *
 * @author Calcifer1331
 */
public class ConfigLoader {

    static {
        createDirectory(getAbsoluteProgramPath());
        createDirectory(getBackupPath());
        createDirectory(getLogsPath());
    }

    private ConfigLoader() {
        throw new IllegalStateException("Configure Class");
    }


    /**
     * Crea un directorio en la ruta especificada si no existe.
     *
     * @param path Ruta del directorio a crear.
     */
    private static void createDirectory(String path) {
        File dir = new File(path);
        if (!dir.exists()) {
            if (dir.mkdirs()) {
                System.out.println("Directorias guardada con exito: " + path + ".");
            }
        }
    }

    public static @NotNull String getAbsoluteProgramPath() {
        return System.getProperty("user.home") + File.separator + FOLDER_PROGRAM_NAME;
    }

    /**
     * Obtiene la ruta completa de la base de datos.
     *
     * @return Ruta de la base de datos.
     */
    public static @NotNull String getDbPath() {
        return getAbsoluteProgramPath() + File.separator + DB_NAME;
    }

    /**
     * Obtiene la ruta completa para los respaldos de la base de datos.
     *
     * @return Ruta de los respaldos.
     */
    public static @NotNull String getBackupPath() {
        return getAbsoluteProgramPath() + File.separator + FOLDER_BACKUP_NAME;
    }

    public static @NotNull String getLogsPath() {
        return getAbsoluteProgramPath() + File.separator + FOLDER_LOG_NAME;
    }

}
