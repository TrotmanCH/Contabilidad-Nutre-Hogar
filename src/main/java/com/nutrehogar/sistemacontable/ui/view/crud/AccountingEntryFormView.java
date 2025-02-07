package com.nutrehogar.sistemacontable.ui.view.crud;

import com.nutrehogar.sistemacontable.domain.DocumentType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;

import javax.swing.*;

public abstract class AccountingEntryFormView extends CRUDView {
    public abstract JTextField getTxtEntryCheckNumber();

    public abstract LocalDateSpinner getSpnEntryDate();

    public abstract JTextField getTxtEntryDocumentNumber();

    public abstract JTextField getTxtEntryName();

    public abstract JTextField getTxtRecordAmount();

    public abstract JTextField getTxtRecordReference();

    public abstract JTextField getTxtRecordVoucher();

    public abstract JTextArea getTaEntryConcept();

    public abstract JRadioButton getRbtRecordCredit();

    public abstract JRadioButton getRbtRecordDebit();

    public abstract JButton getBtnSaveEntry();

    public abstract JButton getBtnDeleteEntry();

    public abstract JButton getBtnUpdateEntry();

    public abstract JButton getBtnAddEntry();

    public abstract JButton getBtnGeneratePaymentVoucher();

    public abstract JButton getBtnGenerateRegistrationForm();

    public abstract JComboBox<Account> getCbxRecordAccount();

    public abstract JComboBox<DocumentType> getCbxRecordDocumentType();

    public abstract ButtonGroup getBgRecordType();

}
