package com.nutrehogar.sistemacontable.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "asiento")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "registro")
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "id_asiento", nullable = false)
    Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    TipoDocumento tipoDocumento;

    @Column(name = "comprobante", columnDefinition = "TEXT")
    String comprobante;

    @Column(name = "referencia", columnDefinition = "TEXT")
    String referencia;

    @ManyToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    Cuenta cuenta;

    @Column(name = "debe", precision = 15, scale = 2)
    BigDecimal debe;

    @Column(name = "haber", precision = 15, scale = 2)
    BigDecimal haber;
}
