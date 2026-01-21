# 🛡️ Authentication & Authorization API

A **production-ready Spring Boot Authentication and Authorization service**, implementing secure JWT based auth, refresh token flow, role-based access control, and logout handling — deployed on AWS EC2.

🔗 Repo: https://github.com/Vikas1267/authentication-and-authorization-api :contentReference[oaicite:0]{index=0}

---

## 🚀 Project Overview

This API serves as a robust backbone for modern applications requiring:

- 🔑 **JWT Authentication**
- 🔄 **Refresh Tokens**
- 👤 **Role-Based Authorization**
- 🔒 **Secure Logout**
- 📜 **Swagger/OpenAPI Documentation**
- 🧱 Stateless and secure Spring Security setup

Built with **clean layered architecture** and security best practices in mind.

---

## 📌 Features

✨ **Authentication**
- Login with username/password
- Returns `accessToken` & `refreshToken`

🔁 **Refresh Token Flow**
- Issue new access tokens using refresh tokens

🔐 **Authorization**
- Role-based access control (e.g., ADMIN / USER)
- Protected endpoints require token

🚪 **Secure Logout**
- Invalidate refresh tokens
- Stateless session

🛠 **Security Hardened**
- JWT validation on every request
- Spring Security custom filter
- Stateless session

📜 **Documentation**
- Fully documented with Swagger UI

---

## 🧱 Tech Stack

| Layer | Technology |
|-------|------------|
| Language | Java 17 |
| Framework | Spring Boot |
| Security | Spring Security + JWT |
| Persistence | Spring Data JPA + H2 |
| API Docs | Swagger / OpenAPI |
| Build | Maven |

---

## 📌 Architecture

Client
└─> POST /auth/login
↓
JWT Access Token + Refresh Token
↓
Protected APIs <-- Spring Security (JWT Filter)

yaml
Copy code

- Controller → Service → Repository
- JWT Filter → Enforces stateless authentication

---

## 📍 API Endpoints

### 🔐 Authentication

**POST /auth/login**
{
"username": "admin",
"password": "admin"
}

css
Copy code
🟢 Response:
json
{
  "accessToken": "jwt-access-token",
  "refreshToken": "refresh-token"
}
🔄 Token Refresh
POST /auth/refresh

json
Copy code
{
  "refreshToken": "refresh-token"
}
🟢 Response:

json
Copy code
{
  "accessToken": "new-jwt-token",
  "refreshToken": "same-refresh-token"
}
🚪 Logout
POST /auth/logout

makefile
Copy code
Authorization: Bearer <JWT>
🟢 Invalidates the user’s refresh token

👤 Protected APIs
GET /user/profile

Requires valid JWT

GET /admin/dashboard

Requires ADMIN role

🛠 Running Locally
Clone:

bash
Copy code
git clone https://github.com/Vikas1267/authentication-and-authorization-api.git
cd authentication-and-authorization-api
Build:

bash
Copy code
mvn clean package
Run:

bash
Copy code
java -jar target/authservice-0.0.1-SNAPSHOT.jar
🟢 App will run at

arduino
Copy code
http://localhost:8080
📖 Swagger UI
Interactive API docs available at:

bash
Copy code
http://localhost:8080/swagger-ui/index.html
👉 Use the Authorize button to paste your JWT:

php-template
Copy code
Bearer <accessToken>
📌 Deployed Version (AWS EC2)
Deployed at:

cpp
Copy code
http://<YOUR_EC2_PUBLIC_IP>:8080
Swagger:

arduino
Copy code
http://<YOUR_EC2_PUBLIC_IP>:8080/swagger-ui/index.html
🧪 Testing the API
Use any API client (Postman / Swagger) to perform:

Login → get JWT

Authorize in Swagger

Call protected endpoints

💡 Remember to prefix JWT with:

php-template
Copy code
Bearer <token>
📁 Project Structure
bash
Copy code
src/main/java/com/vikas/authservice
├── config            # OpenAPI + security configs
├── controller        # API controllers
├── service           # Business logic
├── repository        # DB access
├── security          # JWT and Spring Security
├── entity            # Models / Entities
└── exception         # Custom global handlers
📈 What You’ll Learn
Real-world Spring Security

Stateless JWT authentication design

Secure refresh token flow

Role based access patterns

OpenAPI documentation and secure endpoints

📦 Future Improvements
✔ Add RDBMS (MySQL / PostgreSQL)
✔ Docker & Docker-Compose setup
✔ HTTPS / Nginx setup
✔ Redis-backed refresh token store
✔ Token blacklist for access tokens

👨‍💻 Author
Omvikas Indla
Backend Developer | Java | Spring Boot | Security
