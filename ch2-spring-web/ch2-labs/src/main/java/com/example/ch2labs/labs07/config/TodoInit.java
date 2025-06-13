package com.example.ch2labs.labs07.config;

import com.example.ch2labs.labs07.controller.req.TodoCreateRequest;
import com.example.ch2labs.labs07.service.TodoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TodoInit {

    final private TodoService todoService;

    @PostConstruct
    public void todoInit() {
        todoService.create(new TodoCreateRequest("abc1", false));
        todoService.create(new TodoCreateRequest("abc2", false));
        todoService.create(new TodoCreateRequest("abc3", false));
        todoService.create(new TodoCreateRequest("abc4", false));
        todoService.create(new TodoCreateRequest("abc5", false));
        todoService.create(new TodoCreateRequest("abc6", false));

    }
}
