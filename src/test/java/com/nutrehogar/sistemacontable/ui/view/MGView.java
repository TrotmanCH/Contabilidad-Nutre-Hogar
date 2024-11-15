package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class MGView extends javax.swing.JFrame {


    public MGView() {
        initComponents();
        var pane = new MGPanel();
        conteiner.removeAll();
        conteiner.setLayout(new BorderLayout());  // Añade esta línea para restablecer el diseño del Content
        conteiner.add(pane, BorderLayout.CENTER);
        conteiner.revalidate();
        conteiner.repaint();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        conteiner = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout conteinerLayout = new javax.swing.GroupLayout(conteiner);
        conteiner.setLayout(conteinerLayout);
        conteinerLayout.setHorizontalGroup(
                conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 886, Short.MAX_VALUE)
        );
        conteinerLayout.setVerticalGroup(
                conteinerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 458, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(conteiner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new MGView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel conteiner;
    // End of variables declaration//GEN-END:variables
}
