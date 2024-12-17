package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.repository.LibroDiarioRepo;
import com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.LibroDiarioView;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static com.nutrehogar.sistemacontable.application.service.Util.restarDateToSpinners;

/**
 * @author Calcifer1331
 */

@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibroDiarioController {
    static LibroDiarioController instance;
    @Getter
    LibroDiarioView view;
    final JTable libroDiarioTable;
    final LibroDiarioTableModel libroDiarioTableModel;
    final LocalDateSpinner starDateSpinner;
    final LocalDateSpinner endDateSpinner;
    final JButton btnFilter;

    public static LibroDiarioController getInstance() {
        if (instance == null) {
            instance = new LibroDiarioController();
        }
        return instance;
    }

    private LibroDiarioController() {
        view = new LibroDiarioView();
        libroDiarioTable = view.getTableLibro();
        starDateSpinner = view.getStarDateSpinner();
        endDateSpinner = view.getEndDateSpinner();
        btnFilter = view.getBtnFilter();
        libroDiarioTableModel = new LibroDiarioTableModel();
        libroDiarioTable.setModel(libroDiarioTableModel);
        initialize();
        loadData();
    }

    private void initialize() {
        libroDiarioTable.setDefaultRenderer(BigDecimal.class, new Util.BigDecimalRenderer());
        btnFilter.addActionListener(e -> {
            loadData();
        });
        restarDateToSpinners(starDateSpinner, endDateSpinner);
    }

    public void loadData() {
        var data = LibroDiarioRepo.find(
                LibroDiarioRepo.Field.ASIENTO_FECHA,
                OrderDirection.ASCENDING,
                new LibroDiarioRepo.Filter.ByFechaRange((LocalDate) starDateSpinner.getValue(), (LocalDate) endDateSpinner.getValue()));

        SwingUtilities.invokeLater(() -> {
            libroDiarioTableModel.setData(data);
        });
    }

    public class LibroDiarioTableModel extends AbstractTableModel {
        /**
         * lista de datos a mostrar en la base de datos
         */
        private List<LibroDiarioDTO> data;

        public LibroDiarioTableModel() {
            this.data = List.of();
        }

        public LibroDiarioTableModel(List<LibroDiarioDTO> data) {
            this.data = data != null ? data : List.of();
        }


        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return LibroDiarioRepo.Field.values().length;
        }

        @Override
        public String getColumnName(int column) {
            return LibroDiarioRepo.Field.values()[column].getFieldName();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            LibroDiarioDTO dto = data.get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.asientoFecha();
                case 1 -> dto.tipoDocumentoNombre();
                case 2 -> dto.cuentaId();
                case 3 -> dto.registroComprobante();
                case 4 -> dto.registroReferencia();
                case 5 -> dto.registroDebe();
                case 6 -> dto.registroHaber();
                default -> null;
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> LocalDate.class;
                case 1, 2, 3, 4 -> String.class;
                case 5, 6 -> BigDecimal.class;
                default -> Object.class;
            };
        }

        /**
         * Inserta los nuevos datos a la tabla y llama a {@code fireTableDataChanged()}, para que la tabla se vuelva a renderzar
         *
         * @param newData lista de datos a mostrar
         */

        public void setData(List<LibroDiarioDTO> newData) {
            data = newData != null ? newData : List.of();
            fireTableDataChanged();
        }
    }


}
