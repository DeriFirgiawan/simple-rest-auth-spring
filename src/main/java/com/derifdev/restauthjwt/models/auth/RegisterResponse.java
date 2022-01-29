package com.derifdev.restauthjwt.models.auth;

import lombok.Data;

@Data
public class RegisterResponse {
    private int id;
    private String name;
    private String email;
    public RegisterResponse(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
