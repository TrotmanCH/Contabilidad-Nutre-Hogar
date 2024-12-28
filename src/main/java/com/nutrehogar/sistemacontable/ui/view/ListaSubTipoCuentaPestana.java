package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.styles.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ListaSubTipoCuentaPestana extends javax.swing.JPanel {
    DefaultTableModel tabSubtipoCuentasModelo;
    ListSelectionModel listaSeleccionModelo;
    
    public ListaSubTipoCuentaPestana() {
        initComponents();
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabSubtipoCuentas.clearSelection();
            }
        });
        
        tabSubtipoCuentasModelo = (DefaultTableModel) tabSubtipoCuentas.getModel();
        listaSeleccionModelo = tabSubtipoCuentas.getSelectionModel();
        
        listaSeleccionModelo.addListSelectionListener(this::listaSeleccionEscuchador);
        listaSeleccionModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        estilizarComponentes();
        
        for (SubTipoCuenta subtipoCuenta : SubTipoCuentaRepo.findAll()) {
            tabSubtipoCuentasModelo.addRow(new Object[] {
                subtipoCuenta.getId(),subtipoCuenta.getNombre(),
                subtipoCuenta.getTipoCuenta().getNombre()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labListaSubtipoCuentas = new javax.swing.JLabel();
        scrpanSubtipoCuentas = new javax.swing.JScrollPane();
        tabSubtipoCuentas = new javax.swing.JTable();
        panAcciones = new javax.swing.JPanel();
        butAnadir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 248, 255));

        labListaSubtipoCuentas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labListaSubtipoCuentas.setText("Lista de Subtipos de Cuentas");

        tabSubtipoCuentas.setAutoCreateRowSorter(true);
        tabSubtipoCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Tipo de Cuenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrpanSubtipoCuentas.setViewportView(tabSubtipoCuentas);

        panAcciones.setBackground(new java.awt.Color(241, 248, 255));
        panAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        butAnadir.setBackground(new java.awt.Color(242, 242, 242));
        butAnadir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butAnadir.setForeground(new java.awt.Color(255, 255, 255));
        butAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/anadir.png"))); // NOI18N
        butAnadir.setText("Anadir");
        butAnadir.setPreferredSize(new java.awt.Dimension(139, 42));
        butAnadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butAnadirActionPerformed(evt);
            }
        });

        butEditar.setBackground(new java.awt.Color(242, 242, 242));
        butEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butEditar.setForeground(new java.awt.Color(255, 255, 255));
        butEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        butEditar.setText("Editar");
        butEditar.setEnabled(false);
        butEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEditarActionPerformed(evt);
            }
        });

        butEliminar.setBackground(new java.awt.Color(242, 242, 242));
        butEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butEliminar.setForeground(new java.awt.Color(255, 255, 255));
        butEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/eliminar.png"))); // NOI18N
        butEliminar.setText("Eliminar");
        butEliminar.setEnabled(false);
        butEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panAccionesLayout = new javax.swing.GroupLayout(panAcciones);
        panAcciones.setLayout(panAccionesLayout);
        panAccionesLayout.setHorizontalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(butEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butAnadir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        panAccionesLayout.setVerticalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAccionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(butAnadir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(butEditar)
                .addGap(11, 11, 11)
                .addComponent(butEliminar)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrpanSubtipoCuentas)
                .addGap(20, 20, 20)
                .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(249, Short.MAX_VALUE)
                .addComponent(labListaSubtipoCuentas)
                .addContainerGap(269, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labListaSubtipoCuentas)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(scrpanSubtipoCuentas)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(147, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Estilo de los componentes
    private void estilizarComponentes() {
        new TableStyle(tabSubtipoCuentas); // Tabla
        
        // Columnas especificas
        tabSubtipoCuentas.getColumnModel().getColumn(0).setMaxWidth(80);
        ((DefaultTableCellRenderer) tabSubtipoCuentas.getColumnModel().getColumn(1).getCellRenderer())
                .setHorizontalAlignment(SwingConstants.LEFT);
        
        new ButtonStyle(butAnadir, butEditar, butEliminar);  // Botones
    }
    
    // Escuchador de tabCuentas
    public void listaSeleccionEscuchador(ListSelectionEvent e) {
        if (tabSubtipoCuentas.getSelectedRow() != -1) {
            butEditar.setEnabled(true);
            butEliminar.setEnabled(true);
        } else {
            butEditar.setEnabled(false);
            butEliminar.setEnabled(false);
        }
    }
    
    // Escuchadores de los botones
    private void butAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAnadirActionPerformed
        SubTipoCuentaVentana scv = new SubTipoCuentaVentana(tabSubtipoCuentasModelo, "Crear Subtipo",
                null, null); 
        scv.setLocationRelativeTo(null); 
        scv.setVisible(true);
    }//GEN-LAST:event_butAnadirActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaSubtipoCuenta = tabSubtipoCuentas.getSelectedRow();
            String subtipoCuentaCodigo = tabSubtipoCuentas.getValueAt(filaSubtipoCuenta, 0).toString();
            SubTipoCuenta subtipoCuentaSeleccionada = SubTipoCuentaRepo.findById(subtipoCuentaCodigo);
            SubTipoCuentaVentana scv = new SubTipoCuentaVentana(tabSubtipoCuentasModelo, "Editar Subtipo", 
                    filaSubtipoCuenta, subtipoCuentaSeleccionada); 
            scv.setLocationRelativeTo(null); 
            scv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un subtipo en la tabla.");
        }
    }//GEN-LAST:event_butEditarActionPerformed

    private void butEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEliminarActionPerformed
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaSubtipoCuenta = tabSubtipoCuentas.getSelectedRow();
            String subtipoCuentaCodigo = tabSubtipoCuentas.getValueAt(filaSubtipoCuenta, 0).toString();
            Integer confirmar = JOptionPane.showConfirmDialog(
                this, "¿Está seguro de que desea eliminar este subtipo?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION
            );
            
            if (confirmar == JOptionPane.YES_OPTION) {
                tabSubtipoCuentasModelo.removeRow(filaSubtipoCuenta);
                SubTipoCuentaRepo.delete(subtipoCuentaCodigo);
                JOptionPane.showMessageDialog(this, "Subtipo eliminado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un subtipo en la tabla.");
        }
    }//GEN-LAST:event_butEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butEliminar;
    private javax.swing.JLabel labListaSubtipoCuentas;
    private javax.swing.JPanel panAcciones;
    private javax.swing.JScrollPane scrpanSubtipoCuentas;
    private javax.swing.JTable tabSubtipoCuentas;
    // End of variables declaration//GEN-END:variables
}
