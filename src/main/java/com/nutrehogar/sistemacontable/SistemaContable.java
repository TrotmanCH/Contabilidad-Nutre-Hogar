
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.persistence.model.CuentaEntity;
import com.nutrehogar.sistemacontable.persistence.model.TipoDocumentoEntity;
import com.nutrehogar.sistemacontable.persistence.model.TransaccionEntity;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaHibernateRepository;
import com.nutrehogar.sistemacontable.persistence.repository.TransaccionHibernateRepository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SistemaContable {
    public static void main(String[] args) {
        TransaccionHibernateRepository transaccionRepo = TransaccionHibernateRepository.getInstance();
        List<TransaccionEntity> transacciones = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            transacciones.add(TransaccionEntity.builder()
                    .fecha(LocalDate.now())
                    .credito(BigDecimal.valueOf(i))
                    .noCheque("num:" + i)
                    .noDocumento(i)
                    .referencia("est")
                    .cuenta(CuentaEntity.builder()
                            .noCuenta("NoCuenta:" + i)
                            .nombre("nombre:" + i)
                            .build())
                    .tipoDocumento(TipoDocumentoEntity.builder()
                            .nombre("nombre:" + i)
                            .build())
                    .build());
        }
        transaccionRepo.save(transacciones);
        System.out.println(transacciones.size());

        CuentaHibernateRepository cuentaRepo = CuentaHibernateRepository.getInstance();
        // Comienza a medir el tiempo
        long startTime = System.currentTimeMillis();

        // Realiza la consulta
        CuentaEntity cuenta = cuentaRepo.findByNoCuenta("15001");


        // Termina de medir el tiempo
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime; // Tiempo en milisegundos

        // Muestra información
        System.out.println("Consulta realizada en: " + duration + " ms");
        System.out.println(cuenta);
    }
}
