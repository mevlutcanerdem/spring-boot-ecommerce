# 🛒 Trendyol Clone - E-Commerce Backend API

This project is a scalable RESTful API that simulates the backend architecture of modern e-commerce platforms. Built with **Spring Boot 3** and **Java 21**, it features enterprise-standard **JWT (JSON Web Token)** based authentication and **Spring Security** integration.

## 🚀 Technologies Used

* **Language:** Java 21
* **Framework:** Spring Boot 3.x
* **Security:** Spring Security & JWT (io.jsonwebtoken 0.11.5)
* **Database:** MySQL 8.0 & Spring Data JPA (Hibernate)
* **Data Transfer:** DTO Pattern & ModelMapper
* **Build Tool:** Maven

## ✨ Current Features (V1.0 - Security & Authentication)

* **Stateless Architecture:** No session data is stored on the server; communication is entirely token-based.
* **User Registration & Encryption:** User passwords are encrypted using a one-way hash via **BCryptPasswordEncoder** before being saved to the database.
* **JWT Generation & Validation:** Upon successful login, users receive an encrypted digital signature (Token) with a specific expiration time.
* **Custom Security Filter:** A custom `JwtAuthenticationFilter` intercepts every HTTP request, instantly blocking unauthorized access (HTTP 401/403).

## 🛠️ Setup and Installation

Follow these steps to run the project on your local machine:

### 1. Prerequisites
* JDK 21
* MySQL 8.0 or higher
* Maven

### 2. Database Preparation
Create the project schema in your MySQL database (using Workbench or terminal):
```sql
CREATE DATABASE trendyol_clone_db;
