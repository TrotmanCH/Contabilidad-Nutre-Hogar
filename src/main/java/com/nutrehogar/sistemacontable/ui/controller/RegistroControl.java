package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.Registro.RegistroBuilder;
import com.nutrehogar.sistemacontable.persistence.repository.RegistroRepo;
import java.math.BigDecimal;

public class RegistroControl {
    
    public Registro guardarDatos(Asiento asiento, String comprobante, String referencia, 
            Cuenta cuenta, BigDecimal debe, BigDecimal haber) {
        RegistroBuilder nuevoRegistro = Registro.builder(); 
        nuevoRegistro.asiento(asiento);
        nuevoRegistro.comprobante(comprobante);
        nuevoRegistro.referencia(referencia);
        nuevoRegistro.cuenta(cuenta);
        nuevoRegistro.debe(debe);
        nuevoRegistro.haber(haber);
        
        RegistroRepo registroRepo = RegistroRepo.getInstance();
        Registro registroListo = nuevoRegistro.build();
        registroRepo.save(registroListo);
        return registroListo;
    }
}
