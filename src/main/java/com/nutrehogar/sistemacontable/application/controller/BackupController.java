package com.nutrehogar.sistemacontable.application.controller;

import com.nutrehogar.sistemacontable.ui.view.BackupView;
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
