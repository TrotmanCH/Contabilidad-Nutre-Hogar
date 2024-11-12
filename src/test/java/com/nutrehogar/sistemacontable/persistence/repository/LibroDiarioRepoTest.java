package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LibroDiarioRepoTest {
    LibroDiarioRepo libroDiarioRepo;

    @BeforeEach
    void setUp() {
        libroDiarioRepo = LibroDiarioRepo.getInstance();
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void find() {
        libroDiarioRepo.find(null, null, null).ifPresent(System.out::println);
    }
}