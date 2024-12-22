package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.repository.AsientoRepo;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class Formulario extends javax.swing.JPanel {
    List<Registro> listaRegistro = new ArrayList<>();
    DefaultTableModel tabRegistrosModelo;
    ListSelectionModel listaSeleccionModelo;
    
    public Formulario() {
        initComponents();
           
        tabRegistrosModelo = (DefaultTableModel) tabRegistros.getModel();
        listaSeleccionModelo = tabRegistros.getSelectionModel();
        
        tabRegistrosModelo.addTableModelListener(this::tablaModeloEscucha);
        listaSeleccionModelo.addListSelectionListener(this::listaSeleccionEscucha);
        
        listaSeleccionModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        estilizarTabla();
        estilizarBotones(
                butAnadirRegistro, butEditarRegistro, 
                butEliminarRegistro, butGuardarAsiento
        );     
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        texfieNombre = new javax.swing.JTextField();
        texfieHaber = new javax.swing.JTextField();
        texfieNoDoc = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabRegistros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        spiFecha = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        jScrollPane1 = new javax.swing.JScrollPane();
        texareConcepto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        texfieDebe = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        butAnadirRegistro = new javax.swing.JButton();
        butEditarRegistro = new javax.swing.JButton();
        butGuardarAsiento = new javax.swing.JButton();
        butEliminarRegistro = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        texfieNoCheque = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        texfieMonto = new javax.swing.JTextField();
        texfieDiferencia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 248, 255));

        texfieNombre.setName("nombreField"); // NOI18N

        texfieHaber.setEditable(false);
        texfieHaber.setBackground(new java.awt.Color(255, 255, 255));

        texfieNoDoc.setEditable(false);
        texfieNoDoc.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("Total:");

        tabRegistros.setAutoCreateRowSorter(true);
        tabRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Doc.", "No. Cheque o Comp.", "Referencia", "Código", "Debe", "Haber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabRegistros.setAutoscrolls(false);
        jScrollPane3.setViewportView(tabRegistros);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Nombre:");
        jLabel5.setName(""); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("No. Doc.");

        spiFecha.setModel(new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinnerModel());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 100));

        texareConcepto.setColumns(20);
        texareConcepto.setRows(5);
        texareConcepto.setMinimumSize(new java.awt.Dimension(400, 100));
        jScrollPane1.setViewportView(texareConcepto);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("NUEVO ASIENTO");
        jLabel1.setName(" tituloFormulario"); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Monto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Concepto:");

        texfieDebe.setEditable(false);
        texfieDebe.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(241, 248, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        butAnadirRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butAnadirRegistro.setForeground(new java.awt.Color(255, 255, 255));
        butAnadirRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/anadir.png"))); // NOI18N
        butAnadirRegistro.setText("Añadir Registro");
        butAnadirRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAnadirRegistroMouseClicked(evt);
            }
        });

        butEditarRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butEditarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        butEditarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/editar1.png"))); // NOI18N
        butEditarRegistro.setEnabled(false);
        butEditarRegistro.setLabel("Editar Registro");
        butEditarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarRegistroMouseClicked(evt);
            }
        });

        butGuardarAsiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butGuardarAsiento.setForeground(new java.awt.Color(255, 255, 255));
        butGuardarAsiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/guardar.png"))); // NOI18N
        butGuardarAsiento.setText("Guardar Asiento");
        butGuardarAsiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGuardarAsientoMouseClicked(evt);
            }
        });

        butEliminarRegistro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butEliminarRegistro.setForeground(new java.awt.Color(255, 255, 255));
        butEliminarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/eliminar.png"))); // NOI18N
        butEliminarRegistro.setEnabled(false);
        butEliminarRegistro.setLabel("Eliminar Registro");
        butEliminarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEliminarRegistroMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butAnadirRegistro)
                    .addComponent(butEliminarRegistro)
                    .addComponent(butGuardarAsiento)
                    .addComponent(butEditarRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(butAnadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butEditarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(butGuardarAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Fecha:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setText("<html>No.<br>Cheque</html>");

        texfieMonto.setEditable(false);
        texfieMonto.setBackground(new java.awt.Color(255, 255, 255));

        texfieDiferencia.setEditable(false);
        texfieDiferencia.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Diferencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spiFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texfieNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel7)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(22, 22, 22)
                                .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texfieDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texfieDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(texfieHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spiFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8)
                                        .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7)
                                        .addComponent(texfieNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(jLabel9))))))
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texfieDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texfieHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(texfieDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13)))))
                .addGap(20, 20, 20))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // Estilo de los componentes
    private void estilizarTabla() {
        JTableHeader encabezado = tabRegistros.getTableHeader();
        
        encabezado.setFont(new Font("Arial", Font.BOLD, 16));
        encabezado.setBackground(Color.decode("#1E88E5"));
        encabezado.setForeground(Color.WHITE);

        tabRegistros.setFont(new Font("Arial", Font.PLAIN, 14));
        tabRegistros.setRowHeight(25);
    }

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
    
    // Escuchas de la tabla
    private void listaSeleccionEscucha(ListSelectionEvent e) {
        if (tabRegistros.getSelectedRow() != -1) {
            butEditarRegistro.setEnabled(true);
            butEliminarRegistro.setEnabled(true);
        } else {
            butEditarRegistro.setEnabled(false);
            butEliminarRegistro.setEnabled(false);
        }
    }
    private void tablaModeloEscucha(TableModelEvent e) {
        BigDecimal debeTotal = BigDecimal.ZERO.setScale(2);
        BigDecimal haberTotal = BigDecimal.ZERO.setScale(2);
        BigDecimal diferencia;
        
        for (Integer i = 0; i < tabRegistrosModelo.getRowCount(); i++) {
            debeTotal = debeTotal.add(new BigDecimal(tabRegistrosModelo.getValueAt(i, 4).toString()));
            haberTotal = haberTotal.add(new BigDecimal(tabRegistrosModelo.getValueAt(i, 5).toString()));
        }
        
        if (debeTotal.equals(haberTotal)) {
            texfieMonto.setText(debeTotal.toString());
            texfieDiferencia.setText("0.00");
        } else {
            diferencia = debeTotal.subtract(haberTotal);
            texfieDiferencia.setText(diferencia.toString());
        }
        
        texfieDebe.setText(debeTotal.toString());
        texfieHaber.setText(haberTotal.toString());
    }
    
    // Escuchas de los botones
    private void butAnadirRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirRegistroMouseClicked
        RegistroVentana rv = new RegistroVentana(listaRegistro, tabRegistrosModelo, "AÑADIR REGISTRO", null);
        rv.setLocationRelativeTo(this);
        rv.setVisible(true);
    }//GEN-LAST:event_butAnadirRegistroMouseClicked
    private void butEditarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarRegistroMouseClicked
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaRegistro = tabRegistros.getSelectedRow();
            RegistroVentana rv = new RegistroVentana(listaRegistro, tabRegistrosModelo,
                    "EDITAR REGISTRO", filaRegistro);
            rv.setLocationRelativeTo(this);
            rv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en la tabla");
        }
    }//GEN-LAST:event_butEditarRegistroMouseClicked
    private void butEliminarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEliminarRegistroMouseClicked
        if (!listaSeleccionModelo.isSelectionEmpty()){
            Integer filaRegistro = tabRegistros.getSelectedRow();
            tabRegistrosModelo.removeRow(filaRegistro);
            listaRegistro.remove(listaRegistro.get(filaRegistro));
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en la tabla");
        }
    }//GEN-LAST:event_butEliminarRegistroMouseClicked
    private void butGuardarAsientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGuardarAsientoMouseClicked
        try {
            // Verificando si los campos estan vacíos
            texfieNombre.getText().charAt(1);
            texareConcepto.getText().charAt(1);
            
            // Guardado
            Asiento asiento = Asiento.builder()
                    .fecha(LocalDate.parse(spiFecha.getValue().toString()))
                    .numeroCheque(texfieNoCheque.getText())
                    .nombre(texfieNombre.getText())
                    .concepto(texareConcepto.getText())
                    .build();
            
            listaRegistro.forEach((registro) -> {
                registro.setAsiento(asiento);
            });
            asiento.setRegistros(listaRegistro);
            
            if (texfieDebe.getText().equals(texfieHaber.getText())) {
                if (!asiento.getRegistros().isEmpty()) {
                    AsientoRepo.save(asiento);   
                } else {
                    JOptionPane.showMessageDialog(this, "Este asiento no tiene registros");
                }
            } else {
                JOptionPane.showMessageDialog(this, "El asiento no está balanceado");
            }  
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Uno o varios campos estan vacíos");
        }
    }//GEN-LAST:event_butGuardarAsientoMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadirRegistro;
    private javax.swing.JButton butEditarRegistro;
    private javax.swing.JButton butEliminarRegistro;
    private javax.swing.JButton butGuardarAsiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner spiFecha;
    private javax.swing.JTable tabRegistros;
    private javax.swing.JTextArea texareConcepto;
    private javax.swing.JTextField texfieDebe;
    private javax.swing.JTextField texfieDiferencia;
    private javax.swing.JTextField texfieHaber;
    private javax.swing.JTextField texfieMonto;
    private javax.swing.JTextField texfieNoCheque;
    private javax.swing.JTextField texfieNoDoc;
    private javax.swing.JTextField texfieNombre;
    // End of variables declaration//GEN-END:variables
}
