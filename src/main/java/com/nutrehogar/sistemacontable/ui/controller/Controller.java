package com.nutrehogar.sistemacontable.ui.controller;


import com.nutrehogar.sistemacontable.application.repository.SimpleRepository;
import com.nutrehogar.sistemacontable.ui.components.CustomTableCellRenderer;
import com.nutrehogar.sistemacontable.ui.view.View;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

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
    private AbstractTableModel tblModel;

    protected Controller(SimpleRepository<T> repository, View view) {
        this.repository = repository;
        this.view = view;
        initialize();
    }

    protected void initialize() {
        getTblData().setModel(getTblModel());
        getTblData().setDefaultRenderer(Object.class, new CustomTableCellRenderer());
        loadData();
        setupViewListeners();
    }

    protected void loadData() {
        updateView();
    }

    protected void updateView() {
        SwingUtilities.invokeLater(getTblModel()::fireTableDataChanged);
    }

    protected abstract void setupViewListeners();

    public JTable getTblData() {
        return view.getTblData();
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

    @NotNull String getFullExceptionMessage(Throwable throwable) {
        StringBuilder messageBuilder = new StringBuilder();
        while (throwable != null) {
            if (throwable.getMessage() != null) {
                messageBuilder.append(throwable.getClass().getSimpleName())
                        .append(": ")
                        .append(throwable.getMessage())
                        .append(" -> ");
            } else {
                messageBuilder.append(throwable.getClass().getSimpleName())
                        .append(": [mensaje no disponible] -> ");
            }
            throwable = throwable.getCause();
        }
        // Eliminar la última flecha " -> " si existe
        if (messageBuilder.length() > 4) {
            messageBuilder.setLength(messageBuilder.length() - 4);
        }
        return messageBuilder.toString();
    }

}