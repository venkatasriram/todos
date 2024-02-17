package com.crudapplication.todos.contoller;

import com.crudapplication.todos.entity.Todo;
import com.crudapplication.todos.service.TodoJpaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todos/")
public class TodoController {
    @Autowired
    private TodoJpaService todoService;
    @GetMapping
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public Todo getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }
    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoService.saveOrUpdateTodo(todo);
    }
    @PutMapping("/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo todo) {
        todo.setId(id);
        return todoService.saveOrUpdateTodo(todo);
    }
    @DeleteMapping("/{id}")
    public void deleteTodoById(@PathVariable int id) {
        todoService.deleteTodoById(id);
    }
}
