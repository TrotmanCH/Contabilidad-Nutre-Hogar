package com.nutrehogar.sistemacontable.application.repository;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.application.repository.crud.AsientoRepository;
import com.nutrehogar.sistemacontable.domain.core.CRUDRepositoryFactory;
import com.nutrehogar.sistemacontable.application.repository.crud.CuentaRepository;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class RepositoryFactoryTest {

    @Test
    void createRepository() {

        AsientoRepository asientoRepo = CRUDRepositoryFactory.createRepository(
                AsientoRepository.class, Asiento.class, HibernateUtil.getSession()
        );

//        // Guardar un asiento
//        Asiento asiento = new Asiento();
//        asientoRepo.save(asiento);
//
//        // Buscar un asiento por ID
        Optional<Asiento> asientoOpt = asientoRepo.findById(1);
        asientoOpt.ifPresent(System.out::println);
        asientoRepo.findAll().forEach(System.out::println);
        var cuentaRepo = CRUDRepositoryFactory.createRepository(CuentaRepository.class, Cuenta.class, HibernateUtil.getSession());

        cuentaRepo.findAll().forEach(System.out::println);
        // Eliminar un asiento por ID
//        asientoRepo.deleteById(1);

        // Contar todos los asientos
        long count = asientoRepo.count();
        System.out.println("Total de asientos: " + count);
    }
}