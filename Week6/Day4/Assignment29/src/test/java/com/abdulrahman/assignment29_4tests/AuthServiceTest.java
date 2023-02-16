package com.abdulrahman.assignment29_4tests;


import com.abdulrahman.assignment29_4tests.repository.AuthRepository;
import com.abdulrahman.assignment29_4tests.repository.TodoRepository;
import com.abdulrahman.assignment29_4tests.model.MyUser;
import com.abdulrahman.assignment29_4tests.model.Todo;
import com.abdulrahman.assignment29_4tests.service.AuthService;
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
public class AuthServiceTest {

    @InjectMocks
    AuthService authService;

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
    public void registerTest(){
        authService.register(user);
        verify(authRepository,times(1)).save(user);

    }







}