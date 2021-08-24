# eCommerce prices management 

This is an example about how to build an application with Hexagonal Architecture in a Spring Data Application.

This application uses a H2 Data Base, wich is a database in memory.

### How to run it?

```
	> mvn spring-boot:run
```

Directly from jar

```
	> java -jar prices-1.0.jar
```

As Docker container having Docker already installed and up

```
	> spring-boot:build-image
	> docker run -it -p8080:8080 prices:1.0
```

or manually

```
	> docker build --tag=prices:1.0 .
	> docker run -it -p8080:8080 prices:1.0
```

### How can I test it?

Automatic tests

```
	> mvn clean compile test
```

Also here is a request example with the prices endpoint to do manual testing

[API guide](https://kukosoft.github.io/prices/api-guide.html)