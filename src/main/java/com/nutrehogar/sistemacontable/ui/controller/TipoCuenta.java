package com.nutrehogar.sistemacontable.ui.controller;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Enum que define los tipos que pueden ser las cunetas.
 * <p>
 * Dependiendo del tipo de cuenta el saldo es el que suma es el haber o debe y vise versa con la resta
 * <p>
 * {@code COSTO} es el unico que su valor está mal
 *
 * @author Calcifer1331
 * @see com.nutrehogar.sistemacontable.domain.model.TipoCuenta
 * @see com.nutrehogar.sistemacontable.ui.view.components.MayorGenTableModel
 */
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
    //TODO: El metodo no esta bien implementado
    COSTO(6) {
        @Override
        public BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe) {
            return saldo.add(haber, MATH_CONTEXT).subtract(debe, MATH_CONTEXT).setScale(2, RoundingMode.HALF_UP);
        }
    };
    /**
     * El contexto de las operaciones es el maximo
     */
    private static final MathContext MATH_CONTEXT = MathContext.DECIMAL128;
    /**
     * Es el id con el que esta registrado en la base de datos
     */
    final int id;

    public static @NotNull TipoCuenta fromId(int id) {
        for (TipoCuenta tipo : values()) {
            if (tipo.getId() == id) {
                return tipo;
            }
        }
        return ACTIVO;
    }

    /**
     * Dependiendo del tipo de cuenta el saldo es el que suma es el haber o debe y vise versa con la resta
     *
     * @param saldo
     * @param haber
     * @param debe
     * @return suma de {@code saldo} y el resultado de la resta o suma de {@code haber} y {@code debe}
     */
    public abstract BigDecimal getSaldo(BigDecimal saldo, BigDecimal haber, BigDecimal debe);
}
