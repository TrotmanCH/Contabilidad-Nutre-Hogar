package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.ui.controller.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.*;

public class SistemaContable extends javax.swing.JFrame {
    FormularioPestana formulario = new FormularioPestana();
    LibroDiarioView libroDiario = LibroDiarioController.getInstance().getView();
    BalanceComView balanceComprobacion = BalanceComController.getInstance().getView();
    MayorGenView mayorGeneral = MayorGenController.getInstance().getView();
    ListaCuentaPestana listaCuenta = new ListaCuentaPestana();
    ListaSubTipoCuentaPestana listaSubtipoCuenta = new ListaSubTipoCuentaPestana();
    
    public SistemaContable() {
        initComponents(); 
        
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        panContenido.setLayout(new BorderLayout());
        mostrarPestana(formulario);
        
        estilizarBotones(butFormulario, butBalanceComprobacion, butLibroDiario,
                butMayorGeneral, butListaCuentas, butListaSubtipoCuentas
        );
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
        butListaCuentas = new javax.swing.JButton();
        butListaSubtipoCuentas = new javax.swing.JButton();
        labOcultarMenu = new javax.swing.JLabel();
        panContenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema Contable");
        setBackground(new java.awt.Color(241, 248, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setForeground(new Color(222,222,222));

        panMenu.setBackground(new java.awt.Color(30, 136, 229));

        labLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo_big.png"))); // NOI18N

        butFormulario.setBackground(new java.awt.Color(30, 136, 229));
        butFormulario.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butFormulario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/formulario.png"))); // NOI18N
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
        butLibroDiario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/libro_diario.png"))); // NOI18N
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
        butBalanceComprobacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/balance_comprobacion.png"))); // NOI18N
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
        butMayorGeneral.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/mayor_general.png"))); // NOI18N
        butMayorGeneral.setText("Mayor General");
        butMayorGeneral.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butMayorGeneral.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butMayorGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butMayorGeneralActionPerformed(evt);
            }
        });

        butListaCuentas.setBackground(new java.awt.Color(30, 136, 229));
        butListaCuentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butListaCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lista_cuentas.png"))); // NOI18N
        butListaCuentas.setText("Lista de Cuentas");
        butListaCuentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butListaCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butListaCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butListaCuentasActionPerformed(evt);
            }
        });

        butListaSubtipoCuentas.setBackground(new java.awt.Color(30, 136, 229));
        butListaSubtipoCuentas.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        butListaSubtipoCuentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/lista_cuentas.png"))); // NOI18N
        butListaSubtipoCuentas.setText("Lista Subtipos de Cuentas");
        butListaSubtipoCuentas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        butListaSubtipoCuentas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        butListaSubtipoCuentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butListaSubtipoCuentasActionPerformed(evt);
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
                    .addComponent(butListaCuentas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butListaSubtipoCuentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(butListaCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(butListaSubtipoCuentas, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        labOcultarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/menu_ocultar.png"))); // NOI18N
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
            .addGap(0, 812, Short.MAX_VALUE)
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
                .addComponent(panContenido, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
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

    private void butListaCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butListaCuentasActionPerformed
        mostrarPestana(listaCuenta);
    }//GEN-LAST:event_butListaCuentasActionPerformed
    
    private void butListaSubtipoCuentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butListaSubtipoCuentasActionPerformed
        mostrarPestana(listaSubtipoCuenta);
    }//GEN-LAST:event_butListaSubtipoCuentasActionPerformed

    // Escuchador de labOcultarMenu
    private void labOcultarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labOcultarMenuMouseClicked
        panMenu.setVisible(!panMenu.isVisible());

        if (panMenu.isVisible()) {
            labOcultarMenu.setIcon(new ImageIcon(getClass().getResource("/icon/menu_ocultar.png"))); 
        } else {
            labOcultarMenu.setIcon(new ImageIcon(getClass().getResource("/icon/menu_mostrar.png")));
        }

        revalidate();
        repaint();
    }//GEN-LAST:event_labOcultarMenuMouseClicked
    
    public static void mostrarPestana(JPanel pestana){
       pestana.setBackground(new Color(241,248,255));
       panContenido.removeAll();
       panContenido.add(pestana);
       panContenido.revalidate();
       panContenido.repaint();
    }
    
    // Método main
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
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butBalanceComprobacion;
    private javax.swing.JButton butFormulario;
    private javax.swing.JButton butLibroDiario;
    private javax.swing.JButton butListaCuentas;
    private javax.swing.JButton butListaSubtipoCuentas;
    private javax.swing.JButton butMayorGeneral;
    private javax.swing.JLabel labLogo;
    private javax.swing.JLabel labOcultarMenu;
    private static javax.swing.JPanel panContenido;
    private javax.swing.JPanel panMenu;
    // End of variables declaration//GEN-END:variables


}

