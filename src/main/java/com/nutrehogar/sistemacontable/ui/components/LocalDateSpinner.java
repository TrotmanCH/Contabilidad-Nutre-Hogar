package com.nutrehogar.sistemacontable.ui.components;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.temporal.ChronoUnit;

/**
 * Spinner que tiene como valor un {@link java.time.LocalDate}, para esto tiene un {@link LocalDateSpinnerModel}.
 *
 * @author Calcifer1331
 * @see LocalDateSpinnerModel
 */
@Getter
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

    /**
     * Le da la funcionalidad al espiner de aumentar o decrementar la fecha dependiendo de que seccion se la seleccionada
     */
    public final void configEditor() {
        JSpinner.DefaultEditor editor = new JSpinner.DefaultEditor(this);
        this.setEditor(editor);
        editor.getTextField().addMouseListener(new MouseAdapter() {
            @Override
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
