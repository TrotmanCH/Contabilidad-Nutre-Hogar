package com.nutrehogar.sistemacontable.ui.view.components;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.temporal.ChronoUnit;

public class LocalDateSpinner extends JSpinner {
    private final LocalDateSpinnerModel customModel;

    public LocalDateSpinner() {
        customModel = new LocalDateSpinnerModel();
        this.setModel(customModel);
        configEditor();
    }

    public LocalDateSpinner(LocalDateSpinnerModel customModel) {
        super(customModel);
        this.customModel = customModel;
        configEditor();
    }

    public void configEditor() {
        JSpinner.DefaultEditor editor = new JSpinner.DefaultEditor(this);
        this.setEditor(editor);
        editor.getTextField().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int position = editor.getTextField().getCaretPosition();
                if (position < 5) {
                    customModel.setIncrementUnit(ChronoUnit.YEARS);
                } else if (position < 8) {
                    customModel.setIncrementUnit(ChronoUnit.MONTHS);
                } else {
                    customModel.setIncrementUnit(ChronoUnit.DAYS);
                }
            }
        });
    }
}
