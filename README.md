# Sistema de Gestión de Biblioteca

Sistema de gestión de biblioteca desarrollado en Java con acceso a base de datos MySQL mediante JDBC. Permite gestionar libros, usuarios y préstamos a través de un menú interactivo por consola.

## Tecnologías

- Java 21
- MySQL 8
- JDBC
- Maven

## Funcionalidades

- CRUD completo de libros y usuarios
- Registro y gestión de préstamos
- Control de disponibilidad de libros
- Registro de devoluciones con fecha automática
- Visualización de préstamos activos

## Requisitos previos

- Java 21
- MySQL 8
- Maven

## Instalación

1. Clona el repositorio
2. Ejecuta `sql/creacion.sql` en MySQL Workbench
3. Ejecuta `sql/datos.sql` para cargar datos de prueba
4. Crea `src/main/resources/config.properties` con tus credenciales:
   db.url=jdbc:mysql://localhost:3306/biblioteca
   db.user=tu_usuario
   db.password=tu_contraseña
5. Ejecuta `Main.java`

## Estructura del proyecto

src/main/java/com/biblioteca/
├── model/      # Clases de dominio
├── dao/        # Acceso a base de datos
├── service/    # Lógica de negocio
└── ui/         # Menú por consola
