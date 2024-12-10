package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.util.filter.BalanceComFilter;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BalanceComprobacionRepoTest {
    BalanceComRepo repo;

    @BeforeEach
    void setUp() {
//        repo = BalanceComRepo.getInstance();
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void find() {
//        repo.find(List.of(), null, null).ifPresent(System.out::println);
    }

}