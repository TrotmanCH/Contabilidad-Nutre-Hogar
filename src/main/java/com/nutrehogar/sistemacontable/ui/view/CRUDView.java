package com.nutrehogar.sistemacontable.ui.view;

import javax.swing.*;

public interface CRUDView extends View {
    JButton getBtnDelete();

    JButton getBtnSave();

    JButton getBtnClear();

    JButton getBtnAdd();

    JButton getBtnUpdate();
}
