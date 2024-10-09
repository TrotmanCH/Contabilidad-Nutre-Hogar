package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CuentaRepository {
    private static CuentaRepository instance;
    private static Session session = HibernateUtil.getSession();


    private CuentaRepository() {

    }

    public static CuentaRepository getInstance() {
        if (instance == null) {
            instance = new CuentaRepository();
        }
        return instance;
    }

    public List<Cuenta> findAll() {
        List<Cuenta> cuentas;
        try {
            session.beginTransaction();
            cuentas = session.createQuery("from Cuenta", Cuenta.class).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            cuentas = null;
            e.printStackTrace();
        }
        return cuentas;
    }

    public Cuenta findById(Integer id) {
        return session.find(Cuenta.class, id);
    }

    public Cuenta findByCodigo(String Codigo) {
        Cuenta cuenta = null;
        try {
            session.beginTransaction();
            cuenta = session.createQuery("from Cuenta where codigoCuenta = :Codigo", Cuenta.class).setParameter("Codigo", Codigo).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return cuenta;
    }

    public Cuenta findByNombreCuenta(String nombreCuenta) {
        Cuenta cuenta = null;
        try {
            session.beginTransaction();
            cuenta = session.createQuery("from Cuenta where nombreCuenta = :nombreCuenta", Cuenta.class).setParameter("nombreCuenta", nombreCuenta).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return cuenta;
    }

    public Cuenta findByTipoCuenta(TipoCuenta tipoCuenta) {
        Cuenta cuenta = null;
        try {
            session.beginTransaction();
            cuenta = session.createQuery("from Cuenta where tipoCuenta = :tipoCuenta", Cuenta.class).setParameter("tipoCuenta", tipoCuenta).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return cuenta;
    }

    public void save(Cuenta cuenta) {
        try {
            session.beginTransaction();
            session.save(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void save(@NotNull List<Cuenta> cuentas) {
        try {
            session.beginTransaction();
            cuentas.forEach(session::save);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
    }

    public void delete(Cuenta cuenta) {
        try {
            session.beginTransaction();

            session.delete(cuenta);

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    public void deleteById(Integer id) {
        Cuenta cuenta = this.findById(id);
        if (cuenta != null) {
            delete(cuenta);
        }
    }

    public void update(Cuenta cuenta) {
        try {
            session.beginTransaction();
            session.update(cuenta);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}