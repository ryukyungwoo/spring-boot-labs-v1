package com.example.ch2labs.labs07.exception.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponse {
    private String statusCode;
    private String message;

}
