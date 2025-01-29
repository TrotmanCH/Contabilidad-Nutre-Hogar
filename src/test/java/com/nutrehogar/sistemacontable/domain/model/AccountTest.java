package com.nutrehogar.sistemacontable.domain.model;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountRepository;
import com.nutrehogar.sistemacontable.application.repository.crud.AccountSubtypeRepository;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.core.CRUDRepositoryFactory;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountTest {

    AccountRepository accountRepository;
    AccountSubtypeRepository accountSubtypeRepository;
    Session session;

    @BeforeEach
    void setUp() {
        session = HibernateUtil.getSession();
        accountRepository = CRUDRepositoryFactory.createRepository(AccountRepository.class, Account.class, session);
        accountSubtypeRepository = CRUDRepositoryFactory.createRepository(AccountSubtypeRepository.class, AccountSubtype.class, session);
    }

    @AfterEach
    void tearDown() {
        HibernateUtil.shutdown();
    }

    @Test
    void getBalance() {
//        var subType = new AccountSubtype();
//        subType.setName("Gastos Corrientes");
//        subType.setAccountType(AccountType.EXPENSE);
//        subType.setId(1);
//        accountSubtypeRepository.save(subType);
//        var sub = accountSubtypeRepository.findAll().get(1);
//        var account = new Account();
//        account.setName("Equipo de Deporte");
//        account.setAccountSubtype(sub);
//        account.setId(20);
//        accountRepository.save(account);
        var sub = accountSubtypeRepository.findAll().get(1);
        System.out.println(sub.toString());
        var account = sub.getAccounts().get(0);
        System.out.println(account.toString());
        System.out.println("TipoCuentaId: " + sub.getAccountType().getId() + ", SubTipoCuentaId: " + sub.getCanonicalId() + ", CuentaId: " + account.getCanonicalId());

    }

    @Test
    void getCellRenderer() {
        System.out.println(Account.getCellRenderer(12001));
    }
}