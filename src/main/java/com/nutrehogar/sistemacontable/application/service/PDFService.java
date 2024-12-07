package com.nutrehogar.sistemacontable.application.service;

import com.nutrehogar.sistemacontable.ui.view.PlantillaC;
import com.nutrehogar.sistemacontable.ui.view.PlantillaF;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PDFService {

    /**
     * Realiza la operación de comprobante.
     *
     * @param table Tabla principal que contiene los datos.
     * @param txt_ncheque Texto del número de cheque.
     * @param txt_fecha Texto de la fecha.
     * @param txt_nodoc Texto del número de documento.
     * @param txt_nombre Texto del nombre.
     * @param txt_concepto Texto del concepto.
     * @param ventanaPlantillaC Instancia de la ventana PlantillaC.
     */
    public static void operacionComprobante(
            JTable table,
            String txt_ncheque,
            String txt_fecha,
            String txt_nodoc,
            String txt_nombre,
            String txt_concepto,
            PlantillaC ventanaPlantillaC) {

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

    /**
     * Realiza la operación de formulario.
     *
     * @param table Tabla principal que contiene los datos.
     * @param tablaex Tabla adicional para datos específicos.
     * @param txt_ncheque Texto del número de cheque.
     * @param txt_fecha Texto de la fecha.
     * @param txt_nodoc Texto del número de documento.
     * @param txt_nombre Texto del nombre.
     * @param txt_concepto Texto del concepto.
     * @param ventanaPlantillaF Instancia de la ventana PlantillaF.
     */
    public static void operacionFormulario(
            JTable table,
            JTable tablaex,
            String txt_ncheque,
            String txt_fecha,
            String txt_nodoc,
            String txt_nombre,
            String txt_concepto,
            PlantillaF ventanaPlantillaF) {
        if (table.isEditing()) {
            table.getCellEditor().stopCellEditing();
        }
        table.clearSelection();
        if (tablaex.isEditing()) {
            tablaex.getCellEditor().stopCellEditing();
        }
        tablaex.clearSelection();

        DefaultTableModel modeloMain = (DefaultTableModel) table.getModel();
        DefaultTableModel modeloPlantillaF = ventanaPlantillaF.getTableModel();
        DefaultTableModel modeloPlantillaFCom = ventanaPlantillaF.getTablacomModel();
        DefaultTableModel modeloPlantillaFEx = ventanaPlantillaF.getTablaexModel();

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

        for (int i = 0; i < tablaex.getRowCount(); i++) {
            Object valorCheque = tablaex.getValueAt(i, 1);
            modeloPlantillaFCom.addRow(new Object[]{valorCheque});
        }

        modeloPlantillaFCom.addRow(new Object[]{"0.00"});

        for (int i = 0; i < tablaex.getRowCount(); i++) {
            Object valorCheque = tablaex.getValueAt(i, 0);
            Object[] nuevaFila = new Object[modeloPlantillaFEx.getColumnCount()];

            nuevaFila[2] = valorCheque;

            if (valorCheque != null && !valorCheque.toString().isEmpty()) {
                if (modeloPlantillaFEx.getColumnCount() > 0) {
                    nuevaFila[0] = txt_fecha;
                }
                if (modeloPlantillaFEx.getColumnCount() > 1) {
                    nuevaFila[1] = txt_nodoc;
                }
            }
            modeloPlantillaFEx.addRow(nuevaFila);
        }

        ventanaPlantillaF.setVisible(true);
        ventanaPlantillaF.exportarPantallaAPDF();
    }
}
