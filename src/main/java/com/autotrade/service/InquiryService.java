package com.autotrade.service;

import com.autotrade.dto.request.InquiryRequest;
import com.autotrade.dto.response.InquiryResponse;
import com.autotrade.exception.ResourceNotFoundException;
import com.autotrade.model.CarListing;
import com.autotrade.model.Inquiry;
import com.autotrade.model.InquiryStatus;
import com.autotrade.repository.CarListingRepository;
import com.autotrade.repository.InquiryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InquiryService {

    private final InquiryRepository inquiryRepository;
    private final CarListingRepository carListingRepository;

    public InquiryResponse createInquiry(Long listingId, InquiryRequest request) {

        CarListing listing = carListingRepository.findById(listingId)
                .orElseThrow(() -> new ResourceNotFoundException("Listing not found"));

        Inquiry inquiry = Inquiry.builder()
                .listing(listing)
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .message(request.getMessage())
                .build();

        Inquiry saved = inquiryRepository.save(inquiry);

        return toResponse(saved);
    }

    public Page<InquiryResponse> getAllInquiries(Pageable pageable) {
        return inquiryRepository.findAll(pageable)
                .map(this::toResponse);
    }

    public InquiryResponse updateStatus(Long id, InquiryStatus status) {
        Inquiry inquiry = inquiryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Inquiry not found"));

        inquiry.setStatus(status);
        Inquiry saved = inquiryRepository.save(inquiry);
        return toResponse(saved);
    }

    private InquiryResponse toResponse(Inquiry inquiry) {
        return InquiryResponse.builder()
                .id(inquiry.getId())
                .listingId(inquiry.getListing().getId())
                .name(inquiry.getName())
                .email(inquiry.getEmail())
                .phone(inquiry.getPhone())
                .message(inquiry.getMessage())
                .status(inquiry.getStatus())
                .createdAt(inquiry.getCreatedAt())
                .build();
    }
}
