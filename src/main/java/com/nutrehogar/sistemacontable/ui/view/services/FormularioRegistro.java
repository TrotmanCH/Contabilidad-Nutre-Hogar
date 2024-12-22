package com.nutrehogar.sistemacontable.ui.view.services;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class FormularioRegistro extends javax.swing.JFrame {
    private JTable tabla;
    
    public void setLabelsText(String cheque, String fecha, String noDoc, String nombre, String concepto, String sumaHaber) {
        texfieNoCheque.setText(cheque);
        texfieFecha.setText(fecha);
        texfieNoDoc.setText(noDoc);
        texfieNombre.setText(nombre);
        texareConcepto.setText(concepto);
        texfieMonto.setText(sumaHaber);
    }

    public void exportarPantallaAPDF() {
        try {
            // Obtener el tamaño de la interfaz (sin bordes)
            Dimension dimension = getSize();
            
            BufferedImage imagen = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = imagen.createGraphics();

            // Cambiar el color de fondo (si es necesario)
            g2d.setColor(getBackground());
            g2d.fillRect(0, 0, dimension.width, dimension.height);

            // Pintar la interfaz en el BufferedImage
            paint(g2d);
            g2d.dispose();

            // Guardar la imagen temporalmente en el sistema de archivos
            ImageIO.write(imagen, "png", new java.io.File("captura.png"));
            setVisible(false);

            // Usar JFileChooser para seleccionar ubicación
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como PDF");

            // Crear un formato de fecha para el nombre del archivo
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); // Formato de fecha (AñoMesDía)
            String fechaFormateada = sdf.format(new Date());

            //Configurar el nombre del archivo con la palabra "comprobante" y la fecha
            fileChooser.setSelectedFile(new java.io.File("formulario_" + fechaFormateada + ".pdf"));

            int userSelection = fileChooser.showSaveDialog(this);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();

                // Verificar si el archivo ya existe y mostrar advertencia
                if (fileToSave.exists()) {
                    int response = JOptionPane.showConfirmDialog(this, 
                            "El archivo ya existe. ¿Deseas reemplazarlo?", 
                            "Confirmar Sobrescritura", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);

                    if (response != JOptionPane.YES_OPTION) {
                        return; // Salir del método sin guardar
                    }
                }

                // Crear el documento PDF con tamaño Letter (8.5"x11")
                Document documento = new Document(PageSize.LETTER);
                PdfWriter.getInstance(documento, new FileOutputStream(fileToSave));
                documento.open();

                // Añadir la imagen al documento PDF y posicionarla en la parte superior
                Image imagenPDF = Image.getInstance("captura.png");
                imagenPDF.scaleToFit(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                imagenPDF.setAbsolutePosition(0, 32); // Posicionar en la parte superior omitiendo las opciones de ventana
                documento.add(imagenPDF);

                // Cerrar el documento
                documento.close();

                JOptionPane.showMessageDialog(this, "PDF guardado exitosamente en " + fileToSave.getAbsolutePath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al guardar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    };
    
    
    public DefaultTableModel getTablaModel() {
        return (DefaultTableModel) tabla.getModel();
    }
    
    public FormularioRegistro() {
        initComponents();
        getContentPane().setBackground(Color.WHITE);
        setSize(612, 824);
        setLocationRelativeTo(null); // Centrar en pantalla
        setLayout(null);

        // Crear el modelo de la tabla original sin filas iniciales
        DefaultTableModel modelo = new DefaultTableModel(new String[]{
                "Tipo de Doc.", "No. Cheque o Comp.", "Referencia",
                "Código", "Debe", "Haber"}, 0);

        // Crear la tabla original con el modelo
        tabla = new JTable(modelo);
        tabla.setRowHeight(16); // Ajustar la altura de las filas
        tabla.setEnabled(false); // Deshabilitar edición si es necesario
        
        // Colorear lineas de la tabla
        tabla.setShowGrid(true);
        tabla.setGridColor(Color.BLACK);

        // Configurar el ancho de las columnas de la tabla original
        tabla.getColumnModel().getColumn(0).setPreferredWidth(60); // Tipo de doc
        tabla.getColumnModel().getColumn(1).setPreferredWidth(92); // Comp
        tabla.getColumnModel().getColumn(2).setPreferredWidth(130); // Referencia
        tabla.getColumnModel().getColumn(3).setPreferredWidth(50);  // Código
        tabla.getColumnModel().getColumn(4).setPreferredWidth(50);  // Debe
        tabla.getColumnModel().getColumn(5).setPreferredWidth(50);  // Haber

        // Crear un renderizador personalizado para el contenido
        DefaultTableCellRenderer contentRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Alineación condicional
                switch (column) {
                    case 2:
                        // Alinear la última celda de la columna "Referencia" a la derecha
                        setHorizontalAlignment(row == table.getRowCount() - 1 ? SwingConstants.RIGHT : SwingConstants.LEFT);
                        break;
                    case 3:
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
                } else {
                    comp.setFont(comp.getFont().deriveFont(Font.PLAIN));
                }

                return comp;
            }
        };
        
        // Crear un renderizador personalizado para el encabezado
        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setHorizontalAlignment(SwingConstants.CENTER);
                if (column == table.getColumnCount() - 1) {
                    setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
                } else {
                    setBorder(BorderFactory.createMatteBorder(0,0,1,1,Color.BLACK));
                }

                return comp;
            }
        };
    
        // Asignar el renderizador a todas las columnas
        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(contentRenderer);
            tabla.getTableHeader().getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }

        // Crear un JScrollPane para la tabla original
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(40, 350, 532, 250); // Ajustar posición y tamaño
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        // Agregar el JScrollPane al JFrame
        add(scrollPane);
    }  
    
    public DefaultTableModel getTableModel() {
        return (DefaultTableModel) tabla.getModel(); 
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labEncabezado = new javax.swing.JLabel();
        labLogo = new javax.swing.JLabel();
        labNoCheque = new javax.swing.JLabel();
        texfieNoCheque = new javax.swing.JTextField();
        labFecha = new javax.swing.JLabel();
        texfieFecha = new javax.swing.JTextField();
        labMonto = new javax.swing.JLabel();
        texfieMonto = new javax.swing.JTextField();
        labNoDoc = new javax.swing.JLabel();
        texfieNoDoc = new javax.swing.JTextField();
        labFormularioRegistro = new javax.swing.JLabel();
        labNombre = new javax.swing.JLabel();
        texfieNombre = new javax.swing.JTextField();
        labConcepto = new javax.swing.JLabel();
        scrpanConcepto = new javax.swing.JScrollPane();
        texareConcepto = new javax.swing.JTextArea();
        labLineaAprobado = new javax.swing.JLabel();
        labAprobado = new javax.swing.JLabel();
        labLineaSolicitado = new javax.swing.JLabel();
        labSolicitado = new javax.swing.JLabel();
        labRevisado = new javax.swing.JLabel();
        labLineaRevisado = new javax.swing.JLabel();
        labAutorizado = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setSize(new java.awt.Dimension(612, 824));
        getContentPane().setLayout(null);

        labEncabezado.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        labEncabezado.setText("<html> <div style=\"text-align: center;\">     <span style=\"font-size: 12px;\">Asociación Nacional Pro-Nutrición Infantil<br>NUTRE HOGAR BOCAS</span><br>     <span style=\"font-size: 10px;\">RUC: 1424-02-5701      DV: 43</span><br>     <span style=\"font-size: 10px;\">No. Teléfono 758-6506 &nbsp;&nbsp;&nbsp; E-Mail: nutrebocas@gmail.com</span> </div> </html>");
        labEncabezado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(labEncabezado);
        labEncabezado.setBounds(40, 40, 340, 80);

        labLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo_small.png"))); // NOI18N
        getContentPane().add(labLogo);
        labLogo.setBounds(330, 130, 75, 75);

        labNoCheque.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        labNoCheque.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labNoCheque.setText("<html>No.<br>Cheque</html>");
        getContentPane().add(labNoCheque);
        labNoCheque.setBounds(410, 50, 70, 40);

        texfieNoCheque.setEditable(false);
        texfieNoCheque.setBackground(new java.awt.Color(255, 255, 255));
        texfieNoCheque.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        texfieNoCheque.setText("0");
        texfieNoCheque.setActionCommand("<Not Set>");
        texfieNoCheque.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        texfieNoCheque.setMaximumSize(new java.awt.Dimension(64, 23));
        getContentPane().add(texfieNoCheque);
        texfieNoCheque.setBounds(490, 70, 80, 20);

        labFecha.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labFecha.setText("Fecha:");
        getContentPane().add(labFecha);
        labFecha.setBounds(420, 100, 55, 17);

        texfieFecha.setEditable(false);
        texfieFecha.setBackground(new java.awt.Color(255, 255, 255));
        texfieFecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        texfieFecha.setText("2024-01-01");
        texfieFecha.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        texfieFecha.setMaximumSize(new java.awt.Dimension(77, 20));
        texfieFecha.setMinimumSize(new java.awt.Dimension(77, 20));
        getContentPane().add(texfieFecha);
        texfieFecha.setBounds(490, 100, 80, 20);

        labMonto.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labMonto.setText("Monto:");
        getContentPane().add(labMonto);
        labMonto.setBounds(420, 130, 53, 17);

        texfieMonto.setEditable(false);
        texfieMonto.setBackground(new java.awt.Color(255, 255, 255));
        texfieMonto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        texfieMonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        texfieMonto.setText("0.00");
        texfieMonto.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        texfieMonto.setMaximumSize(new java.awt.Dimension(64, 23));
        getContentPane().add(texfieMonto);
        texfieMonto.setBounds(490, 130, 80, 21);

        labNoDoc.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        labNoDoc.setText("No. Doc.");
        getContentPane().add(labNoDoc);
        labNoDoc.setBounds(420, 160, 65, 28);

        texfieNoDoc.setEditable(false);
        texfieNoDoc.setBackground(new java.awt.Color(255, 255, 255));
        texfieNoDoc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        texfieNoDoc.setText("000");
        texfieNoDoc.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        texfieNoDoc.setMaximumSize(new java.awt.Dimension(64, 28));
        getContentPane().add(texfieNoDoc);
        texfieNoDoc.setBounds(490, 160, 80, 26);

        labFormularioRegistro.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        labFormularioRegistro.setText("FORMULARIO DE REGISTRO");
        getContentPane().add(labFormularioRegistro);
        labFormularioRegistro.setBounds(40, 160, 280, 20);

        labNombre.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        labNombre.setText("Nombre:");
        getContentPane().add(labNombre);
        labNombre.setBounds(50, 220, 68, 20);

        texfieNombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        texfieNombre.setText("0");
        texfieNombre.setBorder(BorderFactory.createMatteBorder(0,0,1,0, Color.GRAY));
        texfieNombre.setName("texfieNombre"); // NOI18N
        getContentPane().add(texfieNombre);
        texfieNombre.setBounds(140, 220, 350, 21);

        labConcepto.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        labConcepto.setText("Concepto:");
        getContentPane().add(labConcepto);
        labConcepto.setBounds(50, 270, 90, 20);

        scrpanConcepto.setBorder(BorderFactory.createMatteBorder(1,1,1,1, Color.GRAY));

        texareConcepto.setColumns(20);
        texareConcepto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        texareConcepto.setLineWrap(true);
        texareConcepto.setRows(4);
        texareConcepto.setWrapStyleWord(true);
        texareConcepto.setMaximumSize(new java.awt.Dimension(232, 32));
        texareConcepto.setPreferredSize(new java.awt.Dimension(232, 32));
        scrpanConcepto.setViewportView(texareConcepto);

        getContentPane().add(scrpanConcepto);
        scrpanConcepto.setBounds(140, 250, 350, 70);

        labLineaAprobado.setText("______________________________");
        getContentPane().add(labLineaAprobado);
        labLineaAprobado.setBounds(390, 740, 200, 15);

        labAprobado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labAprobado.setText("Aprobado por:");
        getContentPane().add(labAprobado);
        labAprobado.setBounds(430, 760, 80, 20);

        labLineaSolicitado.setText("______________________________");
        getContentPane().add(labLineaSolicitado);
        labLineaSolicitado.setBounds(230, 650, 190, 15);

        labSolicitado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labSolicitado.setText("Solicitado por: Licdo. Julio C. Guerra");
        getContentPane().add(labSolicitado);
        labSolicitado.setBounds(220, 670, 190, 20);

        labRevisado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        labRevisado.setText("Revisado por:");
        getContentPane().add(labRevisado);
        labRevisado.setBounds(110, 760, 70, 20);

        labLineaRevisado.setText("______________________________");
        getContentPane().add(labLineaRevisado);
        labLineaRevisado.setBounds(70, 740, 200, 15);

        labAutorizado.setFont(new java.awt.Font("Bahnschrift", 1, 16)); // NOI18N
        labAutorizado.setText("Autorizado:");
        getContentPane().add(labAutorizado);
        labAutorizado.setBounds(260, 710, 90, 20);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel labAprobado;
    private javax.swing.JLabel labAutorizado;
    private javax.swing.JLabel labConcepto;
    private javax.swing.JLabel labEncabezado;
    private javax.swing.JLabel labFecha;
    private javax.swing.JLabel labFormularioRegistro;
    private javax.swing.JLabel labLineaAprobado;
    private javax.swing.JLabel labLineaRevisado;
    private javax.swing.JLabel labLineaSolicitado;
    private javax.swing.JLabel labLogo;
    private javax.swing.JLabel labMonto;
    private javax.swing.JLabel labNoCheque;
    private javax.swing.JLabel labNoDoc;
    private javax.swing.JLabel labNombre;
    private javax.swing.JLabel labRevisado;
    private javax.swing.JLabel labSolicitado;
    private javax.swing.JScrollPane scrpanConcepto;
    private javax.swing.JTextArea texareConcepto;
    private javax.swing.JTextField texfieFecha;
    private javax.swing.JTextField texfieMonto;
    private javax.swing.JTextField texfieNoCheque;
    private javax.swing.JTextField texfieNoDoc;
    private javax.swing.JTextField texfieNombre;
    // End of variables declaration//GEN-END:variables
}