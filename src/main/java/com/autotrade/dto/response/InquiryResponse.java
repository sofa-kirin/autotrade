package com.autotrade.dto.response;

import com.autotrade.model.InquiryStatus;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InquiryResponse {
    private Long id;
    private Long listingId;
    private String name;
    private String email;
    private String phone;
    private String message;
    private InquiryStatus status;
    private LocalDateTime createdAt;
}
