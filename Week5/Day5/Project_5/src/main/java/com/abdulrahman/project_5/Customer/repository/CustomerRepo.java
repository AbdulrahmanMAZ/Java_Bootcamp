package com.abdulrahman.project_5.Customer.repository;

import com.abdulrahman.project_5.Customer.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);

}
