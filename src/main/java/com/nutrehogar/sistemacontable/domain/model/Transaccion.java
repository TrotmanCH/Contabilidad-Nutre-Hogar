package com.nutrehogar.sistemacontable.domain.model;

import com.nutrehogar.sistemacontable.domain.components.TipoDocumento;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una transacción financiera en el sistema contable.
 * <p>
 * Una transacción es una acción que afecta la posición financiera de la empresa y está compuesta por uno o más asientos contables.
 *
 * <p><strong>Ámbito de Desarrollo:</strong></p>
 * <ul>
 *     <li>Gestión de transacciones contables.</li>
 *     <li>Interacción con la base de datos para persistir y recuperar datos de transacciones.</li>
 *     <li>Validación de la integridad de los datos de transacciones.</li>
 * </ul>
 *
 * <p><strong>Ámbito Financiero:</strong></p>
 * <ul>
 *     <li>Registro de eventos financieros como ingresos, gastos, ajustes, etc.</li>
 *     <li>Base para la generación de informes financieros y análisis contables.</li>
 * </ul>
 *
 * <p><strong>Ejemplo de Uso:</strong></p>
 * <pre>{@code
 * Transaccion transaccion = Transaccion.builder()
 *         .fecha(LocalDate.now())
 *         .concepto("Venta de productos")
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
@Table(name = "transacciones")
public class Transaccion {

    /**
     * Identificador único de la transacción.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_transaccion")
    Integer idTransaccion;

    /**
     * Fecha en la que se realiza la transacción.
     */
    @Column(name = "fecha", nullable = false)
    LocalDate fecha;

    /**
     * Descripción o concepto que detalla la naturaleza de la transacción.
     */
    @Column(name = "concepto", columnDefinition = "TEXT")
    String concepto;

    /**
     * Tipo de documento que representa el asiento contable.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_documento", nullable = false)
    TipoDocumento tipoDocumento;

    // Relaciones con otras entidades

    /**
     * Lista de asientos contables asociados a esta transacción.
     *
     * <p>Relación bidireccional: una transacción puede tener múltiples asientos.</p>
     */
    @OneToMany(mappedBy = "transaccion", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Asiento> asientos = new ArrayList<>();
}
