# Tarea1 Daniel Gomez



# Proyecto de Gestión de Productos y Categorías

Este proyecto es una aplicación desarrollada utilizando Java Spring, que permite gestionar productos y categorías. La aplicación implementa autenticación y autorización mediante JWT, y utiliza una base de datos MySQL o MariaDB para almacenar los datos.

## Requisitos del Proyecto

### Estructura

- La aplicación utiliza la estructura de Java Spring provista por el profesor en las clases técnicas.

### Tecnologías

- **Spring Data JPA**
- **Spring Framework**
- **Spring Security con JWT**
- **Configuración CORS**

### Roles de Usuarios

- **SUPER-ADMIN-ROLE**
- **USER**

### Entidades

#### Producto

- **id**: Identificador único del producto.
- **nombre**: Nombre del producto.
- **descripción**: Descripción del producto.
- **precio**: Precio del producto.
- **cantidad en stock**: Cantidad disponible en stock del producto.
- **Categoría**: Relación con la entidad Categoría.

#### Categoría

- **id**: Identificador único de la categoría.
- **nombre**: Nombre de la categoría.
- **descripción**: Descripción de la categoría.

### Base de Datos

- Se utiliza una base de datos MySQL o MariaDB de forma local.
- Los roles de usuario se registran en la base de datos.
- Los datos de los productos y categorías se registran en la base de datos.

### Autenticación y Autorización

- Todos los usuarios autenticados pueden consultar los productos y las categorías.
- Solo el usuario con el rol **SUPER-ADMIN-ROLE** puede registrar, actualizar y borrar productos y categorías.

### Usuarios Predefinidos

- Debe existir un usuario con rol **SUPER-ADMIN-ROLE** y un usuario con rol **USER** previamente insertados en la base de datos al iniciar el proyecto.
- Las contraseñas de los usuarios están encriptadas en la base de datos.
- No se crea un método para registrar usuarios, estos ya deben estar creados en la base de datos al arrancar el proyecto.

### Pruebas

- Se proporciona una colección JSON para Insomnia que permite probar las siguientes acciones:
  - Registrar Producto y Categoría
  - Actualizar Producto y Categoría
  - Borrar Producto y Categoría
  - Listar Productos y Categorías

- No debe existir ninguna categoría creada previamente en la base de datos.

## Configuración del Proyecto

1. Clonar el repositorio del proyecto.
2. Configurar la base de datos MySQL o MariaDB localmente.
3. Insertar los usuarios predefinidos en la base de datos.
4. Ejecutar el proyecto.

## Ejecución del Proyecto

1. Compilar y ejecutar el proyecto utilizando las herramientas y configuraciones provistas en las clases técnicas.
2. Importar la colección JSON en Insomnia y realizar las pruebas correspondientes.


