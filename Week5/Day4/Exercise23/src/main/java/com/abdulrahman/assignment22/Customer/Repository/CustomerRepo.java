package com.abdulrahman.assignment22.Customer.Repository;

import com.abdulrahman.assignment22.Customer.Model.Customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);

}
