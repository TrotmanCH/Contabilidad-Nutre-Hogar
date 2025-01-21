package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.model.TipoDocumento;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class TipoDocumentoRepo {
    private static final Logger logger = LoggerFactory.getLogger(TipoDocumentoRepo.class);
    private static final Session session = HibernateUtil.getSession();

    public static List<TipoDocumento> findAll() {
        List<TipoDocumento> transaccions = List.of();
        try {
            session.beginTransaction();
            transaccions = session.createQuery("from TipoDocumento", TipoDocumento.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al consultar los tipos de documento", e);
        }
        return transaccions;
    }

    public static TipoDocumento findById(Integer id) {
        return session.find(TipoDocumento.class, id);
    }

    public static void save(TipoDocumento tipoDocumento) {
        try {
            session.beginTransaction();
            session.persist(tipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al guardar los tipos de documento", e);
        }
    }

    public static void save(@NotNull List<TipoDocumento> tipoDocumentos) {
        try {
            session.beginTransaction();
            tipoDocumentos.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al guardar los tipos de documento", e);
        }
    }

    public static void delete(TipoDocumento tipoDocumento) {
        try {
            session.beginTransaction();

            session.remove(session.contains(tipoDocumento) ? tipoDocumento : session.merge(tipoDocumento));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al eliminar los tipos de documento", e);
        }
    }

    public static void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(findById(id)).ifPresent(session::remove);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al eliminar los tipos de documento", e);
        }
    }

    public static void update(TipoDocumento tipoDocumento) {
        try {
            session.beginTransaction();
            session.merge(tipoDocumento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al actualizar los tipos de documento", e);
        }
    }
}
