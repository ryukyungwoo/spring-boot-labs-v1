package com.example.ch3labs.dto;

import com.example.ch3labs.domain.Todo;
import lombok.Getter;

@Getter
public class TodoCreateRequest {
    private String title;
    private Boolean completed;

    public static Todo to(TodoCreateRequest request) {
        return new Todo(null, request.getTitle(), request.getCompleted());
    }
}
