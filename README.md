# 🔐 Authentication & Authorization API (Spring Boot)

A production-ready **Authentication & Authorization backend service** built using **Spring Boot, Spring Security, JWT**, and **H2/PostgreSQL**, deployed on **AWS EC2**.

This service provides secure login, token-based authentication, role-based access control, and protected APIs — designed to be used as a standalone auth microservice or integrated into larger systems.

---

## 🚀 Live Deployment
  
- 📘 **Swagger UI**: http://51.21.192.193:8080/swagger-ui/index.html  
- ❤️ **Health Check**: http://51.21.192.193:8080/health  
- 📘 **Api docs** : http://51.21.192.193:8080/v3/api-docs

> ⚠️ Note: Hosted on AWS EC2 (t3.micro). Cold start may take a few seconds.

---
## Screenshots : 

[AWS instance]
<img width="1920" height="1080" alt="image" src="https://github.com/user-attachments/assets/057b7306-023f-4d9b-89be-29b554cb6ec7" />

[JWT token]
<img width="977" height="777" alt="Screenshot 2026-01-08 222425" src="https://github.com/user-attachments/assets/c3a6ab53-f11b-437c-9724-58fe78be0ae1" />

[Admin dashboard]
<img width="939" height="691" alt="Screenshot 2026-01-09 222638" src="https://github.com/user-attachments/assets/9429ee31-f4d6-4101-a2be-26f686e209e9" />

[GET Method]
<img width="930" height="819" alt="Screenshot 2026-01-10 223319" src="https://github.com/user-attachments/assets/8657a4e6-a1eb-4ea4-9cea-fe33f7a1a742" />

[Access and Refresh Tokens]
<img width="893" height="829" alt="Screenshot 2026-01-12 090002" src="https://github.com/user-attachments/assets/51ca017e-f84a-4f8a-869b-1de724a77f38" />




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

bash

1.git clone https://github.com/your-username/authservice.git

2.cd authservice

3.mvn clean package

4.java -jar target/authservice-0.0.1-SNAPSHOT.jar


---

🔐 How to Use the API (via Swagger UI)

This API is designed to be tested directly from Swagger UI.

Step 1: Open Swagger UI

Go to:

**Link** : http://51.21.192.193:8080/swagger-ui/index.html

Step 2: Login (Get JWT Token)

* Expand POST /auth/login

* Click Try it out

* Enter request body in JSON format:

{

  "username": "admin",
  
  "password": "admin"
  
  
}


* Click Execute

* Copy the accessToken from the response

Step 3: Authorize (Set Bearer Token)

* Click Authorize (🔒 button at top right)

*Paste the access token in the box:


* Click Authorize

* Close the dialog

✅ You are now authenticated for all protected APIs.

Step 4: Access Protected APIs

* After authorization:

* Open any secured endpoint (🔒 icon)

* Click Try it out

* Click Execute

Example:

GET /user/profile


you'll get 200 or succeed Response

Step 5: Logout (Optional)

To invalidate the session:

* Use POST /auth/logout

* Execute while authenticated

*Token will no longer be valid

* Token Refresh (When Access Token Expires)

* If access token expires:

* Call POST /auth/refresh

* Use refresh token

* Receive a new access token

* Re-authorize in Swagger

🧠 Usage Pattern (General Rule)

Login → Copy Token → Authorize → Call Protected APIs → Logout / Refresh

This same flow applies whether you use:

Swagger UI

Postman

Frontend application

Mobile app

---

Access Swagger:

**http://localhost:8080/swagger-ui/index.html**
---

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

Backend Engineer | Spring Boot | REST APIs | AWS
