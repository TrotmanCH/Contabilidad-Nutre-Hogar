package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.ui.controller.MayorGenController;
import com.nutrehogar.sistemacontable.ui.controller.TipoCuenta;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
/**
 * @author Calcifer1331
 */
public class MayorGenView extends javax.swing.JPanel {

    public MayorGenView() {
        initComponents();
        customizeTable();
        estilizarBoton(btnFilter, 120, 50);
    }
    
    
private void customizeTable() {

    JTableHeader header = mayorGenTable.getTableHeader();
    header.setFont(new Font("Arial", Font.BOLD, 16));
    header.setBackground(Color.decode("#1E88E5"));
    header.setForeground(Color.WHITE);

   
    DefaultTableCellRenderer rowRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus,
                                                       int row, int column) {
            Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            
            if (!isSelected) {
                setBackground(row % 2 == 0 ? new Color(224, 255, 255) : Color.WHITE); 
                setForeground(Color.BLACK);
            } else {
                setBackground(new Color(30, 144, 255)); 
                setForeground(Color.WHITE);
            }
            return cell;
        }
    };

    
    for (int i = 0; i < mayorGenTable.getColumnCount(); i++) {
        mayorGenTable.getColumnModel().getColumn(i).setCellRenderer(rowRenderer);
    }

 
    mayorGenTable.setFont(new Font("Arial", Font.PLAIN, 14));
    mayorGenTable.setRowHeight(25);

  
 
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
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sec1 = new javax.swing.JPanel();
        comTipoCuenta = new com.nutrehogar.sistemacontable.ui.view.components.CustomComboBox<>();
        comSubTipoCuenta = new com.nutrehogar.sistemacontable.ui.view.components.CustomComboBox<>();
        comCuenta = new com.nutrehogar.sistemacontable.ui.view.components.CustomComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        starDateSpinner = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        jLabel2 = new javax.swing.JLabel();
        endDateSpinner = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        jLabel3 = new javax.swing.JLabel();
        btnFilter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        mayorGenTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 248, 255));

        sec1.setBackground(new java.awt.Color(241, 248, 255));
        sec1.setBorder(javax.swing.BorderFactory.createTitledBorder("Selector"));

        javax.swing.GroupLayout sec1Layout = new javax.swing.GroupLayout(sec1);
        sec1.setLayout(sec1Layout);
        sec1Layout.setHorizontalGroup(
            sec1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sec1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comTipoCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comSubTipoCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        sec1Layout.setVerticalGroup(
            sec1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sec1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(sec1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comSubTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );

        jPanel1.setBackground(new java.awt.Color(241, 248, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        starDateSpinner.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Inicio:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Fin:");

        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/filtrar.png"))); // NOI18N
        btnFilter.setText("Filtrar");
        btnFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(starDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(endDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFilter)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(starDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(endDateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        mayorGenTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(mayorGenTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Mayor General");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(sec1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(sec1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnFilterActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFilter;
    private com.nutrehogar.sistemacontable.ui.view.components.CustomComboBox<Cuenta> comCuenta;
    private com.nutrehogar.sistemacontable.ui.view.components.CustomComboBox<SubTipoCuenta> comSubTipoCuenta;
    private com.nutrehogar.sistemacontable.ui.view.components.CustomComboBox<TipoCuenta> comTipoCuenta;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner endDateSpinner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable mayorGenTable;
    private javax.swing.JPanel sec1;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner starDateSpinner;
    // End of variables declaration//GEN-END:variables
}