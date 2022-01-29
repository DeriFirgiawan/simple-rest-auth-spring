package com.derifdev.restauthjwt.models.auth;

import lombok.Data;

@Data
public class GetAllUsersResponse {
    private int id;
    private String name;
    private String email;
    private Boolean active;

    public GetAllUsersResponse(int id, String name, String email, Boolean active) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.active = active;
    }
}
