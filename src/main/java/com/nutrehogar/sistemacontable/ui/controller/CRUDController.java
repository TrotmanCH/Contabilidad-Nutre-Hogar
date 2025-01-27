package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.repository.crud.CRUDRepository;
import com.nutrehogar.sistemacontable.ui.view.CRUDView;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public abstract class CRUDController<T, ID> extends Controller<T> {
    public CRUDController(CRUDRepository<T, ID> repository, CRUDView view) {
        super(repository, view);
    }

    @Override
    protected void initialize() {
        super.initialize();
    }

    @Override
    protected void loadData() {
        setData(getRepository().findAll());
        super.loadData();
    }

    @Override
    protected void setupViewListeners() {
        getBtnSave().addActionListener(e -> save(getFormData()));
        getBtnDelete().addActionListener(e -> delete(getSelectedId()));
        getBtnUpdate().addActionListener(e -> update());
        getBtnEdit().setEnabled(false);
        getBtnDelete().setEnabled(false);
        getTable().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setElementSelected(e);
            }
        });
    }

    public void save(T entity) {
        try {
            getRepository().save(entity);
            loadData(); // Recargar datos después de guardar
            System.out.printf("Saved entity: %s\n", entity);
        } catch (Exception e) {
            showError("Error al guardar: " + e.getMessage(), "");
        }
    }

    public void update() {
        updateSelected();
        try {
            getRepository().update(getSelected());
            loadData(); // Recargar datos después de eliminar
            setSelected(null);
            getBtnDelete().setEnabled(false);
            getBtnEdit().setEnabled(false);
        } catch (Exception e) {
            showError("Error al actualizar: " + e.getMessage());
        }
    }

    protected abstract void updateSelected();

    public void delete(ID id) {
        if (id == null) {
            getBtnDelete().setEnabled(false);
            return;
        }

        var response = JOptionPane.showConfirmDialog(
                (Component) getView(),
                "Desea eliminar? El cambio sera permanente.",
                "Elimination",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (response != JOptionPane.OK_OPTION) return;

        try {
            getRepository().deleteById(id);
            loadData(); // Recargar datos después de eliminar
            setSelected(null);
            getBtnDelete().setEnabled(false);
        } catch (Exception e) {
            showError("Error al eliminar: " + e.getMessage());
        }
    }

    protected abstract void setElementSelected(@NotNull MouseEvent e);

    protected abstract ID getSelectedId();

    protected abstract T getFormData();

    @Override
    public CRUDRepository<T, ID> getRepository() {
        return (CRUDRepository<T, ID>) super.getRepository();
    }

    @Override
    public CRUDView getView() {
        return (CRUDView) super.getView();
    }

    public JButton getBtnAdd() {
        return getView().getBtnAdd();
    }

    public JButton getBtnUpdate() {
        return getView().getBtnUpdate();
    }

    public JButton getBtnEdit() {
        return getView().getBtnEdit();
    }

    public JButton getBtnDelete() {
        return getView().getBtnDelete();
    }

    public JButton getBtnSave() {
        return getView().getBtnSave();
    }
}
