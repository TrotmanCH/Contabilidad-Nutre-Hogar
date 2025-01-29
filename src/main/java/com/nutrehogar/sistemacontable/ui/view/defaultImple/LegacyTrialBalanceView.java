package com.nutrehogar.sistemacontable.ui.view.defaultImple;

import com.nutrehogar.sistemacontable.ui.styles.*;
import com.nutrehogar.sistemacontable.ui.view.BusinessView;
import com.nutrehogar.sistemacontable.ui.view.TrialBalanceView;
import javax.swing.JButton;
import lombok.Getter;
import lombok.Setter;

@Getter
public class LegacyTrialBalanceView extends javax.swing.JPanel implements TrialBalanceView {
    public LegacyTrialBalanceView() {
        initComponents();
        TableStyle.setStyle(tblData);
        ButtonStyle.setStyle(btnFilter, btnEdit);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labBalanceComprobacion = new javax.swing.JLabel();
        panFiltros = new javax.swing.JPanel();
        labInicio = new javax.swing.JLabel();
        spnStart = new com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner();
        labFin = new javax.swing.JLabel();
        spnEnd = new com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner();
        btnFilter = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        scrpanRegistros = new javax.swing.JScrollPane();
        tblData = new javax.swing.JTable();

        setBackground(new java.awt.Color(241, 248, 255));

        labBalanceComprobacion.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labBalanceComprobacion.setText("Balance de Comprobación");

        panFiltros.setBackground(new java.awt.Color(241, 248, 255));
        panFiltros.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros"));

        labInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labInicio.setText("Inicio:");

        labFin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labFin.setText("Fin:");

        btnFilter.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnFilter.setForeground(new java.awt.Color(255, 255, 255));
        btnFilter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/filtrar.png"))); // NOI18N
        btnFilter.setText("Filtrar");

        btnEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/editar.png"))); // NOI18N
        btnEdit.setText("Editar");

        btnClear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnClear.setForeground(new java.awt.Color(255, 255, 255));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/escritura.png"))); // NOI18N
        btnClear.setText("Limpiar");

        javax.swing.GroupLayout panFiltrosLayout = new javax.swing.GroupLayout(panFiltros);
        panFiltros.setLayout(panFiltrosLayout);
        panFiltrosLayout.setHorizontalGroup(
            panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(labInicio)
                .addGap(12, 12, 12)
                .addComponent(spnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(labFin)
                .addGap(12, 12, 12)
                .addComponent(spnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btnFilter)
                .addGap(18, 18, 18)
                .addComponent(btnEdit)
                .addGap(18, 18, 18)
                .addComponent(btnClear)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panFiltrosLayout.setVerticalGroup(
            panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panFiltrosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnStart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labInicio)
                    .addComponent(labFin)
                    .addComponent(spnEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFilter)
                    .addComponent(btnEdit)
                    .addComponent(btnClear))
                .addGap(12, 12, 12))
        );

        tblData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "fsa", "as"},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        scrpanRegistros.setViewportView(tblData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labBalanceComprobacion)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(scrpanRegistros, javax.swing.GroupLayout.DEFAULT_SIZE, 739, Short.MAX_VALUE))
                .addGap(20, 20, 20))
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnFilter;
    private javax.swing.JLabel labBalanceComprobacion;
    private javax.swing.JLabel labFin;
    private javax.swing.JLabel labInicio;
    private javax.swing.JPanel panFiltros;
    private javax.swing.JScrollPane scrpanRegistros;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spnEnd;
    private com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner spnStart;
    private javax.swing.JTable tblData;
    // End of variables declaration//GEN-END:variables

    @Override
    public JButton getBtnResetStart() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public JButton getBtnResetEnd() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
