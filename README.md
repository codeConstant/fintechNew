# 🏦 Employee Onboarding API – Fintech Company

This backend API is built using **Spring Boot** to streamline employee onboarding for a fintech organization. It supports 
user registration and authentication. employee creation, update, status update, fetchOne, fetchAll,assignRole, updateStatus, assignTask

---

## 📌 Features

- Employee registration and profile management
-  onboarding lifecycle tracking
- Onboarding task assignment and status
- Secure login with JWT-based authentication
- Role-based access control (admin, hr, employee)
- RESTful API design

---

## 🧱 Tech Stack

- Java 17
- Spring Boot 3+
- Spring Data JPA
- Spring Security + JWT
- Mysql
- Lombok

---


## Endpoints
- POST   /employee/create         → Create a new employee
- PUT    /employee/update         → Update employee info
- GET    /employee/fetchOne/{id} → Get employee by ID
- GET    /employee/fetchAll       → List all employees
- POST    /employee/assignRole     → Assign a role to an employee
- POST    /employee/updateStatus   → Update employee onboarding/KYC status
- POST   /employee/assignTask     → Assign onboarding tasks

- POST   /user/register           → Register system user (for login)
- POST   /user/authenticate       → Authenticate and retrieve JWT
