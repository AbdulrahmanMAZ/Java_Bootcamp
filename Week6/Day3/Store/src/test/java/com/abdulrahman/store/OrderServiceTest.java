package com.abdulrahman.store;

import com.abdulrahman.store.MyUser.MyUserRepo;
import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Order.Order;
import com.abdulrahman.store.Order.OrderRepo;
import com.abdulrahman.store.Order.OrderService;
import com.abdulrahman.store.Product.Product;
import org.aspectj.weaver.ast.Or;
import org.junit.jupiter.api.Assertions;
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
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
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
        Assertions.assertEquals(orders1.size(),orders.size());

    }

//    @Test
//    public void findTodoById(){
//        orderRepo.save(order1);
//        Order order=orderRepo.findOrderById(order1.getId());
//        Assertions.assertThat(order).isEqualTo(order1);
//    }


}