package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.repository.BalanceComRepo;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.BalanceComView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.nutrehogar.sistemacontable.application.service.Util.restarDateToSpinners;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class BalanceComController {
    static BalanceComController instance;
    final BalanceComView view;
    final JTable table;
    final BalanceComTableModel tableModel;
    static ArrayList<BalanceComDTO> data = new ArrayList<>();
    BalanceComDTO selected;
    final JButton editButton;
    final LocalDateSpinner starDateSpinner;
    final LocalDateSpinner endDateSpinner;

    private BalanceComController() {
        view = new BalanceComView();
        table = view.getTabRegistros();
        this.editButton = view.getButEdit();
        editButton.setEnabled(false);
        starDateSpinner = view.getSpiInicio();
        endDateSpinner = view.getSpiFin();
        view.getButFiltrar().addActionListener(e -> loadData());
        tableModel = new BalanceComTableModel();
        table.setModel(tableModel);
        Util.setTableRenderer(table);
        restarDateToSpinners(starDateSpinner, endDateSpinner);
        loadData();
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                press(e);
            }

            private void press(@NotNull MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row != -1) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow < 0) {
                        editButton.setEnabled(false);
                        return;
                    }
                    var selectedDate = data.get(selectedRow);
                    if (selectedDate.getAsientoFecha() == null) {
                        editButton.setEnabled(false);
                        return;
                    }
                    selected = selectedDate;
                    editButton.setEnabled(true);
                }
            }
        });
    }

    public static BalanceComController getInstance() {
        if (instance == null) {
            instance = new BalanceComController();
        }
        return instance;
    }

    public BalanceComView getView(Consumer<Integer> action) {
        editButton.addActionListener(e -> action.accept((selected.getAsientoId())));
        return view;
    }

    public void loadData() {
        var lista = BalanceComRepo.find(
                BalanceComRepo.Field.CUENTA_ID,
                OrderDirection.ASCENDING,
                new BalanceComRepo.Filter.ByFechaRange((LocalDate) starDateSpinner.getValue(), (LocalDate) endDateSpinner.getValue()));

        calcularSaldos(lista);
        SwingUtilities.invokeLater(tableModel::fireTableDataChanged);
    }

    /**
     * Calcula la suma de {@code saldo}, de {@code Debe} y de {@code Haber}.
     * <p>
     * Dependiendo del tipo de cuenta que sea el del registro será el débito o el credito el que reste y sume
     */
    private static void calcularSaldos(@NotNull List<BalanceComDTO> list) {
        data.clear();
        Map<String, List<BalanceComDTO>> agrupadoPorCuenta = list.stream()
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
                data.add(dto);
            }

            BalanceComDTO totalDTO = new BalanceComDTO(
                    "TOTAL", // referencia
                    sumDebe, // suma debe
                    sumHaber, // suma haber
                    saldo // diferencia
            );
            data.add(totalDTO);
        });
    }

    public static class BalanceComTableModel extends AbstractTableModel {
        /**
         * lista de datos a mostrar en la base de datos
         */

        public BalanceComTableModel() {
        }


        @Override
        public int getRowCount() {
            return data.size();
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
            BalanceComDTO dto = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.getAsientoFecha();
                case 1 -> dto.getTipoDocumentoNombre();
                case 2 -> dto.getCuentaId();
                case 3 -> dto.getCuentaNombre();
                case 4 -> dto.getRegistroReferencia();
                case 5 -> dto.getRegistroDebe();
                case 6 -> dto.getRegistroHaber();
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

        /**
         * Inserta los nuevos datos a la tabla y llama a {@code fireTableDataChanged()}, para que la tabla se vuelva a renderzar
         *
         * @param newData lista de datos a mostrar
         */

        public void setData(List<BalanceComDTO> newData) {
//            data = newData != null ? calcularSaldos(newData) : new ArrayList<>();
            fireTableDataChanged();
        }
    }

}
