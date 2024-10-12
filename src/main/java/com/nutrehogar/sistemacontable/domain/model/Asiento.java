package com.nutrehogar.sistemacontable.domain.model;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Representa un asiento contable asociado a una transacción.
 * <p>
 * Un asiento contable refleja el movimiento de dinero en una cuenta específica, ya sea un débito o un crédito.
 *
 * <p><strong>Ámbito de Desarrollo:</strong></p>
 * <ul>
 *     <li>Gestión de asientos contables individuales.</li>
 *     <li>Interacción con la base de datos para persistir y recuperar datos de asientos.</li>
 *     <li>Validación de la consistencia de los datos de los asientos.</li>
 * </ul>
 *
 * <p><strong>Ámbito Financiero:</strong></p>
 * <ul>
 *     <li>Registro detallado de movimientos financieros en cuentas específicas.</li>
 *     <li>Base para el cálculo de saldos de cuentas y generación de informes financieros.</li>
 * </ul>
 *
 * <p><strong>Ejemplo de Uso:</strong></p>
 * <pre>{@code
 * Asiento asiento = Asiento.builder()
 *         .transaccion(transaccion)
 *         .tipoDocumento(TipoDocumento.INGRESO)
 *         .fechaAsiento(LocalDate.now())
 *         .concepto("Ingreso por venta de productos")
 *         .build();
 * }</pre>
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "asientos")
public class Asiento {

    /**
     * Identificador único del asiento contable.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_asiento")
    Integer idAsiento;

    /**
     * Transacción a la que está asociado este asiento.
     *
     * <p>Relación bidireccional: un asiento pertenece a una transacción.</p>
     */
    @ManyToOne
    @JoinColumn(name = "id_transaccion", nullable = false)
    Transaccion transaccion;

    /**
     * Cuenta contable afectada por este detalle de asiento.
     *
     * <p>Relación bidireccional: un detalle de asiento está asociado a una cuenta.</p>
     */
    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    Cuenta cuenta;

    /**
     * Monto debitado en la cuenta.
     *
     * <p>Debe ser mayor o igual a cero. Un valor de cero indica que no hay débito en esta transacción.</p>
     */
    @Column(name = "debe", precision = 15, scale = 2)
    BigDecimal debe;

    /**
     * Monto acreditado en la cuenta.
     *
     * <p>Debe ser mayor o igual a cero. Un valor de cero indica que no hay crédito en esta transacción.</p>
     */
    @Column(name = "haber", precision = 15, scale = 2)
    BigDecimal haber;

    /**
     * Referencia a documento
     */
    @Column(name = "comprobante")
    String comprobante;

    /**
     * Descripción o concepto que detalla la naturaleza del asiento.
     */
    @Column(name = "referencia", columnDefinition = "TEXT")
    String referencia;

    // Relaciones con otras entidades
}
