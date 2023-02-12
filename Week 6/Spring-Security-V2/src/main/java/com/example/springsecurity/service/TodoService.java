package com.example.springsecurity.service;


import com.example.springsecurity.exception.ApiException;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

   private final TodoRepository todoRepository;


    public List<Todo> getTodos(Integer id) {
        return todoRepository.findAllByUserId(id);
    }

    public void addTodo(Integer id,Todo todo) {
        todo.setUserId(id);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findById(todoId).get();

        if(todo.getUserId()!=userId){
            throw new ApiException("Bad request");
        }

        todoRepository.deleteById(todoId);
    }
    public void updateTodo(Integer userId, Integer todoId,Todo todo) {
        Todo todo_temp = todoRepository.findById(todoId).get();

        if(todo_temp.getUserId() != userId){
            throw new ApiException("Bad request");
        }
        todo_temp.setMessage(todo.getMessage());
        todoRepository.save(todo_temp);
    }
}
