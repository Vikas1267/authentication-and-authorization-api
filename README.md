# 🔐 Authentication & Authorization API (Spring Boot)

A production-ready **Authentication & Authorization backend service** built using **Spring Boot, Spring Security, JWT**, and **H2/PostgreSQL**, deployed on **AWS EC2**.

This service provides secure login, token-based authentication, role-based access control, and protected APIs — designed to be used as a standalone auth microservice or integrated into larger systems.

---

## 🚀 Live Deployment

- 🌐 **Base URL**: http://13.60.20.109:8080  
- 📘 **Swagger UI**: http://13.60.20.109:8080/swagger-ui/index.html  
- ❤️ **Health Check**: http://13.60.20.109:8080/health  

> ⚠️ Note: Hosted on AWS EC2 (t3.micro). Cold start may take a few seconds.

---

## 🧩 Features

- User authentication using **JWT (Access + Refresh Tokens)**
- Secure login and logout flow
- Token refresh mechanism
- Role-based authorization
- Protected APIs using Spring Security filters
- Centralized exception handling
- Swagger/OpenAPI documentation
- Health check endpoint
- Deployed and managed on AWS EC2 using systemd

---

## 🛠 Tech Stack

- **Backend**: Java 17, Spring Boot
- **Security**: Spring Security, JWT
- **Database**: H2 (in-memory) / PostgreSQL-ready
- **Build Tool**: Maven
- **API Docs**: Swagger (OpenAPI 3)
- **Deployment**: AWS EC2 (Linux), systemd
- **Server**: Embedded Tomcat

---

## 🔑 API Endpoints Overview

### Authentication
| Method | Endpoint        | Description |
|------|----------------|------------|
| POST | `/auth/login`   | Authenticate user & generate tokens |
| POST | `/auth/refresh` | Refresh access token |
| POST | `/auth/logout`  | Invalidate refresh token |

### Protected APIs
| Method | Endpoint        | Description |
|------|----------------|------------|
| GET  | `/user/profile` | Fetch authenticated user profile |

### Utility
| Method | Endpoint |
|------|----------|
| GET  | `/health` |

---

## 🔒 Authentication Flow

1. User logs in via `/auth/login`
2. Server returns **JWT Access Token + Refresh Token**
3. Client sends `Authorization: Bearer <access_token>` for protected APIs
4. Access token expiry handled via `/auth/refresh`

---

## 🧪 Running Locally

```bash
git clone https://github.com/your-username/authservice.git
cd authservice
mvn clean package
java -jar target/authservice-0.0.1-SNAPSHOT.jar
Access Swagger:

bash
Copy code
http://localhost:8080/swagger-ui/index.html
☁️ Deployment Details
Hosted on AWS EC2 (Amazon Linux 2023)

Application managed via systemd

JVM memory optimized for low-resource instance

Swap configured for stability on t3.micro

📌 Future Improvements
User registration endpoint

Persistent database (PostgreSQL/RDS)

Redis-based token blacklist

Rate limiting

Docker & CI/CD pipeline

HTTPS with Nginx + SSL

👤 Author
Vikas Indla
Backend Developer | Spring Boot | REST APIs | AWS
