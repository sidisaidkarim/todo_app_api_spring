package com.example.todoapp.unit;

import com.example.todoapp.repository.TodoRepository;
import com.example.todoapp.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    private TodoService todoService;

    @BeforeEach void setUp(){
        this.todoService = new TodoService(todoRepository);
    }


    @Test
    void shouldGetAllTodos(){
        todoService.getAll();
        verify(todoRepository).findAll();
        assertEquals(todoService.getAll().size(),todoRepository.findAll().size());
    }
}
