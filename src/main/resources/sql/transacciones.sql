-- Inserciones para Transacciones
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (1, 1690972800, 'Compra de suministros de oficina');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (2, 1691059200, 'Venta de productos');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (3, 1691145600, 'Pago de servicios públicos');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (4, 1691232000, 'Compra de equipo informático');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (5, 1691318400, 'Pago de salarios');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (6, 1691404800, 'Alquiler de oficina');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (7, 1691491200, 'Compra de software');
INSERT INTO Transacciones (codigo_transaccion, fecha, concepto) VALUES (8, 1691577600, 'Pago de impuestos');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (9, 1691664000, 'Gastos de marketing');
INSERT INTO Transacciones (codigo_transaccion, fecha, descripcion) VALUES (10, 1691750400, 'Ventas de servicios de consultoría');

-- Inserciones para Asientos
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (1, 1, 1690972800);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (2, 2, 1691059200);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (3, 3, 1691145600);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (4, 4, 1691232000);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (5, 5, 1691318400);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (6, 6, 1691404800);
INSERT INTO Asientos (id_asiento, id_transaccion, fecha_asiento) VALUES (7, 7, 1691491200);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (8, 8, 1691577600);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (9, 9, 1691664000);
INSERT INTO Asientos (codigo_asiento, codigo_transaccion, fecha_asiento) VALUES (10, 10, 1691750400);

-- Inserciones para Detalles de Asiento
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (1, 1, '5000', 150); -- Gastos de sueldos
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (2, 1, '1010', 150); -- Caja Chica
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (3, 2, '4000', 300); -- Ventas de productos
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (4, 2, '2000', 300); -- Cuentas por Pagar
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (5, 3, '5010', 75);  -- Gastos de Honorarios
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (6, 3, '1010', 75);  -- Caja Chica
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (7, 4, '1040', 1200); -- Equipos de computación
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (8, 4, '2000', 1200); -- Cuentas por Pagar
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (9, 5, '5000', 500);  -- Gastos de sueldos
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (10, 5, '1010', 500); -- Caja Chica
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (11, 6, '5010', 800);  -- Gastos de Honorarios
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (12, 6, '1100', 800); -- Bancos
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (13, 7, '1070', 400);  -- Software
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (14, 7, '2000', 400); -- Cuentas por Pagar
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (15, 8, '2050', 200);  -- Impuestos por Pagar
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (16, 8, '1100', 200); -- Bancos
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (17, 9, '5030', 600);  -- Gastos de Marketing
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (18, 9, '1010', 600); -- Caja Chica
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (19, 10, '4010', 300); -- Ventas de Servicios
INSERT INTO DetallesAsiento (codigo_detalle, codigo_asiento, codigo_cuenta, monto) VALUES (20, 10, '1200', 300); -- Cuentas por Cobrar

-- Repetir las inserciones anteriores para generar más asientos, detalles y transacciones