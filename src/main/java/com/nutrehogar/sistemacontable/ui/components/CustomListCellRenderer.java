package com.nutrehogar.sistemacontable.ui.components;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;

import javax.swing.*;
import java.awt.*;

public class CustomListCellRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
                                                  boolean cellHasFocus) {
        var label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
        label.setText(switch (value) {
                    case com.nutrehogar.sistemacontable.domain.TipoCuenta tipoCuenta ->
                            tipoCuenta.getId() + " " + tipoCuenta.name();
                    case SubTipoCuenta tipoCuenta -> tipoCuenta.getId() + " " + tipoCuenta.getNombre();
                    case Cuenta cuenta -> cuenta.getId() + " " + cuenta.getNombre();
                    case com.nutrehogar.sistemacontable.domain.model.TipoCuenta tipoCuenta2 ->
                            tipoCuenta2.getId() + " " + tipoCuenta2.getNombre();
                    default -> value.toString();
                }
        );
        return label;
    }
}