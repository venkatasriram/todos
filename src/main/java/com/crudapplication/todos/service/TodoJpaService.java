package com.crudapplication.todos.service;

import com.crudapplication.todos.entity.Todo;
import com.crudapplication.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoJpaService {
    @Autowired
    private TodoRepository todoRepository;
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }
    public Todo getTodoById(int id) {
        return todoRepository.findById(id).orElse(null);
    }
    public Todo saveOrUpdateTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    public void deleteTodoById(int id) {
        todoRepository.deleteById(id);
    }
}
