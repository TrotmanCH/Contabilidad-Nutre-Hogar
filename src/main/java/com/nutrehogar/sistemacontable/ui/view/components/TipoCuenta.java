package com.nutrehogar.sistemacontable.ui.view.components;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;

@AllArgsConstructor
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum TipoCuenta {

    ACTIVO(1) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(debe, MATH_CONTEXT).subtract(haber, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    },
    PASIVO(2) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(haber, MATH_CONTEXT).subtract(debe, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    },
    PATRIMONIO(3) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(haber, MATH_CONTEXT).subtract(debe, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    },
    INGRESO(4) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(haber, MATH_CONTEXT).subtract(debe, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    },
    GASTO(5) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(debe, MATH_CONTEXT).subtract(haber, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    },
    COSTO(6) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(haber, MATH_CONTEXT).subtract(debe, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    };

    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;

    final int id;

    public abstract BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe);

    public static TipoCuenta fromId(int id) {
        return Arrays.stream(TipoCuenta.values())
                .filter(tipoCuenta -> tipoCuenta.getId() == id)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Invalid TipoCuenta id: " + id));
    }
}
