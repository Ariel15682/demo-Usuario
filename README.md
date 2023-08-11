# demo-Usuario

REST creada en Jersey con los metodos CRUD (GET, POST, DELETE) basicos para la creacion, 
borrar, y listar usuarios (todos y filtrando por nombre de usuario. La misma fue desarrollada
siguiendo las buenas practicas de la ingenieria de software; agile, SCRUM, XP, clean code,
testing, refactoring, se utilizo el patron de desarrollo "builder" (usuariosBuilder), los
conceptos SOLID y operador ternario entre otros. 

pom.xml
````xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-jersey</artifactId>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
````

La aplicacion consta de un modelo (clase) Usuario con los atributos especificos y basicos
del mismo y un metodo toString(), no posee metodos setter, o sea que es inmutable. Tampoco
posee de metodos get y unicamente se pueden conocer su caracteristicas haciendo uso de
toString.

La clase usuarioBuilder dota a la aplicacion de caracteristicas de gestion a la hora de
crear un usuario; evita dejar campos vacios o nulos en alguna de las propiedades.

La clase JerseyConfig donde se indica la ubicacion del paquete que contiene el controlador,
 o punto de entrada (entry point) de la apliacacion

La clase UsuariosController con los "entry point" correspondientes.

Una clase de servicio, UsuarioService, con los CRUD (Create, Read, Update, Delete). Ademas en
la misma se escoge como va a operar la capa de persistencia. Hay 2 opciones posibles:
* Escoger mediante un String "memoria" en el cual los datos son volatiles, se almacenan
en una lista y se borran al detener la aplicacion.
* String "fichero"; se crea un fichero usuarios.txt en donde se guardan los datos en una
linea cuyos atributos se separan con una coma y al momento de la lectura se "parsean" 
nuevamante en un JSON de forma inversa. 
Se encarga ademas de filtrar a los usuarios al momento de la creacion si es que ya existen.

Por otro lado, en el paquete "repositories" contamos con una clase abstracta "UsuariosDB"
encargada de declarar como se va a implementar la "capa de persistencia", metodos obtener, 
buscar, insertar y borrar ademas de dos metodos que se ocupan de contar las eliminaciones
e inserciones realizadas.
Una clase UsuariosDBFactory que de acuerdo al String recibido (memoria o fichero) gestiona
como se va a implementar la persistencia a traves de las clases UsuarioDBMemoria y 
UsuarioDBFichero.
Por ultimo la clase UsuarioDBNullable para gestionar el caso en que se intente crear/guardar
datos en una DB no seleccionada (memoria o fichero)

Una clase DemoApplication con su metodo main

Fichero .gitignore que se ocupa de filtrar archivos de proyectos Java gestionados con 
maven en IntelliJ.

Un fichero "usuarios.txt" que hace las veces de "base de datos" segun opcion escogida.

Se adjunta coleccion de Postman (RESTful API Usuarios1 CRUD.postman_collection) con el
CRUD y los test para cada una de las "request"

## API de Swagger

