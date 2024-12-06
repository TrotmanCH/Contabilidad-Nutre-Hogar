package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGenRepo;
import com.nutrehogar.sistemacontable.persistence.repository.SubTipoCuentaRepo;
import com.nutrehogar.sistemacontable.persistence.repository.TipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinnerModel;
import com.nutrehogar.sistemacontable.ui.view.components.MayorGenTableModel;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import java.time.LocalDate;
import java.util.List;

/**
 * Controlador de la vista del Mayor General
 *
 * @author Calcifer1331
 */
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MayorGenController {
    final TipoCuentaRepo tipoCuentaRepo = TipoCuentaRepo.getInstance();
    final SubTipoCuentaRepo subTipoCuentaRepo = SubTipoCuentaRepo.getInstance();
    final CuentaRepo cuentaRepo = CuentaRepo.getInstance();

    final MayorGenTableModel MGTableModel;
    final LocalDateSpinnerModel starSpinnerModel;
    final LocalDateSpinnerModel endSpinnerModel;
    final SubTipoCuentaComboBoxModel subTipoCuentaComboModel;
    final TipoCuentaComboBoxModel tipoCuentaComboModel;
    final CuentaComboBoxModel cuentaComboModel;
    final LocalDate currentDate;
    /**
     * Última cuenta seleccionada, se usará para la consulta
     */
    private String cuentaId;

    {
        currentDate = LocalDate.now();
    }

    public MayorGenController() {
        this.MGTableModel = new MayorGenTableModel();
        this.starSpinnerModel = new LocalDateSpinnerModel(getStartDateWithCurrentYear());
        this.endSpinnerModel = new LocalDateSpinnerModel(getEndDateWithCurrentYear());
        this.tipoCuentaComboModel = new TipoCuentaComboBoxModel();
        this.subTipoCuentaComboModel = new SubTipoCuentaComboBoxModel(List.of());
        this.cuentaComboModel = new CuentaComboBoxModel(List.of());
        initComponents();
    }

    private void initComponents() {
        defineModelListener();
        loadSubTipoCuentas();
        loadCuenta();
        loadData();
    }

    public LocalDate getStartDateWithCurrentYear() {
        assert currentDate != null;
        return LocalDate.of(currentDate.getYear(), 1, 1);
    }

    public LocalDate getEndDateWithCurrentYear() {
        assert currentDate != null;
        return LocalDate.of(currentDate.getYear(), 12, 31);
    }

    /**
     * Optiene el {@link TipoCuenta} que está seleccionado en el {@code tipoCuentaComboModel},
     * busca el tipo de cuenta en la base de datos mediante su id,
     * optiene sus subTipoCuentas y las inserta en el {@code subTipoCuentaComboModel}
     *
     * <p>
     * Este metodo trabaja en conjunto con {@code loadCuenta()}, pero este siempre debe ser el primero en ser llamado
     */
    private void loadSubTipoCuentas() {
        var tipoCuentaId = 1;
        if (tipoCuentaComboModel.getSelectedItem() instanceof TipoCuenta tipoCuentaEnum) {
            tipoCuentaId = tipoCuentaEnum.getId();
        }
        var tipoCuenta = tipoCuentaRepo.findById(tipoCuentaId);
        subTipoCuentaComboModel.setData(tipoCuenta.getSubTipoCuenta());
    }

    /**
     * Optiene el {@link SubTipoCuenta} que está seleccionado en el {@code subTipoCuentaComboModel},
     * optiene sus cuentas y las inserta en el {@code cuentaComboModel}
     */
    private void loadCuenta() {
        SubTipoCuenta subTipoCuenta = (SubTipoCuenta) subTipoCuentaComboModel.getSelectedItem();
        assert subTipoCuenta != null;
        cuentaComboModel.setData(subTipoCuenta.getCuentas());
    }

    /**
     * Metodo principal de la clase, es el que realiza la consulta a la base de datos mediante el Repositorio
     * <p>
     * Además, avisa a la tabla, para que renderice los nuevos datos
     */
    public void loadData() {
        List<MayorGenDTO> data = MayorGenRepo.find(
                null,
                null,
                new MayorGenFilter.ByFechaRange((LocalDate) starSpinnerModel.getValue(), (LocalDate) endSpinnerModel.getValue()),
                new MayorGenFilter.ByCuentaId(cuentaId));
        SwingUtilities.invokeLater(() -> {
            MGTableModel.setData(data);
        });
    }

    /**
     * Modelo para el combobox de {@link SubTipoCuenta}
     */
    private static class SubTipoCuentaComboBoxModel extends DefaultComboBoxModel<SubTipoCuenta> {
        public SubTipoCuentaComboBoxModel(@NotNull List<SubTipoCuenta> data) {
            super(data.toArray(new SubTipoCuenta[0]));
        }

        /**
         * Metodo para agregar los datos a la lista que se mostraran
         *
         * @param data lista de subtipo cuentas a mostrar en el combo box
         */
        public void setData(List<SubTipoCuenta> data) {
            this.removeAllElements();
            if (data != null) {
                for (SubTipoCuenta subTipoCuenta : data) {
                    this.addElement(subTipoCuenta);
                }
            }
        }
    }

    /**
     * Modelo para el combobox de {@link Cuenta}
     */
    private static class CuentaComboBoxModel extends DefaultComboBoxModel<Cuenta> {
        public CuentaComboBoxModel(@NotNull List<Cuenta> data) {
            super(data.toArray(new Cuenta[0]));
        }

        /**
         * Metodo para agregar los datos a la lista que se mostraran
         *
         * @param data lista de cuentas a mostrar en el combo box
         */
        public void setData(List<Cuenta> data) {
            this.removeAllElements();
            if (data != null) {
                for (Cuenta cuenta : data) {
                    this.addElement(cuenta);
                }
            }
        }
    }

    /**
     * Modelo de un combobox que resive los valores de un enum {@link TipoCuenta} y los muestra, además de seleccionar por defecto el tipo {@code ACTIVO}
     */
    private static class TipoCuentaComboBoxModel extends DefaultComboBoxModel<TipoCuenta> {
        public TipoCuentaComboBoxModel() {
            super(TipoCuenta.values());
            setSelectedItem(TipoCuenta.ACTIVO);
        }
    }

    /**
     * Se asigna los {@code contentsChanged} a los modelos de los combobox.
     * <p>
     * Define que se hará cuando se cambie el elemento seleccionado del combobox
     */
    private void defineModelListener() {
        subTipoCuentaComboModel.addListDataListener(new ListDataListener() {
            @Override
            public void intervalAdded(ListDataEvent e) {
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
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
                loadSubTipoCuentas();
            }
        });
        cuentaComboModel.addListDataListener(new ListDataListener() {

            @Override
            public void intervalAdded(ListDataEvent e) {
            }

            @Override
            public void intervalRemoved(ListDataEvent e) {
            }

            @Override
            public void contentsChanged(ListDataEvent e) {
                if (cuentaComboModel.getSelectedItem() instanceof Cuenta cuenta && cuenta.getId() != null) {
                    cuentaId = cuenta.getId();
                }
                loadData();
            }
        });
    }
}