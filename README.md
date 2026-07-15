# Employee Management System

A RESTful Employee Management System built using **Spring Boot**, **Spring Security**, **JWT Authentication**, **Spring Data JPA**, and **MySQL**. The application provides secure employee management operations with role-based authentication and follows a layered architecture.

---

## Features

- Secure Login using JWT Authentication
- Employee CRUD Operations
- Role-based Authorization
- Input Validation
- RESTful APIs
- Exception Handling
- MySQL Database Integration
- Layered Architecture (Controller → Service → Repository)
- Maven Project
- Postman Tested APIs

---

## Tech Stack

### Backend
- Java 17
- Spring Boot
- Spring Security
- Spring Data JPA (Hibernate)
- JWT
- Maven

### Database
- MySQL

### Tools
- IntelliJ IDEA
- Postman
- Git
- GitHub

---

## Project Structure

```
src
├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
├── exception
├── util
└── resources
```

---

## API Endpoints

### Authentication

| Method | Endpoint |
|---------|----------|
| POST | /auth/login |
| POST | /auth/register |

### Employee

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | /employees | Get All Employees |
| GET | /employees/{id} | Get Employee By ID |
| POST | /employees | Add Employee |
| PUT | /employees/{id} | Update Employee |
| DELETE | /employees/{id} | Delete Employee |

---

## Pagination

```
GET /employees?page=0&size=10&sortBy=name
```

---

## Database

Configure your database in **application.properties**

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employeedb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## Installation

Clone the repository

```bash
git clone https://github.com/aditya1203/employee-management-system.git
```

Move inside the project

```bash
cd employee-management-system
```

Install dependencies

```bash
mvn clean install
```

Run the application

```bash
mvn spring-boot:run
```

---

## Security

- JWT Authentication
- Password Encryption using BCrypt
- Stateless Session Management
- Protected APIs using Spring Security

---

## Testing

The APIs were tested using **Postman**.

Example Login Request

```json
{
    "username":"admin",
    "password":"admin123"
}
```

The generated JWT token must be added in the Authorization header.

```
Authorization: Bearer <JWT_TOKEN>
```

---

## Future Enhancements

- Swagger/OpenAPI Documentation
- Docker Support
- Unit Testing with JUnit & Mockito
- File Upload for Employee Profile Images
- Email Notifications
- Role Management
- Audit Logging

---

## Screenshots

You can add screenshots here.

- Login API
- Employee List
- Create Employee
- Update Employee
- Delete Employee

---

## Learning Outcomes

- Spring Boot REST APIs
- Spring Security
- JWT Authentication
- Hibernate & JPA
- Repository Pattern
- Exception Handling
- Pagination & Sorting
- MySQL Integration
- Maven Project Structure
- Git & GitHub Version Control

---

## Author

**Aditya Gupta**

GitHub: https://github.com/aditya1203
