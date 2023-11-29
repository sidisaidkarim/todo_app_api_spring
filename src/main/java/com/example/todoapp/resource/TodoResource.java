package com.example.todoapp.resource;


import com.example.todoapp.model.Todo;
import com.example.todoapp.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
