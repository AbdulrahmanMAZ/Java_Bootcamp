package com.example.springsecurity.contoller;

import com.example.springsecurity.dto.Response;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.service.TodoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/todo")
public class TodoController {

    private  TodoService todoService;


    @GetMapping()
    public ResponseEntity <List<Todo>> getTodos(@AuthenticationPrincipal MyUser myUser){
//        System.out.println(myUser.getRole());
        return ResponseEntity.status(200).body(todoService.getTodos(myUser.getId()));
    }

    @PostMapping()
    public ResponseEntity <Response> addTodos(@AuthenticationPrincipal MyUser myUser, @RequestBody Todo todo){
        todoService.addTodo(myUser.getId(),todo);
        return ResponseEntity.status(201).body(new Response("New Todo added !",201));
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity <Response> deleteTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId){
        todoService.removeTodo(myUser.getId(),todoId);
        return ResponseEntity.status(200).body(new Response("Todo deleted !",200));
    }
    @PutMapping("/{todoId}")
    public ResponseEntity <Response> updateTodos(@AuthenticationPrincipal MyUser myUser, @PathVariable Integer todoId,@RequestBody Todo todo){
        todoService.updateTodo(myUser.getId(),todoId,todo);
        return ResponseEntity.status(200).body(new Response("Todo Updated !",200));
    }


}
