package com.nutrehogar.sistemacontable.ui.view.components;

import com.nutrehogar.sistemacontable.application.dto.MayorGeneralDTO;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MayorGeneralTableModel extends AbstractTableModel {
    public record MayorGeneralModel(
            LocalDate fecha,
            String asientoNombre,
            String tipoDocumentoNombre,
            String codigoCuenta,
            String referencia,
            BigDecimal debe,
            BigDecimal haber,
            BigDecimal saldo
    ) {
    }

    private List<MayorGeneralModel> data;
    private final String[] columnNames = {
            "Fecha", "Nombre de Asiento", "Tipo Documento", "Código Cuenta", "Referencia", "Debe", "Haber", "Saldo"
    };
    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    public MayorGeneralTableModel(List<MayorGeneralDTO> data) {
        this.data = calcularSaldos(data);
    }

    private List<MayorGeneralModel> calcularSaldos(List<MayorGeneralDTO> data) {
        BigDecimal saldo = BigDecimal.ZERO;
        List<MayorGeneralModel> models = new ArrayList<>();
        for (MayorGeneralDTO mayorGeneralDTO : data) {
            saldo = saldo.add(mayorGeneralDTO.debe(), MATH_CONTEXT).subtract(mayorGeneralDTO.haber(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
            models.add(new MayorGeneralModel(
                    mayorGeneralDTO.fecha(),
                    mayorGeneralDTO.asientoNombre(),
                    mayorGeneralDTO.tipoDocumentoNombre(),
                    mayorGeneralDTO.codigoCuenta(),
                    mayorGeneralDTO.referencia(),
                    mayorGeneralDTO.debe(),
                    mayorGeneralDTO.haber(),
                    saldo
            ));
        }
        return models;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        MayorGeneralModel dto = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> dto.fecha();
            case 1 -> dto.asientoNombre();
            case 2 -> dto.tipoDocumentoNombre();
            case 3 -> dto.codigoCuenta();
            case 4 -> dto.referencia();
            case 5 -> dto.debe();
            case 6 -> dto.haber();
            case 7 -> dto.saldo();
            default -> null;
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return switch (columnIndex) {
            case 0 -> LocalDate.class;
            case 1, 2, 3, 4 -> String.class;
            case 5, 6, 7 -> BigDecimal.class;
            default -> Object.class;
        };
    }

    public void setData(List<MayorGeneralDTO> newData) {
        data = Objects.requireNonNullElseGet(calcularSaldos(newData), List::of);
        fireTableDataChanged();
    }
}
