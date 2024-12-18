package com.nutrehogar.sistemacontable.ui.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.ui.controller.BalanceComController;
import com.nutrehogar.sistemacontable.ui.controller.LibroDiarioController;
import com.nutrehogar.sistemacontable.ui.controller.MayorGenController;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {
private Formulario formulario;
    private ListaCuenta listac;
    
    Formulario formularioc = new Formulario();
    ListaCuenta listaCuenta = new ListaCuenta();
    
    LibroDiarioView librodiario = LibroDiarioController.getInstance().getView();
    BalanceComView balancec = BalanceComController.getInstance().getView();
    MayorGenView mayorg = MayorGenController.getInstance().getView();
    
    public Dashboard() {
        initComponents(); 
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        listac = new ListaCuenta();
        formulario = new Formulario();
        
        showJPanel(formulario);
        
        applyButtonStyles(btnform, "Formulario", "/Icon/formulario.png");
        applyButtonStyles(btnBalancec, "Balance de Comprobación", "/Icon/balance.png");
        applyButtonStyles(btnDiario, "Libro Diario", "/Icon/book.png");
        applyButtonStyles(btnMayor, "Mayor General", "/Icon/mayor.png");
        applyButtonStyles(btnList, "Lista de Cuentas", "/Icon/lista.png");
        
        this.getContentPane().setBackground(Color.decode("#F1F8FF"));
        logoic.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Icon icon = logoic.getIcon();
                if (icon instanceof ImageIcon) {
                    ImageIcon originalImage = (ImageIcon) icon;
                    resizeImage(logoic, originalImage);
                }
            }
        });   
    }
    
    private void resizeImage(JLabel label, ImageIcon originalImage) {
        Image img = originalImage.getImage();
        Image scaledImage = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(scaledImage));
    }
    
    public static void showJPanel(JPanel p){
       content.removeAll();
       content.setLayout(new BorderLayout());
       content.add(p, BorderLayout.CENTER);
       content.revalidate();
       content.repaint();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menup = new javax.swing.JPanel();
        btnform = new javax.swing.JButton();
        btnDiario = new javax.swing.JButton();
        btnBalancec = new javax.swing.JButton();
        btnMayor = new javax.swing.JButton();
        logoic = new javax.swing.JLabel();
        btnList = new javax.swing.JButton();
        content = new javax.swing.JPanel();
        btnOc = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(241, 248, 255));

        menup.setBackground(new java.awt.Color(30, 136, 229));

        btnform.setBackground(new java.awt.Color(30, 136, 229));
        btnform.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnformActionPerformed(evt);
            }
        });

        btnDiario.setBackground(new java.awt.Color(30, 136, 229));
        btnDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiarioActionPerformed(evt);
            }
        });

        btnBalancec.setBackground(new java.awt.Color(30, 136, 229));
        btnBalancec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalancecActionPerformed(evt);
            }
        });

        btnMayor.setBackground(new java.awt.Color(30, 136, 229));
        btnMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMayorActionPerformed(evt);
            }
        });

        logoic.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo_big.png"))); // NOI18N

        btnList.setBackground(new java.awt.Color(30, 136, 229));
        btnList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menupLayout = new javax.swing.GroupLayout(menup);
        menup.setLayout(menupLayout);
        menupLayout.setHorizontalGroup(
            menupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menupLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMayor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBalancec, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDiario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnform, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoic, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                    .addComponent(btnList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menupLayout.setVerticalGroup(
            menupLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menupLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logoic)
                .addGap(9, 9, 9)
                .addComponent(btnform, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBalancec, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMayor, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnList, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 102, 102));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        btnOc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/regresa2.png"))); // NOI18N
        btnOc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnOcMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnOc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(btnOc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiarioActionPerformed
        content.removeAll();
        content.add(librodiario);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnDiarioActionPerformed

    private void btnformActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnformActionPerformed
        content.removeAll();
        content.add(formularioc);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnformActionPerformed

    private void btnBalancecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalancecActionPerformed
        content.removeAll();
        content.add(balancec);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnBalancecActionPerformed

    private void btnMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMayorActionPerformed
        content.removeAll();
        content.add(mayorg);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnMayorActionPerformed

    private void btnOcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnOcMouseClicked
        menup.setVisible(!menup.isVisible());

        if (menup.isVisible()) {
            btnOc.setIcon(new ImageIcon(getClass().getResource("/Icon/regresa2.png"))); 
        } else {
            btnOc.setIcon(new ImageIcon(getClass().getResource("/Icon/regresa.png")));
        }

        revalidate();
        repaint();
    }//GEN-LAST:event_btnOcMouseClicked

    private void btnListActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListActionPerformed
        content.removeAll();
        content.add(listaCuenta);
        content.revalidate();
        content.repaint();
    }//GEN-LAST:event_btnListActionPerformed

    private void applyButtonStyles(JButton button, String text, String iconPath) {
        button.setText("<html><center><span style='text-decoration: none;'>" + text + "</span></center></html>");
        button.setIcon(new ImageIcon(getClass().getResource(iconPath)));
        button.setHorizontalTextPosition(SwingConstants.RIGHT); 
        button.setVerticalTextPosition(SwingConstants.CENTER);  
        button.setHorizontalAlignment(SwingConstants.LEFT);    
        button.setFocusPainted(false);
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setForeground(Color.WHITE);
        button.setBorder(BorderFactory.createMatteBorder(0, 0, 3, 0, Color.WHITE));  
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                button.setBackground(Color.decode("#2E4156"));  
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                button.setBackground(null);  
            }
        });
    }
    public ImageIcon setSVG(String filePath, int width, int height) { 
        ImageIcon imageIcon = new ImageIcon(filePath); 
        Image image = imageIcon.getImage(); 
        Image resizedImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); 
        return new ImageIcon(resizedImage);
    } 
    public static void main(String args[]) {
        try {
           UIManager.setLookAndFeel(new FlatLightLaf());
        } catch(Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBalancec;
    private javax.swing.JButton btnDiario;
    private javax.swing.JButton btnList;
    private javax.swing.JButton btnMayor;
    private javax.swing.JLabel btnOc;
    private javax.swing.JButton btnform;
    private static javax.swing.JPanel content;
    private javax.swing.JLabel logoic;
    private javax.swing.JPanel menup;
    // End of variables declaration//GEN-END:variables


}

