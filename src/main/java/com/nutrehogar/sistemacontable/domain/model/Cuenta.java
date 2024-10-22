package com.nutrehogar.sistemacontable.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "registros")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")

    String id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @Column(name = "saldo", precision = 15, scale = 2)
    BigDecimal saldo;

    @ManyToOne
    @JoinColumn(name = "id_sub_tipo_cuenta", nullable = false)
    SubTipoCuenta subTipoCuenta;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Registro> registros;
}
