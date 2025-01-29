package com.nutrehogar.sistemacontable.domain.helper;

/**
 * Enum que representa el tipo de ordenamiento.
 * Puede ser ASCENDING (ascendente) o DESCENDING (descendente).
 */
public enum OrderDirection {
    /**
     * es equicalente a {@code ORDER BY *** AS}
     */
    ASCENDING,
    /**
     * es equicalente a {@code ORDER BY *** DES}
     */
    DESCENDING
}