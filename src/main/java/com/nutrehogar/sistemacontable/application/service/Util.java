package com.nutrehogar.sistemacontable.application.service;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Util {
    public static @NotNull String formatBigDecimal(@NotNull BigDecimal value) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
        return decimalFormat.format(value.setScale(2, RoundingMode.HALF_UP));
    }
}
