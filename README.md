Authentication & Authorization API
Spring Boot • JWT • Spring Security • AWS EC2
Project Overview
This project is a production-ready Authentication and Authorization service built using Spring Boot. It
implements JWT-based stateless authentication, refresh token flow, role-based access control, and
secure logout. The application is deployed on AWS EC2 and documented using Swagger (OpenAPI 3.0).
Key Features
- JWT Authentication (Access & Refresh Tokens)
- Role-Based Authorization (USER / ADMIN)
- Secure Logout & Token Invalidation
- Spring Security Filter Chain
- Swagger UI with JWT Authorization
- Cloud Deployment on AWS EC2
Tech Stack
Java 17, Spring Boot, Spring Security, JWT, Spring Data JPA, H2 Database, Swagger (OpenAPI 3),
Maven, AWS EC2
Authentication Flow
Client → Login API → Access Token & Refresh Token → Access protected APIs using JWT → Refresh
token when expired
API Highlights
POST /auth/login – Authenticate user and generate tokens
POST /auth/refresh – Generate new access token
POST /auth/logout – Secure logout
GET /user/profile – Protected user endpoint
GET /admin/dashboard – Admin-only endpoint
Swagger Documentation
Swagger UI provides interactive API testing and JWT authorization support. Users can authenticate once
and access all protected endpoints directly from Swagger.
Deployment
The application is packaged as an executable JAR and deployed on AWS EC2. It runs as a background
service using nohup and is accessible via the EC2 public IP.
Project Structure
config – OpenAPI & configuration
controller – REST APIs
service – Business logic
repository – Database access
security – JWT & Spring Security
entity – JPA entities
Learning Outcomes
This project demonstrates real-world backend engineering skills including secure API design, JWT
authentication, Spring Security internals, Swagger documentation, and AWS deployment.
Author
Vikas Indla
Backend Developer – Java & Spring Boot
