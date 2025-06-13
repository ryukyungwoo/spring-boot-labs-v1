package com.example.ch2labs.labs07.controller.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class TodoResponse {
    private Long id;
    private String title;
    private boolean completed;
}
