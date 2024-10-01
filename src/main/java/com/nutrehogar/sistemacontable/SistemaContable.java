
package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.entities.Cuenta;
import com.nutrehogar.sistemacontable.service.BackupService;
import com.nutrehogar.sistemacontable.service.CuentaService;
import com.nutrehogar.sistemacontable.utils.HibernateUtil;

public class SistemaContable {
    /**
     * metodo que cierra la session y el factory.
     * Es importante que se cierren correctamente para evitar perdida de datos. En la implementacion final se debe asignar esta funciona a un Listener de el bton close de windows.
     */
    public static void shutdown() {
        HibernateUtil.closeSession();
        HibernateUtil.closeSessionFactory();
    }

    public static void main(String[] args) {
        CuentaService cuentaService = new CuentaService();
        Cuenta cuenta = cuentaService.obtenerCuenta(1);
        System.out.println(cuenta);
        BackupService.backupDatabase();
        shutdown();
    }
}
