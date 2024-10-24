package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Asiento.AsientoBuilder;
import com.nutrehogar.sistemacontable.domain.model.Registro;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import java.time.LocalDate;
import java.util.List;

public final class AsientoControl {       
    
    public Asiento crear(Integer numero, LocalDate fecha, String concepto, 
            TipoDocumento tipo, List<Registro> registros) {
        AsientoBuilder nuevoAsiento = Asiento.builder();
        
        nuevoAsiento.id(numero);
        nuevoAsiento.fecha(fecha);
        nuevoAsiento.concepto(concepto);
        nuevoAsiento.tipoDocumento(tipo);
        nuevoAsiento.registros(registros);
        
        Asiento asientoListo = nuevoAsiento.build();
        return asientoListo;
    }
}
