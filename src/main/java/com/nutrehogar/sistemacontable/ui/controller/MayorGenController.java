//package com.nutrehogar.sistemacontable.ui.controller;
//
//import com.nutrehogar.sistemacontable.application.dto.AccountDTO;
//import com.nutrehogar.sistemacontable.application.dto.GeneralLedgerDTO;
//import com.nutrehogar.sistemacontable.application.service.Util;
//import com.nutrehogar.sistemacontable.domain.AccountType;
//import com.nutrehogar.sistemacontable.domain.model.Account;
//import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
//import com.nutrehogar.sistemacontable.domain.repository.MayorGenRepo;
//import com.nutrehogar.sistemacontable.domain.repository.TipoCuentaRepo;
//import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinnerModel;
//import com.nutrehogar.sistemacontable.ui.view.MayorGenView;
//import lombok.extern.slf4j.Slf4j;
//import org.jetbrains.annotations.Contract;
//import org.jetbrains.annotations.NotNull;
//
//import javax.swing.*;
//import javax.swing.event.ListDataEvent;
//import javax.swing.event.ListDataListener;
//import javax.swing.table.AbstractTableModel;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.math.BigDecimal;
//import java.math.MathContext;
//import java.math.RoundingMode;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//import java.util.Vector;
//import java.util.function.Consumer;
//
//import static com.nutrehogar.sistemacontable.application.service.Util.restarDateToSpinners;
//
//@Slf4j
//public class MayorGenController {
//    final MayorGenView view;
//    List<GeneralLedgerDTO> data;
//    GeneralLedgerDTO selected;
//    final JTable table;
//    final MayorGenTableModel tableModel;
//    final JButton editButton;
//    final LocalDateSpinnerModel starSpinnerModel;
//    final LocalDateSpinnerModel endSpinnerModel;
//    SubTipoCuentaComboBoxModel subTipoCuentaComboModel;
//    TipoCuentaComboBoxModel tipoCuentaComboModel;
//    CuentaComboBoxModel cuentaComboModel;
//    /**
//     * Última cuenta seleccionada, se usará para la consulta
//     */
//    private String cuentaId;
//
//    public MayorGenController() {
//        view = new MayorGenView();
//        this.table = view.getTabRegistros();
//        this.tableModel = new MayorGenTableModel();
//        this.editButton = view.getButEdit();
//        this.starSpinnerModel = view.getSpiInicio().getModel();
//        this.endSpinnerModel = view.getSpiFin().getModel();
//        this.tipoCuentaComboModel = new TipoCuentaComboBoxModel();
//        this.subTipoCuentaComboModel = new SubTipoCuentaComboBoxModel(List.of());
//        this.cuentaComboModel = new CuentaComboBoxModel(List.of());
//        initComponents();
//    }
//
//    public void MayorGenView() {
//
//    }
//
//    public MayorGenView getView(Consumer<Integer> editarAsiento) {
//        editButton.addActionListener(e -> editarAsiento.accept((selected.getJournalEntryId())));
//        return this.view;
//    }
//
//    private void initComponents() {
//        editButton.setEnabled(false);
//        Util.setTableRenderer(table);
//        view.getTabRegistros().setModel(tableModel);
//        view.getComboxTipoCuenta().setModel(tipoCuentaComboModel);
//        view.getComboxSubtipoCuenta().setModel(subTipoCuentaComboModel);
//        view.getComboxCuenta().setModel(cuentaComboModel);
//        view.getButFiltrar().addActionListener(e -> loadData());
//
//        restarDateToSpinners(starSpinnerModel, endSpinnerModel);
//
//        loadSubTipoCuentas();
//        loadCuenta();
//        cuentaId = cuentaComboModel.getElementAt(0).getId();
//        loadData();
//
//        defineModelListener();
//    }
//
//    public void setCuentaTo(AccountDTO accountDTO) {
//        try {
//            Objects.requireNonNull(accountDTO);
//            AccountType accountTypeConsumer;
//            com.nutrehogar.sistemacontable.domain.model.TipoCuenta cuentaTipo;
//            try {
//                accountTypeConsumer = AccountType.valueOf(accountDTO.getTipoCuenta().toUpperCase());
//                cuentaTipo = TipoCuentaRepo.findById(accountTypeConsumer.getId());
//            } catch (IllegalArgumentException e) {
//                log.error("TipoCuenta no valido", e);
//                return;
//            }
//            tipoCuentaComboModel.setSelectedItem(accountTypeConsumer);
//            AccountSubtype accountSubtypeConsumer = cuentaTipo.getSubTipoCuenta().getFirst();
//            for (var st : cuentaTipo.getSubTipoCuenta()) {
//                if (st.getNombre().equals(accountDTO.getSubTipoCuenta())) {
//                    accountSubtypeConsumer = st;
//                    break;
//                }
//            }
//            Objects.requireNonNull(accountSubtypeConsumer);
//            subTipoCuentaComboModel.setSelectedItem(accountSubtypeConsumer);
//            Account accountConsumer = accountSubtypeConsumer.getAccounts().getFirst();
//            for (var cu : accountSubtypeConsumer.getAccounts()) {
//                if (cu.getNombre().equals(accountDTO.getCuenta())) {
//                    accountConsumer = cu;
//                    break;
//                }
//            }
//            Objects.requireNonNull(accountConsumer);
//            cuentaComboModel.setSelectedItem(accountConsumer);
//        } catch (NullPointerException e) {
//            log.error("Algun tipo invalido", e);
//        }
//    }
//
//
//    /**
//     * Optiene el {@link AccountType} que está seleccionado en el {@code tipoCuentaComboModel},
//     * busca el tipo de cuenta en la base de datos mediante su id,
//     * optiene sus subTipoCuentas y las inserta en el {@code subTipoCuentaComboModel}
//     *
//     * <p>
//     * Este metodo trabaja en conjunto con {@code loadCuenta()}, pero este siempre debe ser el primero en ser llamado
//     */
//    private void loadSubTipoCuentas() {
//        var tipoCuentaId = 1;
//        if (tipoCuentaComboModel.getSelectedItem() instanceof AccountType accountTypeEnum) {
//            tipoCuentaId = accountTypeEnum.getId();
//        }
//        var tipoCuenta = TipoCuentaRepo.findById(tipoCuentaId);
//        subTipoCuentaComboModel.setData(tipoCuenta.getSubTipoCuenta());
//    }
//
//    /**
//     * Optiene el {@link AccountSubtype} que está seleccionado en el {@code subTipoCuentaComboModel},
//     * optiene sus cuentas y las inserta en el {@code cuentaComboModel}
//     */
//    private void loadCuenta() {
//        AccountSubtype accountSubtype = (AccountSubtype) subTipoCuentaComboModel.getSelectedItem();
//        assert accountSubtype != null;
//        cuentaComboModel.setData(accountSubtype.getAccounts());
//    }
//
//    /**
//     * Metodo principal de la clase, es el que realiza la consulta a la base de datos mediante el Repositorio
//     * <p>
//     * Además, avisa a la tabla, para que renderice los nuevos datos
//     */
//    public void loadData() {
////        this.data = MayorGenRepo.find(null, null, new MayorGenRepo.Filter.ByFechaRange(starSpinnerModel.getValue(), endSpinnerModel.getValue()), new MayorGenRepo.Filter.ByCuentaId(accountId));
//        this.data = List.of();
//        SwingUtilities.invokeLater(() -> tableModel.setData(this.data));
//    }
//
//
//    /**
//     * Se asigna los {@code contentsChanged} a los modelos de los combobox.
//     * <p>
//     * Define que se hará cuando se cambie el elemento seleccionado del combobox
//     */
//    private void defineModelListener() {
//        subTipoCuentaComboModel.addListDataListener(new ListDataListener() {
//            @Override
//            public void intervalAdded(ListDataEvent e) {
//            }
//
//            @Override
//            public void intervalRemoved(ListDataEvent e) {
//            }
//
//            @Override
//            public void contentsChanged(ListDataEvent e) {
//                loadCuenta();
//            }
//        });
//        tipoCuentaComboModel.addListDataListener(new ListDataListener() {
//
//            @Override
//            public void intervalAdded(ListDataEvent e) {
//            }
//
//            @Override
//            public void intervalRemoved(ListDataEvent e) {
//            }
//
//            @Override
//            public void contentsChanged(ListDataEvent e) {
//                loadSubTipoCuentas();
//            }
//        });
//        cuentaComboModel.addListDataListener(new ListDataListener() {
//
//            @Override
//            public void intervalAdded(ListDataEvent e) {
//            }
//
//            @Override
//            public void intervalRemoved(ListDataEvent e) {
//            }
//
//            @Override
//            public void contentsChanged(ListDataEvent e) {
//                if (cuentaComboModel.getSelectedItem() instanceof Account account && account.getId() != null) {
//                    cuentaId = account.getId();
//                }
//                loadData();
//            }
//        });
//        // Detectar clic derecho
//        table.addMouseListener(new MouseAdapter() {
//
//            @Override
//            public void mousePressed(MouseEvent e) {
//                press(e);
//            }
//
//            @Override
//            public void mouseReleased(MouseEvent e) {
////                press(e);
//            }
//
//            private void press(@NotNull MouseEvent e) {
//                int row = table.rowAtPoint(e.getPoint());
//                if (row != -1) {
//                    int selectedRow = table.getSelectedRow();
//                    if (selectedRow >= 0 && selectedRow < data.size()) {
//                        selected = data.get(selectedRow);
//                        editButton.setEnabled(true);
//                    } else {
//                        editButton.setEnabled(false);
//                    }
//                }
//            }
//        });
//    }
//
//    /**
//     * Modelo para el combobox de {@link AccountSubtype}
//     */
//    private static class SubTipoCuentaComboBoxModel extends DefaultComboBoxModel<AccountSubtype> {
//        public SubTipoCuentaComboBoxModel(@NotNull List<AccountSubtype> data) {
//            super(new Vector<>(data));
//        }
//
//        /**
//         * Metodo para agregar los datos a la lista que se mostraran
//         *
//         * @param data lista de subtipo cuentas a mostrar en el combo box
//         */
//        public void setData(List<AccountSubtype> data) {
//            this.removeAllElements();
//            if (data != null) {
//                for (AccountSubtype accountSubtype : data) {
//                    this.addElement(accountSubtype);
//                }
//            }
//        }
//    }
//
//    /**
//     * Modelo para el combobox de {@link Account}
//     */
//    private static class CuentaComboBoxModel extends DefaultComboBoxModel<Account> {
//        public CuentaComboBoxModel(@NotNull List<Account> data) {
//            super(new Vector<>(data));
//        }
//
//        /**
//         * Metodo para agregar los datos a la lista que se mostraran
//         *
//         * @param data lista de cuentas a mostrar en el combo box
//         */
//        public void setData(List<Account> data) {
//            this.removeAllElements();
//            if (data != null) {
//                for (Account account : data) {
//                    this.addElement(account);
//                }
//            }
//        }
//    }
//
//    /**
//     * Modelo de un combobox que resive los valores de un enum {@link AccountType} y los muestra, además de seleccionar por defecto el tipo {@code ACTIVO}
//     */
//    private static class TipoCuentaComboBoxModel extends DefaultComboBoxModel<AccountType> {
//        public TipoCuentaComboBoxModel() {
//            super(AccountType.values());
//            setSelectedItem(AccountType.ASSETS);
//        }
//    }
//
//    /**
//     * Modelo para una table que muestra una lista de {@link GeneralLedgerDTO}
//     *
//     * @author Calcifer1331
//     * @see
//     */
//    public static class MayorGenTableModel extends AbstractTableModel {
//        /**
//         * lista de datos a mostrar en la base de datos
//         */
//        private List<GeneralLedgerDTO> data;
//
//        private BigDecimal saldo = BigDecimal.ZERO;
//        private BigDecimal sumDebe = BigDecimal.ZERO;
//        private BigDecimal sumHaber = BigDecimal.ZERO;
//
//        public MayorGenTableModel() {
//            this.data = List.of();
//        }
//
//        public MayorGenTableModel(List<GeneralLedgerDTO> data) {
//            this.data = data != null ? calcularSaldos(data) : List.of();
//        }
//
//        /**
//         * Calcula la suma de {@code saldo}, de {@code Debe} y de {@code Haber}.
//         * <p>
//         * Dependiendo del tipo de cuenta que sea el del registro será el débito o el credito el que reste y sume
//         *
//         * @param data lista de datos a mostrar en la base de datos
//         * @return la misma lista, con el {@code saldo}, total de {@code Debe} y total de {@code Haber} sumado
//         */
//        @Contract("_ -> param1")
//        private List<GeneralLedgerDTO> calcularSaldos(@NotNull List<GeneralLedgerDTO> data) {
//            saldo = BigDecimal.ZERO;
//            sumDebe = BigDecimal.ZERO;
//            sumHaber = BigDecimal.ZERO;
//            for (GeneralLedgerDTO dto : data) {
//                saldo = AccountType.fromId(dto.getTipoCuentaId()).getSaldo(saldo, dto.getLedgerRecordCredit(), dto.getLedgerRecordDebit());
//                sumDebe = sumDebe.add(dto.getLedgerRecordDebit(), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
//                sumHaber = sumHaber.add(dto.getLedgerRecordCredit(), MathContext.DECIMAL128).setScale(2, RoundingMode.HALF_UP);
//                dto.setBalance(saldo);
//            }
//            return data;
//        }
//
//
//        @Override
//        public int getRowCount() {
//            return data.size() + 1;
//        }
//
//        @Override
//        public int getColumnCount() {
//            return MayorGenRepo.Field.values().length;
//        }
//
//        @Override
//        public String getColumnName(int column) {
//            return MayorGenRepo.Field.values()[column].getFieldName();
//        }
//
//        @Override
//        public Object getValueAt(int rowIndex, int columnIndex) {
//            if (rowIndex < data.size()) {
//                GeneralLedgerDTO dto = data.get(rowIndex);
//                return switch (columnIndex) {
//                    case 0 -> dto.getJournalEntryDate();
//                    case 1 -> dto.getJournalEntryName();
//                    case 2 -> dto.getLedgerRecordDocumentType();
//                    case 3 -> dto.getAccountId();
//                    case 4 -> dto.getLedgerRecordReference();
//                    case 5 -> dto.getLedgerRecordDebit().setScale(2, RoundingMode.HALF_UP);
//                    case 6 -> dto.getLedgerRecordCredit().setScale(2, RoundingMode.HALF_UP);
//                    case 7 -> dto.getBalance();
//                    default -> null;
//                };
//            } else {
//                return switch (columnIndex) {
//                    case 4 -> "TOTAL";
//                    case 5 -> sumDebe;
//                    case 6 -> sumHaber;
//                    case 7 -> saldo;
//                    default -> null;
//                };
//            }
//        }
//
//        @Override
//        public Class<?> getColumnClass(int columnIndex) {
//            return switch (columnIndex) {
//                case 0 -> LocalDate.class;
//                case 1, 2, 3, 4 -> String.class;
//                case 5, 6, 7 -> BigDecimal.class;
//                default -> Object.class;
//            };
//        }
//
//        /**
//         * Inserta los nuevos datos a la tabla y llama a {@code fireTableDataChanged()}, para que la tabla se vuelva a renderzar
//         *
//         * @param newData lista de datos a mostrar
//         */
//
//        public void setData(List<GeneralLedgerDTO> newData) {
//            data = newData != null ? calcularSaldos(newData) : List.of();
//            fireTableDataChanged();
//        }
//    }
//
//}