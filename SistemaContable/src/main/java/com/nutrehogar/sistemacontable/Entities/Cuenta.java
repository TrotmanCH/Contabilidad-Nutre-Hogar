package com.nutrehogar.sistemacontable.Entities;

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
    String id;
    String nombre;
}
