package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.repository.business.BusinessRepository;
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
    private LocalDateSpinnerModel spnModelStartPeriod;
    private LocalDateSpinnerModel spnModelEndPeriod;

    public BusinessController(BusinessRepository<T> repository, BusinessView view) {
        super(repository, view);
    }

    @Override
    protected void initialize() {
        startSpnModel();
        super.initialize();
    }

    private void startSpnModel() {
        spnModelStartPeriod = getSpnStart().getModel();
        if (spnModelStartPeriod == null) {
            spnModelStartPeriod = new LocalDateSpinnerModel(START_PERIOD);
        } else {
            setStartPeriod();
        }
        spnModelEndPeriod = getSpnEnd().getModel();
        if (spnModelEndPeriod == null) {
            spnModelEndPeriod = new LocalDateSpinnerModel(END_PERIOD);
        } else {
            setEndPeriod();
        }
    }

    private void setStartPeriod() {
        spnModelStartPeriod.setValue(START_PERIOD);
    }

    private void setEndPeriod() {
        spnModelEndPeriod.setValue(END_PERIOD);
    }

    @Override
    protected void setupViewListeners() {
        getBtnEdit().setEnabled(false);
        getBtnFilter().addActionListener(e -> {
            loadData();
            setSelected(null);
            getBtnEdit().setEnabled(false);
        });
        getBtnResetStart().addActionListener(e -> {
            setStartPeriod();
            clearView();
        });
        getBtnResetEnd().addActionListener(e -> {
            setEndPeriod();
            clearView();
        });
        getTblData().addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setElementSelected(e);
            }
        });
    }

    public void clearView() {
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

    public LocalDateSpinner getSpnStart() {
        return getView().getSpnStart();
    }

    public LocalDateSpinner getSpnEnd() {
        return getView().getSpnEnd();
    }

    public JButton getBtnFilter() {
        return getView().getBtnFilter();
    }

    public JButton getBtnResetStart() {
        return getView().getBtnResetStart();
    }

    public JButton getBtnResetEnd() {
        return getView().getBtnResetEnd();
    }
}