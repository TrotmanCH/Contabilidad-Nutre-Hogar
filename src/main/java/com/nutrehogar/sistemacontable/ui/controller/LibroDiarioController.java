package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioField;
import com.nutrehogar.sistemacontable.persistence.repository.LibroDiarioRepo;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGenRepo;
import com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.components.ViewLibroDiario;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Calcifer1331
 */
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LibroDiarioController {
    static LibroDiarioController instance;
    ViewLibroDiario viewLibroDiario;
    JTable libroDiarioTable;
    LibroDiarioTableModel libroDiarioTableModel;
    LocalDateSpinner starDateSpinner;
    LocalDateSpinner endDateSpinner;
    LocalDate currentDate;
    JButton btnFilter;

    public static LibroDiarioController getInstance() {
        if (instance == null) {
            instance = new LibroDiarioController();
        }
        return instance;
    }

    {
        currentDate = LocalDate.now();
    }

    private LibroDiarioController() {
        viewLibroDiario = new ViewLibroDiario();
        libroDiarioTable = viewLibroDiario.getTableLibro();
        starDateSpinner = viewLibroDiario.getStarDateSpinner();
        endDateSpinner = viewLibroDiario.getEndDateSpinner();
        btnFilter = viewLibroDiario.getBtnFilter();
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
        restarDateToSpinners();
    }

    public void loadData() {
        List<LibroDiarioDTO> data = LibroDiarioRepo.find(
                null,
                null,
                new LibroDiarioFilter.ByFechaRange((LocalDate) starDateSpinner.getValue(), (LocalDate) endDateSpinner.getValue()));

        SwingUtilities.invokeLater(() -> {
            System.out.println("MayorGenController.loadData: " + data);
            libroDiarioTableModel.setData(data);
        });
    }

    public LocalDate getStartDateWithCurrentYear() {
        assert currentDate != null;
        return LocalDate.of(currentDate.getYear(), 1, 1);
    }

    public LocalDate getEndDateWithCurrentYear() {
        assert currentDate != null;
        return LocalDate.of(currentDate.getYear(), 12, 31);
    }

    public void restarDateToSpinners() {
        this.starDateSpinner.setValue(getStartDateWithCurrentYear());
        this.endDateSpinner.setValue(getEndDateWithCurrentYear());
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
            return LibroDiarioField.values().length;
        }

        @Override
        public String getColumnName(int column) {
            return LibroDiarioField.values()[column].getFieldName();
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
            System.out.println("MayorGenTableModel.setData: " + data);
            fireTableDataChanged();
        }
    }


}
