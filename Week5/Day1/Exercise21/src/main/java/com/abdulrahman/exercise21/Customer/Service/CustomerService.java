package com.abdulrahman.exercise21.Customer.Service;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.Customer.Repository.CustomerRepo;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
//@AllArgsConstructor
public class CustomerService {

    private final CustomerRepo customerRepo;
    public List<Customer> getCustomer() {
       return customerRepo.findAll();
    }
    public void addCustomer(Customer customer) {

        customerRepo.save(customer);
    }
}
