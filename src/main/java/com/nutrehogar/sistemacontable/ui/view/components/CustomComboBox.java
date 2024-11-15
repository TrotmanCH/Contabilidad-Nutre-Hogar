package com.nutrehogar.sistemacontable.ui.view.components;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.ui.controller.TipoCuenta;

import javax.swing.*;
import java.awt.*;

public class CustomComboBox<E> extends JComboBox<E> {
    {
        setRenderer(new CustomListCellRenderer());
    }

    public CustomComboBox() {
    }

    public CustomComboBox(ComboBoxModel<E> aModel) {
        super(aModel);
    }

    static class CustomListCellRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                      boolean cellHasFocus) {
            var label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (value instanceof TipoCuenta tipoCuenta) {
                label.setText(tipoCuenta.getId() + " - " + tipoCuenta.name().toLowerCase());
            } else if (value instanceof SubTipoCuenta tipoCuenta) {
                label.setText(tipoCuenta.getId() + " - " + tipoCuenta.getNombre().toLowerCase());
            } else if (value instanceof Cuenta cuenta) {
                label.setText(cuenta.getId() + " - " + cuenta.getNombre());
            }
            return label;
        }
    }
}
