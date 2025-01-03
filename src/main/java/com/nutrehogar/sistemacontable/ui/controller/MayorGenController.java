package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.repository.MayorGenRepo;
import com.nutrehogar.sistemacontable.domain.repository.TipoCuentaRepo;
import com.nutrehogar.sistemacontable.ui.SistemaContable;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinnerModel;
import com.nutrehogar.sistemacontable.ui.view.MayorGenView;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import javax.swing.table.AbstractTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Vector;

import static com.nutrehogar.sistemacontable.application.service.Util.restarDateToSpinners;

@FieldDefaults(level = AccessLevel.PRIVATE)

public class MayorGenController {
    static MayorGenController instance;
    SistemaContable main;
    final MayorGenView view;
    List<MayorGenDTO> data;
    MayorGenDTO selected;
    final JTable table;
    final MayorGenTableModel tableModel;
    final JButton editButton;
    final LocalDateSpinnerModel starSpinnerModel;
    final LocalDateSpinnerModel endSpinnerModel;
    final SubTipoCuentaComboBoxModel subTipoCuentaComboModel;
    final TipoCuentaComboBoxModel tipoCuentaComboModel;
    final CuentaComboBoxModel cuentaComboModel;
    /**
     * Última cuenta seleccionada, se usará para la consulta
     */
    private String cuentaId;

    private MayorGenController() {
        view = new MayorGenView();
        this.table = view.getTabRegistros();
        this.tableModel = new MayorGenTableModel();
        this.editButton = view.getButEdit();
        this.starSpinnerModel = view.getSpiInicio().getCustomModel();
        this.endSpinnerModel = view.getSpiFin().getCustomModel();
        this.tipoCuentaComboModel = new TipoCuentaComboBoxModel();
        this.subTipoCuentaComboModel = new SubTipoCuentaComboBoxModel(List.of());
        this.cuentaComboModel = new CuentaComboBoxModel(List.of());
        initComponents();
    }

    public MayorGenView getView(SistemaContable frame) {
        this.main=frame;
        return this.view;
    }

    public static MayorGenController getInstance() {
        if (instance == null) {
            instance = new MayorGenController();
        }
        return instance;
    }

    private void initComponents() {
        editButton.setEnabled(false);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        view.getTabRegistros().setModel(tableModel);
        view.getComboxTipoCuenta().setModel(tipoCuentaComboModel);
        view.getComboxSubtipoCuenta().setModel(subTipoCuentaComboModel);
        view.getComboxCuenta().setModel(cuentaComboModel);
        view.getButFiltrar().addActionListener(e -> loadData());

        restarDateToSpinners(starSpinnerModel, endSpinnerModel);

        loadSubTipoCuentas();
        loadCuenta();
        loadData();

        defineModelListener();
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
        var tipoCuenta = TipoCuentaRepo.findById(tipoCuentaId);
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
                new MayorGenRepo.Filter.ByFechaRange((LocalDate) starSpinnerModel.getValue(), (LocalDate) endSpinnerModel.getValue()),
                new MayorGenRepo.Filter.ByCuentaId(cuentaId));
        SwingUtilities.invokeLater(() -> {
            this.data=data;
            tableModel.setData(data);
        });
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
        editButton.addActionListener(e -> main.editarAsiento(selected.getAsientoId()));

        // Detectar clic derecho
        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                press(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                press(e);
            }

            private void press(MouseEvent e) {
                int row = table.rowAtPoint(e.getPoint());
                if (row != -1) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow >= 0 && selectedRow < data.size()) {
                        selected = data.get(selectedRow);
                        editButton.setEnabled(true);
                    } else {
                        editButton.setEnabled(false);
                    }
                }
            }
        });
    }

    /**
     * Modelo para el combobox de {@link SubTipoCuenta}
     */
    private static class SubTipoCuentaComboBoxModel extends DefaultComboBoxModel<SubTipoCuenta> {
        public SubTipoCuentaComboBoxModel(@NotNull List<SubTipoCuenta> data) {
            super(new Vector<>(data));
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
            super(new Vector<>(data));
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
     * Modelo para una table que muestra una lista de {@link MayorGenDTO}
     *
     * @author Calcifer1331
     * @see
     */
    public static class MayorGenTableModel extends AbstractTableModel {
        private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;
        /**
         * lista de datos a mostrar en la base de datos
         */
        private List<MayorGenDTO> data;

        private BigDecimal saldo = BigDecimal.ZERO;
        private BigDecimal sumDebe = BigDecimal.ZERO;
        private BigDecimal sumHaber = BigDecimal.ZERO;

        public MayorGenTableModel() {
            this.data = List.of();
        }

        public MayorGenTableModel(List<MayorGenDTO> data) {
            this.data = data != null ? calcularSaldos(data) : List.of();
        }

        /**
         * Calcula la suma de {@code saldo}, de {@code Debe} y de {@code Haber}.
         * <p>
         * Dependiendo del tipo de cuenta que sea el del registro será el débito o el credito el que reste y sume
         *
         * @param data lista de datos a mostrar en la base de datos
         * @return la misma lista, con el {@code saldo}, total de {@code Debe} y total de {@code Haber} sumado
         */
        @Contract("_ -> param1")
        private List<MayorGenDTO> calcularSaldos(@NotNull List<MayorGenDTO> data) {
            saldo = BigDecimal.ZERO;
            sumDebe = BigDecimal.ZERO;
            sumHaber = BigDecimal.ZERO;
            for (MayorGenDTO dto : data) {
                saldo = TipoCuenta.fromId(dto.getTipoCuentaId()).getSaldo(saldo, dto.getRegistroHaber(), dto.getRegistroDebe());
                sumDebe = sumDebe.add(dto.getRegistroDebe(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
                sumHaber = sumHaber.add(dto.getRegistroHaber(), MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
                dto.setSaldo(saldo);
            }
            return data;
        }


        @Override
        public int getRowCount() {
            return data.size() + 1;
        }

        @Override
        public int getColumnCount() {
            return MayorGenRepo.Field.values().length;
        }

        @Override
        public String getColumnName(int column) {
            return MayorGenRepo.Field.values()[column].getFieldName();
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (rowIndex < data.size()) {
                MayorGenDTO dto = data.get(rowIndex);
                return switch (columnIndex) {
                    case 0 -> dto.getAsientoFecha();
                    case 1 -> dto.getAsientoNombre();
                    case 2 -> dto.getTipoDocumentoNombre();
                    case 3 -> dto.getCuentaId();
                    case 4 -> dto.getRegistroReferencia();
                    case 5 -> dto.getRegistroDebe().setScale(2, RoundingMode.HALF_UP);
                    case 6 -> dto.getRegistroHaber().setScale(2, RoundingMode.HALF_UP);
                    case 7 -> dto.getSaldo();
                    default -> null;
                };
            } else {
                return switch (columnIndex) {
                    case 4 -> "TOTAL:";
                    case 5 -> sumDebe;
                    case 6 -> sumHaber;
                    case 7 -> saldo;
                    default -> null;
                };
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return switch (columnIndex) {
                case 0 -> LocalDate.class;
                case 1, 2, 3, 4 -> String.class;
                case 5, 6, 7 -> BigDecimal.class;
                default -> Object.class;
            };
        }

        /**
         * Inserta los nuevos datos a la tabla y llama a {@code fireTableDataChanged()}, para que la tabla se vuelva a renderzar
         *
         * @param newData lista de datos a mostrar
         */

        public void setData(List<MayorGenDTO> newData) {
            data = newData != null ? calcularSaldos(newData) : List.of();
            fireTableDataChanged();
        }
    }

}