package com.nutrehogar.sistemacontable.ui.controller;

import com.formdev.flatlaf.FlatLightLaf;
import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.BalanceCheckRepositoryImpl;
import com.nutrehogar.sistemacontable.ui.view.BalanceCheckView;
import com.nutrehogar.sistemacontable.ui.view.Main;
import com.nutrehogar.sistemacontable.ui.view.MainContent;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class BalanceCheckControllerTest {


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