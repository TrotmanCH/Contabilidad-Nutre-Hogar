package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;

import javax.swing.*;

public abstract class GeneralLedgerSimpleView extends BusinessSimpleView {
    public abstract JComboBox<AccountType> getCbxAccountType();

    public abstract JComboBox<AccountSubtype> getCbxAccountSubtype();

    public abstract JComboBox<Account> getCbxAccount();

}
