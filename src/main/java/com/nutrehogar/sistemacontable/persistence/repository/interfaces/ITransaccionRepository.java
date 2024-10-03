package com.nutrehogar.sistemacontable.persistence.repository.interfaces;

import com.nutrehogar.sistemacontable.persistence.model.TransaccionEntity;

import java.util.List;

public interface ITransaccionRepository {

    List<TransaccionEntity> findAll();

    TransaccionEntity findById(Integer id);

    void save(TransaccionEntity transaccionEntity);

    void delete(TransaccionEntity transaccionEntity);

    void deleteById(Integer id);

    void update(TransaccionEntity transaccionEntity);
}
