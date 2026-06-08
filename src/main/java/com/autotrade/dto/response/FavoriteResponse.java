package com.autotrade.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FavoriteResponse {
    private Long id;
    private Long listingId;
    private String listingTitle;
    private String listingBrand;
    private String listingModel;
    private String mainImageUrl;
    private LocalDateTime createdAt;
}
