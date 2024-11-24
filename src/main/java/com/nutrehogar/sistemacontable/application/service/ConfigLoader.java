package com.nutrehogar.sistemacontable.application.service;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Properties;

/**
 * Clase encargada de gestionar la carga, el almacenamiento y la inicialización de configuraciones
 * mediante el uso de un archivo de propiedades. Utiliza un patrón Singleton para garantizar que solo
 * exista una instancia de esta clase.
 * @author Calci
 */
public class ConfigLoader {

    /** Ruta relativa del archivo de configuración dentro del paquete. */
    public static final String RESOURCE_PATH = "config.properties";

    /** Ruta relativa al archivo de configuración dentro del proyecto (para guardado). */
    public static final String RESOURCE_RELATIVE_PATH = "src/main/resources/config.properties";

    /** Instancia única de la clase ConfigLoader. */
    private static ConfigLoader instance;

    /** Objeto Properties que almacena las configuraciones cargadas. */
    private static final Properties properties = new Properties();

    /** Constructor privado para implementar el patrón Singleton. */
    private ConfigLoader() {
    }

    /**
     * Devuelve la instancia única de ConfigLoader. Si no existe, la crea.
     *
     * @return Instancia única de ConfigLoader.
     */
    public static ConfigLoader getInstance() {
        if (instance == null) {
            instance = new ConfigLoader();
        }
        return instance;
    }

    /**
     * Enum que define las claves y valores predeterminados de las propiedades del sistema.
     */
    public enum Property {
        /** Ruta del programa en el sistema de archivos. */
        PROGRAM_PATH("program.path", "SistemaContable"),

        /** Nombre de la base de datos. */
        DB_NAME("db.name", "srccontabilidad.db"),

        /** Ruta para los respaldos de la base de datos. */
        DB_BACKUP_PATH("db.backup", "backup"),

        /** Ruta predeterminada de la base de datos. */
        DB_PATH("db.path", System.getProperty("user.home") + File.separator + "db");

        /** Clave de la propiedad. */
        private final String key;

        /** Valor predeterminado de la propiedad. */
        private final String defaultValue;

        /**
         * Constructor del enum Property.
         *
         * @param key Clave de la propiedad.
         * @param defaultValue Valor predeterminado de la propiedad.
         */
        Property(String key, String defaultValue) {
            this.key = key;
            this.defaultValue = defaultValue;
        }
    }

    // Bloque estático para inicializar las propiedades con valores predeterminados
    static {
        for (Property property : Property.values()) {
            properties.put(property.key, property.defaultValue);
        }
    }

    // Bloque estático para inicializar la clase.
    static {
        initialize();
    }

    /**
     * Inicializa las configuraciones cargando propiedades y creando directorios necesarios.
     */
    public static void initialize() {
        loadProperties();
        createDirectories();
    }

    /**
     * Carga las propiedades desde el archivo de configuración.
     * Si el archivo no existe, utiliza los valores predeterminados.
     */
    private static void loadProperties() {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream(RESOURCE_PATH)) {
            if (input != null) {
                properties.load(input);
            } else {
                System.out.println("No se encontró el archivo de configuración. Usando valores predeterminados.");
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración. Usando valores predeterminados.");
            e.printStackTrace();
        }
    }

    /**
     * Guarda las propiedades actuales en el archivo de configuración.
     */
    public static void saveProperties() {
        try (OutputStream output = new FileOutputStream(RESOURCE_RELATIVE_PATH)) {
            properties.store(output, null);
            System.out.println("Configuración guardada correctamente.");
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de configuración.");
            e.printStackTrace();
        }
    }

    /**
     * Crea los directorios necesarios definidos en las propiedades.
     */
    private static void createDirectories() {
        String programPath = properties.getProperty(Property.PROGRAM_PATH.key);
        String userHome = System.getProperty("user.home");

        String programPathInUserHome = userHome + File.separator + programPath;
        String backupPath = programPathInUserHome + File.separator + properties.getProperty(Property.DB_BACKUP_PATH.key);

        createDirectory(programPathInUserHome);
        createDirectory(backupPath);
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
                System.out.println("Directorio creado: " + dir.getAbsolutePath());
            }
        }
    }

    /**
     * Obtiene el valor de una propiedad específica.
     *
     * @param property Propiedad a consultar.
     * @return Valor de la propiedad.
     */
    public static String getProperty(@NotNull Property property) {
        return properties.getProperty(property.key);
    }

    /**
     * Obtiene la ruta completa de la base de datos.
     *
     * @return Ruta de la base de datos.
     */
    public static @NotNull String getDbPath() {
        return System.getProperty("user.home") + File.separator + properties.getProperty(Property.PROGRAM_PATH.key) + File.separator + properties.getProperty(Property.DB_NAME.key);
    }

    /**
     * Obtiene la ruta completa para los respaldos de la base de datos.
     *
     * @return Ruta de los respaldos.
     */
    public static @NotNull String getBackupPath() {
        return System.getProperty("user.home") + File.separator + properties.getProperty(Property.PROGRAM_PATH.key) + File.separator + properties.getProperty(Property.DB_BACKUP_PATH.key);
    }
}
