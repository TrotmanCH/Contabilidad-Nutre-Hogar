package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Asiento.AsientoBuilder;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import java.time.LocalDate;
import java.util.List;

public final class AsientoControl {       
    
    public Asiento crear(LocalDate fecha, String nombre, 
            String concepto, List<Registro> registros) {
        AsientoBuilder nuevoAsiento = Asiento.builder();
        nuevoAsiento.fecha(fecha);
        nuevoAsiento.nombre(nombre);
        nuevoAsiento.concepto(concepto);
        nuevoAsiento.registros(registros);
        
        Asiento asientoListo = nuevoAsiento.build();
        return asientoListo;
    }
}
