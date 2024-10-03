
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.persistence.model.CuentaEntity;
import com.nutrehogar.sistemacontable.persistence.model.TipoDocumentoEntity;
import com.nutrehogar.sistemacontable.persistence.model.TransaccionEntity;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaHibernateRepository;
import com.nutrehogar.sistemacontable.persistence.repository.TipoDocumentoHibernateRepository;
import com.nutrehogar.sistemacontable.persistence.repository.TransaccionHibernateRepository;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SistemaContable {
    /**
     * metodo que cierra la session y el factory.
     * Es importante que se cierren correctamente para evitar perdida de datos. En la implementacion final se debe asignar esta funciona a un Listener de el bton close de windows.
     */

    public static void main(String[] args) {
        TransaccionHibernateRepository transaccionRepo = TransaccionHibernateRepository.getInstance();
        CuentaHibernateRepository cuentaRepo = CuentaHibernateRepository.getInstance();
        TipoDocumentoHibernateRepository tipoDocumentoRepo = TipoDocumentoHibernateRepository.getInstance();
        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoRepo.findById(1);
        CuentaEntity cuenta = cuentaRepo.findById(1);
        CuentaEntity cuenta2 = cuentaRepo.findById(2);

        transaccionRepo.save(TransaccionEntity.builder().fecha(LocalDate.now()).credito(BigDecimal.valueOf(198467)).cuenta(cuenta).noCheque("es").noDocumento(122).tipoDocumento(tipoDocumentoEntity).build());
        TransaccionEntity transaccionEntity = transaccionRepo.findById(2);
        System.out.println(transaccionEntity+"  "+ transaccionEntity.getCuenta()+"  "+ transaccionEntity.getTipoDocumento());
        transaccionEntity.setCuenta(cuenta2);
        transaccionRepo.update(transaccionEntity);
        transaccionEntity = transaccionRepo.findById(2);
        System.out.println(transaccionEntity+"  "+ transaccionEntity.getCuenta());

    }
}
