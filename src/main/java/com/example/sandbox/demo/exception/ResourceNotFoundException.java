package com.example.sandbox.demo.exception;

public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String err) {
        super(err);
    }
}
