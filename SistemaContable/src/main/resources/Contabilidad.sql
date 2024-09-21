CREATE DATABASE Contabilidad;
USE Contabilidad;

CREATE TABLE Cuenta(
Codigo VARCHAR(10),
Nombre VARCHAR(100)
);

INSERT INTO Cuenta VALUES("1", "Activo");
INSERT INTO Cuenta VALUES("11", "Activo Corriente");
INSERT INTO Cuenta VALUES("11020", "Caja Menuda");
INSERT INTO Cuenta VALUES("11030", "Caja Menuda del MIDES");
INSERT INTO Cuenta VALUES("11051", "Banco Global Bank Corp");
INSERT INTO Cuenta VALUES("11090", "Caja General");
INSERT INTO Cuenta VALUES("11100", "Gastos Pagados Por Adelantado");
INSERT INTO Cuenta VALUES("13", "Inventario");
INSERT INTO Cuenta VALUES("13000", "Alimentos");
INSERT INTO Cuenta VALUES("13001", "Útiles de Limpieza y Aseo");
INSERT INTO Cuenta VALUES("13002", "Enseres");
INSERT INTO Cuenta VALUES("13003", "Medicamentos");
INSERT INTO Cuenta VALUES("13004", "Ropa de Los Niños");
INSERT INTO Cuenta VALUES("13005", "Juguetes");
INSERT INTO Cuenta VALUES("13006", "Otros");
INSERT INTO Cuenta VALUES("15", "Cuentas Por Cobrar");
INSERT INTO Cuenta VALUES("15000", "Cta. Por Cobrar - Empleados");
INSERT INTO Cuenta VALUES("15001", "Cta. Por Cobrar - Actividad");
INSERT INTO Cuenta VALUES("15002", "Cta. Por Cobrar - Cuotas");
INSERT INTO Cuenta VALUES("15003", "Cta. Por Cobrar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES("15004", "Cta. Por Cobrar - Nutre Hogar Rifa");
INSERT INTO Cuenta VALUES("15005", "Cta. Por Cobrar - Mides");
INSERT INTO Cuenta VALUES("15006", "Cta. Por Cobrar - Otros");
INSERT INTO Cuenta VALUES("16", "Activos Fijos");
INSERT INTO Cuenta VALUES("16000", "Edificio");
INSERT INTO Cuenta VALUES("16001", "Equipo de Oficina");
INSERT INTO Cuenta VALUES("16002", "Equipo de Medico y Enfermería");
INSERT INTO Cuenta VALUES("16003", "Transporte");
INSERT INTO Cuenta VALUES("16004", "Equipo de Aire Acondicionado");
INSERT INTO Cuenta VALUES("16005", "Muebles y Enseres");
INSERT INTO Cuenta VALUES("16006", "Equipo de Cocina y Lavandería");
INSERT INTO Cuenta VALUES("16007", "Otros Activos Fijos");
INSERT INTO Cuenta VALUES("161", "Depreciación Acumulada");
INSERT INTO Cuenta VALUES("16100", "Edificio");
INSERT INTO Cuenta VALUES("16101", "Equipo de Oficina");
INSERT INTO Cuenta VALUES("16102", "Equipo de Médico y Enfermería");
INSERT INTO Cuenta VALUES("16103", "Transporte");
INSERT INTO Cuenta VALUES("16104", "Equipo de Aire Acondicionado");
INSERT INTO Cuenta VALUES("16105", "Muebles y enseres");
INSERT INTO Cuenta VALUES("16106", "Equipo de Cocina y Lavandería");
INSERT INTO Cuenta VALUES("16107", "Otros Activos Fijos");


INSERT INTO Cuenta VALUES("2", "Pasivos");
INSERT INTO Cuenta VALUES("21", "Cuentas Por Pagar");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Nutre Hogar Rifa");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Distribuidora Pimentel");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Almacén Siempre Hay");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Farmacia Selecta");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Súper Farmacia Universal");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Supermercado La Huaca");
INSERT INTO Cuenta VALUES("21000", "Cta. Por Pagar - Supercentro Changuinola");