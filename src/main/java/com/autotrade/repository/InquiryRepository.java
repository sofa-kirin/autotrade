package com.autotrade.repository;

import com.autotrade.model.Inquiry;
import com.autotrade.model.InquiryStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InquiryRepository extends JpaRepository<Inquiry, Long> {
    Page<Inquiry> findByListingId(Long listingId, Pageable pageable);
    Page<Inquiry> findByStatus(InquiryStatus status, Pageable pageable);
    long countByStatus(InquiryStatus status);
}
