package com.nutrehogar.sistemacontable.domain.helper;


import java.time.LocalDate;

public interface SimpleFilter {

    record ByFechaRange(LocalDate startDate, LocalDate endDate)  {

    }
}
