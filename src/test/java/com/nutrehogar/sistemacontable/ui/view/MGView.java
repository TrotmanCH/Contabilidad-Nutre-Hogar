package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGenField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.ui.controller.MayorGenController;
import com.nutrehogar.sistemacontable.ui.view.components.MayorGenTableModel;

import javax.swing.*;
import java.util.List;

public class MGView extends javax.swing.JFrame {
    MayorGenTableModel MGTableModel;
    MayorGenController MGController;

    public MGView() {
        MGTableModel = new MayorGenTableModel(List.of());
        MGController = new MayorGenController(MGTableModel);
        MGController.applyFiltersAndOrder(List.of(new MayorGenFilter.ByCuentaId("2")), MayorGenField.ASIENTO_FECHA, OrderDirection.ASCENDING);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        localDateSpinner2 = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        mayorGenTable1 = new com.nutrehogar.sistemacontable.ui.view.components.MayorGenTable();
        localDateSpinner1 = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        localDateSpinner3 = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mayorGenTable1.setModel(MGTableModel);
        jScrollPane1.setViewportView(mayorGenTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(localDateSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60)
                .addComponent(localDateSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(localDateSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(localDateSpinner3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)))
                .addComponent(jScrollPane1)
                .addGap(118, 118, 118))
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
    private javax.swing.JScrollPane jScrollPane1;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner localDateSpinner1;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner localDateSpinner2;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner localDateSpinner3;
    private com.nutrehogar.sistemacontable.ui.view.components.MayorGenTable mayorGenTable1;
    // End of variables declaration//GEN-END:variables
}
