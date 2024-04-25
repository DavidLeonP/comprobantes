# Comprobantes

Api para la creacion de RIDE del SRI ecuador.

## Características/features

### Versión 1.0

- **Creacion de Certificados**
Se crea metodos para certificados en general PDF de Factura, Nota de Credito, Nota de Debito, Guia de Remision Y Liquidacion de Compra

- **Estructura de JAVA para ejecutar RIDE**
Se crea una estructura de JAVA para la generacion de RIDE de los comprobantes electronicos.

- **API de Itext**
Se utiliza la API de Itext para la generacion de los comprobantes electronicos y otros documentos.

## JDK (JAVA Development Kit)

El sistema debe tener instalado el OpenJDK version 11, para verificar la versión de java se debe ejecutar el siguiente comando:

```bash
java -version
```

## Maven

El sistema debe tener instalado Maven, al menos la versión 3.5.0 para verificar la versión de Maven se debe ejecutar el siguiente comando:

```bash
mvn -version
```

## Dependencias internas

Para el presente proyecto no se requiere de dependencias internas.

## Dependencias externas

Las que se encuentran en el archivo pomParent.xml

## Configuracion pom Parent

El archivo pomParent.xml permite la configuración de las dependencias y plugins que se utilizan en el proyecto, para ello se debe configurar el archivo pom.xml y pomGenerate.

```bash
mvn clean compile install -f pomParent.xml
```

Puede ver mas información a [arquitectura JAVA](https://www.arquitecturajava.com/maven-parent-pom-y-uso-de-librerias/)

## Configuracion pom Generate

El archivo pomGenerate.xml permite la generación de estructuras necesarias para interactuar con SOAP y xml, que se encuentra en la carpeta POM para generar cada una de las estructuras de lectura con un modulo de maven.

```bash
mvn clean compile install -f pomGenerate.xml
```

## Configuracion pom

El archivo pom.xml permite la generación de la aplicación y no ejecutar el test del aplicativo.

```bash
mvn clean compile install -Dmaven.test.skip=true
```

## Ejecutar TEST

Para ejecutar los test del aplicativo se debe ejecutar el siguiente comando:

```bash
mvn test
```

## Configuraciones archivos de fuentes de caracters

Se debe agregar las fuentes a la carpeta de resources/fonts del proyecto o en el sistema operativo y para que el aplicativo pueda leer las fuentes y generar los certificados se debe modificar el archivo de configuración de la aplicación /resorces/messages.properties en las entradas de las fuentes.

```bash

>**NOTA:** 
>
>Los log del producto se obtienen de manera estándar en la consola de la aplicación.

---
![logo](./recursos/logo13Aplicaciones.png)

<omargo33@hotmail.com>

**Actualizado: 2024-04-24**