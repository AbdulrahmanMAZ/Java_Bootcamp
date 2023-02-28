package com.abdulrahman.assignment29_4tests;


import com.abdulrahman.assignment29_4tests.repository.AuthRepository;
import com.abdulrahman.assignment29_4tests.repository.TodoRepository;
import com.abdulrahman.assignment29_4tests.model.MyUser;
import com.abdulrahman.assignment29_4tests.model.Todo;
import com.abdulrahman.assignment29_4tests.service.MyUserDetailsService;
import com.abdulrahman.assignment29_4tests.service.TodoService;
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



    @Mock
    AuthRepository authRepository;
    @InjectMocks
    MyUserDetailsService myUserDetailsService;



    MyUser user;

    Todo todo1,todo2,todo3;

    List<Todo> todos;

    @BeforeEach
    void setUp() {
        user=new MyUser(null,"Abdulrahman","12345","USER", null);

    }


    @Test
    public void loadUserByUsername(){
        when(authRepository.findMyUserByUsername(user.getUsername())).thenReturn(user);
        when(authRepository.findMyUserByUsername(user.getUsername())).thenReturn(user);

        Assertions.assertThat(myUserDetailsService.loadUserByUsername(user.getUsername())).isEqualTo(user);
        verify(authRepository,times(1)).findMyUserByUsername(user.getUsername());

    }

}