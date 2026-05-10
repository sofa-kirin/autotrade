CREATE TABLE users (
        id         BIGINT AUTO_INCREMENT PRIMARY KEY,
        email      VARCHAR(255) NOT NULL UNIQUE,
        password   VARCHAR(255) NOT NULL,
        first_name VARCHAR(100) NOT NULL,
        last_name  VARCHAR(100) NOT NULL,
        phone_number VARCHAR(20) NOT NULL,
        role       ENUM('CUSTOMER', 'ADMIN') NOT NULL,
        created_at DATETIME
);