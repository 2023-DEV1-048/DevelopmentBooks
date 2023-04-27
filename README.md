
# Building and Running the project

This README file explains how to build and run a Maven project. Before we begin, make sure that Maven and a Java Development Kit (JDK) are installed on your system.

## Building the Project

To build a Maven project, follow these steps:

1. Open a terminal or command prompt window.
2. Navigate to the root directory of the project you want to build.
3. Run the following command:

```
mvn clean install
```

This command will compile the source code, run any tests, and package the project into a JAR file.

If the build is successful, you will see a message similar to the following:

```
BUILD SUCCESS
```

The JAR file will be located in the `target/` directory.

## Running the JAR File

To run the JAR file, follow these steps:

1. Open a terminal or command prompt window.
2. Navigate to the `target/` directory of the project.
3. Run the following command:

```
java -jar development-books-[version].jar
```
## Accessing the Swagger UI

Once the JAR file is running, you can access the Swagger UI by opening a web browser and navigating to the following URL:

```
http://localhost:8080/swagger-ui.html
```

This will open the Swagger UI, which allows you to interact with the API.

If you encounter any issues while accessing the Swagger UI, make sure that the JAR file is running and that the correct port number is used in the URL. You can also check the console output for any error messages.

## Using the Application

Once the JAR file is running, you can use the application by opening the file located to `gui` folder.

Open the `gui/basket.html` file in your web browser, which allows you to interact with the application.

If you encounter any issues while using the application, make sure that the JAR file is running and that the correct port number is used in the URL. You can also check the console output for any error messages.

## Troubleshooting

If you encounter any issues while running the JAR file, make sure that you have the correct version of the JDK installed and that your `JAVA_HOME` environment variable is set correctly.

You can also try running the JAR file with the `-verbose` option to enable verbose output:

```
java -jar development-books-[version].jar
```

This will give you more detailed information about the runtime environment and any errors that occur.

