package com.nutrehogar.sistemacontable.domain.core;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountSubtypeRepository;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.model.Account;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUDRepositoryFactoryTest {
    Session session;

    @BeforeEach
    void setUp() {
        session = HibernateUtil.getSession();
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void createRepository() {
        // Crear el repositorio
        AccountSubtypeRepository subTipoRepository = CRUDRepositoryFactory.createRepository(
                AccountSubtypeRepository.class,
                AccountSubtype.class,
                session
        );
        AccountSubtypeRepository subTipoSubTipoRepository = CRUDRepositoryFactory.createRepository(
                AccountSubtypeRepository.class, AccountSubtype.class, session
        );

        AccountRepository accountRepository = CRUDRepositoryFactory.createRepository(
                AccountRepository.class, Account.class, session
        );
        accountRepository.findAll().forEach(System.out::println);
        System.out.printf("-----------------------------------------------------------------------");
        subTipoRepository.findAll().forEach(System.out::println);
        System.out.printf("-----------------------------------------------------------------------");
        subTipoRepository.findAllByAccountType(AccountType.ASSETS).forEach(System.out::println);


//        AccountType accountType = AccountType.EXPENSE;
//        List<AccountSubtype> subtipos = subTipoRepository.findAllByAccountType(accountType);
//
//        subtipos.forEach(subtipo -> System.out.println(subtipo.getName()));
    }
}