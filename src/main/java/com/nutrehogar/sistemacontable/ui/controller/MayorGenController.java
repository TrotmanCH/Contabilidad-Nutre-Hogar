package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.dto.MayorGenDTO;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGenField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGenRepo;
import com.nutrehogar.sistemacontable.ui.view.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.view.components.MayorGenTableModel;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.Getter;

public class MayorGenController {
    private final MayorGenRepo MGRepo;
    @Getter
    private final MayorGenTableModel MGTableModel;
    private final LocalDateSpinner starDateSpinner;
    private final LocalDateSpinner endDateSpinner;

    public MayorGenController(MayorGenTableModel MGTableModel, LocalDateSpinner starDateSpinner, LocalDateSpinner endDateSpinner) {
        this.MGRepo = MayorGenRepo.getInstance();
        this.MGTableModel = MGTableModel;
        this.starDateSpinner = starDateSpinner;
        this.endDateSpinner = endDateSpinner;
    }

    public void loadData() {
        List<MayorGenFilter> filters = new ArrayList<>();
        if (starDateSpinner.getValue() instanceof LocalDate starDate && endDateSpinner.getValue() instanceof LocalDate endDate) {
            filters.add(new MayorGenFilter.ByFechaRange(starDate, endDate));
        }
        updateTable(filters, null, null);
    }

    public void applyFiltersAndOrder(List<MayorGenFilter> filters, MayorGenField orderField, OrderDirection orderDirection) {
        System.out.printf(filters.toString());
        updateTable(filters, orderField, orderDirection);
    }

    private void updateTable(List<MayorGenFilter> filters, MayorGenField orderField, OrderDirection orderDirection) {
        Optional<List<MayorGenDTO>> data = MGRepo.find(filters, orderField, orderDirection);
        SwingUtilities.invokeLater(() -> {
            MGTableModel.setData(data.orElseGet(List::of));
        });
    }
}