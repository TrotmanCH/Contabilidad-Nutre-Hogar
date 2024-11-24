package com.nutrehogar.sistemacontable.ui.view.components;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListDataListener;

/**
 * Modelo de un comboBox que puede resivir cualquier enum como valor
 * @author Calci
 * @param <E>
 */
public class EnumComboBoxModel<E extends Enum<E>> implements ComboBoxModel<E> {
    private final E[] values;
    private E selected;

    public EnumComboBoxModel(@NotNull Class<E> enumClass) {
        this.values = enumClass.getEnumConstants();
        if (this.values.length > 0) {
            this.selected = values[0];
        }
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.selected = (E) anItem;
    }

    @Override
    public @Nullable Object getSelectedItem() {
        return selected;
    }

    @Override
    public int getSize() {
        return values.length;
    }

    @Override
    public E getElementAt(int index) {
        return values[index];
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
