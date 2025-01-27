package com.nutrehogar.sistemacontable.domain;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.application.repository.business.DiaryBookRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DiaryBookRepositoryImplTest {
    Session session;
    DiaryBookRepositoryImpl repository;

    @BeforeEach
    void setUp() {
        session = HibernateUtil.getSession();
        repository = new DiaryBookRepositoryImpl(session);

    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void find() {
        repository.find(
                DiaryBookRepositoryImpl.Field.ASIENTO_FECHA,
                OrderDirection.DESCENDING,
                new DiaryBookRepositoryImpl.Filter.ByFechaRange(
                        LocalDate.of(2000, 1, 1),
                        LocalDate.of(2030, 1, 1)
                )
        ).forEach(System.out::println);
    }
}