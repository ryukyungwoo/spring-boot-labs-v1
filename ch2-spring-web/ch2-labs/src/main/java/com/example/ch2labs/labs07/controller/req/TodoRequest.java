package com.example.ch2labs.labs07.controller.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TodoRequest {
    private String title;
    private Boolean completed;
}
