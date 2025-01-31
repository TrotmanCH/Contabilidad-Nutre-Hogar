package com.nutrehogar.sistemacontable.ui.JComponents.impl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DefaultPanelButton extends JButton {
    private static final Color BG_COLOR = Color.decode("#e5f3ff");
    private static final Color FONT_COLOR = Color.decode("#187212");
    private static final Color FONT_HOVER_COLOR = new Color(0, 102, 204);
    private static final Font FONT = new Font("Segoe UI Semibold", Font.BOLD, 14);

    public DefaultPanelButton() {
        super();
        setBorderPainted(false);
        setVerticalTextPosition(SwingConstants.TOP);
        setForeground(FONT_COLOR);
        setHorizontalAlignment(SwingConstants.LEADING);
        setMargin(new Insets(4, 6, 3, 14));
        setFont(FONT);
        setIconTextGap(10);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(Color.WHITE);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(BG_COLOR);
            }
        });
    }
}
