package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.OrderDirection;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class MayorGenRepoTest {
    Session session;
    MayorGenRepo mayorGenRepo;

    @BeforeEach
    void setUp() {
        session = HibernateUtil.getSession();
        mayorGenRepo = new MayorGenRepo(session);
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void find() {
        mayorGenRepo.find(
                MayorGenRepo.Field.ASIENTO_FECHA,
                OrderDirection.DESCENDING,
                new MayorGenRepo.Filter.ByFechaRange(
                        LocalDate.of(2025, 1, 4),
                        LocalDate.of(2025, 1, 12)
                )
        ).forEach(System.out::println);
    }
}