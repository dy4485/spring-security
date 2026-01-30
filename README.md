# 📘 Spring Security 6 with Spring Boot and JWT

This project is based on a Spring Security course where I learned how to secure REST APIs using **Spring Boot**, **Spring Security 6**, and **JWT (JSON Web Tokens)**.  
It demonstrates modern authentication and authorization practices used in real-world backend applications.

---

## 🧠 What I Learned from This Course

### 🔐 Spring Security Fundamentals
- Understanding what Spring Security is and how it works internally.
- How authentication and authorization are handled using security filters.
- Configuring security rules for public and protected endpoints.

---

### 🛠️ Spring Boot + Security Configuration
- Setting up a Spring Boot project with Spring Security dependencies.
- Creating a custom security configuration using `SecurityFilterChain`.
- Disabling CSRF for REST APIs.
- Enabling stateless security.

---

### 🔑 JWT (JSON Web Token) Authentication
- What JWT is and why it is used for stateless authentication.
- Generating JWT tokens after successful login.
- Validating JWT tokens for every secured request.
- Passing JWT tokens using the `Authorization: Bearer <token>` header.

Example:


---

### 🔒 Password Security
- Encoding passwords securely using `BCryptPasswordEncoder`.
- Preventing plain-text password storage in the database.

---

### 👤 User Authentication Flow
1. User sends login credentials (username & password).
2. Server validates credentials.
3. Server generates a JWT token.
4. Client uses the JWT token to access protected APIs.

---

### 🧪 Practical Skills Gained
- Building secure REST APIs using Spring Security.
- Implementing login and protected routes.
- Handling authentication errors and unauthorized access.
- Following backend security best practices.

---

## ⚙️ Tech Stack Used
- Java  
- Spring Boot  
- Spring Security 6  
- JWT (JSON Web Token)  
- Maven  
- REST APIs  

---

## 🚀 How to Set Up and Run This Project

### ✅ Prerequisites
Make sure you have the following installed:
- Java 17+
- Maven
- Git
- IDE: Eclipse

---

### 📥 Clone the Repository
git clone https://github.com/dy4485/spring-security.git
cd spring-security


---

### ⚙️ Configure Application
Update `application.properties` if required.

Example:
server.port=9090

---

### ▶️ Run the Application

#### Option 1: Using Maven
mvn spring-boot:run

#### Option 2: From IDE
- Open the project in your IDE.
- Run the main Spring Boot application class.

---

### 🔍 Access the Application
The application runs on:
http://localhost:9090


You can test APIs using **Postman** .

---

## 👤 Author
**Dilip Yadav**
