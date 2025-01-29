package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.TrialBalanceDTO;
import com.nutrehogar.sistemacontable.domain.DocumentType;
import com.nutrehogar.sistemacontable.domain.helper.OrderDirection;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.repository.TrialBalanceRepositoryImpl;
import com.nutrehogar.sistemacontable.ui.view.TrialBalanceView;
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

public class TrialBalanceController extends BusinessController<TrialBalanceDTO> {

    public TrialBalanceController(TrialBalanceRepositoryImpl repository, TrialBalanceView view) {
        super(repository, view);
    }

    @Override
    protected void initialize() {
        setTblModel(new TrialBalanceTableModel());
        super.initialize();
    }

    @Override
    protected void loadData() {
        getData().clear();
        var list = getRepository().find(TrialBalanceRepositoryImpl.Field.ACCOUNT_ID, OrderDirection.ASCENDING, new TrialBalanceRepositoryImpl.Filter.ByDateRange(getSpnModelStartPeriod().getValue(), getSpnModelEndPeriod().getValue()));

        Map<Integer, List<TrialBalanceDTO>> agrupadoPorCuenta = list.stream().collect(Collectors.groupingBy(TrialBalanceDTO::getAccountId));

        agrupadoPorCuenta.forEach((cuentaId, listaBalances) -> {
            var balance = BigDecimal.ZERO;
            var debitSum = BigDecimal.ZERO;
            var creditSum = BigDecimal.ZERO;

            for (TrialBalanceDTO dto : listaBalances) {
                balance = dto.getAccountType().getSaldo(balance, dto.getLedgerRecordCredit(), dto.getLedgerRecordDebit());
                debitSum = debitSum.add(dto.getLedgerRecordDebit(), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
                creditSum = creditSum.add(dto.getLedgerRecordCredit(), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
                dto.setBalance(balance);
                getData().add(dto);
            }

            TrialBalanceDTO totalDTO = new TrialBalanceDTO("TOTAL", // referencia
                    debitSum, // suma debe
                    creditSum, // suma haber
                    balance // diferencia
            );
            getData().add(totalDTO);
            getData().add(new TrialBalanceDTO("", null, null, null));
        });
        super.loadData();
    }

    @Override
    protected void setElementSelected(@NotNull MouseEvent e) {
        int row = getTblData().rowAtPoint(e.getPoint());
        if (row != -1) {
            int selectedRow = getTblData().getSelectedRow();
            if (selectedRow < 0) {
                getBtnEdit().setEnabled(false);
                return;
            }
            var selected = getData().get(selectedRow);
            if (selected.getJournalDate() == null) {
                getBtnEdit().setEnabled(false);
                return;
            }
            setSelected(selected);
            getBtnEdit().setEnabled(true);
        }
    }


    public class TrialBalanceTableModel extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return getData().size();
        }

        @Override
        public int getColumnCount() {
            return TrialBalanceRepositoryImpl.Field.values().length;
        }

        @Override
        public String getColumnName(int column) {
            return TrialBalanceRepositoryImpl.Field.values()[column].getFieldName();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var dto = getData().get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.getJournalDate();
                case 1 -> dto.getLedgeRecordDocumentType();
                case 2 -> Account.getCellRenderer(dto.getAccountId());
                case 3 -> dto.getAccountName();
                case 4 -> dto.getLedgerRecordReference();
                case 5 -> dto.getLedgerRecordDebit();
                case 6 -> dto.getLedgerRecordCredit();
                case 7 -> dto.getBalance();
                default -> "Element not found";
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> LocalDate.class;
                case 1 -> DocumentType.class;
                case 2, 3, 4 -> String.class;
                case 5, 6, 7 -> BigDecimal.class;
                default -> Object.class;
            };
        }
    }

    @Override
    public TrialBalanceView getView() {
        return (TrialBalanceView) super.getView();
    }

    @Override
    public TrialBalanceRepositoryImpl getRepository() {
        return (TrialBalanceRepositoryImpl) super.getRepository();
    }

}
