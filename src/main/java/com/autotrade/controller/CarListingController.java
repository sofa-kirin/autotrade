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

import com.autotrade.model.ListingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    // GET /api/listings?page=0&size=10
    @GetMapping
    public ResponseEntity<Page<CarListingResponse>> getAllListings(Pageable pageable) {
        Page<CarListingResponse> response = carListingService.getAllListings(pageable);
        return ResponseEntity.ok(response);
    }

    // PUT /api/listings/{id}
    @PutMapping("/{id}")
    public ResponseEntity<CarListingResponse> updateListing(
            @PathVariable Long id,
            @Valid @RequestBody CarListingRequest request) {
        CarListingResponse response = carListingService.updateListing(id, request);
        return ResponseEntity.ok(response);
    }

    // PATCH /api/listings/{id}/status?status=SOLD
    @PatchMapping("/{id}/status")
    public ResponseEntity<CarListingResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam ListingStatus status) {
        CarListingResponse response = carListingService.updateStatus(id, status);
        return ResponseEntity.ok(response);
    }

    // DELETE /api/listings/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteListing(@PathVariable Long id) {
        carListingService.deleteListing(id);
        return ResponseEntity.noContent().build();
    }
}
