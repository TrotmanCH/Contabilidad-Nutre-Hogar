package com.nutrehogar.sistemacontable.application.config;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Constants {

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String FOLDER_PROGRAM_NAME = "SistemaContable";
    public static final String DB_NAME = "sistemacontable.sqlite";
    public static final String FOLDER_BACKUP_NAME = "backup";
    public static final String FOLDER_LOG_NAME = "logs";

    public static final LocalDate CURRENT_DATE = LocalDate.now();
    public static final LocalDate END_PERIOD = LocalDate.of(CURRENT_DATE.getYear(), 12, 31);
    public static final LocalDate START_PERIOD = LocalDate.of(CURRENT_DATE.getYear(), 1, 1);
    public static final BigDecimal ZERO = new BigDecimal("0.00");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
    public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0.00");
}
