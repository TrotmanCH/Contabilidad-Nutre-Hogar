package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.repository.business.BusinessRepository;
import com.nutrehogar.sistemacontable.application.service.Util;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinner;
import com.nutrehogar.sistemacontable.ui.components.LocalDateSpinnerModel;
import com.nutrehogar.sistemacontable.ui.view.BusinessView;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.nutrehogar.sistemacontable.application.service.Util.END_PERIOD;
import static com.nutrehogar.sistemacontable.application.service.Util.START_PERIOD;

@Getter
@Setter
public abstract class BusinessController<T> extends Controller<T> {
    private LocalDateSpinnerModel spinnerModelStartPeriod;
    private LocalDateSpinnerModel spinnerModelEndPeriod;

    public BusinessController(BusinessRepository<T> repository, BusinessView view) {
        super(repository, view);
    }

    @Override
    protected void initialize() {
        setPeriod();
        super.initialize();
    }

    private void setPeriod() {
        spinnerModelStartPeriod = getSpinnerStartPeriod().getModel();
        if (spinnerModelStartPeriod == null) {
            spinnerModelStartPeriod = new LocalDateSpinnerModel(START_PERIOD);
        } else {
            spinnerModelStartPeriod.setValue(START_PERIOD);
        }
        spinnerModelEndPeriod = getSpinnerEndPeriod().getModel();
        if (spinnerModelEndPeriod == null) {
            spinnerModelEndPeriod = new LocalDateSpinnerModel(END_PERIOD);
        } else {
            spinnerModelEndPeriod.setValue(END_PERIOD);
        }
    }

    @Override
    protected void setupViewListeners() {
        Util.setTableRenderer(getTable());
        getBtnEdit().setEnabled(false);
        getBtnFilter().addActionListener(e -> {
            loadData();
            setSelected(null);
            getBtnEdit().setEnabled(false);
        });
        getBtnClear().addActionListener(e -> clearView());
        getTable().addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setElementSelected(e);
            }
        });
    }

    public void clearView() {
        setPeriod();
        setSelected(null);
        getBtnEdit().setEnabled(false);
        getData().clear();
        loadData();
    }

    protected abstract void setElementSelected(@NotNull MouseEvent e);


    @Override
    public BusinessView getView() {
        return (BusinessView) super.getView();
    }

    @Override
    public BusinessRepository<T> getRepository() {
        return (BusinessRepository<T>) super.getRepository();
    }

    public LocalDateSpinner getSpinnerStartPeriod() {
        return getView().getSpinnerStartPeriod();
    }

    public LocalDateSpinner getSpinnerEndPeriod() {
        return getView().getSpinnerEndPeriod();
    }

    public JButton getBtnFilter() {
        return getView().getBtnFilter();
    }

    public JButton getBtnClear() {
        return getView().getBtnClear();
    }
}