package com.nutrehogar.sistemacontable.persistence.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Representa una transacción en el sistema contable.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"cuenta","tipoDocumento"})
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transaccion")
public class TransaccionEntity {

    /**
     * Identificador único de la transacción.
     * Este campo se autoincrementa en la base de datos.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

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
    TipoDocumentoEntity tipoDocumento;

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
    CuentaEntity cuenta;

    /**
     * Monto debitado en la transacción.
     */
    BigDecimal debito;

    /**
     * Monto acreditado en la transacción.
     */
    BigDecimal credito;
}
