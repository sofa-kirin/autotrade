package com.autotrade.dto.response;

import com.autotrade.model.FuelType;
import com.autotrade.model.ListingStatus;
import com.autotrade.model.Transmission;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarListingDetailsResponse {
    private Long id;
    private String title;
    private String brand;
    private String model;
    private Integer year;
    private BigDecimal price;
    private Integer mileage;
    private String city;
    private ListingStatus status;
    private String mainImageUrl;
    private FuelType fuelType;
    private Transmission transmission;
    private String color;
    private String engineVolume;
    private Integer horsepower;
    private String driveType;
    private String description;
    private List<String> imageUrls;
}
