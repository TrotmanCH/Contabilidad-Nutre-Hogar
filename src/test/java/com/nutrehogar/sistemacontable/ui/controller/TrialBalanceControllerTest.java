package com.nutrehogar.sistemacontable.ui.controller;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TrialBalanceControllerTest {


    @BeforeEach
    void setUp() {

    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void getView() {
    }
}