package com.derifdev.restauthjwt.controller;

import com.derifdev.restauthjwt.entity.Users;
import com.derifdev.restauthjwt.models.WebResponse;
import com.derifdev.restauthjwt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping(value = "/users")
    @ResponseStatus(value = HttpStatus.OK)
    WebResponse<List<Users>> users() {
        List<Users> list = service.showAllUsers();
        WebResponse<List<Users>> response = new WebResponse<>();
        response.setStatus(200);
        response.setMessage("success get all users");
        response.setData(list);
        return response;
    }
}
