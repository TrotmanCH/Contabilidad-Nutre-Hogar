package com.nutrehogar.sistemacontable.ui.view;

import javax.swing.*;

public abstract class DashboardView extends View {
    public abstract JButton getBtnShowFormView();

    public abstract JButton getBtnShowJournalView();

    public abstract JButton getBtnShowTrialBalanceView();

    public abstract JButton getBtnShowGeneralLedgerView();

    public abstract JButton getBtnShowAccountView();

    public abstract JButton getBtnShowAccountSubtypeView();

    public abstract JButton getBtnShowBackupView();

    public abstract JPanel getPnlContent();
}
