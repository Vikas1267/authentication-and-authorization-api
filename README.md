🔐 Authentication & Authorization API

A production-ready Spring Boot authentication and authorization service implementing JWT-based security, refresh tokens, role-based access control, and secure logout handling.
Built step-by-step with a strong focus on security, clean architecture, and real-world backend practices.

🚀 Features

✅ JWT Access Tokens

✅ Refresh Token flow (DB-backed, one per user)

✅ Role-based authorization (ADMIN / USER)

✅ Secure Logout (refresh token invalidation)

✅ Spring Security custom filter chain

✅ Stateless authentication

✅ Global exception handling

✅ Initial data seeding

✅ Hardened security configuration


🛠️ Tech Stack

Java 17

Spring Boot

Spring Security

JWT (io.jsonwebtoken)

Spring Data JPA / Hibernate

H2 In-Memory Database

Maven


🏗️ Architecture Overview
Controller → Service → Repository → Database
        ↓
   Spring Security Filter (JWT)
JwtAuthenticationFilter validates access tokens
RefreshTokenService manages refresh tokens lifecycle
SecurityConfig enforces stateless security
Role-based access control via authorities

📌 API Endpoints
🔑 Login

POST /auth/login
Body(Json):
{
  "username": "admin",
  "password": "admin"
}


Response
{
  "accessToken": "jwt-access-token",
  "refreshToken": "refresh-token"
}

🔄 Refresh Token

POST /auth/refresh
{
  "refreshToken": "refresh-token"
}


Response
{
  "accessToken": "new-jwt-access-token",
  "refreshToken": "same-refresh-token"
}

🚪 Logout

POST /auth/logout?username=admin
Requires Authorization: Bearer <access-token>
Invalidates the user’s refresh token

Response
Logged out successfully

🔐 Security Highlights

Stateless session management
JWT validation on every request
Refresh tokens stored securely in DB
One refresh token per user
Token expiry validation
Proper HTTP status handling (401 / 403)
No sensitive data exposed

🧪 Testing the API

You can test all endpoints using Postman.
📸 Screenshots included below show:

Successful login

Token refresh
Logout flow
403 handling during invalid access

## 📷 Screenshots

![Refresh Token](screenshots/refresh.png)
<img width="893" height="829" alt="Screenshot 2026-01-12 090002" src="https://github.com/user-attachments/assets/907e17c8-6e72-41d9-b3e9-468d06d20efc" />

![Logout](screenshots/logout.png)
<img width="907" height="843" alt="Screenshot 2026-01-12 204058" src="https://github.com/user-attachments/assets/73bc0a9f-409d-47da-94e8-fd8bf4c0cd9f" />


▶️ How to Run Locally

./mvnw spring-boot:run
App runs on http://localhost:8080
H2 console enabled for local testing
No external setup required

📂 Project Structure
src/main/java/com/vikas/authservice
├── controller
├── service
├── repository
├── security
├── entity
├── dto
├── exception
└── config

🧠 Learning Outcomes

This project demonstrates:
Real-world Spring Security configuration
Proper JWT + refresh token design
Backend security hardening
Clean layered architecture
Debugging and fixing 403 / authentication issues

📌 Future Improvements

Token blacklist for access tokens
Redis-backed refresh tokens
Docker & Docker Compose
Swagger / OpenAPI documentation
Integration with microservices

👨‍💻 Author

Omvikas
Backend Engineer | Java | Spring Boot | Security
