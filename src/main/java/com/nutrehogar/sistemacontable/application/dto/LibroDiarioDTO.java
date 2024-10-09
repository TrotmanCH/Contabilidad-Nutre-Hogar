package com.nutrehogar.sistemacontable.application.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record LibroDiarioDTO(LocalDate fecha,
                             String concepto,
                             BigDecimal debe,
                             BigDecimal haber) {
}
