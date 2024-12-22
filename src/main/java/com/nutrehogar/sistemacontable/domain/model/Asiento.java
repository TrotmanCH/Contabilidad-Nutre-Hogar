package com.nutrehogar.sistemacontable.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "asiento")
public class Asiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    
    @Column(name = "numero_cheque", columnDefinition = "TEXT")
    String numeroCheque;
    
    @Column(name = "fecha", nullable = false)
    LocalDate fecha;

    @Column(name = "nombre", columnDefinition = "TEXT")
    String nombre;

    @Column(name = "concepto", columnDefinition = "TEXT")
    String concepto;

    @OneToMany(mappedBy = "asiento", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Registro> registros;
}
