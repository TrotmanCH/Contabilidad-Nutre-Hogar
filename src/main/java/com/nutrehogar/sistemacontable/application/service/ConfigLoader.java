package com.nutrehogar.sistemacontable.application.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Properties;

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

    public static final String RESOURCE_PATH = "config.properties";
    public static final String RESOURCE_RELATIVE_PATH = "src/main/resources/config.properties";
    /**
     * Propiedades del programa, son las que se cargan en el momento en que se arranca.
     */
    private static final Properties properties = new Properties();
    /**
     * Propiedades que se editan al momento de manipular las propiedades, se debe llamar al metodo {@code persistProperties()}
     * para efectuar las modificaciones.
     */
    private static Properties config = null;

    private ConfigLoader() {
    }

    /**
     * Enum que define las claves y valores predeterminados de las propiedades del sistema.
     */
    @Getter
    public enum Property {
        PROGRAM_PATH("program.path", "SistemaContable", "Dirección del programa"),
        DB_NAME("db.name", "srccontabilidad.db", "Nombre de Base de Datos"),
        DB_BACKUP_PATH("db.backup", "backup", "Carpeta de las Copias de Seguridad de la Base de Datos"),
        DB_PATH("db.path", System.getProperty("user.home") + File.separator + "db", "Dirección de la Base de Datos");

        private final String key;
        private final String defaultValue;
        private final String name;

        /**
         * Constructor del enum Property.
         *
         * @param key          Clave de la propiedad.
         * @param defaultValue Valor predeterminado de la propiedad.
         */
        Property(String key, String defaultValue, String name) {
            this.key = key;
            this.defaultValue = defaultValue;
            this.name = name;
        }
    }

    static {
        initialize();
    }

    /**
     * Inicializa las configuraciones cargando propiedades y creando directorios necesarios.
     */
    public static void initialize() {
        setDefaultValues();
        loadProperties();
        createDirectories();
    }

    public static void setDefaultValues() {
        for (Property property : Property.values()) {
            properties.put(property.key, property.defaultValue);
        }
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
    private static void saveProperties() {
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

    public static void setProperty(@NotNull Property property, @NotNull String value) {
        if (config == null) config = new Properties(properties);
        config.setProperty(property.key, value);
    }

    public static void persistProperties() {
        properties.putAll(config);
        dispatchProperties();
        saveProperties();
    }

    public static void dispatchProperties() {
        config = null;
    }

    public static int getPropertiesSize() {
        return properties.size();
    }

    @Getter
    private static final String[] columnNames = {
            "Propiedad", "Valor", "Key", "Default Value"
    };

    public static @Nullable Object getValues(int rowIndex, int columnIndex) {
        if (columnIndex < properties.size()) {
            Property property = Property.values()[rowIndex];
            return switch (columnIndex) {
                case 0 -> property.name;
                case 1 -> properties.getProperty(property.key);
                case 2 -> property.key;
                case 3 -> property.defaultValue;
                default -> null;
            };
        } else return null;
    }

    public static @NotNull String getAbsoluteProgramPath() {
        return System.getProperty("user.home") + File.separator + properties.getProperty(Property.PROGRAM_PATH.key);
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
