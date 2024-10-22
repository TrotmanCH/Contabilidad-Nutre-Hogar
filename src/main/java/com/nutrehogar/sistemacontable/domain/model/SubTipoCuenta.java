package com.nutrehogar.sistemacontable.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "cuentas")
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "sub_tipo_cuenta")
public class SubTipoCuenta {
    @Id
    @Column(name = "id")
    String id;

    @Column(name = "nombre")
    String nombre;

    @ManyToOne
    @JoinColumn(name = "id_tipo_cuenta", nullable = false)
    TipoCuenta tipoCuenta;

    @OneToMany(mappedBy = "subTipoCuenta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Cuenta> cuentas;
}
