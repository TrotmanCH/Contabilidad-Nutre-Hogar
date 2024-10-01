package com.nutrehogar.sistemacontable.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Representa una transacción en el sistema contable.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transaccion")
public class Transaccion {

    /**
     * Identificador único de la transacción.
     * Este campo se autoincrementa en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;  // Considera usar Integer para permitir valores nulos.

    /**
     * Fecha en que se realizó la transacción.
     */
    LocalDate fecha;

    /**
     * Número del documento asociado a la transacción.
     */
    @Column(name = "numero_documento")
    int noDocumento;

    /**
     * Tipo de documento asociado a esta transacción.
     * Relación muchos a uno con la entidad TipoDocumento.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_documento_id")
    TipoDocumento tipoDocumento;

    /**
     * Número de cheque asociado a la transacción.
     */
    @Column(name = "numero_cheque")
    String noCheque;

    /**
     * Referencia adicional para la transacción.
     */
    String referencia;

    /**
     * Cuenta asociada a la transacción.
     * Relación muchos a uno con la entidad Cuenta.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    Cuenta cuenta;

    /**
     * Monto debitado en la transacción.
     */
    float debito;

    /**
     * Monto acreditado en la transacción.
     */
    float credito;
}
