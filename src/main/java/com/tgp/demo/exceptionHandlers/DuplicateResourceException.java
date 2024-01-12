package com.tgp.demo.exceptionHandlers;

public class DuplicateResourceException extends RuntimeException{
    public DuplicateResourceException (String message) {
        super(message);
    }
}
