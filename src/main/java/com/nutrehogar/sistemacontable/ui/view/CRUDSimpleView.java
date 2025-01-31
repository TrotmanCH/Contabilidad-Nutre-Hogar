package com.nutrehogar.sistemacontable.ui.view;

import javax.swing.*;

public abstract class CRUDSimpleView extends SimpleView {
    public abstract JButton getBtnDelete();

    public abstract JButton getBtnSave();

    public abstract JButton getBtnAdd();

    public abstract JButton getBtnUpdate();
}
