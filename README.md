# employee-performance-api
Spring Boot Full Stack Assignment - Employee Performance Management

# 🧑‍💼 Employee Performance Management System

A Spring Boot-based REST API for managing employee data, department details, project assignments, and performance reviews.

---
Assignment Requirements

This project fulfills the following requirements:

- Get a list of employees with filters:
  - Performance score for a given review date
  - Department (supports multi-select + contains filter)
  - Projects (supports multi-select + contains filter)
- Get detailed employee information by ID:
  - Department, Projects (with role and assigned date)
  - Last 3 performance reviews (ordered by date)

---
Tech Stack

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 (in-memory database)
- Maven
- Lombok
