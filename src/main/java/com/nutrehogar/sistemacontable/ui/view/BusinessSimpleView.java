package com.nutrehogar.sistemacontable.ui.view;

import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;

import javax.swing.*;

public abstract class BusinessSimpleView extends SimpleView {
    public abstract LocalDateSpinner getSpnStart();

    public abstract LocalDateSpinner getSpnEnd();

    public abstract JButton getBtnFilter();

    public abstract JButton getBtnResetStart();

    public abstract JButton getBtnResetEnd();
}