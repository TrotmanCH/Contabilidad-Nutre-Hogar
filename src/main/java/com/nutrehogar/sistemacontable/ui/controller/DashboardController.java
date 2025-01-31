package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.ui.view.*;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public class DashboardController extends Controller{
    private final AccountingEntryFormSimpleController accountingEntryFormController;
    private final AccountSimpleController accountController;
    private final AccountSubtypeSimpleController accountSubtypeController;
    private final JournalSimpleController journalController;
    private final TrialBalanceSimpleController trialBalanceController;
    private final GeneralLedgerSimpleController generalLedgerController;
    private final BackupController backupController;

    public DashboardController(DashboardView view, AccountingEntryFormSimpleController accountingEntryFormController, AccountSimpleController accountController, AccountSubtypeSimpleController accountSubtypeController, JournalSimpleController journalController, TrialBalanceSimpleController trialBalanceController, GeneralLedgerSimpleController generalLedgerController, BackupController backupController) {
        super(view);
        this.accountingEntryFormController = accountingEntryFormController;
        this.accountController = accountController;
        this.accountSubtypeController = accountSubtypeController;
        this.journalController = journalController;
        this.trialBalanceController = trialBalanceController;
        this.generalLedgerController = generalLedgerController;
        this.backupController = backupController;
    }

    protected void setupViewListeners() {
        getBtnShowFormView().addActionListener(e -> setContent(accountingEntryFormController.getView()));
        getBtnShowAccountSubtypeView().addActionListener(e -> setContent(accountSubtypeController.getView()));
        getBtnShowAccountView().addActionListener(e -> setContent(accountController.getView()));
        getBtnShowJournalView().addActionListener(e -> setContent(journalController.getView()));
        getBtnShowTrialBalanceView().addActionListener(e -> setContent(trialBalanceController.getView()));
        getBtnShowGeneralLedgerView().addActionListener(e -> setContent(generalLedgerController.getView()));
        getBtnShowBackupView().addActionListener(e -> setContent(backupController.getView()));
    }

    public void setContent(JPanel p) {
        getPnlContent().removeAll();
        getPnlContent().setLayout(new BorderLayout());
        getPnlContent().add(p, BorderLayout.CENTER);
        getPnlContent().revalidate();
        getPnlContent().repaint();
    }

    @Override
    public DashboardView getView() {
        return (DashboardView) super.getView();
    }

    public JButton getBtnShowFormView() {
        return getView().getBtnShowFormView();
    }

    public JButton getBtnShowJournalView() {
        return getView().getBtnShowJournalView();
    }

    public JButton getBtnShowTrialBalanceView() {
        return getView().getBtnShowTrialBalanceView();
    }

    public JButton getBtnShowGeneralLedgerView() {
        return getView().getBtnShowGeneralLedgerView();
    }

    public JButton getBtnShowAccountView() {
        return getView().getBtnShowAccountView();
    }

    public JButton getBtnShowAccountSubtypeView() {
        return getView().getBtnShowAccountSubtypeView();
    }

    public JButton getBtnShowBackupView() {
        return getView().getBtnShowBackupView();
    }

    public JPanel getPnlContent() {
        return getView().getPnlContent();
    }
}
