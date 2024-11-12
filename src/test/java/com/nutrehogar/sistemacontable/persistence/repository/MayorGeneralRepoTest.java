package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.util.filter.MayorGeneralFilter;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGeneralOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class MayorGeneralRepoTest {

    MayorGeneralRepo repo;

    @BeforeEach
    void setUp() {
        repo = MayorGeneralRepo.getInstance();
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void find() {

        var startDate = LocalDate.of(2024, 1, 1);
        var endDate = LocalDate.of(2024, 12, 31);
        var dateFilter = new MayorGeneralFilter.ByFechaRange(startDate, endDate);
        List<MayorGeneralFilter> filters = List.of(dateFilter);
        var orderField = MayorGeneralOrderField.FECHA;
        var order = OrderDirection.DESCENDING;

        var response = repo.find(filters, orderField, order);

        response.ifPresent(mayorGeneralDTOS -> {
            mayorGeneralDTOS.forEach(System.out::println);
        });
    }
    @Test
    void findNull(){
        repo.find(null, null, null).ifPresent(System.out::println);
    }
}