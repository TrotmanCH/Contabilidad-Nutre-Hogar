package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CuentaView extends javax.swing.JFrame {
    List<SubTipoCuenta> listaSubTipo = new ArrayList<>();
    private DefaultTableModel  tblCuenta;

    public CuentaView(DefaultTableModel tblCuentaModelo) {
        initComponents();
        estilizarBoton(btnGuardar, 120, 50);
        this.getContentPane().setBackground(Color.decode("#F1F8FF"));
        this.tblCuenta = tblCuentaModelo;
        
        //busca todo lo que esta en subtipo cuenta con findAll, y con el foreach puedo hacer con cada cosa que esta en esta lista
        SubTipoCuentaRepo.findAll().forEach((subTipoCuenta) -> {
            cboSubTipoCuenta.addItem(subTipoCuenta.getNombre());
            listaSubTipo.add(subTipoCuenta);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        cboSubTipoCuenta = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva Cuenta");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Id");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Subtipo Cuenta");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardar.setForeground(new java.awt.Color(255, 255, 255));
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Insertar Nueva Cuenta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtId)
                    .addComponent(cboSubTipoCuenta, 0, 119, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnGuardar)
                        .addGap(87, 87, 87))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel5)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(cboSubTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnGuardar)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
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
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        String id = txtId.getText();
        String nombre = txtNombre.getText();

        if(id.length() != 6 ){
            JOptionPane.showMessageDialog(this, "El id debe tener 6 caracteres, y formato: #.###");
            return;
        }
        if(nombre.isBlank()){
            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacio.");
            return;
        }

        try{
            int nu = Integer.parseInt(nombre);
            JOptionPane.showMessageDialog(this, "El nombre no puede ser un numero");

            return;
        } catch (NumberFormatException e){
            System.out.println("CuentaView.btnGuardarActionPerformed");
        }
        
        String[] codigoSubtipo = {"vacio"};
        listaSubTipo.forEach((subTipoCuenta) -> {
            if(subTipoCuenta.getNombre().equals(cboSubTipoCuenta.getSelectedItem().toString())){
                codigoSubtipo[0] = subTipoCuenta.getId();
            }
        });
        SubTipoCuenta subtipoCuenta = SubTipoCuentaRepo.findById(codigoSubtipo[0]);
        
        Cuenta cuenta =new Cuenta();
        cuenta.setId(id);
        cuenta.setNombre(nombre);
        cuenta.setSubTipoCuenta(subtipoCuenta);
        CuentaRepo.save(cuenta);
        tblCuenta.addRow(new Object[]{
            id,nombre,subtipoCuenta.getTipoCuenta().getNombre(),subtipoCuenta.getNombre()
        });
        dispose();
    }//GEN-LAST:event_btnGuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cboSubTipoCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
