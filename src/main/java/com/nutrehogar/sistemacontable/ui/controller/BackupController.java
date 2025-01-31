package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.ui.view.BackupView;
import com.nutrehogar.sistemacontable.ui.view.View;
import lombok.Getter;

@Getter
public class BackupController extends Controller {

    public BackupController(BackupView view) {
        super(view);
    }

    @Override
    protected void initialize() {

    }

    @Override
    protected void setupViewListeners() {
    }

    @Override
    public BackupView getView() {
        return (BackupView) super.getView();
    }
}
