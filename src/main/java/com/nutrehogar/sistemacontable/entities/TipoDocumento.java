package com.nutrehogar.sistemacontable.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.List;

/**
 * Representa un tipo de documento en el sistema contable.
 */
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

    /**
     * Identificador único del tipo de documento.
     * Este campo se autoincrementa en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;  // Considera usar Integer para permitir valores nulos.

    /**
     * Nombre del tipo de documento.
     */
    String nombre;

    /**
     * Lista de transacciones asociadas a este tipo de documento.
     * Relación uno a muchos con la entidad Transaccion.
     */
    @OneToMany(mappedBy = "tipoDocumento", cascade = CascadeType.ALL) // Relación uno a muchos
            List<Transaccion> transacciones; // Lista de transacciones asociadas
}
