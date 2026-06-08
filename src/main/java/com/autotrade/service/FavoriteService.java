package com.autotrade.service;

import com.autotrade.dto.response.FavoriteResponse;
import com.autotrade.exception.ResourceNotFoundException;
import com.autotrade.model.CarImage;
import com.autotrade.model.CarListing;
import com.autotrade.model.Favorite;
import com.autotrade.model.User;
import com.autotrade.repository.CarListingRepository;
import com.autotrade.repository.FavoriteRepository;
import com.autotrade.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final CarListingRepository carListingRepository;
    private final UserRepository userRepository;

    // Добавить объявление в избранное
    public FavoriteResponse addFavorite(Long listingId, String email) {
        // 1. Находим пользователя по email (email берём из JWT токена)
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        // 2. Находим объявление
        CarListing listing = carListingRepository.findById(listingId)
                .orElseThrow(() -> new ResourceNotFoundException("Listing not found"));

        // 3. Проверяем — вдруг уже добавлено в избранное
        if (favoriteRepository.existsByUserIdAndCarListingId(user.getId(), listingId)) {
            throw new IllegalStateException("Already in favorites");
        }

        // 4. Создаём и сохраняем
        Favorite favorite = Favorite.builder()
                .user(user)
                .carListing(listing)
                .build();

        Favorite saved = favoriteRepository.save(favorite);
        return toResponse(saved);
    }

    // Убрать объявление из избранного
    @Transactional
    public void removeFavorite(Long listingId, String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (!favoriteRepository.existsByUserIdAndCarListingId(user.getId(), listingId)) {
            throw new ResourceNotFoundException("Favorite not found");
        }

        favoriteRepository.deleteByUserIdAndCarListingId(user.getId(), listingId);
    }

    // Получить все избранные текущего пользователя
    public List<FavoriteResponse> getUserFavorites(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        return favoriteRepository.findByUserId(user.getId())
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // Конвертация: Favorite (entity) → FavoriteResponse (DTO)
    private FavoriteResponse toResponse(Favorite favorite) {
        CarListing listing = favorite.getCarListing();

        String mainImageUrl = listing.getImages().stream()
                .filter(CarImage::isMain)
                .findFirst()
                .map(CarImage::getUrl)
                .orElse(null);

        return FavoriteResponse.builder()
                .id(favorite.getId())
                .listingId(listing.getId())
                .listingTitle(listing.getTitle())
                .listingBrand(listing.getBrand())
                .listingModel(listing.getModel())
                .mainImageUrl(mainImageUrl)
                .createdAt(favorite.getCreatedAt())
                .build();
    }
}
