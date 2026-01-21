🔐 Authentication & Authorization API
Secure JWT-based Auth Service | Spring Boot | AWS EC2

A production-ready Authentication & Authorization REST API built using Spring Boot and Spring Security, implementing JWT-based authentication, role-based authorization, and secure API access.
The service is fully deployed on AWS EC2 and documented using Swagger (OpenAPI 3).

This project demonstrates real-world backend engineering practices, not just local development.

🚀 Live Deployment

Base URL:

http://<EC2_PUBLIC_IP>:8080


Swagger UI:

http://<EC2_PUBLIC_IP>:8080/swagger-ui/index.html


Health Check:

GET /health

🧠 What This Project Solves

Secure user authentication using JWT

Role-based authorization (USER, ADMIN)

Stateless session management

Token refresh mechanism

Centralized API documentation

Cloud deployment (AWS EC2)

This API can be plugged directly into:

Frontend applications (React / Angular / Mobile apps)

Microservices architectures

E-commerce / SaaS platforms

🏗️ Architecture Overview
Client
  ↓
Auth Controller (/auth/login)
  ↓
JWT Generation
  ↓
Spring Security Filter Chain
  ↓
Protected APIs (/user/**, /admin/**)


Stateless authentication

JWT validated on every request

No server-side session storage

🔑 Authentication Flow (JWT)

User logs in with credentials

Server returns:

accessToken

refreshToken

Client sends token as:

Authorization: Bearer <access_token>


Spring Security validates JWT for protected routes

📌 API Endpoints
🔐 Authentication
Method	Endpoint	Description
POST	/auth/login	Authenticate user & get JWT
POST	/auth/refresh	Refresh access token
POST	/auth/logout	Logout user
👤 User
Method	Endpoint	Access
GET	/user/profile	Authenticated users
🛡️ Admin
Method	Endpoint	Access
GET	/admin/dashboard	ADMIN role only
❤️ Health
Method	Endpoint
GET	/health
🧪 Testing with Swagger UI

Open Swagger UI

Call /auth/login

Copy the accessToken

Click Authorize 🔓

Paste:

Bearer <accessToken>


Access protected APIs

🛠️ Tech Stack

Java 17

Spring Boot 3

Spring Security

JWT (JSON Web Tokens)

Spring Data JPA

H2 Database (can be replaced with PostgreSQL/MySQL)

Swagger / OpenAPI 3

Maven

AWS EC2

Linux (Amazon Linux 2023)

📂 Project Structure
src/main/java/com/vikas/authservice
├── config        # OpenAPI & app configs
├── controller    # REST controllers
├── security      # JWT & Spring Security
├── service       # Business logic
├── repository    # Data access layer
├── entity        # JPA entities
├── dto           # Request/Response models
└── exception     # Global exception handling

▶️ Run Locally
git clone https://github.com/Vikas1267/authentication-and-authorization-api.git
cd authentication-and-authorization-api
mvn clean package
java -jar target/authservice-0.0.1-SNAPSHOT.jar


App runs at:

http://localhost:8080

☁️ Deployment Details

Hosted on AWS EC2

Runs as a standalone JAR

Managed using nohup

Open ports configured via EC2 Security Groups

Designed for easy extension with:

Nginx

HTTPS (SSL)

Docker

RDS (PostgreSQL/MySQL)

🎯 Key Learnings & Highlights

Implemented JWT authentication from scratch

Deep understanding of Spring Security filter chain

Debugged real production issues:

Port conflicts

Authorization failures

Token validation

Hands-on AWS EC2 deployment

Swagger secured with Bearer Authentication

👨‍💻 Author

Vikas Indla
Backend Engineer | Java | Spring Boot
