# Gestor de Artículos API

API REST desarrollada con **Spring Boot** para la gestión de artículos mediante operaciones CRUD (Crear, Leer, Actualizar y Eliminar).

La aplicación utiliza una arquitectura en capas y almacena los artículos **en memoria**, utilizando una colección `ArrayList` como estructura de almacenamiento. Los datos se mantienen mientras la aplicación está en ejecución y se pierden al reiniciar la aplicación.

## Tecnologías utilizadas

* Java 21
* Spring Boot
* Spring Web
* Maven
* Postman
* Git
* GitHub

## Funcionalidades

* Crear un artículo.
* Obtener todos los artículos.
* Obtener un artículo por ID.
* Actualizar un artículo.
* Eliminar un artículo.
* Almacenamiento de datos en memoria mediante `ArrayList`.
* Generación automática de identificadores.
* Validación de datos.
* Manejo de excepciones.
* Respuestas HTTP mediante `ResponseEntity`.

## Arquitectura del proyecto

La aplicación sigue una arquitectura en capas:

```text
Cliente
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
Memoria (ArrayList)
```

## Descripción de las capas

**Controller:** recibe las solicitudes HTTP, se comunica con el Service y devuelve las respuestas HTTP correspondientes.

**Service:** contiene la lógica de negocio, realiza las validaciones y controla el flujo de las operaciones.

**Repository:** gestiona los datos almacenados en memoria mediante una colección `ArrayList`. Se encarga de realizar las operaciones de búsqueda, guardado, modificación y eliminación.

**Model:** contiene las clases que representan los objetos utilizados por la aplicación, como `Articulo`.

**Exception:** contiene las excepciones personalizadas utilizadas para gestionar situaciones específicas, como cuando un artículo no es encontrado.

## Almacenamiento en memoria

La aplicación no utiliza una base de datos.

Los artículos se almacenan temporalmente en memoria mediante una lista:

```java
private List<Articulo> listaArticulos = new ArrayList<>();
```

Los identificadores de los artículos se generan mediante un contador interno:

```java
private Long count = 0L;
```

Al guardar un nuevo artículo, se incrementa el contador y se asigna el ID correspondiente.

Los datos almacenados se mantienen mientras la aplicación está en ejecución. Al detener o reiniciar la aplicación, la información almacenada en memoria se pierde.

## Endpoints

| Método HTTP | Endpoint                      | Descripción                 |
| ----------- | ----------------------------- | --------------------------- |
| GET         | `/api/memoria/articulos`      | Obtener todos los artículos |
| GET         | `/api/memoria/articulos/{id}` | Obtener un artículo por ID  |
| POST        | `/api/memoria/articulos`      | Crear un artículo           |
| PUT         | `/api/memoria/articulos/{id}` | Actualizar un artículo      |
| DELETE      | `/api/memoria/articulos/{id}` | Eliminar un artículo        |

## Respuestas HTTP

La API utiliza diferentes códigos de estado HTTP según el resultado de cada operación:

| Código HTTP     | Descripción                              |
| --------------- | ---------------------------------------- |
| 200 OK          | Solicitud procesada correctamente        |
| 201 CREATED     | Artículo creado correctamente            |
| 204 NO CONTENT  | Artículo eliminado correctamente         |
| 400 BAD REQUEST | Los datos enviados no son válidos        |
| 404 NOT FOUND   | El artículo solicitado no fue encontrado |

## Estructura del proyecto

```text
gestor-articulos
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── controller
│   │   │   ├── service
│   │   │   ├── repository
│   │   │   ├── model
│   │   │   ├── exception
│   │   │   └── GestorArticulosApplication.java
│   │   │
│   │   └── resources
│   │
│   └── test
│
├── docs
│   └── uml
│
├── postman
│   └── GestorArticulos.postman_collection.json
│
├── pom.xml
└── README.md
```

## Colección de Postman

El proyecto incluye una colección de **Postman** para probar los diferentes endpoints de la API.

La colección contiene las operaciones CRUD:

* Obtener todos los artículos.
* Obtener un artículo por ID.
* Crear un artículo.
* Actualizar un artículo.
* Eliminar un artículo.

La colección se encuentra en:

```text
postman/GestorArticulos.postman_collection.json
```

Para utilizarla, importar el archivo de colección desde Postman y ejecutar la aplicación Spring Boot.

## Cómo ejecutar el proyecto

1. Clonar el repositorio.
2. Abrir el proyecto en Visual Studio Code.
3. Verificar que Java 21 y Maven estén instalados.
4. Ejecutar la aplicación Spring Boot.
5. Importar la colección de Postman.
6. Probar los endpoints de la API utilizando Postman.

La aplicación estará disponible en:

```text
http://localhost:8080
```

Los endpoints de artículos se encuentran bajo:

```text
http://localhost:8080/api/memoria/articulos
```

## Herramientas utilizadas durante el desarrollo

* Visual Studio Code
* Java Extension Pack
* Java 21
* Maven
* Postman
* Git
* GitHub
* draw.io

## Documentación

La carpeta `docs` contiene la documentación técnica del proyecto, incluyendo:

* Diagramas UML.
* Documentación de la arquitectura.
* Información sobre el funcionamiento de la aplicación.

## Autor

**Khalil Ali Viera**
