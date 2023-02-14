package com.abdulrahman.store.Orderr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Orderr, Integer> {
     Orderr findOrderById(Integer id);
     List<Orderr> findAllByMyUser_Id(Integer id);


}
