package com.nutrehogar.sistemacontable.application.config;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Locale;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final Locale LOCALE =  Locale.of("es", "PA");

    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final LocalDate END_PERIOD = LocalDate.of(CURRENT_DATE.getYear(), 12, 31);
    public static final LocalDate START_PERIOD = LocalDate.of(CURRENT_DATE.getYear(), 1, 1);
    public static final BigDecimal ZERO = BigDecimal.valueOf(0,2);
}
