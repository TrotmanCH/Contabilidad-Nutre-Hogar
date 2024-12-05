/*usando srccontabilidad.db*/

VACUUM INTO 'BACKUP.sqlite';
ATTACH DATABASE 'BACKUP.sqlite' AS BACKUP;

DELETE FROM cuenta;

INSERT INTO main.asiento
SELECT *
FROM BACKUP.asiento;
INSERT INTO main.cuenta
SELECT *
FROM BACKUP.cuenta;
INSERT INTO main.registro
SELECT *
FROM BACKUP.registro;
INSERT INTO main.sub_tipo_cuenta
SELECT *
FROM BACKUP.sub_tipo_cuenta;
INSERT INTO main.tipo_cuenta
SELECT *
FROM BACKUP.tipo_cuenta;
INSERT INTO main.tipo_documento
SELECT *
FROM BACKUP.tipo_documento;

 --INSERT OR IGNORE

INSERT OR IGNORE INTO main.asiento
SELECT *
FROM BACKUP.asiento;
INSERT OR IGNORE INTO main.cuenta
SELECT *
FROM BACKUP.cuenta;
INSERT OR IGNORE INTO main.registro
SELECT *
FROM BACKUP.registro;
INSERT OR IGNORE INTO main.sub_tipo_cuenta
SELECT *
FROM BACKUP.sub_tipo_cuenta;
INSERT OR IGNORE INTO main.tipo_cuenta
SELECT *
FROM BACKUP.tipo_cuenta;
INSERT OR IGNORE INTO main.tipo_documento
SELECT *
FROM BACKUP.tipo_documento;
