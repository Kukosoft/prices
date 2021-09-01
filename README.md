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
	> mvn spring-boot:build-image
	> docker run -it -p8080:8080 prices:1.0
```

or manually

```
	> docker build --tag=prices:1.0 .
	> docker run -itd -p 8080:8080 prices:1.0
```

### How can I test it?

Automatic tests

```
	> mvn clean compile test
```

After running the microservice, open the Swagger API reference to do manual testing

http://{HOST}:{PORT}/swagger-ui/index.html

### Jacoco code coverage report

file://&lt;PATH&gt;/prices/target/site/jacoco/index.html

### H2 URL access

http://localhost:8080/h2-console