package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.ui.controller.TipoCuenta;
import com.nutrehogar.sistemacontable.ui.styles.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class MayorGenView extends javax.swing.JPanel {
    public MayorGenView() {
        initComponents();
        
        TableStyle.setStyle(tabRegistros);
        ButtonStyle.setStyle(butFiltrar,butEdit);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labMayorGeneral = new javax.swing.JLabel();
        panSelector = new javax.swing.JPanel();
        comboxTipoCuenta = new com.nutrehogar.sistemacontable.ui.components.CustomComboBox<>();
        comboxSubtipoCuenta = new com.nutrehogar.sistemacontable.ui.components.CustomComboBox<>();
        comboxCuenta = new com.nutrehogar.sistemacontable.ui.components.CustomComboBox<>();
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

        labMayorGeneral.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labMayorGeneral.setText("Mayor General");

        panSelector.setBackground(new java.awt.Color(241, 248, 255));
        panSelector.setBorder(javax.swing.BorderFactory.createTitledBorder("Selector")); // NOI18N

        javax.swing.GroupLayout panSelectorLayout = new javax.swing.GroupLayout(panSelector);
        panSelector.setLayout(panSelectorLayout);
        panSelectorLayout.setHorizontalGroup(
            panSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panSelectorLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(comboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(comboxSubtipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
        panSelectorLayout.setVerticalGroup(
            panSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panSelectorLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panSelectorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxSubtipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panFiltros.setBackground(new java.awt.Color(241, 248, 255));
        panFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros")); // NOI18N

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
                .addContainerGap()
                .addComponent(labInicio)
                .addGap(12, 12, 12)
                .addComponent(spiInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(labFin)
                .addGap(12, 12, 12)
                .addComponent(spiFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(butFiltrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butEdit)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(labMayorGeneral)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrpanRegistros)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(panFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labMayorGeneral)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panSelector, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(scrpanRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butEdit;
    private javax.swing.JButton butFiltrar;
    private com.nutrehogar.sistemacontable.ui.components.CustomComboBox<Cuenta> comboxCuenta;
    private com.nutrehogar.sistemacontable.ui.components.CustomComboBox<SubTipoCuenta> comboxSubtipoCuenta;
    private com.nutrehogar.sistemacontable.ui.components.CustomComboBox<TipoCuenta> comboxTipoCuenta;
    private javax.swing.JLabel labFin;
    private javax.swing.JLabel labInicio;
    private javax.swing.JLabel labMayorGeneral;
    private javax.swing.JPanel panFiltros;
    private javax.swing.JPanel panSelector;
    private javax.swing.JScrollPane scrpanRegistros;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spiFin;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spiInicio;
    private javax.swing.JTable tabRegistros;
    // End of variables declaration//GEN-END:variables
}
