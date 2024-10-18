package com.nutrehogar.sistemacontable.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tipo_documento")
public class TipoDocumento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "nombre")
    String nombre;

    @OneToMany(mappedBy = "tipoDocumento", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Asiento> asientos = new ArrayList<>();
}
