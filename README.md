# Developper REST CRUD with Spring Boot, Spring Data, HikariCP, 

A simple single table CRUD example with [Spring Data JPA](http://projects.spring.io/spring-data-jpa/) and [HikariCP](https://brettwooldridge.github.io/HikariCP/). Uses [Spring Boot](http://projects.spring.io/spring-boot/) for easy project setup and development. Helps you to get started with basic JPA backed applications.

## How to play with this application

### Suggested method

* Clone the project
* Import to your favorite IDE
* Execute the main method from Application class

### Just execute it with maven

```
git clone https://github.com/anosi22/developpersTestRest.git
cd developpersTestRest 
mvn spring-boot:run  -Dspring.profiles.active=local
```

### Just create the package and run it

The built .jar file is auto-runnable, so as you can move it to any computer having java installed and run the app. 

```
git clone https://github.com/anosi22/developpersTestRest.git
cd developpersTestRest
mvn package
java -jar target/developpers-0.0.1-SNAPSHOT.jar --spring.profiles.active=local
```

### Just deploy it

The built jar file is really simple to deploy in modern PaaS services. E.g. if you have existing Bluemix account and are already logged in with your cf (CLI) tools just execute following:

```
git clone https://github.com/anosi22/developpersTestRest.git
cd developpersTestRest
mvn install
cf push choose-namefor-your-server-here -p target/*.jar -b https://github.com/cloudfoundry/java-buildpack.git

```
### To test rest ws
```
GET: http://localhost:8080/developpers/version
GET: http://localhost:8080/developpers/developper/1
PUT: http://localhost:8080/developpers/developper/1
DELETE: http://localhost:8080/developpers/developper/1
POST: http://localhost:8080/developpers/developper
DELETE: http://localhost:8080/developpers/developper
```