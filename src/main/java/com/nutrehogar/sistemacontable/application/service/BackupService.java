//package com.nutrehogar.sistemacontable.application.service;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.nutrehogar.sistemacontable.application.service.ConfigLoader;
//
//import java.io.File;
//import java.io.IOException;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.List;
//
//public class BackupService {
//
//    private static final String BACKUP_PATH = ConfigLoader.getBackupPath() + File.separator;
//
//    //    private final CuentaService cuentaService;
//    private static final ObjectMapper objectMapper = new ObjectMapper();
//    private static final CuentaHibernateRepository cuentaService = CuentaHibernateRepository.getInstance();
//
//
//    /**
//     * Realiza una copia de seguridad de la base de datos.
//     * Se copia el archivo de la base de datos a una nueva ubicación con un nombre basado en la fecha y hora.
//     */
//
//    public static void backupDatabaseJSON() {
//        try {
//            List<CuentaEntity> cuentas = cuentaService.findAll();
//            File file = new File(BACKUP_PATH + nameByDate());
//            if (file.createNewFile()) {
//                escribirCuentasAArchivo(file, cuentas);
//                System.out.println("Backup creado exitosamente.");
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    /**
//     * Restaura la base de datos desde un archivo de backup.
//     *
//     * @param backupFileName El nombre del archivo de backup a restaurar.
//     */
//
//    public static void restoreDatabaseJSON(String backupFileName) {
//        try {
//            File file = new File(BACKUP_PATH + backupFileName);
//            List<CuentaEntity> cuentas = leerCuentasDesdeArchivo(file);
//            cuentaService.save(cuentas);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static void startDataCuenta() {
//        try {
//            File file = new File(BACKUP_PATH + "initCuenta.json");
//            List<CuentaEntity> cuentas = objectMapper.readValue(file, new TypeReference<>() {
//            });
//
//            cuentaService.save(cuentas);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static List<CuentaEntity> leerCuentasDesdeArchivo(File file) throws IOException {
//        return objectMapper.readValue(file, new TypeReference<>() {
//        });
//    }
//
//    private static void escribirCuentasAArchivo(File file, List<CuentaEntity> cuentas) throws IOException {
//        objectMapper.writeValue(file, cuentas);
//    }
//
//    private static String nameByDate() {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
//        LocalDateTime date = LocalDateTime.now();
//        return "backup_" + date.format(formatter) + ".json";
//    }
//
//}
