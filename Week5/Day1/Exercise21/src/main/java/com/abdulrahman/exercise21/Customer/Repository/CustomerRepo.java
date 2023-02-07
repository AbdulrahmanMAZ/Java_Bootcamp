package com.abdulrahman.exercise21.Customer.Repository;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    Customer findCustomerById(Integer id);
}
