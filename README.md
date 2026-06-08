# Autotrade API

A RESTful backend for a car marketplace platform. Users can browse and post car listings, send purchase inquiries, and save favorites. Built with Spring Boot and secured with JWT authentication.

## Tech Stack

- **Java 21**
- **Spring Boot 3.5**
- **Spring Security** — JWT-based authentication
- **Spring Data JPA** — database access layer
- **MySQL** — relational database
- **Flyway** — automated database migrations
- **Lombok** — boilerplate reduction
- **Springdoc OpenAPI** — auto-generated API documentation

## Features

- User registration and login with JWT tokens
- Full CRUD for car listings with pagination
- Car specification details (fuel type, transmission, engine, etc.)
- Purchase inquiry system with status tracking
- Favorites — users can save and manage preferred listings
- Role-based access: `USER` and `ADMIN`
- Centralized error handling with meaningful responses
- Interactive API docs via Swagger UI

## Getting Started

### Prerequisites

- Java 21+
- MySQL 8+
- Maven

### 1. Clone the repository

```bash
git clone https://github.com/sofa-kirin/autotrade.git
cd autotrade
```

### 2. Create the database

```sql
CREATE DATABASE autotrade_db;
```

### 3. Configure environment

Open `src/main/resources/application.yaml` and update your database credentials:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/autotrade_db
    username: your_username
    password: your_password

app:
  jwt:
    secret: your-secret-key-minimum-256-bits
    expiration-ms: 86400000
```

### 4. Run the application

```bash
./mvnw spring-boot:run
```

The server starts at `http://localhost:8080`.
Flyway automatically runs all database migrations on startup — no manual setup needed.

---

## API Documentation

Once the app is running, open Swagger UI:

```
http://localhost:8080/swagger-ui/index.html
```

---

## API Overview

### Authentication
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/auth/register` | Register a new user | Public |
| POST | `/api/auth/login` | Login and receive JWT token | Public |

### Car Listings
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/api/listings` | Get all listings (paginated) | Public |
| GET | `/api/listings/{id}` | Get listing details | Public |
| POST | `/api/listings` | Create a new listing | Required |
| PUT | `/api/listings/{id}` | Update a listing | Required |
| PATCH | `/api/listings/{id}/status` | Update listing status | Required |
| DELETE | `/api/listings/{id}` | Delete a listing | Required |

### Inquiries
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| POST | `/api/listings/{id}/inquiries` | Send an inquiry on a listing | Public |
| GET | `/api/inquiries` | Get all inquiries (paginated) | Required |
| PATCH | `/api/inquiries/{id}/status` | Update inquiry status | Required |

### Favorites
| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| GET | `/api/favorites` | Get current user's favorites | Required |
| POST | `/api/favorites/{listingId}` | Add listing to favorites | Required |
| DELETE | `/api/favorites/{listingId}` | Remove listing from favorites | Required |

---

## Authentication

This API uses **Bearer token** authentication. After login, include the token in every protected request:

```
Authorization: Bearer <your_token>
```

Tokens are valid for **24 hours**.

---

## Database Schema

The schema is managed by Flyway migrations located in `src/main/resources/db/migration/`:

| Migration | Description |
|-----------|-------------|
| V1 | Create users table |
| V2 | Create car_listings table |
| V3 | Create car_images table |
| V4 | Create car_specification_details table |
| V5 | Create inquiries table |
| V6 | Create favorites table |

---

## Project Structure

```
src/main/java/com/autotrade/
├── controller/       # REST controllers
├── service/          # Business logic
├── repository/       # Database access (Spring Data JPA)
├── model/            # JPA entities
├── dto/
│   ├── request/      # Incoming request bodies
│   └── response/     # Outgoing response bodies
├── mapper/           # Entity ↔ DTO conversion
├── security/         # JWT filter, config, UserDetailsService
└── exception/        # Global error handling
```

---

## Purpose

This project is built as a portfolio application to demonstrate practical skills in Java backend development, REST API design, relational data modeling, and scalable application architecture.
