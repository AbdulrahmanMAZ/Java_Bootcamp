package com.abdulrahman.final_Project.Start_up.repository;

import com.abdulrahman.final_Project.Start_up.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);

}
