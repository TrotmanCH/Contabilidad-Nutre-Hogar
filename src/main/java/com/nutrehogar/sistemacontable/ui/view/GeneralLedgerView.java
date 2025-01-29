package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;

import javax.swing.*;

public interface GeneralLedgerView extends BusinessView {
    JComboBox<AccountType> getCbxAccountType();

    JComboBox<AccountSubtype> getCbxAccountSubtype();

    JComboBox<Account> getCbxAccount();

}
