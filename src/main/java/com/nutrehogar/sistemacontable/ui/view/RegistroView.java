package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.TipoDocumentoRepo;
import java.math.BigDecimal;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroView extends javax.swing.JFrame {
    private final List<Registro> listaRegistro;
    private final DefaultTableModel tabRegistrosModelo;
    private Integer filaRegistro;
    
    TipoDocumentoRepo tipoDocumentoRepo = TipoDocumentoRepo.getInstance();
    CuentaRepo cuentaRepo = CuentaRepo.getInstance();
    
    public RegistroView(List<Registro> listaRegistro, DefaultTableModel tabRegistrosModelo, 
                String titulo, Integer filaRegistro) {
        initComponents();
        labTitulo.setText(titulo);
        
        if (titulo == "AÑADIR REGISTRO") {
            butAnadir.setEnabled(true);
            butEditar.setEnabled(false);
        } else if (titulo == "EDITAR REGISTRO") {
            butAnadir.setEnabled(false);
            butEditar.setEnabled(true);
        }
        
        this.listaRegistro = listaRegistro;
        this.tabRegistrosModelo = tabRegistrosModelo;
        this.filaRegistro = filaRegistro;
        
        tipoDocumentoRepo.findAll().forEach((tipoDocumento) -> {
            comboxTipoDoc.addItem(tipoDocumento.getNombre());
        });
        cuentaRepo.findAll().forEach((cuenta) -> {
            comboxCuenta.addItem(cuenta.getId()+ " | " + cuenta.getNombre());
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butgroTipoRegistro = new javax.swing.ButtonGroup();
        labTitulo = new javax.swing.JLabel();
        texfieNoCheque = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        texfieReferencia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        radbutDebito = new javax.swing.JRadioButton();
        radbutCredito = new javax.swing.JRadioButton();
        jLabel9 = new javax.swing.JLabel();
        texfieMonto = new javax.swing.JTextField();
        butAnadir = new javax.swing.JButton();
        comboxCuenta = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        comboxTipoDoc = new javax.swing.JComboBox<>();
        butEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labTitulo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labTitulo.setText("TEXTO");
        labTitulo.setName(" tituloFormulario"); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("No. Cheque:");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Referencia:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Cuenta:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tipo de Registro:");

        butgroTipoRegistro.add(radbutDebito);
        radbutDebito.setSelected(true);
        radbutDebito.setText("Debito");

        butgroTipoRegistro.add(radbutCredito);
        radbutCredito.setText("Crédito");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Monto:");

        texfieMonto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                texfieMontoFocusLost(evt);
            }
        });

        butAnadir.setText("Añadir");
        butAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAnadirMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de Doc:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labTitulo)
                        .addGap(195, 195, 195))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(texfieReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(radbutDebito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radbutCredito))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(butAnadir)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(butEditar))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(63, 63, 63))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(texfieReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(radbutDebito)
                    .addComponent(radbutCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butEditar)
                    .addComponent(butAnadir))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
        if (butAnadir.isEnabled()) {
           try {
                //  Generación de excepciones
                texfieNoCheque.getText().charAt(1);
                texfieReferencia.getText().charAt(1);
                
                // Guardado
                Registro registro = Registro.builder()
                        .tipoDocumento(tipoDocumentoRepo.findById(
                            comboxTipoDoc.getSelectedIndex() + 1
                        ))
                        .comprobante(texfieNoCheque.getText())
                        .referencia(texfieReferencia.getText())
                        .cuenta(cuentaRepo.findById(
                            comboxCuenta.getSelectedItem().toString().substring(0, 6)
                        ))
                        .build();
                
                BigDecimal monto = BigDecimal.valueOf(Double.parseDouble(
                        texfieMonto.getText()
                ));

                if (radbutDebito.isSelected()) {
                    registro.setDebe(monto);
                    registro.setHaber(BigDecimal.ZERO);
                } else if (radbutCredito.isSelected()){
                    registro.setDebe(BigDecimal.ZERO);
                    registro.setHaber(monto);
                }

                listaRegistro.add(registro);
                tabRegistrosModelo.addRow(new Object[] {
                    registro.getTipoDocumento().getNombre(), 
                    registro.getComprobante(), 
                    registro.getReferencia(),
                    registro.getCuenta().getId(),
                    registro.getDebe(),
                    registro.getHaber()
                });

                dispose();
            } catch (IndexOutOfBoundsException e) {
                mostrarError("Campos Vacíos", "Uno o varios campos estan vacíos");
            } catch (NumberFormatException e) {
                mostrarError("Valor Incorrecto", "Introduzca un número decimal válido");
            }
        }  
    }//GEN-LAST:event_butAnadirMouseClicked

    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
        if (butEditar.isEnabled()) {
            try {
                // Generación de excepciones
                texfieNoCheque.getText().charAt(1);
                texfieReferencia.getText().charAt(1);
                
                // Editado
                tabRegistrosModelo.setValueAt(comboxTipoDoc.getSelectedItem(), filaRegistro, 0);
                tabRegistrosModelo.setValueAt(texfieNoCheque.getText(), filaRegistro, 1);
                tabRegistrosModelo.setValueAt(texfieReferencia.getText(), filaRegistro, 2);
                tabRegistrosModelo.setValueAt(comboxCuenta.getSelectedItem().toString().substring(0, 6), filaRegistro, 3);
                
                Registro registroSeleccionado = listaRegistro.get(filaRegistro);
                registroSeleccionado.setTipoDocumento(tipoDocumentoRepo.findById(
                            comboxTipoDoc.getSelectedIndex() + 1
                        ));
                registroSeleccionado.setComprobante(texfieNoCheque.getText());
                registroSeleccionado.setReferencia(texfieReferencia.getText());
                registroSeleccionado.setCuenta(cuentaRepo.findById(
                            comboxCuenta.getSelectedItem().toString().substring(0, 6)
                        ));
                
                BigDecimal monto = BigDecimal.valueOf(Double.parseDouble(
                        texfieMonto.getText()
                ));
                if (radbutDebito.isSelected()) {
                    tabRegistrosModelo.setValueAt(texfieMonto.getText(), filaRegistro, 4);
                    tabRegistrosModelo.setValueAt(BigDecimal.ZERO, filaRegistro, 5);
                    
                    registroSeleccionado.setDebe(monto);
                    registroSeleccionado.setHaber(BigDecimal.ZERO);
                } else if (radbutCredito.isSelected()) {
                    tabRegistrosModelo.setValueAt(BigDecimal.ZERO, filaRegistro, 4);
                    tabRegistrosModelo.setValueAt(texfieMonto.getText(), filaRegistro, 5);
                    
                    registroSeleccionado.setDebe(BigDecimal.ZERO);
                    registroSeleccionado.setHaber(monto);
                }
                dispose();
            } catch (IndexOutOfBoundsException e) {
                mostrarError("Campos Vacíos", "Uno o varios campos estan vacíos");
            } catch (NumberFormatException e) {
                mostrarError("Valor Incorrecto", "Introduzca un número decimal válido");
            }
        }
    }//GEN-LAST:event_butEditarMouseClicked
    private void texfieMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texfieMontoFocusLost
        try {
            BigDecimal.valueOf(Double.parseDouble(texfieMonto.getText()));
        } catch (NumberFormatException e) {
            mostrarError("Valor Incorrecto", "Introduzca un número decimal válido");
            texfieMonto.setText("");
        }
    }//GEN-LAST:event_texfieMontoFocusLost
    
    private void mostrarError(String titulo, String mensaje){
        JOptionPane.showMessageDialog(null, mensaje, 
                    titulo, JOptionPane.ERROR_MESSAGE
        );
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.ButtonGroup butgroTipoRegistro;
    public javax.swing.JComboBox<String> comboxCuenta;
    public javax.swing.JComboBox<String> comboxTipoDoc;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labTitulo;
    public javax.swing.JRadioButton radbutCredito;
    public javax.swing.JRadioButton radbutDebito;
    public javax.swing.JTextField texfieMonto;
    public javax.swing.JTextField texfieNoCheque;
    public javax.swing.JTextField texfieReferencia;
    // End of variables declaration//GEN-END:variables
}
