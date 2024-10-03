package com.nutrehogar.sistemacontable.persistence.repository.interfaces;

import com.nutrehogar.sistemacontable.persistence.model.TipoDocumentoEntity;

import java.util.List;

public interface ITipoDocumentoRepository {

    List<TipoDocumentoEntity> findAll();

    TipoDocumentoEntity findById(Integer id);

    void save(TipoDocumentoEntity tipoDocumento);

    void delete(TipoDocumentoEntity tipoDocumento);

    void deleteById(Integer id);

    void update(TipoDocumentoEntity tipoDocumento);
}
