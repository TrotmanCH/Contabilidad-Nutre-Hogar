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
    public MayorGenTable() {
        init();
    }

    public MayorGenTable(MayorGenTableModel dm) {
        this.setModel(dm);
        init();
    }

    private void init() {
        setAutoCreateRowSorter(true);
        setFillsViewportHeight(true);
        setPreferredScrollableViewportSize(new Dimension(800, 200));
        setDefaultRenderer(BigDecimal.class, new BigDecimalRenderer());
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
