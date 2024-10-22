package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CuentaRepoTest {


    private CuentaRepo cuentaRepo;
    private Session session;

    @BeforeEach
    public void setUp() {
        cuentaRepo = CuentaRepo.getInstance();
        session = HibernateUtil.getSession();
        session.beginTransaction();
    }

    @AfterEach
    public void tearDown() {
        session.getTransaction().rollback(); // Deshacer los cambios realizados
        session.close();
    }

    @Test
    public void test() {

    }

    @Test
    public void testFindAll() {
        // Prepara datos de prueba
//        Cuenta cuenta1 = new Cuenta();
//        cuenta1.setNombre("Cuenta 1");
//        cuenta1.setSaldo(BigDecimal.valueOf(1000));

//        session.save(cuenta1); // Guardar la cuenta en la base de datos

//        cuentaRepo.findAll().forEach(System.out::println); // Llamar al método que se va a probar

//        assertEquals(1, cuentas.size()); // Verificar que se encontró una cuenta
//        assertEquals("Cuenta 1", cuentas.get(0).getNombre()); // Verificar el nombre de la cuenta
    }
}