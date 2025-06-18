package com.example.ch3labs.mapper;

import com.example.ch3labs.domain.Todo;
import com.example.ch3labs.dto.TodoResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TodoMapper {
    void insert(Todo post);
    List<Todo> findAll();
    void update(Todo todo);
    void remove(Long id);
    List<Todo> findByTitle(String keyword);
}
