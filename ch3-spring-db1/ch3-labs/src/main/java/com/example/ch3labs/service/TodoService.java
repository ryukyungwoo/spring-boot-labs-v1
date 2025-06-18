package com.example.ch3labs.service;

import com.example.ch3labs.domain.Todo;
import com.example.ch3labs.dto.TodoCreateRequest;
import com.example.ch3labs.dto.TodoResponse;
import com.example.ch3labs.dto.TodoUpdateRequest;
import com.example.ch3labs.mapper.TodoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    final private TodoMapper todoMapper;

    public TodoResponse createPost(TodoCreateRequest request) {
        Todo post = TodoCreateRequest.to(request);
        todoMapper.insert(post);
        return TodoResponse.from(post);
    }

    public List<TodoResponse> allTodos() {
        return todoMapper.findAll().stream().map(TodoResponse::from).toList();
    }

    public TodoResponse updatePost(Long id, TodoUpdateRequest request) {
        Todo todo = TodoUpdateRequest.to(id, request);
        todoMapper.update(todo);
        return TodoResponse.from(todo);
    }

    public void removeTodo(Long id) {
        todoMapper.remove(id);
    }

    public List<TodoResponse> searchByTitle(String keyword) {
        System.out.println(keyword);
        return todoMapper.findByTitle(keyword).stream().map(TodoResponse::from).toList();
    }
}
