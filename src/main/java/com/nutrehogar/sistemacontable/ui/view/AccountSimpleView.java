package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;

import javax.swing.*;

public abstract class AccountSimpleView extends CRUDSimpleView {
    public abstract JComboBox<AccountType> getCbxAccountType();

    public abstract JComboBox<AccountSubtype> getCbxAccountSubtype();

    public abstract JTextField getTxtAccountName();

    public abstract JTextField getTxtAccountId();

    public abstract JLabel getLblAccountId();

    public abstract JLabel getLblAccountName();

    public abstract JLabel getLblAccountTypeId();

    public abstract JLabel getLblAccountSubtypeId();

}
