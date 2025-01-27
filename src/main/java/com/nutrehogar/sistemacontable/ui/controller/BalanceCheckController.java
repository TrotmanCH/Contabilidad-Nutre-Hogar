package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.domain.BalanceCheckRepositoryImpl;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.BalanceComRepo;
import com.nutrehogar.sistemacontable.ui.view.BalanceCheckView;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceCheckController extends BusinessController<BalanceComDTO> {

    public BalanceCheckController(BalanceCheckRepositoryImpl repository, BalanceCheckView view) {
        super(repository, view);
    }

    @Override
    protected void initialize() {
        setTableModel(new BalanceCheckTableModel());
        super.initialize();
    }

    @Override
    protected void loadData() {
        getData().clear();
        var lista = getRepository().find(BalanceCheckRepositoryImpl.Field.CUENTA_ID,
                OrderDirection.ASCENDING,
                new BalanceCheckRepositoryImpl.Filter.ByFechaRange(getSpinnerModelStartPeriod().getValue(),
                        getSpinnerModelEndPeriod().getValue()));

        Map<String, List<BalanceComDTO>> agrupadoPorCuenta = lista.stream()
                .collect(Collectors.groupingBy(BalanceComDTO::getCuentaId));

        agrupadoPorCuenta.forEach((cuentaId, listaBalances) -> {
            var saldo = BigDecimal.ZERO;
            var sumDebe = BigDecimal.ZERO;
            var sumHaber = BigDecimal.ZERO;

            for (BalanceComDTO dto : listaBalances) {
                saldo = TipoCuenta.fromId(dto.getTipoCuentaId()).getSaldo(saldo, dto.getRegistroHaber(), dto.getRegistroDebe());
                sumDebe = sumDebe.add(dto.getRegistroDebe(), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
                sumHaber = sumHaber.add(dto.getRegistroHaber(), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
                dto.setSaldo(saldo);
                getData().add(dto);
            }

            BalanceComDTO totalDTO = new BalanceComDTO(
                    "TOTAL", // referencia
                    sumDebe, // suma debe
                    sumHaber, // suma haber
                    saldo // diferencia
            );
            getData().add(totalDTO);
            getData().add(new BalanceComDTO("", BigDecimal.ZERO, BigDecimal.ZERO, BigDecimal.ZERO));
        });
        super.loadData();
    }

    @Override
    protected void setElementSelected(@NotNull MouseEvent e) {
        int row = getTable().rowAtPoint(e.getPoint());
        if (row != -1) {
            int selectedRow = getTable().getSelectedRow();
            if (selectedRow < 0) {
                getBtnEdit().setEnabled(false);
                return;
            }
            var selected = getData().get(selectedRow);
            if (selected.getAsientoFecha() == null) {
                getBtnEdit().setEnabled(false);
                return;
            }
            setSelected(selected);
            getBtnEdit().setEnabled(true);
        }
    }

    @Override
    public BalanceCheckView getView() {
        return (BalanceCheckView) super.getView();
    }

    @Override
    public BalanceCheckRepositoryImpl getRepository() {
        return (BalanceCheckRepositoryImpl) super.getRepository();
    }

    public class BalanceCheckTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return getData().size();
        }

        @Override
        public int getColumnCount() {
            return BalanceComRepo.Field.values().length;
        }

        @Override
        public String getColumnName(int column) {
            return BalanceComRepo.Field.values()[column].getFieldName();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            BalanceComDTO dto = getData().get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.getAsientoFecha();
                case 1 -> dto.getTipoDocumentoNombre();
                case 2 -> dto.getCuentaId();
                case 3 -> dto.getCuentaNombre();
                case 4 -> dto.getRegistroReferencia();
                case 5 -> dto.getRegistroDebe();
                case 6 -> dto.getRegistroHaber();
                case 7 -> dto.getSaldo();
                default -> "que haces?";
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
    }
}
