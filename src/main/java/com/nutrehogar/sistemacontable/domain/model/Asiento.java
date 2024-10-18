package com.nutrehogar.sistemacontable.domain.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "asiento")

public class Asiento {
    @Id
    @Column(name = "id")
    Integer id;

    @Column(name = "fecha", columnDefinition = "TEXT", nullable = false)
    String fecha;

    @Column(name = "concepto", columnDefinition = "TEXT")
    String concepto;

    @OneToOne
    @JoinColumn(name = "id_tipo_documento", nullable = false)
    TipoDocumento tipoDocumento;

    @OneToMany(mappedBy = "asiento", cascade = CascadeType.ALL, orphanRemoval = true)
    List<Registro> registros = new ArrayList<>();
}
