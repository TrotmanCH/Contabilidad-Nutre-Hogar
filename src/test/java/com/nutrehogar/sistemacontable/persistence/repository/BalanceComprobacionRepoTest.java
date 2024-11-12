package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalanceComprobacionRepoTest {
    BalanceComprobacionRepo repo;

    @BeforeEach
    void setUp() {
        repo = BalanceComprobacionRepo.getInstance();
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void find() {
        repo.find(null, null, null).ifPresent(System.out::println);
    }

}