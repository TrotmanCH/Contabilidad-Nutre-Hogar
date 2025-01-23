package com.nutrehogar.sistemacontable.exception;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;


class AppExceptionTest {
    @Test
    void testAppException() {
        try {
            // Simular un error
            throw new SQLException("Error de E/S");
        } catch (SQLException e) {
            // Lanzar una excepción personalizada
            throw new RepositoryException("Error al optener datos de id", e);
        }    }
}