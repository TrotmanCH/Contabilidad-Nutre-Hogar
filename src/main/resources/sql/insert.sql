INSERT INTO tipo_documento (nombre)
VALUES (2);
INSERT INTO tipo_documento (nombre)
VALUES (3);
INSERT INTO tipo_documento (nombre)
VALUES (1);
INSERT INTO tipo_cuenta(nombre)
VALUES ('ACTIVOS');
INSERT INTO tipo_cuenta(nombre)
VALUES ('PASIVOS');
INSERT INTO tipo_cuenta(nombre)
VALUES ('PATRIMONIO');
INSERT INTO tipo_cuenta(nombre)
VALUES ('INGRESOS');
INSERT INTO tipo_cuenta(nombre)
VALUES ('GASTOS');
INSERT INTO subtipo_cuenta(id, nombre)
VALUES ('1.1', 'ACTIVOS CORRIENTES');
INSERT INTO subtipo_cuenta(id, nombre)
VALUES ('1.3', 'INVETARIOS');
INSERT INTO subtipo_cuenta(id, nombre)
VALUES ('2.1', 'CUENTAS POR PAGAR');
INSERT INTO subtipo_cuenta(id, nombre)
VALUES ('2.2', 'Otras');
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('1000', 'Caja', '1.1', 2);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('1100', 'Bancos', '1.1', 2);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('1200', 'cuenta por Cobrar', '1.1', 2);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('1300', 'Inventarios', '1.1', 2);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('2000', 'cuenta por Pagar', '1.1', 3);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('2100', 'Préstamos Bancarios', '1.1', 3);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('3000', 'CAPITAL Social', '1.1', 3);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('3100', 'Reservas de CAPITAL', '1.1', 3);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('4000', 'Ventas', '1.1', 4);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('4100', 'INGRESOs por Servicios', '1.1', 4);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('5000', 'GASTOs de Sueldos', '1.1', 4);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('5100', 'GASTOs de Alquiler', '1.1', 4);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('5200', 'GASTOs de Suministros', '1.1', 4);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('5300', 'GASTOs de Publicidad', '1.1', 5);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('6000', 'Depreciación', '1.1', 5);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('7000', 'Intereses Pagados', '1.1', 5);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('8000', 'Impuestos sobre la Renta', '1.1', 5);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('9000', 'Otros INGRESOs', '1.1', 5);
INSERT INTO cuenta (id, nombre, id_subtipo_cuenta, id_tipo_cuenta)
VALUES ('9100', 'Otros GASTOs', '1.1', 5);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Aporte de capital inicial por los socios', 1642118400000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Compra de inventario de mercaderías', 1706227200000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Venta de productos a clientes', 1706486400000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de sueldos del personal', 1715817600000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de alquiler del local comercial', 1705968000000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Compra de equipo de oficina', 1704412800000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Venta de servicios de consultoría', 1704240000000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de intereses de préstamo bancario', 1728432000000, 1);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de impuestos sobre la renta', 1711065600000, 2);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('INGRESO por venta de activos fijos', 1704240000000, 2);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Compra de suministros de oficina', 1674691200000, 2);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('GASTOs de publicidad en medios locales', 1672963200000, 2);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Depreciación mensual de activos fijos', 1674086400000, 2);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de préstamo bancario a largo plazo', 1610064000000, 2);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('INGRESO por otros servicios prestados', 1705104000000, 3);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de gastos de suministros', 1672963200000, 3);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('INGRESO por otros ingresos no operativos', 1706227200000, 3);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de otros gastos operativos', 1611187200000, 3);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Compra de publicidad en línea', 1706486400000, 3);
INSERT INTO asiento (concepto, fecha, id_tipo_documento)
VALUES ('Pago de impuestos adicionales', 1609459200000, 3);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (11, 'ryguhjk', 'Aporte de capital inicial', 1, 1, 768);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (10, 'tfygujhkl', 'Compra de inventario', 2, 2, 6457);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (10, 'yghjk', 'Venta de productos', 3, 3, 46);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (9, 'ygjhkml', 'Pago de sueldos', 4, 4, 43);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (9, 'gjhk', 'Pago de alquiler', 1, 5, 7);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (8, 'uhjkl', 'Compra de equipo de oficina', 2, 6, 57);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (8, 'uhjkm', 'Venta de servicios de consultoría', 2, 7, 465);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (7, 'ygjhk', 'Pago de intereses de préstamo', 3, 8, 8);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (7, 'guhjkml,', 'Pago de impuestos', 3, 9, 87);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (6, 'ygjhkn', 'INGRESO por venta de activos', 4, 10, 76);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (6, 'ygujhk', 'Compra de suministros de oficina', 5, 11, 76);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (5, 'ghjnkm', 'GASTOs de publicidad', 4, 12, 87);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (4, 'tfyghjk', 'Depreciación de activos fijos', 10, 13, 678);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (4, 'rtyguhjk', 'Pago de préstamo a largo plazo', 9, 14, 877);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (3, 'tyghj', 'INGRESO por otros servicios', 9, 15, 8);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (3, 'redtfyghj', 'Pago de gastos de suministros', 6, 16, 567);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (2, 'tryfghj', 'INGRESO por otros ingresos', 6, 17, 65);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (2, 'hgjbm', 'Pago de otros gastos operativos', 6, 18, 657);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (1, 'ugj', 'Compra de publicidad en línea', 7, 19, 548);
INSERT INTO registro (id_asiento, comprobante, referencia, id_cuenta, debe, haber)
VALUES (1, 'ryguj', 'Pago de impuestos adicionales', 6, 20, 76);


SELECT c.nombre,
       c.id,
       SUM(r.debe)                AS `Total_Debe`,
       SUM(r.haber)               AS `Total_Haber`,
       SUM(r.debe) - SUM(r.haber) AS `Diferencias`

FROM cuenta c
         INNER JOIN registro r ON r.id_cuenta = c.id
GROUP BY c.id