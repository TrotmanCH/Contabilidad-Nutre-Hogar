package com.nutrehogar.sistemacontable.ui.view.legacy.styles;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Arrays;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.ButtonUI;
import javax.swing.plaf.basic.BasicButtonUI;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ButtonStyle {
    static Color color1 = Color.decode("#1E88E5");
    static Color color2 = Color.decode("#105189");
    static ButtonUI buttonUI = new BasicButtonUI() {
        @Override
        public void paint(@NotNull Graphics g, @NotNull JComponent c) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color1);
            g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 25, 25);
            g2d.dispose();

            super.paint(g, c);
        }

        @Override
        protected void paintButtonPressed(@NotNull Graphics g, @NotNull AbstractButton b) {
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(color2);
            g2d.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 25, 25);
            g2d.dispose();

            super.paintButtonPressed(g, b);
        }
    };

    public static void setStyle(JButton @NotNull ... botones) {
        for (JButton boton : botones) {
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            boton.setUI(buttonUI);
        }
    }
}
