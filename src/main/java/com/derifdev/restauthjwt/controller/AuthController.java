package com.derifdev.restauthjwt.controller;

import com.derifdev.restauthjwt.config.JWTGenerated;
import com.derifdev.restauthjwt.entity.Users;
import com.derifdev.restauthjwt.models.WebResponse;
import com.derifdev.restauthjwt.models.auth.*;
import com.derifdev.restauthjwt.service.UserService;
import com.derifdev.restauthjwt.utils.ErrorBadRequest;
import com.derifdev.restauthjwt.utils.ErrorNotFound;
import com.derifdev.restauthjwt.utils.ValidationUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final UserService service;
    private final ValidationUtil validationUtil;

    @PostMapping(value = "/register")
    @ResponseStatus(value = HttpStatus.CREATED)
    WebResponse<RegisterResponse> register(@RequestBody RegisterRequest payload) throws ErrorBadRequest {
        validationUtil.validate(payload);
        Users findUser = service.findByEmail(payload.getEmail());
        if (findUser == null) {
            RegisterResponse saveUser = service.register(payload);
            WebResponse<RegisterResponse> response = new WebResponse<>();
            response.setStatus(201);
            response.setMessage("success register");
            response.setData(saveUser);
            return response;
        } else {
            throw new ErrorBadRequest("user is existing");
        }
    }

    @PostMapping(value = "/login")
    @ResponseStatus(value = HttpStatus.OK)
    WebResponse<LoginResponse> login(@RequestBody LoginRequest payload) throws ErrorBadRequest, ErrorNotFound {
        validationUtil.validate(payload);

        Users findUser = service.findByEmail(payload.getEmail());

        if (findUser == null) {
            throw new ErrorNotFound("user not found");
        } else {
            Boolean comparePassword = service.comparePassword(payload.getPassword(), findUser.getPassword());
            if (!comparePassword) {
                throw new ErrorBadRequest("password is wrong");
            }
            WebResponse<LoginResponse> response = new WebResponse<>();
            JWTGenerated tokenGenerated = new JWTGenerated();
            LoginResponse token = new LoginResponse(
                    tokenGenerated.getToken(findUser.getEmail(), findUser.getId()),
                    tokenGenerated.getRefreshToken(findUser.getEmail())
            );
            response.setStatus(200);
            response.setMessage("success login");
            response.setData(token);
            return response;
        }
    }
}
