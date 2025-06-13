package com.example.ch2labs.labs07.exception;

public class TodoBadRequestException extends RuntimeException{
    public TodoBadRequestException() {
        super("title or completed is null");
    }
}
