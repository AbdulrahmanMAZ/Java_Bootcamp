package com.abdulrahman.assignment29_4tests;


import com.abdulrahman.assignment29_4tests.model.MyUser;
import com.abdulrahman.assignment29_4tests.model.Todo;
import com.abdulrahman.assignment29_4tests.repository.AuthRepository;
import com.abdulrahman.assignment29_4tests.repository.TodoRepository;
import com.abdulrahman.assignment29_4tests.service.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class TodoServiceTest {

    @InjectMocks
    TodoService todoService;
    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;


    MyUser user;

    Todo todo1,todo2,todo3;

    List<Todo> todos;

    @BeforeEach
    void setUp() {
        user=new MyUser(null,"Abdulrahman","12345","USER", null);
        todo1=new Todo(null,"todo1",user);
        todo2=new Todo(null,"todo2",user);
        todo3=new Todo(null,"todo3",null);

        todos=new ArrayList<>();
        todos.add(todo1);
        todos.add(todo2);
        todos.add(todo3);
    }


    @Test
    public void getAllTheUserTodoTest(){
        when(todoRepository.findAllByMyUser_Id(user.getId())).thenReturn(todos);
        List<Todo> todoList=todoService.getTodos(user.getId());
        Assertions.assertEquals(3,todoList.size());
        verify(todoRepository,times(1)).findAllByMyUser_Id(user.getId());

    }
    @Test
    public void getTodoByIdTest(){
        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
        when(todoRepository.findAllByMyUser(user)).thenReturn(todos);

        List<Todo> todoList = todoService.getTodoById(user.getId());
        Assertions.assertEquals(todoList,todos);
        verify(authRepository,times(1)).findMyUserById(user.getId());
        verify(todoRepository,times(1)).findAllByMyUser(user);

    }

    @Test
    public void AddTodoTest(){

        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
        todoService.addTodo(user.getId(),todo3);
        verify(authRepository,times(1)).findMyUserById(user.getId());
        verify(todoRepository,times(1)).save(todo3);
    }

    @Test
    public void updateTodoTest(){

        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
        todoService.updateTodo(user.getId(),todo1.getId(),todo2);
        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).save(todo1);

    }

    @Test
    public void deleteTodoTest(){

        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
        todoService.removeTodo(user.getId(),todo1.getId());
        verify(todoRepository,times(1)).findTodoById(todo1.getId());
        verify(todoRepository,times(1)).delete(todo1);

    }





}