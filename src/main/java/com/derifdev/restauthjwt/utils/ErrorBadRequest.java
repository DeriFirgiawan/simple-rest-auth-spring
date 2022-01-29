package com.derifdev.restauthjwt.utils;

public class ErrorBadRequest extends Exception {
    public String message;

    public ErrorBadRequest(String messages) {
        this.message = messages;
    }
}
