package com.nutrehogar.sistemacontable.application.controller.crud;

import com.nutrehogar.sistemacontable.application.repository.crud.AccountSubtypeRepository;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import com.nutrehogar.sistemacontable.ui.components.CustomComboBoxModel;
import com.nutrehogar.sistemacontable.ui.components.CustomListCellRenderer;
import com.nutrehogar.sistemacontable.ui.components.DocumentSizeFilter;
import com.nutrehogar.sistemacontable.domain.helper.AccountSubtypeIdComparator;
import com.nutrehogar.sistemacontable.ui.view.crud.AccountSubtypeView;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.PlainDocument;

public class AccountSubtypeController extends CRUDController<AccountSubtype, Integer> {
    private CustomComboBoxModel<AccountType> cbxModelAccountType;
    private DocumentSizeFilter documentSizeFilter;

    public AccountSubtypeController(AccountSubtypeRepository repository, AccountSubtypeView view) {
        super(repository, view);
        setTextToLbAccountTypeId();
        prepareToAdd();
    }

    @Override
    protected void initialize() {
        setTblModel(new AccountSubtypeTableModel());
        cbxModelAccountType = new CustomComboBoxModel<>(AccountType.values());
        documentSizeFilter = new DocumentSizeFilter(AccountSubtype.MAX_CANONICAL_ID_LENGTH);
        super.initialize();
    }

    @Override
    protected void updateView() {
        getData().sort(new AccountSubtypeIdComparator());
        super.updateView();
    }

    @Override
    protected void setupViewListeners() {
        super.setupViewListeners();
        getCbxAccountType().setRenderer(new CustomListCellRenderer());
        getCbxAccountType().setModel(cbxModelAccountType);
        getCbxAccountType().addItemListener(e -> {
            setTextToLbAccountTypeId();
        });
        ((PlainDocument) getTxtAccountSubtypeId().getDocument()).setDocumentFilter(documentSizeFilter);
    }

    private void setTextToLbAccountTypeId() {
        if (cbxModelAccountType.getSelectedItem() == null) return;
        var id = cbxModelAccountType.getSelectedItem().getId();
        getView().getLblAccountTypeId().setText(id + ".");
    }

    @Override
    protected void prepareToEdit() {
        super.prepareToEdit();
        getTxtAccountSubtypeName().setText(getSelected().getName());
        getTxtAccountSubtypeId().setText(getSelected().getCanonicalId());
        getTxtAccountSubtypeId().setEnabled(false);
        getCbxAccountType().setEnabled(false);
        AccountType accountType = getSelected().getAccountType();
        getCbxAccountType().setSelectedItem(accountType != null ? accountType : AccountType.ASSETS);
    }

    @Override
    protected void prepareToAdd() {
        super.prepareToAdd();
        getTxtAccountSubtypeId().setEnabled(true);
        getCbxAccountType().setEnabled(true);
        getTxtAccountSubtypeName().setText("");
        getTxtAccountSubtypeId().setText("");
        getCbxAccountType().setSelectedItem(AccountType.ASSETS);
    }

    @Override
    protected Integer prepareToDelete() {
        return getSelected().getId();
    }


    @Override
    protected AccountSubtype prepareToSave() {
        int id;
        try {
            id = Integer.parseInt(getTxtAccountSubtypeId().getText());
        } catch (NumberFormatException e) {
            showMessage("El Codigo tiene que ser un numero.");
            return null;
        }
        if (cbxModelAccountType.getSelectedItem() == null || getTxtAccountSubtypeName().getText().isBlank()) {
            showMessage("Ningun campo puede estar vacio.");
            return null;
        }

        var accountSubtype = new AccountSubtype();
        accountSubtype.setAccountType(cbxModelAccountType.getSelectedItem());
        try {
            accountSubtype.setId(id);
        } catch (IllegalArgumentException e) {
            showMessage(e.getMessage());
            return null;
        }

        if (getRepository().existsById(accountSubtype.getId())) {
            showMessage("Ya existe un subtipo cuenta con el codigo: " + accountSubtype.getId());
            return null;
        }

        accountSubtype.setName(getTxtAccountSubtypeName().getText());
        return accountSubtype;
    }

    @Override
    protected AccountSubtype prepareToUpdate() {
        if (getTxtAccountSubtypeName().getText().isBlank()) {
            showMessage("Ningun campo puede estar vacio.");
            return null;
        }
        getSelected().setName(getTxtAccountSubtypeName().getText());
        return getSelected();
    }

    public class AccountSubtypeTableModel extends AbstractTableModel {

        private final String[] COLUMN_NAMES =
                {
                        "Código", "Nombre", "Tipo de Cuenta"
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
                case 2 -> dto.getAccountType().getName();
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

    @Override
    public AccountSubtypeView getView() {
        return (AccountSubtypeView) super.getView();
    }

    @Override
    public AccountSubtypeRepository getRepository() {
        return (AccountSubtypeRepository) super.getRepository();
    }

    public JComboBox<AccountType> getCbxAccountType() {
        return getView().getCbxAccountType();
    }

    public JTextField getTxtAccountSubtypeId() {
        return getView().getTxtAccountSubtypeId();
    }

    public JTextField getTxtAccountSubtypeName() {
        return getView().getTxtAccountSubtypeName();
    }
}
