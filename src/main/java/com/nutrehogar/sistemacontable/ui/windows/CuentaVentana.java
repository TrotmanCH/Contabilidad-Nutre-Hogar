//package com.nutrehogar.sistemacontable.ui.windows;
//
//import com.nutrehogar.sistemacontable.domain.model.Account;
//import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
//import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
//import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
//import com.nutrehogar.sistemacontable.domain.repository.SubTipoCuentaRepo;
//import com.nutrehogar.sistemacontable.domain.repository.TipoCuentaRepo;
//import com.nutrehogar.sistemacontable.ui.styles.ButtonStyle;
//import java.awt.event.ItemEvent;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Objects;
//import java.util.regex.Pattern;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//
//public class CuentaVentana extends javax.swing.JFrame {
//    List<TipoCuenta> tiposCuenta  = new ArrayList<>();
//    DefaultTableModel tabCuentasModelo;
//    Integer filaIndice;
//    Account accountBuscada;
//
//    public CuentaVentana(String titulo, DefaultTableModel tabCuentasModelo,
//            Integer filaIndice, Account accountBuscada) {
//        initComponents();
//        ButtonStyle.setStyle(butAnadir, butEditar);
//
//        // Trayendo datos de CuentasPestana
//        labTitulo.setText(titulo);
//        this.tabCuentasModelo = tabCuentasModelo;
//        this.filaIndice = filaIndice;
//        this.accountBuscada = accountBuscada;
//
//        // Trayendo los subtipos de cuenta
//        SubTipoCuentaRepo.findAll().forEach(subTipoCuenta -> {
//            comboxSubtipoCuenta.addItem(subTipoCuenta.getId() + " " + subTipoCuenta.getNombre());
//        });
//        comboxSubtipoCuenta.addItemListener(this::elementoEscuchador);
//
//        // Trayendo los tipos de cuenta
//        tiposCuenta.addAll(TipoCuentaRepo.findAll());
//        texfieTipoCuenta.setText(tiposCuenta.getFirst().getId() +  " " +
//            tiposCuenta.getFirst().getNombre()
//        );
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
//            comboxSubtipoCuenta.setEnabled(false);
//
//            llenarCampos();
//        }
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
//        labSubtipoCuenta = new javax.swing.JLabel();
//        comboxSubtipoCuenta = new javax.swing.JComboBox<>();
//        labTipoCuenta = new javax.swing.JLabel();
//        texfieTipoCuenta = new javax.swing.JTextField();
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
//        labSubtipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labSubtipoCuenta.setText("Subtipo de Cuenta:");
//
//        labTipoCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labTipoCuenta.setText("Tipo de Cuenta:");
//
//        texfieTipoCuenta.setEditable(false);
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
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(38, 38, 38)
//                        .addComponent(labTipoCuenta)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addComponent(texfieTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
//                    .addGroup(layout.createSequentialGroup()
//                        .addGap(20, 20, 20)
//                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
//                            .addGroup(layout.createSequentialGroup()
//                                .addComponent(labSubtipoCuenta)
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addComponent(comboxSubtipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
//                            .addGroup(layout.createSequentialGroup()
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(labCodigo, javax.swing.GroupLayout.Alignment.TRAILING)
//                                    .addComponent(labNombre, javax.swing.GroupLayout.Alignment.TRAILING))
//                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                                    .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
//                                    .addComponent(texfieCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))))
//                .addGap(20, 20, 20))
//            .addGroup(layout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(butAnadir)
//                .addGap(32, 32, 32)
//                .addComponent(butEditar)
//                .addGap(0, 0, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGap(0, 0, Short.MAX_VALUE)
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
//                    .addComponent(labSubtipoCuenta)
//                    .addComponent(comboxSubtipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labTipoCuenta)
//                    .addComponent(texfieTipoCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
//    // Escuchador de selección de comboxSubtipoCuenta
//    private void elementoEscuchador(ItemEvent e) {
//        int tipoCuentaId = Integer.parseInt(Objects.requireNonNull(comboxSubtipoCuenta.getSelectedItem()).toString().substring(0, 1));
//        TipoCuenta tipoCuenta = tiposCuenta.get(tipoCuentaId - 1);
//        texfieTipoCuenta.setText(
//                tipoCuenta.getId() + " " + tipoCuenta.getNombre()
//        );
//    }
//
//    // Llenador de campos de la cuentaBuscada a actualizar
//    private void llenarCampos() {
//        texfieCodigo.setText(accountBuscada.getId());
//        texfieNombre.setText(accountBuscada.getNombre());
//        comboxSubtipoCuenta.setSelectedItem(accountBuscada.getAccountSubtype().getId() +
//                " " + accountBuscada.getAccountSubtype().getNombre()
//        );
//        texfieTipoCuenta.setText(accountBuscada.getAccountSubtype().getAccountType().getId()
//                +  " " + accountBuscada.getAccountSubtype().getAccountType().getNombre()
//        );
//    }
//
//    // Escuchadores de los botones
//    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
//        if (validarDatos()) {
//            String id = texfieCodigo.getText();
//            String nombre = texfieNombre.getText();
//            AccountSubtype subtipoCuenta = SubTipoCuentaRepo.findById(
//                    Objects.requireNonNull(comboxSubtipoCuenta.getSelectedItem()).toString().split("\\s")[0]
//            );
//
//            Account account = Account.builder()
//                    .id(id)
//                    .nombre(nombre)
//                    .accountSubtype(subtipoCuenta)
//                    .build();
//            CuentaRepo.save(account);
//
//            tabCuentasModelo.addRow(new Object[] {
//                id, nombre,
//                subtipoCuenta.getAccountType().getNombre(), subtipoCuenta.getNombre()
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
//            AccountSubtype subtipoCuenta = SubTipoCuentaRepo.findById(
//                    Objects.requireNonNull(comboxSubtipoCuenta.getSelectedItem()).toString().split("\\s")[0]
//            );
//
//            Account account = Account.builder()
//                    .id(id)
//                    .nombre(nombre)
//                    .accountSubtype(subtipoCuenta)
//                    .build();
//            CuentaRepo.update(account);
//
//            tabCuentasModelo.setValueAt(id, filaIndice, 0);
//            tabCuentasModelo.setValueAt(nombre, filaIndice, 1);
//            tabCuentasModelo.setValueAt(subtipoCuenta.getAccountType().getNombre(), filaIndice, 2);
//            tabCuentasModelo.setValueAt(subtipoCuenta.getNombre(), filaIndice, 3);
//
//            dispose();
//        }
//    }//GEN-LAST:event_butEditarMouseClicked
//
//    // Validador de datos
//    private Boolean validarDatos() {
//        if (!Pattern.matches("\\d{1}\\.\\d{4}", texfieCodigo.getText())) {
//            JOptionPane.showMessageDialog(
//                    this, "El código debe tener 5 dígitos en el siguiente formato: 0.0000"
//            );
//            return false;
//        }
//
//        if (texfieNombre.getText().isBlank()) {
//            JOptionPane.showMessageDialog(this, "El nombre no puede estar vacío.");
//            return false;
//        }
//
//        if (!texfieCodigo.getText().startsWith(Objects.requireNonNull(comboxSubtipoCuenta.getSelectedItem()).toString().split("\\s")[0])) {
//            JOptionPane.showMessageDialog(
//                    this, "El código de la cuenta debe comenzar igual que el código del subtipo de cuenta."
//            );
//            return false;
//        }
//
//        if (CuentaRepo.findById(texfieCodigo.getText()) != null && filaIndice == null) {
//            JOptionPane.showMessageDialog(
//                    this, "Ya existe una cuenta con este código."
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
//    private javax.swing.JComboBox<String> comboxSubtipoCuenta;
//    private javax.swing.JLabel labCodigo;
//    private javax.swing.JLabel labNombre;
//    private javax.swing.JLabel labSubtipoCuenta;
//    private javax.swing.JLabel labTipoCuenta;
//    private javax.swing.JLabel labTitulo;
//    private javax.swing.JTextField texfieCodigo;
//    private javax.swing.JTextField texfieNombre;
//    private javax.swing.JTextField texfieTipoCuenta;
//    // End of variables declaration//GEN-END:variables
//}
