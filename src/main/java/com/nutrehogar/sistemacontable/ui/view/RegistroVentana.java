package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.domain.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.domain.repository.TipoDocumentoRepo;
import java.awt.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroVentana extends javax.swing.JFrame {
    List<Registro> listaRegistro;
    DefaultTableModel tabRegistrosModelo;
    Integer filaRegistro;
    
    public RegistroVentana(List<Registro> listaRegistro, DefaultTableModel tabRegistrosModelo, 
                String titulo, Integer filaRegistro) {
        initComponents();
        
        this.listaRegistro = listaRegistro;
        this.tabRegistrosModelo = tabRegistrosModelo;
        this.filaRegistro = filaRegistro;
        
        TipoDocumentoRepo.findAll().forEach((tipoDocumento) -> {
            comboxTipoDoc.addItem(tipoDocumento.getNombre());
        });
        CuentaRepo.findAll().forEach((cuenta) -> {
            comboxCuenta.addItem(cuenta.getId()+ " " + cuenta.getNombre());
        });
                
        if (filaRegistro == null) {
            butAnadir.setVisible(true);
            butEditar.setVisible(false);
        } else {
            butAnadir.setVisible(false);
            butEditar.setVisible(true);
            
            llenarCampos();
        }
        
        labTitulo.setText(titulo);
        estilizarBotones(butAnadir, butEditar);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        butgroTipoRegistro = new javax.swing.ButtonGroup();
        labTitulo = new javax.swing.JLabel();
        labTipoDoc = new javax.swing.JLabel();
        comboxTipoDoc = new javax.swing.JComboBox<>();
        labNoComp = new javax.swing.JLabel();
        texfieNoComp = new javax.swing.JTextField();
        labReferencia = new javax.swing.JLabel();
        texfieReferencia = new javax.swing.JTextField();
        labCuenta = new javax.swing.JLabel();
        comboxCuenta = new javax.swing.JComboBox<>();
        labTipoRegistro = new javax.swing.JLabel();
        radbutDebito = new javax.swing.JRadioButton();
        radbutCredito = new javax.swing.JRadioButton();
        labMonto = new javax.swing.JLabel();
        texfieMonto = new javax.swing.JTextField();
        butAnadir = new javax.swing.JButton();
        butEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(Color.decode("#F1F8FF"));
        setResizable(false);

        labTitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labTitulo.setText("Titulo");
        labTitulo.setName(" tituloFormulario"); // NOI18N

        labTipoDoc.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labTipoDoc.setText("Tipo de Doc:");

        labNoComp.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labNoComp.setText("No. Comp:");

        labReferencia.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labReferencia.setText("Referencia:");

        labCuenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labCuenta.setText("Cuenta:");

        labTipoRegistro.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labTipoRegistro.setText("Tipo de Registro:");

        butgroTipoRegistro.add(radbutDebito);
        radbutDebito.setSelected(true);
        radbutDebito.setText("Debito");

        butgroTipoRegistro.add(radbutCredito);
        radbutCredito.setText("Crédito");

        labMonto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        labMonto.setText("Monto:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(butAnadir)
                .addGap(18, 18, 18)
                .addComponent(butEditar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(labMonto)
                            .addComponent(labNoComp)
                            .addComponent(labReferencia)
                            .addComponent(labCuenta)
                            .addComponent(labTipoRegistro)
                            .addComponent(labTipoDoc))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texfieNoComp, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(comboxCuenta, 0, 249, Short.MAX_VALUE)
                                .addComponent(texfieReferencia))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(radbutDebito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radbutCredito))
                            .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(153, Short.MAX_VALUE)
                        .addComponent(labTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 135, Short.MAX_VALUE)))
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labTitulo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTipoDoc)
                    .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labNoComp)
                    .addComponent(texfieNoComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labReferencia)
                    .addComponent(texfieReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labCuenta)
                    .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labTipoRegistro)
                    .addComponent(radbutDebito)
                    .addComponent(radbutCredito))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labMonto)
                    .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butEditar)
                    .addComponent(butAnadir))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Estilo de los botones
    private void estilizarBotones(JButton... botones) {
        Arrays.asList(botones).forEach((boton) -> {
            boton.setPreferredSize(new Dimension(120, 50));
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
                    g2d.dispose();

                    super.paint(g, c);
                }
            }); 
        });
    }
    
    // Llenado de campos del registro a acutalizar
    private void llenarCampos() {
        Registro registroSeleccionado = listaRegistro.get(filaRegistro);
        
        comboxTipoDoc.setSelectedIndex(registroSeleccionado.getTipoDocumento().getId() - 1);
        texfieNoComp.setText(registroSeleccionado.getComprobante());
        texfieReferencia.setText(registroSeleccionado.getReferencia());
        comboxCuenta.setSelectedItem(registroSeleccionado.getCuenta().getId() +
                " " + registroSeleccionado.getCuenta().getNombre()
        );

        if (!registroSeleccionado.getDebe().equals(BigDecimal.ZERO.setScale(2))  
                && registroSeleccionado.getHaber().equals(BigDecimal.ZERO.setScale(2))) {
            radbutDebito.setSelected(true);
            texfieMonto.setText(registroSeleccionado.getDebe().toString());
        } else {
            radbutCredito.setSelected(true);
            texfieMonto.setText(registroSeleccionado.getHaber().toString());
        }
    }
    
    // Escuchadores de los botones
    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
        if (validarDatos()) {
            TipoDocumento tipoDocumento = TipoDocumentoRepo.findById(
                    comboxTipoDoc.getSelectedIndex() + 1
            );
            
            String comprobante = texfieNoComp.getText();
            String referencia = texfieReferencia.getText();
            
            Cuenta cuenta = CuentaRepo.findById(
                    comboxCuenta.getSelectedItem().toString().substring(0, 6)
            );
            
            BigDecimal monto = new BigDecimal(texfieMonto.getText()).setScale(2);
            
            BigDecimal debe = null;
            BigDecimal haber = null;

            if (radbutDebito.isSelected()) {
                debe = monto;
                haber = BigDecimal.ZERO.setScale(2);
            } else if (radbutCredito.isSelected()){
                haber = monto;
                debe = BigDecimal.ZERO.setScale(2);
            }

            Registro registro = Registro.builder()
                    .tipoDocumento(tipoDocumento)
                    .comprobante(comprobante)
                    .referencia(referencia)
                    .cuenta(cuenta)
                    .debe(debe)
                    .haber(haber)
                    .build();
            listaRegistro.add(registro);
            tabRegistrosModelo.addRow(new Object[] {
                    tipoDocumento.getNombre(), comprobante, 
                    referencia, cuenta.getId(),
                    debe, haber    
            });

            dispose();
        }
    }//GEN-LAST:event_butAnadirMouseClicked
    
    private void butEditarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarMouseClicked
        if (validarDatos()) {
            TipoDocumento tipoDocumento = TipoDocumentoRepo.findById(
                    comboxTipoDoc.getSelectedIndex() + 1
            );
            
            String comprobante = texfieNoComp.getText();
            String referencia = texfieReferencia.getText();
            
            Cuenta cuenta = CuentaRepo.findById(
                    comboxCuenta.getSelectedItem().toString().substring(0, 6)
            );
            
            BigDecimal monto = new BigDecimal(texfieMonto.getText()).setScale(2);
            
            BigDecimal debe = null;
            BigDecimal haber = null;

            if (radbutDebito.isSelected()) {
                debe = monto;
                haber = BigDecimal.ZERO.setScale(2);
            } else if (radbutCredito.isSelected()){
                haber = monto;
                debe = BigDecimal.ZERO.setScale(2);
            }
            
            Registro registroSeleccionado = listaRegistro.get(filaRegistro);
            registroSeleccionado.setTipoDocumento(tipoDocumento);
            registroSeleccionado.setComprobante(comprobante);
            registroSeleccionado.setReferencia(referencia);
            registroSeleccionado.setCuenta(cuenta);
            registroSeleccionado.setDebe(debe);
            registroSeleccionado.setHaber(haber);
            
            tabRegistrosModelo.setValueAt(tipoDocumento.getNombre(), filaRegistro, 0);
            tabRegistrosModelo.setValueAt(comprobante, filaRegistro, 1);
            tabRegistrosModelo.setValueAt(referencia, filaRegistro, 2);
            tabRegistrosModelo.setValueAt(cuenta.getId(), filaRegistro, 3);
            tabRegistrosModelo.setValueAt(debe, filaRegistro, 4);
            tabRegistrosModelo.setValueAt(haber, filaRegistro, 5);
            
            dispose();
        }
    }//GEN-LAST:event_butEditarMouseClicked
    
    // Validador de datos
    private Boolean validarDatos() {
        if (texfieNoComp.getText().isBlank() || 
                texfieReferencia.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Uno o varios campos estan vacíos");
            return false;
        }
        
        try {
            new BigDecimal(texfieMonto.getText()).setScale(2);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduzca un número decimal válido");
            return false;
        }
        
        return true;
    }
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.ButtonGroup butgroTipoRegistro;
    private javax.swing.JComboBox<String> comboxCuenta;
    private javax.swing.JComboBox<String> comboxTipoDoc;
    private javax.swing.JLabel labCuenta;
    private javax.swing.JLabel labMonto;
    private javax.swing.JLabel labNoComp;
    private javax.swing.JLabel labReferencia;
    private javax.swing.JLabel labTipoDoc;
    private javax.swing.JLabel labTipoRegistro;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JRadioButton radbutCredito;
    private javax.swing.JRadioButton radbutDebito;
    private javax.swing.JTextField texfieMonto;
    private javax.swing.JTextField texfieNoComp;
    private javax.swing.JTextField texfieReferencia;
    // End of variables declaration//GEN-END:variables
}
