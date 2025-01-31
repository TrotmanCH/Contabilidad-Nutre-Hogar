package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.repository.crud.AccountSubtypeRepository;
import com.nutrehogar.sistemacontable.domain.AccountType;
import com.nutrehogar.sistemacontable.domain.core.CRUDRepositoryImpl;
import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;
import com.nutrehogar.sistemacontable.exception.RepositoryException;
import org.hibernate.Session;

import java.util.List;

public class AccountSubtypeRepositoryImpl extends CRUDRepositoryImpl<AccountSubtype, Integer>
        implements AccountSubtypeRepository {

    public AccountSubtypeRepositoryImpl(Session session) {
        super(AccountSubtype.class, session);
    }

    @Override
    public List<AccountSubtype> findAllByAccountType(AccountType accountType) throws RepositoryException {
        return executeInTransaction(() ->
                getSession().createQuery(
                                "FROM AccountSubtype WHERE accountType = :accountType ORDER BY id",
                                AccountSubtype.class
                        )
                        .setParameter("accountType", accountType)
                        .list()
        );
    }
}