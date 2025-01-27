package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.repository.crud.CuentaRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.SubTipoCuentaRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.TipoCuentaRepository;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.model.TipoCuenta;
import com.nutrehogar.sistemacontable.ui.components.CustomListCellRenderer;
import com.nutrehogar.sistemacontable.ui.view.AccountView;
import com.nutrehogar.sistemacontable.ui.view.CRUDView;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Objects;
import java.util.Vector;

public class AccountController extends CRUDController<Cuenta, String> {
    private final SubTipoCuentaRepository subTipoCuentaRepository;
    private final TipoCuentaRepository tipoCuentaRepository;
    private List<TipoCuenta> selectedTipoCuenta;
    private List<SubTipoCuenta> selectedSubTipoCuenta;

    public AccountController(CuentaRepository repository, CRUDView view, SubTipoCuentaRepository subTipoCuentaRepository, TipoCuentaRepository tipoCuentaRepository) {
        super(repository, view);
        this.subTipoCuentaRepository = subTipoCuentaRepository;
        this.tipoCuentaRepository = tipoCuentaRepository;
        getCbTipoCuenta().setRenderer(new CustomListCellRenderer());
        getCbSubTipoCuenta().setRenderer(new CustomListCellRenderer());
        getCbTipoCuenta().setModel(new CustomComboBoxModel<>(List.of()));
        getCbSubTipoCuenta().setModel(new CustomComboBoxModel<>(List.of()));
        loadTipoCuentas();
        loadSubTipoCuentas();
    }

    @Override
    protected void initialize() {
        setTableModel(new AccountTableModel());
        super.initialize();
    }

    @Override
    protected void setElementSelected(@NotNull MouseEvent e) {
        int row = getTable().rowAtPoint(e.getPoint());
        if (row != -1) {
            int selectedRow = getTable().getSelectedRow();
            if (selectedRow < 0) {
                getBtnEdit().setEnabled(false);
                getBtnDelete().setEnabled(false);
                return;
            }
            var selected = getData().get(selectedRow);
            if (selected.getId() == null) {
                getBtnEdit().setEnabled(false);
                getBtnDelete().setEnabled(false);
                return;
            }
            setSelected(selected);
            getBtnEdit().setEnabled(true);
            getBtnDelete().setEnabled(true);
        }
    }

    @Override
    protected void setupViewListeners() {
        super.setupViewListeners();
        getCbTipoCuenta().addItemListener(e -> loadSubTipoCuentas());
        getBtnAdd().addActionListener(e -> {
            setSelected(null);
            getBtnSave().setEnabled(false);
            getBtnEdit().setEnabled(false);
            getBtnDelete().setEnabled(false);
        });
        getBtnEdit().addActionListener(e -> {
            TipoCuenta tipoCuenta = getSelected().getSubTipoCuenta().getTipoCuenta();
            getTxtCodigo().setText(getSelected().getId());
            getTxtNombre().setText(getSelected().getNombre());
            getBtnSave().setEnabled(true);
            getBtnEdit().setEnabled(false);
            getBtnDelete().setEnabled(true);
        });
    }

    @Override
    protected void updateSelected() {
        getSelected().setId(getTxtCodigo().getText());
        getSelected().setNombre(getTxtNombre().getText());
    }

    @Override
    protected String getSelectedId() {
        return getSelected().getId();
    }

    private void loadTipoCuentas() {
        selectedTipoCuenta = this.tipoCuentaRepository.findAll();
        loadSubTipoCuentas();
    }

    private void loadTipoCuentas(List<TipoCuenta> tipoCuentas) {
        if (getCbTipoCuenta().getModel() instanceof CustomComboBoxModel<TipoCuenta> model) {
            model.setData(selectedTipoCuenta);
        }
    }

    private void loadSubTipoCuentas() {
        List<SubTipoCuenta> subTipoCuentas = ((TipoCuenta) Objects.requireNonNull(getCbTipoCuenta().getModel().getSelectedItem())).getSubTipoCuenta();
        getCbSubTipoCuenta().setModel(new DefaultComboBoxModel<>(new Vector<>()));
    }

    @Override
    protected Cuenta getFormData() {
        SubTipoCuenta subTipoCuenta = (SubTipoCuenta) Objects.requireNonNull(getCbSubTipoCuenta().getModel().getSelectedItem());
        return new Cuenta(getTxtCodigo().getText(), getTxtNombre().getText(), subTipoCuenta, null);
    }

    @Override
    public AccountView getView() {
        return (AccountView) super.getView();
    }

    @Override
    public CuentaRepository getRepository() {
        return (CuentaRepository) super.getRepository();
    }

    public JComboBox<SubTipoCuenta> getCbSubTipoCuenta() {
        return getView().getCbSubTipoCuenta();
    }

    public JComboBox<TipoCuenta> getCbTipoCuenta() {
        return getView().getCbTipoCuenta();
    }

    public JTextField getTxtCodigo() {
        return getView().getTxtCodigo();
    }

    public JTextField getTxtNombre() {
        return getView().getTxtNombre();
    }

    public class AccountTableModel extends AbstractTableModel {

        private final String[] COLUMN_NAMES =
                {
                        "Código", "Nombre", "Tipo de Cuenta", "Subtipo de Cuenta"
                };

        @Override
        public int getRowCount() {
            return getData().size();
        }

        @Override
        public int getColumnCount() {
            return COLUMN_NAMES.length;
        }

        @Override
        public String getColumnName(int column) {
            return COLUMN_NAMES[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var dto = getData().get(rowIndex);
            return switch (columnIndex) {
                case 0 -> dto.getId();
                case 1 -> dto.getNombre();
                case 2 -> dto.getSubTipoCuenta().getTipoCuenta().getNombre();
                case 3 -> dto.getSubTipoCuenta().getNombre();
                default -> "que haces?";
            };
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return String.class;
        }
    }

    private static class CustomComboBoxModel<T> extends DefaultComboBoxModel<T> {
        public CustomComboBoxModel(@NotNull List<T> data) {
            super(new Vector<>(data));
        }

        /**
         * Metodo para agregar los datos a la lista que se mostraran
         *
         * @param data lista de subtipo cuentas a mostrar en el combo box
         */
        public void setData(List<T> data) {
            this.removeAllElements();
            if (data != null) {
                for (T subTipoCuenta : data) {
                    this.addElement(subTipoCuenta);
                }
            }
        }
    }
}
