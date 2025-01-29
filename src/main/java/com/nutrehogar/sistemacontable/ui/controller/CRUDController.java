package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.repository.crud.CRUDRepository;
import com.nutrehogar.sistemacontable.exception.RepositoryException;
import com.nutrehogar.sistemacontable.ui.view.CRUDView;
import jakarta.persistence.EntityExistsException;
import org.hibernate.ObjectDeletedException;
import org.hibernate.exception.ConstraintViolationException;
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
    protected void loadData() {
        setData(getRepository().findAll());
        super.loadData();
    }

    @Override
    protected void setupViewListeners() {
        getBtnSave().addActionListener(e -> save(prepareToSave()));
        getBtnDelete().addActionListener(e -> delete(prepareToDelete()));
        getBtnUpdate().addActionListener(e -> update(prepareToUpdate()));
        getBtnEdit().addActionListener(e -> prepareToEdit());
        getBtnAdd().addActionListener(e -> prepareToAdd());
        deselect();
        getTblData().addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                setElementSelected(e);
            }
        });
    }

    private void save(T entity) {
        if (entity == null) return;
        try {
            getRepository().save(entity);
            loadData(); // Recargar datos después de guardar
            prepareToAdd();
        } catch (RepositoryException e) {
            String fullMessage = switch (e.getCause()) {
                case EntityExistsException c -> "Ya existe esa Cuenta";
                case IllegalArgumentException c -> "Los datos no puede ser nulo";
                case ConstraintViolationException c -> "Codigo de cuenta duplicado";
                case null, default -> e.getMessage();
            };

            showError("Error al guardar: " + fullMessage);
        }
    }


    private void update(T entity) {
        if (entity == null) return;
        try {
            getRepository().update(getSelected());
            loadData(); // Recargar datos después de eliminar
            prepareToAdd();
        } catch (RepositoryException e) {
            String fullMessage = switch (e.getCause()) {
                case IllegalArgumentException c -> "Los datos no son validos";
                case ObjectDeletedException c -> "No se puede editar un cuenta eliminado";
                case ConstraintViolationException c -> "Operacion no valido";
                case null, default -> e.getMessage();
            };
            showError("Error al guardar: " + fullMessage);
        }
    }


    private void delete(ID id) {
        if (id == null) {
            prepareToAdd();
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
            prepareToAdd();
        } catch (RepositoryException e) {
            showError("Error al guardar: " + e.getMessage());
        }
    }

    protected void deselect() {
        setSelected(null);
        getBtnDelete().setEnabled(false);
        getBtnEdit().setEnabled(false);
    }

    protected void select() {
        getBtnDelete().setEnabled(true);
        getBtnEdit().setEnabled(true);
    }

    @Override
    public void setSelected(T selected) {
        super.setSelected(selected);
        select();
    }

    private void setElementSelected(@NotNull MouseEvent e) {
        int row = getTblData().rowAtPoint(e.getPoint());
        if (row != -1) {
            int selectedRow = getTblData().getSelectedRow();
            if (selectedRow < 0) {
                deselect();
                return;
            }
//            var selected = getData().get(selectedRow);
//            if (selected.getId() == null) {
//                deselect();
//                return;
//            }
            setSelected(getData().get(selectedRow));
        }
    }

    protected void prepareToEdit() {
        getBtnUpdate().setEnabled(true);
        getBtnSave().setEnabled(false);
    }

    protected void prepareToAdd() {
        deselect();
        getBtnUpdate().setEnabled(false);
        getBtnSave().setEnabled(true);
    }

    protected abstract ID prepareToDelete();

    protected abstract T prepareToSave();

    protected abstract T prepareToUpdate();

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
