package com.nutrehogar.sistemacontable.service;

import com.nutrehogar.sistemacontable.utils.HibernateUtil;
import org.hibernate.Session;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BackupService {

    static final String BACKUP_PATH = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "backup" + File.separator;
    static final String DB_PATH = "contabilidad.db";

    public static void backupDatabase() {
        // Iniciar la transacción de Hibernate
        Session session = HibernateUtil.getSession();

        // Realizar la operación de backup en la conexión JDBC
        session.doWork(connection -> {
            try (Statement statement = connection.createStatement()) {
                // Ejecutar el comando backup para crear una copia de la base de datos
                LocalDateTime date = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
                String fileName = "backup_" + date.format(formatter) + ".db";

                String sqlBackupCommand = String.format("BACKUP TO '%s'", BACKUP_PATH + fileName);
                statement.execute(sqlBackupCommand);
                System.out.println("Backup realizado correctamente");
            }
        });
    }

    public static void restoreDatabase(String backupFileName) {
        HibernateUtil.closeSession();

        try {
            Path backup = Paths.get(BACKUP_PATH + backupFileName);
            Path target = Paths.get(DB_PATH);

            Files.copy(backup, target, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            HibernateUtil.getSession();
        }
    }
}
