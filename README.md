# Issue Tracker App build with Spring Boot

[![Actions](https://github.com/lirent/issue-tracker-ms-spring-boot-rest-jpa/workflows/Java%20CI%20with%20Maven/badge.svg)](https://github.com/lirent/issue-tracker-ms-spring-boot-rest-jpa/actions)

The Issue Tracker App is a backend application built using Spring Boot,
designed to streamline issue tracking and project management.

## Requirements

For building and running the application you need:

- [JDK 174](http://www.oracle.com/technetwork/java/javase/downloads/jdk17-downloads-2133151.html)
- [Maven 4](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `net.lirent.ms.Application` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

##Explore Rest APIs
The app defines following REST APIs.
```
GET /v1/issues/    - Get all issues from DB

POST /v1/issues/   - Post a new issue

GET /v1/issues/{id}  - Find issue from a given id

PUT /v1/issues/{id}  - Update issue from a given id

DELETE /v1/issues/{id} - Delete a issue from DB
```
You can test them using any rest client.

##Test applications APIs
To get all the issues, must make a GET request to the following exposed API:
```
curl -X GET --header 'Accept: application/json' 'http://localhost:8080/v1/issues'
```
To add a new Issue, must make a POST request with a ISSUE json in body as follows:
```
curl -X POST --header 'Content-Type: application/json' --header 'Accept: application/json' -d '{"title":"Demo Issue","description":"Demo description","reporter":"Demo User","type":"TASK","priority":"LOW","status":"OPEN"}' 'http://localhost:8080/v1/issues'
```

To delete an issue (example with ID:1), must make e DELETE request to the following API:
```
curl -X DELETE --header 'Accept: application/json' 'http://localhost:8080/v1/issues/1'
```

## Copyright

Released under the Apache License 2.0. See the [LICENSE](https://github.com/lirent/issue-tracker-ms-spring-boot-rest-jpa/master/LICENSE) file.
