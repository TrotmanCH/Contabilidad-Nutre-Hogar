package com.nutrehogar.sistemacontable.ui.components;

import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.DocumentType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;

import javax.swing.table.DefaultTableCellRenderer;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import static com.nutrehogar.sistemacontable.application.service.Util.DECIMAL_FORMAT;
import static com.nutrehogar.sistemacontable.application.service.Util.formatBigDecimal;

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
public class CustomTableCellRenderer extends DefaultTableCellRenderer {
    @Override
    protected void setValue(Object value) {
        setText(switch (value) {
            case BigDecimal bigDecimal -> (!bigDecimal.equals(BigDecimal.ZERO) ? formatBigDecimal(bigDecimal) : "");
            case Double doubleValue -> (doubleValue != 0.0 ? DECIMAL_FORMAT.format(doubleValue) : "");
            case AccountType accountType -> AccountType.getCellRenderer(accountType);
            case AccountSubtype tipoCuenta ->
                    tipoCuenta.getAccountType().getId() + "." + tipoCuenta.getCanonicalId() + " " + tipoCuenta.getName();
            case Account account -> account.getId() + " " + account.getName();
            case null -> "";
            default -> value.toString();
        });
    }
}