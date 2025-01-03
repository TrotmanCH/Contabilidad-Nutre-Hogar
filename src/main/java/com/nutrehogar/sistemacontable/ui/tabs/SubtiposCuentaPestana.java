package com.nutrehogar.sistemacontable.ui.tabs;

import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.styles.*;
import com.nutrehogar.sistemacontable.ui.windows.SubtiposCuentaVentana;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class SubtiposCuentaPestana extends javax.swing.JPanel {
    public SubtiposCuentaPestana() {
        initComponents();
        estilizarComponentes();
        
        // Configurando la selección en tabSubtiposCuentas        
        tabSubtiposCuenta.getSelectionModel()
                .addListSelectionListener(this::seleccionEscuchador);
        tabSubtiposCuenta.getSelectionModel()
                .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tabSubtiposCuenta.clearSelection();
            }
        });
        
        // Llenando tabSubtiposCuentas
        SubTipoCuentaRepo.findAll().forEach(subtipoCuenta -> {
            ((DefaultTableModel) tabSubtiposCuenta.getModel()).addRow(new Object[] {
                subtipoCuenta.getId(),subtipoCuenta.getNombre(),
                subtipoCuenta.getTipoCuenta().getNombre()
            });
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labSubtiposCuenta = new javax.swing.JLabel();
        scrpanSubtiposCuenta = new javax.swing.JScrollPane();
        tabSubtiposCuenta = new javax.swing.JTable();
        panAcciones = new javax.swing.JPanel();
        butAnadir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 248, 255));

        labSubtiposCuenta.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labSubtiposCuenta.setText("Subtipos de Cuenta");

        tabSubtiposCuenta.setAutoCreateRowSorter(true);
        tabSubtiposCuenta.setModel(new javax.swing.table.DefaultTableModel(
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
        tabSubtiposCuenta.getTableHeader().setReorderingAllowed(false);
        scrpanSubtiposCuenta.setViewportView(tabSubtiposCuenta);
        if (tabSubtiposCuenta.getColumnModel().getColumnCount() > 0) {
            tabSubtiposCuenta.getColumnModel().getColumn(0).setMinWidth(160);
            tabSubtiposCuenta.getColumnModel().getColumn(0).setPreferredWidth(160);
            tabSubtiposCuenta.getColumnModel().getColumn(0).setMaxWidth(160);
            tabSubtiposCuenta.getColumnModel().getColumn(2).setMinWidth(240);
            tabSubtiposCuenta.getColumnModel().getColumn(2).setPreferredWidth(240);
            tabSubtiposCuenta.getColumnModel().getColumn(2).setMaxWidth(240);
        }

        panAcciones.setBackground(new java.awt.Color(241, 248, 255));
        panAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        butAnadir.setBackground(new java.awt.Color(242, 242, 242));
        butAnadir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butAnadir.setForeground(new java.awt.Color(255, 255, 255));
        butAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/anadir.png"))); // NOI18N
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
        butEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png"))); // NOI18N
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
        butEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/eliminar.png"))); // NOI18N
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
                .addComponent(scrpanSubtiposCuenta)
                .addGap(20, 20, 20)
                .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(301, Short.MAX_VALUE)
                .addComponent(labSubtiposCuenta)
                .addContainerGap(320, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labSubtiposCuenta)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(scrpanSubtiposCuenta)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(147, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Estilo de los componentes
    private void estilizarComponentes() {
        TableStyle.setStyle(tabSubtiposCuenta); // Tabla
        ButtonStyle.setStyle(butAnadir, butEditar, butEliminar);  // Botones
    }
    
    // Escuchador de selección de tabSubtiposCuentas
    public void seleccionEscuchador(ListSelectionEvent e) {
        if (tabSubtiposCuenta.getSelectedRow() != -1) {
            butEditar.setEnabled(true);
            butEliminar.setEnabled(true);
        } else {
            butEditar.setEnabled(false);
            butEliminar.setEnabled(false);
        }
    }
    
    // Escuchadores de los botones
    private void butAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAnadirActionPerformed
        SubtiposCuentaVentana scv = new SubtiposCuentaVentana(
                "Añadir Subtipo", (DefaultTableModel) tabSubtiposCuenta.getModel(),
                null, null); 
        scv.setLocationRelativeTo(null); 
        scv.setVisible(true);
    }//GEN-LAST:event_butAnadirActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
        if (!tabSubtiposCuenta.getSelectionModel().isSelectionEmpty()) {
            Integer filaIndice = tabSubtiposCuenta.getSelectedRow();
            String filaCodigo = tabSubtiposCuenta.getValueAt(filaIndice, 0).toString();
            SubTipoCuenta subtipoCuentaBuscada = SubTipoCuentaRepo.findById(filaCodigo);
            
            SubtiposCuentaVentana scv = new SubtiposCuentaVentana(
                    "Editar Subtipo", (DefaultTableModel) tabSubtiposCuenta.getModel(), 
                    filaIndice, subtipoCuentaBuscada); 
            scv.setLocationRelativeTo(null); 
            scv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un subtipo en la tabla.");
        }
    }//GEN-LAST:event_butEditarActionPerformed

    private void butEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEliminarActionPerformed
        if (!tabSubtiposCuenta.getSelectionModel().isSelectionEmpty()) {
            Integer filaIndice = tabSubtiposCuenta.getSelectedRow();
            String filaCodigo = tabSubtiposCuenta.getValueAt(filaIndice, 0).toString();
            Integer respuesta = JOptionPane.showConfirmDialog(
                this, "¿Está seguro de que desea eliminar este subtipo?",
                "Eliminar Subtipo", JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                SubTipoCuentaRepo.delete(filaCodigo);
                ((DefaultTableModel) tabSubtiposCuenta.getModel()).removeRow(filaIndice);
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
    private javax.swing.JLabel labSubtiposCuenta;
    private javax.swing.JPanel panAcciones;
    private javax.swing.JScrollPane scrpanSubtiposCuenta;
    private javax.swing.JTable tabSubtiposCuenta;
    // End of variables declaration//GEN-END:variables
}
