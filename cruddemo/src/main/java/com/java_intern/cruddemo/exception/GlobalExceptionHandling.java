package com.java_intern.cruddemo.exception;


public class GlobalExceptionHandling {
    public static class NotFoundResource extends RuntimeException{
        public NotFoundResource(String message) {
            super(message);
        }
    }
}
