package com.derifdev.restauthjwt.utils;

import lombok.RequiredArgsConstructor;
import org.hibernate.mapping.Any;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;


@Component
@RequiredArgsConstructor
public class ValidationUtil <T> {
    private final Validator validator;
    public void validate(T a) {
        var result = validator.validate(a);
        if (result.size() != 0) {
            throw new ConstraintViolationException(result);
        }
    }
}
