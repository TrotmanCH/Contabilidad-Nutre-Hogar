package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.application.config.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AsientoRepo {
    private static final Logger logger = LoggerFactory.getLogger(AsientoRepo.class);

    private static final Session session = HibernateUtil.getSession();

    public static @NotNull @Unmodifiable List<Asiento> findAll() {
        List<Asiento> transaccions = List.of();
        try {
            session.beginTransaction();
            session.createQuery("from Asiento", Asiento.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al consultar asientos", e);
        }
        return transaccions;
    }

    public static Asiento findById(Integer id) {
        return session.find(Asiento.class, id);
    }

    public static int getSize() {
        int size = 0;
        try {
            size = session.createQuery("select count(*) from Asiento", Long.class).uniqueResult().intValue();
        } catch (Exception e) {
            logger.error("Error al consultar asientos", e);
            size = -1;
        }
        return size;
    }

    public static void save(Asiento asiento) {
        try {
            session.beginTransaction();
            session.persist(asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al guardar asiento", e);
        }
    }

    public static void save(List<Asiento> asientos) {
        try {
            session.beginTransaction();
            asientos.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al guardar asientos", e);
        }
    }

    public static void delete(Asiento asiento) {
        try {
            session.beginTransaction();

            session.remove(session.contains(asiento) ? asiento : session.merge(asiento));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al eliminar asiento", e);
        }
    }

    public static void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(session.find(Asiento.class, id)).ifPresent(session::remove);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al eliminar asiento", e);
        }
    }

    public static void update(Asiento asiento) {
        try {
            session.beginTransaction();
            session.merge(asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            logger.error("Error al actualizar asiento", e);
        }
    }
}
