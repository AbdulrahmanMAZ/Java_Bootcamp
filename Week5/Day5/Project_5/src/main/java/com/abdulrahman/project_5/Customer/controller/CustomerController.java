package com.abdulrahman.project_5.Customer.controller;

import com.abdulrahman.project_5.Customer.service.CustomerService;
import com.abdulrahman.project_5.Customer.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
public class CustomerController {

    // ServiceInjection
    private final CustomerService customerService;

    // getter
    @GetMapping("/getcustomer")
    public List<Customer> getBooks(){
        return customerService.getCustomers();
    }
    @PostMapping("/addcustomer")

    public ResponseEntity addBooks( @RequestBody Customer customer){
                customerService.addCustomer(customer);
                return ResponseEntity.status(200).body("Success");

    }
    @PutMapping("/editcustomer")
    public ResponseEntity updateBooks(@PathVariable Integer id, @RequestBody Customer customer){
        customerService.editCustomer(id,customer);
        return ResponseEntity.status(200).body("Updated");

    }
    @DeleteMapping("/deletecustomer")
    public ResponseEntity updateBooks(@PathVariable Integer id){
        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Updated");

    }
}
