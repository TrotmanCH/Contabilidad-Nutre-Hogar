package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.AccountType;

import javax.swing.*;

public interface AccountSubtypeView extends CRUDView {
    JComboBox<AccountType> getCbxAccountType();

    JTextField getTxtAccountSubtypeId();

    JTextField getTxtAccountSubtypeName();

    JLabel getLblAccountTypeId();

}
