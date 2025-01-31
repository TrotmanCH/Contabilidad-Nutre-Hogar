//package com.nutrehogar.sistemacontable.ui.windows;
//
//import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
//import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
//import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
//import com.nutrehogar.sistemacontable.domain.repository.TipoCuentaRepo;
//import com.nutrehogar.sistemacontable.ui.styles.ButtonStyle;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.regex.Pattern;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//
//public class SubtiposCuentaVentana extends javax.swing.JFrame {
//    List<TipoCuenta> listaTipoCuenta = new ArrayList<>();
//    DefaultTableModel tabSubtiposCuentaModelo;
//    Integer filaIndice;
//    AccountSubtype subtipoCuentaBuscada;
//
//    public SubtiposCuentaVentana(String titulo, DefaultTableModel tabSubtiposCuentaModelo,
//            Integer filaIndice, AccountSubtype subtipoCuentaBuscada) {
//        initComponents();
//        ButtonStyle.setStyle(butAnadir, butEditar);
//
//        // Trayendo datos de SubtiposCuentaPestana
//        labTitulo.setText(titulo);
//        this.tabSubtiposCuentaModelo = tabSubtiposCuentaModelo;
//        this.filaIndice = filaIndice;
//        this.subtipoCuentaBuscada = subtipoCuentaBuscada;
//
//        // Trayendo los tipos de cuenta
//        TipoCuentaRepo.findAll().forEach((tipoCuenta) -> {
//            comboxTipoCuenta.addItem(tipoCuenta.getId() + " " + tipoCuenta.getNombre());
//            listaTipoCuenta.add(tipoCuenta);
//        });
//
//        // Cambiando contenido de la ventana dependiendo de si es añadir o editar
//        if (filaIndice == null) {
//            butAnadir.setVisible(true);
//            butEditar.setVisible(false);
//        } else {
//            butAnadir.setVisible(false);
//            butEditar.setVisible(true);
//
//            texfieCodigo.setEnabled(false);
//            comboxTipoCuenta.setEnabled(false);
//
//            llenarCampos();
//        }
//
//    }
//
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        labTitulo = new javax.swing.JLabel();
//        labCodigo = new javax.swing.JLabel();
//        texfieCodigo = new javax.swing.JTextField();
//        labNombre = new javax.swing.JLabel();
//        texfieNombre = new javax.swing.JTextField();
//        labTipoCuenta = new javax.swing.JLabel();
//        comboxTipoCuenta = new javax.swing.JComboBox<>();
//        butAnadir = new javax.swing.JButton();
//        butEditar = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        setResizable(false);
//
//        labTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//        labTitulo.setText("Titulo");
//
//        labCodigo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labCodigo.setText("Código:");
//
//        labNombre.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labNombre.setText("Nombre:");
//
//        labTipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labTipoCuenta.setText("Tipo de Cuenta:");
//        labTipoCuenta.setToolTipText("");
//
//        butAnadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        butAnadir.setForeground(new java.awt.Color(255, 255, 255));
//        butAnadir.setText("Añadir");
//        butAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                butAnadirMouseClicked(evt);
//            }
//        });
//
//        butEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
//        butEditar.setForeground(new java.awt.Color(255, 255, 255));
//        butEditar.setText("Editar");
//        butEditar.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                butEditarMouseClicked(evt);
//            }
//        });
//
//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(20, 20, 20)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addComponent(labTipoCuenta)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addComponent(comboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(labCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
//                            .addComponent(labNombre, javax.swing.GroupLayout.Alignment.TRAILING))
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                            .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
//                            .addComponent(texfieCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
//                .addGap(20, 20, 20))
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(butAnadir)
//                .addGap(32, 32, 32)
//                .addComponent(butEditar)
//                .addGap(0, 0, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(labTitulo)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(20, 20, 20)
//                .addComponent(labTitulo)
//                .addGap(20, 20, 20)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labCodigo)
//                    .addComponent(texfieCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labNombre)
//                    .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addComponent(labTipoCuenta)
//                    .addComponent(comboxTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(20, 20, 20)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(butAnadir)
//                    .addComponent(butEditar))
//                .addGap(20, 20, 20))
//        );
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    // Llenado de campos de la subtipoCuentaBuscada a acutalizar
//    private void llenarCampos() {
//        texfieCodigo.setText(subtipoCuentaBuscada.getId());
//        texfieNombre.setText(subtipoCuentaBuscada.getNombre());
//        comboxTipoCuenta.setSelectedItem(subtipoCuentaBuscada.getAccountType().getId() +
//                " " + subtipoCuentaBuscada.getAccountType().getNombre()
//        );
//    }
//
//    // Escuchadores de los botones
//    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
//        if (validarDatos()) {
//            String id = texfieCodigo.getText();
//            String nombre = texfieNombre.getText();
//            TipoCuenta tipoCuenta = TipoCuentaRepo.findById(Integer.valueOf(
//                    comboxTipoCuenta.getSelectedItem().toString().split("\\s")[0]
//            ));
//
//            AccountSubtype subtipoCuenta = AccountSubtype.builder()
//                    .id(id)
//                    .nombre(nombre)
//                    .accountType(tipoCuenta)
//                    .build();
//            SubTipoCuentaRepo.save(subtipoCuenta);
//
//            tabSubtiposCuentaModelo.addRow(new Object[]{
//                id, nombre, tipoCuenta.getNombre()
//            });
//
//            dispose();
//        }
//    }//GEN-LAST:event_butAnadirMouseClicked
//
//    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
//        if (validarDatos()) {
//            String id = texfieCodigo.getText();
//            String nombre = texfieNombre.getText();
//            TipoCuenta tipoCuenta = TipoCuentaRepo.findById(Integer.valueOf(
//                    comboxTipoCuenta.getSelectedItem().toString().split("\\s")[0]
//            ));
//
//            AccountSubtype subtipoCuenta = AccountSubtype.builder()
//                    .id(id)
//                    .nombre(nombre)
//                    .accountType(tipoCuenta)
//                    .build();
//            SubTipoCuentaRepo.update(subtipoCuenta);
//
//            tabSubtiposCuentaModelo.setValueAt(id, filaIndice, 0);
//            tabSubtiposCuentaModelo.setValueAt(nombre, filaIndice, 1);
//            tabSubtiposCuentaModelo.setValueAt(tipoCuenta.getNombre(), filaIndice, 2);
//
//            dispose();
//        }
//    }//GEN-LAST:event_butEditarMouseClicked
//
//    // Validador de datos
//    private Boolean validarDatos() {
//        if (!Pattern.matches("\\d{1}\\.\\d{1,3}", texfieCodigo.getText())) {
//            JOptionPane.showMessageDialog(
//                    this, "El código debe tener entre 2 y 4 dígitos en el siguiente formato: 0.000"
//            );
//            return false;
//        }
//
//        if (texfieNombre.getText().isBlank()) {
//            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
//            return false;
//        }
//
//        if (!texfieCodigo.getText().startsWith(comboxTipoCuenta.getSelectedItem().toString().split("\\s")[0])) {
//            JOptionPane.showMessageDialog(
//                    this, "El código del subtipo de cuenta debe comenzar igual que el código del tipo de cuenta."
//            );
//            return false;
//        }
//
//        if (SubTipoCuentaRepo.findById(texfieCodigo.getText()) != null && filaIndice == null) {
//            JOptionPane.showMessageDialog(
//                    this, "Ya existe un subtipo de cuenta con este código."
//            );
//            return false;
//        }
//
//        return true;
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton butAnadir;
//    private javax.swing.JButton butEditar;
//    private javax.swing.JComboBox<String> comboxTipoCuenta;
//    private javax.swing.JLabel labCodigo;
//    private javax.swing.JLabel labNombre;
//    private javax.swing.JLabel labTipoCuenta;
//    private javax.swing.JLabel labTitulo;
//    private javax.swing.JTextField texfieCodigo;
//    private javax.swing.JTextField texfieNombre;
//    // End of variables declaration//GEN-END:variables
//}
