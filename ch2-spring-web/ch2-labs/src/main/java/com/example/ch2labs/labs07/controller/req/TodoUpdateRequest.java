package com.example.ch2labs.labs07.controller.req;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class TodoUpdateRequest extends TodoRequest{
    public TodoUpdateRequest(String title, boolean completed) {
        super(title, completed);
    }
}
