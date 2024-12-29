/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.nutrehogar.sistemacontable.ui.services;

import lombok.Getter;
import lombok.Setter;
/**
 * Propiedades de BackUp
 *
 * @author Calcifer1331
 */
@Getter
@Setter
public class BackupPanel extends javax.swing.JPanel {

    public BackupPanel() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableBackup = new javax.swing.JTable();
        btnClose = new javax.swing.JButton();
        labelDescription1 = new javax.swing.JLabel();
        labelSection1 = new javax.swing.JLabel();
        sepaSection1 = new javax.swing.JSeparator();
        panelSection2 = new javax.swing.JPanel();
        labelDescriptionRestarBackup = new javax.swing.JLabel();
        btnRestarBackup = new javax.swing.JButton();
        labelDescriptionRestarBackup1 = new javax.swing.JLabel();
        btnCreateBackup = new javax.swing.JButton();

        tableBackup.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "2", "3", null},
                {"fthgj", "tfyghj", "tfyguhj", null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title aaa", "Title yghj", "Title ftyghj", "Title 4aa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tableBackup);

        btnClose.setText("Cerrar");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        labelDescription1.setText("<html> <p>Estas copias permiten restaurar la base de datos en caso de pérdida total o parcial de datos debido a eventos inesperados. </p> <p>También se realizan para proteger los datos en caso de supresión accidental y corrupción de la base de datos.</p> </html>");
        labelDescription1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        labelSection1.setText("Lista de Copias");

        panelSection2.setBorder(javax.swing.BorderFactory.createTitledBorder("Operaciones"));

        labelDescriptionRestarBackup.setText("<html>\n<p>Para restaurar los datos a partir de una copia de seguridad anterior, selecione alguna de la tabla de arriba y presione en el boton \"Restaurar\"</p>\n</html>");
        labelDescriptionRestarBackup.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnRestarBackup.setText("Restaurar Copia");
        btnRestarBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestarBackupActionPerformed(evt);
            }
        });

        labelDescriptionRestarBackup1.setText("<html> <p>Se creara una copia de seguridad con los datos actuales</p> </html>");
        labelDescriptionRestarBackup1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        btnCreateBackup.setText("Crear Copia");

        javax.swing.GroupLayout panelSection2Layout = new javax.swing.GroupLayout(panelSection2);
        panelSection2.setLayout(panelSection2Layout);
        panelSection2Layout.setHorizontalGroup(
            panelSection2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSection2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSection2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelDescriptionRestarBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(labelDescriptionRestarBackup1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSection2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestarBackup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSection2Layout.setVerticalGroup(
            panelSection2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelSection2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(panelSection2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescriptionRestarBackup1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCreateBackup))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSection2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescriptionRestarBackup, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnRestarBackup))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelSection2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSection1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(sepaSection1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnClose)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDescription1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelSection1)
                    .addComponent(sepaSection1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 157, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelSection2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnClose)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnRestarBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestarBackupActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnRestarBackupActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnCreateBackup;
    private javax.swing.JButton btnRestarBackup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescription1;
    private javax.swing.JLabel labelDescriptionRestarBackup;
    private javax.swing.JLabel labelDescriptionRestarBackup1;
    private javax.swing.JLabel labelSection1;
    private javax.swing.JPanel panelSection2;
    private javax.swing.JSeparator sepaSection1;
    private javax.swing.JTable tableBackup;
    // End of variables declaration//GEN-END:variables
}
