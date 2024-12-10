package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.persistence.repository.AsientoRepo;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class AsientoView extends javax.swing.JFrame {
    private final List<Registro> listaRegistro = new ArrayList<>();
    private final DefaultTableModel tabRegistrosModelo;
    private final ListSelectionModel listaSeleccionModelo;
    private final CustomListSelectionListener listaSeleccionEscucha;
    private final CustomTableModelListener tablaModeloEscucha;
    
    public AsientoView() {
        initComponents();
        
        this.tabRegistrosModelo = (DefaultTableModel) tabRegistros.getModel();
        this.listaSeleccionModelo = tabRegistros.getSelectionModel();
        
        this.listaSeleccionEscucha = new CustomListSelectionListener(butEditarRegistro, butEliminarRegistro);
        this.tablaModeloEscucha = new CustomTableModelListener(texfieDebeTotal, texfieHaberTotal, texfieMonto);
        
        this.listaSeleccionModelo.addListSelectionListener(this.listaSeleccionEscucha);
        this.tabRegistrosModelo.addTableModelListener(this.tablaModeloEscucha);
        
        this.tabRegistros.setSelectionModel(this.listaSeleccionModelo);
        
        
        butEditarRegistro.setEnabled(false);
        butEliminarRegistro.setEnabled(false);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        texfieNombre = new javax.swing.JTextField();
        texfieMonto = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabRegistros = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texareConcepto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        butAnadirRegistro = new javax.swing.JButton();
        texfieDebeTotal = new javax.swing.JTextField();
        texfieHaberTotal = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        butGuardarAsiento = new javax.swing.JButton();
        butEditarRegistro = new javax.swing.JButton();
        butEliminarRegistro = new javax.swing.JButton();
        spiFecha = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Monto:");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Concepto:");

        texfieNombre.setName("nombreField"); // NOI18N

        texfieMonto.setEditable(false);

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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nombre:");
        jLabel5.setName(""); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Fecha:");

        jScrollPane1.setPreferredSize(new java.awt.Dimension(400, 100));

        texareConcepto.setColumns(20);
        texareConcepto.setRows(5);
        texareConcepto.setMinimumSize(new java.awt.Dimension(400, 100));
        jScrollPane1.setViewportView(texareConcepto);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("NUEVO ASIENTO");
        jLabel1.setName(" tituloFormulario"); // NOI18N

        butAnadirRegistro.setText("Añadir Registro");
        butAnadirRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butAnadirRegistroMouseClicked(evt);
            }
        });

        texfieDebeTotal.setEditable(false);

        texfieHaberTotal.setEditable(false);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Total:");

        butGuardarAsiento.setText("Guardar Asiento");
        butGuardarAsiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGuardarAsientoMouseClicked(evt);
            }
        });

        butEditarRegistro.setLabel("Editar Registro");
        butEditarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarRegistroMouseClicked(evt);
            }
        });

        butEliminarRegistro.setLabel("Eliminar Registro");
        butEliminarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEliminarRegistroMouseClicked(evt);
            }
        });

        spiFecha.setModel(new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinnerModel());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(butAnadirRegistro)
                        .addGap(15, 15, 15)
                        .addComponent(butEditarRegistro)
                        .addGap(18, 18, 18)
                        .addComponent(butEliminarRegistro))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel9)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel7)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(spiFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(19, 19, 19)
                                    .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(39, 39, 39))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 684, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(279, 279, 279))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(butGuardarAsiento)
                            .addGap(63, 63, 63)
                            .addComponent(jLabel11)
                            .addGap(26, 26, 26)
                            .addComponent(texfieDebeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(texfieHaberTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(13, 13, 13))))
                .addGap(71, 71, 71))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texfieNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(spiFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(texfieMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(texfieDebeTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(texfieHaberTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(butGuardarAsiento))
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(butAnadirRegistro)
                    .addComponent(butEditarRegistro)
                    .addComponent(butEliminarRegistro))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void butAnadirRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirRegistroMouseClicked
        new RegistroView(listaRegistro, tabRegistrosModelo, 
                "AÑADIR REGISTRO", null).setVisible(true);
    }//GEN-LAST:event_butAnadirRegistroMouseClicked
    private void butGuardarAsientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGuardarAsientoMouseClicked
        try {
            // Generación de excepciones
            texfieNombre.getText().charAt(1);
            texareConcepto.getText().charAt(1);
            
            // Guardado
            Asiento asiento = Asiento.builder()
                    .fecha(LocalDate.parse(spiFecha.getValue().toString()))
                    .nombre(texfieNombre.getText())
                    .concepto(texareConcepto.getText())
                    .build();
            
            listaRegistro.forEach((registro) -> {
                registro.setAsiento(asiento);
            });
            asiento.setRegistros(listaRegistro);
            
            if (!asiento.getRegistros().isEmpty()) {
                AsientoRepo asientoRepo = AsientoRepo.getInstance();
                asientoRepo.save(asiento);
                
                dispose();
            } else {
                mostrarError("Sin Registros", "Este asiento no tiene registros");
            }
        } catch (IndexOutOfBoundsException e) {
            mostrarError("Campos Vacíos", "Uno o varios campos estan vacíos");
        }
    }//GEN-LAST:event_butGuardarAsientoMouseClicked
    
    private void butEditarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarRegistroMouseClicked
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaRegistro = listaSeleccionEscucha.fila;
            
            Registro registroSeleccionado = listaRegistro.get(filaRegistro);
            RegistroView registroVista = new RegistroView(listaRegistro, tabRegistrosModelo, 
                    "EDITAR REGISTRO", filaRegistro);
            registroVista.comboxTipoDoc.setSelectedIndex(registroSeleccionado.getTipoDocumento().getId() - 1);
            registroVista.texfieNoCheque.setText(registroSeleccionado.getComprobante());
            registroVista.texfieReferencia.setText(registroSeleccionado.getReferencia());

            Object cuentaRegistroSeleccionado = registroSeleccionado.getCuenta().getId()+ " | " + registroSeleccionado.getCuenta().getNombre();
            registroVista.comboxCuenta.setSelectedItem(cuentaRegistroSeleccionado);

            if (registroSeleccionado.getDebe() != BigDecimal.ZERO && registroSeleccionado.getHaber() == BigDecimal.ZERO) {
                registroVista.radbutDebito.setSelected(true);
                registroVista.texfieMonto.setText(registroSeleccionado.getDebe().toString());
            } else {
                registroVista.radbutCredito.setSelected(true);
                registroVista.texfieMonto.setText(registroSeleccionado.getHaber().toString());
            }

            registroVista.setVisible(true);
        } else {
            mostrarSeleccionVacia();
        }
    }//GEN-LAST:event_butEditarRegistroMouseClicked

    private void butEliminarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEliminarRegistroMouseClicked
        if (!listaSeleccionModelo.isSelectionEmpty()){
            Integer filaRegistro = listaSeleccionEscucha.fila;
            tabRegistrosModelo.removeRow(filaRegistro);

            listaRegistro.remove(listaRegistro.get(filaRegistro));
        } else {
            mostrarSeleccionVacia();
        }
    }//GEN-LAST:event_butEliminarRegistroMouseClicked
    
    private void mostrarSeleccionVacia() {
        JOptionPane.showMessageDialog(null, "Seleccione un registro en la tabla", 
                    "Selección Vacía", JOptionPane.INFORMATION_MESSAGE
        );
    }
    private void mostrarError(String titulo, String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, 
                    titulo, JOptionPane.ERROR_MESSAGE
        );
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadirRegistro;
    private javax.swing.JButton butEditarRegistro;
    private javax.swing.JButton butEliminarRegistro;
    private javax.swing.JButton butGuardarAsiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner spiFecha;
    public javax.swing.JTable tabRegistros;
    private javax.swing.JTextArea texareConcepto;
    private javax.swing.JTextField texfieDebeTotal;
    private javax.swing.JTextField texfieHaberTotal;
    private javax.swing.JTextField texfieMonto;
    private javax.swing.JTextField texfieNombre;
    // End of variables declaration//GEN-END:variables
}
