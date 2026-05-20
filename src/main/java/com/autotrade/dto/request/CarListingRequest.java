package com.autotrade.dto.request;

import com.autotrade.model.FuelType;
import com.autotrade.model.Transmission;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarListingRequest {

    @NotBlank
    private String title;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    @Min(1900)
    private Integer year;

    @NotNull
    @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull
    private Integer mileage;

    @NotBlank
    private String city;

    private FuelType fuelType;
    private Transmission transmission;
    private String color;
    private String engineVolume;
    private Integer horsepower;
    private String driveType;
    private String description;
}
