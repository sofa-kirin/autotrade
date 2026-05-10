CREATE TABLE car_images (
                            id         BIGINT AUTO_INCREMENT PRIMARY KEY,
                            listing_id BIGINT NOT NULL,
                            url        VARCHAR(500) NOT NULL,
                            is_main    BOOLEAN NOT NULL DEFAULT FALSE,
                            created_at DATETIME,
                            CONSTRAINT fk_images_listing FOREIGN KEY (listing_id)
                                REFERENCES car_listings(id) ON DELETE CASCADE
);