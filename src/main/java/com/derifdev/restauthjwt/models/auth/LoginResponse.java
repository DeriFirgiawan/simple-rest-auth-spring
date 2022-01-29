package com.derifdev.restauthjwt.models.auth;

import lombok.Data;

@Data
public class LoginResponse {
    private String token;
    private String refresh_token;

    public LoginResponse(String token, String refreshToken) {
        this.token = token;
        this.refresh_token = refreshToken;
    }
}
