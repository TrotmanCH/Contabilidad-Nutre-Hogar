package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class TransparentTableExample {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        // Datos de ejemplo
        Object[][] data = {
                {1, "Producto A", 19.99},
                {2, "Producto B", 29.99},
                {3, "Producto C", 9.99}
        };
        String[] columnNames = {"ID", "Nombre", "Precio"};

        // Crear la tabla
        JTable table = new JTable(data, columnNames);

        // Hacer transparente el fondo de la tabla
        table.setOpaque(false);

        // Desactivar las líneas de la cuadrícula
        table.setShowGrid(false);

        // Desactivar los bordes de la tabla
        table.setBorder(BorderFactory.createEmptyBorder());

        // Hacer transparente el fondo de las celdas
        table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                // Hacer transparente el fondo de las celdas
                setOpaque(false);

                // Personalizar el texto (opcional)
                setForeground(Color.BLACK); // Color del texto
                setBorder(BorderFactory.createEmptyBorder(5, 10, 20, 20)); // Padding interno

                return this;
            }
        });

        // Hacer transparente el encabezado de la tabla
        JTableHeader header = table.getTableHeader();
        header.setOpaque(false);
        header.setDefaultRenderer(new TransparentHeaderRenderer());
        header.setForeground(Color.BLACK);
        header.setFont(new Font("SansSerif", Font.BOLD, 14));
        header.setBorder(BorderFactory.createEmptyBorder());


        // Crear el JScrollPane y hacerlo transparente
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        var a = new JPanel(new BorderLayout());
        a.add(scrollPane, BorderLayout.CENTER);
        a.setBackground(Color.red);
        // Mostrar la tabla en un JFrame
        JFrame frame = new JFrame("Tabla Transparente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(a);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Renderizador personalizado para el encabezado
    static class TransparentHeaderRenderer implements TableCellRenderer {
        private final DefaultTableCellRenderer renderer;

        public TransparentHeaderRenderer() {
            renderer = new DefaultTableCellRenderer();
            renderer.setOpaque(false); // Hacer transparente el fondo del renderizador
            renderer.setForeground(Color.BLACK); // Color del texto
            renderer.setFont(new Font("SansSerif", Font.BOLD, 14)); // Fuente del encabezado
            renderer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10)); // Padding interno
            renderer.setHorizontalAlignment(JLabel.CENTER); // Alineación del texto
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return renderer.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
}