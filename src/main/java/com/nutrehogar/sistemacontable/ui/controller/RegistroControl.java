package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.Registro.RegistroBuilder;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import java.math.BigDecimal;

public class RegistroControl {
    
    public Registro crear(Asiento asiento, TipoDocumento tipo, String comprobante,
            String referencia, Cuenta cuenta, BigDecimal debe, BigDecimal haber) {
        RegistroBuilder nuevoRegistro = Registro.builder(); 
        
        nuevoRegistro.asiento(asiento);
        nuevoRegistro.tipoDocumento(tipo);
        nuevoRegistro.comprobante(comprobante);
        nuevoRegistro.referencia(referencia);
        nuevoRegistro.cuenta(cuenta);
        nuevoRegistro.debe(debe);
        nuevoRegistro.haber(haber);
        
        Registro registroListo = nuevoRegistro.build();
        return registroListo;
    }
}
