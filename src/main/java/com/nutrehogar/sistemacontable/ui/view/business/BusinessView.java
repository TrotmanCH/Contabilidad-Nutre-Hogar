package com.nutrehogar.sistemacontable.ui.view.business;

import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.SimpleView;

import javax.swing.*;

public abstract class BusinessView extends SimpleView {
    public abstract LocalDateSpinner getSpnStart();

    public abstract LocalDateSpinner getSpnEnd();

    public abstract JButton getBtnFilter();

    public abstract JButton getBtnResetStart();

    public abstract JButton getBtnResetEnd();
}