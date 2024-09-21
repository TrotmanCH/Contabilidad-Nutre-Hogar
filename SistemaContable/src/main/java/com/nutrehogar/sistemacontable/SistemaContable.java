
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.Entities.Cuenta;
import com.nutrehogar.sistemacontable.Entities.CuentaService;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Objects;

public class SistemaContable {

    public static void main(String[] args) {

        CuentaService cuentaService = new CuentaService();
        cuentaService.agergarCuentas(Cuenta.builder().id("udds").nombre("siyd").build());

        List<Cuenta> cuentaList = cuentaService.mostrarCuentas();

        cuentaList.forEach(System.out::println);
    }
}
