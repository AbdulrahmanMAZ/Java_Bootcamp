package com.abdulrahman.store;

import com.abdulrahman.store.MyUser.MyUserRepo;
import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Order.Order;
import com.abdulrahman.store.Order.OrderRepo;
import com.abdulrahman.store.Product.Product;
import org.aspectj.weaver.ast.Or;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DaoTests {


    @Autowired
    OrderRepo orderRepo;

    @Autowired
    MyUserRepo myUserRepo;

    Order order1,order2,order3;
    MyUser myUser;
    Set<Product> products;

    @BeforeEach
    void setUp() {
        myUser=new MyUser(null,"Abdulrahman" , "12345" , "USER" , null);

        order1 = new Order(null ,10, 0 , null,null ,"new", myUser, null);
        order2 = new Order(null ,5, 0 , null,null ,"new", myUser, null);
        order3 = new Order(null ,3, 0 , null,null ,"new", null, null);
        myUserRepo.save(myUser);
        orderRepo.save(order1);
        orderRepo.save(order2);
        orderRepo.save(order3);
    }


    @Test
    public void findAllByMyUserTesting(){
        List<Order> orders= orderRepo.findAllByMyUser_Id(myUser.getId());

        for (Order order: orders) {
            Assertions.assertThat(order.getMyUser().getId()).isEqualTo(myUser.getId());
        }

    }

    @Test
    public void findTodoById(){
        orderRepo.save(order1);
        Order order=orderRepo.findOrderById(order1.getId());
        Assertions.assertThat(order).isEqualTo(order1);
    }


}