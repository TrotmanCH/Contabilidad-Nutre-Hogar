package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.AccountType;

import javax.swing.*;

public abstract class AccountSubtypeSimpleView extends CRUDSimpleView {
    public abstract JComboBox<AccountType> getCbxAccountType();

    public abstract JTextField getTxtAccountSubtypeId();

    public abstract JTextField getTxtAccountSubtypeName();

    public abstract JLabel getLblAccountTypeId();
}
