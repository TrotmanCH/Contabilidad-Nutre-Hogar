module SistemaContable {
    requires java.base;
    requires java.compiler;
    requires java.desktop;
    requires java.instrument;
    requires java.logging;
    requires java.naming;
    requires java.rmi;
    requires java.sql;
    requires java.transaction.xa;
    requires java.xml;
    requires java.xml.crypto;

    requires com.formdev.flatlaf;
    requires itextpdf;
    requires jakarta.persistence;
    requires static lombok;
    requires org.hibernate.orm.core;
    requires org.jetbrains.annotations;
    requires org.slf4j;

    exports com.nutrehogar.sistemacontable.ui;
    exports com.nutrehogar.sistemacontable.ui.components;
    exports com.nutrehogar.sistemacontable.ui.controller;
    exports com.nutrehogar.sistemacontable.ui.tabs;
    exports com.nutrehogar.sistemacontable.ui.styles;
    exports com.nutrehogar.sistemacontable.ui.view;
    exports com.nutrehogar.sistemacontable.ui.services;
    exports com.nutrehogar.sistemacontable.ui.windows;
    exports com.nutrehogar.sistemacontable.application;
    exports com.nutrehogar.sistemacontable.application.dto;
    exports com.nutrehogar.sistemacontable.application.service;
    exports com.nutrehogar.sistemacontable.domain;
    exports com.nutrehogar.sistemacontable.domain.model;
    exports com.nutrehogar.sistemacontable.domain.repository;

    opens com.nutrehogar.sistemacontable.domain.model to org.hibernate.orm.core;
}