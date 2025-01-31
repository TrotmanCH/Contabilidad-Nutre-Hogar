package com.nutrehogar.sistemacontable.ui.components;

import com.nutrehogar.sistemacontable.application.config.Constants;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.DocumentType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import org.jetbrains.annotations.NotNull;

import javax.swing.table.DefaultTableCellRenderer;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;


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
    /**
     * Formatea un {@link BigDecimal} a dos decimales con redondeo hacia el valor más cercano.
     *
     * @param value número a formatear
     * @return el número redondeado a dos decimales como cadena
     */
    public static @NotNull String formatBigDecimal(@NotNull BigDecimal value) {
        return Constants.DECIMAL_FORMAT.format(value.setScale(2, RoundingMode.HALF_UP));
    }

    @Override
    protected void setValue(Object value) {
        setText(switch (value) {
            case BigDecimal bigDecimal ->
                    (bigDecimal.equals(BigDecimal.ZERO) || bigDecimal.equals(Constants.ZERO) ? " " : formatBigDecimal(bigDecimal));
            case Double doubleValue -> (doubleValue != 0.0 ? Constants.DECIMAL_FORMAT.format(doubleValue) : " ");
            case AccountType accountType -> AccountType.getCellRenderer(accountType);
            case AccountSubtype tipoCuenta ->
                    tipoCuenta.getAccountType().getId() + "." + tipoCuenta.getCanonicalId() + " " + tipoCuenta.getName();
            case Account account -> account.getId() + " " + account.getName();
            case DocumentType documentType -> documentType.getName();
            case null -> "";
            default -> value.toString();
        });
    }
}