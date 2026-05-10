CREATE TABLE favorites (
                           id         BIGINT AUTO_INCREMENT PRIMARY KEY,
                           user_id    BIGINT NOT NULL,
                           listing_id BIGINT NOT NULL,
                           created_at DATETIME,
                           CONSTRAINT fk_fav_user    FOREIGN KEY (user_id)    REFERENCES users(id) ON DELETE CASCADE,
                           CONSTRAINT fk_fav_listing FOREIGN KEY (listing_id) REFERENCES car_listings(id) ON DELETE CASCADE,
                           CONSTRAINT uq_fav_user_listing UNIQUE (user_id, listing_id)
);