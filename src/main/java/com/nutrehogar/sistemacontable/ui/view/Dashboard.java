/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.ui.controller.MayorGenController;

import javax.swing.*;
import java.awt.*;

/**
 * @author charl
 */
public class Dashboard extends javax.swing.JFrame {
// private Formulario formulario;

    private static javax.swing.JPanel content;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalancec;
    private javax.swing.JButton btnDiario;
    private javax.swing.JButton btnMayor;
    private javax.swing.JLabel btnT;
    private javax.swing.JButton btnform;
    private javax.swing.JPanel menup;

    public Dashboard() {
        initComponents();
//        formulario = new Formulario();
//        showJPanel();
        ajustarImagenToggle();
        applyButtonStyles(btnform, "Formulario", "/Icon/formulario.png");
        applyButtonStyles(btnBalancec, "Balance de Comprobación", "/Icon/balance.png");
        applyButtonStyles(btnDiario, "Libro Diario", "/Icon/book.png");
        applyButtonStyles(btnMayor, "Mayor General", "/Icon/mayor.png");
    }

    public static void showJPanel(JPanel p) {
        content.removeAll();
        content.setLayout(new BorderLayout());
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menup = new javax.swing.JPanel();
        btnform = new javax.swing.JButton();
        btnDiario = new javax.swing.JButton();
        btnBalancec = new javax.swing.JButton();
        btnMayor = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        btnT = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 255));

        menup.setBackground(new java.awt.Color(51, 204, 255));

        javax.swing.GroupLayout menupLayout = new javax.swing.GroupLayout(menup);
        menup.setLayout(menupLayout);
        menupLayout.setHorizontalGroup(
                menupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnform, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                        .addComponent(btnDiario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBalancec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnMayor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        menupLayout.setVerticalGroup(
                menupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(menupLayout.createSequentialGroup()
                                .addGap(169, 169, 169)
                                .addComponent(btnform, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBalancec, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(247, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
                contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 864, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
                contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 614, Short.MAX_VALUE)
        );

        btnT.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(menup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(menup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(btnT, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ajustarImagenToggle() {
        ImageIcon originalIcon = new ImageIcon("C:\\Users\\charl\\OneDrive\\I SEMESTRE\\Documentos\\Contabilidad-Nutre-Hogar\\src\\main\\resources\\Icon\\regresa2.png");
// Obtener el tamaño del botón
        int buttonWidth = btnT.getWidth();
        int buttonHeight = btnT.getHeight(); // Redimensionar la imagen para que se ajuste al tamaño del botón
        Image scaledImage = originalIcon.getImage().getScaledInstance(buttonWidth, buttonHeight, Image.SCALE_SMOOTH);
// Establecer la imagen redimensionada en el botón
        btnT.setIcon(new ImageIcon(scaledImage));
    }

    private void applyButtonStyles(JButton button, String text, String iconPath) {
        button.setText("<html><center><span style='text-decoration: underline;'>" + text + "</span></center></html>");
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setHorizontalTextPosition(SwingConstants.RIGHT);
        button.setVerticalTextPosition(SwingConstants.CENTER);
        button.setFocusPainted(false);

        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setForeground(Color.BLACK);

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);

        button.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(220, 220, 220));
                button.setOpaque(true);
                button.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setBackground(new Color(0, 0, 0, 0));
                button.setOpaque(false);
            }
        });
    }

    public ImageIcon setSVG(String filePath, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(filePath);
// Cargar la imagen
        Image image = imageIcon.getImage();
// Obtener la imagen
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
// Redimensionar la imagen
        return new ImageIcon(resizedImage);
    } // Devolver la nueva imagen redimensionada }
    // End of variables declaration//GEN-END:variables


}

