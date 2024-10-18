package com.nutrehogar.sistemacontable.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "registro")

public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "id_asiento", nullable = false)
    Asiento asiento;
    
    @Column(name = "comprobante", columnDefinition = "TEXT")
    String comprobante;
    
    @Column(name = "referencia", columnDefinition = "TEXT")
    String referencia;

    @OneToOne
    @JoinColumn(name = "id_cuenta", nullable = false)
    Cuenta cuenta;

    @Column(name = "debe", precision = 15, scale = 2)
    BigDecimal debe;

    @Column(name = "haber", precision = 15, scale = 2)
    BigDecimal haber;
}
