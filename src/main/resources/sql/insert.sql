INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('1000', 'Caja general de la empresa', 'Caja', 'ACTIVO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('1100', 'Bancos - Cuenta corriente', 'Bancos', 'ACTIVO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('1200', 'Cuentas por cobrar clientes', 'Cuentas por Cobrar', 'ACTIVO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('1300', 'Inventarios de mercaderías', 'Inventarios', 'ACTIVO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('2000', 'Cuentas por pagar proveedores', 'Cuentas por Pagar', 'PASIVO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('2100', 'Préstamos bancarios a corto plazo', 'Préstamos Bancarios', 'PASIVO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('3000', 'CAPITAL social aportado', 'CAPITAL Social', 'CAPITAL');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('3100', 'Reservas de capital', 'Reservas de CAPITAL', 'CAPITAL');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('4000', 'Ventas de productos', 'Ventas', 'INGRESO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('4100', 'INGRESOs por servicios', 'INGRESOs por Servicios', 'INGRESO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('5000', 'GASTOs de sueldos', 'GASTOs de Sueldos', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('5100', 'GASTOs de alquiler', 'GASTOs de Alquiler', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('5200', 'GASTOs de suministros', 'GASTOs de Suministros', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('5300', 'GASTOs de publicidad', 'GASTOs de Publicidad', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('6000', 'Depreciación de activos fijos', 'Depreciación', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('7000', 'Intereses pagados', 'Intereses Pagados', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('8000', 'Impuestos sobre la renta', 'Impuestos sobre la Renta', 'GASTO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('9000', 'Otros ingresos', 'Otros INGRESOs', 'INGRESO');
INSERT INTO Cuentas (codigo_cuenta, descripcion, nombre_cuenta, tipo_cuenta) VALUES ('9100', 'Otros gastos', 'Otros GASTOs', 'GASTO');
INSERT INTO Transacciones (concepto, fecha) VALUES ('Aporte de capital inicial por los socios', 1642118400000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Compra de inventario de mercaderías', 1706227200000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Venta de productos a clientes', 1706486400000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de sueldos del personal', 1715817600000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de alquiler del local comercial', 1705968000000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Compra de equipo de oficina', 1704412800000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Venta de servicios de consultoría', 1704240000000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de intereses de préstamo bancario', 1728432000000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de impuestos sobre la renta', 1711065600000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('INGRESO por venta de activos fijos', 1704240000000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Compra de suministros de oficina', 1674691200000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('GASTOs de publicidad en medios locales', 1672963200000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Depreciación mensual de activos fijos', 1674086400000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de préstamo bancario a largo plazo', 1610064000000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('INGRESO por otros servicios prestados', 1705104000000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de gastos de suministros', 1672963200000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('INGRESO por otros ingresos no operativos', 1706227200000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de otros gastos operativos', 1611187200000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Compra de publicidad en línea', 1706486400000);
INSERT INTO Transacciones (concepto, fecha) VALUES ('Pago de impuestos adicionales', 1609459200000);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('INGRESO','Aporte de capital inicial', 1642118400000, 1);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('INGRESO','Compra de inventario', 1706227200000, 2);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('INGRESO','Venta de productos', 1706486400000, 3);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('INGRESO','Pago de sueldos', 1715817600000, 4);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('INGRESO','Pago de alquiler', 1705968000000, 5);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('INGRESO','Compra de equipo de oficina', 1704412800000, 6);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('EGRESO','Venta de servicios de consultoría', 1704240000000, 7);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('EGRESO','Pago de intereses de préstamo', 1728432000000, 8);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('EGRESO','Pago de impuestos', 1711065600000, 9);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('EGRESO','INGRESO por venta de activos', 1704240000000, 10);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('EGRESO','Compra de suministros de oficina', 1674691200000, 11);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','GASTOs de publicidad', 1672963200000, 12);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','Depreciación de activos fijos', 1674086400000, 13);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','Pago de préstamo a largo plazo', 1610064000000, 14);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','INGRESO por otros servicios', 1705104000000, 15);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','Pago de gastos de suministros', 1672963200000, 16);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','INGRESO por otros ingresos', 1706227200000, 17);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','Pago de otros gastos operativos', 1611187200000, 18);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','Compra de publicidad en línea', 1706486400000, 19);
INSERT INTO Asientos (tipo_documento, concepto, fecha_asiento, id_transaccion) VALUES ('AJUSTE','Pago de impuestos adicionales', 1609459200000, 20);
-- Asiento 1: Aporte de capital inicial
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (1, 1, 10000.00, 0.00); -- Debe: Caja
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (1, 7, 0.00, 10000.00); -- Haber: CAPITAL Social

-- Asiento 2: Compra de inventario
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (2, 4, 5000.00, 0.00); -- Debe: Inventarios
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (2, 5, 0.00, 5000.00); -- Haber: Cuentas por Pagar

-- Asiento 3: Venta de productos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (3, 1, 0.00, 3000.00); -- Haber: Caja
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (3, 9, 3000.00, 0.00); -- Debe: Ventas

-- Asiento 4: Pago de sueldos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (4, 11, 2000.00, 0.00); -- Debe: GASTOs de Sueldos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (4, 1, 0.00, 2000.00); -- Haber: Caja

-- Asiento 5: Pago de alquiler
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (5, 12, 1500.00, 0.00); -- Debe: GASTOs de Alquiler
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (5, 1, 0.00, 1500.00); -- Haber: Caja

-- Asiento 6: Compra de equipo de oficina
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (6, 3, 4000.00, 0.00); -- Debe: Cuentas por Cobrar (suponiendo que es un activo)
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (6, 5, 0.00, 4000.00); -- Haber: Cuentas por Pagar

-- Asiento 7: Venta de servicios de consultoría
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (7, 1, 0.00, 2500.00); -- Haber: Caja
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (7, 10, 2500.00, 0.00); -- Debe: INGRESOs por Servicios

-- Asiento 8: Pago de intereses de préstamo
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (8, 16, 500.00, 0.00); -- Debe: Intereses Pagados
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (8, 1, 0.00, 500.00); -- Haber: Caja

-- Asiento 9: Pago de impuestos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (9, 17, 800.00, 0.00); -- Debe: Impuestos sobre la Renta
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (9, 1, 0.00, 800.00); -- Haber: Caja

-- Asiento 10: INGRESO por venta de activos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (10, 1, 700.00, 0.00); -- Debe: Caja
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (10, 18, 0.00, 700.00); -- Haber: Otros INGRESOs

-- Asiento 11: Compra de suministros de oficina
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (11, 13, 300.00, 0.00); -- Debe: GASTOs de Suministros
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (11, 1, 0.00, 300.00); -- Haber: Caja

-- Asiento 12: GASTOs de publicidad
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (12, 14, 1200.00, 0.00); -- Debe: GASTOs de Publicidad
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (12, 1, 0.00, 1200.00); -- Haber: Caja

-- Asiento 13: Depreciación de activos fijos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (13, 15, 600.00, 0.00); -- Debe: Depreciación
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (13, 3, 0.00, 600.00); -- Haber: Cuentas por Cobrar

-- Asiento 14: Pago de préstamo a largo plazo
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (14, 5, 1000.00, 0.00); -- Debe: Cuentas por Pagar
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (14, 1, 0.00, 1000.00); -- Haber: Caja

-- Asiento 15: INGRESO por otros servicios
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (15, 1, 0.00, 2200.00); -- Haber: Caja
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (15, 10, 2200.00, 0.00); -- Debe: INGRESOs por Servicios

-- Asiento 16: Pago de gastos de suministros
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (16, 13, 400.00, 0.00); -- Debe: GASTOs de Suministros
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (16, 1, 0.00, 400.00); -- Haber: Caja

-- Asiento 17: INGRESO por otros ingresos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (17, 1, 0.00, 900.00); -- Haber: Caja
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (17, 18, 900.00, 0.00); -- Debe: Otros INGRESOs

-- Asiento 18: Pago de otros gastos operativos
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (18, 19, 500.00, 0.00); -- Debe: Otros GASTOs
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (18, 1, 0.00, 500.00); -- Haber: Caja

-- Asiento 19: Compra de publicidad en línea
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (19, 14, 800.00, 0.00); -- Debe: GASTOs de Publicidad
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (19, 1, 0.00, 800.00); -- Haber: Caja

-- Asiento 20: Pago de impuestos adicionales
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (20, 17, 1000.00, 0.00); -- Debe: Impuestos sobre la Renta
INSERT INTO Detalles_Asientos (id_asiento, id_cuenta, debe, haber) VALUES (20, 1, 0.00, 1000.00); -- Haber: Caja
