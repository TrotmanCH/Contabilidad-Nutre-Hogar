package com.nutrehogar.sistemacontable.ui.tabs;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.ui.styles.*;
import com.nutrehogar.sistemacontable.ui.styles.*;
import com.nutrehogar.sistemacontable.ui.windows.CuentaVentana;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CuentasPestana extends javax.swing.JPanel {
    public CuentasPestana() {
        initComponents();
        estilizarComponentes();
               
        // Configurando la selección en tabCuentas
        tabCuentas.getSelectionModel()
                .addListSelectionListener(this::seleccionEscuchador);
        tabCuentas.getSelectionModel()
                .setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tabCuentas.clearSelection();
            }
        });
        
        // Llenando tabCuentas
        CuentaRepo.findAll().forEach(cuenta -> {
            ((DefaultTableModel) tabCuentas.getModel()).addRow(new Object[] {
                cuenta.getId(),cuenta.getNombre(),
                cuenta.getSubTipoCuenta().getTipoCuenta().getNombre(),
                cuenta.getSubTipoCuenta().getNombre()
            });
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labListaCuentas = new javax.swing.JLabel();
        scrpanCuentas = new javax.swing.JScrollPane();
        tabCuentas = new javax.swing.JTable();
        panAcciones = new javax.swing.JPanel();
        butAnadir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 248, 255));

        labListaCuentas.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labListaCuentas.setText("Cuentas");

        tabCuentas.setAutoCreateRowSorter(true);
        tabCuentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Tipo de Cuenta", "Subtipo de Cuenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrpanCuentas.setViewportView(tabCuentas);
        if (tabCuentas.getColumnModel().getColumnCount() > 0) {
            tabCuentas.getColumnModel().getColumn(0).setHeaderValue("Código");
            tabCuentas.getColumnModel().getColumn(1).setHeaderValue("Nombre");
            tabCuentas.getColumnModel().getColumn(2).setHeaderValue("Tipo de Cuenta");
            tabCuentas.getColumnModel().getColumn(3).setHeaderValue("Subtipo de Cuenta");
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
                .addComponent(scrpanCuentas)
                .addGap(20, 20, 20)
                .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(365, Short.MAX_VALUE)
                .addComponent(labListaCuentas)
                .addContainerGap(386, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labListaCuentas)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(scrpanCuentas)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                        .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(147, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Estilo de los componentes
    private void estilizarComponentes() {
        new TableStyle(tabCuentas); // Tabla
        
        // Columnas especificas
        tabCuentas.getColumnModel().getColumn(0).setMaxWidth(80);
        ((DefaultTableCellRenderer) tabCuentas.getColumnModel().getColumn(1).getCellRenderer())
                .setHorizontalAlignment(SwingConstants.LEFT);
        
        new ButtonStyle(butAnadir, butEditar, butEliminar); // Botones
    }
    
    // Escuchador de selección de tabCuentas
    public void seleccionEscuchador(ListSelectionEvent e) {
        if (tabCuentas.getSelectedRow() != -1) {
            butEditar.setEnabled(true);
            butEliminar.setEnabled(true);
        } else {
            butEditar.setEnabled(false);
            butEliminar.setEnabled(false);
        }
    }
    
    // Escuchadores de los botones
    private void butAnadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butAnadirActionPerformed
        CuentaVentana cv = new CuentaVentana(
                "Añadir Cuenta", (DefaultTableModel) tabCuentas.getModel(),
                null, null
        ); 
        cv.setLocationRelativeTo(null); 
        cv.setVisible(true);
    }//GEN-LAST:event_butAnadirActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
        if (!tabCuentas.getSelectionModel().isSelectionEmpty()) {
            Integer filaIndice = tabCuentas.getSelectedRow();
            String filaCodigo = tabCuentas.getValueAt(filaIndice, 0).toString();
            Cuenta cuentaBuscada = CuentaRepo.findById(filaCodigo);
            
            CuentaVentana cv = new CuentaVentana(
                    "Editar Cuenta", (DefaultTableModel) tabCuentas.getModel(), 
                    filaIndice, cuentaBuscada
            ); 
            cv.setLocationRelativeTo(null); 
            cv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cuenta en la tabla.");
        }
    }//GEN-LAST:event_butEditarActionPerformed

    private void butEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEliminarActionPerformed
        if (!tabCuentas.getSelectionModel().isSelectionEmpty()) {
            Integer filaIndice = tabCuentas.getSelectedRow();
            String filaCodigo = tabCuentas.getValueAt(filaIndice, 0).toString();
            Integer respuesta = JOptionPane.showConfirmDialog(
                this, "¿Está seguro de que desea eliminar esta cuenta?",
                "Eliminar Cuenta", JOptionPane.YES_NO_OPTION
            );
            
            if (respuesta == JOptionPane.YES_OPTION) {
                CuentaRepo.delete(filaCodigo);
                ((DefaultTableModel) tabCuentas.getModel()).removeRow(filaIndice);
                JOptionPane.showMessageDialog(this, "Cuenta eliminada exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cuenta en la tabla.");
        }
    }//GEN-LAST:event_butEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butEliminar;
    private javax.swing.JLabel labListaCuentas;
    private javax.swing.JPanel panAcciones;
    private javax.swing.JScrollPane scrpanCuentas;
    private javax.swing.JTable tabCuentas;
    // End of variables declaration//GEN-END:variables
}
