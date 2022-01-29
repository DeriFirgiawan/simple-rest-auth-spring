package com.derifdev.restauthjwt.service.impl;

import com.derifdev.restauthjwt.entity.Users;
import com.derifdev.restauthjwt.models.auth.GetAllUsersResponse;
import com.derifdev.restauthjwt.models.auth.RegisterRequest;
import com.derifdev.restauthjwt.models.auth.RegisterResponse;
import com.derifdev.restauthjwt.repository.UserRepository;
import com.derifdev.restauthjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;
    private final PasswordEncoder passwordEncoder;

    @Override
    public RegisterResponse register(RegisterRequest payload) {
        Users response = new Users();
        response.setName(payload.getName());
        response.setEmail(payload.getEmail());
        response.setPassword(passwordEncoder.encode(payload.getPassword()));
        response.setCreatedAt(new Date());
        repo.save(response);
        return new RegisterResponse(response.getId(), response.getName(), response.getEmail());
    }

    @Override
    public Users findByEmail(String email) {
        return repo.findByEmail(email);
    }

    @Override
    public List<Users> showAllUsers() {
        return repo.findAll();
    }

    @Override
    public Boolean comparePassword(String userPassword, String password) {
        return passwordEncoder.matches(userPassword, password);
    }
}
