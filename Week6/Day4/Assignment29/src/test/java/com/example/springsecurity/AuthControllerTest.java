package com.example.springsecurity;


import com.example.springsecurity.contoller.AuthController;
import com.example.springsecurity.dto.Response;
import com.example.springsecurity.model.MyUser;
import com.example.springsecurity.model.Todo;
import com.example.springsecurity.repository.AuthRepository;
import com.example.springsecurity.repository.TodoRepository;
import com.example.springsecurity.service.AuthService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @InjectMocks
    AuthController authController;
    @Mock
    AuthService authService;
    @Mock
    AuthRepository authRepository;

    @Mock
    Todo todo;

    MyUser user;

    Todo todo1,todo2,todo3;

    List<Todo> todos;

//    @BeforeEach
//    void setUp() {
//        user=new MyUser(null,"Abdulrahman","12345","USER", null);
//
//    }


    @Test
    public void registerControllerTest(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        MyUser myUser = new MyUser();
        myUser.setId(1);
//        when(authRepository.save(any(MyUser.class))).thenReturn(user);
        MyUser user=new MyUser(null,"Abdulrahman","12345","USER", null);
        ResponseEntity<Response> responseEntity = authController.register(user);
        Assertions.assertThat(responseEntity.getStatusCode().value()).isEqualTo(201);
        Response response = new Response("User registered !",201);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(response);

//        assertThat(responseEntity).isEqualTo(201);
//        assertThat(responseEntity.getHeaders().getLocation().getPath()).isEqualTo("/1");
    }







}