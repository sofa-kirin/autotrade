CREATE TABLE inquiries (
                           id         BIGINT AUTO_INCREMENT PRIMARY KEY,
                           listing_id BIGINT NOT NULL,
                           user_id    BIGINT,
                           name       VARCHAR(100) NOT NULL,
                           email      VARCHAR(255) NOT NULL,
                           phone      VARCHAR(20) NOT NULL,
                           message    TEXT,
                           status     ENUM('NEW','VIEWED','CLOSED') NOT NULL DEFAULT 'NEW',
                           created_at DATETIME,
                           CONSTRAINT fk_inquiry_listing FOREIGN KEY (listing_id)
                               REFERENCES car_listings(id) ON DELETE CASCADE,
                           CONSTRAINT fk_inquiry_user FOREIGN KEY (user_id)
                               REFERENCES users(id) ON DELETE SET NULL
);