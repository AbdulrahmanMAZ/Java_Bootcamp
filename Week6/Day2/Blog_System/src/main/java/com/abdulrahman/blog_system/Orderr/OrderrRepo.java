package com.abdulrahman.blog_system.Orderr;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderrRepo extends JpaRepository<Orderr, Integer> {
     Orderr findOrderrById(Integer id);
     List<Orderr> findAllByMyUser_Id(Integer id);


}
