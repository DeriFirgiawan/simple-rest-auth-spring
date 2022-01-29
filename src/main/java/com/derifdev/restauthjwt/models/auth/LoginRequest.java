package com.derifdev.restauthjwt.models.auth;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class LoginRequest {
    @NotBlank
    private String email;

    @NotBlank String password;

    LoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
