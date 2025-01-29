package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;

import javax.swing.*;

public interface BusinessView extends View {
    LocalDateSpinner getSpnStart();

    LocalDateSpinner getSpnEnd();

    JButton getBtnFilter();

    JButton getBtnResetStart();

    JButton getBtnResetEnd();
}