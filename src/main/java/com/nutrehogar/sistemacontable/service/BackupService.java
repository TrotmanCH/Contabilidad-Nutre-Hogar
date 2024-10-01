package com.nutrehogar.sistemacontable.service;

import com.nutrehogar.sistemacontable.utils.HibernateUtil;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class BackupService {

    static final String BACKUP_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "backup" + File.separator;

    static final String DB_PATH = "contabilidad.db";

    /**
     * Realiza una copia de seguridad de la base de datos.
     * Se copia el archivo de la base de datos a una nueva ubicación con un nombre basado en la fecha y hora.
     */
    public static Optional<String> backupDatabase() {

        try {
            LocalDateTime date = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String fileName = "backup_" + date.format(formatter) + ".db";
            Path sourcePath = Paths.get(DB_PATH);
            Path backupPath = Paths.get(BACKUP_PATH + fileName);

            Files.createDirectories(backupPath.getParent());

            Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Backup realizado correctamente: " + backupPath);
            return Optional.of(fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return Optional.empty();
        }
    }

    /**
     * Restaura la base de datos desde un archivo de backup.
     *
     * @param backupFileName El nombre del archivo de backup a restaurar.
     */
    public static void restoreDatabase(String backupFileName) {
        HibernateUtil.closeSession();
        HibernateUtil.closeSessionFactory();

        try {
            Path backup = Paths.get(BACKUP_PATH + backupFileName);
            Path target = Paths.get(DB_PATH);

            Files.copy(backup, target, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Restauración de la base de datos realizada correctamente desde: " + backup);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
