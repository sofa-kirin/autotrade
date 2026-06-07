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

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CarListingResponse> getAllListings() {
        return carListingRepository.findAll()
                .stream()
                .map(carListingMapper::toResponse)
                .collect(Collectors.toList());
    }
}
