package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.domain.repository.TipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.styles.ButtonStyle;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CuentaVentana extends javax.swing.JFrame {
    List<SubTipoCuenta> listaSubTipoCuenta = new ArrayList<>();
    List<TipoCuenta> listaTipoCuenta  = new ArrayList<>();
    DefaultTableModel tabCuentasModelo;
    Integer filaCuenta;
    Cuenta cuenta;
    String[] codigoSubtipo = {""};

    public CuentaVentana(DefaultTableModel tabCuentasModelo, String titulo, 
            Integer filaCuenta, Cuenta cuenta) {
        initComponents();
        
        this.tabCuentasModelo = tabCuentasModelo;
        this.filaCuenta = filaCuenta;
        this.cuenta = cuenta;
        
        SubTipoCuentaRepo.findAll().forEach((subTipoCuenta) -> {
            comboxSubtipoCuenta.addItem(subTipoCuenta.getId() + " " + subTipoCuenta.getNombre());
            listaSubTipoCuenta.add(subTipoCuenta);
        });
        comboxSubtipoCuenta.addItemListener(this::elementoEscucha);
        
        TipoCuentaRepo.findAll().forEach((tipoCuenta) -> {
            listaTipoCuenta.add(tipoCuenta);
        });
        texfieTipoCuenta.setText(
            listaTipoCuenta.get(0).getId() +  " " +
            listaTipoCuenta.get(0).getNombre()
        );
        
        if (filaCuenta == null) {
            butAnadir.setVisible(true);
            butEditar.setVisible(false);
        } else {
            butAnadir.setVisible(false);
            butEditar.setVisible(true);
            
            texfieCodigo.setEnabled(false);
            comboxSubtipoCuenta.setEnabled(false);
            
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
        labSubtipoCuenta = new javax.swing.JLabel();
        comboxSubtipoCuenta = new javax.swing.JComboBox<>();
        labTipoCuenta = new javax.swing.JLabel();
        texfieTipoCuenta = new javax.swing.JTextField();
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

        labSubtipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labSubtipoCuenta.setText("Subtipo de Cuenta:");

        labTipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labTipoCuenta.setText("Tipo de Cuenta:");

        texfieTipoCuenta.setEditable(false);

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(labTipoCuenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(texfieTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labSubtipoCuenta)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comboxSubtipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labNombre, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texfieCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butAnadir)
                .addGap(32, 32, 32)
                .addComponent(butEditar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labTitulo)
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
                    .addComponent(labSubtipoCuenta)
                    .addComponent(comboxSubtipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTipoCuenta)
                    .addComponent(texfieTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAnadir)
                    .addComponent(butEditar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Escucha de comboxSubtipoCuenta
    private void elementoEscucha(ItemEvent e) {
        Integer tipoCuentaId = Integer.valueOf(
                comboxSubtipoCuenta.getSelectedItem().toString().substring(0, 1)
        );
        TipoCuenta tipoCuenta = listaTipoCuenta.get(tipoCuentaId - 1);
        texfieTipoCuenta.setText(
                tipoCuenta.getId() + " " + tipoCuenta.getNombre()
        );
    }
        
    // Llenado de campos de la cuenta a acutalizar
    private void llenarCampos() {
        texfieCodigo.setText(cuenta.getId());
        texfieNombre.setText(cuenta.getNombre());
        comboxSubtipoCuenta.setSelectedItem(cuenta.getSubTipoCuenta().getId() + 
                " " + cuenta.getSubTipoCuenta().getNombre()
        );
        texfieTipoCuenta.setText(cuenta.getSubTipoCuenta().getTipoCuenta().getId() +  ". " +
            cuenta.getSubTipoCuenta().getTipoCuenta().getNombre()
        );
    }
    
    // Escuchadores de los botones
    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
        if (validarDatos()) {
            String id = texfieCodigo.getText();
            String nombre = texfieNombre.getText();

            SubTipoCuenta subtipoCuenta = SubTipoCuentaRepo.findById(codigoSubtipo[0]);

            Cuenta cuenta = Cuenta.builder()
                    .id(id)
                    .nombre(nombre)
                    .subTipoCuenta(subtipoCuenta)
                    .build();
            CuentaRepo.save(cuenta);

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

            SubTipoCuenta subtipoCuenta = SubTipoCuentaRepo.findById(codigoSubtipo[0]);

            Cuenta cuenta = Cuenta.builder()
                    .id(id)
                    .nombre(nombre)
                    .subTipoCuenta(subtipoCuenta)
                    .build();
            CuentaRepo.update(cuenta);
            
            tabCuentasModelo.setValueAt(id, filaCuenta, 0);
            tabCuentasModelo.setValueAt(nombre, filaCuenta, 1);
            tabCuentasModelo.setValueAt(subtipoCuenta.getTipoCuenta().getNombre(), filaCuenta, 2);
            tabCuentasModelo.setValueAt(subtipoCuenta.getNombre(), filaCuenta, 3);
            
            dispose();
        }
    }//GEN-LAST:event_butEditarMouseClicked
    
    // Validador de datos
    private Boolean validarDatos() {
        if (!Pattern.matches("\\d{1}\\.\\d{4}", texfieCodigo.getText())) {
            JOptionPane.showMessageDialog(
                    this, "El código debe tener 5 dígitos en el siguiente formato: 0.0000"
            );
            return false;
        }
        
        if (texfieNombre.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
            return false;
        }
        
        listaSubTipoCuenta.forEach((subTipoCuenta) -> {
            if(comboxSubtipoCuenta.getSelectedItem().toString().startsWith(subTipoCuenta.getId())){
                codigoSubtipo[0] = subTipoCuenta.getId();
            }
        });

        if (!texfieCodigo.getText().startsWith(codigoSubtipo[0])) {
            JOptionPane.showMessageDialog(
                    this, "El código de la cuenta debe comenzar igual que el código del subtipo de cuenta."
            );
            return false;
        }
        
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.JComboBox<String> comboxSubtipoCuenta;
    private javax.swing.JLabel labCodigo;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labSubtipoCuenta;
    private javax.swing.JLabel labTipoCuenta;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JTextField texfieCodigo;
    private javax.swing.JTextField texfieNombre;
    private javax.swing.JTextField texfieTipoCuenta;
    // End of variables declaration//GEN-END:variables
}
