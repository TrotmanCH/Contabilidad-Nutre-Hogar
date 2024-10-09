package com.nutrehogar.sistemacontable;

import com.nutrehogar.sistemacontable.application.dto.LibroDiarioDTO;
import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import com.nutrehogar.sistemacontable.domain.model.Asiento;
import com.nutrehogar.sistemacontable.domain.model.Cuenta;
import com.nutrehogar.sistemacontable.domain.model.DetalleAsiento;
import com.nutrehogar.sistemacontable.domain.model.Transaccion;
import com.nutrehogar.sistemacontable.domain.util.filter.LibroDiarioFilter;
import com.nutrehogar.sistemacontable.domain.util.order.LibroDiarioOrderField;
import com.nutrehogar.sistemacontable.domain.util.order.OrderDirection;
import com.nutrehogar.sistemacontable.persistence.config.HibernateUtil;
import com.nutrehogar.sistemacontable.persistence.repository.ContabilidadRepository;
import org.hibernate.Session;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public class SistemaContable {

    public static void main(String[] args) {
//        Session session = HibernateUtil.getSession();
        ContabilidadRepository contabilidadRepository = ContabilidadRepository.getInstance();
        Optional<List<LibroDiarioDTO>> opListLibro = contabilidadRepository
                .findLibroDiario(
                        new LibroDiarioFilter.ByFechaRange(
                                LocalDate.of(2024, 1, 1),
                                LocalDate.of(2024, 12, 31)),
                        LibroDiarioOrderField.FECHA,
                        OrderDirection.DESCENDING);
        opListLibro.ifPresentOrElse(libroDiarioDTOS -> {
            libroDiarioDTOS.forEach(System.out::println);
            System.out.println("---------------------------");
        }, ()-> {throw new RuntimeException("No libro diario found");});

    }

}