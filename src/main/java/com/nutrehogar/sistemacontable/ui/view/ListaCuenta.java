
package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.SubTipoCuentaRepo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author charl
 */
public class ListaCuenta extends javax.swing.JPanel {
 List<SubTipoCuenta> listaSubTipo = new ArrayList<>();

        SubTipoCuentaRepo subTipoCuentaRepo = SubTipoCuentaRepo.getInstance();
    public ListaCuenta() {
        initComponents();
        estilizarBoton(btnCrear, 120, 50);      // Botón Crear con ancho 120 y alto 50
estilizarBoton(btnActualizar, 120, 50); // Botón Modificar con ancho 120 y alto 50
estilizarBoton(btnEliminar, 120, 50);  // Botón Eliminar con ancho 120 y alto 50

       customizeTable();
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
    private void estilizarBoton(JButton boton, int ancho, int alto) {
    // Cambiar tamaño del botón
    boton.setPreferredSize(new Dimension(ancho, alto));

    // Configuración básica para eliminar estilos predeterminados
    boton.setContentAreaFilled(false); // Elimina el fondo predeterminado
    boton.setFocusPainted(false);      // Elimina el borde de enfoque predeterminado
    boton.setBorderPainted(false);     // Elimina el borde predeterminado

    // Estilo personalizado del botón
    boton.setUI(new javax.swing.plaf.basic.BasicButtonUI() {
        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Dibujar el fondo con bordes redondeados
            g2d.setColor(new Color(102, 204, 255)); // Color de fondo
            g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 25, 25); // Bordes redondeados

            // Dibujar el borde
            g2d.setColor(new Color(30, 144, 255)); // Color del borde
            g2d.drawRoundRect(0, 0, c.getWidth() - 1, c.getHeight() - 1, 25, 25);

            g2d.dispose();

            // Llamar al renderizador predeterminado para pintar el texto y el ícono
            super.paint(g, c);
        }
    });
}

// Personalización de la tabla
private void customizeTable() {
    // Cambiar el estilo del encabezado
    JTableHeader header = tblCuenta.getTableHeader();
    header.setFont(new Font("Arial", Font.BOLD, 16));
    header.setBackground(new Color(102, 204, 255));
    header.setForeground(Color.BLACK);

    // Renderizador para aplicar estilos en todas las filas
    DefaultTableCellRenderer rowRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Alternar colores de las filas
            if (!isSelected) {
                setBackground(row % 2 == 0 ? new Color(224, 255, 255) : Color.WHITE); // Alterna entre celeste claro y blanco
                setForeground(Color.BLACK);
            } else {
                setBackground(new Color(30, 144, 255)); // Azul al seleccionar
                setForeground(Color.WHITE);
            }
            return cell;
        }
    };

    // Asignar el renderizador a todas las columnas de la tabla
    for (int i = 0; i < tblCuenta.getColumnCount(); i++) {
        tblCuenta.getColumnModel().getColumn(i).setCellRenderer(rowRenderer);
    }

    // Ajustar tamaño de texto y altura de las filas
    tblCuenta.setFont(new Font("Arial", Font.PLAIN, 14));
    tblCuenta.setRowHeight(25);

    // Ajustar el ancho de la columna ID si es necesario
    TableColumnModel columnModel = tblCuenta.getColumnModel();
    columnModel.getColumn(0).setPreferredWidth(80);
    columnModel.getColumn(0).setMaxWidth(80);
    columnModel.getColumn(0).setMinWidth(80);
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        btnCrear.setBackground(new java.awt.Color(242, 242, 242));
        btnCrear.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnCrear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/anadir.png"))); // NOI18N
        btnCrear.setText("Crear");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        btnActualizar.setBackground(new java.awt.Color(242, 242, 242));
        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/editar1.png"))); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(242, 242, 242));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(281, 281, 281)
                        .addComponent(jLabel1)))
                .addContainerGap(330, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
