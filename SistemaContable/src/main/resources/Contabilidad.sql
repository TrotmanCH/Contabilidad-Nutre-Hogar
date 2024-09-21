CREATE DATABASE Contabilidad;
USE Contabilidad;

CREATE TABLE Cuenta(
id int unique key,
num_cuenta VARCHAR(10) unique key,
nombre VARCHAR(100)
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
INSERT INTO Cuenta VALUES("21001", "Cta. Por Pagar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES("21002", "Cta. Por Pagar - Distribuidora Pimentel");
INSERT INTO Cuenta VALUES("21003", "Cta. Por Pagar - Almacén Siempre Hay");
INSERT INTO Cuenta VALUES("21004", "Cta. Por Pagar - Farmacia Selecta");
INSERT INTO Cuenta VALUES("21005", "Cta. Por Pagar - Súper Farmacia Universal");
INSERT INTO Cuenta VALUES("21006", "Cta. Por Pagar - Supermercado La Huaca");
INSERT INTO Cuenta VALUES("21007", "Cta. Por Pagar - Supercentro Changuinola");
INSERT INTO Cuenta VALUES("21008", "Cta. Por Pagar - Cable & Wireless Panamá");
INSERT INTO Cuenta VALUES("21009", "Cta. Por Pagar - Grupo Anvered, S.A.");
INSERT INTO Cuenta VALUES("21010", "Cta. Por Pagar - Ventas A.C.M., S.A.");
INSERT INTO Cuenta VALUES("21011", "Cta. Por Pagar - Productos Toledanos, S.A.");
INSERT INTO Cuenta VALUES("21012", "Cta. Por Pagar - Edechi, S.A.");
INSERT INTO Cuenta VALUES("21013", "Cta. Por Pagar - Frutas y Legumbres Jara");
INSERT INTO Cuenta VALUES("21014", "Cta. Por Pagar - Distribuidora Fon");
INSERT INTO Cuenta VALUES("21015", "Cta. Por Pagar - Nutre Hogar Nacional");
INSERT INTO Cuenta VALUES("21016", "Cta. Por Pagar - Lavoratorio Navarro, S.A.");
INSERT INTO Cuenta VALUES("21017", "Cta. Por Pagar - Préstamos");
INSERT INTO Cuenta VALUES("21018", "Cta. Por Pagar - Actividades");
INSERT INTO Cuenta VALUES("21019", "Cta. Por Pagar - Otros");
INSERT INTO Cuenta VALUES("21020", "Cta. Por Pagar - Decimos Xlll Mes");
INSERT INTO Cuenta VALUES("21021", "Cta. Por Pagar - Salario");
INSERT INTO Cuenta VALUES("21022", "Cta. Por Pagar - Gasto de transporte Escolar");


INSERT INTO Cuenta VALUES("22", "Otras Cuents Por Pagar");
INSERT INTO Cuenta VALUES("22000", "Cta. Por Pagar - Seg. Social - Empleado");
INSERT INTO Cuenta VALUES("22001", "Cta. Por Pagar - Seg. Educativo - Empleado");
INSERT INTO Cuenta VALUES("22002", "Cta. Por Pagar - Descuento Bancario");
INSERT INTO Cuenta VALUES("22003", "Cta. Por Pagar - Seg. Social - Patronal");
INSERT INTO Cuenta VALUES("22004", "Cta. Por Pagar - Seg. Educativo - Patronal");
INSERT INTO Cuenta VALUES("22005", "Cta. Por Pagar - Riesgo Profesional");


INSERT INTO Cuenta VALUES("3", "Patrimonio");
INSERT INTO Cuenta VALUES("39990", "Patrimonio");
INSERT INTO Cuenta VALUES("39998", "Excedente Ganacia o Perdida - Mensual");
INSERT INTO Cuenta VALUES("39999", "Excedente Ganacia o Perdida - Anual");


INSERT INTO Cuenta VALUES("4", "Ingresos");
INSERT INTO Cuenta VALUES("41000", "Ingresos - Actividad");
INSERT INTO Cuenta VALUES("41002", "Ingresos - Campaña Los Niños Primeros");
INSERT INTO Cuenta VALUES("41003", "Ingresos - Donaciones Fijas");
INSERT INTO Cuenta VALUES("41004", "Ingresos - Donaciones");
INSERT INTO Cuenta VALUES("41005", "Ingresos - Subsidio del Municipio");
INSERT INTO Cuenta VALUES("41006", "Ingresos - Subsidio del MIDES");
INSERT INTO Cuenta VALUES("41007", "Ingresos - Subsidio de Loteria");
INSERT INTO Cuenta VALUES("41008", "Ingresos - Dividendo de Nutre Hogar Rifa");
INSERT INTO Cuenta VALUES("41009", "Ingresos - NHN - Apoyo Cuota Patronal");
INSERT INTO Cuenta VALUES("41010", "Ingresos - Ventas");
INSERT INTO Cuenta VALUES("41011", "Ingresos - Alquiler");
INSERT INTO Cuenta VALUES("41012", "Ingresos - Otros");


INSERT INTO Cuenta VALUES("42", "Ingresos Por Donación");
INSERT INTO Cuenta VALUES("42001", "Ing. Donación - Alimentos");
INSERT INTO Cuenta VALUES("42002", "Ing. Donación - Útiles aseo y Limpieza");
INSERT INTO Cuenta VALUES("42003", "Ing. Donación - Enseres");
INSERT INTO Cuenta VALUES("42004", "Ing. Donación - Ropa de Los Niños");
INSERT INTO Cuenta VALUES("42005", "Ing. Donación - Juguetes");
INSERT INTO Cuenta VALUES("42006", "Ing. Donación - Equipos");
INSERT INTO Cuenta VALUES("42007", "Ing. Donación - Otros");


INSERT INTO Cuenta VALUES("5", "Gastos");
INSERT INTO Cuenta VALUES("51000", "Gastos - Actividades");
INSERT INTO Cuenta VALUES("51001", "Gastos - Planilla");
INSERT INTO Cuenta VALUES("51002", "Gastos - Vacaciones");
INSERT INTO Cuenta VALUES("51003", "Gastos - Décimo Tercer Mes");
INSERT INTO Cuenta VALUES("51004", "Gastos - Prima de Antigüedad");
INSERT INTO Cuenta VALUES("51005", "Gastos - Indemnización");
INSERT INTO Cuenta VALUES("51006", "Gastos - Pre-Aviso");
INSERT INTO Cuenta VALUES("51007", "Gastos - Teléfono");
INSERT INTO Cuenta VALUES("51008", "Gastos - Lúz");
INSERT INTO Cuenta VALUES("51019", "Gastos - Agua");
INSERT INTO Cuenta VALUES("51010", "Gastos - Recolección de la Basura");
INSERT INTO Cuenta VALUES("51011", "Gastos - Gas");
INSERT INTO Cuenta VALUES("51012", "Gastos - Alimentos");
INSERT INTO Cuenta VALUES("51013", "Gastos - Útiles de Limpieza y Aseo");
INSERT INTO Cuenta VALUES("51014", "Gastos - Enseres");
INSERT INTO Cuenta VALUES("51015", "Gastos - Medicamentos");
INSERT INTO Cuenta VALUES("51016", "Gastos - Útiles de Oficina y Papelería");
INSERT INTO Cuenta VALUES("51017", "Gastos - Chequera");
INSERT INTO Cuenta VALUES("51018", "Gastos - Transporte de la Oficina");
INSERT INTO Cuenta VALUES("51019", "Gastos - Transporte de la Enfermería");
INSERT INTO Cuenta VALUES("51020", "Gastos - Flete y Acarreo");
INSERT INTO Cuenta VALUES("51021", "Gastos - Junta Directiva");
INSERT INTO Cuenta VALUES("51022", "Gastos - Capacitación");
INSERT INTO Cuenta VALUES("51023", "Gastos - Comisión Bancaria");
INSERT INTO Cuenta VALUES("51024", "Gastos - Viáticos");
INSERT INTO Cuenta VALUES("51025", "Gastos - Hospedajes");
INSERT INTO Cuenta VALUES("51026", "Gastos - Laboratorio o Clínica");
INSERT INTO Cuenta VALUES("51027", "Gastos - Combustible");
INSERT INTO Cuenta VALUES("51028", "Gastos - Funerario");
INSERT INTO Cuenta VALUES("51029", "Gastos - Depreciación");
INSERT INTO Cuenta VALUES("51030", "Mant. Y Reparación de Edificio");
INSERT INTO Cuenta VALUES("51031", "Mant. Y Reparación de Equipo");
INSERT INTO Cuenta VALUES("51032", "Mant. Y Reparación de Equipo de Oficina");
INSERT INTO Cuenta VALUES("51033", "Mant. Y Reparación de E. Lavand. Y Cocina");
INSERT INTO Cuenta VALUES("51034", "Gastos - Útiles de Cocina");
INSERT INTO Cuenta VALUES("51035", "Gastos - Ropa de los Niños");
INSERT INTO Cuenta VALUES("51036", "Gastos - Ropa de Cama, Toallas, y Otros");
INSERT INTO Cuenta VALUES("51037", "Gastos - Uniforme del Personal");
INSERT INTO Cuenta VALUES("51038", "Gastos - Escolar");
INSERT INTO Cuenta VALUES("51039", "Gastos - Misceláneos");
INSERT INTO Cuenta VALUES("51040", "Gastos - Servicios Profesionales");
INSERT INTO Cuenta VALUES("51041", "Gastos - Cuota Patronal");
INSERT INTO Cuenta VALUES("51042", "Gastos - Otros");


INSERT INTO Cuenta VALUES("52", "Gastos Otros / Donaciones");
INSERT INTO Cuenta VALUES("52000", "Consumo de Alimentos");
INSERT INTO Cuenta VALUES("52001", "Donación - Limpieza y Aseo");
INSERT INTO Cuenta VALUES("52002", "Donación - Enseres");
INSERT INTO Cuenta VALUES("52003", "Donación Medicamentos");
INSERT INTO Cuenta VALUES("52004", "Donación - Bolsa de Alimentos");
INSERT INTO Cuenta VALUES("52005", "Productos Vencidos O Dañados");
INSERT INTO Cuenta VALUES("52006", "Donación - Otros");