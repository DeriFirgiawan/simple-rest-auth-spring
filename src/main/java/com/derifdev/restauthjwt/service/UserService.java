package com.derifdev.restauthjwt.service;

import com.derifdev.restauthjwt.entity.Users;
import com.derifdev.restauthjwt.models.auth.GetAllUsersResponse;
import com.derifdev.restauthjwt.models.auth.RegisterRequest;
import com.derifdev.restauthjwt.models.auth.RegisterResponse;

import java.util.List;

public interface UserService {
    RegisterResponse register(RegisterRequest payload);
    Users findByEmail(String email);
    List<Users> showAllUsers();
    Boolean comparePassword(String userPassword, String password);
}
