package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.application.service.PDFService;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.repository.AsientoRepo;
import com.nutrehogar.sistemacontable.ui.styles.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FormularioPestana extends javax.swing.JPanel {
    List<Registro> listaRegistro = new ArrayList<>();
    DefaultTableModel tabRegistrosModelo;
    ListSelectionModel listaSeleccionModelo;
    
    public FormularioPestana() {
        metodoConstructor();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labFormulario = new javax.swing.JLabel();
        labNombre = new javax.swing.JLabel();
        texfieNombre = new javax.swing.JTextField();
        labConcepto = new javax.swing.JLabel();
        scrpanConcepto = new javax.swing.JScrollPane();
        texareConcepto = new javax.swing.JTextArea();
        labNoCheque = new javax.swing.JLabel();
        texfieNoCheque = new javax.swing.JTextField();
        labFecha = new javax.swing.JLabel();
        spiFecha = new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner();
        labMonto = new javax.swing.JLabel();
        texfieMonto = new javax.swing.JTextField();
        labNoDoc = new javax.swing.JLabel();
        texfieNoDoc = new javax.swing.JTextField();
        scrpanRegistros = new javax.swing.JScrollPane();
        tabRegistros = new javax.swing.JTable();
        labDiferencia = new javax.swing.JLabel();
        texfieDiferencia = new javax.swing.JTextField();
        labTotal = new javax.swing.JLabel();
        texfieDebe = new javax.swing.JTextField();
        texfieHaber = new javax.swing.JTextField();
        panAcciones = new javax.swing.JPanel();
        butAnadirRegistro = new javax.swing.JButton();
        butEditarRegistro = new javax.swing.JButton();
        butEliminarRegistro = new javax.swing.JButton();
        butGuardarAsiento = new javax.swing.JButton();
        butExportarFormulario = new javax.swing.JButton();
        butExportarComprobante = new javax.swing.JButton();
        butLimpiarFormulario = new javax.swing.JButton();

        setBackground(new java.awt.Color(241, 248, 255));

        labFormulario.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        labFormulario.setText("Formulario");
        labFormulario.setName(" tituloFormulario"); // NOI18N

        labNombre.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNombre.setText("Nombre:");
        labNombre.setName(""); // NOI18N

        texfieNombre.setName("nombreField"); // NOI18N

        labConcepto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labConcepto.setText("Concepto:");

        scrpanConcepto.setPreferredSize(new java.awt.Dimension(400, 100));

        texareConcepto.setColumns(20);
        texareConcepto.setRows(5);
        texareConcepto.setMinimumSize(new java.awt.Dimension(400, 100));
        scrpanConcepto.setViewportView(texareConcepto);

        labNoCheque.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNoCheque.setText("<html>No.<br>Cheque:</html>");

        labFecha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labFecha.setText("Fecha:");

        spiFecha.setModel(new com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinnerModel());

        labMonto.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labMonto.setText("Monto:");

        texfieMonto.setEditable(false);
        texfieMonto.setBackground(new java.awt.Color(255, 255, 255));

        labNoDoc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labNoDoc.setText("No. Doc.");

        texfieNoDoc.setEditable(false);
        texfieNoDoc.setBackground(new java.awt.Color(255, 255, 255));

        tabRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tipo de Doc.", "No. Comp.", "Referencia", "Código", "Debe", "Haber"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabRegistros.setAutoscrolls(false);
        scrpanRegistros.setViewportView(tabRegistros);

        labDiferencia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labDiferencia.setText("Diferencia:");

        texfieDiferencia.setEditable(false);
        texfieDiferencia.setBackground(new java.awt.Color(255, 255, 255));

        labTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labTotal.setText("Total:");

        texfieDebe.setEditable(false);
        texfieDebe.setBackground(new java.awt.Color(255, 255, 255));

        texfieHaber.setEditable(false);
        texfieHaber.setBackground(new java.awt.Color(255, 255, 255));

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
        butEditarRegistro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/editar.png"))); // NOI18N
        butEditarRegistro.setEnabled(false);
        butEditarRegistro.setLabel("Editar Registro");
        butEditarRegistro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butEditarRegistroMouseClicked(evt);
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

        butGuardarAsiento.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butGuardarAsiento.setForeground(new java.awt.Color(255, 255, 255));
        butGuardarAsiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/guardar.png"))); // NOI18N
        butGuardarAsiento.setText("Guardar Asiento");
        butGuardarAsiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butGuardarAsientoMouseClicked(evt);
            }
        });

        butExportarFormulario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butExportarFormulario.setForeground(new java.awt.Color(255, 255, 255));
        butExportarFormulario.setText("Exportar Formulario");
        butExportarFormulario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butExportarFormularioMouseClicked(evt);
            }
        });

        butExportarComprobante.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butExportarComprobante.setForeground(new java.awt.Color(255, 255, 255));
        butExportarComprobante.setText("Exportar Comprobante");
        butExportarComprobante.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butExportarComprobanteMouseClicked(evt);
            }
        });

        butLimpiarFormulario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        butLimpiarFormulario.setForeground(new java.awt.Color(255, 255, 255));
        butLimpiarFormulario.setText("Limpiar Formulario");
        butLimpiarFormulario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                butLimpiarFormularioMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panAccionesLayout = new javax.swing.GroupLayout(panAcciones);
        panAcciones.setLayout(panAccionesLayout);
        panAccionesLayout.setHorizontalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAccionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(butAnadirRegistro)
                    .addComponent(butEliminarRegistro)
                    .addComponent(butEditarRegistro)
                    .addComponent(butGuardarAsiento)
                    .addComponent(butExportarFormulario)
                    .addComponent(butExportarComprobante)
                    .addComponent(butLimpiarFormulario))
                .addGap(12, 12, 12))
        );
        panAccionesLayout.setVerticalGroup(
            panAccionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAccionesLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(butAnadirRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(butEditarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(butEliminarRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(butGuardarAsiento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(butExportarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(butExportarComprobante, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(butLimpiarFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );

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
                        .addGap(20, 20, 20)
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
                                .addGap(27, 27, 27)
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labFormulario)
                .addGap(20, 20, 20)
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
                        .addComponent(labTotal)))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addComponent(panAcciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    // metodo para generar contenido del frame
    private void metodoConstructor() {
        initComponents();
        
        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabRegistros.clearSelection();
            }
        });
        
        tabRegistrosModelo = (DefaultTableModel) tabRegistros.getModel();
        listaSeleccionModelo = tabRegistros.getSelectionModel();
        
        tabRegistrosModelo.addTableModelListener(this::tablaModeloEscuchador);
        listaSeleccionModelo.addListSelectionListener(this::listaSeleccionEscuchador);
        
        listaSeleccionModelo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        Integer noDoc = AsientoRepo.findAll().size() + 1;
        texfieNoDoc.setText(new DecimalFormat("000").format(noDoc));
        
        estilizarComponentes();     
    }
    
    // Estilo de los componentes
    private void estilizarComponentes() {
        new TableStyle(tabRegistros); // Tabla
        
        // Columnas especificas
        tabRegistros.getColumnModel().getColumn(3).setMaxWidth(80);
        ((DefaultTableCellRenderer) tabRegistros.getColumnModel().getColumn(1).getCellRenderer())
                .setHorizontalAlignment(SwingConstants.LEFT);
        ((DefaultTableCellRenderer) tabRegistros.getColumnModel().getColumn(2).getCellRenderer())
                .setHorizontalAlignment(SwingConstants.LEFT);
        
        new ButtonStyle(butAnadirRegistro, butEditarRegistro, 
                butEliminarRegistro, butGuardarAsiento,
                butExportarFormulario, butExportarComprobante,
                butLimpiarFormulario
        ); // Botones
    }
    
    // Escuchadores de la tabla
    private void listaSeleccionEscuchador(ListSelectionEvent e) {
        if (tabRegistros.getSelectedRow() != -1) {
            butEditarRegistro.setEnabled(true);
            butEliminarRegistro.setEnabled(true);
        } else {
            butEditarRegistro.setEnabled(false);
            butEliminarRegistro.setEnabled(false);
        }
    }
    private void tablaModeloEscuchador(TableModelEvent e) {
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
    
    // Escuchadores de los botones
    private void butAnadirRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butAnadirRegistroMouseClicked
        RegistroVentana rv = new RegistroVentana(listaRegistro, tabRegistrosModelo, 
                "Añadir Registro", null);
        rv.setLocationRelativeTo(this);
        rv.setVisible(true);
    }//GEN-LAST:event_butAnadirRegistroMouseClicked
    
    private void butEditarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEditarRegistroMouseClicked
        if (!listaSeleccionModelo.isSelectionEmpty()) {
            Integer filaRegistro = tabRegistros.getSelectedRow();
            RegistroVentana rv = new RegistroVentana(listaRegistro, tabRegistrosModelo,
                    "Editar Registro", filaRegistro);
            rv.setLocationRelativeTo(this);
            rv.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en la tabla");
        }
    }//GEN-LAST:event_butEditarRegistroMouseClicked

    private void butEliminarRegistroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butEliminarRegistroMouseClicked
        if (!listaSeleccionModelo.isSelectionEmpty()){
            Integer filaRegistro = tabRegistros.getSelectedRow();
            Integer confirmar = JOptionPane.showConfirmDialog(
                this, "¿Está seguro de que desea eliminar este registro?",
                "Confirmar eliminación", JOptionPane.YES_NO_OPTION
            );
            
            if (confirmar == JOptionPane.YES_OPTION) {
                tabRegistrosModelo.removeRow(filaRegistro);
                listaRegistro.remove(listaRegistro.get(filaRegistro));
                JOptionPane.showMessageDialog(this, "Registro eliminado exitosamente.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione un registro en la tabla");
        }
    }//GEN-LAST:event_butEliminarRegistroMouseClicked

    private void butGuardarAsientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butGuardarAsientoMouseClicked
        if (validarDatos()) {
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
            
            AsientoRepo.save(asiento);   
            JOptionPane.showMessageDialog(this, "Asiento guardado exitosamente.");
        }
    }//GEN-LAST:event_butGuardarAsientoMouseClicked
    
    // Validador de datos
    private Boolean validarDatos() {
        if (texfieNombre.getText().isBlank() || texareConcepto.getText().isBlank()) {
            JOptionPane.showMessageDialog(this, "Uno o varios campos estan vacíos");
            return false;
        }
        
        if (!texfieDebe.getText().equals(texfieHaber.getText())) {
            JOptionPane.showMessageDialog(this, "El asiento no está balanceado");
            return false;
        }
        
        if (listaRegistro.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Este asiento no tiene registros");
            return false;
        }
        
        return true;
    }
    
    // Escuchadores para generar PDFs
    private void butExportarFormularioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butExportarFormularioMouseClicked
        PDFService pdf = new PDFService();
        prepararPDF(pdf);
        pdf.exportarFormulario();
    }//GEN-LAST:event_butExportarFormularioMouseClicked

    private void butExportarComprobanteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butExportarComprobanteMouseClicked
        PDFService pdf = new PDFService();
        prepararPDF(pdf);
        pdf.exportarComprobante();
    }//GEN-LAST:event_butExportarComprobanteMouseClicked
    
    // Obtencion de datos para el pdf
    private void prepararPDF(PDFService pdf) {
        pdf.noCheque = texfieNoCheque.getText();
        pdf.fecha = spiFecha.getValue().toString();
        pdf.monto = texfieMonto.getText();
        pdf.noDoc = texfieNoDoc.getText();
        pdf.nombre = texfieNombre.getText();
        pdf.concepto = texareConcepto.getText();
        pdf.debe = texfieDebe.getText();
        pdf.haber = texfieHaber.getText();
        pdf.registros = tabRegistrosModelo;
    }
    
    // Escuchador para limpiar  el formulario
    private void butLimpiarFormularioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_butLimpiarFormularioMouseClicked
        Integer confirmar = JOptionPane.showConfirmDialog(
            this, "¿Está seguro de que desea vaciar todos los campos?",
            "Limpiar formulario", JOptionPane.YES_NO_OPTION
        );
            
        if (confirmar == JOptionPane.YES_OPTION) {
            removeAll();
            metodoConstructor();
        }
    }//GEN-LAST:event_butLimpiarFormularioMouseClicked
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton butAnadirRegistro;
    private javax.swing.JButton butEditarRegistro;
    private javax.swing.JButton butEliminarRegistro;
    private javax.swing.JButton butExportarComprobante;
    private javax.swing.JButton butExportarFormulario;
    private javax.swing.JButton butGuardarAsiento;
    private javax.swing.JButton butLimpiarFormulario;
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
