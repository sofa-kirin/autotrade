package com.autotrade.dto.response;

import com.autotrade.model.ListingStatus;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarListingResponse {
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
}
