# gestorTareas

Para cargar crear la base de datos y el usuario que lo usa, ejecutar en terminal "script.sh" que se encuentra en src/main/resources/carga-bd. Le
pedirá la contraseña de su usuario root de MySQL para ejecutar el script.
Este script ejecuta el archivo gestorTarea.sql que se encuentra en la misma carpeta. MySQL se ejecuta en el puerto 3306.

Tanto el back como el front se levantan por separado (el back ejecutando el servlet con el que inicia el proyecto springboot en
src/main/java/com/gestorTareas/GestorTareasApplication.java).

Una vez levantado, las rutas para probar la api-rest son: 

GET http://localhost:8080/tasks devuelve la lista de tareas

GET http://localhost:8080/task/id  devuelve la tarea con el id especificado en la ruta

POST  http://localhost:8080/task  carga una tarea en la base de datos

PATCH http://localhost:8080/task/id   edita la tarea con el id especificado en la ruta, espera un objeto de tipo Task en el body del request

DELETE http://localhost:8080/task/id  elimina la tarea con el id especificado en la ruta


Para implementar el backend utilicé: Java 11, MySQL 5.7.28, Apache Maven 3.6.0, Spring Boot 2.5.6, Spring Data, Spring Web.
