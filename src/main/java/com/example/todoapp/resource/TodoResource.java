package com.example.todoapp.resource;


import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todo/")
public class TodoResource {

    private TodoService todoService;

    public TodoResource (TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<Todo>> getAll(){
        return ResponseEntity.ok().body(todoService.getAll());
    }

    @PostMapping
    public ResponseEntity<Todo> addTodo(@RequestBody Todo newTodo){
        todoService.addTodo(newTodo);
        return   ResponseEntity.ok().body(newTodo);

    }
}
