package com.nutrehogar.sistemacontable.application.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.nutrehogar.sistemacontable.ui.view.services.ComprobantePago;
import com.nutrehogar.sistemacontable.ui.view.services.FormularioRegistro;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PDFService {
    public String noCheque;
    public String fecha;
    public String monto;
    public String noDoc;
    public String nombre;
    public String concepto;
    public String debe;
    public String haber;
    public DefaultTableModel registros;
    
    public void exportarComprobante() {
        ComprobantePago cp = new ComprobantePago();
        cp.texfieNoCheque.setText(noCheque);
        cp.texfieFecha.setText(fecha);
        cp.texfieNoDoc.setText(noDoc);
        cp.texfieNombre.setText(nombre);
        cp.texareConcepto.setText(concepto);
        cp.texfieMonto.setText(monto);
        DefaultTableModel cpRegistros = (DefaultTableModel) cp.tabRegistros.getModel();
        
        for (Integer fila = 0; fila < registros.getRowCount(); fila++) {
            Object[] columnas = new Object[cpRegistros.getColumnCount()];
            for (Integer columna = 2; columna < registros.getColumnCount(); columna++) {
                Object valor = registros.getValueAt(fila, columna);
                columnas[columna - 2] = valor;
            }
            cpRegistros.addRow(columnas);
        }

        cpRegistros.addRow(new Object[]{"", "Total:", debe, haber});

        cp.setVisible(true);
        exportarPDF(cp);
    }
    public void exportarFormulario() {
        FormularioRegistro fr = new FormularioRegistro();
        fr.texfieNoCheque.setText(noCheque);
        fr.texfieFecha.setText(fecha);
        fr.texfieNoDoc.setText(noDoc);
        fr.texfieNombre.setText(nombre);
        fr.texareConcepto.setText(concepto);
        fr.texfieMonto.setText(monto);
        DefaultTableModel frRegistros = (DefaultTableModel) fr.tabRegistros.getModel();
        
        for (Integer fila = 0; fila < registros.getRowCount(); fila++) {
            Object[] columnas = new Object[frRegistros.getColumnCount()];
            for (Integer columna = 0; columna < registros.getColumnCount(); columna++) {
                Object valor = registros.getValueAt(fila, columna);
                columnas[columna] = valor;
            }
            frRegistros.addRow(columnas);
        }

        frRegistros.addRow(new Object[]{"","","", "Total:", debe, haber});

        fr.setVisible(true);
        exportarPDF(fr);
    }
    
    private void exportarPDF(JFrame ventana) {
        try {
            // Obtener el tamaño de la interfaz (sin bordes)
            Dimension dimension = ventana.getSize();
            
            BufferedImage imagen = new BufferedImage(dimension.width, dimension.height, BufferedImage.TYPE_INT_RGB);
            Graphics2D g2d = imagen.createGraphics();

            // Cambiar el color de fondo (si es necesario)
            g2d.setColor(ventana.getBackground());
            g2d.fillRect(0, 0, dimension.width, dimension.height);

            // Pintar la interfaz en el BufferedImage
            ventana.paint(g2d);
            g2d.dispose();

            // Guardar la imagen temporalmente en el sistema de archivos
            ImageIO.write(imagen, "png", new java.io.File(ventana.getTitle() + ".png"));
            ventana.setVisible(false);

            // Usar JFileChooser para seleccionar ubicación
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Guardar como PDF");

            // Crear un formato de fecha para el nombre del archivo
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Formato de fecha (AñoMesDía)
            String fechaFormateada = sdf.format(new Date());

            //Configurar el nombre del archivo con el titulo de la ventana y la fecha
            fileChooser.setSelectedFile(new java.io.File(ventana.getTitle()+ "_" + fechaFormateada + ".pdf"));

            Integer userSelection = fileChooser.showSaveDialog(ventana);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                java.io.File fileToSave = fileChooser.getSelectedFile();

                // Verificar si el archivo ya existe y mostrar advertencia
                if (fileToSave.exists()) {
                    Integer response = JOptionPane.showConfirmDialog(ventana, 
                            "El archivo ya existe. ¿Deseas reemplazarlo?", 
                            "Confirmar Sobrescritura", 
                            JOptionPane.YES_NO_OPTION, 
                            JOptionPane.WARNING_MESSAGE);
                    
                    // Salir del método sin guardar
                    if (response != JOptionPane.YES_OPTION) {
                        return; 
                    }
                }

                // Crear el documento PDF con tamaño Letter (8.5"x11")
                Document documento = new Document(PageSize.LETTER);
                PdfWriter.getInstance(documento, new FileOutputStream(fileToSave));
                documento.open();

                // Añadir la imagen al documento PDF y posicionarla en la parte superior
                Image imagenPDF = Image.getInstance(ventana.getTitle() + ".png");
                imagenPDF.scaleToFit(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
                imagenPDF.setAbsolutePosition(0, 32);
                documento.add(imagenPDF);

                // Cerrar el documento
                documento.close();

                JOptionPane.showMessageDialog(ventana, "PDF guardado exitosamente en " + fileToSave.getAbsolutePath());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(
                    ventana, "Error al guardar el PDF: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE
            );
        }
    }
}
