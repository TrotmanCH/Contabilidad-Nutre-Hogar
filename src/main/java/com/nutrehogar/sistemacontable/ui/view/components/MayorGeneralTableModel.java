package com.nutrehogar.sistemacontable.ui.view.components;

import com.nutrehogar.sistemacontable.application.dto.MayorGeneralDTO;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class MayorGeneralTableModel extends AbstractTableModel {

    private List<MayorGeneralDTO> data;
    private final String[] columnNames = {
            "Fecha", "Nombre de Asiento", "Tipo Documento", "Código Cuenta", "Referencia", "Debe", "Haber", "Saldo"
    };

    public MayorGeneralTableModel(List<MayorGeneralDTO> data) {
        this.data = calcularSaldos(data);
    }

    private @NotNull List<MayorGeneralDTO> calcularSaldos(@NotNull List<MayorGeneralDTO> data) {
        BigDecimal saldo;
        for (MayorGeneralDTO mayorGeneralDTO : data) {
            saldo = TipoCuenta.fromId(mayorGeneralDTO.getIdTipoCuenta()).getSaldo(mayorGeneralDTO.getSaldo(), mayorGeneralDTO.getHaber(), mayorGeneralDTO.getDebe());
            mayorGeneralDTO.setSaldo(saldo);
        }
        return data;
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
        MayorGeneralDTO dto = data.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> dto.getFecha();
            case 1 -> dto.getAsientoNombre();
            case 2 -> dto.getTipoDocumentoNombre();
            case 3 -> dto.getCodigoCuenta();
            case 4 -> dto.getReferencia();
            case 5 -> dto.getDebe();
            case 6 -> dto.getHaber();
            case 7 -> dto.getSaldo();
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
