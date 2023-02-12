package com.abdulrahman.project_5.Customer.service;

import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.Customer.repository.CustomerRepo;
import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.exception.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    final private CustomerRepo customerRepo;

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }
    public void addCustomer(Customer customer){
        customerRepo.save(customer);

    }
    public void editCustomer(Integer id,Customer customer){
        Customer temp = customerRepo.findCustomerById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        temp.setEmail(customer.getEmail());
        temp.setPhoneNumber(customer.getPhoneNumber());
//        temp.set(customer.getStore());
        customerRepo.save(temp);

    }
    public void deleteCustomer(Integer id){
        Customer temp = customerRepo.findCustomerById(id);
        if (temp == null) {
            throw new ApiException("Not found");
        }
        customerRepo.delete(temp);

    }

}
