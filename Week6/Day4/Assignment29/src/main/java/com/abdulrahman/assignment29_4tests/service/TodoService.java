package com.abdulrahman.assignment29_4tests.service;


import com.abdulrahman.assignment29_4tests.exception.ApiException;
import com.abdulrahman.assignment29_4tests.repository.AuthRepository;
import com.abdulrahman.assignment29_4tests.repository.TodoRepository;
import com.abdulrahman.assignment29_4tests.model.MyUser;
import com.abdulrahman.assignment29_4tests.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {

   private final TodoRepository todoRepository;

   private final AuthRepository authRepository;


    public List<Todo> getTodos(Integer id) {
        return todoRepository.findAllByMyUser_Id(id);
    }

    public void addTodo(Integer id,Todo todo) {
        MyUser myUser = authRepository.findMyUserById(id);
        if (myUser == null) {
            throw new ApiException("not found");
        }
        todo.setMyUser(myUser);
        todoRepository.save(todo);
    }

    public void removeTodo(Integer userId, Integer todoId) {
        Todo todo=todoRepository.findTodoById(todoId);
        MyUser myUser = todo.getMyUser();
        if (myUser == null) {
            throw new ApiException("Does not have owner");
        }
        if(todo.getMyUser().getId() != userId || todo == null){
            throw new ApiException("Bad request");
        }
        if(todo.getMyUser().getId() !=userId){
            throw new ApiException("Bad request");
        }

        todoRepository.delete(todo);
    }
    public void updateTodo(Integer userId, Integer todoId,Todo todos) {
        Todo todo = todoRepository.findTodoById(todoId);
        MyUser myUser = todo.getMyUser();
        if (myUser == null) {
            throw new ApiException("Does not have owner");
        }
        if(todo.getMyUser().getId() != userId || todo == null){
            throw new ApiException("Bad request");
        }
        todo.setMessage(todos.getMessage());
        todoRepository.save(todo);
    }
    public List<Todo> getTodoById(Integer user_id) {
        MyUser myUser = authRepository.findMyUserById(user_id);
        if (myUser == null) {
            throw new ApiException("not found");
        }
        List<Todo> todos = todoRepository.findAllByMyUser(myUser);
        if (todos == null) {
            throw new ApiException("not found");
        }
        return todos;
    }
}
