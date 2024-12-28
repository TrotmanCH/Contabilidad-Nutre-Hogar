package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.domain.repository.TipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.styles.ButtonStyle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class SubTipoCuentaVentana extends javax.swing.JFrame {
    List<TipoCuenta> listaTipoCuenta = new ArrayList<>();
    DefaultTableModel tabCuentasModelo;
    Integer filaSubtipoCuenta;
    SubTipoCuenta subtipoCuenta;
    Integer[] codigoTipo = {0};

    public SubTipoCuentaVentana(DefaultTableModel tabCuentasModelo, String titulo, 
            Integer filaSubtipoCuenta, SubTipoCuenta subtipoCuenta) {
        initComponents();
        
        this.tabCuentasModelo = tabCuentasModelo;
        this.filaSubtipoCuenta = filaSubtipoCuenta;
        this.subtipoCuenta = subtipoCuenta;
        
        TipoCuentaRepo.findAll().forEach((tipoCuenta) -> {
            comboxTipoCuenta.addItem(tipoCuenta.getId() + " " + tipoCuenta.getNombre());
            listaTipoCuenta.add(tipoCuenta);
        });
                
        if (filaSubtipoCuenta == null) {
            butAnadir.setVisible(true);
            butEditar.setVisible(false);
        } else {
            butAnadir.setVisible(false);
            butEditar.setVisible(true);
            
            texfieCodigo.setEnabled(false);
            comboxTipoCuenta.setEnabled(false);
            
            llenarCampos();
        }
        
        labTitulo.setText(titulo);
        new ButtonStyle(butAnadir, butEditar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labTitulo = new javax.swing.JLabel();
        labCodigo = new javax.swing.JLabel();
        texfieCodigo = new javax.swing.JTextField();
        labNombre = new javax.swing.JLabel();
        texfieNombre = new javax.swing.JTextField();
        labTipoCuenta = new javax.swing.JLabel();
        comboxTipoCuenta = new javax.swing.JComboBox<>();
        butAnadir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labTitulo.setText("Titulo");

        labCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labCodigo.setText("Código:");

        labNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labNombre.setText("Nombre:");

        labTipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labTipoCuenta.setText("Tipo de Cuenta:");
        labTipoCuenta.setToolTipText("");

        butAnadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAnadir.setForeground(new java.awt.Color(255, 255, 255));
        butAnadir.setText("Añadir");
        butAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAnadirMouseClicked(evt);
            }
        });

        butEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butEditar.setForeground(new java.awt.Color(255, 255, 255));
        butEditar.setText("Editar");
        butEditar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labTipoCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(comboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texfieCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butAnadir)
                        .addGap(32, 32, 32)
                        .addComponent(butEditar))
                    .addComponent(labTitulo))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCodigo)
                    .addComponent(texfieCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNombre)
                    .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labTipoCuenta)
                    .addComponent(comboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAnadir)
                    .addComponent(butEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    // Llenado de campos de la subtipoCuenta a acutalizar
    private void llenarCampos() {
        texfieCodigo.setText(subtipoCuenta.getId());
        texfieNombre.setText(subtipoCuenta.getNombre());
        comboxTipoCuenta.setSelectedItem(subtipoCuenta.getTipoCuenta().getId() + 
                " " + subtipoCuenta.getTipoCuenta().getNombre()
        );
    }
    
    // Escuchadores de los botones
    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
        if (validarDatos()) {
            String id = texfieCodigo.getText();
            String nombre = texfieNombre.getText();

            TipoCuenta tipoCuenta = TipoCuentaRepo.findById(codigoTipo[0]);

            SubTipoCuenta subtipoCuenta = SubTipoCuenta.builder()
                    .id(id)
                    .nombre(nombre)
                    .tipoCuenta(tipoCuenta)
                    .build();
            SubTipoCuentaRepo.save(subtipoCuenta);

            tabCuentasModelo.addRow(new Object[]{
                id, nombre,
                subtipoCuenta.getTipoCuenta().getNombre(), subtipoCuenta.getNombre()
            });
            
            dispose();
        }
    }//GEN-LAST:event_butAnadirMouseClicked

    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
        if (validarDatos()) {
            String id = texfieCodigo.getText();
            String nombre = texfieNombre.getText();

            TipoCuenta tipoCuenta = TipoCuentaRepo.findById(codigoTipo[0]);

            SubTipoCuenta subtipoCuenta = SubTipoCuenta.builder()
                    .id(id)
                    .nombre(nombre)
                    .tipoCuenta(tipoCuenta)
                    .build();
            SubTipoCuentaRepo.update(subtipoCuenta);
            
            tabCuentasModelo.setValueAt(id, filaSubtipoCuenta, 0);
            tabCuentasModelo.setValueAt(nombre, filaSubtipoCuenta, 1);
            tabCuentasModelo.setValueAt(subtipoCuenta.getTipoCuenta().getNombre(), filaSubtipoCuenta, 2);
            
            dispose();
        }
    }//GEN-LAST:event_butEditarMouseClicked
    
    // Validador de datos
    private Boolean validarDatos() {
        if (texfieCodigo.getText().length() < 3 || texfieCodigo.getText().length() > 5) {
            JOptionPane.showMessageDialog(
                    this, "El codigo debe tener entre 3 y 5 caracteres y en los siguientes formatos: 0.000 "
            );
            return false;
        }
        
        if (texfieNombre.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
            return false;
        }
        
        listaTipoCuenta.forEach((tipoCuenta) -> {
            if(comboxTipoCuenta.getSelectedItem().toString().startsWith(tipoCuenta.getId().toString())){
                codigoTipo[0] = tipoCuenta.getId();
            }
        });

        if (!texfieCodigo.getText().startsWith(codigoTipo[0].toString())) {
            JOptionPane.showMessageDialog(
                    this, "El código del subtipo de cuenta debe comenzar igual que el código del tipo de cuenta."
            );
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.JComboBox<String> comboxTipoCuenta;
    private javax.swing.JLabel labCodigo;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labTipoCuenta;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JTextField texfieCodigo;
    private javax.swing.JTextField texfieNombre;
    // End of variables declaration//GEN-END:variables
}
