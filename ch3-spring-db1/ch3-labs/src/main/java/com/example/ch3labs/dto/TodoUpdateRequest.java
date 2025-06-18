package com.example.ch3labs.dto;

import com.example.ch3labs.domain.Todo;
import lombok.Getter;

@Getter
public class TodoUpdateRequest {
    private String title;
    private Boolean completed;

    public static Todo to(Long id, TodoUpdateRequest request) {
        return new Todo(id, request.getTitle(), request.getCompleted());
    }
}
