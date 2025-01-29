package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.repository.crud.AccountRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountSubtypeRepository;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import com.nutrehogar.sistemacontable.ui.components.CustomComboBoxModel;
import com.nutrehogar.sistemacontable.ui.components.CustomListCellRenderer;
import com.nutrehogar.sistemacontable.ui.view.AccountView;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;
import java.awt.event.MouseEvent;
import java.util.List;

public class AccountController extends CRUDController<Account, Integer> {
    private final AccountSubtypeRepository subtypeRepository;
    private CustomComboBoxModel<AccountType> cbxModelAccountType;
    private CustomComboBoxModel<AccountSubtype> cbxModelSubtype;
    private DocumentSizeFilter documentSizeFilter;

    public AccountController(AccountRepository repository, AccountView view, AccountSubtypeRepository subtypeRepository) {
        super(repository, view);
        this.subtypeRepository = subtypeRepository;
        loadDataSubtype();
        setTextToLbAccountTypeId();
        setTextToLbAccountSubtypeId();
        prepareToAdd();
    }

    private void loadDataSubtype() {
        var accountType = cbxModelAccountType.getSelectedItem();
        List<AccountSubtype> list = subtypeRepository.findAllByAccountType(accountType != null ? accountType : AccountType.ASSETS);
        cbxModelSubtype.setData(list);
    }

    @Override
    protected void initialize() {
        setTblModel(new AccountTableModel());
        cbxModelAccountType = new CustomComboBoxModel<>(AccountType.values());
        cbxModelSubtype = new CustomComboBoxModel<>(List.of());
        documentSizeFilter = new DocumentSizeFilter(Account.MAX_ACCOUNT_ID_LENGTH);
        super.initialize();
    }

    @Override
    protected void loadData() {
        super.loadData();
    }


    @Override
    protected void setupViewListeners() {
        super.setupViewListeners();
        getCbxAccountType().setRenderer(new CustomListCellRenderer());
        getCbxAccountSubtype().setRenderer(new CustomListCellRenderer());
        getCbxAccountType().setModel(cbxModelAccountType);
        getCbxAccountSubtype().setModel(cbxModelSubtype);
        getCbxAccountType().addItemListener(e -> {
            loadDataSubtype();
            setTextToLbAccountTypeId();
        });
        getCbxAccountSubtype().addItemListener(e -> {
            setTextToLbAccountSubtypeId();
        });
        ((PlainDocument) getTxtAccountId().getDocument()).setDocumentFilter(documentSizeFilter);
    }

    public void setTextToLbAccountTypeId() {
        if (cbxModelAccountType.getSelectedItem() == null) return;
        var id = cbxModelAccountType.getSelectedItem().getId();
        getView().getLblAccountTypeId().setText(id + ".");

    }

    public void setTextToLbAccountSubtypeId() {
        if (cbxModelSubtype.getSelectedItem() == null) return;
        var id = cbxModelSubtype.getSelectedItem().getCanonicalId();
        getView().getLblAccountSubtypeId().setText(id);
        int size = Account.MAX_ACCOUNT_ID_LENGTH - cbxModelSubtype.getSelectedItem().getId().toString().length();
        documentSizeFilter.setMaxCaracteres(size);

        getTxtAccountId().setText(getTxtAccountId().getText().length() <= size ? getTxtAccountId().getText() : "");
    }

    @Override
    protected void setElementSelected(@NotNull MouseEvent e) {
        int row = getTblData().rowAtPoint(e.getPoint());
        if (row != -1) {
            int selectedRow = getTblData().getSelectedRow();
            if (selectedRow < 0) {
                deselect();
                return;
            }
            var selected = getData().get(selectedRow);
            if (selected.getId() == null) {
                deselect();
                return;
            }
            setSelected(selected);
        }
    }

    @Override
    protected void prepareToEdit() {
        getTxtAccountName().setText(getSelected().getName());
        getTxtAccountId().setText(getSelected().getCanonicalId());
        getBtnUpdate().setEnabled(true);
        getBtnSave().setEnabled(false);
        getTxtAccountId().setEnabled(false);
        getCbxAccountType().setEnabled(false);
        getCbxAccountSubtype().setEnabled(false);
        AccountType accountType = getSelected().getAccountSubtype().getAccountType();
        getCbxAccountType().setSelectedItem(accountType != null ? accountType : AccountType.ASSETS);
        cbxModelSubtype.setData(subtypeRepository.findAllByAccountType(accountType != null ? accountType : AccountType.ASSETS));
        getCbxAccountSubtype().setSelectedItem(getSelected().getAccountSubtype());
    }

    @Override
    protected void prepareToAdd() {
        deselect();
        getBtnUpdate().setEnabled(false);
        getBtnSave().setEnabled(true);
        getTxtAccountId().setEnabled(true);
        getCbxAccountType().setEnabled(true);
        getCbxAccountSubtype().setEnabled(true);
        getTxtAccountName().setText("");
        getTxtAccountId().setText("");
        getCbxAccountType().setSelectedItem(AccountType.ASSETS);
        loadDataSubtype();
    }

    @Override
    protected Integer prepareToDelete() {
        return getSelected().getId();
    }


    @Override
    protected Account prepareToSave() {
        int id;
        try {
            id = Integer.parseInt(getTxtAccountId().getText());
        } catch (NumberFormatException e) {
            showMessage("El Codigo tiene que ser un numero.");
            return null;
        }
        if (cbxModelSubtype.getSelectedItem() == null || getTxtAccountName().getText().isBlank()) {
            showMessage("Ningun campo puede estar vacio.");
            return null;
        }

        var account = new Account();
        account.setAccountSubtype(cbxModelSubtype.getSelectedItem());
        try {
            account.setId(id);
        } catch (IllegalArgumentException e) {
            showMessage(e.getMessage());
            return null;
        }

        if (getRepository().existsById(account.getId())) {
            showMessage("Ya existe una cuenta con el codigo: " + account.getId());
            return null;
        }

        account.setName(getTxtAccountName().getText());
        return account;
    }

    @Override
    protected Account prepareToUpdate() {
        if (getTxtAccountName().getText().isBlank()) {
            showMessage("Ningun campo puede estar vacio.");
            return null;
        }
        getSelected().setName(getTxtAccountName().getText());
        return getSelected();
    }

    public class AccountTableModel extends AbstractTableModel {

        private final String[] COLUMN_NAMES =
                {
                        "Código", "Nombre", "Tipo de Cuenta", "Subtipo de Cuenta"
                };

        @Override
        public int getRowCount() {
            return getData().size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var dto = getData().get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.getFormattedId();
                case 1 -> dto.getName();
                case 2 -> dto.getAccountSubtype().getAccountType();
                case 3 -> dto.getAccountSubtype().getName();
                default -> "que haces?";
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 2 -> AccountType.class;
                default -> String.class;
            };
        }
    }



    @Setter
    static class DocumentSizeFilter extends DocumentFilter {
        private int maxCaracteres; // Límite de 10 caracteres

        public DocumentSizeFilter(int maxCaracteres) {
            this.maxCaracteres = maxCaracteres;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("\\d*") && (fb.getDocument().getLength() + string.length()) <= maxCaracteres) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("\\d*") && (fb.getDocument().getLength() + text.length() - length) <= maxCaracteres) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    @Override
    public AccountView getView() {
        return (AccountView) super.getView();
    }

    @Override
    public AccountRepository getRepository() {
        return (AccountRepository) super.getRepository();
    }

    public JComboBox<AccountSubtype> getCbxAccountSubtype() {
        return getView().getCbxAccountSubtype();
    }

    public JComboBox<AccountType> getCbxAccountType() {
        return getView().getCbxAccountType();
    }

    public JTextField getTxtAccountId() {
        return getView().getTxtAccountId();
    }

    public JTextField getTxtAccountName() {
        return getView().getTxtAccountName();
    }
}
