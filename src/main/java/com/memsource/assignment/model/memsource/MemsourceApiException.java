package com.memsource.assignment.model.memsource;

/**
 * Exception for general error during call of Memsource API.
 */
public class MemsourceApiException extends RuntimeException {
    public MemsourceApiException(String message) {
        super(message);
    }
}
