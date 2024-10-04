
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.persistence.model.CuentaEntity;
import com.nutrehogar.sistemacontable.persistence.repository.CuentaHibernateRepository;

import java.util.List;

public class SistemaContable {

    public static void main(String[] args) {

        CuentaHibernateRepository cuentaRepo = CuentaHibernateRepository.getInstance();
        cuentaRepo.save(CuentaEntity.builder().nombre("Yose").noCuenta("1093").build());
        List<CuentaEntity> cuentas = cuentaRepo.findAll();
        cuentas.forEach(System.out::println);

//        BackupService.backupDatabaseJSON();
    }
}
