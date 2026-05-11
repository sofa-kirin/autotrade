package com.autotrade.repository;

import com.autotrade.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUserId(Long userId);
    Optional<Favorite> findByUserIdAndCarListingId(Long userId, Long carListingId);
    boolean existsByUserIdAndCarListingId(Long userId, Long carListingId);
    void deleteByUserIdAndCarListingId(Long userId, Long carListingId);
}
