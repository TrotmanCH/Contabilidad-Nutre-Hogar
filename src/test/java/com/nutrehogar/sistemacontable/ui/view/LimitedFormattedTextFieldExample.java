package com.nutrehogar.sistemacontable.ui.view;

import lombok.Setter;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.NumberFormat;

public class LimitedFormattedTextFieldExample {

    public static void main(String[] args) {
        JFrame frame = new JFrame("JFormattedTextField Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(200, 20));
        var filter = new DocumentSizeFilter(5);
        ((PlainDocument) textField.getDocument()).setDocumentFilter(filter);
        JButton changeLimitButton = new JButton("Cambiar Límite");
        changeLimitButton.addActionListener(e -> {
            String newLimitStr = JOptionPane.showInputDialog(frame, "Ingrese el nuevo límite de caracteres:");
            try {
                int newLimit = Integer.parseInt(newLimitStr);
                if (newLimit > 0) {
                    textField.setText(""); // Limpiar el campo para evitar valores conflictivos
                    filter.setMaxCaracteres(newLimit);
                } else {
                    JOptionPane.showMessageDialog(frame, "El límite debe ser mayor que 0.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Por favor, ingrese un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Panel para organizar los componentes
        JPanel panel = new JPanel();
        panel.add(textField);
        panel.add(changeLimitButton);

        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // Filtro para limitar el número de caracteres
    @Setter
    static class DocumentSizeFilter extends DocumentFilter {
        private int maxCaracteres = 10; // Límite de 10 caracteres

        public DocumentSizeFilter(int maxCaracteres) {
            this.maxCaracteres = maxCaracteres;
        }

        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("\\d*") && (fb.getDocument().getLength() + string.length()) <= maxCaracteres) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("\\d*") && (fb.getDocument().getLength() + text.length() - length) <= maxCaracteres) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }
}
