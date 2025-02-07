package com.nutrehogar.sistemacontable.application;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.ui.SistemaContable;
import javax.swing.UIManager;

public class Principal {
    public static void main(String args[]) {
        try {
           UIManager.setLookAndFeel(new FlatLightLaf());
        } catch(Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SistemaContable().setVisible(true);
            }
        });
    }
}
