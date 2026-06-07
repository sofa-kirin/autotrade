package com.autotrade.controller;

import com.autotrade.dto.request.CarListingRequest;
import com.autotrade.dto.response.CarListingDetailsResponse;
import com.autotrade.dto.response.CarListingResponse;
import com.autotrade.service.CarListingService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/listings")
@RequiredArgsConstructor
public class CarListingController {

    private final CarListingService carListingService;

    // POST /api/listings
    @PostMapping
    public ResponseEntity<CarListingResponse> createListing(
            @Valid @RequestBody CarListingRequest request) {
        CarListingResponse response = carListingService.createListing(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /api/listings/{id}
    @GetMapping("/{id}")
    public ResponseEntity<CarListingDetailsResponse> getListingById(
            @PathVariable Long id) {
        CarListingDetailsResponse response = carListingService.getListingById(id);
        return ResponseEntity.ok(response);
    }

    // GET /api/listings
    @GetMapping
    public ResponseEntity<List<CarListingResponse>> getAllListings() {
        List<CarListingResponse> response = carListingService.getAllListings();
        return ResponseEntity.ok(response);
    }
}
