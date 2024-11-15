package com.nutrehogar.sistemacontable.ui.view.components;

import com.nutrehogar.sistemacontable.application.service.Util;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.math.BigDecimal;

@Getter
@Setter
public class MayorGenTable extends JTable {
    {
//        setAutoCreateRowSorter(true);
        setFillsViewportHeight(true);
        setPreferredScrollableViewportSize(new Dimension(800, 200));
        setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
    }

    public MayorGenTable() {
    }

    public MayorGenTable(MayorGenTableModel dm) {
        super(dm);
    }

    static class BigDecimalRenderer extends DefaultTableCellRenderer {
        @Override
        protected void setValue(Object value) {
            if (value instanceof BigDecimal bigDecimal) {
                setText(!bigDecimal.equals(BigDecimal.ZERO) ? Util.formatBigDecimal(bigDecimal) : ""); // Formato con 2 decimales
            } else {
                super.setValue(value);
            }
        }
    }

}
