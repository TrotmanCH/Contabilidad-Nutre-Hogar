package com.nutrehogar.sistemacontable.ui.view.crud;

import com.nutrehogar.sistemacontable.ui.view.SimpleView;

import javax.swing.*;

public abstract class CRUDView extends SimpleView {
    public abstract JButton getBtnDelete();

    public abstract JButton getBtnSave();

    public abstract JButton getBtnAdd();

    public abstract JButton getBtnUpdate();
}
