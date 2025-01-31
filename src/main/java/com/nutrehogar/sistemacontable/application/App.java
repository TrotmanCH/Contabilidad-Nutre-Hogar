package com.nutrehogar.sistemacontable.application;

import com.formdev.flatlaf.extras.FlatSVGIcon;
import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.application.controller.*;
import com.nutrehogar.sistemacontable.application.controller.business.GeneralLedgerController;
import com.nutrehogar.sistemacontable.application.controller.business.JournalController;
import com.nutrehogar.sistemacontable.application.controller.business.TrialBalanceController;
import com.nutrehogar.sistemacontable.application.controller.crud.AccountController;
import com.nutrehogar.sistemacontable.application.controller.crud.AccountSubtypeController;
import com.nutrehogar.sistemacontable.application.controller.crud.AccountingEntryFormController;
import com.nutrehogar.sistemacontable.application.controller.impl.PanelDashboardController;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountSubtypeRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.JournalEntryRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.LedgerRecordRepository;
import com.nutrehogar.sistemacontable.domain.core.CRUDRepositoryFactory;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import com.nutrehogar.sistemacontable.domain.model.JournalEntry;
import com.nutrehogar.sistemacontable.domain.model.LedgerRecord;
import com.nutrehogar.sistemacontable.domain.repository.GeneralLedgerRepositoryImpl;
import com.nutrehogar.sistemacontable.domain.repository.JournalRepositoryImpl;
import com.nutrehogar.sistemacontable.domain.repository.TrialBalanceRepositoryImpl;
import com.nutrehogar.sistemacontable.ui.view.*;
import com.nutrehogar.sistemacontable.ui.view.business.GeneralLedgerView;
import com.nutrehogar.sistemacontable.ui.view.business.JournalView;
import com.nutrehogar.sistemacontable.ui.view.business.TrialBalanceView;
import com.nutrehogar.sistemacontable.ui.view.crud.AccountSubtypeView;
import com.nutrehogar.sistemacontable.ui.view.crud.AccountView;
import com.nutrehogar.sistemacontable.ui.view.crud.AccountingEntryFormView;
import com.nutrehogar.sistemacontable.ui.view.imple.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;

import javax.swing.*;
import java.util.function.Consumer;

@Slf4j
public class App {
    private Session session;
    private AccountRepository accountRepository;
    private AccountSubtypeRepository subTipoRepository;
    private JournalEntryRepository journalEntryRepository;
    private LedgerRecordRepository ledgerRecordRepository;
    private JournalRepositoryImpl journalRepository;
    private TrialBalanceRepositoryImpl trialBalanceRepository;
    private GeneralLedgerRepositoryImpl generalLedgerRepository;

    private AccountingEntryFormController accountingEntryFormController;
    private AccountController accountController;
    private AccountSubtypeController accountSubtypeController;
    private JournalController journalController;
    private TrialBalanceController trialBalanceController;
    private GeneralLedgerController generalLedgerController;
    private BackupController backupController;
    private DashboardController dashboardController;

    private AccountingEntryFormView accountingEntryFormView;
    private AccountView accountView;
    private AccountSubtypeView accountSubtypeView;
    private JournalView journalView;
    private TrialBalanceView trialBalanceView;
    private GeneralLedgerView generalLedgerView;
    private BackupView backupView;
    private PanelDashboardView dashboardView;

    private Consumer<Integer> prepareToEditJournalEntry;

    public App() {
        session = HibernateUtil.getSession();
        Thread.startVirtualThread(() -> Runtime.getRuntime().addShutdownHook(new Thread(HibernateUtil::shutdown)));
        setDefaultRepositories();
        setDefaultViews();
        setDefaultControllers();
        FlatSVGIcon svgLogo = new FlatSVGIcon("svgs/SistemaContableLogo.svg", 250, 250);
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setIconImage(svgLogo.getImage());
            frame.setTitle("Sistema Contable");
            frame.setSize(1300, 600);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.add(dashboardView);
            frame.setVisible(true);
        });
    }

    private void setDefaultViews() {
        accountingEntryFormView = new DefaultAccountEntryFormView();
        accountView = new DefaultAccountView();
        accountSubtypeView = new DefaultAccountSubtypeView();
        journalView = new DefaultJournalView();
        trialBalanceView = new DefaultTrialBalanceView();
        generalLedgerView = new DefaultGeneralLedgerView();
        backupView = new DefaultBackupView();
        dashboardView = new DefaultDashboardView();
    }

    private void setDefaultRepositories() {
        accountRepository = CRUDRepositoryFactory.createRepository(AccountRepository.class, Account.class, session);
        subTipoRepository = CRUDRepositoryFactory.createRepository(AccountSubtypeRepository.class, AccountSubtype.class, session);
        ledgerRecordRepository = CRUDRepositoryFactory.createRepository(LedgerRecordRepository.class, LedgerRecord.class, session);
        journalEntryRepository = CRUDRepositoryFactory.createRepository(JournalEntryRepository.class, JournalEntry.class, session);
        generalLedgerRepository = new GeneralLedgerRepositoryImpl(session);
        journalRepository = new JournalRepositoryImpl(session);
        trialBalanceRepository = new TrialBalanceRepositoryImpl(session);
    }

    private void setDefaultControllers() {
        accountingEntryFormController = new AccountingEntryFormController(ledgerRecordRepository, accountingEntryFormView, journalEntryRepository, accountRepository);
        prepareToEditJournalEntry = (Integer JournalEntryId) -> {
            dashboardController.setContent(accountingEntryFormController.getView());
            accountingEntryFormController.prepareToEditEntry(JournalEntryId);
        };
        accountController = new AccountController(accountRepository, accountView, subTipoRepository);
        accountSubtypeController = new AccountSubtypeController(subTipoRepository, accountSubtypeView);
        generalLedgerController = new GeneralLedgerController(generalLedgerRepository, generalLedgerView, prepareToEditJournalEntry, subTipoRepository);
        trialBalanceController = new TrialBalanceController(trialBalanceRepository, trialBalanceView, prepareToEditJournalEntry);
        journalController = new JournalController(journalRepository, journalView, prepareToEditJournalEntry);
        backupController = new BackupController(backupView);
        dashboardController = new PanelDashboardController(dashboardView, accountingEntryFormController, accountController, accountSubtypeController, journalController, trialBalanceController, generalLedgerController, backupController);
    }

}
