package com.nutrehogar.sistemacontable.application;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.application.service.ConfigLoader;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.ui.SistemaContable;

import javax.swing.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Principal {

    public static void main(String[] args) {
        System.setProperty("LOG_DIR", ConfigLoader.getLogsPath());
        Logger logger = LoggerFactory.getLogger(Principal.class);

        Thread.startVirtualThread(HibernateUtil::getSession);
        //Tarea que se realizara antes de que se apage la JVM, cierra conexión de hibernate
        Thread.startVirtualThread(() -> Runtime.getRuntime().addShutdownHook(new Thread(HibernateUtil::shutdown)));
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            logger.error("Error setting look and feel", ex);
            JOptionPane.showMessageDialog(null, """
                    <html>
                    <h3>Error al cargar el UiManager</h3>
                    <p>Ha ocurrido un problema al iniciar el sistema. </p>
                    <p>Por favor, cierra el programa y contacta al equipo de asistencia para resolver el problema.</p>
                    </html>
                    """, "Error", JOptionPane.ERROR_MESSAGE);
        }

        java.awt.EventQueue.invokeLater(() -> new SistemaContable().setVisible(true));
    }
}
