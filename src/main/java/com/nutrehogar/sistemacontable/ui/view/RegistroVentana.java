package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Registro;
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
            comboxCuenta.addItem(cuenta.getId()+ " | " + cuenta.getNombre());
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
        setBackground(Color.decode("#F1F8FF"));
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

        butAnadir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butAnadir.setForeground(new java.awt.Color(255, 255, 255));
        butAnadir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/archivo-de-texto-agregar-boton-de-interfaz-contorneado.png"))); // NOI18N
        butAnadir.setText("Añadir");
        butAnadir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAnadirMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tipo de Doc:");

        butEditar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        butEditar.setForeground(new java.awt.Color(255, 255, 255));
        butEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/escritura.png"))); // NOI18N
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
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboxTipoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(radbutDebito)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(radbutCredito)))
                        .addGap(113, 113, 113))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(54, 54, 54)
                                .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addComponent(butAnadir)
                                    .addGap(18, 18, 18)
                                    .addComponent(butEditar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(31, 31, 31)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboxCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(texfieReferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(16, 16, 16))))
            .addGroup(layout.createSequentialGroup()
                .addGap(178, 178, 178)
                .addComponent(labTitulo))
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
                .addContainerGap(28, Short.MAX_VALUE))
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
    
    // Llenado de campos al actualizar un registro
    private void llenarCampos() {
        Registro registroSeleccionado = listaRegistro.get(filaRegistro);
        comboxTipoDoc.setSelectedIndex(registroSeleccionado.getTipoDocumento().getId() - 1);
        texfieNoCheque.setText(registroSeleccionado.getComprobante());
        texfieReferencia.setText(registroSeleccionado.getReferencia());

        Object cuentaRegistroSeleccionado = registroSeleccionado.getCuenta().getId() +
                " | " + registroSeleccionado.getCuenta().getNombre();
        comboxCuenta.setSelectedItem(cuentaRegistroSeleccionado);

        if (!registroSeleccionado.getDebe().equals(BigDecimal.ZERO.setScale(2))  
                && registroSeleccionado.getHaber().equals(BigDecimal.ZERO.setScale(2))) {
            radbutDebito.setSelected(true);
            texfieMonto.setText(registroSeleccionado.getDebe().toString());
        } else {
            System.out.println(registroSeleccionado.getHaber().toString());
            radbutCredito.setSelected(true);
            texfieMonto.setText(registroSeleccionado.getHaber().toString());
        }
    }
    
    // Escuchas de los botones
    private void butAnadirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirMouseClicked
        if (butAnadir.isEnabled()) {
            try {
                // Verificando si los campos estan vacíos
                texfieNoCheque.getText().charAt(1);
                texfieReferencia.getText().charAt(1);
                
                // Guardado
                Registro registro = Registro.builder()
                        .tipoDocumento(TipoDocumentoRepo.findById(
                            comboxTipoDoc.getSelectedIndex() + 1
                        ))
                        .comprobante(texfieNoCheque.getText())
                        .referencia(texfieReferencia.getText())
                        .cuenta(CuentaRepo.findById(
                            comboxCuenta.getSelectedItem().toString().substring(0, 6)
                        ))
                        .build();
                
                if (radbutDebito.isSelected()) {
                    registro.setDebe(new BigDecimal(texfieMonto.getText()).setScale(2));
                    registro.setHaber(BigDecimal.ZERO.setScale(2));
                } else if (radbutCredito.isSelected()){
                    registro.setDebe(BigDecimal.ZERO.setScale(2));
                    registro.setHaber(new BigDecimal(texfieMonto.getText()).setScale(2));
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
                JOptionPane.showMessageDialog(this, "Uno o varios campos estan vacíos");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Introduzca un número decimal válido");
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
                registroSeleccionado.setTipoDocumento(TipoDocumentoRepo.findById(
                            comboxTipoDoc.getSelectedIndex() + 1
                        ));
                registroSeleccionado.setComprobante(texfieNoCheque.getText());
                registroSeleccionado.setReferencia(texfieReferencia.getText());
                registroSeleccionado.setCuenta(CuentaRepo.findById(
                            comboxCuenta.getSelectedItem().toString().substring(0, 6)
                        ));
                
                if (radbutDebito.isSelected()) {
                    tabRegistrosModelo.setValueAt(new BigDecimal(texfieMonto.getText()).setScale(2), filaRegistro, 4);
                    tabRegistrosModelo.setValueAt(BigDecimal.ZERO.setScale(2), filaRegistro, 5);
                    
                    registroSeleccionado.setDebe(new BigDecimal(texfieMonto.getText()).setScale(2));
                    registroSeleccionado.setHaber(BigDecimal.ZERO.setScale(2));
                } else if (radbutCredito.isSelected()) {
                    tabRegistrosModelo.setValueAt(BigDecimal.ZERO.setScale(2), filaRegistro, 4);
                    tabRegistrosModelo.setValueAt(new BigDecimal(texfieMonto.getText()).setScale(2), filaRegistro, 5);
                    
                    registroSeleccionado.setDebe(BigDecimal.ZERO.setScale(2));
                    registroSeleccionado.setHaber(new BigDecimal(texfieMonto.getText()).setScale(2));
                }
                
                dispose();
            } catch (IndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(this, "Uno o varios campos estan vacíos");
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Introduzca un número decimal válido");
            }
        }
    }//GEN-LAST:event_butEditarMouseClicked
    
    // Escucha de texfieMonto
    private void texfieMontoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_texfieMontoFocusLost
        try {
            BigDecimal.valueOf(Double.parseDouble(texfieMonto.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Introduzca un número decimal válido");
            texfieMonto.setText("");
        }
    }//GEN-LAST:event_texfieMontoFocusLost
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadir;
    private javax.swing.JButton butEditar;
    private javax.swing.ButtonGroup butgroTipoRegistro;
    private javax.swing.JComboBox<String> comboxCuenta;
    private javax.swing.JComboBox<String> comboxTipoDoc;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel labTitulo;
    private javax.swing.JRadioButton radbutCredito;
    private javax.swing.JRadioButton radbutDebito;
    private javax.swing.JTextField texfieMonto;
    private javax.swing.JTextField texfieNoCheque;
    private javax.swing.JTextField texfieReferencia;
    // End of variables declaration//GEN-END:variables
}
