package com.nutrehogar.sistemacontable.ui.controller;


import com.nutrehogar.sistemacontable.application.repository.SimpleRepository;
import com.nutrehogar.sistemacontable.ui.view.View;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public abstract class Controller<T> {
    private final View view;
    private final SimpleRepository<T> repository;
    private List<T> data = new ArrayList<>();
    private T selected;
    private AbstractTableModel tableModel;

    protected Controller(SimpleRepository<T> repository, View view) {
        this.repository = repository;
        this.view = view;
        initialize();
    }

    protected void initialize() {
        getTable().setModel(getTableModel());
        loadData();
        setupViewListeners();
    }

    protected void loadData() {
        updateView();
    }

    public void updateView() {
        SwingUtilities.invokeLater(getTableModel()::fireTableDataChanged);
    }

    protected abstract void setupViewListeners();

    public JTable getTable() {
        return view.getTable();
    }
    public JButton getBtnEdit() {
        return getView().getBtnEdit();
    }

    public void showMessage(Object message, String title) {
        JOptionPane.showMessageDialog((Component) getView(), message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public void showMessage(Object message) {
        showMessage(message, "Message");
    }

    public void showError(Object message, String title) {
        JOptionPane.showMessageDialog((Component) getView(), message, title, JOptionPane.ERROR_MESSAGE);
    }

    public void showError(Object message) {
        showError(message, "Error");
    }
}