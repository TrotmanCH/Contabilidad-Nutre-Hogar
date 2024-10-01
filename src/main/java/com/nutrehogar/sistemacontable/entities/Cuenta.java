package com.nutrehogar.sistemacontable.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cuenta")
public class Cuenta {
    @Id
    @Column(length = 10)
    String id;
    String nombre;
}
