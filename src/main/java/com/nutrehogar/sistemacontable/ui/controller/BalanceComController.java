package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.repository.BalanceComRepo;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.BalanceComView;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.nutrehogar.sistemacontable.application.service.Util.restarDateToSpinners;
@FieldDefaults(level = AccessLevel.PRIVATE)

public class BalanceComController {
    static BalanceComController instance;
    @Getter
    final BalanceComView view;
    final JTable table;
    final BalanceComTableModel tableModel;

    final LocalDateSpinner starDateSpinner;
    final LocalDateSpinner endDateSpinner;

    private BalanceComController() {
        view = new BalanceComView();
        table = view.getTabRegistros();
        starDateSpinner = view.getSpiInicio();
        endDateSpinner = view.getSpiFin();
        view.getButFiltrar().addActionListener(e -> {
            loadData();
        });
        tableModel = new BalanceComTableModel();
        table.setModel(tableModel);
        table.setDefaultRenderer(BigDecimal.class, new Util.BigDecimalRenderer());
        restarDateToSpinners(starDateSpinner, endDateSpinner);
        loadData();
    }

    public static BalanceComController getInstance() {
        if (instance == null) {
            instance = new BalanceComController();
        }
        return instance;
    }

    public void loadData() {
        var data = BalanceComRepo.find(
                BalanceComRepo.Field.CUENTA_ID,
                OrderDirection.ASCENDING,
                new BalanceComRepo.Filter.ByFechaRange((LocalDate) starDateSpinner.getValue(), (LocalDate) endDateSpinner.getValue()));
        SwingUtilities.invokeLater(() -> {
            tableModel.setData(data);
        });
    }

    public class BalanceComTableModel extends AbstractTableModel {
        private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;
        /**
         * lista de datos a mostrar en la base de datos
         */
        private ArrayList<BalanceComDTO> data;

        public BalanceComTableModel() {
            this.data = new ArrayList<>();
        }

        /**
         * Calcula la suma de {@code saldo}, de {@code Debe} y de {@code Haber}.
         * <p>
         * Dependiendo del tipo de cuenta que sea el del registro será el débito o el credito el que reste y sume
         *
         * @param data lista de datos a mostrar en la base de datos
         * @return la misma lista, con el {@code saldo}, total de {@code Debe} y total de {@code Haber} sumado
         */
        @Contract("_ -> param1")
        private @NotNull ArrayList<BalanceComDTO> calcularSaldos(@NotNull List<BalanceComDTO> data) {

            Map<String, List<BalanceComDTO>> agrupadoPorCuenta = data.stream()
                    .collect(Collectors.groupingBy(BalanceComDTO::getCuentaId));

            ArrayList<BalanceComDTO> resultado = new ArrayList<>();

            agrupadoPorCuenta.forEach((cuentaId, listaBalances) -> {
                var saldo = BigDecimal.ZERO;
                var sumDebe = BigDecimal.ZERO;
                var sumHaber = BigDecimal.ZERO;

                for (BalanceComDTO dto : listaBalances) {
                    saldo = TipoCuenta.fromId(dto.getTipoCuentaId()).getSaldo(saldo, dto.getRegistroHaber(), dto.getRegistroDebe());
                    sumDebe = sumDebe.add(dto.getRegistroDebe(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
                    sumHaber = sumHaber.add(dto.getRegistroHaber(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
                }

                BalanceComDTO totalDTO = new BalanceComDTO(
                        "---- TOTAL", // referencia
                        sumDebe, // suma debe
                        sumHaber, // suma haber
                        saldo // diferencia
                );
                resultado.addAll(listaBalances);
                resultado.add(totalDTO);
            });
            return resultado;
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
            data = newData != null ? calcularSaldos(newData) : new ArrayList<>();
            fireTableDataChanged();
        }
    }

}
