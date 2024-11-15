package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGenField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGenRepo;
import com.nutrehogar.sistemacontable.persistence.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.TipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinnerModel;
import com.nutrehogar.sistemacontable.ui.view.components.MayorGenTableModel;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
public class MayorGenController {
    private final MayorGenRepo MGRepo = MayorGenRepo.getInstance();
    private final TipoCuentaRepo tipoCuentaRepo = TipoCuentaRepo.getInstance();
    private final SubTipoCuentaRepo subTipoCuentaRepo = SubTipoCuentaRepo.getInstance();
    private final CuentaRepo cuentaRepo = CuentaRepo.getInstance();

    private final MayorGenTableModel MGTableModel;
    private final LocalDateSpinnerModel starSpinnerModel;
    private final LocalDateSpinnerModel endSpinnerModel;
    private final SubTipoCuentaComboBoxModel subTipoCuentaComboModel;
    private final TipoCuentaComboBoxModel tipoCuentaComboModel;
    private final CuentaComboBoxModel cuentaComboModel;
    private final LocalDate currentDate;

    public MayorGenController() {
        currentDate = LocalDate.now();
        this.MGTableModel = new MayorGenTableModel();
        this.starSpinnerModel = new LocalDateSpinnerModel(LocalDate.of(currentDate.getYear(), 1, 1));
        this.endSpinnerModel = new LocalDateSpinnerModel(LocalDate.of(currentDate.getYear(), 12, 31));
        this.tipoCuentaComboModel = new TipoCuentaComboBoxModel();
        this.subTipoCuentaComboModel = new SubTipoCuentaComboBoxModel(List.of());
        this.cuentaComboModel = new CuentaComboBoxModel(List.of());
        subTipoCuentaComboModel.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {

            }

            @Override
            public void intervalRemoved(ListDataEvent e) {

            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                System.out.println("Change: " + subTipoCuentaComboModel.getSelectedItem().toString());
                loadCuenta();
            }
        });
        tipoCuentaComboModel.addListDataListener(new ListDataListener() {

            @Override
            public void intervalAdded(ListDataEvent e) {

            }

            @Override
            public void intervalRemoved(ListDataEvent e) {

            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                System.out.println("change : " + tipoCuentaComboModel.getSelectedItem().toString());
                loadSubTipoCuentas();
            }
        });
        loadSubTipoCuentas();
        loadCuenta();
        loadData();
    }

    private void loadSubTipoCuentas() {
        var tipoCuentaId = 1;
        if (tipoCuentaComboModel.getSelectedItem() instanceof TipoCuenta tipoCuentaEnum) {
            tipoCuentaId = tipoCuentaEnum.getId();
        }
        var tipoCuenta = tipoCuentaRepo.findById(tipoCuentaId);
        subTipoCuentaComboModel.setData(tipoCuenta.getSubTipoCuenta());
    }

    private void loadCuenta() {
        SubTipoCuenta subTipoCuenta = (SubTipoCuenta) subTipoCuentaComboModel.getSelectedItem();
        assert subTipoCuenta != null;
        cuentaComboModel.setData(subTipoCuenta.getCuentas());

    }

    public void loadData() {
        List<MayorGenFilter> filters = new ArrayList<>();
        if (starSpinnerModel.getValue() instanceof LocalDate starDate && endSpinnerModel.getValue() instanceof LocalDate endDate) {
            filters.add(MayorGenFilter.ByFechaRange.of(starDate, endDate));
        }
        if (cuentaComboModel.getSelectedItem() instanceof Cuenta cuenta) {
            filters.add(MayorGenFilter.ByCuentaId.of(cuenta.getId()));
        }
        updateTable(filters, null, null);
    }

    private void updateTable(List<MayorGenFilter> filters, MayorGenField orderField, OrderDirection orderDirection) {
        Optional<List<MayorGenDTO>> data = MGRepo.find(filters, orderField, orderDirection);
        SwingUtilities.invokeLater(() -> {
            MGTableModel.setData(data.orElseGet(List::of));
        });
    }

    private class SubTipoCuentaComboBoxModel extends DefaultComboBoxModel<SubTipoCuenta> {
        public SubTipoCuentaComboBoxModel(@NotNull List<SubTipoCuenta> data) {
            super(data.toArray(new SubTipoCuenta[0]));
        }

        public void setData(List<SubTipoCuenta> data) {
            this.removeAllElements();
            if (data != null) {
                for (SubTipoCuenta subTipoCuenta : data) {
                    this.addElement(subTipoCuenta);
                }
            }
        }
    }

    private static class CuentaComboBoxModel extends DefaultComboBoxModel<Cuenta> {
        public CuentaComboBoxModel(@NotNull List<Cuenta> data) {
            super(data.toArray(new Cuenta[0]));
            this.addListDataListener(new ListDataListener() {

                @Override
                public void intervalAdded(ListDataEvent e) {

                }

                @Override
                public void intervalRemoved(ListDataEvent e) {

                }

                @Override
                public void contentsChanged(ListDataEvent e) {
                    System.out.println("Change: " + getSelectedItem().toString());
                }
            });
        }

        public void setData(List<Cuenta> data) {
            this.removeAllElements();
            if (data != null) {
                for (Cuenta cuenta : data) {
                    this.addElement(cuenta);
                }
            }
        }
    }

    private class TipoCuentaComboBoxModel extends DefaultComboBoxModel<TipoCuenta> {
        public TipoCuentaComboBoxModel() {
            super(TipoCuenta.values());
            setSelectedItem(TipoCuenta.ACTIVO);
        }
    }
}