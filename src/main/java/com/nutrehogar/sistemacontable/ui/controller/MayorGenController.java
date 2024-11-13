package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGenField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGenRepo;
import com.nutrehogar.sistemacontable.ui.view.components.MayorGenTableModel;

import javax.swing.*;
import java.util.List;
import java.util.Optional;

public class MayorGenController {
    private final MayorGenRepo MGRepo;
    private final MayorGenTableModel MGTableModel;

    public MayorGenController(MayorGenTableModel MGTableModel) {
        this.MGRepo = MayorGenRepo.getInstance();
        this.MGTableModel = MGTableModel;
    }

    public void loadData() {
        updateTable(null, null, null);
    }

    public void applyFiltersAndOrder(List<MayorGenFilter> filters, MayorGenField orderField, OrderDirection orderDirection) {
        updateTable(filters, orderField, orderDirection);
    }

    private void updateTable(List<MayorGenFilter> filters, MayorGenField orderField, OrderDirection orderDirection) {
        Optional<List<MayorGenDTO>> data = MGRepo.find(filters, orderField, orderDirection);

        SwingUtilities.invokeLater(() -> {
            if (data.isPresent()) {
                MGTableModel.setData(data.get());
            } else {
                MGTableModel.setData(List.of());
            }
        });
    }
}