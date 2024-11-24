package com.nutrehogar.sistemacontable.application.service;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.format.DateTimeFormatter;

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
 * @author Calci
 * @see DateTimeFormatter
 * @see DecimalFormat
 */
public class Util {
    /**
     * Formato por defecto de un {@link BigDecimal}
     *
     * @param value numero a formatear
     * @return el número redondeado a dos decimales, a la alsa
     */
    public static @NotNull String formatBigDecimal(@NotNull BigDecimal value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(value.setScale(2, RoundingMode.HALF_UP));
    }

    /**
     * Devuelve el formato de fecha usado para guardar archivos.
     *
     * @return año-mes-día-hora-minuto-segundo
     */
    @Contract(" -> new")
    public static @NotNull DateTimeFormatter getDateFormat() {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    }
}
