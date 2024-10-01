package com.nutrehogar.sistemacontable.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; // Cambiado a Integer

    String nombre;

    @OneToMany(mappedBy = "tipoDocumento", cascade = CascadeType.ALL) // Relación uno a muchos
    List<Transaccion> transacciones; // Lista de transacciones asociadas
}
