package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.MayorGeneralDTO;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGeneralFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGeneralOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGeneralRepo;
import com.nutrehogar.sistemacontable.ui.view.components.MayorGeneralTableModel;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class MayorGeneralController {
    private final MayorGeneralRepo mayorGeneralRepo;
    private final MayorGeneralTableModel mayorGeneralTableModel;

    public MayorGeneralController(MayorGeneralTableModel mayorGeneralTableModel) {
        this.mayorGeneralRepo = MayorGeneralRepo.getInstance();
        this.mayorGeneralTableModel = mayorGeneralTableModel;
    }

    public void loadData() {
        updateTable(null, null, null);
    }

    public void applyFiltersAndOrder(List<MayorGeneralFilter> filters, MayorGeneralOrderField orderField, OrderDirection orderDirection) {
        updateTable(filters, orderField, orderDirection);
    }

    private void updateTable(List<MayorGeneralFilter> filters, MayorGeneralOrderField orderField, OrderDirection orderDirection) {
        Optional<List<MayorGeneralDTO>> data = mayorGeneralRepo.find(filters, orderField, orderDirection);

        // Utilizamos SwingUtilities para actualizar el JTable en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            data.ifPresentOrElse(mayorGeneralTableModel::setData,
                    () -> mayorGeneralTableModel.setData(List.of())); // Si no hay datos, limpiar la tabla
        });
    }
}