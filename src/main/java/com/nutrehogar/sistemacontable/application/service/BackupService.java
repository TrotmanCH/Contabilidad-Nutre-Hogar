package com.nutrehogar.sistemacontable.application.service;

import com.nutrehogar.sistemacontable.application.config.Constants;
import com.nutrehogar.sistemacontable.ui.services.BackupPanel;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import static com.nutrehogar.sistemacontable.application.config.ConfigLoader.getBackupPath;

/**
 * Servicio encargado de gestionar las operaciones de respaldo de la base de datos
 * utilizando Hibernate y herramientas de conexión a base de datos.
 * Implementa el patrón Singleton para garantizar una única instancia.
 *
 * @author Calcifer1331
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
@Slf4j
public class BackupService {

    /**
     * Sesión de Hibernate para la conexión con la base de datos.
     */
    final Session session;
    /**
     * Diálogo modal que muestra la interfaz gráfica de respaldo.
     */
    JDialog dialog;

    /**
     * Frame principal del programa.
     */
    Frame mainFrame;

    /**
     * Panel principal que contiene los elementos de la interfaz gráfica.
     */
    BackupPanel backupPanel;

    /**
     * Tabla que muestra la lista de respaldos disponibles.
     */
    JTable tableBackup;

    /**
     * Modelo de datos para la tabla de respaldos.
     */
    BackupTableModel backupTableModel;

    /**
     * Botón para cerrar la ventana de respaldo.
     */
    JButton btnClose;

    /**
     * Botón para crear un nuevo respaldo.
     */
    JButton btnCreateBackup;

    /**
     * Botón para restaurar un respaldo seleccionado.
     */
    JButton btnRestarBackup;

    /**
     * Lista de archivos de respaldo encontrados en el directorio configurado.
     */
    File[] files;

    /**
     * Archivo seleccionado para la restauración.
     */
    File selectedFile;

    /**
     * Constructor privado para implementar el patrón Singleton.
     * Inicializa los componentes gráficos y carga los archivos de respaldo disponibles.
     */
    public BackupService(Session session) {
        this.session = session;
        backupPanel = new BackupPanel();
        btnCreateBackup = backupPanel.getBtnCreateBackup();
        btnRestarBackup = backupPanel.getBtnRestarBackup();
        btnClose = backupPanel.getBtnClose();
        tableBackup = backupPanel.getTableBackup();

        files = findBackupFiles();
        backupTableModel = new BackupTableModel(files);
        tableBackup.setModel(backupTableModel);
        initialize();
    }

    /**
     * Devuelve el formato de fecha usado para guardar archivos.
     *
     * @return año-mes-día-hora-minuto-segundo
     */
    @Contract(" -> new")
    public static @NotNull DateTimeFormatter getDateFormat() {
        return Constants.DATE_TIME_FORMATTER;
    }

    /**
     * Muestra el diálogo modal para gestionar respaldos.
     *
     * @param frame Ventana principal de la aplicación.
     * @return Instancia del diálogo modal.
     */
    public JDialog getDialog(JFrame frame) {
        if (dialog == null) {
            mainFrame = frame;
            dialog = new JDialog(mainFrame, "Copias de Seguridad", true);
            dialog.setLocationRelativeTo(frame);
            dialog.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
            dialog.add(backupPanel);
            dialog.setSize(430, 460);
        }
        return dialog;
    }

    /**
     * Configura los componentes gráficos y asigna los eventos de los botones y la tabla.
     */
    private void initialize() {
        tableBackup.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        btnRestarBackup.setEnabled(false);
        tableBackup.getSelectionModel().addListSelectionListener(this::tableChainSelectedRow);
        btnCreateBackup.addActionListener(this::btnCreateBackupActionPerformed);
        btnClose.addActionListener(this::btnCloseActionPerformed);
        btnRestarBackup.addActionListener(this::btnRestarBackupActionPerformance);

        // Agregar ordenamiento a la tabla
        TableRowSorter<BackupTableModel> sorter = new TableRowSorter<>(backupTableModel);
        tableBackup.setRowSorter(sorter);

        // Comparador personalizado para la columna de fecha
        sorter.setComparator(1, (o1, o2) -> {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
                LocalDateTime date1 = LocalDateTime.parse(o1.toString(), formatter);
                LocalDateTime date2 = LocalDateTime.parse(o2.toString(), formatter);
                return date1.compareTo(date2);
            } catch (Exception e) {
                log.error("Error parsing date", e);
                return 0;
            }
        });
        // Ordenar inicialmente por la segunda columna (fecha)
        sorter.toggleSortOrder(1);
    }

    /**
     * Manejador del evento para restaurar un respaldo cuando se pulsa el botón.
     *
     * @param e Evento asociado al clic del botón.
     */
    private void btnRestarBackupActionPerformance(ActionEvent e) {
        var response = JOptionPane.showConfirmDialog(
                dialog,
                "Debe creara una copia de seguridad con los datos actuales.",
                "Restablecer copia",
                JOptionPane.OK_CANCEL_OPTION);

        if (response != JOptionPane.OK_OPTION) return;

        int result = btnCreateBackupActionPerformed(null, "security_");

        if (result != JOptionPane.OK_OPTION) return;

        restartBackup(selectedFile.getAbsolutePath());

        log.info("Restar copia finalizada");

        JOptionPane.showMessageDialog(dialog,"Para hacer efectivo los cambios se cerrara el programa.","Se cerrara el programa.", JOptionPane.INFORMATION_MESSAGE);
        System.exit(1);//terminar proceso
    }

    /**
     * Manejador del evento para cerrar el diálogo de respaldo.
     *
     * @param e Evento asociado al clic del botón.
     */
    private void btnCloseActionPerformed(ActionEvent e) {
        dialog.setVisible(false);
    }

    /**
     * Maneja el evento de selección de una fila en la tabla de respaldos.
     *
     * @param e Evento de selección de la tabla.
     */
    public void tableChainSelectedRow(@NotNull ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tableBackup.getSelectedRow();
            if (selectedRow != -1) {
                selectFile(selectedRow);
                btnRestarBackup.setEnabled(true);
            } else {
                btnRestarBackup.setEnabled(false);
            }
        }
    }

    /**
     * Manejador del evento para crear un respaldo nuevo.
     *
     * @param e Evento asociado al clic del botón.
     */
    public int btnCreateBackupActionPerformed(ActionEvent e, String name) {
        JTextField inputFileName = new JTextField();
        var fileName = name == null ? createNameByDate() : name + createNameByDate();
        inputFileName.setText(fileName);
        JPanel contentPanel = new JPanel();
        contentPanel.add(new Label("Nombre:"));
        contentPanel.add(inputFileName);

        int result = JOptionPane.showConfirmDialog(
                dialog,
                contentPanel,
                "Nueva Copia de Seguridad",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE
        );

        if (result == JOptionPane.OK_OPTION) {
            String input = inputFileName.getText();
            backup(createFilePathAndName(input));
            files = findBackupFiles();
            backupTableModel.setDataAndReload(files);
        }
        return result;
    }

    public int btnCreateBackupActionPerformed(ActionEvent e) {
        return btnCreateBackupActionPerformed(e, null);
    }

    /**
     * Selecciona un archivo de respaldo de la lista basado en su índice.
     *
     * @param i Índice del archivo en la lista.
     */
    private void selectFile(int i) {
        selectedFile = files[i];
    }

    /**
     * Encuentra y retorna los archivos de respaldo en el directorio configurado.
     *
     * @return Lista de archivos de respaldo.
     */
    public File[] findBackupFiles() {
        Path backupPath = Paths.get(getBackupPath());
        if (Files.exists(backupPath) && Files.isDirectory(backupPath)) {
            return backupPath.toFile().listFiles();
        }
        return null;
    }

    /**
     * Realiza un respaldo de la base de datos actual.
     *
     * @param fileName Nombre del archivo de respaldo.
     */
    public void backup(String fileName) {
        session.doWork(connection -> {
            try (Statement stmt = connection.createStatement()) {
                connection.setAutoCommit(true);
                stmt.execute("VACUUM INTO '" + fileName + "';");
                connection.setAutoCommit(false);
            } catch (Exception e) {
                log.error("Error while backup", e);
                JOptionPane.showMessageDialog(
                        dialog,
                        "Error al realizar copia de seguridad.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    /**
     * Restablece los datos de la base de datos mediante una respaldo
     *
     * @param fileName path de la base de datos de respaldo
     */
    public void restartBackup(String fileName) {
        session.doWork(connection -> {
            try (Statement stmt = connection.createStatement()) {
                // Habilita el autocommit para ejecutar los comandos
                connection.setAutoCommit(true);

                // Elimina los datos actuales de las tablas
                stmt.execute("DELETE FROM cuenta;");
                stmt.execute("DELETE FROM asiento;");
                stmt.execute("DELETE FROM registro;");
                stmt.execute("DELETE FROM sub_tipo_cuenta;");
                stmt.execute("DELETE FROM tipo_cuenta;");
                stmt.execute("DELETE FROM tipo_documento;");

                // Adjunta la base de datos de respaldo
                stmt.execute("ATTACH DATABASE '" + fileName + "' AS BACKUP;");

                // Copia los datos del respaldo a las tablas principales
                stmt.execute("INSERT INTO main.asiento SELECT * FROM BACKUP.asiento;");
                stmt.execute("INSERT INTO main.cuenta SELECT * FROM BACKUP.cuenta;");
                stmt.execute("INSERT INTO main.registro SELECT * FROM BACKUP.registro;");
                stmt.execute("INSERT INTO main.sub_tipo_cuenta SELECT * FROM BACKUP.sub_tipo_cuenta;");
                stmt.execute("INSERT INTO main.tipo_cuenta SELECT * FROM BACKUP.tipo_cuenta;");
                stmt.execute("INSERT INTO main.tipo_documento SELECT * FROM BACKUP.tipo_documento;");

                // Restaurar el autocommit a su estado inicial
                connection.setAutoCommit(false);
            } catch (Exception e) {
                log.error("Error al realizar copia de seguridad.", e);
                // Manejo de errores durante el proceso de respaldo
                JOptionPane.showMessageDialog(
                        dialog,
                        "Error al restablecer los datos",
                        "Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }

    /**
     * Obtiene la ruta completa del archivo de respaldo, incluyendo su nombre generado
     * dinámicamente según la fecha y hora actual.
     *
     * @return Ruta completa del archivo de respaldo.
     */
    private @NotNull String createFilePathAndName(String fileName) {
        return getBackupPath() + File.separator + fileName + ".sqlite";
    }

    /**
     * Genera un nombre de archivo único para el respaldo, basado en la fecha y hora actuales.
     *
     * @return Nombre del archivo de respaldo.
     */
    private @NotNull String createNameByDate() {
        return "backup_" + LocalDateTime.now().format(getDateFormat());
    }

    /**
     * Modelo de tabla que muestra el nombre y fecha de creacion de los backup
     */
    static class BackupTableModel extends AbstractTableModel {
        private final String[] titles = {"Nombre", "Fecha"};
        private File[] files;

        public BackupTableModel(File[] files) {
            this.files = files;
        }

        public void setDataAndReload(File... newData) {
            files = newData;
            fireTableDataChanged();
        }

        @Override
        public String getColumnName(int column) {
            return titles[column];
        }

        @Override
        public int getRowCount() {
            return files.length;
        }

        @Override
        public int getColumnCount() {
            return titles.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> File.class;
                case 1 -> String.class;
                default -> Object.class;
            };
        }


        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex < files.length) {
                File file = files[rowIndex];
                return switch (columnIndex) {
                    case 0 -> file.getName();
                    case 1 -> {
                        try {
                            BasicFileAttributes attr = Files.readAttributes(Paths.get(file.getPath()), BasicFileAttributes.class);

                            yield attr.creationTime()
                                    .toInstant()
                                    .atZone(ZoneId.systemDefault())
                                    .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
                        } catch (IOException e) {
                            log.error("Error al obtener el fichero de datos.", e);
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Ha ocurrido un error inesperado.",
                                    "Error",
                                    JOptionPane.WARNING_MESSAGE
                            );
                            yield "";
                        }
                    }
                    default -> null;
                };
            }
            return null;
        }
    }
}
