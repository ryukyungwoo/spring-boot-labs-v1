package com.example.ch2labs.labs07.controller.req;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class TodoCreateRequest extends TodoRequest{
    public TodoCreateRequest(String title, boolean completed) {
        super(title, completed);
    }
}
