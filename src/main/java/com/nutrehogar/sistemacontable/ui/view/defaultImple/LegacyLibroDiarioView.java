package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.ui.styles.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LegacyLibroDiarioView extends javax.swing.JPanel {
    public LegacyLibroDiarioView() {
        initComponents();
        
        TableStyle.setStyle(tabRegistros);
        ButtonStyle.setStyle(butFiltrar, butEdit);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labLibroDiario = new javax.swing.JLabel();
        panFiltros = new javax.swing.JPanel();
        labInicio = new javax.swing.JLabel();
        spiInicio = new com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner();
        labFin = new javax.swing.JLabel();
        spiFin = new com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner();
        butFiltrar = new javax.swing.JButton();
        butEdit = new javax.swing.JButton();
        scrpanRegistros = new javax.swing.JScrollPane();
        tabRegistros = new javax.swing.JTable();

        setBackground(new java.awt.Color(241, 248, 255));

        labLibroDiario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labLibroDiario.setText("Libro Diario");

        panFiltros.setBackground(new java.awt.Color(241, 248, 255));
        panFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        labInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labInicio.setText("Inicio:");

        spiInicio.setToolTipText("");

        labFin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labFin.setText("Fin:");

        butFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        butFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filtrar.png"))); // NOI18N
        butFiltrar.setText("Filtrar");

        butEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butEdit.setForeground(new java.awt.Color(255, 255, 255));
        butEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png"))); // NOI18N
        butEdit.setText("Editar");

        javax.swing.GroupLayout panFiltrosLayout = new javax.swing.GroupLayout(panFiltros);
        panFiltros.setLayout(panFiltrosLayout);
        panFiltrosLayout.setHorizontalGroup(
            panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labInicio)
                .addGap(12, 12, 12)
                .addComponent(spiInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(labFin)
                .addGap(12, 12, 12)
                .addComponent(spiFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(butFiltrar)
                .addGap(18, 18, 18)
                .addComponent(butEdit)
                .addContainerGap(105, Short.MAX_VALUE))
        );
        panFiltrosLayout.setVerticalGroup(
            panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labInicio)
                    .addComponent(spiInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labFin)
                    .addComponent(spiFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butFiltrar)
                    .addComponent(butEdit))
                .addGap(12, 12, 12))
        );

        tabRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrpanRegistros.setViewportView(tabRegistros);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labLibroDiario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrpanRegistros))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labLibroDiario)
                .addGap(20, 20, 20)
                .addComponent(panFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(scrpanRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butEdit;
    private javax.swing.JButton butFiltrar;
    private javax.swing.JLabel labFin;
    private javax.swing.JLabel labInicio;
    private javax.swing.JLabel labLibroDiario;
    private javax.swing.JPanel panFiltros;
    private javax.swing.JScrollPane scrpanRegistros;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spiFin;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spiInicio;
    private javax.swing.JTable tabRegistros;
    // End of variables declaration//GEN-END:variables
}
