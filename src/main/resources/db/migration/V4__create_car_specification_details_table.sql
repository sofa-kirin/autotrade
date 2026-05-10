CREATE TABLE car_specification_details (
                                           id           BIGINT AUTO_INCREMENT PRIMARY KEY,
                                           listing_id   BIGINT NOT NULL UNIQUE,
                                           fuel_type    ENUM('PETROL','DIESEL','ELECTRIC','HYBRID','GAS'),
                                           transmission ENUM('MANUAL','AUTOMATIC','ROBOT','VARIATOR'),
                                           color        VARCHAR(50),
                                           engine_volume VARCHAR(10),
                                           horsepower   INT,
                                           drive_type   VARCHAR(10),
                                           updated_at   DATETIME,
                                           CONSTRAINT fk_specs_listing FOREIGN KEY (listing_id)
                                               REFERENCES car_listings(id) ON DELETE CASCADE
);