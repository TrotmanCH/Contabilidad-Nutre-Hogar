package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import com.nutrehogar.sistemacontable.domain.repository.LibroDiarioRepo;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.LibroDiarioView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.function.Consumer;

import static com.nutrehogar.sistemacontable.application.service.Util.restarDateToSpinners;
@FieldDefaults(level = AccessLevel.PRIVATE)

public class LibroDiarioController {
    static LibroDiarioController instance;
    LibroDiarioView view;
    List<LibroDiarioDTO> data;
    LibroDiarioDTO selected;
    final JTable table;
    final LibroDiarioTableModel libroDiarioTableModel;
    final JButton editButton;
    final LocalDateSpinner starDateSpinner;
    final LocalDateSpinner endDateSpinner;
    final JButton btnFilter;

    public static LibroDiarioController getInstance() {
        if (instance == null) {
            instance = new LibroDiarioController();
        }
        return instance;
    }

    public LibroDiarioView getView(Consumer<Integer> action) {
        editButton.addActionListener(e -> action.accept((selected.asientoId())));
        return view;
    }

    private LibroDiarioController() {
        view = new LibroDiarioView();
        table = view.getTabRegistros();
        this.editButton = view.getButEdit();
        editButton.setEnabled(false);
        starDateSpinner = view.getSpiInicio();
        endDateSpinner = view.getSpiFin();
        btnFilter = view.getButFiltrar();
        libroDiarioTableModel = new LibroDiarioTableModel();
        table.setModel(libroDiarioTableModel);
        initialize();
        loadData();
        // Detectar clic derecho
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                press(e);
            }
            private void press(@NotNull MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row != -1) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0 && selectedRow < data.size()) {
                        selected = data.get(selectedRow);
                        editButton.setEnabled(true);
                    } else {
                        editButton.setEnabled(false);
                    }
                }
            }
        });
    }

    private void initialize() {
        Util.setTableRenderer(table);
        btnFilter.addActionListener(e -> loadData());
        restarDateToSpinners(starDateSpinner, endDateSpinner);
    }

    public void loadData() {
        this.data = LibroDiarioRepo.find(
                LibroDiarioRepo.Field.ASIENTO_FECHA,
                OrderDirection.ASCENDING,
                new LibroDiarioRepo.Filter.ByFechaRange((LocalDate) starDateSpinner.getValue(), (LocalDate) endDateSpinner.getValue()));
        SwingUtilities.invokeLater(() -> libroDiarioTableModel.setData(this.data));
    }

    public static class LibroDiarioTableModel extends AbstractTableModel {
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
