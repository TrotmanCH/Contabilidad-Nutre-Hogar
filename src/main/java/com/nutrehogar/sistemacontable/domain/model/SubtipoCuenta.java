package com.nutrehogar.sistemacontable.domain.model;

import java.math.BigDecimal;
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
@Table(name = "subtipo_cuenta")

public class SubtipoCuenta {
    @Id
    @Column(name = "id", columnDefinition = "TEXT")
    String id;
    
    @Column(name = "nombre", columnDefinition = "TEXT")
    String nombre;
    
    @OneToMany(mappedBy = "subtipoCuenta", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Cuenta> cuentas = new ArrayList<>();
}
