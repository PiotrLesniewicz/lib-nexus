# Lib-Nexus

**Lib-Nexus** is a modern, high-performance Library Management System designed for municipal libraries. Built with a focus on clean architecture, data integrity, and scalability, it provides a robust backend for managing users, book collections, loans, and reservations.

## 🚀 Key Features

- **Advanced User Management:** Integrated role-based access control (RBAC) for Users, Librarians, and Administrators.
- **Smart Address System:** Optimized shared address management to eliminate data redundancy.
- **Security First:** Secure password hashing (BCrypt), account status management (isActive), and data anonymization protocols.
- **Automated Schema Evolution:** Database migrations handled by Flyway.
- **Comprehensive Testing:** High test coverage with Integration Tests using Testcontainers (PostgreSQL).

## 🛠 Tech Stack

* **Language:** Java 21
* **Framework:** Spring Boot 3.x (Data JPA, Security, Validation)
* **Database:** PostgreSQL
* **Migration:** Flyway
* **Testing:** JUnit 5, AssertJ, Mockito, Testcontainers
* **Mapping:** MapStruct & Lombok
* **Containerization:** Docker

## 🏗 Architecture

The project follows a **Clean 3-Layer Architecture** to ensure separation of concerns and maintainability:

1.  **Infrastructure Layer:** Database entities, repositories, and external configurations.
2.  **Domain Layer:** Core business logic, domain models (Immutability-focused), and services.
3.  **Application/API Layer:** (Work in progress) REST Controllers and DTO mapping.

## 📈 Roadmap
- [x] Core User & Address Module
- [ ] Book & Inventory Management (BookInstances)
- [ ] Loan & Reservation Logic
- [ ] Opinion & Review System
- [ ] Advanced Reporting Dashboard