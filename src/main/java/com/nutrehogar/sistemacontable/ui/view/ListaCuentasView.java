package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.view.CuentaView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class ListaCuentasView extends javax.swing.JFrame {

    public ListaCuentasView() {
        initComponents();
        tblCuenta.getSelectionModel().addListSelectionListener(this::isSelectRow);
        btnActualizar.setEnabled(false);


        List<Cuenta> ListaCuenta = CuentaRepo.getInstance().findAll();
        DefaultTableModel model = (DefaultTableModel)tblCuenta.getModel();
        for (Cuenta cuenta : ListaCuenta) {
            model.addRow(new Object[]{
            cuenta.getId(),cuenta.getNombre(),cuenta.getSubTipoCuenta().getNombre(),cuenta.getSubTipoCuenta().getTipoCuenta().getNombre()
        });
        }

    }

    public void isSelectRow(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectRow = tblCuenta.getSelectedRow();
            if (selectRow != -1) {
                btnActualizar.setEnabled(true);
            } else {
                btnActualizar.setEnabled(false);
            }
        }

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cuentas");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("NUTRE HOGAR BOCAS");

        tblCuenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOMBRE", "TIPO CUENTA", "SUBTIPO CUENTA"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCuenta);

        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 634, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnCrear)
                        .addGap(120, 120, 120)
                        .addComponent(btnActualizar)
                        .addGap(116, 116, 116)
                        .addComponent(btnEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(237, 237, 237)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCrear)
                    .addComponent(btnActualizar)
                    .addComponent(btnEliminar))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed

        DefaultTableModel tblCuentaModelo = (DefaultTableModel) tblCuenta.getModel();
        new CuentaView(tblCuentaModelo).setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        //seleccionando la cuenta
        /*int selectedRow = tblCuenta.getSelectedRow();
        System.out.println(selectedRow); */
        
        int selectedRow = tblCuenta.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cuenta para actualizar.");
            return;
    }
        // Obtener los datos de la fila seleccionada
        String id = tblCuenta.getValueAt(selectedRow, 0).toString();
        String nombreActual = tblCuenta.getValueAt(selectedRow, 1).toString();
        String subTipoCuentaActual = tblCuenta.getValueAt(selectedRow, 3).toString();

        // Abrir el formulario de edición y pasar los datos
        new EditarCuentaView(id, nombreActual, subTipoCuentaActual, (DefaultTableModel) tblCuenta.getModel(), selectedRow).setVisible(true);
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //CuentaRepo.getInstance().delete(tblCuenta.get);
        int selectedRow = tblCuenta.getSelectedRow();

        // Verificar si hay una fila seleccionada
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una cuenta para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar esta cuenta?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        String id = tblCuenta.getValueAt(selectedRow, 0).toString();
        try {
        // Llamar al repositorio para eliminar la cuenta
        CuentaRepo cuentaRepo = CuentaRepo.getInstance();
        cuentaRepo.delete(id);

        // Eliminar la fila de la tabla
        ((DefaultTableModel) tblCuenta.getModel()).removeRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Cuenta eliminada exitosamente.");
    } catch (Exception e) {
        JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar la cuenta: " + e.getMessage());
        e.printStackTrace();
    }
    }//GEN-LAST:event_btnEliminarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> new ListaCuentasView().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuenta;
    // End of variables declaration//GEN-END:variables

}