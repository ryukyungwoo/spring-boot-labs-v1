package com.example.ch2labs.labs07.exception;

import com.example.ch2labs.labs07.exception.res.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalControllerException {

    @ExceptionHandler(TodoNotFoundException.class)
    public ResponseEntity<ErrorResponse> todoNotFoundException(TodoNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage()));
    }

    @ExceptionHandler(TodoBadRequestException.class)
    public ResponseEntity<ErrorResponse> todoBadRequestException(TodoBadRequestException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErrorResponse(HttpStatus.NOT_FOUND.toString(), e.getMessage()));
    }
}
