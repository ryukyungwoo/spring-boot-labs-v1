package com.example.ch2labs.labs07.service;

import com.example.ch2labs.labs07.exception.TodoBadRequestException;
import com.example.ch2labs.labs07.controller.req.TodoCreateRequest;
import com.example.ch2labs.labs07.controller.req.TodoRequest;
import com.example.ch2labs.labs07.controller.req.TodoUpdateRequest;
import com.example.ch2labs.labs07.controller.res.TodoResponse;
import com.example.ch2labs.labs07.domain.Todo;
import com.example.ch2labs.labs07.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

    final private TodoRepository todoRepository;

    public TodoResponse create(TodoCreateRequest request) {
        nullCheck(request);
        return toResponse(todoRepository.save(request));
    }

    public TodoResponse toResponse(Todo todo) {
        return new TodoResponse(todo.getId(), todo.getTitle(), todo.isCompleted());
    }

    public List<TodoResponse> read() {
        return todoRepository.findAll().stream().map(todo -> new TodoResponse(todo.getId(), todo.getTitle(), todo.isCompleted())).toList();
    }

    public TodoResponse update(Long id, TodoUpdateRequest request) {
        nullCheck(request);
        return toResponse(todoRepository.update(id, request));
    }

    public void delete(Long id) {
        todoRepository.delete(id);
    }

    public <T extends TodoRequest> void nullCheck(T t) {
        if(t.getTitle() == null || t.getCompleted() == null){
            throw new TodoBadRequestException();
        }
    }
}
