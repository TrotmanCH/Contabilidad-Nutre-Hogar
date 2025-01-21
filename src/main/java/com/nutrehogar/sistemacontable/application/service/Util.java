package com.nutrehogar.sistemacontable.application.service;

import com.nutrehogar.sistemacontable.application.dto.BalanceComDTO;
import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinnerModel;
import com.nutrehogar.sistemacontable.ui.controller.TipoCuenta;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * Clase de utilidad del proyecto, Contiene metodos que pueden ser utilizados en el proyecto,
 * normalmente son metodos staticos por lo que no hace falta instanciar la clase
 * <p>
 * <strong><a id="override">Implementation Note:</a></strong> al ser <code>static</code> se
 * puede importar el metodo a usar sin la necesidad de importar la clase entera.
 *
 * <blockquote><pre>
 * import static com.nutrehogar.sistemacontable.application.service.Util.getDateFormat;
 *     </pre></blockquote><p>
 * <p>
 * ya se puede usar el metodo, se hace referencia de forma directa
 *
 * <blockquote><pre>
 *  var date = BigDecimal.now();
 *  System.out.print(getDateFormat(date)); // 2024-12-1-2-34-12
 * </pre></blockquote>
 *
 * @author Calcifer1331
 * @see DateTimeFormatter
 * @see DecimalFormat
 */
public class Util {
    public static LocalDate CURRENT_DATE = LocalDate.now();

    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    // Formato estático para números decimales
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");

    /**
     * Formatea un {@link BigDecimal} a dos decimales con redondeo hacia el valor más cercano.
     *
     * @param value número a formatear
     * @return el número redondeado a dos decimales como cadena
     */
    public static @NotNull String formatBigDecimal(@NotNull BigDecimal value) {
        return DECIMAL_FORMAT.format(value.setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * Devuelve el formato de fecha usado para guardar archivos.
     *
     * @return año-mes-día-hora-minuto-segundo
     */
    @Contract(" -> new")
    public static @NotNull DateTimeFormatter getDateFormat() {
        return DATE_TIME_FORMATTER;
    }

    public static void restarDateToSpinners(@NotNull LocalDateSpinnerModel star, @NotNull LocalDateSpinnerModel end) {
        star.setValue(LocalDate.of(CURRENT_DATE.getYear(), 1, 1));
        end.setValue(LocalDate.of(CURRENT_DATE.getYear(), 12, 31));
    }

    public static void restarDateToSpinners(@NotNull LocalDateSpinner star, @NotNull LocalDateSpinner end) {
        star.setValue(LocalDate.of(CURRENT_DATE.getYear(), 1, 1));
        end.setValue(LocalDate.of(CURRENT_DATE.getYear(), 12, 31));
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

    private static class DecimalRenderer extends DefaultTableCellRenderer {
        @Override
        protected void setValue(Object value) {
            if (value instanceof BigDecimal bigDecimal) {
                setText(!bigDecimal.equals(BigDecimal.ZERO) ? formatBigDecimal(bigDecimal) : ""); // Formato con 2 decimales
            } else if (value instanceof Double doubleValue) {
                setText(doubleValue != 0.0 ? DECIMAL_FORMAT.format(doubleValue) : ""); // Formato para Double
            } else {
                super.setValue(value);
            }
        }
    }
    @Getter
    private static final DecimalRenderer DECIMAL_RENDERER = new DecimalRenderer();

    /**
     * Configura el renderer por defecto para una o más tablas.
     *
     * @param tables Tablas a las que se aplicará el renderer
     */
    public static void setTableRenderer(JTable @NotNull ... tables) {
        for (JTable table : tables) {
            table.setDefaultRenderer(BigDecimal.class, DECIMAL_RENDERER);
            table.setDefaultRenderer(Double.class, DECIMAL_RENDERER);
            table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
    }

    @Contract(value = "!null -> param1", pure = true)
    public static <E> @NotNull List<E> ifNull(List<E> e) {
        if (e == null) return List.of();
        return e;
    }

    public record Triple<A, B, C>(A first, B second, C third) {
    }

    public record Pair<A, B>(A first, B second) {
    }
}
