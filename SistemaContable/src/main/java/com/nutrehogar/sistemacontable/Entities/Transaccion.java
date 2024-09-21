package com.nutrehogar.sistemacontable.Entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "transaccion")
public class Transaccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id; // Cambiado a Integer

    LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY) // Relación muchos a uno
    @JoinColumn(name = "tipo_documento_id") // Clave foránea en Transaccion
    TipoDocumento tipoDocumento; // Un solo tipo de documento

    int no_doc;
    String no_cheque_comp;
    String referencia;
    int debe;
    int hacer;
}


