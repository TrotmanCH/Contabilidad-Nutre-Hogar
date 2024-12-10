package com.nutrehogar.sistemacontable.ui.view;

import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class CustomListSelectionListener implements ListSelectionListener {
    public Integer fila;
    private JButton editar;
    private JButton eliminar;
    
    public CustomListSelectionListener(JButton editar, JButton eliminar) {
        this.editar = editar;
        this.eliminar = eliminar;
    }
    
    @Override
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel) e.getSource();
        if (!lsm.isSelectionEmpty()) {
            int minIndex = lsm.getMinSelectionIndex();
            int maxIndex = lsm.getMaxSelectionIndex();
            for (int i = minIndex; i <= maxIndex; i++) {
                if (lsm.isSelectedIndex(i)) {
                    fila = i;
                }
            }

            editar.setEnabled(true);
            eliminar.setEnabled(true);
        } else {
            editar.setEnabled(false);
            eliminar.setEnabled(false);
        }
    }
}
