package com.nutrehogar.sistemacontable.ui.components;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.SubTipoCuenta;
import com.nutrehogar.sistemacontable.domain.TipoCuenta;

import javax.swing.*;
import java.awt.*;

/**
 * Combobox personalizado, se usa para definir el tipo de renderizado que tendra cada tipo de dato.
 * <p>
 * Los ya definidos son:
 * <u>
 * <li>{@link TipoCuenta}</li>
 * <li>{@link SubTipoCuenta}</li>
 * <li>{@link Cuenta}</li>
 * </u>
 *
 * @param <E>
 * @author Calcifer1331
 */
public class CustomComboBox<E> extends JComboBox<E> {
    {
        setRenderer(new CustomListCellRenderer());
    }

    public CustomComboBox() {
    }

//    public CustomComboBox(ComboBoxModel<E> aModel) {
//        super(aModel);
//    }

}
