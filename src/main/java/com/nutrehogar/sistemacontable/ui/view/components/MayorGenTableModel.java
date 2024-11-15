package com.nutrehogar.sistemacontable.ui.view.components;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGenField;
import com.nutrehogar.sistemacontable.ui.controller.TipoCuenta;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

public class MayorGenTableModel extends AbstractTableModel {
    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    private List<MayorGenDTO> data;
    /**
     * private final String[] columnNames = {
     * MayorGenField.ASIENTO_FECHA.getFieldName(),
     * MayorGenField.ASIENTO_NOMBRE.getFieldName(),
     * MayorGenField.TIPO_DOCUMENTO_NOMBRE.getFieldName(),
     * MayorGenField.CUENTA_ID.getFieldName(),
     * MayorGenField.REGISTRO_REFERENCIA.getFieldName(),
     * MayorGenField.REGISTRO_DEBE.getFieldName(),
     * MayorGenField.REGISTRO_HABER.getFieldName(),
     * MayorGenField.SALDO.getFieldName()
     * };
     *
     * @Override public String getColumnName(int column) {
     * return columnNames[column];
     * }
     * @Override
     *     public Class<?> getColumnClass(int columnIndex) {
     *         return switch (columnIndex) {
     *             case 0 -> LocalDate.class;
     *             case 1, 2, 3, 4 -> String.class;
     *             case 5, 6, 7 -> BigDecimal.class;
     *             default -> Object.class;
     *         };
     *     }
     */
    private BigDecimal saldo = BigDecimal.ZERO;
    private BigDecimal sumDebe = BigDecimal.ZERO;
    private BigDecimal sumHaber = BigDecimal.ZERO;

    public MayorGenTableModel() {
        this.data = List.of();
    }

    public MayorGenTableModel(List<MayorGenDTO> data) {
        this.data = data != null ? calcularSaldos(data) : List.of();
    }

    @Contract("_ -> param1")
    private List<MayorGenDTO> calcularSaldos(@NotNull List<MayorGenDTO> data) {
        saldo = BigDecimal.ZERO;
        sumDebe = BigDecimal.ZERO;
        sumHaber = BigDecimal.ZERO;
        for (MayorGenDTO dto : data) {
            saldo = TipoCuenta.fromId(dto.getTipoCuentaId()).getSaldo(saldo, dto.getRegistroHaber(), dto.getRegistroDebe());
            sumDebe = sumDebe.add(dto.getRegistroDebe(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
            sumHaber = sumHaber.add(dto.getRegistroHaber(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
            dto.setSaldo(saldo);
        }
        return data;
    }


    @Override
    public int getRowCount() {
        return data.size() + 1;//uno extra para el total
    }

    @Override
    public int getColumnCount() {
        return MayorGenField.values().length;
    }

    @Override
    public String getColumnName(int column) {
        return MayorGenField.values()[column].getFieldName();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < data.size()) {
            MayorGenDTO dto = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.getAsientoFecha();
                case 1 -> dto.getAsientoNombre();
                case 2 -> dto.getTipoDocumentoNombre();
                case 3 -> dto.getCuentaId();
                case 4 -> dto.getRegistroReferencia();
                case 5 -> dto.getRegistroDebe();
                case 6 -> dto.getRegistroHaber();
                case 7 -> dto.getSaldo();
                default -> null;
            };
        } else {
            return switch (columnIndex) {
                case 4 -> "TOTAL:";
                case 5 -> sumDebe;
                case 6 -> sumHaber;
                case 7 -> saldo;
                default -> null;
            };
        }
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

    public void setData(List<MayorGenDTO> newData) {
        data = newData != null ? calcularSaldos(newData) : List.of();
        fireTableDataChanged();
    }
}
