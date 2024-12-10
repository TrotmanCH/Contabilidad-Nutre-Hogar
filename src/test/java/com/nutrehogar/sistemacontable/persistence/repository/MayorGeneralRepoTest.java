//package com.nutrehogar.sistemacontable.persistence.repository;
//
//import com.nutrehogar.sistemacontable.domain.util.filter.MayorGenFilter;
//import com.nutrehogar.sistemacontable.domain.util.order.MayorGenField;
//import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
//import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import javax.swing.*;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Date;
//import java.util.List;
//
//class MayorGeneralRepoTest {
//
//    MayorGenRepo repo;
//
//    @BeforeEach
//    void setUp() {
//        repo = MayorGenRepo.getInstance();
//    }
//
//    @AfterEach
//    void tearDown() {
//        HibernateUtil.shutdown();
//    }
//
//    @Test
//    void find() {
//
//        var startDate = LocalDate.of(2024, 1, 1);
//        var endDate = LocalDate.of(2024, 12, 31);
//        var dateFilter = MayorGenFilter.ByFechaRange.of(startDate, endDate);
//        var cueFilter = MayorGenFilter.ByNombreCuenta.of("Bancos");
//        List<MayorGenFilter> filters = List.of(dateFilter, cueFilter);
//        var orderField = MayorGenField.ASIENTO_FECHA;
//        var order = OrderDirection.ASCENDING;
//
//        var response = repo.find(filters, orderField, order);
//
//        response.ifPresent(mayorGeneralDTOS -> {
//            mayorGeneralDTOS.forEach(System.out::println);
//        });
//    }
//
//
//    @Test
//    void findNull() {
//        repo.find(null, null, null).ifPresentOrElse(mayorGeneralDTOS -> {
//            mayorGeneralDTOS.forEach(System.out::println);
//        }, () -> {
//            System.out.println("Error");
//        });
//    }
//
//    @Test
//    void tipoCuentaIdTest() {
//        repo.find(null, null, null).ifPresentOrElse(mayorGeneralDTOS -> {
//            mayorGeneralDTOS.forEach(System.out::println);
//        }, () -> {
//            System.out.println("Error");
//        });
//    }
//
//    @Test
//    void test() {
//        Date date = new Date(); // Objeto Date actual
//
//        // Convertir Date a LocalDate
//        LocalDate localDate = date.toInstant()
//                .atZone(ZoneId.systemDefault())
//                .toLocalDate();
//        var dateModel = new SpinnerDateModel();
//        var spiner = new JSpinner(dateModel);
//        var data = dateModel.getDate();
//
//        System.out.println("Fecha (Date): " + date);
//        System.out.println("Fecha (LocalDate): " + localDate);
//    }
//}