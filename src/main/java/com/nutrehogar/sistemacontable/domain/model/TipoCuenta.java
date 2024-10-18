package com.nutrehogar.sistemacontable.domain.model;

import java.util.ArrayList;
import java.util.List;
import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tipo_cuenta")

public class TipoCuenta {
    @Id
    @Column(name = "id")
    Integer id;
    
    @Column(name = "nombre", columnDefinition = "TEXT")
    String nombre;
    
    @OneToMany(mappedBy = "tipoCuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Cuenta> cuentas = new ArrayList<>();
}
