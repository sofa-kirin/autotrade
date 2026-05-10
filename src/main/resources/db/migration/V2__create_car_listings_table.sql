CREATE TABLE car_listings (
        id          BIGINT AUTO_INCREMENT PRIMARY KEY,
        title       VARCHAR(255) NOT NULL,
        description TEXT NOT NULL,
        price       DECIMAL(12, 2) NOT NULL,
        year        INT NOT NULL,
        mileage     INT NOT NULL,
        brand       VARCHAR(100) NOT NULL,
        model       VARCHAR(100) NOT NULL,
        city        VARCHAR(100) NOT NULL,
        status      ENUM('ACTIVE', 'SOLD', 'ARCHIVED') NOT NULL DEFAULT 'ACTIVE',
        created_at  DATETIME
);