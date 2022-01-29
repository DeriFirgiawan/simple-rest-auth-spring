package com.derifdev.restauthjwt.controller;

import com.derifdev.restauthjwt.models.WebResponse;
import com.derifdev.restauthjwt.utils.ErrorBadRequest;
import com.derifdev.restauthjwt.utils.ErrorNotFound;
import org.hibernate.mapping.Any;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class ErrorController {
    @ExceptionHandler(value = ConstraintViolationException.class)
    WebResponse<Any> validationHandler(ConstraintViolationException constraintViolationException) {
        WebResponse<Any> response = new WebResponse<>();
        response.setStatus(400);
        response.setMessage(constraintViolationException.getMessage());
        return response;
    }
    // Error Bad Request
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {ErrorBadRequest.class})
    WebResponse<Any> errorBadRequest(ErrorBadRequest errorBadRequest) {
        WebResponse<Any> response = new WebResponse<>();
        response.setStatus(400);
        response.setMessage(errorBadRequest.message);
        return response;
    }

    // Error Not Found
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {ErrorNotFound.class})
    WebResponse<Any> errorNotFound(ErrorNotFound errorNotFound) {
        WebResponse<Any> response = new WebResponse<>();
        response.setStatus(404);
        response.setMessage(errorNotFound.message);
        return response;
    }
}
