package com.example.springsecurity;


import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import com.example.springsecurity.service.MyUserDetailsService;
import com.example.springsecurity.service.TodoService;
import org.assertj.core.api.Assertions;
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
public class MyUserDetailsServiceTest {


    TodoService todoService;
    @Mock
    TodoRepository todoRepository;
    @Mock
    AuthRepository authRepository;
    @InjectMocks
    MyUserDetailsService myUserDetailsService;

    @Mock
    Todo todo;

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
    public void loadUserByUsername(){
        when(authRepository.findMyUserByUsername(user.getUsername())).thenReturn(user);
        Assertions.assertThat(myUserDetailsService.loadUserByUsername(user.getUsername())).isEqualTo(user);
        verify(authRepository,times(1)).findMyUserByUsername(user.getUsername());

    }

}