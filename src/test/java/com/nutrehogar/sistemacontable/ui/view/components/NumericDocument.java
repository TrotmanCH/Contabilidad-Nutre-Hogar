package com.nutrehogar.sistemacontable.ui.view.components;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

public class NumericDocument extends PlainDocument {
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
        if (str == null) return;

        // Verifica si el texto no supera el límite
        if ((getLength() + str.length()) <= 10) {
            super.insertString(offs, str, a);
        }
    }
}
