package com.nutrehogar.sistemacontable.application;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.ui.SistemaContable;

import javax.swing.*;

public class Principal {
    public static void main(String[] args) {
        Thread.startVirtualThread(HibernateUtil::getSession);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            System.err.println("Failed to initialize LaF");
            JOptionPane.showMessageDialog(null,
                    """
                            <html>
                            <h3>Error al cargar el UiManager</h3>
                            <p>Ha ocurrido un problema al iniciar el sistema. </p>
                            <p>Por favor, cierra el programa y contacta al equipo de asistencia para resolver el problema.</p>
                            </html>
                            """,
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

        java.awt.EventQueue.invokeLater(() -> new SistemaContable().setVisible(true));

        //Tarea que se realizara antes de que se apage la JVM, cierra conexión de hibernate
        Runtime.getRuntime().addShutdownHook(new Thread(HibernateUtil::shutdown));
    }
}
