package com.nutrehogar.sistemacontable.ui.view.components;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;


public class LocalDateSpinnerModel extends AbstractSpinnerModel {
    private LocalDate currentDate;
    @Getter
    private LocalDate minDate;
    @Getter
    private LocalDate maxDate;
    @Getter
    @Setter
    private ChronoUnit incrementUnit;

    public LocalDateSpinnerModel() {
        this.currentDate = LocalDate.now();
        this.incrementUnit = ChronoUnit.DAYS;
    }

    public LocalDateSpinnerModel(LocalDate currentDate) {
        this.currentDate = currentDate;
        this.incrementUnit = ChronoUnit.DAYS;
    }

    public LocalDateSpinnerModel(LocalDate initialDate, LocalDate minDate, LocalDate maxDate, ChronoUnit incrementUnit) {
        this.currentDate = initialDate != null ? initialDate : LocalDate.now();
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.incrementUnit = incrementUnit != null ? incrementUnit : ChronoUnit.DAYS;
    }

    @Override
    public Object getValue() {
        return currentDate;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof LocalDate newDate) {
            if (!newDate.equals(currentDate)) {
                if (isWithinBounds(newDate)) {
                    currentDate = newDate;
                    fireStateChanged();
                }
            }
        }
    }

    @Override
    public Object getNextValue() {
        LocalDate nextDate = currentDate.plus(1, incrementUnit);
        return isWithinBounds(nextDate) ? nextDate : null;
    }

    @Override
    public Object getPreviousValue() {
        LocalDate previousDate = currentDate.minus(1, incrementUnit);
        return isWithinBounds(previousDate) ? previousDate : null;
    }

    private boolean isWithinBounds(LocalDate date) {
        boolean afterMin = (minDate == null || !date.isBefore(minDate));
        boolean beforeMax = (maxDate == null || !date.isAfter(maxDate));
        return afterMin && beforeMax;
    }

}

