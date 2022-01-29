package com.derifdev.restauthjwt.models;

import lombok.Data;

@Data
public class WebResponse <T> {
    private int status;
    private String message;
    private T data;
}
