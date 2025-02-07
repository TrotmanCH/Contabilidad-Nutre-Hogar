package com.nutrehogar.sistemacontable.domain.repository;

import com.nutrehogar.sistemacontable.domain.HibernateUtil;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AsientoRepo {
    private static final Session session = HibernateUtil.getSession();
        
    public static List<Asiento> findAll() {
        List<Asiento> transaccions = List.of();
            try {
                session.beginTransaction();
                session.createQuery("from Asiento", Asiento.class).list();
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                e.printStackTrace();
            }
        return transaccions;
    }

    public static Asiento findById(Integer id) {
        return session.find(Asiento.class, id);
    }
    public static int getSize(){
        int size = 0;
        try {
            size = session.createQuery("select count(*) from Asiento", Long.class).uniqueResult().intValue();
        } catch (Exception e) {
            e.printStackTrace();
            size=-1;
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
        }
    }

    public static void save( List<Asiento> asientos) {
        try {
            session.beginTransaction();
            asientos.forEach(session::persist);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public static void delete(Asiento asiento) {
        try {
            session.beginTransaction();

            session.remove(session.contains(asiento) ? asiento : session.merge(asiento));

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void delete(Integer id) {
        try {
            session.beginTransaction();

            Optional.ofNullable(session.find(Asiento.class, id)).ifPresent(session::remove);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public static void update(Asiento asiento) {
        try {
            session.beginTransaction();
            session.merge(asiento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
