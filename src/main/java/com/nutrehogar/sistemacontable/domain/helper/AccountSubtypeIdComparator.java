package com.nutrehogar.sistemacontable.domain.helper;

import com.nutrehogar.sistemacontable.domain.model.AccountSubtype;

import java.util.Comparator;

public class AccountSubtypeIdComparator implements Comparator<AccountSubtype> {
    @Override
    public int compare(AccountSubtype o1, AccountSubtype o2) {
        int mainPart1 = o1.getAccountType().getId();
        int mainPart2 = o2.getAccountType().getId();

        // Comparar la parte entera primero
        if (mainPart1 != mainPart2) {
            return Integer.compare(mainPart1, mainPart2);
        }

        Integer subPart1 = ajustarDecimal(o1.getCanonicalId());
        Integer subPart2 = ajustarDecimal(o2.getCanonicalId());
//
//
//        int result1 = Integer.parseInt(mainPart1 + subPart1.toString());
//        int result2 = Integer.parseInt(mainPart2 + subPart2.toString());
//

        return Integer.compare(subPart1, subPart2);
    }

    private Integer ajustarDecimal(String decimal) {
        // Normalizar la longitud a 3 dígitos rellenando a la derecha
        if (decimal.length() == 1) {
            return Integer.parseInt(decimal) * 100;  // "6" → "600"
        } else if (decimal.length() == 2) {
            return Integer.parseInt(decimal) * 10;   // "61" → "610"
        } else {
            return Integer.parseInt(decimal);        // "999" → "999"
        }
    }
}

