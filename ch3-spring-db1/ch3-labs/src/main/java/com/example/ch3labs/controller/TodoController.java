package com.example.ch3labs.controller;

import com.example.ch3labs.dto.TodoCreateRequest;
import com.example.ch3labs.dto.TodoResponse;
import com.example.ch3labs.dto.TodoUpdateRequest;
import com.example.ch3labs.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {
    final private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.createPost(request));
    }

//    @GetMapping
//    public ResponseEntity<List<TodoResponse>> all() {
//        return ResponseEntity.status(HttpStatus.OK).body(todoService.allTodos());
//    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> searchByTitle(@ModelAttribute String keyword) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.searchByTitle(keyword));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> put(@PathVariable Long id, @RequestBody TodoUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.updatePost(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.removeTodo(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
