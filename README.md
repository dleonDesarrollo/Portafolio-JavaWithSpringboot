# Sprint Final Módulo 6 [JAVA con Framework Spring Boot]

#### Desarrollador
- [Diego Saavedra](https://github.com/dleonDesarrollo),

## Contexto

Preder, Empresa de Asesorías en Prevención de Riesgos,
busca implementar una solución tecnológica que de respuesta
a la necesidad de sistematizar y organizar eficientemente
todos los procesos e información tanto internos, como de sus clientes.
https://user-images.githubusercontent.com/60191320/184059256-c2f7e3cf-3c94-4de6-ad05-8121257dc4c0.png
## Solución

Se ha desarrollado un sistema informático que cubre los procesos de negocio
requeridos por la Empresa,
que ofrece una mejora en la gestión, el control y disponibilidad
de los datos necesarios para su funcionamiento óptimo.

De acuerdo a los requerimientos de la empresa, se ha realizado
algunas implementaciones al sistema, para garantizar el apropiado funcionamiento de este.


- Se definen diversas clases 'entity' con sus propiedades representando a cada
  entidad que conforma el programa y que estructuran las tablas de la base de datos.
- Se utiliza modelo JPA para interactuar con la base de dato y garantizar la persistencia de los objetos en el programa.
- Se agrega estilos y responsividad declarados en un archivo independiente.
- Se implementa validaciones para los datos requeridos en los formularios.
- Se consideran todos los enlaces en el sitios para una navegabilidad correcta.

1.- Login de Acceso al Sistema.

	Función que permite el acceso a un usuario al portal
	- A través de un usuario "admin" y contraseña "1234". Donde se accede a la gestión de capacitaciones.
	- Y a través de un usuario "cliente", contraseña "1234". Para la gestión de usuarios.


2.- Gestión de Usuarios de la plataforma.

	- Se crea formulario que permitará agregar un nuevo usuario al sistema dependiendo de su perfil y editarlo en caso de 
    ser requerido.


3.- Gestión de Capacitaciones

	- Despliega el listado de capacitaciones y formulario para añadir una nueva o editarla.

4.- Conexión a base de datos

	- Se utilizó una base de datos local mediante MySQL, en la cual se crean las tablas para almacenar capacitaciones y y tablas para 
	los distintos tipos de usuarios del sitema.

## Herramientas

- Java 15
- Tomcat 9
- MySQL
- SpringBoot
- DataTables
