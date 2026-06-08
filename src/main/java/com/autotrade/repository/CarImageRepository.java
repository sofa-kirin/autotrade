package com.autotrade.repository;

import com.autotrade.model.CarImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarImageRepository extends JpaRepository<CarImage, Long> {
    List<CarImage> findByListingId(Long listingId);
    Optional<CarImage> findByListingIdAndMainTrue(Long listingId);
}
