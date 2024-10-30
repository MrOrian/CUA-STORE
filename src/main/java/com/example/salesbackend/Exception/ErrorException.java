package com.example.salesbackend.Exception;

public class ErrorException extends Exception{
    public ErrorException(String message) {
        super(message);
    }

    public ErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
