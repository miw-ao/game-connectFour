# ConnectFour. *domainModel*

> By Oliver Fernández García ([**@oliver-upm**](//github.com/oliver-upm)) & Adrián Castro Vilar ([**@adriancastrovilar**](//github.com/adriancastrovilar))

## Requirements

- Java 17 o superior
- Maven 3 o superior

## Compilation and Execution

To compile and run the project, use the following commands in your terminal:

```bash
mvn install
java -jar target/game-connectFour-1.0-Release.jar
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

