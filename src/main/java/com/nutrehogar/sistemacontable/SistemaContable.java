package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.application.service.ConfigLoader;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroMayorFilter;
import com.nutrehogar.sistemacontable.domain.util.order.BalanceComprobacionOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.LibroMayorOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import com.nutrehogar.sistemacontable.persistence.repository.ContabilidadRepository;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;


public class SistemaContable {

    public static void main(String[] args) {
        ConfigLoader.getInstance();
        Session session = HibernateUtil.getSession();
        ContabilidadRepository contabilidadRepository = ContabilidadRepository.getInstance();


        contabilidadRepository.findLibroDiario(
                List.of(
                        new LibroDiarioFilter.ByFechaRange(
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 12, 31)
                        )
//                        new LibroDiarioFilter.ByConcepto("servi")
                ),
                LibroDiarioOrderField.FECHA,
                OrderDirection.DESCENDING
        ).ifPresent(libroDiario -> libroDiario.forEach(System.out::println));

        contabilidadRepository.findLibroMayor(
                List.of(
                        new LibroMayorFilter.ByFechaRange(
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 12, 31)
                        )
                ),
                LibroMayorOrderField.CODIGO_CUENTA,
                OrderDirection.DESCENDING
        ).ifPresent(mayor -> mayor.forEach(System.out::println));


        contabilidadRepository.findBalanceComprobacion(
                List.of(

                ),
                BalanceComprobacionOrderField.FECHA,
                OrderDirection.DESCENDING
        ).ifPresent(balanceComprobacionDTOS -> balanceComprobacionDTOS.forEach(System.out::println));

//        opLiBa.ifPresent(listLi ->{
//            AtomicReference<BigDecimal> sumaHaber = new AtomicReference<>(BigDecimal.ZERO);
//            AtomicReference<BigDecimal> sumadebe = new AtomicReference<>(BigDecimal.ZERO);
//
//            System.out.println("Fecha  |  Codigo de cuenta  |  debe   |    haber");
//            listLi.forEach(libro -> {
//
//                System.out.println(libro.fecha()+" | "+libro.codigoCuenta()+"  |  "+ libro.debe()+"  |  "+libro.haber());
//                BigDecimal debee = sumadebe.get().add(libro.debe());
//                BigDecimal habere = sumaHaber.get().add(libro.haber());
//                sumadebe.set(debee);
//                sumaHaber.set(habere);
//
//            });
//            System.out.println("Suma de Debe: "+sumaHaber+"  |  Suma de haber: "+sumadebe+"  |  Saldo: "+sumadebe.get().subtract(sumaHaber.get()));
//        });
    }


}