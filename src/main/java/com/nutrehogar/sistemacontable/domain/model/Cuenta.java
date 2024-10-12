package com.nutrehogar.sistemacontable.domain.model;

import com.nutrehogar.sistemacontable.domain.components.TipoCuenta;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa una cuenta contable en el sistema.
 * <p>
 * Una cuenta contable es una categoría utilizada para registrar y agrupar transacciones financieras similares.
 *
 * <p><strong>Ámbito de Desarrollo:</strong></p>
 * <ul>
 *     <li>Gestión de las cuentas contables y sus características.</li>
 *     <li>Interacción con la base de datos para persistir y recuperar datos de cuentas.</li>
 *     <li>Validación de la unicidad y consistencia de los códigos de cuenta.</li>
 * </ul>
 *
 * <p><strong>Ámbito Financiero:</strong></p>
 * <ul>
 *     <li>Clasificación de transacciones financieras en categorías específicas.</li>
 *     <li>Facilita el seguimiento y análisis de movimientos en diferentes áreas financieras.</li>
 * </ul>
 *
 * <p><strong>Ejemplo de Uso:</strong></p>
 * <pre>{@code
 * Cuenta cuenta = Cuenta.builder()
 *         .codigoCuenta("1000")
 *         .nombreCuenta("Caja")
 *         .tipoCuenta(TipoCuenta.ACTIVO)
 *         .descripcion("Dinero en efectivo disponible")
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
@Table(name = "cuentas")
public class Cuenta {

    /**
     * Identificador único de la cuenta contable.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cuenta")
    Integer idCuenta;

    /**
     * Código único que identifica a la cuenta contable.
     *
     * <p>Debe ser único para evitar duplicados y facilitar la referencia en transacciones.</p>
     */
    @Column(name = "codigo_cuenta", nullable = false, unique = true)
    String codigoCuenta;

    /**
     * Nombre descriptivo de la cuenta contable.
     */
    @Column(name = "nombre_cuenta", nullable = false)
    String nombreCuenta;

    /**
     * Tipo de cuenta contable que define su naturaleza y comportamiento financiero.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_cuenta", nullable = false)
    TipoCuenta tipoCuenta;

    /**
     * Descripción adicional de la cuenta contable.
     *
     * <p>Proporciona información extra sobre la cuenta para mayor claridad.</p>
     */
    @Column(name = "descripcion")
    String descripcion;

    // Relaciones con otras entidades

    /**
     * Lista de detalles de asiento que afectan a esta cuenta.
     *
     * <p>Relación bidireccional: una cuenta puede estar asociada a múltiples detalles de asiento.</p>
     */
    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Asiento> asientos = new ArrayList<>();
}
