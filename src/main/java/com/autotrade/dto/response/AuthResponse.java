package com.autotrade.dto.response;

import lombok.*;

@Getter
@AllArgsConstructor
public class AuthResponse {
    private String token;
    private String email;
    private String role;
}
