package com.nutrehogar.sistemacontable.domain.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;
import java.util.Objects;


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
    @Column(name = "id")
    String id;

    @Column(name = "nombre", nullable = false)
    String nombre;

    @ManyToOne
    @JoinColumn(name = "id_sub_tipo_cuenta", nullable = false)
    SubTipoCuenta subTipoCuenta;

    @OneToMany(mappedBy = "cuenta", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    List<Registro> registros;

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Cuenta cuenta)) return false;

        return Objects.equals(id, cuenta.id) && Objects.equals(nombre, cuenta.nombre);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(nombre);
        return result;
    }
}
