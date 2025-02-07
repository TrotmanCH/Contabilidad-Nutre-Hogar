# Sistema Contable

Este proyecto es una aplicación de escritorio para la gestión contable de Nutre Hogar. Permite el registro y control de
transacciones contables, incluyendo la generación de reportes de libro diario mayor y general.

````xml

<role>Software Developer</role>
<role>Frontend Developer</role>
<role>Backend Developer</role>
<role>Full Stack Developer</role>
<role>DevOps Engineer</role>
<role>QA Engineer / Tester</role>
<role>Data Engineer</role>
````

```java
SwingWorker<Void, Void> worker = new SwingWorker<>() {

    @Override
    protected Void doInBackground() {
        libroDiario = LibroDiarioController.getInstance().getView();
        balanceComprobacion = BalanceComController.getInstance().getView();
        mayorGeneral = MayorGenController.getInstance().getView();
        listaCuenta = new CuentasPestana();
        listaSubtipoCuenta = new SubtiposCuentaPestana();
        backupService = BackupService.getInstance();
        return null;
    }
};
        worker.

execute();
```

## Características

- **Registro de Transacciones**: Permite registrar transacciones contables como ingresos, egresos y adjuntos.
- **Visualización de Reportes**: Genera reportes en formato imprimible utilizando JasperStudio.
- **Interfaz de Usuario Amigable**: Desarrollada con Java Swing para una experiencia de usuario fluida.
- **Persistencia de Datos**: Utiliza Hibernate para la interacción con una base de datos SQLite.
- **Copias de Ceguridad**: Funciones de creacion de Backup y Restableciminto.


## Explicación de Dependencias

Describe las dependencias utilizadas en el proyecto y su propósito dentro del proyecto.

### Hibernate Core

```xml

<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-core</artifactId>
    <version>5.6.14.Final</version>
</dependency>
```

**Propósito**: Hibernate es una biblioteca de mapeo objeto-relacional (ORM) que facilita la interacción entre una base
de datos y objetos Java. Proporciona la capacidad de manejar el ciclo de vida de los objetos (CRUD) y mapear estos a
tablas de base de datos. `hibernate-core` es la dependencia principal para usar las características de ORM de Hibernate.

### SQLite JDBC

```xml

<dependency>
    <groupId>org.xerial</groupId>
    <artifactId>sqlite-jdbc</artifactId>
    <version>3.46.1.3</version>
</dependency>
```

**Propósito**: Esta dependencia es el driver JDBC (Java Database Connectivity) para SQLite, que permite a la aplicación
Java conectarse y ejecutar comandos SQL en una base de datos SQLite.

### SQLite Dialect

```xml

<dependency>
    <groupId>com.github.gwenn</groupId>
    <artifactId>sqlite-dialect</artifactId>
    <version>0.1.4</version>
</dependency>
```

**Propósito**: `sqlite-dialect` permite a Hibernate reconocer SQLite como un motor de base de datos compatible. Como
Hibernate soporta múltiples bases de datos, un "dialecto" se necesita para especificar las particularidades de la
sintaxis SQL que usa SQLite.

### JPA API (Java Persistence API)

```xml

<dependency>
    <groupId>javax.persistence</groupId>
    <artifactId>javax.persistence-api</artifactId>
    <version>2.2</version>
</dependency>
```

**Propósito**: Esta dependencia proporciona las interfaces de la API de JPA (Java Persistence API). JPA es una
especificación estándar para el mapeo de objetos en bases de datos relacionales en Java, y Hibernate es una
implementación de esta especificación.

### JasperReports

```xml

<dependency>
    <groupId>net.sf.jasperreports</groupId>
    <artifactId>jasperreports</artifactId>
    <version>6.21.2</version>
</dependency>
```

**Propósito**: `jasperreports` es una biblioteca utilizada para generar informes dinámicos en varios formatos (PDF,
HTML, CSV, etc.) a partir de datos en Java. Es útil para crear informes financieros o de gestión en proyectos
empresariales.

### Lombok

```xml

<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.32</version>
    <scope>provided</scope>
</dependency>
```

**Propósito**: Lombok es una herramienta que reduce el código repetitivo al generar automáticamente código como getters,
setters, constructores, `equals`, `hashCode`, y otros métodos comunes en las clases Java. Solo se necesita durante la
fase de compilación.

### Jackson Databind

```xml

<dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.17.1</version>
</dependency>
```

**Propósito**: Jackson es una biblioteca para el procesamiento de JSON en Java. `jackson-databind` proporciona la
capacidad de convertir objetos Java a JSON y viceversa. Es útil para serializar y deserializar datos.

### JetBrains Annotations

```xml

<dependency>
    <groupId>org.jetbrains</groupId>
    <artifactId>annotations</artifactId>
    <version>RELEASE</version>
    <scope>compile</scope>
</dependency>
```

**Propósito**: Esta dependencia añade anotaciones de ayuda como `@Nullable`, `@NotNull`, y otras que pueden mejorar la
calidad del código al proporcionar indicadores adicionales sobre cómo debe usarse cada método o variable. Es
particularmente útil para detectar posibles errores y mejorar la comprensión del código.