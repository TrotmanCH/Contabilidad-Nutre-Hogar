package com.nutrehogar.sistemacontable.ui.styles;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class TableStyle {
    static Font fontHeader = new Font("Arial", Font.BOLD, 16);
    static Font fontBody = new Font("Arial", Font.PLAIN, 14);
    static Color bg1 = Color.decode("#1E88E5");
    static Color bg2 = Color.decode("#F1F8FF");
    static Color bg3 = Color.decode("#BBDEFB");
    static DefaultTableCellRenderer celdaRenderizador = new DefaultTableCellRenderer() {
        @Override
        public @NotNull Component getTableCellRendererComponent(JTable tabla, Object valor,
                                                                boolean estaSeleccionado, boolean estaEnfocado, int fila, int columna) {
            Component componente = super.getTableCellRendererComponent(
                    tabla, valor, estaSeleccionado, estaEnfocado, fila, columna
            );

            if (!estaSeleccionado) {
                if (fila % 2 == 0) {
                    componente.setBackground(bg2);
                } else {
                    componente.setBackground(Color.WHITE);
                }
            } else {
                componente.setBackground(bg3);
            }
            if (tabla.getModel().getColumnClass(columna) == String.class) {
                setHorizontalAlignment(SwingConstants.LEFT);
            } else {
                setHorizontalAlignment(SwingConstants.CENTER);
            }
            return componente;
        }
    };

    public static void setStyle(@NotNull JTable tabla) {
        JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setFont(fontHeader);
        encabezado.setBackground(bg1);
        encabezado.setForeground(Color.WHITE);

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(celdaRenderizador);
        }

        tabla.setFont(fontBody);
        tabla.setRowHeight(25);
    }
}
