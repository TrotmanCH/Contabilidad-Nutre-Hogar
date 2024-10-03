package com.nutrehogar.sistemacontable.persistence.model;

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
public class CuentaEntity {

    /**
     * Identificador único de la cuenta.
     * Este campo se autoincrementa en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    /**
     * Número de cuenta, debe ser único y no nulo.
     */
    @Column(name = "numero_cuenta", nullable = false)
    String noCuenta;

    /**
     * Nombre asociado a la cuenta.
     */
    @Column(nullable = false)
    String nombre;
}
