package com.nutrehogar.sistemacontable.domain.model;


import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
@Table(name = "Asientos")
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
     * Tipo de documento que representa el asiento contable.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false)
    TipoDocumento tipoDocumento;

    /**
     * Fecha en la que se realiza el asiento contable.
     */
    @Column(name = "fecha_asiento", nullable = false)
    LocalDate fechaAsiento;

    /**
     * Descripción o concepto que detalla la naturaleza del asiento.
     */
    @Column(name = "concepto", columnDefinition = "TEXT")
    String concepto;

    // Relaciones con otras entidades

    /**
     * Lista de detalles de asiento asociados a este asiento contable.
     *
     * <p>Relación bidireccional: un asiento puede tener múltiples detalles de asiento.</p>
     */
    @OneToMany(mappedBy = "asiento", cascade = CascadeType.ALL, orphanRemoval = true)
    List<DetalleAsiento> detallesAsientos = new ArrayList<>();
}
