package com.nutrehogar.sistemacontable.ui.view.components;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDateSpinner extends JSpinner {
    private LocalDateSpinnerModel model;

    public LocalDateSpinner() {
        configModel();
        configEditor();
    }

    public void configModel() {
        model = new LocalDateSpinnerModel(LocalDate.now(), null, null, ChronoUnit.DAYS);
        this.setModel(model);
    }

    public void configEditor() {
        JSpinner.DefaultEditor editor = new JSpinner.DefaultEditor(this);
        this.setEditor(editor);
        editor.getTextField().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int position = editor.getTextField().getCaretPosition();
                if (position < 5) {
                    model.setIncrementUnit(ChronoUnit.YEARS);
                } else if (position < 8) {
                    model.setIncrementUnit(ChronoUnit.MONTHS);
                } else {
                    model.setIncrementUnit(ChronoUnit.DAYS);
                }
            }
        });
    }
}
