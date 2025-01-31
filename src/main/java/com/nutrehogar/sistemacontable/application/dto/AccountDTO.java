package com.nutrehogar.sistemacontable.application.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountDTO {
    String tipoCuenta;
    String subTipoCuenta;
    String cuenta;
}
