package com.autotrade.service;

import com.autotrade.dto.request.CarListingRequest;
import com.autotrade.dto.response.CarListingDetailsResponse;
import com.autotrade.dto.response.CarListingResponse;
import com.autotrade.exception.ResourceNotFoundException;
import com.autotrade.mapper.CarListingMapper;
import com.autotrade.model.CarListing;
import com.autotrade.repository.CarListingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.autotrade.model.ListingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
@RequiredArgsConstructor
public class CarListingService {

    private final CarListingRepository carListingRepository;
    private final CarListingMapper carListingMapper;

    public CarListingResponse createListing(CarListingRequest request) {
        CarListing listing = carListingMapper.toEntity(request);
        CarListing saved = carListingRepository.save(listing);
        return carListingMapper.toResponse(saved);
    }

    public CarListingDetailsResponse getListingById(Long id) {
        CarListing listing = carListingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing not found"));
        return carListingMapper.toDetailResponse(listing);
    }

    public Page<CarListingResponse> getAllListings(Pageable pageable) {
        return carListingRepository.findAll(pageable)
                .map(carListingMapper::toResponse);
    }

    public CarListingResponse updateListing(Long id, CarListingRequest request) {
        CarListing listing = carListingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing not found"));

        listing.setTitle(request.getTitle());
        listing.setBrand(request.getBrand());
        listing.setModel(request.getModel());
        listing.setYear(request.getYear());
        listing.setPrice(request.getPrice());
        listing.setMileage(request.getMileage());
        listing.setCity(request.getCity());
        listing.setDescription(request.getDescription());

        CarListing saved = carListingRepository.save(listing);
        return carListingMapper.toResponse(saved);
    }

    public CarListingResponse updateStatus(Long id, ListingStatus status) {
        CarListing listing = carListingRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Listing not found"));

        listing.setStatus(status);
        CarListing saved = carListingRepository.save(listing);
        return carListingMapper.toResponse(saved);
    }

    public void deleteListing(Long id) {
        if (!carListingRepository.existsById(id)) {
            throw new ResourceNotFoundException("Listing not found");
        }
        carListingRepository.deleteById(id);
    }
}
