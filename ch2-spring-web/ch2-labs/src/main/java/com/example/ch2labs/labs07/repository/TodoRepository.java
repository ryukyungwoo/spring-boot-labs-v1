package com.example.ch2labs.labs07.repository;

import com.example.ch2labs.labs07.exception.TodoNotFoundException;
import com.example.ch2labs.labs07.controller.req.TodoCreateRequest;
import com.example.ch2labs.labs07.controller.req.TodoUpdateRequest;
import com.example.ch2labs.labs07.domain.Todo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class TodoRepository {

    final private Map<Long, Todo> todoStore = new HashMap<>();
    private Long seq = 0L;

    public Todo save(TodoCreateRequest request) {
        Todo todo = new Todo(++ seq, request.getTitle(), request.getCompleted());
        todoStore.put(seq, todo);
        return todo;
    }

    public List<Todo> findAll() {
        return todoStore.values().stream().toList();
    }

    public Todo update(Long id, TodoUpdateRequest request) {
        Todo todo = Optional.ofNullable(todoStore.get(id)).orElseThrow(() -> new TodoNotFoundException(id));
        todo.setTitle(request.getTitle());
        todo.setCompleted(request.getCompleted());
        return todo;
    }

    public void delete(Long id) {
        Todo todo = Optional.ofNullable(todoStore.get(id)).orElseThrow(() -> new TodoNotFoundException(id));
        todoStore.remove(todo.getId());
    }
}
