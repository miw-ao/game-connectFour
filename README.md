# ConnectFour. *viewModel*

> By Oliver Fernández García ([**@oliver-upm**](//github.com/oliver-upm)) & Adrián Castro Vilar ([**@adriancastrovilar**](//github.com/adriancastrovilar))

### Autoevaluación

> Nota: 9,5. Hemos conseguido dejar en un segundo plano que funcione el código (algo que se consiguió rápido) por
> invertir mucho tiempo en revisar cada nombre de clase, función, variable, visibilidad y en general cada una de las
> pautas de diseño vistas en clase, priorizando alta cohesión, bajo acoplamiento y tamaño pequeño. Una de las mayores
> dificultades a las que nos enfrentamos fue cambiar el modo en el que verificamos el 4 en raya, para hacerlo con clase
> línea, dirección, etc. Consideramos un trabajo final exitoso tanto el modelo del dominio como vista y dominio, y sobre
> todo el cambio de paradigma pensando y releyendo cada línea o variable.

## Requirements

- Java 17 o superior
- Maven 3 o superior

## Compilation and Execution

To compile and run the project, use the following commands in your terminal:

```bash
mvn install
java -jar target/game-connectFour-2.0-Release.jar
```

OR

```bash
mvn compile
mvn exec:java -Dexec.mainClass="connectfour.ConnectFour"
```

## Cleanup

If you want to clean up the files generated during compilation, you can use the following command:

```bash
mvn clean
```

This command will remove the `target` directory, which is where Maven places the output of its compiling and packaging.

