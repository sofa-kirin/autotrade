package com.autotrade.controller;

import com.autotrade.dto.request.InquiryRequest;
import com.autotrade.dto.response.InquiryResponse;
import com.autotrade.model.InquiryStatus;
import com.autotrade.service.InquiryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class InquiryController {

    private final InquiryService inquiryService;

    // POST /api/listings/{listingId}/inquiries
    @PostMapping("/api/listings/{listingId}/inquiries")
    public ResponseEntity<InquiryResponse> createInquiry(
            @PathVariable Long listingId,
            @Valid @RequestBody InquiryRequest request) {
        InquiryResponse response = inquiryService.createInquiry(listingId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // GET /api/inquiries?page=0&size=10
    @GetMapping("/api/inquiries")
    public ResponseEntity<Page<InquiryResponse>> getAllInquiries(Pageable pageable) {
        Page<InquiryResponse> response = inquiryService.getAllInquiries(pageable);
        return ResponseEntity.ok(response);
    }

    // PATCH /api/inquiries/{id}/status?status=VIEWED
    @PatchMapping("/api/inquiries/{id}/status")
    public ResponseEntity<InquiryResponse> updateStatus(
            @PathVariable Long id,
            @RequestParam InquiryStatus status) {
        InquiryResponse response = inquiryService.updateStatus(id, status);
        return ResponseEntity.ok(response);
    }
}
