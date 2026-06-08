package com.autotrade.controller;

import com.autotrade.dto.response.FavoriteResponse;
import com.autotrade.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    // POST /api/favorites/{listingId}
    @PostMapping("/{listingId}")
    public ResponseEntity<FavoriteResponse> addFavorite(
            @PathVariable Long listingId,
            @AuthenticationPrincipal UserDetails userDetails) {
        FavoriteResponse response = favoriteService.addFavorite(listingId, userDetails.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // DELETE /api/favorites/{listingId}
    @DeleteMapping("/{listingId}")
    public ResponseEntity<Void> removeFavorite(
            @PathVariable Long listingId,
            @AuthenticationPrincipal UserDetails userDetails) {
        favoriteService.removeFavorite(listingId, userDetails.getUsername());
        return ResponseEntity.noContent().build();
    }

    // GET /api/favorites
    @GetMapping
    public ResponseEntity<List<FavoriteResponse>> getUserFavorites(
            @AuthenticationPrincipal UserDetails userDetails) {
        List<FavoriteResponse> response = favoriteService.getUserFavorites(userDetails.getUsername());
        return ResponseEntity.ok(response);
    }
}
