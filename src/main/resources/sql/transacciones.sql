-- Insertar datos en tipo_documento
INSERT INTO tipo_documento (id, nombre)
VALUES (1, 'INGRESO'),
       (2, 'EGRESO'),
       (3, 'AJUSTE');

-- Insertar datos en tipo_cuenta
INSERT INTO tipo_cuenta (id, nombre)
VALUES (1, 'ACTIVO'),
       (2, 'PASIVO'),
       (3, 'PATRIMONIO'),
       (4, 'INGRESO'),
       (5, 'GASTO'),
       (6, 'COSTO');

-- Insertar datos en sub_tipo_cuenta
INSERT INTO sub_tipo_cuenta (id, nombre, id_tipo_cuenta)
VALUES ('ACTIVO_CORRIENTE', 'ACTIVO CORRIENTE', 1),
       ('ACTIVO_NO_CORRIENTE', 'ACTIVO NO CORRIENTE', 1),
       ('PASIVO_CORRIENTE', 'PASIVO CORRIENTE', 2),
       ('PASIVO_NO_CORRIENTE', 'PASIVO NO CORRIENTE', 2),
       ('PATRIMONIO_NETO', 'PATRIMONIO NETO', 3),
       ('INGRESO_OPERACIONAL', 'INGRESO OPERACIONAL', 4),
       ('EGRESO_OPERACIONAL', 'EGRESO OPERACIONAL', 5),
       ('COSTO_VENTA', 'COSTO VENTA', 6);

-- Insertar datos en cuenta
INSERT INTO cuenta (id, nombre, id_sub_tipo_cuenta)
VALUES (1, 'Caja', 'ACTIVO_CORRIENTE'),
       (2, 'Bancos', 'ACTIVO_CORRIENTE'),
       (3, 'Cuentas por cobrar', 'ACTIVO_CORRIENTE'),
       (4, 'Proveedores', 'PASIVO_CORRIENTE'),
       (5, 'Capital Social', 'PATRIMONIO_NETO'),
       (6, 'Ventas', 'INGRESO_OPERACIONAL'),
       (7, 'Compras', 'EGRESO_OPERACIONAL'),
       (8, 'Costo de ventas', 'COSTO_VENTA');
-- Insertar datos en asiento
INSERT INTO asiento (id, concepto, fecha, nombre)
VALUES (1, 'Asiento de prueba 1', 1731283200000, 'Asiento 1'),
       (2, 'Asiento de prueba 2', 1731283200000, 'Asiento 2'),
       (3, 'Asiento de ajuste mensual', 1731379600000, 'Asiento 3'),
       (4, 'Asiento de cierre de ejercicio', 1731466000000, 'Asiento 4'),
       (5, 'Asiento por revalorización de activos', 1731552400000, 'Asiento 5'),
       (6, 'Asiento de ajuste por intereses', 1731638800000, 'Asiento 6'),
       (7, 'Asiento de ajuste mensual cuentas por pagar', 1731720400000, 'Asiento 7'),
       (8, 'Asiento de ajuste mensual cuentas por cobrar', 1731806800000, 'Asiento 8'),
       (9, 'Asiento por gastos operativos', 1731893200000, 'Asiento 9'),
       (10, 'Asiento por abono a proveedor', 1731979600000, 'Asiento 10'),
       (11, 'Asiento por pago de deuda a corto plazo', 1732066000000, 'Asiento 11');

-- Insertar datos en registro
INSERT INTO registro (id, comprobante, debe, haber, referencia, id_asiento, id_cuenta, id_tipo_documento)
VALUES (1, 'C001', 500.00, 0.00, 'Ingreso por venta', 1, 1, 1),
       (2, 'C001', 0.00, 500.00, 'Ingreso por venta', 1, 6, 1),
       (3, 'C002', 300.00, 0.00, 'Pago a proveedor', 2, 4, 2),
       (4, 'C002', 0.00, 300.00, 'Pago a proveedor', 2, 2, 2),
       (5, 'C003', 1500.00, 0.00, 'Pago por alquiler', 3, 5, 3),
       (6, 'C003', 0.00, 1500.00, 'Pago por alquiler', 3, 7, 3),
       (7, 'C004', 1000.00, 0.00, 'Venta de mercadería', 4, 8, 1),
       (8, 'C004', 0.00, 1000.00, 'Venta de mercadería', 4, 9, 1),
       (9, 'C005', 200.00, 0.00, 'Pago de impuestos', 5, 10, 2),
       (10, 'C005', 0.00, 200.00, 'Pago de impuestos', 5, 11, 2),
       (11, 'C006', 300.00, 0.00, 'Depósito bancario', 6, 12, 1),
       (12, 'C006', 0.00, 300.00, 'Depósito bancario', 6, 13, 1),
       (13, 'C007', 1000.00, 0.00, 'Pago a proveedor A', 7, 2, 1),
       (14, 'C007', 0.00, 1000.00, 'Pago a proveedor A', 7, 1, 1),
       (15, 'C008', 200.00, 0.00, 'Pago a proveedor B', 8, 2, 1),
       (16, 'C008', 0.00, 200.00, 'Pago a proveedor B', 8, 1, 1),
       (17, 'C009', 500.00, 0.00, 'Gasto operativo', 9, 2, 2),
       (18, 'C009', 0.00, 500.00, 'Gasto operativo', 9, 3, 2),
       (19, 'C010', 1500.00, 0.00, 'Abono a proveedor C', 10, 2, 1),
       (20, 'C010', 0.00, 1500.00, 'Abono a proveedor C', 10, 4, 1),
       (21, 'C011', 300.00, 0.00, 'Pago deuda corto plazo', 11, 2, 2),
       (22, 'C011', 0.00, 300.00, 'Pago deuda corto plazo', 11, 5, 2);