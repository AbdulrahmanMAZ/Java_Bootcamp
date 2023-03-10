package com.abdulrahman.store.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {
     Order findOrderById(Integer id);
     List<Order> findAllByMyUser_Id(Integer id);


}
