package com.nutrehogar.sistemacontable.ui.view;

import java.awt.Color;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class PlantillaC extends javax.swing.JFrame {
    private JTable tabla;
    public void setLabelsText(String cheque, String fecha, String noDoc, String nombre, String concepto, String sumaHaber) {
    lab_ncheque.setText(cheque);
    lab_nfecha.setText(fecha);
    lab_ndoc.setText(noDoc);
    lab_nnombre.setText(nombre);
    lab_nconcepto.setText(concepto);
    lab_nmonto.setText(sumaHaber);
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
        fileChooser.setSelectedFile(new java.io.File("comprobante_" + fechaFormateada + ".pdf"));
        
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
            imagenPDF.setAbsolutePosition(0, PageSize.LETTER.getHeight() - imagenPDF.getScaledHeight()); // Posicionar en la parte superior
            documento.add(imagenPDF);

            // Cerrar el documento
            documento.close();

            JOptionPane.showMessageDialog(this, "PDF guardado exitosamente en " + fileToSave.getAbsolutePath());
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar el PDF: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
}
    
    public DefaultTableModel getTableModel() {
    return (DefaultTableModel) tabla.getModel(); 
}
    
    public PlantillaC() {
    initComponents();
    getContentPane().setBackground(Color.WHITE);
    setSize(612, 792);
    setLocationRelativeTo(null); // Centrar en pantalla
    setLayout(null);

    // Crear el modelo de la tabla
    DefaultTableModel modelo = new DefaultTableModel(new String[]{"Referencia", "Código", "Debe", "Haber"}, 0);

    // Crear la tabla con el modelo
    tabla = new JTable(modelo);
    tabla.setRowHeight(16); // Ajustar la altura de las filas
    tabla.setEnabled(false); // Deshabilitar edición si es necesario

    // Configurar el ancho de las columnas
    tabla.getColumnModel().getColumn(0).setPreferredWidth(130); // Referencia
    tabla.getColumnModel().getColumn(1).setPreferredWidth(50); // Código
    tabla.getColumnModel().getColumn(2).setPreferredWidth(65); // Debe
    tabla.getColumnModel().getColumn(3).setPreferredWidth(65); // Haber

    // Crear un renderizador personalizado para combinar alineación y formato
    DefaultTableCellRenderer customRenderer = new DefaultTableCellRenderer() {
        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

            // Alineación condicional
            switch (column) {
                case 0:
                    // Alinear la última celda de la columna "Referencia" a la derecha
                    setHorizontalAlignment(row == table.getRowCount() - 1 ? SwingConstants.RIGHT : SwingConstants.LEFT);
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
            } else {
                comp.setFont(comp.getFont().deriveFont(Font.PLAIN));
            }

            return comp;
        }
    };

    // Asignar el renderizador a todas las columnas
    for (int i = 0; i < tabla.getColumnCount(); i++) {
        tabla.getColumnModel().getColumn(i).setCellRenderer(customRenderer);
    }

    // Agregar la tabla dentro de un JScrollPane
    JScrollPane scrollPane = new JScrollPane(tabla);
    scrollPane.setBounds(260, 215, 299, 326); // Coordenadas y tamaño
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);

    // Agregar el JScrollPane al JFrame
    add(scrollPane);
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lab_ncheque = new javax.swing.JTextField();
        lab_nfecha = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lab_nmonto = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        lab_ndoc = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lab_nnombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lab_nconcepto = new javax.swing.JTextArea();

        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("<html> <div style=\"text-align: center;\">     <span style=\"font-size: 12px;\">Asociación Nacional Pro-Nutrición Infantil<br>NUTRE HOGAR BOCAS</span><br>     <span style=\"font-size: 10px;\">RUC: 1424-02-5701      DV: 43</span><br>     <span style=\"font-size: 10px;\">No. Teléfono 758-6506 &nbsp;&nbsp;&nbsp; E-Mail: nutrebocas@gmail.com</span> </div> </html>");
        jLabel5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        getContentPane().add(jLabel5);
        jLabel5.setBounds(4, 4, 340, 80);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 16)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("<html>No.<br>Cheque</html>");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(450, 20, 76, 52);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel7.setText("COMPROBANTE DE PAGO");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(57, 88, 260, 26);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Fecha:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(410, 80, 55, 17);

        lab_ncheque.setEditable(false);
        lab_ncheque.setBackground(new java.awt.Color(255, 255, 255));
        lab_ncheque.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lab_ncheque.setText("0");
        lab_ncheque.setActionCommand("<Not Set>");
        lab_ncheque.setBorder(null);
        lab_ncheque.setMaximumSize(new java.awt.Dimension(64, 23));
        lab_ncheque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_nchequeActionPerformed(evt);
            }
        });
        getContentPane().add(lab_ncheque);
        lab_ncheque.setBounds(540, 30, 64, 30);

        lab_nfecha.setEditable(false);
        lab_nfecha.setBackground(new java.awt.Color(255, 255, 255));
        lab_nfecha.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lab_nfecha.setText("01/00/1900");
        lab_nfecha.setBorder(null);
        lab_nfecha.setMaximumSize(new java.awt.Dimension(77, 20));
        lab_nfecha.setMinimumSize(new java.awt.Dimension(77, 20));
        lab_nfecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_nfechaActionPerformed(evt);
            }
        });
        getContentPane().add(lab_nfecha);
        lab_nfecha.setBounds(490, 80, 86, 14);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Monto");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(450, 110, 53, 17);

        lab_nmonto.setEditable(false);
        lab_nmonto.setBackground(new java.awt.Color(255, 255, 255));
        lab_nmonto.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lab_nmonto.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        lab_nmonto.setText("0.00");
        lab_nmonto.setBorder(null);
        lab_nmonto.setMaximumSize(new java.awt.Dimension(64, 23));
        getContentPane().add(lab_nmonto);
        lab_nmonto.setBounds(510, 110, 70, 17);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("No. Doc.");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(450, 160, 65, 28);

        lab_ndoc.setEditable(false);
        lab_ndoc.setBackground(new java.awt.Color(255, 255, 255));
        lab_ndoc.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        lab_ndoc.setText("000");
        lab_ndoc.setBorder(null);
        lab_ndoc.setMaximumSize(new java.awt.Dimension(64, 28));
        lab_ndoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_ndocActionPerformed(evt);
            }
        });
        getContentPane().add(lab_ndoc);
        lab_ndoc.setBounds(520, 170, 60, 22);

        jLabel6.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/Icon/sprite2.png")))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(350, 0, 100, 70);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel8.setText("Concepto:");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 170, 90, 20);

        lab_nnombre.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lab_nnombre.setText("0");
        lab_nnombre.setBorder(null);
        lab_nnombre.setName("lab_nnombre"); // NOI18N
        lab_nnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lab_nnombreActionPerformed(evt);
            }
        });
        getContentPane().add(lab_nnombre);
        lab_nnombre.setBounds(110, 120, 320, 17);

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Firma del personal que entrega:");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(30, 320, 190, 20);

        jLabel10.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel10.setText("Nombre:");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(30, 120, 68, 20);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel11.setText("Entregado por:");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(90, 250, 90, 20);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel12.setText("Recibido por:");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(90, 410, 90, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel13.setText("No. De Cédula:");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(70, 480, 90, 20);

        jLabel14.setText("______________________________");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(10, 460, 230, 16);

        jLabel15.setText("______________________________");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(10, 300, 240, 16);

        jLabel16.setText("______________________________");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(20, 390, 230, 16);

        lab_nconcepto.setColumns(20);
        lab_nconcepto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        lab_nconcepto.setLineWrap(true);
        lab_nconcepto.setRows(4);
        lab_nconcepto.setWrapStyleWord(true);
        lab_nconcepto.setMaximumSize(new java.awt.Dimension(232, 32));
        lab_nconcepto.setPreferredSize(new java.awt.Dimension(232, 32));
        jScrollPane2.setViewportView(lab_nconcepto);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(110, 140, 320, 70);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lab_nchequeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_nchequeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_nchequeActionPerformed

    private void lab_nfechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_nfechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_nfechaActionPerformed

    private void lab_ndocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_ndocActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_ndocActionPerformed

    private void lab_nnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lab_nnombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lab_nnombreActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlantillaC().setVisible(true);
            }});
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField lab_ncheque;
    private javax.swing.JTextArea lab_nconcepto;
    private javax.swing.JTextField lab_ndoc;
    private javax.swing.JTextField lab_nfecha;
    private javax.swing.JTextField lab_nmonto;
    private javax.swing.JTextField lab_nnombre;
    // End of variables declaration//GEN-END:variables

}
