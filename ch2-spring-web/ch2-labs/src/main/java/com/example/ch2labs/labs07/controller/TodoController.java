package com.example.ch2labs.labs07.controller;

import com.example.ch2labs.labs07.controller.req.TodoCreateRequest;
import com.example.ch2labs.labs07.controller.req.TodoUpdateRequest;
import com.example.ch2labs.labs07.controller.res.TodoResponse;
import com.example.ch2labs.labs07.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {

    final private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponse> create(@RequestBody TodoCreateRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(todoService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<TodoResponse>> read() {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.read());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoResponse> update(@PathVariable Long id, @RequestBody TodoUpdateRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(todoService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        todoService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
