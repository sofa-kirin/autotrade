package com.autotrade.repository;

import com.autotrade.model.CarListing;
import com.autotrade.model.ListingStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarListingRepository extends JpaRepository<CarListing, Long>, JpaSpecificationExecutor<CarListing> {
    Page<CarListing> findByStatus(ListingStatus status, Pageable pageable);
}
