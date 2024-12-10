//package com.nutrehogar.sistemacontable.persistence.repository;
//
//import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//class LibroDiarioRepoTest {
//    LibroDiarioRepo libroDiarioRepo;
//
//    @BeforeEach
//    void setUp() {
//        libroDiarioRepo = LibroDiarioRepo.getInstance();
//    }
//
//    @AfterEach
//    void tearDown() {
//        HibernateUtil.shutdown();
//    }
//
//    @Test
//    void find() {
//        libroDiarioRepo.find(null, null, null).ifPresent(libroDiarioDTOS -> {
//            libroDiarioDTOS.forEach(System.out::println);
//        });
//    }
//
//    @Test
//    void tes() {
//        String[] nombres = {"Yoseph", "Ale", "Noel"};
//        var list = List.of(5678, 789, 6789, 8756890, 6576879);
//        Integer sum = 0;
//        for (var i : list) {
//            sum += i;
//            System.out.println(i);
//        }
//        System.out.println(sum);
//    }
//}