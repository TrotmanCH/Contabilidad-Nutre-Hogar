package com.nutrehogar.sistemacontable.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Representa un detalle de asiento contable que especifica una transacción en una cuenta específica.
 * <p>
 * Cada detalle de asiento indica si la cuenta se debita o acredita, y en qué monto.
 *
 * <p><strong>Ámbito de Desarrollo:</strong></p>
 * <ul>
 *     <li>Gestión de los detalles específicos de cada asiento contable.</li>
 *     <li>Interacción con la base de datos para persistir y recuperar datos de detalles de asientos.</li>
 *     <li>Validación de los montos de debe y haber para asegurar la integridad contable.</li>
 * </ul>
 *
 * <p><strong>Ámbito Financiero:</strong></p>
 * <ul>
 *     <li>Detalle de movimientos en cuentas específicas, permitiendo un seguimiento preciso de las transacciones.</li>
 *     <li>Facilita el cálculo de saldos de cuentas y la elaboración de informes financieros detallados.</li>
 * </ul>
 *
 * <p><strong>Ejemplo de Uso:</strong></p>
 * <pre>{@code
 * DetalleAsiento detalle = DetalleAsiento.builder()
 *         .asiento(asiento)
 *         .cuenta(cuenta)
 *         .debe(new BigDecimal("1000.00"))
 *         .haber(BigDecimal.ZERO)
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
@Table(name = "detalles_asientos")
public class DetalleAsiento {

    /**
     * Identificador único del detalle de asiento.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_detalle")
    Integer idDetalle;

    /**
     * Asiento contable al que pertenece este detalle.
     *
     * <p>Relación bidireccional: un detalle de asiento pertenece a un asiento.</p>
     */
    @ManyToOne
    @JoinColumn(name = "id_asiento", nullable = false)
    Asiento asiento;

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
     * Calcula el impacto neto de este detalle de asiento.
     *
     * @return Monto neto (debe - haber)
     */
    public BigDecimal getImpactoNeto() {
        return debe.subtract(haber);
    }
}
