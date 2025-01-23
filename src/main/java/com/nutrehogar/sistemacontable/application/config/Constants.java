package com.nutrehogar.sistemacontable.application.config;

public class Constants {
    private Constants() {
        throw new IllegalStateException("Utility class");
    }
    public static final String RESOURCE_PATH = "config.properties";
    public static final String RESOURCE_RELATIVE_PATH = "src/main/resources/config.properties";
    public static final String FOLDER_PROGRAM_NAME = "SistemaContable";
    public static final String DB_NAME= "sistemacontable.sqlite";
    public static final String FOLDER_BACKUP_NAME="backup";
    public static final String FOLDER_LOG_NAME="logs";
}
