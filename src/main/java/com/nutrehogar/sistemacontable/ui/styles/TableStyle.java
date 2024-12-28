package com.nutrehogar.sistemacontable.ui.styles;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class TableStyle {
   public TableStyle(JTable tabla) {
       JTableHeader encabezado = tabla.getTableHeader();
        encabezado.setFont(new Font("Arial", Font.BOLD, 16));
        encabezado.setBackground(Color.decode("#1E88E5"));
        encabezado.setForeground(Color.WHITE);

        DefaultTableCellRenderer celdaRenderizador = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable tabla, Object valor,
                                boolean estaSeleccionado, boolean estaEnfocado, int fila, int columna) {
                Component componente = super.getTableCellRendererComponent(
                        tabla, valor, estaSeleccionado, estaEnfocado, fila, columna
                );

                if (!estaSeleccionado) {
                    if (fila % 2 == 0) {
                        componente.setBackground(Color.decode("#F1F8FF"));
                    } else {
                        componente.setBackground(Color.WHITE); 
                    }
                } else {
                    componente.setBackground(Color.decode("#BBDEFB")); 
                }
                
                setHorizontalAlignment(SwingConstants.CENTER);
                return componente;
            }
        };

        for (int i = 0; i < tabla.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(celdaRenderizador);
        }
        
        tabla.setFont(new Font("Arial", Font.PLAIN, 14));
        tabla.setRowHeight(25);
   }
}
