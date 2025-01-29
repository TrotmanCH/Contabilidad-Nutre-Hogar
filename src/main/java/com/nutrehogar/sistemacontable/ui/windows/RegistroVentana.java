//package com.nutrehogar.sistemacontable.ui.windows;
//
//import com.nutrehogar.sistemacontable.domain.model.Account;
//import com.nutrehogar.sistemacontable.domain.model.LedgerRecord;
//import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
//import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
//import com.nutrehogar.sistemacontable.domain.repository.TipoDocumentoRepo;
//import com.nutrehogar.sistemacontable.ui.styles.ButtonStyle;
//import lombok.AccessLevel;
//import lombok.experimental.FieldDefaults;
//import org.jetbrains.annotations.NotNull;
//
//import java.awt.Color;
//import java.math.BigDecimal;
//import java.math.RoundingMode;
//import java.util.List;
//import java.util.Objects;
//import javax.swing.JOptionPane;
//import javax.swing.table.DefaultTableModel;
//@FieldDefaults(level = AccessLevel.PRIVATE)
//public class RegistroVentana extends javax.swing.JFrame {
//    final List<LedgerRecord> ledgerRecords;
//    final DefaultTableModel tabRegistrosModelo;
//    final Integer filaIndice;
//
//    public RegistroVentana(String titulo, DefaultTableModel tabRegistrosModelo,
//                 Integer filaIndice, List<LedgerRecord> ledgerRecords) {
//        initComponents();
//        ButtonStyle.setStyle(butAnadir, butEditar);
//
//        // Trayendo datos de FormularioPestana
//        labTitulo.setText(titulo);
//        this.ledgerRecords = ledgerRecords;
//        this.tabRegistrosModelo = tabRegistrosModelo;
//        this.filaIndice = filaIndice;
//
//        // Trayendo los tipos de documentos y las cuentas
//        TipoDocumentoRepo.findAll().forEach(tipoDocumento -> comboxTipoDoc.addItem(tipoDocumento.getNombre()));
//        CuentaRepo.findAll().forEach(cuenta -> comboxCuenta.addItem(cuenta.getId()+ " " + cuenta.getNombre()));
//
//        // Cambiando contenido de la ventana dependiendo de si es añadir o editar
//        if (filaIndice == null) {
//            butAnadir.setVisible(true);
//            butEditar.setVisible(false);
//        } else {
//            butAnadir.setVisible(false);
//            butEditar.setVisible(true);
//
//            llenarCampos();
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
//    private void initComponents() {
//
//        butgroTipoRegistro = new javax.swing.ButtonGroup();
//        labTitulo = new javax.swing.JLabel();
//        labTipoDoc = new javax.swing.JLabel();
//        comboxTipoDoc = new javax.swing.JComboBox<>();
//        labNoComp = new javax.swing.JLabel();
//        texfieNoComp = new javax.swing.JTextField();
//        labReferencia = new javax.swing.JLabel();
//        texfieReferencia = new javax.swing.JTextField();
//        labCuenta = new javax.swing.JLabel();
//        comboxCuenta = new javax.swing.JComboBox<>();
//        labTipoRegistro = new javax.swing.JLabel();
//        radbutDebito = new javax.swing.JRadioButton();
//        radbutCredito = new javax.swing.JRadioButton();
//        labMonto = new javax.swing.JLabel();
//        texfieMonto = new javax.swing.JTextField();
//        butAnadir = new javax.swing.JButton();
//        butEditar = new javax.swing.JButton();
//
//        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
//        setBackground(Color.decode("#F1F8FF"));
//        setResizable(false);
//
//        labTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
//        labTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
//        labTitulo.setText("Titulo");
//        labTitulo.setName(" tituloFormulario"); // NOI18N
//
//        labTipoDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labTipoDoc.setText("Tipo de Doc:");
//
//        labNoComp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labNoComp.setText("No. Comp:");
//
//        labReferencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labReferencia.setText("Referencia:");
//
//        labCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labCuenta.setText("Cuenta:");
//
//        labTipoRegistro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labTipoRegistro.setText("Tipo de Registro:");
//
//        butgroTipoRegistro.add(radbutDebito);
//        radbutDebito.setSelected(true);
//        radbutDebito.setText("Debito");
//
//        butgroTipoRegistro.add(radbutCredito);
//        radbutCredito.setText("Crédito");
//
//        labMonto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
//        labMonto.setText("Monto:");
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
//                    .addComponent(labMonto)
//                    .addComponent(labNoComp)
//                    .addComponent(labReferencia)
//                    .addComponent(labCuenta)
//                    .addComponent(labTipoRegistro)
//                    .addComponent(labTipoDoc))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
//                        .addComponent(comboxCuenta, 0, 249, Short.MAX_VALUE)
//                        .addComponent(texfieReferencia))
//                    .addGroup(layout.createSequentialGroup()
//                        .addComponent(radbutDebito)
//                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                        .addComponent(radbutCredito))
//                    .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(texfieNoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
//                    .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addContainerGap(16, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addGap(0, 0, Short.MAX_VALUE)
//                .addComponent(labTitulo)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
//                .addComponent(butAnadir)
//                .addGap(18, 18, 18)
//                .addComponent(butEditar)
//                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
//        );
//        layout.setVerticalGroup(
//            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
//            .addGroup(layout.createSequentialGroup()
//                .addGap(20, 20, 20)
//                .addComponent(labTitulo)
//                .addGap(20, 20, 20)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labTipoDoc)
//                    .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labNoComp)
//                    .addComponent(texfieNoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labReferencia)
//                    .addComponent(texfieReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labCuenta)
//                    .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labTipoRegistro)
//                    .addComponent(radbutDebito)
//                    .addComponent(radbutCredito))
//                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(labMonto)
//                    .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
//                .addGap(20, 20, 20)
//                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
//                    .addComponent(butEditar)
//                    .addComponent(butAnadir))
//                .addGap(20, 20, 20))
//        );
//
//        pack();
//    }// </editor-fold>//GEN-END:initComponents
//
//    // Llenado de campos con campos del registro a actualizar
//    private void llenarCampos() {
//        LedgerRecord ledgerRecordBuscado = ledgerRecords.get(filaIndice);
//
//        comboxTipoDoc.setSelectedIndex(ledgerRecordBuscado.getDocumentType().getId() - 1);
//        texfieNoComp.setText(ledgerRecordBuscado.getComprobante());
//        texfieReferencia.setText(ledgerRecordBuscado.getReferencia());
//        comboxCuenta.setSelectedItem(ledgerRecordBuscado.getAccount().getId() +
//                " " + ledgerRecordBuscado.getAccount().getNombre()
//        );
//
//        if (!ledgerRecordBuscado.getDebe().equals(BigDecimal.ZERO)
//                && ledgerRecordBuscado.getHaber().equals(BigDecimal.ZERO)) {
//            radbutDebito.setSelected(true);
//            texfieMonto.setText(ledgerRecordBuscado.getDebe().toString());
//        } else {
//            radbutCredito.setSelected(true);
//            texfieMonto.setText(ledgerRecordBuscado.getHaber().toString());
//        }
//    }
//
//    // Escuchadores de los botones
//    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
//        actionButton();
//    }//GEN-LAST:event_butAnadirMouseClicked
//
//    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
//        actionButton();
//    }//GEN-LAST:event_butEditarMouseClicked
//
//    public void actionButton(){
//        if (validarDatos()) {
//            TipoDocumento tipoDocumento = TipoDocumentoRepo.findById(
//                    comboxTipoDoc.getSelectedIndex() + 1
//            );
//            String comprobante = texfieNoComp.getText();
//            String referencia = texfieReferencia.getText();
//            Account account = CuentaRepo.findById(
//                    Objects.requireNonNull(comboxCuenta.getSelectedItem()).toString().split("\\s")[0]
//            );
//            BigDecimal monto = new BigDecimal(texfieMonto.getText()).setScale(2, RoundingMode.HALF_UP);
//            System.out.println("Cuenta es: " + account);
//            BigDecimal debe = null;
//            BigDecimal haber = null;
//            if (radbutDebito.isSelected()) {
//                debe = monto;
//                haber = BigDecimal.ZERO;
//            } else if (radbutCredito.isSelected()){
//                haber = monto;
//                debe = BigDecimal.ZERO;
//            }
//            if (filaIndice == null) {
//                LedgerRecord ledgerRecord = LedgerRecord.builder()
//                        .documentType(tipoDocumento)
//                        .comprobante(comprobante)
//                        .referencia(referencia)
//                        .account(account)
//                        .debe(debe)
//                        .haber(haber)
//                        .build();
//                ledgerRecords.add(ledgerRecord);
//
//                tabRegistrosModelo.addRow(new Object[] {
//                        tipoDocumento.getNombre(), comprobante,
//                        referencia, account.getId(),
//                        debe, haber
//                });
//            } else {
//                LedgerRecord ledgerRecordBuscado = ledgerRecords.get(filaIndice);
//                ledgerRecordBuscado.setDocumentType(tipoDocumento);
//                ledgerRecordBuscado.setComprobante(comprobante);
//                ledgerRecordBuscado.setReferencia(referencia);
//                ledgerRecordBuscado.setAccount(account);
//                ledgerRecordBuscado.setDebe(debe);
//                ledgerRecordBuscado.setHaber(haber);
//
//                tabRegistrosModelo.setValueAt(tipoDocumento.getNombre(), filaIndice, 0);
//                tabRegistrosModelo.setValueAt(comprobante, filaIndice, 1);
//                tabRegistrosModelo.setValueAt(referencia, filaIndice, 2);
//                tabRegistrosModelo.setValueAt(account.getId(), filaIndice, 3);
//                tabRegistrosModelo.setValueAt(debe, filaIndice, 4);
//                tabRegistrosModelo.setValueAt(haber, filaIndice, 5);
//            }
//            dispose();
//        }
//    }
//
//    // Validador de datos
//    private @NotNull Boolean validarDatos() {
//        if (texfieNoComp.getText().isBlank() || texfieReferencia.getText().isBlank()) {
//            JOptionPane.showMessageDialog(this, "Uno o varios campos estan vacíos.");
//            return false;
//        }
//
//        try {
//            new BigDecimal(texfieMonto.getText());
//        } catch (NumberFormatException | ArithmeticException e) {
//            JOptionPane.showMessageDialog(this, "Introduzca un monto válido.");
//            return false;
//        }
//
//        return true;
//    }
//
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JButton butAnadir;
//    private javax.swing.JButton butEditar;
//    private javax.swing.ButtonGroup butgroTipoRegistro;
//    private javax.swing.JComboBox<String> comboxCuenta;
//    private javax.swing.JComboBox<String> comboxTipoDoc;
//    private javax.swing.JLabel labCuenta;
//    private javax.swing.JLabel labMonto;
//    private javax.swing.JLabel labNoComp;
//    private javax.swing.JLabel labReferencia;
//    private javax.swing.JLabel labTipoDoc;
//    private javax.swing.JLabel labTipoRegistro;
//    private javax.swing.JLabel labTitulo;
//    private javax.swing.JRadioButton radbutCredito;
//    private javax.swing.JRadioButton radbutDebito;
//    private javax.swing.JTextField texfieMonto;
//    private javax.swing.JTextField texfieNoComp;
//    private javax.swing.JTextField texfieReferencia;
//    // End of variables declaration//GEN-END:variables
//}
