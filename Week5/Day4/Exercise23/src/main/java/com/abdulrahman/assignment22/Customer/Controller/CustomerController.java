package com.abdulrahman.assignment22.Customer.Controller;

import com.abdulrahman.assignment22.Customer.Model.Customer;
import com.abdulrahman.assignment22.Customer.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("/customer")
    public List<Customer> readCustomer(){
        return customerService.getCustomer();
    }

    @PostMapping("/customer")
    public ResponseEntity createCustomers(@RequestBody @Valid Customer customer) {

        customerService.addCustomer(customer);
        return ResponseEntity.status(200).body("Added");
    }
    @PutMapping("/customer/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id, @RequestBody @Valid Customer customer){
        customerService.editCustomer(id,customer);
        return ResponseEntity.status(200).body("Updated");
    }
    @DeleteMapping("/customer/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){

        customerService.deleteCustomer(id);
        return ResponseEntity.status(200).body("Teacher address was deleted!");

    }



}
