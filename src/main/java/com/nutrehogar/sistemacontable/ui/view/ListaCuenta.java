package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

public class ListaCuenta extends javax.swing.JPanel {

    public ListaCuenta() {
        initComponents();
    
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCuenta.clearSelection();
            }
        });
        
        estilizarBoton(btnCrear, 120, 50);      
        estilizarBoton(btnActualizar, 120, 50); 
        estilizarBoton(btnEliminar, 120, 50);  

        customizeTable();
        tblCuenta.getSelectionModel().addListSelectionListener(this::isSelectRow);
        btnActualizar.setEnabled(false);

        List<Cuenta> ListaCuenta = CuentaRepo.findAll();
        DefaultTableModel model = (DefaultTableModel)tblCuenta.getModel();
        for (Cuenta cuenta : ListaCuenta) {
            model.addRow(new Object[] {
                cuenta.getId(),cuenta.getNombre(),
                cuenta.getSubTipoCuenta().getNombre(),
                cuenta.getSubTipoCuenta().getTipoCuenta().getNombre()
            });
        }
        


    }
    
    private void estilizarBoton(JButton boton, int ancho, int alto) {
        boton.setPreferredSize(new Dimension(ancho, alto));
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


                g2d.setColor(new Color(30, 144, 255)); 
                g2d.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 25, 25);

                g2d.dispose();


                super.paint(g, c);
            }
        });
    }

    private void customizeTable() {
        JTableHeader header = tblCuenta.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 16));
        header.setBackground(Color.decode("#1E88E5"));
        header.setForeground(Color.WHITE);

        DefaultTableCellRenderer rowRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                                boolean isSelected, boolean hasFocus, int row, int column) {
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (!isSelected) {
                    if (row % 2 == 0) {
                        cell.setBackground(Color.decode("#F1F8FF"));
                    } else {
                        cell.setBackground(Color.WHITE); 
                    }
                } else {
                    cell.setBackground(Color.decode("#BBDEFB")); 
                }
                return cell;
            }
        };

        for (int i = 0; i < tblCuenta.getColumnCount(); i++) {
            tblCuenta.getColumnModel().getColumn(i).setCellRenderer(rowRenderer);
        }

        tblCuenta.setFont(new Font("Arial", Font.PLAIN, 14));
        tblCuenta.setRowHeight(25);

        TableColumnModel columnModel = tblCuenta.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(80);
        columnModel.getColumn(0).setMaxWidth(80);
        columnModel.getColumn(0).setMinWidth(80);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCuenta = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnCrear = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 248, 255));

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 24)); // NOI18N
        jLabel1.setText("Lista de Cuentas");

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

        jPanel1.setBackground(new java.awt.Color(241, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnCrear.setBackground(new java.awt.Color(242, 242, 242));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrear.setForeground(new java.awt.Color(255, 255, 255));
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/anadir.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(242, 242, 242));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnActualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/editar1.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/eliminar.png"))); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnCrear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(btnActualizar)
                .addGap(63, 63, 63)
                .addComponent(btnEliminar)
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(36, 36, 36)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
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
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        DefaultTableModel tblCuentaModelo = (DefaultTableModel) tblCuenta.getModel(); 
        CuentaView cuentaView = new CuentaView(tblCuentaModelo); 
        cuentaView.setLocationRelativeTo(null); 
        cuentaView.setVisible(true);
    }//GEN-LAST:event_btnCrearActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
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
        EditarCuentaView editarCuentaView = new EditarCuentaView(id, nombreActual, subTipoCuentaActual, (DefaultTableModel) tblCuenta.getModel(), selectedRow);
        editarCuentaView.setLocationRelativeTo(null); // Centrar la ventana
        editarCuentaView.setVisible(true);
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
            CuentaRepo.delete(id);

            // Eliminar la fila de la tabla
            ((DefaultTableModel) tblCuenta.getModel()).removeRow(selectedRow);

            JOptionPane.showMessageDialog(this, "Cuenta eliminada exitosamente.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al eliminar la cuenta: " + e.getMessage());
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCuenta;
    // End of variables declaration//GEN-END:variables
}
