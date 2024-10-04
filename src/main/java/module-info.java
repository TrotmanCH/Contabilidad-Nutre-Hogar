module SistemaContable {
    requires com.fasterxml.jackson.databind;
    requires java.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires org.jetbrains.annotations;

    exports com.nutrehogar.sistemacontable.persistence.model;
    exports com.nutrehogar.sistemacontable.persistence.repository;
    exports com.nutrehogar.sistemacontable.service;
    exports com.nutrehogar.sistemacontable.utils;
}