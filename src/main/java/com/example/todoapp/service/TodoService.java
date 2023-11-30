package com.example.todoapp.service;

import com.example.todoapp.model.Todo;
import com.example.todoapp.repository.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getAll() {
        return this.todoRepository.findAll();
    }

    public Todo addTodo(Todo newTodo) {
        return this.todoRepository.save(newTodo);
    }

    public String deleteTodo(Long id) {
        Optional<Todo> optional = todoRepository.findById(id);

        if (!optional.isEmpty()) {
            this.todoRepository.deleteById(id);
            return "Todo deleted with success";
        }
        return "Todo task doesn't exist";
    }
}
