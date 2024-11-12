package com.nutrehogar.sistemacontable.ui.view.components;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class MayorGeneralTable extends JTable {
    {
        setAutoCreateRowSorter(true);
        setFillsViewportHeight(true);
        setPreferredScrollableViewportSize(new Dimension(800, 200));
        setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
    }

    public MayorGeneralTable() {
    }

    public MayorGeneralTable(TableModel model) {
        super(model);
    }

    static class BigDecimalRenderer extends DefaultTableCellRenderer {
        @Override
        protected void setValue(Object value) {
            if (value instanceof BigDecimal bigDecimal) {
                setText(!bigDecimal.equals(BigDecimal.ZERO) ? bigDecimal.setScale(2, RoundingMode.HALF_UP).toString() : ""); // Formato con 2 decimales
            } else {
                super.setValue(value);
            }
        }
    }

}
