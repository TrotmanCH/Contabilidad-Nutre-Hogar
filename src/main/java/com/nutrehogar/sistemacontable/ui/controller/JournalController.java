package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.JournalDTO;
import com.nutrehogar.sistemacontable.domain.DocumentType;
import com.nutrehogar.sistemacontable.domain.helper.OrderDirection;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.repository.JournalRepositoryImpl;
import com.nutrehogar.sistemacontable.ui.view.JournalView;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.time.LocalDate;

public class JournalController extends BusinessController<JournalDTO> {
    public JournalController(JournalRepositoryImpl repository, JournalView view) {
        super(repository, view);
    }

    @Override
    protected void initialize() {
        setTblModel(new JournalTableModel());
        super.initialize();
    }

    @Override
    protected void loadData() {
        getData().clear();
        var lista = getRepository().find(JournalRepositoryImpl.Field.ACCOUNT_ID, OrderDirection.ASCENDING, new JournalRepositoryImpl.Filter.ByDateRange(getSpnModelStartPeriod().getValue(), getSpnModelEndPeriod().getValue()));
        setData(lista);
        super.loadData();
    }

    @Override
    protected void setElementSelected(@NotNull MouseEvent e) {
        int row = getTblData().rowAtPoint(e.getPoint());
        if (row != -1) {
            int selectedRow = getTblData().getSelectedRow();
            if (selectedRow >= 0 && selectedRow < getData().size()) {
                setSelected(getData().get(selectedRow));
                getBtnEdit().setEnabled(true);
            } else {
                getBtnEdit().setEnabled(false);
            }
        }
    }

    public class JournalTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return getData().size();
        }

        @Override
        public int getColumnCount() {
            return JournalRepositoryImpl.Field.values().length;
        }

        @Override
        public String getColumnName(int column) {
            return JournalRepositoryImpl.Field.values()[column].getFieldName();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var dto = getData().get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.journalEntryFecha();
                case 1 -> dto.ledgerRecordDocumentType();
                case 2 -> Account.getCellRenderer(dto.accountId());
                case 3 -> dto.ledgerRecordVoucher();
                case 4 -> dto.ledgerRecordReference();
                case 5 -> dto.ledgerRecordDebit();
                case 6 -> dto.ledgerRecordCredit();
                default -> "Element not found";
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> LocalDate.class;
                case 1 -> DocumentType.class;
                case 2, 3, 4 -> String.class;
                case 5, 6 -> BigDecimal.class;
                default -> Object.class;
            };
        }
    }

    @Override
    public JournalView getView() {
        return (JournalView) super.getView();
    }

    @Override
    public JournalRepositoryImpl getRepository() {
        return (JournalRepositoryImpl) super.getRepository();
    }
}
