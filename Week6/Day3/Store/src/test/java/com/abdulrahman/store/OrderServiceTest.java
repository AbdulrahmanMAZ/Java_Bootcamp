package com.abdulrahman.store;

import com.abdulrahman.store.MyUser.MyUserRepo;
import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Order.Order;
import com.abdulrahman.store.Order.OrderRepo;
import com.abdulrahman.store.Order.OrderService;
import com.abdulrahman.store.Product.Product;
import org.aspectj.weaver.ast.Or;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

public class OrderServiceTest {


    @Mock
    OrderRepo orderRepo;
    @InjectMocks
    OrderService orderService;

    @Mock
    MyUserRepo myUserRepo;

    Order order1,order2,order3;

    MyUser myUser;
    Set<Product> products;
    List<Order> orders;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Abdulrahman" , "12345" , "USER" , null);

        order1 = new Order(null ,10, 0 , null,null ,"new", myUser, null);
        order2 = new Order(null ,5, 0 , null,null ,"new", myUser, null);
        order3 = new Order(null ,3, 0 , null,null ,"new", null, null);
//        myUserRepo.save(myUser);
        orders = new ArrayList();

        orders.add(order1);
        orders.add(order2);

    }


    @Test
    public void getUserOrdersTesting(){
        when(orderRepo.findAll()).thenReturn(orders);
        List<Order> orders1 =  orderService.getMyOrders();
        System.out.println(orders.size());
        Assertions.assertThat(orders1).isEqualTo(orders);

    }

//
//    @Test
//    public void getTodoByIdTest(){
//        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
//        when(todoRepository.findAllByMyUser(user)).thenReturn(todos);
//
//
//        List<Todo> todo = todoService.getTodo(user.getId());
//        Assertions.assertEquals(todo,todos);
//        verify(authRepository,times(1)).findMyUserById(user.getId());
//        verify(todoRepository,times(1)).findAllByMyUser(user);
//
//    }
//
//    @Test
//    public void AddTodoTest(){
//
//        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
//
//        todoService.addTodo(user.getId(),todo3);
//        verify(authRepository,times(1)).findMyUserById(user.getId());
//        verify(todoRepository,times(1)).save(todo3);
//    }
//
//    @Test
//    public void updateTodoTest(){
//
//        when(todoRepository.findTodoById(todo1.getId())).thenReturn(todo1);
//        when(authRepository.findMyUserById(user.getId())).thenReturn(user);
//
//        todoService.updateTodo(todo1.getId(),todo2,user.getId());
//
//        verify(todoRepository,times(1)).findTodoById(todo1.getId());
//        verify(authRepository,times(1)).findMyUserById(user.getId());
//        verify(todoRepository,times(1)).save(todo1);
//
//    }


}