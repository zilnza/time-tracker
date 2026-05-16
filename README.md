# Time Tracker Backend

Backend project for time tracking system using Spring Boot.

## Features

- Full CRUD for time entries
- JWT Authentication
- User registration and login
- Role-based security
- Swagger API documentation
- Excel report export
- File upload
- Logging system
- PostgreSQL database

## Technologies

- Java 17
- Spring Boot
- Spring Security
- JWT
- PostgreSQL
- Hibernate / JPA
- Maven
- Swagger OpenAPI
- Apache POI

## Endpoints

### Authentication

- POST /auth/register
- POST /auth/login

### Time Entries

- GET /entries
- POST /entries
- PUT /entries/{id}
- DELETE /entries/{id}

### Reports

- GET /reports/export

### Files

- POST /files/upload

## запуск проекта

1. Создать PostgreSQL database
2. Указать username/password в application.properties
3. Выполнить:
mvn clean install

4. Запустить:
mvn spring-boot:run

5. Swagger:

http://localhost:8080/swagger-ui/index.html
