package com.nutrehogar.sistemacontable.persistence.repository;

import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class CuentaRepository {
    private static CuentaRepository instance;
    private static final Session session = HibernateUtil.getSession();


    private CuentaRepository() {

    }

    public static CuentaRepository getInstance() {
        if (instance == null) {
            instance = new CuentaRepository();
        }
        return instance;
    }

    public Optional<List<Cuenta>> findAll() {
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
        return Optional.ofNullable(cuentas);
    }

    public Optional<Cuenta> findById(Integer id) {
        return Optional.ofNullable(session.find(Cuenta.class, id));
    }

    public Optional<Cuenta> findByCodigo(String Codigo) {
        Cuenta cuenta = null;
        try {
            session.beginTransaction();
            cuenta = session.createQuery("from Cuenta where codigoCuenta = :Codigo", Cuenta.class).setParameter("Codigo", Codigo).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return Optional.ofNullable(cuenta);
    }

    public Optional<Cuenta> findByNombreCuenta(String nombreCuenta) {
        Cuenta cuenta = null;
        try {
            session.beginTransaction();
            cuenta = session.createQuery("from Cuenta where nombreCuenta = :nombreCuenta", Cuenta.class).setParameter("nombreCuenta", nombreCuenta).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return Optional.ofNullable(cuenta);
    }

    public Optional<Cuenta> findByTipoCuenta(TipoCuenta tipoCuenta) {
        Cuenta cuenta = null;
        try {
            session.beginTransaction();
            cuenta = session.createQuery("from Cuenta where tipoCuenta = :tipoCuenta", Cuenta.class).setParameter("tipoCuenta", tipoCuenta).uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
        }
        return Optional.ofNullable(cuenta);
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
        Optional<Cuenta> cuenta = this.findById(id);
        cuenta.ifPresent(session::delete);
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