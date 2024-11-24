package com.nutrehogar.sistemacontable.ui.view.components;

import com.nutrehogar.sistemacontable.application.service.Util;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Tabla que usada para mostrar una lista de {@code  MayorGenDTO}
 *
 * @author Calci
 * @see MayorGenTableModel
 */
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

    /**
     * Define como se debe renderizar una selda que contenga un tipo especifico de dato.
     * <p>
     * En este caso si el valor de la celda ({@code value}) es de tipo {@link BigDecimal} se aplicara este renderer.
     * <p>
     * <strong><a id="override">Implementation Note:</a></strong> si el <code>bigDecimal</code> es 0 (<code>BigDecimal.ZERO</code>) en la tabla no se vera nada es decir ""
     * ,en cambio si es un numero diferente a 0 antes de imprimir al numero se le aplica un {@link DecimalFormat},
     * en concreto "#,##0.00", mediante <code>formatBigDecimal</code> de {@link Util}.
     *
     * @see DefaultTableCellRenderer
     */
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
