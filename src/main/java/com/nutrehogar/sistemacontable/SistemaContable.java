package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.application.dto.LibroMayorDTO;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroMayorFilter;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.LibroMayorOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import com.nutrehogar.sistemacontable.persistence.repository.ContabilidadRepository;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class SistemaContable {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSession();
        ContabilidadRepository contabilidadRepository = ContabilidadRepository.getInstance();


        Optional<List<LibroDiarioDTO>> opListLibro = contabilidadRepository.findLibroDiario(
                List.of(
                        new LibroDiarioFilter.ByFechaRange(
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 12, 31)
                        ),
                        new LibroDiarioFilter.ByConcepto("servi")
                ),
                LibroDiarioOrderField.FECHA,
                OrderDirection.DESCENDING
        );


        opListLibro.ifPresent(libroDiario -> libroDiario.forEach(System.out::println));

        Optional<List<LibroMayorDTO>> libro= contabilidadRepository.findLibroMayor(
                List.of(
                        new LibroMayorFilter.ByFechaRange(
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 12, 31)
                        )
                ),
                        LibroMayorOrderField.CODIGO_CUENTA,
                        OrderDirection.DESCENDING
        );
        libro.ifPresent(mayor -> mayor.forEach(System.out::println));
    }

}