package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;

import javax.swing.*;

public interface AccountView extends CRUDView {
    JComboBox<AccountType> getCbxAccountType();

    JComboBox<AccountSubtype> getCbxAccountSubtype();

    JTextField getTxtAccountName();

    JTextField getTxtAccountId();

    JLabel getLblAccountId();

    JLabel getLblAccountName();

    JLabel getLblAccountTypeId();

    JLabel getLblAccountSubtypeId();

}
