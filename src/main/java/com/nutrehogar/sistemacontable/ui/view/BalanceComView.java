package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.ui.styles.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class BalanceComView extends javax.swing.JPanel {
    public BalanceComView() {
        initComponents();
        
        new TableStyle(tabRegistros);
        new ButtonStyle(butFiltrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labBalanceComprobacion = new javax.swing.JLabel();
        panFiltros = new javax.swing.JPanel();
        labInicio = new javax.swing.JLabel();
        spiInicio = new com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner();
        labFin = new javax.swing.JLabel();
        spiFin = new com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner();
        butFiltrar = new javax.swing.JButton();
        scrpanRegistros = new javax.swing.JScrollPane();
        tabRegistros = new javax.swing.JTable();

        setBackground(new java.awt.Color(241, 248, 255));

        labBalanceComprobacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labBalanceComprobacion.setText("Balance de Comprobación");

        panFiltros.setBackground(new java.awt.Color(241, 248, 255));
        panFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        labInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labInicio.setText("Inicio:");

        labFin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labFin.setText("Fin:");

        butFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butFiltrar.setForeground(new java.awt.Color(255, 255, 255));
        butFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filtrar.png"))); // NOI18N
        butFiltrar.setText("Filtrar");

        javax.swing.GroupLayout panFiltrosLayout = new javax.swing.GroupLayout(panFiltros);
        panFiltros.setLayout(panFiltrosLayout);
        panFiltrosLayout.setHorizontalGroup(
            panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltrosLayout.createSequentialGroup()
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
                .addGap(12, 12, 12))
        );
        panFiltrosLayout.setVerticalGroup(
            panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spiInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labInicio)
                    .addComponent(labFin)
                    .addComponent(spiFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(butFiltrar))
                .addGap(12, 12, 12))
        );

        tabRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

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
                .addGap(20, 20, 20)
                .addComponent(scrpanRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labBalanceComprobacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labBalanceComprobacion)
                .addGap(20, 20, 20)
                .addComponent(panFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(scrpanRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butFiltrar;
    private javax.swing.JLabel labBalanceComprobacion;
    private javax.swing.JLabel labFin;
    private javax.swing.JLabel labInicio;
    private javax.swing.JPanel panFiltros;
    private javax.swing.JScrollPane scrpanRegistros;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spiFin;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spiInicio;
    private javax.swing.JTable tabRegistros;
    // End of variables declaration//GEN-END:variables
}
