# Spring Boot PostgreSQL REST API

A hands-on Spring Boot project that demonstrates building a real-world
backend application with Java, Spring Boot, Spring Data JPA, PostgreSQL,
and Docker. This project is inspired by the Amigoscode Spring Boot crash
course.

------------------------------------------------------------------------

## ;) Features

-   Build REST APIs using **Spring Boot** and **Spring MVC**
-   Connect Spring Boot to **PostgreSQL** using **Docker**
-   CRUD operations with **Spring Data JPA**
-   Containerized PostgreSQL setup using **Docker Compose**
-   Clean, testable, and scalable backend architecture
-   Proper controller, service, and repository layers

------------------------------------------------------------------------

##  Tech Stack

-   Java 21
-   Spring Boot
-   Spring MVC
-   Spring Data JPA
-   PostgreSQL
-   Docker & Docker Compose
-   Maven
-   IntelliJ IDEA Ultimate Edition

------------------------------------------------------------------------
##  Project Structure
``` 
spring-boot/
│
├─ .idea/ # IntelliJ project settings (ignored in Git)
├─ .mvn/ # Maven wrapper files
│
├─ src/
│ ├─ main/
│ │ ├─ java/
│ │ │ └─ com/sandycode/
│ │ │ ├─ Application.java # Spring Boot main class
│ │ │ ├─ SoftwareEngineer.java # Entity/model
│ │ │ ├─ SoftwareEngineerController.java # REST controller
│ │ │ ├─ SoftwareEngineerRepository.java # JPA repository
│ │ │ ├─ SoftwareEngineerService.java # Service layer
│ │ │ ├─ GlobalExceptionHandler.java
│ │ │ └─ SoftwareEngineerNotFoundException.java
│ │ └─ resources/
│ │ ├─ static/ # Static assets (empty)
│ │ ├─ templates/ # Template files (empty)
│ │ └─ application.properties # DB + Spring configuration
│ │
│ └─ test/
│ └─ java/
│ └─ com/sandycode/
│ └─ ApplicationTests.java # Test class
│
├─ target/ # Generated compiled files (ignored in Git)
│
├─ .gitattributes
├─ .gitignore # Git ignore rules
├─ docker-compose.yml # PostgreSQL container setup
├─ HELP.md
├─ mvnw # Maven wrapper
├─ mvnw.cmd # Maven wrapper (Windows)
├─ pom.xml # Maven dependencies and build config
└─ request.http # IntelliJ REST client API tests
``` 
------------------------------------------------------------------------

## ⚽ Getting Started

### **Prerequisites**

Make sure you have the following installed:

-   JDK 21
-   Maven
-   Docker & Docker Compose
-   IntelliJ IDEA (I recommend u)

------------------------------------------------------------------------

## ▶️ How to Run This Project

### **Step 1: Clone the repository**

``` bash
git clone https://github.com/SanthoshKumar8624/SpringBoot-RestApi-PostgreSQL.git
cd spring-boot-postgres-api
```

### **Step 2: Start PostgreSQL using Docker**

``` bash
docker-compose up -d
```

### **Step 3: Run the Spring Boot application**

``` bash
mvn clean install
mvn spring-boot:run
```

### *The application will start on:*
``` 
    http://localhost:8080
``` 
------------------------------------------------------------------------

## 🧩 API Endpoints
``` 
  ---------------------------------------------------------------------------
  Method   Endpoint                          Description
  -------- --------------------------------- --------------------------------
  GET      /api/v1/software-engineers        Get all software engineers

  GET      /api/v1/software-engineers/{id}   Get software engineer by ID

  POST     /api/v1/software-engineers        Add new engineer

  PUT      /api/v1/software-engineers/{id}   Update engineer by ID

  DELETE   /api/v1/software-engineers/{id}   Delete engineer by ID
  ---------------------------------------------------------------------------
```
## Request Flow Diagram
```
CLIENT (Browser / Postman)
        |
        |  HTTP Request
        |  (GET / POST / PUT / DELETE)
        v
SoftwareEngineerController
        |
        |  calls service method
        v
SoftwareEngineerService
        |
        |  calls repository method
        v
SoftwareEngineerRepository ----(while ID-not-found)- - > Optional.empty()
        |                                                       |   
    (only if ID is found)                                       |
                                                                v 
        |  JPA API                               SoftwareEngineerNotFoundException
        v                                                       |                                    
Hibernate (JPA Implementation)                                  v   
        |                                              GlobalExceptionHandler
        |  SQL Query                                            |
        v                                                       v
PostgreSQL Database                                   404 NOT FOUND + message
        |
        |  ResultSet (rows)
        v
    Hibernate
        |
        |  Maps rows -> Java Objects
        v
SoftwareEngineerRepository
        |
        v
SoftwareEngineerService
        |
        v
SoftwareEngineerController
        |
        |  JSON Response
        v
      CLIENT
```
------------------------------------------------------------------------

## 📝 Notes

-   Database tables are auto-generated using **Hibernate & JPA**.
-   Use **Postman** or IntelliJ REST Client(I used this ) to test APIs.
-   Ensure Docker is running before starting the app.

------------------------------------------------------------------------

## 📚 References

-   Amigoscode Spring Boot Course(https://youtu.be/Cw0J6jYJtzw?si=KeN3SdxuJ88zi9vw)
-   Spring Boot Official Docs
-   Docker Docs

------------------------------------------------------------------------
