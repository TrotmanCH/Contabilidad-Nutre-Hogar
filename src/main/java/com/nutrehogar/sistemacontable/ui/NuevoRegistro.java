package com.nutrehogar.sistemacontable.ui;
/*
import com.nutrehogar.sistemacontable.persistence.model.CuentaEntity;
import com.nutrehogar.sistemacontable.persistence.model.TipoDocumentoEntity;
import com.nutrehogar.sistemacontable.persistence.model.TransaccionEntity;
import com.nutrehogar.sistemacontable.persistence.model.TransaccionEntity.TransaccionEntityBuilder;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaHibernateRepository;
import com.nutrehogar.sistemacontable.persistence.repository.TipoDocumentoHibernateRepository;
import com.nutrehogar.sistemacontable.persistence.repository.TransaccionHibernateRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
*/
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class NuevoRegistro extends javax.swing.JFrame {
    private JTable tabla;
    /*TipoDocumentoHibernateRepository tipoDocumentoRepo = TipoDocumentoHibernateRepository.getInstance();
    CuentaHibernateRepository cuentaRepo = CuentaHibernateRepository.getInstance();*/
    
    public NuevoRegistro(JTable tabla) {
        initComponents();
        
        this.tabla = tabla;
        /*
        btgrTipoRegistro.add(rdbtDebito);
        btgrTipoRegistro.add(rdbtCredito);
        cmbxCuenta.addItem("pepe");
        List<TipoDocumentoEntity> listaTiposDocumento = tipoDocumentoRepo.findAll();
        listaTiposDocumento.forEach((tipoDocumento) -> {
            cmbxTipoDoc.addItem(tipoDocumento.getNombre());
        });
        List<CuentaEntity> listaCuentas = cuentaRepo.findAll();
        listaCuentas.forEach((cuenta) -> {
            cmbxCuenta.addItem(cuenta.getNoCuenta() + " | " + cuenta.getNombre());
        });
        */
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btgrTipoRegistro = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNoDoc = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
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
        bttRegistrar = new javax.swing.JButton();
        cmbxTipoDoc = new javax.swing.JComboBox<>();
        cmbxCuenta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NUEVO REGISTRO");
        jLabel1.setName(" tituloFormulario"); // NOI18N

        jLabel2.setText("Fecha:");

        jLabel3.setText("No. Doc:");

        jLabel4.setText("Tipo de Doc:");

        jLabel5.setText("No. Cheque:");

        jLabel6.setText("Referencia:");

        jLabel7.setText("Cuenta:");

        jLabel8.setText("Tipo de Registro:");

        rdbtDebito.setText("Debito");

        rdbtCredito.setText("Crédito");

        jLabel9.setText("Monto:");

        bttRegistrar.setText("Registrar");
        bttRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttRegistrarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(bttRegistrar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(61, 61, 61)))
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
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 96, Short.MAX_VALUE)))))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(bttRegistrar)
                        .addGap(23, 23, 23))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Clicks
    private void bttRegistrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttRegistrarMouseClicked
        // Mostrar Registro
        /*
        DefaultTableModel modeloTabla = (DefaultTableModel) this.tabla.getModel();
        String fecha = txtFecha.getText();
        String noDoc = txtNoDoc.getText();                
        String tipoDoc = cmbxTipoDoc.getSelectedItem().toString();
        String noCheque = txtNoCheque.getText();
        String referencia = txtReferencia.getText();
        String codigo = cmbxCuenta.getSelectedItem().toString();
        String monto = txtMonto.getText();
        // Registrar Transaccion
        TransaccionEntityBuilder nuevaTransaccion = TransaccionEntity.builder();
        //
        LocalDate fechaFormat = LocalDate.parse(fecha.replace("/", "-"));
        nuevaTransaccion.fecha(fechaFormat);
        //
        nuevaTransaccion.noDocumento(Integer.parseInt(noDoc));
        //      
        TipoDocumentoEntity tipoDocumento = tipoDocumentoRepo.findById(cmbxTipoDoc.getSelectedIndex());
        nuevaTransaccion.tipoDocumento(tipoDocumento);
        //
        nuevaTransaccion.noCheque(noCheque);
        //
        nuevaTransaccion.referencia(referencia);
        //
        CuentaEntity cuenta = cuentaRepo.findById(cmbxCuenta.getSelectedIndex());
        nuevaTransaccion.cuenta(cuenta);
        //
        BigDecimal montoFormat = BigDecimal.valueOf(Double.parseDouble(monto));
        if (rdbtDebito.isSelected()) {
            nuevaTransaccion.debito(montoFormat);
            nuevaTransaccion.credito(null);
        } else if (rdbtCredito.isSelected()) {
            nuevaTransaccion.credito(montoFormat);
            nuevaTransaccion.debito(null);
        }    
        //
        TransaccionHibernateRepository transaccionRepo = TransaccionHibernateRepository.getInstance();
        transaccionRepo.save(nuevaTransaccion.build());
        // wait
        int ultimoRegistroIndice = transaccionRepo.findAll().size();
        TransaccionEntity ultimoRegistro = transaccionRepo.findById(ultimoRegistroIndice);
        
        if (ultimoRegistro.getDebito() != null) {
            modeloTabla.addRow(new Object[] {fecha, noDoc, tipoDoc, noCheque,
                referencia, codigo, monto, ""});   
        } else if (ultimoRegistro.getCredito() != null) {
            modeloTabla.addRow(new Object[] {fecha, noDoc, tipoDoc, noCheque,
                referencia, codigo, "", monto});
        }
        setVisible(false);
    }//GEN-LAST:event_bttRegistrarMouseClicked
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoRegistro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoRegistro().setVisible(true);
            }
        });
        */
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btgrTipoRegistro;
    private javax.swing.JButton bttRegistrar;
    private javax.swing.JComboBox<String> cmbxCuenta;
    private javax.swing.JComboBox<String> cmbxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rdbtCredito;
    private javax.swing.JRadioButton rdbtDebito;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNoCheque;
    private javax.swing.JTextField txtNoDoc;
    private javax.swing.JTextField txtReferencia;
    // End of variables declaration//GEN-END:variables
}
