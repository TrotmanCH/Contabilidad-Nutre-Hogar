package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Asiento.AsientoBuilder;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import com.nutrehogar.sistemacontable.persistence.repository.AsientoRepo;
import java.time.LocalDate;

public final class AsientoControl {       
    
    public Asiento guardarDatos(Integer numero, LocalDate fecha, String concepto, TipoDocumento tipo) {
        AsientoBuilder nuevoAsiento = Asiento.builder();
        nuevoAsiento.id(numero);
        nuevoAsiento.fecha(fecha);
        nuevoAsiento.concepto(concepto);
        nuevoAsiento.tipoDocumento(tipo);
        
        AsientoRepo asientoRepo = AsientoRepo.getInstance();
        Asiento asientoListo = nuevoAsiento.build();
        asientoRepo.save(asientoListo);
        return asientoListo;
    }
}
