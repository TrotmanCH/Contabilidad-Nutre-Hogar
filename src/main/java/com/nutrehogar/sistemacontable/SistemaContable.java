
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.persistence.repository.CuentaHibernateRepository;

public class SistemaContable {

    public static void main(String[] args) {
CuentaHibernateRepository cuentaHibernateRepository = CuentaHibernateRepository.getInstance();
cuentaHibernateRepository.findAll();
    }
}
