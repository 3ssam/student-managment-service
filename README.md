# Drone-Task

Minimal [Spring Boot](http://projects.spring.io/spring-boot/) sample app.

## Requirements

For building and running the application you need:

- [JDK 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method
in the `de.codecentric.springbootsample.Application` class from your IDE.

Alternatively you can use
the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html)
like so:

```shell
mvn spring-boot:run
```

## How to Run

This application is packaged as a war which has Tomcat 8 embedded. No Tomcat or JBoss installation is necessary. You run
it using the ```java -jar``` command.

* Clone this repository
* Make sure you are using JDK 17 and Maven 3.x
* You can build the project and run the tests by running ```mvn clean package```
* Once successfully built, you can run the service by one of these two methods:

```
mvn spring-boot:run
```

* Check the stdout or drone-service.log file to make sure no exceptions are thrown

Once the application runs you should see something like this

```
2017-08-29 17:31:23.091  INFO 19387 --- [           main] s.b.c.e.t.TomcatEmbeddedServletContainer : Tomcat started on port(s): 8080 (http)
2017-08-29 17:31:23.097  INFO 19387 --- [           main] com.khoubyari.example.Application        : Started Application in 22.285 seconds (JVM running for 23.032)
```

## About Database

This application used h2 in memory database in dev profile, MySQL in test profile and Oracle database in Production
profile you can change each of them from
`spring.profiles.active` in `application.properties` file When startup application it will create tables and relations
between tables and when close application it will remove all data that stored in application.

* this is [console panel](http://localhost:8080/h2-console/login.jsp) to manage data and check if it inserted
  successfully or not.
* username for console panel is `admin` and password is `password`.
* need also to change `JDBC URL:` with this url `jdbc:h2:mem:studentDB`.
* we can change all previous values from `application.properties` file.

## About The Services

The service is just a simple Drone REST service. It uses an in-memory database (H2) to store the data. You can also do
with a relational database like MySQL or PostgreSQL. If your database connection properties work, you can call some REST
endpoints defined in ```com.essam.student.management.StudentController```
or ```com.essam.student.management.CourseController```on **port 8080**. (see below)

More interestingly, you can start calling some operational endpoints (see full list below) like ```/student```
and ```/course``` (these are available on **port 8080**)

You can use this sample service to understand the conventions and configurations that allow you to create a DB-backed
RESTFUl service. Once you understand and get comfortable with the sample app you can add your own services following the
same patterns as the sample service.

Here is what this little application demonstrates:

* Full integration with the latest **Spring** Framework: inversion of control, dependency injection, etc.
* Packaging as a single war with embedded container (tomcat 8): No need to install a container separately on the host
  just run using the ``java -jar`` command
* Writing a RESTful service using annotation: only JSON request / response; simply use desired ``Accept`` header in your
  request
* Exception mapping from application exceptions to the right HTTP response with exception details in the body by
  using `RestControllerAdvice`
* *Spring Data* Integration with JPA/Hibernate with just a few lines of configuration and familiar annotations.
* Automatic CRUD functionality against the data source using Spring *Repository* pattern
* All APIs are "self-documented" by Swagger2 using annotations and we can check it
  form [Swagger UI](http://localhost:8080/swagger-ui.html)
* All logs in application come by configuration of log4j2 in file `log4j2.xml` in resources.