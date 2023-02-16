package com.abdulrahman.assignment29_4tests;


import com.abdulrahman.assignment29_4tests.dto.Response;
import com.abdulrahman.assignment29_4tests.contoller.AuthController;
import com.abdulrahman.assignment29_4tests.model.MyUser;
import com.abdulrahman.assignment29_4tests.model.Todo;
import com.abdulrahman.assignment29_4tests.repository.AuthRepository;
import com.abdulrahman.assignment29_4tests.service.AuthService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AuthControllerTest {

    @InjectMocks
    AuthController authController;
    @Mock
    AuthService authService;



    @Test
    public void registerControllerTest(){

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        MyUser myUser = new MyUser();
        myUser.setId(1);
        MyUser user=new MyUser(null,"Abdulrahman","12345","USER", null);
        ResponseEntity<Response> responseEntity = authController.register(user);
        Assertions.assertThat(responseEntity.getStatusCode().value()).isEqualTo(201);
        Response response = new Response("User registered !",201);
        Assertions.assertThat(responseEntity.getBody()).isEqualTo(response);

}







}