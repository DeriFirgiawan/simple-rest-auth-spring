package com.derifdev.restauthjwt.utils;

public class ErrorNotFound extends Exception {
    public String message;
    public ErrorNotFound(String message) {
        this.message = message;
    }
}
