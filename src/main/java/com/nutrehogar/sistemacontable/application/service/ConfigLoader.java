package com.nutrehogar.sistemacontable.application.service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    public static ConfigLoader instance;
    private static final Properties properties = new Properties();

    private ConfigLoader() {

    }

    public static ConfigLoader getInstance() {
        if (instance == null) {
            instance = new ConfigLoader();
        }
        return instance;
    }

    static {
        loadProperties();
        createDirectories();
    }

    private static void loadProperties() {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (input == null) {
                throw new IOException("No se pudo encontrar el archivo config.properties");
            }
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void createDirectories() {
        String appPath = properties.getProperty("app.path");
        String userHome = System.getProperty("user.home");

        String dbPath = userHome + File.separator + appPath;
        String backupPath = userHome + File.separator + appPath + File.separator + properties.getProperty("db.backup");

        // Crear directorio para la base de datos
        File dbDirectory = new File(dbPath).getParentFile();
        if (dbDirectory != null && !dbDirectory.exists()) {
            if (dbDirectory.mkdirs()) {
                System.out.println("Directorio de base de datos creado: " + dbDirectory.getAbsolutePath());
            }
        }

        // Crear directorio para los backups
        File backupDirectory = new File(backupPath);
        if (!backupDirectory.exists()) {
            if (backupDirectory.mkdirs()) {
                System.out.println("Directorio de backups creado: " + backupDirectory.getAbsolutePath());
            }
        }
    }

    public static String getDbPath() {
        return System.getProperty("user.home") + File.separator + properties.getProperty("app.path") + File.separator + properties.getProperty("db.name");
    }

    public static String getBackupPath() {
        return System.getProperty("user.home") + File.separator + properties.getProperty("app.path") + File.separator + properties.getProperty("db.backup");
    }

}
