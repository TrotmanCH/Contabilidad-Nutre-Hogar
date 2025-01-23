package com.nutrehogar.sistemacontable.application;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.application.config.ConfigLoader;
import com.nutrehogar.sistemacontable.ui.SistemaContable;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.util.concurrent.atomic.AtomicBoolean;

@Slf4j
public class Principal {

    private static final AtomicBoolean isShutdownHookRegistered = new AtomicBoolean(false);

    public static void main(String[] args) {
        // Configurar el directorio de logs
        System.setProperty("LOG_DIR", ConfigLoader.getLogsPath());

        // Registrar el hook de apagado para Hibernate
        registerShutdownHook();

        // Inicializar la sesión de Hibernate en un hilo virtual
        Session session = HibernateUtil.getSession();

        // Configurar el Look and Feel de la interfaz gráfica
        setupLookAndFeel();

        // Iniciar la interfaz gráfica en el hilo de eventos de Swing
        java.awt.EventQueue.invokeLater(() -> {
            new SistemaContable().setVisible(true);
        });
    }

    /**
     * Registra un hook de apagado para cerrar Hibernate correctamente al salir de la aplicación.
     */
    private static void registerShutdownHook() {
        if (!isShutdownHookRegistered.getAndSet(true)) {
            Thread.startVirtualThread(() -> Runtime.getRuntime().addShutdownHook(new Thread(HibernateUtil::shutdown)));
        }
    }


    /**
     * Configura el Look and Feel de la interfaz gráfica.
     */
    private static void setupLookAndFeel() {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            log.error("Error al configurar el Look and Feel", ex);
            showErrorDialog("""
                    <html>
                    <h3>Error al cargar la interfaz gráfica</h3>
                    <p>Ha ocurrido un problema al iniciar el sistema.</p>
                    <p>Por favor, cierra el programa y contacta al equipo de asistencia para resolver el problema.</p>
                    </html>
                    """);
            System.exit(1);
        }
    }


    /**
     * Muestra un diálogo de error con un mensaje personalizado.
     *
     * @param message El mensaje de error en formato HTML.
     */
    private static void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
}