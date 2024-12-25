package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
import java.awt.*;
import java.util.Arrays;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.*;

public class ListaCuenta extends javax.swing.JPanel {
    DefaultTableModel tabCuentasModelo;
    ListSelectionModel listaSeleccionModelo;
    
    public ListaCuenta() {
        initComponents();
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabCuentas.clearSelection();
            }
        });
        
        tabCuentasModelo = (DefaultTableModel) tabCuentas.getModel();
        listaSeleccionModelo = tabCuentas.getSelectionModel();
        
        listaSeleccionModelo.addListSelectionListener(this::listaSeleccionEscuchador);
        listaSeleccionModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        estilizarTabla();
        estilizarBotones(butCrear, butEditar, butEliminar);  
        
        for (Cuenta cuenta : CuentaRepo.findAll()) {
            tabCuentasModelo.addRow(new Object[] {
                cuenta.getId(),cuenta.getNombre(),
                cuenta.getSubTipoCuenta().getTipoCuenta().getNombre(),
                cuenta.getSubTipoCuenta().getNombre()
            });
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labListaCuentas = new javax.swing.JLabel();
        scrpanCuentas = new javax.swing.JScrollPane();
        tabCuentas = new javax.swing.JTable();
        panAcciones = new javax.swing.JPanel();
        butCrear = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();
        butEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 248, 255));

        labListaCuentas.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        labListaCuentas.setText("Lista de Cuentas");

        tabCuentas.setModel(new javax.swing.table.DefaultTableModel(
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
        scrpanCuentas.setViewportView(tabCuentas);

        panAcciones.setBackground(new java.awt.Color(241, 248, 255));
        panAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        butCrear.setBackground(new java.awt.Color(242, 242, 242));
        butCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butCrear.setForeground(new java.awt.Color(255, 255, 255));
        butCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/anadir.png"))); // NOI18N
        butCrear.setText("Crear");
        butCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                butCrearActionPerformed(evt);
            }
        });

        butEditar.setBackground(new java.awt.Color(242, 242, 242));
        butEditar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butEditar.setForeground(new java.awt.Color(255, 255, 255));
        butEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/editar1.png"))); // NOI18N
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
                    .addComponent(butCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(butEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12))
        );
        panAccionesLayout.setVerticalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panAccionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(butCrear)
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
                .addContainerGap(314, Short.MAX_VALUE)
                .addComponent(labListaCuentas)
                .addContainerGap(335, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labListaCuentas)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(scrpanCuentas)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                        .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(148, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Estilo de los componentes
    private void estilizarTabla() {
        JTableHeader header = tabCuentas.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.decode("#1E88E5"));
        header.setForeground(Color.WHITE);

        DefaultTableCellRenderer celdaRenderizador = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    if (row % 2 == 0) {
                        comp.setBackground(Color.decode("#F1F8FF"));
                    } else {
                        comp.setBackground(Color.WHITE); 
                    }
                } else {
                    comp.setBackground(Color.decode("#BBDEFB")); 
                }
                
                if (column == 1) {
                    setHorizontalAlignment(SwingConstants.LEFT);
                } else {
                    setHorizontalAlignment(SwingConstants.CENTER);
                }
                
                return comp;
            }
        };

        for (int i = 0; i < tabCuentas.getColumnCount(); i++) {
            tabCuentas.getColumnModel().getColumn(i).setCellRenderer(celdaRenderizador);
        }
        
        tabCuentas.getColumnModel().getColumn(0).setMaxWidth(80);
        tabCuentas.setFont(new Font("Arial", Font.PLAIN, 14));
        tabCuentas.setRowHeight(25);
    }
    
    private void estilizarBotones(JButton... botones) {
        Arrays.asList(botones).forEach((boton) -> {
            boton.setPreferredSize(new Dimension(120, 50));
            boton.setContentAreaFilled(false); 
            boton.setFocusPainted(false);      
            boton.setBorderPainted(false);
            
            boton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
                @Override
                public void paint(Graphics g, JComponent c) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(Color.decode("#1E88E5")); 
                    g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 25, 25); 
                    g2d.dispose();

                    super.paint(g, c);
                }
            });
        });
    }
    
    // Escuchador de tabCuentas
    public void listaSeleccionEscuchador(ListSelectionEvent e) {
        if (tabCuentas.getSelectedRow() != -1) {
            butEditar.setEnabled(true);
            butEliminar.setEnabled(true);
        } else {
            butEditar.setEnabled(false);
            butEliminar.setEnabled(false);
        }
    }
    
    // Escuchadores de los botones
    private void butCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butCrearActionPerformed
        CuentaVentana cv = new CuentaVentana(tabCuentasModelo, "Crear Cuenta",
                null, null); 
        cv.setLocationRelativeTo(null); 
        cv.setVisible(true);
    }//GEN-LAST:event_butCrearActionPerformed

    private void butEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEditarActionPerformed
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaCuenta = tabCuentas.getSelectedRow();
            String cuentaCodigo = tabCuentas.getValueAt(filaCuenta, 0).toString();
            Cuenta cuentaSeleccionada = CuentaRepo.findById(cuentaCodigo);
            CuentaVentana cv = new CuentaVentana(tabCuentasModelo, "Editar Cuenta", 
                    filaCuenta, cuentaSeleccionada); 
            cv.setLocationRelativeTo(null); 
            cv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cuenta en la tabla");
        }
    }//GEN-LAST:event_butEditarActionPerformed

    private void butEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_butEliminarActionPerformed
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaCuenta = tabCuentas.getSelectedRow();
            String cuentaCodigo = tabCuentas.getValueAt(filaCuenta, 0).toString();
            Integer confirmar = JOptionPane.showConfirmDialog(
                this, "¿Está seguro de que desea eliminar esta cuenta?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION
            );
            
            if (confirmar == JOptionPane.YES_OPTION) {
                tabCuentasModelo.removeRow(filaCuenta);
                CuentaRepo.delete(cuentaCodigo);
                JOptionPane.showMessageDialog(this, "Cuenta eliminada exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione una cuenta en la tabla");
        }
    }//GEN-LAST:event_butEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butCrear;
    private javax.swing.JButton butEditar;
    private javax.swing.JButton butEliminar;
    private javax.swing.JLabel labListaCuentas;
    private javax.swing.JPanel panAcciones;
    private javax.swing.JScrollPane scrpanCuentas;
    private javax.swing.JTable tabCuentas;
    // End of variables declaration//GEN-END:variables
}
