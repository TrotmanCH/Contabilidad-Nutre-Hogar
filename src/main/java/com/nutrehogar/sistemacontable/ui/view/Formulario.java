package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.repository.AsientoRepo;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
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
        
        Integer noDoc = AsientoRepo.count() +  1;
        texfieNoDoc.setText(new DecimalFormat("000").format(noDoc));
        
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
        labTotal = new javax.swing.JLabel();
        scrpanRegistros = new javax.swing.JScrollPane();
        tabRegistros = new javax.swing.JTable();
        labNombre = new javax.swing.JLabel();
        labNoDoc = new javax.swing.JLabel();
        spiFecha = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        scrpanConcepto = new javax.swing.JScrollPane();
        texareConcepto = new javax.swing.JTextArea();
        labFormulario = new javax.swing.JLabel();
        labMonto = new javax.swing.JLabel();
        labConcepto = new javax.swing.JLabel();
        texfieDebe = new javax.swing.JTextField();
        panAcciones = new javax.swing.JPanel();
        butAnadirRegistro = new javax.swing.JButton();
        butEditarRegistro = new javax.swing.JButton();
        butGuardarAsiento = new javax.swing.JButton();
        butEliminarRegistro = new javax.swing.JButton();
        labFecha = new javax.swing.JLabel();
        texfieNoCheque = new javax.swing.JTextField();
        labNoCheque = new javax.swing.JLabel();
        texfieMonto = new javax.swing.JTextField();
        texfieDiferencia = new javax.swing.JTextField();
        labDiferencia = new javax.swing.JLabel();

        setBackground(new java.awt.Color(241, 248, 255));

        texfieNombre.setName("nombreField"); // NOI18N

        texfieHaber.setEditable(false);
        texfieHaber.setBackground(new java.awt.Color(255, 255, 255));

        texfieNoDoc.setEditable(false);
        texfieNoDoc.setBackground(new java.awt.Color(255, 255, 255));

        labTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labTotal.setText("Total:");

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
        scrpanRegistros.setViewportView(tabRegistros);

        labNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNombre.setText("Nombre:");
        labNombre.setName(""); // NOI18N

        labNoDoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNoDoc.setText("No. Doc.");

        spiFecha.setModel(new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinnerModel());

        scrpanConcepto.setPreferredSize(new java.awt.Dimension(400, 100));

        texareConcepto.setColumns(20);
        texareConcepto.setRows(5);
        texareConcepto.setMinimumSize(new java.awt.Dimension(400, 100));
        scrpanConcepto.setViewportView(texareConcepto);

        labFormulario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        labFormulario.setText("Formulario");
        labFormulario.setName(" tituloFormulario"); // NOI18N

        labMonto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labMonto.setText("Monto:");

        labConcepto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labConcepto.setText("Concepto:");

        texfieDebe.setEditable(false);
        texfieDebe.setBackground(new java.awt.Color(255, 255, 255));

        panAcciones.setBackground(new java.awt.Color(241, 248, 255));
        panAcciones.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

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

        javax.swing.GroupLayout panAccionesLayout = new javax.swing.GroupLayout(panAcciones);
        panAcciones.setLayout(panAccionesLayout);
        panAccionesLayout.setHorizontalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAccionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butAnadirRegistro)
                    .addComponent(butEliminarRegistro)
                    .addComponent(butGuardarAsiento)
                    .addComponent(butEditarRegistro))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panAccionesLayout.setVerticalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAccionesLayout.createSequentialGroup()
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

        labFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labFecha.setText("Fecha:");

        labNoCheque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNoCheque.setText("<html>No.<br>Cheque</html>");

        texfieMonto.setEditable(false);
        texfieMonto.setBackground(new java.awt.Color(255, 255, 255));

        texfieDiferencia.setEditable(false);
        texfieDiferencia.setBackground(new java.awt.Color(255, 255, 255));

        labDiferencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labDiferencia.setText("Diferencia:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labFormulario)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labNombre)
                                .addGap(18, 18, 18)
                                .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labConcepto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scrpanConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labFecha)
                                    .addComponent(labNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(spiFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(texfieNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(labNoDoc)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labMonto)
                                .addGap(22, 22, 22)
                                .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labDiferencia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texfieDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labTotal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(texfieDebe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(texfieHaber, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(scrpanRegistros, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20)
                .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labFormulario)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 100, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(texfieNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(spiFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labFecha)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labMonto)
                                        .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labNoDoc)
                                        .addComponent(texfieNoDoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(labNombre)
                                        .addComponent(labNoCheque, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(scrpanConcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(37, 37, 37)
                                            .addComponent(labConcepto))))))
                        .addGap(20, 20, 20)
                        .addComponent(scrpanRegistros, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(texfieDiferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labDiferencia))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(texfieDebe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(texfieHaber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(labTotal)))))
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
    private javax.swing.JLabel labConcepto;
    private javax.swing.JLabel labDiferencia;
    private javax.swing.JLabel labFecha;
    private javax.swing.JLabel labFormulario;
    private javax.swing.JLabel labMonto;
    private javax.swing.JLabel labNoCheque;
    private javax.swing.JLabel labNoDoc;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labTotal;
    private javax.swing.JPanel panAcciones;
    private javax.swing.JScrollPane scrpanConcepto;
    private javax.swing.JScrollPane scrpanRegistros;
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
