package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.ui.controller.MayorGenController;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.InvocationTargetException;

public class MGView extends javax.swing.JFrame {


    public MGView() {
        initComponents();
        var pane = MayorGenController.getInstance().getView();
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

    public static void main(String[] args) throws InterruptedException, InvocationTargetException {
        Runtime.getRuntime().addShutdownHook(new Thread(HibernateUtil::shutdown));

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        // Mostrar ventana de carga con JWindow
        JWindow splash = new JWindow();
        splash.getContentPane().add(new JLabel("Cargando..."), BorderLayout.CENTER);
        splash.setSize(300, 100);
        splash.setLocationRelativeTo(null); // Centrado en la pantalla
        splash.setVisible(true);

        HibernateUtil.getSessionFactory();//para que se inicialice en el hilo princiapl
//        Thread.startVirtualThread(HibernateUtil::createSession);// inicia una session en un hilo virtual
        //lo que se ejecute dentro, se ejecuta en el EDT
        SwingUtilities.invokeAndWait(() -> {
            splash.setVisible(false);  // Ocultar pantalla de carga
            new MGView().setVisible(true);  // Mostrar la ventana principal
        });
//        Thread.startVirtualThread(() -> {
//            System.out.println("MGView.main: latch.await()");
//            AsientoRepo.getInstance();
//            CuentaRepo.getInstance();
//            RegistroRepo.getInstance();
//            SubTipoCuentaRepo.getInstance();
//            TipoDocumentoRepo.getInstance();
//            TipoCuentaRepo.getInstance();
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel conteiner;
    // End of variables declaration//GEN-END:variables
}
