VACUUM INTO '*direccion de la base de datos*/*nombre de la nueva base de datos*.*extencion*';
VACUUM INTO 'backup.sqlite';
/* 1.backup  2.alias para la base de datos*/
ATTACH DATABASE 'srccontabilidad.db' AS ORIGINAL;

/*1. main es la local y se le insertan del backup*/
INSERT INTO main.asiento
SELECT *
FROM ORIGINAL.asiento;
DETACH DATABASE ORIGINAL;
INSERT OR IGNORE INTO main.Cuenta SELECT * FROM backup.Cuenta;
INSERT OR REPLACE INTO main.Cuenta SELECT * FROM backup.Cuenta;
INSERT INTO main.Cuenta (id, column1, column2, ...)
SELECT id, column1, column2, ...
FROM backup.Cuenta
WHERE NOT EXISTS (SELECT 1 FROM main.Cuenta WHERE main.Cuenta.id = backup.Cuenta.id);
