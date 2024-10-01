
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.service.CuentaService;
import com.nutrehogar.sistemacontable.entities.TipoDocumento;
import com.nutrehogar.sistemacontable.entities.Transaccion;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.time.LocalDate;

public class SistemaContable {

    public static void main(String[] args) {

        CuentaService cuentaService = new CuentaService();
//        cuentaService.agregarCuenta(Cuenta.builder().id("yfghjkn").nombre("rdtfgyhj").build());
//
//        List<Cuenta> cuentaList = cuentaService.mostrarCuentas();
//
//        cuentaList.forEach(System.out::println);

//        List<TipoDocumento> tipoDocumentos = List.of(TipoDocumento.builder().nombre("AJT").build(), TipoDocumento.builder().nombre("Ing").build(), TipoDocumento.builder().nombre("ABj").build());
//        tipoDocumentos.forEach(tipo -> HibernateUtil.ejectaTransaction(session -> session.save(tipo)));
        TipoDocumento tipoDocumento = null;
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            tipoDocumento = session.get(TipoDocumento.class, 2);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        Transaccion transaccion = Transaccion.builder().tipoDocumento(tipoDocumento).debe(12).fecha(LocalDate.now()).referencia("iygkhjk").no_doc(12).build();
        HibernateUtil.ejectaTransaction(session -> session.save(transaccion));
    }
}
