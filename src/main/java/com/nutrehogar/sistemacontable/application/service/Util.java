package com.nutrehogar.sistemacontable.application.service;

import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.DocumentType;
import com.nutrehogar.sistemacontable.ui.components.CustomTableCellRenderer;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinnerModel;
import jakarta.persistence.Id;
import lombok.Getter;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

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
    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final LocalDate START_PERIOD = LocalDate.of(CURRENT_DATE.getYear(), 1, 1);
    public static final LocalDate END_PERIOD = LocalDate.of(CURRENT_DATE.getYear(), 12, 31);
    public static final BigDecimal ZERO = new BigDecimal("0.00");
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

    @Contract(value = "!null -> param1", pure = true)
    public static <E> @NotNull List<E> ifNull(List<E> e) {
        if (e == null) return List.of();
        return e;
    }


    /**
     * Obtiene el tipo del campo anotado con @Id en una clase.
     *
     * @param clazz La clase en la que buscar el campo @Id.
     * @return El tipo del campo @Id, o un Optional vacío si no se encuentra.
     */
    public static Optional<Class<?>> getIdFieldType(@NotNull Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(Id.class)) {
                return Optional.of(field.getType());
            }
        }
        return Optional.empty();
    }
}
