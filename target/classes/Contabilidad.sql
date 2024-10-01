DROP DATABASE IF EXISTS Contabilidad;
CREATE DATABASE IF NOT EXISTS Contabilidad;
USE Contabilidad;

DROP TABLE IF EXISTS Cuenta;
CREATE TABLE IF NOT EXISTS Cuenta(
id int primary key auto_increment,
num_cuenta VARCHAR(10) unique key,
nombre VARCHAR(100)
);

INSERT INTO Cuenta VALUES(null,"1", "Activo");
INSERT INTO Cuenta VALUES(null,"11", "Activo Corriente");
INSERT INTO Cuenta VALUES(null,"11020", "Caja Menuda");
INSERT INTO Cuenta VALUES(null,"11030", "Caja Menuda del MIDES");
INSERT INTO Cuenta VALUES(null,"11051", "Banco Global Bank Corp");
INSERT INTO Cuenta VALUES(null,"11090", "Caja General");
INSERT INTO Cuenta VALUES(null,"11100", "Gastos Pagados Por Adelantado");
INSERT INTO Cuenta VALUES(null,"13", "Inventario");
INSERT INTO Cuenta VALUES(null,"13000", "Alimentos");
INSERT INTO Cuenta VALUES(null,"13001", "Útiles de Limpieza y Aseo");
INSERT INTO Cuenta VALUES(null,"13002", "Enseres");
INSERT INTO Cuenta VALUES(null,"13003", "Medicamentos");
INSERT INTO Cuenta VALUES(null,"13004", "Ropa de Los Niños");
INSERT INTO Cuenta VALUES(null,"13005", "Juguetes");
INSERT INTO Cuenta VALUES(null,"13006", "Otros");
INSERT INTO Cuenta VALUES(null,"15", "Cuentas Por Cobrar");
INSERT INTO Cuenta VALUES(null,"15000", "Cta. Por Cobrar - Empleados");
INSERT INTO Cuenta VALUES(null,"15001", "Cta. Por Cobrar - Actividad");
INSERT INTO Cuenta VALUES(null,"15002", "Cta. Por Cobrar - Cuotas");
INSERT INTO Cuenta VALUES(null,"15003", "Cta. Por Cobrar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES(null,"15004", "Cta. Por Cobrar - Nutre Hogar Rifa");
INSERT INTO Cuenta VALUES(null,"15005", "Cta. Por Cobrar - Mides");
INSERT INTO Cuenta VALUES(null,"15006", "Cta. Por Cobrar - Otros");
INSERT INTO Cuenta VALUES(null,"16", "Activos Fijos");
INSERT INTO Cuenta VALUES(null,"16000", "Edificio");
INSERT INTO Cuenta VALUES(null,"16001", "Equipo de Oficina");
INSERT INTO Cuenta VALUES(null,"16002", "Equipo de Medico y Enfermería");
INSERT INTO Cuenta VALUES(null,"16003", "Transporte");
INSERT INTO Cuenta VALUES(null,"16004", "Equipo de Aire Acondicionado");
INSERT INTO Cuenta VALUES(null,"16005", "Muebles y Enseres");
INSERT INTO Cuenta VALUES(null,"16006", "Equipo de Cocina y Lavandería");
INSERT INTO Cuenta VALUES(null,"16007", "Otros Activos Fijos");
INSERT INTO Cuenta VALUES(null,"161", "Depreciación Acumulada");
INSERT INTO Cuenta VALUES(null,"16100", "Edificio");
INSERT INTO Cuenta VALUES(null,"16101", "Equipo de Oficina");
INSERT INTO Cuenta VALUES(null,"16102", "Equipo de Médico y Enfermería");
INSERT INTO Cuenta VALUES(null,"16103", "Transporte");
INSERT INTO Cuenta VALUES(null,"16104", "Equipo de Aire Acondicionado");
INSERT INTO Cuenta VALUES(null,"16105", "Muebles y enseres");
INSERT INTO Cuenta VALUES(null,"16106", "Equipo de Cocina y Lavandería");
INSERT INTO Cuenta VALUES(null,"16107", "Otros Activos Fijos");

INSERT INTO Cuenta VALUES(null,"2", "Pasivos");
INSERT INTO Cuenta VALUES(null,"21", "Cuentas Por Pagar");
INSERT INTO Cuenta VALUES(null,"21000", "Cta. Por Pagar - Nutre Hogar Rifa");
INSERT INTO Cuenta VALUES(null,"21001", "Cta. Por Pagar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES(null,"21002", "Cta. Por Pagar - Distribuidora Pimentel");
INSERT INTO Cuenta VALUES(null,"21003", "Cta. Por Pagar - Almacén Siempre Hay");
INSERT INTO Cuenta VALUES(null,"21004", "Cta. Por Pagar - Farmacia Selecta");
INSERT INTO Cuenta VALUES(null,"21005", "Cta. Por Pagar - Súper Farmacia Universal");
INSERT INTO Cuenta VALUES(null,"21006", "Cta. Por Pagar - Supermercado La Huaca");
INSERT INTO Cuenta VALUES(null,"21007", "Cta. Por Pagar - Supercentro Changuinola");
INSERT INTO Cuenta VALUES(null,"21008", "Cta. Por Pagar - Cable & Wireless Panamá");
INSERT INTO Cuenta VALUES(null,"21009", "Cta. Por Pagar - Grupo Anvered, S.A.");
INSERT INTO Cuenta VALUES(null,"21010", "Cta. Por Pagar - Ventas A.C.M., S.A.");
INSERT INTO Cuenta VALUES(null,"21011", "Cta. Por Pagar - Productos Toledanos, S.A.");
INSERT INTO Cuenta VALUES(null,"21012", "Cta. Por Pagar - Edechi, S.A.");
INSERT INTO Cuenta VALUES(null,"21013", "Cta. Por Pagar - Frutas y Legumbres Jara");
INSERT INTO Cuenta VALUES(null,"21014", "Cta. Por Pagar - Distribuidora Fon");
INSERT INTO Cuenta VALUES(null,"21015", "Cta. Por Pagar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES(null,"21016", "Cta. Por Pagar - Lavoratorio Navarro, S.A.");
INSERT INTO Cuenta VALUES(null,"21017", "Cta. Por Pagar - Préstamos");
INSERT INTO Cuenta VALUES(null,"21018", "Cta. Por Pagar - Actividades");
INSERT INTO Cuenta VALUES(null,"21019", "Cta. Por Pagar - Otros");
INSERT INTO Cuenta VALUES(null,"21020", "Cta. Por Pagar - Decimos Xlll Mes");
INSERT INTO Cuenta VALUES(null,"21021", "Cta. Por Pagar - Salario");
INSERT INTO Cuenta VALUES(null,"21022", "Cta. Por Pagar - Gasto de transporte Escolar");

INSERT INTO Cuenta VALUES(null,"22", "Otras Cuents Por Pagar");
INSERT INTO Cuenta VALUES(null,"22000", "Cta. Por Pagar - Seg. Social - Empleado");
INSERT INTO Cuenta VALUES(null,"22001", "Cta. Por Pagar - Seg. Educativo - Empleado");
INSERT INTO Cuenta VALUES(null,"22002", "Cta. Por Pagar - Descuento Bancario");
INSERT INTO Cuenta VALUES(null,"22003", "Cta. Por Pagar - Seg. Social - Patronal");
INSERT INTO Cuenta VALUES(null,"22004", "Cta. Por Pagar - Seg. Educativo - Patronal");
INSERT INTO Cuenta VALUES(null,"22005", "Cta. Por Pagar - Riesgo Profesional");

INSERT INTO Cuenta VALUES(null,"3", "Patrimonio");
INSERT INTO Cuenta VALUES(null,"39990", "Patrimonio");
INSERT INTO Cuenta VALUES(null,"39998", "Excedente Ganacia o Perdida - Mensual");
INSERT INTO Cuenta VALUES(null,"39999", "Excedente Ganacia o Perdida - Anual");

INSERT INTO Cuenta VALUES(null,"4", "Ingresos");
INSERT INTO Cuenta VALUES(null,"41000", "Ingresos - Actividad");
INSERT INTO Cuenta VALUES(null,"41002", "Ingresos - Campaña Los Niños Primeros");
INSERT INTO Cuenta VALUES(null,"41003", "Ingresos - Donaciones Fijas");
INSERT INTO Cuenta VALUES(null,"41004", "Ingresos - Donaciones");
INSERT INTO Cuenta VALUES(null,"41005", "Ingresos - Subsidio del Municipio");
INSERT INTO Cuenta VALUES(null,"41006", "Ingresos - Subsidio del MIDES");
INSERT INTO Cuenta VALUES(null,"41007", "Ingresos - Subsidio de Loteria");
INSERT INTO Cuenta VALUES(null,"41008", "Ingresos - Dividendo de Nutre Hogar Rifa");
INSERT INTO Cuenta VALUES(null,"41009", "Ingresos - NHN - Apoyo Cuota Patronal");
INSERT INTO Cuenta VALUES(null,"41010", "Ingresos - Ventas");
INSERT INTO Cuenta VALUES(null,"41011", "Ingresos - Alquiler");
INSERT INTO Cuenta VALUES(null,"41012", "Ingresos - Otros");

INSERT INTO Cuenta VALUES(null,"42", "Ingresos Por Donación");
INSERT INTO Cuenta VALUES(null,"42001", "Ing. Donación - Alimentos");
INSERT INTO Cuenta VALUES(null,"42002", "Ing. Donación - Útiles aseo y Limpieza");
INSERT INTO Cuenta VALUES(null,"42003", "Ing. Donación - Enseres");
INSERT INTO Cuenta VALUES(null,"42004", "Ing. Donación - Ropa de Los Niños");
INSERT INTO Cuenta VALUES(null,"42005", "Ing. Donación - Juguetes");
INSERT INTO Cuenta VALUES(null,"42006", "Ing. Donación - Equipos");
INSERT INTO Cuenta VALUES(null,"42007", "Ing. Donación - Otros");

INSERT INTO Cuenta VALUES(null,"5", "Gastos");
INSERT INTO Cuenta VALUES(null,"51000", "Gastos - Actividades");
INSERT INTO Cuenta VALUES(null,"51001", "Gastos - Planilla");
INSERT INTO Cuenta VALUES(null,"51002", "Gastos - Vacaciones");
INSERT INTO Cuenta VALUES(null,"51003", "Gastos - Décimo Tercer Mes");
INSERT INTO Cuenta VALUES(null,"51004", "Gastos - Prima de Antigüedad");
INSERT INTO Cuenta VALUES(null,"51005", "Gastos - Indemnización");
INSERT INTO Cuenta VALUES(null,"51006", "Gastos - Pre-Aviso");
INSERT INTO Cuenta VALUES(null,"51007", "Gastos - Teléfono");
INSERT INTO Cuenta VALUES(null,"51008", "Gastos - Lúz");
INSERT INTO Cuenta VALUES(null,"51019", "Gastos - Agua");
INSERT INTO Cuenta VALUES(null,"51010", "Gastos - Recolección de la Basura");
INSERT INTO Cuenta VALUES(null,"51011", "Gastos - Gas");
INSERT INTO Cuenta VALUES(null,"51012", "Gastos - Alimentos");
INSERT INTO Cuenta VALUES(null,"51013", "Gastos - Útiles de Limpieza y Aseo");
INSERT INTO Cuenta VALUES(null,"51014", "Gastos - Enseres");
INSERT INTO Cuenta VALUES(null,"51015", "Gastos - Medicamentos");
INSERT INTO Cuenta VALUES(null,"51016", "Gastos - Útiles de Oficina y Papelería");
INSERT INTO Cuenta VALUES(null,"51017", "Gastos - Chequera");
INSERT INTO Cuenta VALUES(null,"51018", "Gastos - Transporte de la Oficina");
INSERT INTO Cuenta VALUES(null,"51019", "Gastos - Transporte de la Enfermería");
INSERT INTO Cuenta VALUES(null,"51020", "Gastos - Flete y Acarreo");
INSERT INTO Cuenta VALUES(null,"51021", "Gastos - Junta Directiva");
INSERT INTO Cuenta VALUES(null,"51022", "Gastos - Capacitación");
INSERT INTO Cuenta VALUES(null,"51023", "Gastos - Comisión Bancaria");
INSERT INTO Cuenta VALUES(null,"51024", "Gastos - Viáticos");
INSERT INTO Cuenta VALUES(null,"51025", "Gastos - Hospedajes");
INSERT INTO Cuenta VALUES(null,"51026", "Gastos - Laboratorio o Clínica");
INSERT INTO Cuenta VALUES(null,"51027", "Gastos - Combustible");
INSERT INTO Cuenta VALUES(null,"51028", "Gastos - Funerario");
INSERT INTO Cuenta VALUES(null,"51029", "Gastos - Depreciación");
INSERT INTO Cuenta VALUES(null,"51030", "Mant. Y Reparación de Edificio");
INSERT INTO Cuenta VALUES(null,"51031", "Mant. Y Reparación de Equipo");
INSERT INTO Cuenta VALUES(null,"51032", "Mant. Y Reparación de Equipo de Oficina");
INSERT INTO Cuenta VALUES(null,"51033", "Mant. Y Reparación de E. Lavand. Y Cocina");
INSERT INTO Cuenta VALUES(null,"51034", "Gastos - Útiles de Cocina");
INSERT INTO Cuenta VALUES(null,"51035", "Gastos - Ropa de los Niños");
INSERT INTO Cuenta VALUES(null,"51036", "Gastos - Ropa de Cama, Toallas, y Otros");
INSERT INTO Cuenta VALUES(null,"51037", "Gastos - Uniforme del Personal");
INSERT INTO Cuenta VALUES(null,"51038", "Gastos - Escolar");
INSERT INTO Cuenta VALUES(null,"51039", "Gastos - Misceláneos");
INSERT INTO Cuenta VALUES(null,"51040", "Gastos - Servicios Profesionales");
INSERT INTO Cuenta VALUES(null,"51041", "Gastos - Cuota Patronal");
INSERT INTO Cuenta VALUES(null,"51042", "Gastos - Otros");

INSERT INTO Cuenta VALUES(null,"52", "Gastos Otros / Donaciones");
INSERT INTO Cuenta VALUES(null,"52000", "Consumo de Alimentos");
INSERT INTO Cuenta VALUES(null,"52001", "Donación - Limpieza y Aseo");
INSERT INTO Cuenta VALUES(null,"52002", "Donación - Enseres");
INSERT INTO Cuenta VALUES(null,"52003", "Donación Medicamentos");
INSERT INTO Cuenta VALUES(null,"52004", "Donación - Bolsa de Alimentos");
INSERT INTO Cuenta VALUES(null,"52005", "Productos Vencidos O Dañados");
INSERT INTO Cuenta VALUES(null,"52006", "Donación - Otros");
select * from Cuenta;
DROP TABLE IF EXISTS Tipo_Documento;
CREATE TABLE IF NOT EXISTS Tipo_Documento(
    id int primary key auto_increment, 
    nombre varchar(10)
); 

INSERT INTO Tipo_Documento VALUES(null,"N-ING");
INSERT INTO Tipo_Documento VALUES(null,"N-EGR");
INSERT INTO Tipo_Documento VALUES(null,"N-AJT"); 
select * from Tipo_Documentp;
DROP TABLE IF EXISTS transacciones;
CREATE TABLE IF NOT EXISTS transacciones(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE, 
    nodoc INT, 
    tipo_docu INT,
    no_cheque_comp VARCHAR(100), 
    referencia VARCHAR(1000), 
    codigoC INT, 
    debe REAL, 
    hacer REAL,
    CONSTRAINT tipo_docu_fk FOREIGN KEY(tipo_docu) REFERENCES Tipo_Documento(id),
    CONSTRAINT codigoC_fk FOREIGN KEY(codigoC) REFERENCES Cuenta(id)
);

describe transacciones;

select * from transacciones; 
insert into transacciones(id, fecha, nodoc,tipo_docu,no_cheque_comp,referencia,codigoC, debe,hacer) values (null, curdate(),066,2,'101',"Para comprar jugos",5,200,200);

SELECT 
    t.id, 
    t.fecha, 
    t.nodoc, 
    td.nombre AS tipo_documento,  
    t.no_cheque_comp, 
    t.referencia, 
    c.num_cuenta AS num_cuenta,      
    t.debe, 
    t.hacer
FROM 
    transacciones t 
JOIN Tipo_Documento td ON t.tipo_docu = td.id             
JOIN Cuenta c ON t.codigoC = c.id;               

