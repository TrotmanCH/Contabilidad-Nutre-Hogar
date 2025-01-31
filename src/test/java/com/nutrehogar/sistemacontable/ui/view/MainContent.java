/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
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
import com.nutrehogar.sistemacontable.ui.controller.*;
import com.nutrehogar.sistemacontable.ui.view.defaultImple.*;
import org.hibernate.Session;

import java.awt.*;
import java.util.function.Consumer;
import javax.swing.*;

/**
 * @author Calci
 */
public class MainContent extends javax.swing.JFrame {
    Session session;

    AccountSubtypeRepository subTipoRepository;
    LedgerRecordRepository ledgerRecordRepository;
    JournalEntryRepository journalEntryRepository;
    AccountRepository accountRepository;

    GeneralLedgerRepositoryImpl generalLedgerRepository;
    JournalRepositoryImpl journalRepository;
    TrialBalanceRepositoryImpl trialBalanceRepository;

    AccountingEntryFormSimpleController accountingEntryFormController;
    AccountSimpleController accountController;
    AccountSubtypeSimpleController accountSubtypeController;
    JournalSimpleController journalController;
    TrialBalanceSimpleController trialBalanceController;
    GeneralLedgerSimpleController generalLedgerController;
    AccountingEntryFormSimpleView accountingEntryFormView;

    AccountSimpleView accountView;
    AccountSubtypeSimpleView accountSubtypeView;
    JournalSimpleView journalView;
    TrialBalanceSimpleView trialBalanceView;
    GeneralLedgerSimpleView generalLedgerView;

    private final Consumer<Integer> prepareToEditJournalEntry;

    /**
     * Creates new form MainContent
     */
    public MainContent() {
        initComponents();

        session = HibernateUtil.getSession();

        accountRepository = CRUDRepositoryFactory.createRepository(AccountRepository.class, Account.class, session);
        subTipoRepository = CRUDRepositoryFactory.createRepository(AccountSubtypeRepository.class, AccountSubtype.class, session);
        ledgerRecordRepository = CRUDRepositoryFactory.createRepository(LedgerRecordRepository.class, LedgerRecord.class, session);
        journalEntryRepository = CRUDRepositoryFactory.createRepository(JournalEntryRepository.class, JournalEntry.class, session);
        generalLedgerRepository = new GeneralLedgerRepositoryImpl(session);
        journalRepository = new JournalRepositoryImpl(session);
        trialBalanceRepository = new TrialBalanceRepositoryImpl(session);

        accountingEntryFormView = new DefaultAccountEntryFormSimpleView();
        accountView = new DefaultAccountSimpleView();
        accountSubtypeView = new DefaultAccountSubtypeSimpleView();
        journalView = new DefaultJournalSimpleView();
        trialBalanceView = new DefaultTrialBalanceSimpleView();
        generalLedgerView = new DefaultGeneralLedgerSimpleView();

        accountingEntryFormController = new AccountingEntryFormSimpleController(ledgerRecordRepository, accountingEntryFormView, journalEntryRepository, accountRepository);
        prepareToEditJournalEntry = (Integer JournalEntryId) -> {
            setContent(accountingEntryFormController.getView());
            accountingEntryFormController.prepareToEditEntry(JournalEntryId);
        };
        accountController = new AccountSimpleController(accountRepository, accountView, subTipoRepository);
        accountSubtypeController = new AccountSubtypeSimpleController(subTipoRepository, accountSubtypeView);
        generalLedgerController = new GeneralLedgerSimpleController(generalLedgerRepository, generalLedgerView, prepareToEditJournalEntry, subTipoRepository);
        trialBalanceController = new TrialBalanceSimpleController(trialBalanceRepository, trialBalanceView, prepareToEditJournalEntry);
        journalController = new JournalSimpleController(journalRepository, journalView, prepareToEditJournalEntry);
    }

    public void setContent(JPanel p) {
        content.removeAll();
        content.setLayout(new BorderLayout());  // Añade esta línea para restablecer el diseño del Content
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        content = new javax.swing.JPanel();
        btnAccountView = new javax.swing.JButton();
        btnTrialBalance = new javax.swing.JButton();
        btnJournal = new javax.swing.JButton();
        btnGeneralLedger = new javax.swing.JButton();
        btnAccountSubtype = new javax.swing.JButton();
        btnForm = new javax.swing.JButton();
        btnLoadData = new javax.swing.JButton();
        txtJounelEntryId = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        btnAccountView.setText("AccountView");
        btnAccountView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountViewActionPerformed(evt);
            }
        });

        btnTrialBalance.setText("TrialBalance");
        btnTrialBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTrialBalanceActionPerformed(evt);
            }
        });

        btnJournal.setText("Journal");
        btnJournal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJournalActionPerformed(evt);
            }
        });

        btnGeneralLedger.setText("GeneralLedger");
        btnGeneralLedger.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGeneralLedgerActionPerformed(evt);
            }
        });

        btnAccountSubtype.setText("AccountSubtypeView");
        btnAccountSubtype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccountSubtypeActionPerformed(evt);
            }
        });

        btnForm.setText("Form");
        btnForm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFormActionPerformed(evt);
            }
        });

        btnLoadData.setText("load");
        btnLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadDataActionPerformed(evt);
            }
        });

        txtJounelEntryId.setText("95");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnAccountView)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTrialBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnJournal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGeneralLedger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAccountSubtype)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnForm)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLoadData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtJounelEntryId, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAccountView)
                    .addComponent(btnTrialBalance)
                    .addComponent(btnJournal)
                    .addComponent(btnGeneralLedger)
                    .addComponent(btnAccountSubtype)
                    .addComponent(btnForm)
                    .addComponent(btnLoadData)
                    .addComponent(txtJounelEntryId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAccountViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountViewActionPerformed
        setContent(accountView);
    }//GEN-LAST:event_btnAccountViewActionPerformed

    private void btnTrialBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTrialBalanceActionPerformed
        setContent(trialBalanceView);
    }//GEN-LAST:event_btnTrialBalanceActionPerformed

    private void btnJournalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJournalActionPerformed
        setContent(journalView);
    }//GEN-LAST:event_btnJournalActionPerformed

    private void btnGeneralLedgerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGeneralLedgerActionPerformed
        setContent(generalLedgerView);
    }//GEN-LAST:event_btnGeneralLedgerActionPerformed

    private void btnAccountSubtypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccountSubtypeActionPerformed
        setContent(accountSubtypeView);
    }//GEN-LAST:event_btnAccountSubtypeActionPerformed

    private void btnFormActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFormActionPerformed
        setContent(accountingEntryFormController.getView());
    }//GEN-LAST:event_btnFormActionPerformed

    private void btnLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadDataActionPerformed
        prepareToEditJournalEntry.accept(Integer.parseInt(txtJounelEntryId.getText()));
    }//GEN-LAST:event_btnLoadDataActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        System.setProperty("flatlaf.useWindowDecorations", "true");
        FlatLightLaf.setup();
        EventQueue.invokeLater(() -> new MainContent().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccountSubtype;
    private javax.swing.JButton btnAccountView;
    private javax.swing.JButton btnForm;
    private javax.swing.JButton btnGeneralLedger;
    private javax.swing.JButton btnJournal;
    private javax.swing.JButton btnLoadData;
    private javax.swing.JButton btnTrialBalance;
    private static javax.swing.JPanel content;
    private javax.swing.JTextField txtJounelEntryId;
    // End of variables declaration//GEN-END:variables
}
