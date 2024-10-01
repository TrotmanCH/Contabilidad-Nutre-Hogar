package com.nutrehogar.sistemacontable.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

/**
 * Representa una cuenta en el sistema contable.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cuenta")
public class Cuenta {

    /**
     * Identificador único de la cuenta.
     * Este campo se autoincrementa en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 10)
    Integer id;  // Considera usar Integer para permitir valores nulos.

    /**
     * Número de cuenta, debe ser único y no nulo.
     */
    @Column(name = "numero_cuenta", unique = true, nullable = false)
    String noCuenta;

    /**
     * Nombre asociado a la cuenta.
     */
    String nombre;
}
