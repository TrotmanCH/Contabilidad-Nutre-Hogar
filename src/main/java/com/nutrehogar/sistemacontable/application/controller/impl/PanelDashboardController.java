package com.nutrehogar.sistemacontable.application.controller.impl;

import com.nutrehogar.sistemacontable.application.controller.BackupController;
import com.nutrehogar.sistemacontable.application.controller.DashboardController;
import com.nutrehogar.sistemacontable.application.controller.business.GeneralLedgerController;
import com.nutrehogar.sistemacontable.application.controller.business.JournalController;
import com.nutrehogar.sistemacontable.application.controller.business.TrialBalanceController;
import com.nutrehogar.sistemacontable.application.controller.crud.AccountController;
import com.nutrehogar.sistemacontable.application.controller.crud.AccountSubtypeController;
import com.nutrehogar.sistemacontable.application.controller.crud.AccountingEntryFormController;
import com.nutrehogar.sistemacontable.ui.view.imple.PanelDashboardView;

import javax.swing.*;
import java.awt.*;

public class PanelDashboardController extends DashboardController {
    public PanelDashboardController(PanelDashboardView view, AccountingEntryFormController accountingEntryFormController, AccountController accountController, AccountSubtypeController accountSubtypeController, JournalController journalController, TrialBalanceController trialBalanceController, GeneralLedgerController generalLedgerController, BackupController backupController) {
        super(view, accountingEntryFormController, accountController, accountSubtypeController, journalController, trialBalanceController, generalLedgerController, backupController);
    }

    @Override
    protected void initialize() {
        getBtnHome().setEnabled(false);
        super.initialize();
    }

    @Override
    protected void setupViewListeners() {
        super.setupViewListeners();
        getBtnHome().addActionListener(e -> {
            setContent(getPnlHome());
        });
    }

    @Override
    public void setContent(JPanel p) {
        if (p != getPnlHome()) {
            getBtnHome().setEnabled(true);
        } else {
            getBtnHome().setEnabled(false);
            getBtnShowFormView().setBackground(Color.WHITE);
            getBtnShowJournalView().setBackground(Color.WHITE);
            getBtnShowTrialBalanceView().setBackground(Color.WHITE);
            getBtnShowGeneralLedgerView().setBackground(Color.WHITE);
            getBtnShowAccountView().setBackground(Color.WHITE);
            getBtnShowAccountSubtypeView().setBackground(Color.WHITE);
        }
        super.setContent(p);
    }

    @Override
    public PanelDashboardView getView() {
        return (PanelDashboardView) super.getView();
    }

    public JButton getBtnHome() {
        return getView().getBtnHome();
    }

    public JPanel getPnlHome() {
        return getView().getPnlHome();
    }
}
