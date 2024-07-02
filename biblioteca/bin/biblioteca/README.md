### Aplicación en Java para gestionar una biblioteca a través de consola.


Actualmente la aplicación funciona con vectores (_arrays dinámicos_), por lo que **la información almacenada durante la ejecución se perderá** una vez se cierre el programa. Más adelante la aplicación incorporará persistencia de datos, primero mediante ficheros y luego en base de datos.

### <a name="1"></a>Antes de empezar

Para una correcta y más fácil ejecución de la aplicación se recomienda el uso de un entorno de desarrollo integrado o IDE, caso de **_Eclipse_**, que es en el que se ha desarrollado el código.

### <a name="2"></a>Creación de paquetes

En el IDE, es necesario crear un proyecto (podemos llamarlo _biblioteca_) y dentro de éste un paquete, que puede denominarse igual biblioteca. Dentro se ubicarán todas las clases que se incluyen en este proyecto.

### <a name="3"></a>Ejecución

Para que la aplicación funcione debemos ejecutar la clase **Biblioteca.java**, que es la clase ejecutable donde se encuentra el método _main_ que llama a las demás clases de objetos.

### <a name="4"></a>Funcionamiento

Al ejecutar la aplicación aparecerá en la consola un menú que ofrecerá al usuario varias opciones:

1. Gestión de libros.
2. Gestión de usuarios.
3. Realizar préstamo.
4. Devolver préstamo.
5. Mostrar préstamos.
0. Salir.

Las cuatro primeras opciones dan acceso a sendos nuevos menús que permiten la gestión de los distintos materiales y de los usuarios de la biblioteca, y que cuentan con las siguientes opciones:

1. Añadir recurso / usuario.
2. Eliminar recurso / usuario.
3. Modificar recurso / usuario.
4. Mostrar recursos / usuarios.
0. Volver al menú principal.


Las opciones 3, 4 y 5 del menú principal de la biblioteca permiten la gestión de los préstamos de material de distinto tipo que los usuarios de la biblioteca solicitan o devuelven. La opción 7 ("Mostrar préstamos"), permite comprobar el historial de préstamos y devoluciones de material.

El usuario podrá interactuar con la aplicación a través del teclado tanto para elegir la opción deseada como para introducir los distintos datos que se le irán solicitando.

La aplicación finalizará cuando en el menú principal se pulse 0. **Al finalizar la aplicación se perderá toda la información introducida**.


