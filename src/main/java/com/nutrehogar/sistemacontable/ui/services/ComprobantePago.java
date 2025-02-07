package com.nutrehogar.sistemacontable.ui.services;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ComprobantePago extends JFrame {
    public JTable tabRegistros;
    
    public ComprobantePago() {
        initComponents();
        
        getContentPane().setBackground(Color.WHITE);
        setSize(612, 824);
        setLocationRelativeTo(null);
        setLayout(null);

        // Crear el modelo de la tabRegistros
        DefaultTableModel modelo = new DefaultTableModel(new String[]{
            "Referencia", "Código", "Debe", "Haber"}, 0);

        // Crear la tabRegistros con el modelo
        tabRegistros = new JTable(modelo);
        tabRegistros.setRowHeight(16);
        tabRegistros.setEnabled(false);

        // Colorear lineas de la tabRegistros
        tabRegistros.setShowGrid(true);
        tabRegistros.setGridColor(Color.BLACK);
        
        // Configurar el ancho de las columnas
        tabRegistros.getColumnModel().getColumn(0).setPreferredWidth(130); // Referencia
        tabRegistros.getColumnModel().getColumn(1).setPreferredWidth(50); // Código
        tabRegistros.getColumnModel().getColumn(2).setPreferredWidth(65); // Debe
        tabRegistros.getColumnModel().getColumn(3).setPreferredWidth(65); // Haber
        
        // Crear un renderizador personalizado para el encabezado
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                
                comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                setHorizontalAlignment(SwingConstants.CENTER);
                
                if (column == table.getColumnCount() - 1) {
                    setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
                } else {
                    setBorder(BorderFactory.createMatteBorder(0,0,1,1,Color.BLACK));
                }
                
                return comp;
            }
        };
        // Crear un renderizador personalizado para el contenido
        DefaultTableCellRenderer contentRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Alineación condicional
                switch (column) {
                    case 0:
                        // Alinear "Referencia" a la izquierda
                        setHorizontalAlignment(SwingConstants.LEFT);
                        break;
                    case 1:
                        // Alinear "Código" al centro
                        setHorizontalAlignment(SwingConstants.CENTER);
                        break;
                    default:
                        // Alinear "Debe" y "Haber" a la derecha
                        setHorizontalAlignment(SwingConstants.RIGHT);
                        break;
                }

                // Aplicar negrita a la última fila
                if (row == table.getRowCount() - 1) {
                    comp.setFont(comp.getFont().deriveFont(Font.BOLD));
                }

                return comp;
            }
        };

        // Asignar el renderizador a todas las columnas
        for (int i = 0; i < tabRegistros.getColumnCount(); i++) {
            tabRegistros.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            tabRegistros.getColumnModel().getColumn(i).setCellRenderer(contentRenderer);
        }

        // Agregar la tabRegistros dentro de un JScrollPane
        JScrollPane scrollPane = new JScrollPane(tabRegistros);
        scrollPane.setBounds(260, 350, 300, 250);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        add(scrollPane);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labEncabezado = new JLabel();
        labNoCheque = new JLabel();
        labComprobantePago = new JLabel();
        labFecha = new JLabel();
        texfieNoCheque = new JTextField();
        texfieFecha = new JTextField();
        labMonto = new JLabel();
        texfieMonto = new JTextField();
        labNoDoc = new JLabel();
        texfieNoDoc = new JTextField();
        labLogo = new JLabel();
        labConcepto = new JLabel();
        texfieNombre = new JTextField();
        labFirma = new JLabel();
        labNombre = new JLabel();
        labEntregado = new JLabel();
        labRecibido = new JLabel();
        labNoCedula = new JLabel();
        labLineaNoCedula = new JLabel();
        labLineaFirma = new JLabel();
        labLineaRecibido = new JLabel();
        scrpanConcepto = new JScrollPane();
        texareConcepto = new JTextArea();

        setTitle("ComprobantePago");
        setAutoRequestFocus(false);
        setBackground(new Color(255, 255, 255));
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        setSize(new Dimension(612, 824));
        getContentPane().setLayout(null);

        labEncabezado.setFont(new Font("Bahnschrift", 0, 14)); // NOI18N
        labEncabezado.setHorizontalAlignment(SwingConstants.CENTER);
        labEncabezado.setText("<html> <div style=\"text-align: center;\">     <span style=\"font-size: 12px;\">Asociación Nacional Pro-Nutrición Infantil<br>NUTRE HOGAR BOCAS</span><br>     <span style=\"font-size: 10px;\">RUC: 1424-02-5701      DV: 43</span><br>     <span style=\"font-size: 10px;\">No. Teléfono 758-6506 &nbsp;&nbsp;&nbsp; E-Mail: nutrebocas@gmail.com</span> </div> </html>");
        labEncabezado.setBorder(new javax.swing.border.LineBorder(new Color(0, 0, 0), 1, true));
        getContentPane().add(labEncabezado);
        labEncabezado.setBounds(40, 40, 340, 80);

        labNoCheque.setFont(new Font("Arial Black", 0, 16)); // NOI18N
        labNoCheque.setHorizontalAlignment(SwingConstants.CENTER);
        labNoCheque.setText("<html>No.<br>Cheque:</html>");
        getContentPane().add(labNoCheque);
        labNoCheque.setBounds(410, 50, 70, 40);

        labComprobantePago.setFont(new Font("Arial", 1, 20)); // NOI18N
        labComprobantePago.setText("COMPROBANTE DE PAGO");
        getContentPane().add(labComprobantePago);
        labComprobantePago.setBounds(40, 160, 260, 20);

        labFecha.setFont(new Font("Arial", 1, 14)); // NOI18N
        labFecha.setText("Fecha:");
        getContentPane().add(labFecha);
        labFecha.setBounds(420, 100, 55, 17);

        texfieNoCheque.setEditable(false);
        texfieNoCheque.setBackground(new Color(255, 255, 255));
        texfieNoCheque.setFont(new Font("Arial", 1, 16)); // NOI18N
        texfieNoCheque.setHorizontalAlignment(JTextField.CENTER);
        texfieNoCheque.setText("0");
        texfieNoCheque.setActionCommand("<Not Set>");
        texfieNoCheque.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY)
        );
        texfieNoCheque.setMaximumSize(new Dimension(64, 23));
        getContentPane().add(texfieNoCheque);
        texfieNoCheque.setBounds(490, 70, 80, 20);

        texfieFecha.setEditable(false);
        texfieFecha.setBackground(new Color(255, 255, 255));
        texfieFecha.setFont(new Font("Arial", 0, 12)); // NOI18N
        texfieFecha.setHorizontalAlignment(JTextField.CENTER);
        texfieFecha.setText("2024-01-01");
        texfieFecha.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY)
        );
        texfieFecha.setMaximumSize(new Dimension(77, 20));
        texfieFecha.setMinimumSize(new Dimension(77, 20));
        getContentPane().add(texfieFecha);
        texfieFecha.setBounds(490, 100, 80, 20);

        labMonto.setFont(new Font("Arial", 1, 14)); // NOI18N
        labMonto.setText("Monto:");
        getContentPane().add(labMonto);
        labMonto.setBounds(420, 130, 53, 17);

        texfieMonto.setEditable(false);
        texfieMonto.setBackground(new Color(255, 255, 255));
        texfieMonto.setFont(new Font("Arial", 0, 14)); // NOI18N
        texfieMonto.setHorizontalAlignment(JTextField.CENTER);
        texfieMonto.setText("0.00");
        texfieMonto.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY)
        );
        texfieMonto.setMaximumSize(new Dimension(64, 23));
        getContentPane().add(texfieMonto);
        texfieMonto.setBounds(490, 130, 80, 21);

        labNoDoc.setFont(new Font("Arial", 1, 16)); // NOI18N
        labNoDoc.setText("No. Doc.");
        getContentPane().add(labNoDoc);
        labNoDoc.setBounds(420, 160, 65, 28);

        texfieNoDoc.setEditable(false);
        texfieNoDoc.setBackground(new Color(255, 255, 255));
        texfieNoDoc.setFont(new Font("Arial", 0, 18)); // NOI18N
        texfieNoDoc.setHorizontalAlignment(JTextField.CENTER);
        texfieNoDoc.setText("000");
        texfieNoDoc.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY)
        );
        texfieNoDoc.setMaximumSize(new Dimension(64, 28));
        getContentPane().add(texfieNoDoc);
        texfieNoDoc.setBounds(490, 160, 80, 26);

        labLogo.setIcon(new ImageIcon(getClass().getResource("/icons/nutrehogar_icono.png"))); // NOI18N
        getContentPane().add(labLogo);
        labLogo.setBounds(310, 130, 75, 75);

        labConcepto.setFont(new Font("Arial", 1, 16)); // NOI18N
        labConcepto.setText("Concepto:");
        getContentPane().add(labConcepto);
        labConcepto.setBounds(50, 270, 80, 20);

        texfieNombre.setFont(new Font("Arial", 0, 14)); // NOI18N
        texfieNombre.setHorizontalAlignment(JTextField.LEFT);
        texfieNombre.setText("0");
        texfieNombre.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY)
        );
        texfieNombre.setName("texfieNombre"); // NOI18N
        getContentPane().add(texfieNombre);
        texfieNombre.setBounds(140, 220, 350, 21);

        labFirma.setFont(new Font("Arial", 0, 12)); // NOI18N
        labFirma.setText("Firma del personal que entrega:");
        getContentPane().add(labFirma);
        labFirma.setBounds(50, 420, 190, 20);

        labNombre.setFont(new Font("Arial", 1, 16)); // NOI18N
        labNombre.setText("Nombre:");
        getContentPane().add(labNombre);
        labNombre.setBounds(50, 220, 68, 20);

        labEntregado.setFont(new Font("Arial", 1, 12)); // NOI18N
        labEntregado.setText("Entregado por:");
        getContentPane().add(labEntregado);
        labEntregado.setBounds(90, 350, 90, 20);

        labRecibido.setFont(new Font("Arial", 1, 12)); // NOI18N
        labRecibido.setText("Recibido por:");
        getContentPane().add(labRecibido);
        labRecibido.setBounds(90, 500, 80, 20);

        labNoCedula.setFont(new Font("Arial", 1, 12)); // NOI18N
        labNoCedula.setText("No. De Cédula:");
        getContentPane().add(labNoCedula);
        labNoCedula.setBounds(90, 570, 90, 20);

        labLineaNoCedula.setText("______________________________");
        getContentPane().add(labLineaNoCedula);
        labLineaNoCedula.setBounds(50, 550, 200, 15);

        labLineaFirma.setText("______________________________");
        getContentPane().add(labLineaFirma);
        labLineaFirma.setBounds(50, 400, 200, 15);

        labLineaRecibido.setText("______________________________");
        getContentPane().add(labLineaRecibido);
        labLineaRecibido.setBounds(50, 480, 200, 15);

        scrpanConcepto.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.GRAY));

        texareConcepto.setColumns(20);
        texareConcepto.setFont(new Font("Arial", 0, 12)); // NOI18N
        texareConcepto.setLineWrap(true);
        texareConcepto.setRows(4);
        texareConcepto.setWrapStyleWord(true);
        texareConcepto.setMaximumSize(new Dimension(232, 32));
        scrpanConcepto.setViewportView(texareConcepto);

        getContentPane().add(scrpanConcepto);
        scrpanConcepto.setBounds(140, 250, 350, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JLabel labComprobantePago;
    private JLabel labConcepto;
    private JLabel labEncabezado;
    private JLabel labEntregado;
    private JLabel labFecha;
    private JLabel labFirma;
    private JLabel labLineaFirma;
    private JLabel labLineaNoCedula;
    private JLabel labLineaRecibido;
    private JLabel labLogo;
    private JLabel labMonto;
    private JLabel labNoCedula;
    private JLabel labNoCheque;
    private JLabel labNoDoc;
    private JLabel labNombre;
    private JLabel labRecibido;
    private JScrollPane scrpanConcepto;
    public JTextArea texareConcepto;
    public JTextField texfieFecha;
    public JTextField texfieMonto;
    public JTextField texfieNoCheque;
    public JTextField texfieNoDoc;
    public JTextField texfieNombre;
    // End of variables declaration//GEN-END:variables
}