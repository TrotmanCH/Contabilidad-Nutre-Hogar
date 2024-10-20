package com.nutrehogar.sistemacontable.ui;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaRepo;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NuevoRegistro extends javax.swing.JFrame {
    private JTable tblRegistros;
//    private List<Cuenta> cuentasRegistros;
    CuentaRepo cuentaRepo = CuentaRepo.getInstance();
    
    public NuevoRegistro(JTable tblRegistros, List<Cuenta> cuentasRegistros) {
        initComponents();
        this.tblRegistros = tblRegistros;
//        this.cuentasRegistros = cuentasRegistros;
        btgrTipoRegistro.add(rdbtDebito);
        btgrTipoRegistro.add(rdbtCredito);
        cuentaRepo.findAll().forEach((cuenta) -> {
            cmbxCuenta.addItem(cuenta.getId()+ " | " + cuenta.getNombre());
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrTipoRegistro = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        txtNoCheque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtReferencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdbtDebito = new javax.swing.JRadioButton();
        rdbtCredito = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtMonto = new javax.swing.JTextField();
        bttGuardarRegistro = new javax.swing.JButton();
        cmbxCuenta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NUEVO REGISTRO");
        jLabel1.setName(" tituloFormulario"); // NOI18N

        jLabel5.setText("No. Cheque:");

        jLabel6.setText("Referencia:");

        jLabel7.setText("Cuenta:");

        jLabel8.setText("Tipo de Registro:");

        rdbtDebito.setText("Debito");

        rdbtCredito.setText("Crédito");

        jLabel9.setText("Monto:");

        bttGuardarRegistro.setText("Guardar Registro");
        bttGuardarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttGuardarRegistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(rdbtDebito)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdbtCredito))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(bttGuardarRegistro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel1)))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(rdbtDebito)
                    .addComponent(rdbtCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bttGuardarRegistro)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void bttGuardarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttGuardarRegistroMouseClicked
        // Mostrar Registro
        DefaultTableModel modeloTblRegistros = (DefaultTableModel) this.tblRegistros.getModel();
        String noCheque = txtNoCheque.getText();
        String referencia = txtReferencia.getText();
//        String codigo = cmbxCuenta.getSelectedItem().toString().substring(0, 5);
        String codigo = "11100";
        String monto = txtMonto.getText();
       
        if (rdbtDebito.isSelected()) {
            modeloTblRegistros.addRow(new Object[] {noCheque, referencia, codigo, monto, ""});
        } else if (rdbtCredito.isSelected()) {
            modeloTblRegistros.addRow(new Object[] {noCheque, referencia, codigo, "", monto});
        }
        
//        Cuenta cuentaSeleccionada = cuentaRepo.findById(codigo);
//        this.cuentasRegistros.add(cuentaSeleccionada);
        setVisible(false);
    }//GEN-LAST:event_bttGuardarRegistroMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgrTipoRegistro;
    private javax.swing.JButton bttGuardarRegistro;
    private javax.swing.JComboBox<String> cmbxCuenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rdbtCredito;
    private javax.swing.JRadioButton rdbtDebito;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNoCheque;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables
}
