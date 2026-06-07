package com.autotrade.mapper;

import com.autotrade.dto.request.CarListingRequest;
import com.autotrade.dto.response.CarListingDetailsResponse;
import com.autotrade.dto.response.CarListingResponse;
import com.autotrade.model.CarImage;
import com.autotrade.model.CarListing;
import com.autotrade.model.CarSpecificationDetails;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarListingMapper {
    public CarListingResponse toResponse(CarListing listing) {
        return CarListingResponse.builder()
                .id(listing.getId())
                .title(listing.getTitle())
                .brand(listing.getBrand())
                .model(listing.getModel())
                .year(listing.getYear())
                .price(listing.getPrice())
                .mileage(listing.getMileage())
                .city(listing.getCity())
                .status(listing.getStatus())
                .mainImageUrl(listing.getImages().stream()
                        .filter(CarImage::isMain)
                        .findFirst()
                        .map(CarImage::getUrl)
                        .orElse(null))
                .build();
    }
    public CarListingDetailsResponse toDetailResponse(CarListing listing) {

        CarSpecificationDetails spec = listing.getSpecification();

        List<String> imageUrls = listing.getImages().stream()
                .map(CarImage::getUrl)
                .collect(Collectors.toList());

        return CarListingDetailsResponse.builder()

                .id(listing.getId())
                .title(listing.getTitle())
                .brand(listing.getBrand())
                .model(listing.getModel())
                .year(listing.getYear())
                .price(listing.getPrice())
                .mileage(listing.getMileage())
                .city(listing.getCity())
                .status(listing.getStatus())
                .description(listing.getDescription())

                .mainImageUrl(listing.getImages().stream()
                        .filter(CarImage::isMain)
                        .findFirst()
                        .map(CarImage::getUrl)
                        .orElse(null))
                .imageUrls(imageUrls)

                .fuelType(spec != null ? spec.getFuelType() : null)
                .transmission(spec != null ? spec.getTransmission() : null)
                .color(spec != null ? spec.getColor() : null)
                .engineVolume(spec != null ? spec.getEngineVolume() : null)
                .horsepower(spec != null ? spec.getHorsepower() : null)
                .driveType(spec != null ? spec.getDriveType() : null)

                .build();
    }
    public CarListing toEntity(CarListingRequest request) {
        if (request == null) return null;

        CarListing listing = new CarListing();
        listing.setTitle(request.getTitle());
        listing.setBrand(request.getBrand());
        listing.setModel(request.getModel());
        listing.setYear(request.getYear());
        listing.setPrice(request.getPrice());
        listing.setMileage(request.getMileage());
        listing.setCity(request.getCity());
        listing.setDescription(request.getDescription());

        boolean hasSpec = request.getFuelType() != null
                || request.getTransmission() != null
                || request.getColor() != null
                || request.getEngineVolume() != null
                || request.getHorsepower() != null
                || request.getDriveType() != null;

        if (hasSpec) {
            CarSpecificationDetails spec = new CarSpecificationDetails();
            spec.setFuelType(request.getFuelType());
            spec.setTransmission(request.getTransmission());
            spec.setColor(request.getColor());
            spec.setEngineVolume(request.getEngineVolume());
            spec.setHorsepower(request.getHorsepower());
            spec.setDriveType(request.getDriveType());
            spec.setListing(listing);
            listing.setSpecification(spec);
        }

        return listing;
    }
}
