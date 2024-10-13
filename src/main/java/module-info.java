module SistemaContable {
    requires java.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires org.jetbrains.annotations;
    requires org.slf4j;

    requires java.base;
    requires java.compiler;
    requires java.datatransfer;
    requires java.desktop;
    requires java.instrument;
    requires java.logging;
    requires java.management;
    requires java.naming;
    requires java.rmi;
    requires java.sql;
    requires java.sql.rowset;
    requires java.transaction;
    requires java.xml;
    exports com.nutrehogar.sistemacontable;
    exports com.nutrehogar.sistemacontable.application.service;
    exports com.nutrehogar.sistemacontable.application.dto;
    exports com.nutrehogar.sistemacontable.domain.components;
    exports com.nutrehogar.sistemacontable.domain.model;
    exports com.nutrehogar.sistemacontable.domain.util.order;
    exports com.nutrehogar.sistemacontable.domain.util.filter;
    exports com.nutrehogar.sistemacontable.persistence.config;
    exports com.nutrehogar.sistemacontable.persistence.repository;
//    exports com.nutrehogar.sistemacontable.report;
//    exports com.nutrehogar.sistemacontable.ui.view;
//    exports com.nutrehogar.sistemacontable.ui.controller;
    opens com.nutrehogar.sistemacontable.domain.model; // Agrega esta línea
    opens com.nutrehogar.sistemacontable.domain.components; // Agrega esta línea
    opens com.nutrehogar.sistemacontable.application.dto; // Agrega esta línea

}