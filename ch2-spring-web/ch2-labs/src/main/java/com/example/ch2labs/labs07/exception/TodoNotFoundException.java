package com.example.ch2labs.labs07.exception;

public class TodoNotFoundException extends RuntimeException{
    public TodoNotFoundException(Long id) {
        super("no identify id : " + id);
    }
}
