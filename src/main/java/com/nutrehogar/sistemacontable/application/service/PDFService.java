package com.nutrehogar.sistemacontable.application.service;

import com.nutrehogar.sistemacontable.ui.view.services.ComprobantePago;
import com.nutrehogar.sistemacontable.ui.view.services.FormularioRegistro;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PDFService {
    public static void operacionComprobante(
            JTable table,
            String txt_ncheque,
            String txt_fecha,
            String txt_nodoc,
            String txt_nombre,
            String txt_concepto,
            ComprobantePago ventanaPlantillaC) {

        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }
        table.clearSelection();

        DefaultTableModel modeloMain = (DefaultTableModel) table.getModel();
        DefaultTableModel modeloPlantillaC = ventanaPlantillaC.getTableModel();

        modeloPlantillaC.setRowCount(0);
        double sumaDebe = 0.0;
        double sumaHaber = 0.0;

        for (int i = 0; i < modeloMain.getRowCount(); i++) {
            Object[] fila = new Object[modeloMain.getColumnCount()];
            for (int j = 0; j < modeloMain.getColumnCount(); j++) {
                Object valorOriginal = modeloMain.getValueAt(i, j);

                if (j == 2 || j == 3) {
                    try {
                        if (valorOriginal != null && !valorOriginal.toString().isEmpty()) {
                            double valorDecimal = Double.parseDouble(valorOriginal.toString());
                            fila[j] = String.format("%.2f", valorDecimal);

                            if (j == 2) {
                                sumaDebe += valorDecimal;
                            } else if (j == 3) {
                                sumaHaber += valorDecimal;
                            }
                        }
                    } catch (NumberFormatException | NullPointerException ex) {
                        // Ignorar errores de formato
                    }
                } else {
                    fila[j] = valorOriginal;
                }
            }
            modeloPlantillaC.addRow(fila);
        }

        modeloPlantillaC.addRow(new Object[]{"0.00", "Total", String.format("%.2f", sumaDebe), String.format("%.2f", sumaHaber)});
        ventanaPlantillaC.setLabelsText(txt_ncheque, txt_fecha, txt_nodoc, txt_nombre, txt_concepto, String.format("%.2f", sumaHaber));
        ventanaPlantillaC.setVisible(true);
        ventanaPlantillaC.exportarPantallaAPDF();
    }
    public static void operacionFormulario(
            JTable table,
            String txt_ncheque,
            String txt_fecha,
            String txt_nodoc,
            String txt_nombre,
            String txt_concepto,
            FormularioRegistro ventanaPlantillaF) {
        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }
        table.clearSelection();

        DefaultTableModel modeloMain = (DefaultTableModel) table.getModel();
        DefaultTableModel modeloPlantillaF = ventanaPlantillaF.getTableModel();

        modeloPlantillaF.setRowCount(0);
        double sumaDebe = 0.0;
        double sumaHaber = 0.0;

        for (int i = 0; i < modeloMain.getRowCount(); i++) {
            Object[] fila = new Object[modeloMain.getColumnCount()];
            for (int j = 0; j < modeloMain.getColumnCount(); j++) {
                Object valorOriginal = modeloMain.getValueAt(i, j);

                if (j == 2 || j == 3) {
                    try {
                        if (valorOriginal != null && !valorOriginal.toString().isEmpty()) {
                            double valorDecimal = Double.parseDouble(valorOriginal.toString());
                            fila[j] = String.format("%.2f", valorDecimal);

                            if (j == 2) {
                                sumaDebe += valorDecimal;
                            } else if (j == 3) {
                                sumaHaber += valorDecimal;
                            }
                        }
                    } catch (NumberFormatException | NullPointerException ex) {
                        // Ignorar errores de formato
                    }
                } else {
                    fila[j] = valorOriginal;
                }
            }
            modeloPlantillaF.addRow(fila);
        }

        modeloPlantillaF.addRow(new Object[]{"", "Total", String.format("%.2f", sumaDebe), String.format("%.2f", sumaHaber)});
        ventanaPlantillaF.setLabelsText(txt_ncheque, txt_fecha, txt_nodoc, txt_nombre, txt_concepto, String.format("%.2f", sumaHaber));

        for (int i = 0; i < table.getRowCount(); i++) {
            Object valorCheque = table.getValueAt(i, 1);
            modeloPlantillaF.addRow(new Object[]{valorCheque});
        }

        modeloPlantillaF.addRow(new Object[]{"0.00"});

        for (int i = 0; i < table.getRowCount(); i++) {
            Object valorCheque = table.getValueAt(i, 0);
            Object[] nuevaFila = new Object[modeloPlantillaF.getColumnCount()];

            nuevaFila[2] = valorCheque;

            if (valorCheque != null && !valorCheque.toString().isEmpty()) {
                if (modeloPlantillaF.getColumnCount() > 0) {
                    nuevaFila[0] = txt_fecha;
                }
                if (modeloPlantillaF.getColumnCount() > 1) {
                    nuevaFila[1] = txt_nodoc;
                }
            }
            modeloPlantillaF.addRow(nuevaFila);
        }

        ventanaPlantillaF.setVisible(true);
        ventanaPlantillaF.exportarPantallaAPDF();
    }
}
