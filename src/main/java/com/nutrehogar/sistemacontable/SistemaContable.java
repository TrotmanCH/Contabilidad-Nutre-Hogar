package com.nutrehogar.sistemacontable;


import com.nutrehogar.sistemacontable.domain.util.filter.BalanceComprobacionFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.MayorGeneralFilter;
import com.nutrehogar.sistemacontable.domain.util.order.BalanceComprobacionOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.MayorGeneralOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.repository.BalanceComprobacionRepo;
import com.nutrehogar.sistemacontable.persistence.repository.LibroDiarioRepo;
import com.nutrehogar.sistemacontable.persistence.repository.MayorGeneralRepo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class SistemaContable {
    public static void main(String[] args) {

//        /* Utilizando clases de repository y model para insertar en la base de datos
//        Verifiquen si la base de datos ya tiene los datos de abajo
//        con db browser, si ya los tiene comenten todo lo que no esta comentado
//        en esta clase.
//        */
//        HibernateUtil.getSession();
//        // Repos
//        TipoDocumentoRepo tipoDocuRepo = TipoDocumentoRepo.getInstance();
//        TipoCuentaRepo tipoCuentaRepo = TipoCuentaRepo.getInstance();
//        SubtipoCuentaRepo subtipoCuentaRepo = SubtipoCuentaRepo.getInstance();
//        CuentaRepo cuentaRepo = CuentaRepo.getInstance();
//        AsientoRepo asientoRepo = AsientoRepo.getInstance();
//        RegistroRepo registroRepo = RegistroRepo.getInstance();
//        // Tipos de Documentos
//        tipoDocuRepo.save(TipoDocumento.builder().id(1).nombre("EGRESO").build());
//        tipoDocuRepo.save(TipoDocumento.builder().id(2).nombre("INGRESO").build());
//        tipoDocuRepo.save(TipoDocumento.builder().id(3).nombre("AJUSTE").build());
//        // Tipo de Cuentas
//        tipoCuentaRepo.save(TipoCuenta.builder().id(1).nombre("ACTIVOS").build());
//        tipoCuentaRepo.save(TipoCuenta.builder().id(2).nombre("PASIVOS").build());
//        tipoCuentaRepo.save(TipoCuenta.builder().id(3).nombre("PATRIMONIO").build());
//        tipoCuentaRepo.save(TipoCuenta.builder().id(4).nombre("INGRESOS").build());
//        tipoCuentaRepo.save(TipoCuenta.builder().id(5).nombre("GASTOS").build());
//        // Subtipo de Cuentas
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("1.1").nombre("ACTIVOS CORRIENTES").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("1.3").nombre("INVETARIOS").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("1.5").nombre("CUENTAS POR COBRAR").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("1.6").nombre("ACTIVOS FIJOS").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("1.61").nombre("DEPRECIACIÓN ACUMULADA").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("2.1").nombre("CUENTAS POR PAGAR").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("2.2").nombre("OTRAS CUENTAS POR PAGAR").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("4.2").nombre("INGRESOS POR DONACIÓN").build());
//        subtipoCuentaRepo.save(SubtipoCuenta.builder().id("5.2").nombre("GASTOS OTROS/DONACIONES").build());
//        // Cuentas
//        TipoCuenta tipo1 = tipoCuentaRepo.findById(2);
//        SubtipoCuenta subtipo1 = subtipoCuentaRepo.findById("2.1");
//        cuentaRepo.save(
//                Cuenta.builder()
//                        .id("21010")
//                        .nombre("Ventas A.C.M.")
//                        .saldo(BigDecimal.valueOf(82.85))
//                        .tipoCuenta(tipo1)
//                        .subtipoCuenta(subtipo1)
//                        .build()
//        );
//        TipoCuenta tipo2 = tipoCuentaRepo.findById(1);
//        SubtipoCuenta subtipo2 = subtipoCuentaRepo.findById("1.1");
//        cuentaRepo.save(
//                Cuenta.builder()
//                        .id("11051")
//                        .nombre("Banco Nacional")
//                        .saldo(BigDecimal.valueOf(82.85))
//                        .tipoCuenta(tipo2)
//                        .subtipoCuenta(subtipo2)
//                        .build()
//        );
//        // Asiento
//        TipoDocumento docu = tipoDocuRepo.findById(1);
//        asientoRepo.save(
//                Asiento.builder()
//                        .id(1)
//                        .fecha(LocalDate.now())
//                        .concepto("Para cancelar factura")
//                        .tipoDocumento(docu)
//                        .build()
//        );
//
//        // Registros
//        Asiento asiento = asientoRepo.findById(1);
//        Cuenta cuenta1 = cuentaRepo.findById("21010");
//        registroRepo.save(
//                Registro.builder()
//                        .asiento(asiento)
//                        .comprobante("Compr-095")
//                        .referencia("F-00008711")
//                        .cuenta(cuenta1)
//                        .debe(cuenta1.getSaldo())
//                        .haber(null)
//                        .build()
//        );
//        Cuenta cuenta2 = cuentaRepo.findById("11051");
//        registroRepo.save(
//                Registro.builder()
//                        .asiento(asiento)
//                        .comprobante("Ch-4818")
//                        .referencia("Pago de Factura")
//                        .cuenta(cuenta2)
//                        .debe(null)
//                        .haber(cuenta2.getSaldo())
//                        .build()
//        );

////
//
        var opListLibro = LibroDiarioRepo.getInstance().find(
                List.of(
                        new LibroDiarioFilter.ByFechaRange(
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 4, 20)
                        ),
                        new LibroDiarioFilter.ByComprobante("l")
                ),
                LibroDiarioOrderField.FECHA,
                OrderDirection.DESCENDING
        );
        opListLibro.ifPresent(libroDiario -> libroDiario.forEach(System.out::println));


        var opLiBa = BalanceComprobacionRepo.getInstance().find(
                List.of(
                        new BalanceComprobacionFilter.ByFechaRange(
                                LocalDate.of(2024, Month.JUNE, 1),
                                LocalDate.of(2024, Month.FEBRUARY, 20)
                        )
                ),
                BalanceComprobacionOrderField.FECHA,
                OrderDirection.DESCENDING
        );

        opLiBa.ifPresent(listLi -> {
            AtomicReference<BigDecimal> sumaHaber = new AtomicReference<>(BigDecimal.ZERO);
            AtomicReference<BigDecimal> sumadebe = new AtomicReference<>(BigDecimal.ZERO);

            System.out.println("Fecha  |  Codigo de cuenta  |  debe   |    haber");
            listLi.forEach(libro -> {

                System.out.println(libro.fecha() + " | " + libro.codigoCuenta() + "  |  " + libro.debe() + "  |  " + libro.haber());
                BigDecimal debee = sumadebe.get().add(libro.debe());
                BigDecimal habere = sumaHaber.get().add(libro.haber());
                sumadebe.set(debee);
                sumaHaber.set(habere);

            });
            System.out.println("Suma de Debe: " + sumaHaber + "  |  Suma de haber: " + sumadebe + "  |  Saldo: " + sumadebe.get().subtract(sumaHaber.get()));
        });

        var OpListDtoMayor = MayorGeneralRepo.getInstance().find(
                List.of(
                        new MayorGeneralFilter.ByCodigoCuenta("1200")
                ),
                MayorGeneralOrderField.FECHA,
                OrderDirection.DESCENDING
        );

        OpListDtoMayor.ifPresentOrElse(
                (listDtoMayor)->{
                    listDtoMayor.forEach(dtoMayor->{
                        System.out.println(dtoMayor);
                            });
                },
                ()->{
                    new RuntimeException().printStackTrace();
                }
        );
    }


}