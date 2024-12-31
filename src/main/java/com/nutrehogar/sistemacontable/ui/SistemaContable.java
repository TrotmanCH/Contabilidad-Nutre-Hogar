package com.nutrehogar.sistemacontable.ui;

import com.nutrehogar.sistemacontable.application.service.BackupService;
import com.nutrehogar.sistemacontable.ui.controller.*;
import com.nutrehogar.sistemacontable.ui.tabs.*;
import com.nutrehogar.sistemacontable.ui.view.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import javax.swing.*;

public class SistemaContable extends javax.swing.JFrame {
    FormularioPestana formulario = new FormularioPestana();
    LibroDiarioView libroDiario = LibroDiarioController.getInstance().getView();
    BalanceComView balanceComprobacion = BalanceComController.getInstance().getView();
    MayorGenView mayorGeneral = MayorGenController.getInstance().getView();
    CuentasPestana listaCuenta = new CuentasPestana();
    SubtiposCuentaPestana listaSubtipoCuenta = new SubtiposCuentaPestana();
    BackupService backupService =BackupService.getInstance();
    
    public SistemaContable() {
        initComponents(); 
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panContenido.setLayout(new BorderLayout());
        mostrarPestana(formulario);
        
        estilizarBotones(butFormulario, butBalanceComprobacion, butLibroDiario,
                butMayorGeneral, butCuentas, butSubtiposCuenta
        );
        // Poner la siguiente linea en un boton para mostrar la ventana de backups
        backupService.getDialog(this).setVisible(true);
    }
    
    // Estilo de botones
    private void estilizarBotones(JButton... botones) {
        Arrays.asList(botones).forEach((boton) -> { 
            boton.setFocusPainted(false);
            boton.setForeground(Color.WHITE);
            boton.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE)); 
            
            boton.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    boton.setBackground(Color.decode("#2E4156"));  
                }
                @Override
                public void mouseReleased(MouseEvent e) {
                    boton.setBackground(null);  
                }
            });
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panMenu = new javax.swing.JPanel();
        labLogo = new javax.swing.JLabel();
        butFormulario = new javax.swing.JButton();
        butLibroDiario = new javax.swing.JButton();
        butBalanceComprobacion = new javax.swing.JButton();
        butMayorGeneral = new javax.swing.JButton();
        butCuentas = new javax.swing.JButton();
        butSubtiposCuenta = new javax.swing.JButton();
        labOcultarMenu = new javax.swing.JLabel();
        panContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Contable");
        setBackground(new java.awt.Color(241, 248, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new Color(222,222,222));

        panMenu.setBackground(new java.awt.Color(30, 136, 229));

        labLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/nutrehogar_logo.png"))); // NOI18N

        butFormulario.setBackground(new java.awt.Color(30, 136, 229));
        butFormulario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/formulario.png"))); // NOI18N
        butFormulario.setText("Formulario");
        butFormulario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butFormulario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butFormulario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butFormularioActionPerformed(evt);
            }
        });

        butLibroDiario.setBackground(new java.awt.Color(30, 136, 229));
        butLibroDiario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butLibroDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/libro_diario.png"))); // NOI18N
        butLibroDiario.setText("Libro Diario");
        butLibroDiario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butLibroDiario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butLibroDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butLibroDiarioActionPerformed(evt);
            }
        });

        butBalanceComprobacion.setBackground(new java.awt.Color(30, 136, 229));
        butBalanceComprobacion.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butBalanceComprobacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/balance_comprobacion.png"))); // NOI18N
        butBalanceComprobacion.setText("Balance de Comprobación");
        butBalanceComprobacion.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butBalanceComprobacion.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butBalanceComprobacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butBalanceComprobacionActionPerformed(evt);
            }
        });

        butMayorGeneral.setBackground(new java.awt.Color(30, 136, 229));
        butMayorGeneral.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butMayorGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/mayor_general.png"))); // NOI18N
        butMayorGeneral.setText("Mayor General");
        butMayorGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butMayorGeneral.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butMayorGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMayorGeneralActionPerformed(evt);
            }
        });

        butCuentas.setBackground(new java.awt.Color(30, 136, 229));
        butCuentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cuentas.png"))); // NOI18N
        butCuentas.setText("Cuentas");
        butCuentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCuentasActionPerformed(evt);
            }
        });

        butSubtiposCuenta.setBackground(new java.awt.Color(30, 136, 229));
        butSubtiposCuenta.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butSubtiposCuenta.setText("Subtipos de Cuenta");
        butSubtiposCuenta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butSubtiposCuenta.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butSubtiposCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butSubtiposCuentaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panMenuLayout = new javax.swing.GroupLayout(panMenu);
        panMenu.setLayout(panMenuLayout);
        panMenuLayout.setHorizontalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butMayorGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butBalanceComprobacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butLibroDiario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butFormulario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labLogo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butCuentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butSubtiposCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panMenuLayout.setVerticalGroup(
            panMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panMenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labLogo)
                .addGap(9, 9, 9)
                .addComponent(butFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butLibroDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butBalanceComprobacion, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butMayorGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butSubtiposCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labOcultarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/menu_ocultar.png"))); // NOI18N
        labOcultarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labOcultarMenuMouseClicked(evt);
            }
        });

        panContenido.setBackground(new java.awt.Color(255, 102, 102));
        panContenido.setPreferredSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panContenidoLayout = new javax.swing.GroupLayout(panContenido);
        panContenido.setLayout(panContenidoLayout);
        panContenidoLayout.setHorizontalGroup(
            panContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 781, Short.MAX_VALUE)
        );
        panContenidoLayout.setVerticalGroup(
            panContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(labOcultarMenu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 548, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(labOcultarMenu)
                .addContainerGap(256, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Escuchadores de botones
    private void butFormularioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butFormularioActionPerformed
        mostrarPestana(formulario);
    }//GEN-LAST:event_butFormularioActionPerformed
    
    private void butLibroDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butLibroDiarioActionPerformed
        mostrarPestana(libroDiario);
    }//GEN-LAST:event_butLibroDiarioActionPerformed

    private void butBalanceComprobacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butBalanceComprobacionActionPerformed
        mostrarPestana(balanceComprobacion);
    }//GEN-LAST:event_butBalanceComprobacionActionPerformed

    private void butMayorGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butMayorGeneralActionPerformed
        mostrarPestana(mayorGeneral);
    }//GEN-LAST:event_butMayorGeneralActionPerformed

    private void butCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCuentasActionPerformed
        mostrarPestana(listaCuenta);
    }//GEN-LAST:event_butCuentasActionPerformed
    
    private void butSubtiposCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butSubtiposCuentaActionPerformed
        mostrarPestana(listaSubtipoCuenta);
    }//GEN-LAST:event_butSubtiposCuentaActionPerformed

    // Escuchador de labOcultarMenu
    private void labOcultarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labOcultarMenuMouseClicked
        panMenu.setVisible(!panMenu.isVisible());

        if (panMenu.isVisible()) {
            labOcultarMenu.setIcon(new ImageIcon(getClass().getResource("/icons/menu_ocultar.png"))); 
        } else {
            labOcultarMenu.setIcon(new ImageIcon(getClass().getResource("/icons/menu_mostrar.png")));
        }

        revalidate();
        repaint();
    }//GEN-LAST:event_labOcultarMenuMouseClicked
    
    private void mostrarPestana(JPanel pestana){
        pestana.setBackground(new Color(241,248,255));
        panContenido.removeAll();
        panContenido.add(pestana);
        panContenido.revalidate();
        panContenido.repaint();
    }
        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butBalanceComprobacion;
    private javax.swing.JButton butCuentas;
    private javax.swing.JButton butFormulario;
    private javax.swing.JButton butLibroDiario;
    private javax.swing.JButton butMayorGeneral;
    private javax.swing.JButton butSubtiposCuenta;
    private javax.swing.JLabel labLogo;
    private javax.swing.JLabel labOcultarMenu;
    private javax.swing.JPanel panContenido;
    private javax.swing.JPanel panMenu;
    // End of variables declaration//GEN-END:variables
}

