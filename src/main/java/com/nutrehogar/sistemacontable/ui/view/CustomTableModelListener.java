package com.nutrehogar.sistemacontable.ui.view;

import java.math.BigDecimal;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

public class CustomTableModelListener implements TableModelListener {
    private final JTextField debe;
    private final JTextField haber;
    private final JTextField monto;
    
    public CustomTableModelListener(JTextField debe, JTextField haber, JTextField monto) {
        this.debe = debe;
        this.haber = haber;
        this.monto = monto;
    }
    
    @Override
    public void tableChanged(TableModelEvent e) {
        DefaultTableModel dtm = (DefaultTableModel) e.getSource();
        
        BigDecimal debeTotal = BigDecimal.ZERO;
        BigDecimal haberTotal = BigDecimal.ZERO;
        BigDecimal montoValor = BigDecimal.ZERO;
        
        for (Integer i = 0; i < dtm.getRowCount(); i++){
            Double debeValor = Double.valueOf(dtm.getValueAt(i, 4).toString());
            Double haberValor = Double.valueOf(dtm.getValueAt(i, 5).toString());
            
            debeTotal = debeTotal.add(BigDecimal.valueOf(debeValor));
            haberTotal = haberTotal.add(BigDecimal.valueOf(haberValor));
        }
        
        montoValor = debeTotal.subtract(haberTotal);
        monto.setText(montoValor.toString());
        debe.setText(debeTotal.toString());
        haber.setText(haberTotal.toString());
    }
    
}
