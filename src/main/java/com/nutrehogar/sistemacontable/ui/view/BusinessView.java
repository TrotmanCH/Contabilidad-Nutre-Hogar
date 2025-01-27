package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;

import javax.swing.*;

public interface BusinessView extends View {
    LocalDateSpinner getSpinnerStartPeriod();

    LocalDateSpinner getSpinnerEndPeriod();

    JButton getBtnFilter();

    JButton getBtnClear();
}