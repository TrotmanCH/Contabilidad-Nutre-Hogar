package com.nutrehogar.sistemacontable.ui.view;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

import com.formdev.flatlaf.FlatLightLaf;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import com.nutrehogar.sistemacontable.application.service.PDFService;
import com.nutrehogar.sistemacontable.ui.view.PlantillaC;

public class MainFrameDePrueba extends JFrame {
    // Declaración de los componentes
    private JTextField txt_ncheque, txt_fecha, txt_nombre, txt_concepto, txt_nodoc;
    private JTable table, tablaex;
    private JButton btnDocComprobante, btnFormulario, btnPrueba;

    public MainFrameDePrueba() {
        // Configuración básica del JFrame
        setTitle("Formulario de Cheque");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Configuración del layout
        setLayout(new BorderLayout());

        // Panel superior para los cuadros de texto
        JPanel panelSuperior = new JPanel();
        panelSuperior.setLayout(new GridLayout(5, 2, 5, 5));

        // Etiquetas y cuadros de texto
        panelSuperior.add(new JLabel("N° Cheque:"));
        txt_ncheque = new JTextField();
        panelSuperior.add(txt_ncheque);

        panelSuperior.add(new JLabel("Fecha:"));
        txt_fecha = new JTextField();
        panelSuperior.add(txt_fecha);

        panelSuperior.add(new JLabel("Nombre:"));
        txt_nombre = new JTextField();
        panelSuperior.add(txt_nombre);

        panelSuperior.add(new JLabel("Concepto:"));
        txt_concepto = new JTextField();
        panelSuperior.add(txt_concepto);

        panelSuperior.add(new JLabel("N° Documento:"));
        txt_nodoc = new JTextField();
        panelSuperior.add(txt_nodoc);

        // Añadir el panel superior al JFrame
        add(panelSuperior, BorderLayout.NORTH);

        // Crear el modelo de la primera tabla
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Referencias");
        model.addColumn("Código");
        model.addColumn("Debe");
        model.addColumn("Haber");

        // Añadir 18 filas vacías al modelo de la primera tabla
        for (int i = 0; i < 18; i++) {
            model.addRow(new Object[]{"", "", "", ""});
        }

        // Crear la primera tabla
        table = new JTable(model);
        JScrollPane scrollPane1 = new JScrollPane(table);

        // Crear el modelo de la segunda tabla
        DefaultTableModel modelEx = new DefaultTableModel();
        modelEx.addColumn("Tipo Doc");
        modelEx.addColumn("No Cheque");

        // Añadir 18 filas vacías al modelo de la segunda tabla
        for (int i = 0; i < 18; i++) {
            modelEx.addRow(new Object[]{"", ""});
        }

        // Crear la segunda tabla
        tablaex = new JTable(modelEx);
        JScrollPane scrollPane2 = new JScrollPane(tablaex);

        // Usar un JPanel con GridLayout para organizar las tablas
        JPanel panelTablas = new JPanel(new GridLayout(1, 2));
        panelTablas.add(scrollPane1);
        panelTablas.add(scrollPane2);

        // Añadir el panel de tablas al marco
        add(panelTablas, BorderLayout.CENTER);
        
        // Crear los botones Imprimir y Prueba
        btnDocComprobante = new JButton("Comprobante De Pago");
        btnFormulario = new JButton("Formulario");
        btnPrueba = new JButton("Prueba");
        
        // Crear una instancia de Tstd1
        btnDocComprobante.addActionListener(e -> {
        PlantillaC Tstd1 = new PlantillaC();
        PDFService.operacionComprobante(table, txt_ncheque.getText(), txt_fecha.getText(), txt_nodoc.getText(), txt_nombre.getText(), txt_concepto.getText(), Tstd1);
        });
        
        btnFormulario.addActionListener(e -> {
        PlantillaF Tstd2 = new PlantillaF();
        PDFService.operacionFormulario(table, tablaex, txt_ncheque.getText(), txt_fecha.getText(), txt_nodoc.getText(), txt_nombre.getText(), txt_concepto.getText(), Tstd2);
        });
        
        // Acción del botón "Prueba" para guardar en PDF
        btnPrueba.addActionListener(e -> {
            // Llamar a los métodos directamente
            if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
            }
            table.clearSelection();
            deseleccionarCuadrosTexto();
            guardarComoPDF(); // Esto ejecutará el método de guardado
        });
        
        // Panel inferior para los botones
        JPanel panelInferior = new JPanel();
        panelInferior.add(btnDocComprobante);
        panelInferior.add(btnFormulario);
        panelInferior.add(btnPrueba); 

        // Añadir el panel inferior al JFrame
        add(panelInferior, BorderLayout.SOUTH);
    }

private void deseleccionarCuadrosTexto() {
    txt_ncheque.setSelectionStart(0);
    txt_ncheque.setSelectionEnd(0);
    txt_fecha.setSelectionStart(0);
    txt_fecha.setSelectionEnd(0);
    txt_nombre.setSelectionStart(0);
    txt_nombre.setSelectionEnd(0);
    txt_concepto.setSelectionStart(0);
    txt_concepto.setSelectionEnd(0);
    txt_nodoc.setSelectionStart(0);
    txt_nodoc.setSelectionEnd(0);
    table.clearSelection();
    
     // Finalizar la edición actual de la celda (si la hay)
    if (table.isEditing()) {
        table.getCellEditor().stopCellEditing();
    }
    
    // Asegurarse de que el renderizador no marque la celda
    table.getSelectionModel().clearSelection();
    table.getColumnModel().getSelectionModel().clearSelection();
}

private void guardarComoPDF() {
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

        // Usar JFileChooser para seleccionar ubicación
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Guardar como PDF");
        fileChooser.setSelectedFile(new java.io.File("interfaz.pdf"));
        
        int userSelection = fileChooser.showSaveDialog(this);
        
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            java.io.File fileToSave = fileChooser.getSelectedFile();
            
            // Verificar si el archivo ya existe
            if (fileToSave.exists()) {
                // Preguntar al usuario si desea sobrescribir
                int response = JOptionPane.showConfirmDialog(this, 
                        "El archivo ya existe. ¿Deseas reemplazarlo?", 
                        "Confirmar Sobrescritura", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);
                
                // Si el usuario elige NO, cancelar el guardado
                if (response != JOptionPane.YES_OPTION) {
                    return; // Salir del método sin guardar
                }
            }

            // Crear el documento PDF con tamaño Carta (Letter)
            Document documento = new Document(new com.itextpdf.text.Rectangle(0, 0, 612, 792)); // 612x792 puntos para Carta (8.5"x11")
            PdfWriter.getInstance(documento, new FileOutputStream(fileToSave));
            documento.open();

            // Añadir la imagen al documento PDF
            Image imagenPDF = Image.getInstance("captura.png");
            imagenPDF.scaleToFit(PageSize.LETTER.getWidth(), PageSize.LETTER.getHeight());
            imagenPDF.setAlignment(Image.ALIGN_CENTER);  // Centrar imagen
            documento.add(imagenPDF);

            // Cerrar el documento
            documento.close();

            JOptionPane.showMessageDialog(this, "PDF guardado exitosamente en " + fileToSave.getAbsolutePath());
        }
        
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al guardar en PDF: " + ex.getMessage());
    }
}

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch(Exception ex) {
            System.err.println("Failed to initialize LaF");
        }        SwingUtilities.invokeLater(() -> {
            MainFrameDePrueba frame = new MainFrameDePrueba();
            frame.setVisible(true);
        });
    }
}