package com.nutrehogar.sistemacontable.ui;

import com.nutrehogar.sistemacontable.domain.model.*;
import com.nutrehogar.sistemacontable.domain.model.Asiento.AsientoBuilder;
import com.nutrehogar.sistemacontable.domain.model.Registro.RegistroBuilder;
import com.nutrehogar.sistemacontable.persistence.repository.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class NuevoAsiento extends javax.swing.JFrame {
    TipoDocumentoRepo tipoDocumentoRepo = TipoDocumentoRepo.getInstance();
    List<Cuenta> cuentasRegistros = new ArrayList<>();;
    public NuevoAsiento() {
        initComponents();
        tipoDocumentoRepo.findAll().forEach((tipoDocumento) -> {
            cmbxTipoDoc.addItem(tipoDocumento.getNombre());
        });
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtNoDoc = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblRegistros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtConcepto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        bttAnadirRegistro = new javax.swing.JButton();
        txtDebe = new javax.swing.JTextField();
        txtHaber = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cmbxTipoDoc = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        bttGuardarAsiento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Monto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Concepto:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("No. Doc.");

        jTextField1.setName("nombreField"); // NOI18N

        txtMonto.setEditable(false);

        txtNoDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtNoDoc.setName("docField"); // NOI18N

        tblRegistros.setAutoCreateRowSorter(true);
        tblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Cheque o Comp.", "Referencia", "Código", "Debe", "Haber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblRegistros.setAutoscrolls(false);
        jScrollPane3.setViewportView(tblRegistros);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");
        jLabel5.setName(""); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Fecha:");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 100));

        txtConcepto.setColumns(20);
        txtConcepto.setRows(5);
        txtConcepto.setMinimumSize(new java.awt.Dimension(400, 100));
        jScrollPane1.setViewportView(txtConcepto);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NUEVO ASIENTO");
        jLabel1.setName(" tituloFormulario"); // NOI18N

        bttAnadirRegistro.setText("Añadir Registro");
        bttAnadirRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttAnadirRegistroMouseClicked(evt);
            }
        });

        txtDebe.setEditable(false);

        txtHaber.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Total:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de Doc:");

        bttGuardarAsiento.setText("Guardar Asiento");
        bttGuardarAsiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bttGuardarAsientoMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(19, 19, 19)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNoDoc))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bttGuardarAsiento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bttAnadirRegistro)
                                .addGap(56, 56, 56)
                                .addComponent(jLabel11)
                                .addGap(26, 26, 26)
                                .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(txtHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)))
                        .addGap(27, 27, 27))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(306, 306, 306))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(txtNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cmbxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(bttAnadirRegistro)
                    .addComponent(bttGuardarAsiento))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //Clicks
    private void bttAnadirRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttAnadirRegistroMouseClicked
        new NuevoRegistro(tblRegistros, cuentasRegistros).setVisible(true);
    }//GEN-LAST:event_bttAnadirRegistroMouseClicked

    private void bttGuardarAsientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bttGuardarAsientoMouseClicked
        // Creación de Asiento
        AsientoBuilder nuevoAsiento = Asiento.builder();        
        nuevoAsiento.id(Integer.valueOf(txtNoDoc.getText()));
        nuevoAsiento.fecha(LocalDate.parse(txtFecha.getText()));
        nuevoAsiento.concepto(txtConcepto.getText());
        nuevoAsiento.tipoDocumento(tipoDocumentoRepo.findById(
                cmbxTipoDoc.getSelectedIndex()
        ));
        AsientoRepo asientoRepo = AsientoRepo.getInstance();
        Asiento asientoListo = nuevoAsiento.build();
        asientoRepo.save(asientoListo);
        // Creación de Registros
        DefaultTableModel modeloTblRegistros = (DefaultTableModel) this.tblRegistros.getModel();
        RegistroRepo registroRepo = RegistroRepo.getInstance();
        for (Integer fila = 0; fila < modeloTblRegistros.getRowCount(); fila++) {
            RegistroBuilder nuevoRegistro = Registro.builder();  
            nuevoRegistro.asiento(asientoListo);
            nuevoRegistro.comprobante(String.valueOf(modeloTblRegistros.getValueAt(fila, 0)));
            nuevoRegistro.referencia(String.valueOf(modeloTblRegistros.getValueAt(fila, 1)));
            nuevoRegistro.cuenta(cuentasRegistros.get(fila));
            Object columnaDebe = modeloTblRegistros.getValueAt(fila, 3);
            Object columnaHaber = modeloTblRegistros.getValueAt(fila, 4);

            if (columnaDebe != "") {
                nuevoRegistro.debe(BigDecimal.valueOf(
                    Double.parseDouble(columnaDebe.toString())
                ));
            } else if (columnaHaber != "") {
                nuevoRegistro.haber(BigDecimal.valueOf(
                    Double.parseDouble(columnaHaber.toString())
                ));
            }   

            Registro registroListo = nuevoRegistro.build();
            registroRepo.save(registroListo);
        }
    }//GEN-LAST:event_bttGuardarAsientoMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bttAnadirRegistro;
    private javax.swing.JButton bttGuardarAsiento;
    private javax.swing.JComboBox<String> cmbxTipoDoc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    public javax.swing.JTable tblRegistros;
    private javax.swing.JTextArea txtConcepto;
    private javax.swing.JTextField txtDebe;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtHaber;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNoDoc;
    // End of variables declaration//GEN-END:variables
}
