package com.nutrehogar.sistemacontable.ui.styles;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Arrays;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicButtonUI;

public class ButtonStyle {
    public ButtonStyle(JButton... botones) {
        Arrays.asList(botones).forEach((boton) -> {
            boton.setContentAreaFilled(false);
            boton.setBorderPainted(false);
            boton.setFocusPainted(false);
            
            boton.setUI(new BasicButtonUI() {
                @Override
                public void paint(Graphics g, JComponent c) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(Color.decode("#1E88E5")); 
                    g2d.fillRoundRect(0, 0, c.getWidth(), c.getHeight(), 25, 25); 
                    g2d.dispose();

                    super.paint(g, c);
                }
                @Override
                protected void paintButtonPressed(Graphics g, AbstractButton b) {
                    Graphics2D g2d = (Graphics2D) g.create();
                    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                    g2d.setColor(Color.decode("#105189")); 
                    g2d.fillRoundRect(0, 0, b.getWidth(), b.getHeight(), 25, 25); 
                    g2d.dispose();
                    
                    super.paintButtonPressed(g, b);
                }
            });
        });
    }
}
