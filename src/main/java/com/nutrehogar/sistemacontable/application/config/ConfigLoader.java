package com.nutrehogar.sistemacontable.application.config;


import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.*;
import java.util.Properties;

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


    /**
     * Propiedades del programa, son las que se cargan en el momento en que se arranca.
     */
    private static final Properties properties = new Properties();
    /**
     * Propiedades que se editan al momento de manipular las propiedades, se debe llamar al metodo {@code persistProperties()}
     * para efectuar las modificaciones.
     */
    private static Properties config = null;

    static {
//        setDefaultValues();
//        loadProperties();
        createDirectory(getAbsoluteProgramPath());
        createDirectory(getBackupPath());
        createDirectory(getLogsPath());
    }

    private ConfigLoader() {
        throw new IllegalStateException("Configure Class");
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
                saveProperties();
            }
        } catch (IOException e) {
            System.err.println("Error al cargar el archivo de configuración. Usando valores predeterminados.");
            saveProperties();
        }
    }

    /**
     * Guarda las propiedades actuales en el archivo de configuración.
     */
    private static void saveProperties() {
        try (OutputStream output = new FileOutputStream(RESOURCE_RELATIVE_PATH)) {
            properties.store(output, null);
        } catch (IOException e) {
            System.err.println("Error al guardar el archivo de configuración.");
        }
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
                System.out.println("Directorias guardada con exito: "+path+".");
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

    /**
     * Enum que define las claves y valores predeterminados de las propiedades del sistema.
     */
    @Getter
    public enum Property {
        PROGRAM_PATH("program.path", "SistemaContable", "Dirección del programa"),
        DB_NAME("db.name", "sistemacontable.sqlite", "Nombre de Base de Datos"),
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
}
