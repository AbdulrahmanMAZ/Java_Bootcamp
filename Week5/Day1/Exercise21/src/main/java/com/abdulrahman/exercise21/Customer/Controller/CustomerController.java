package com.abdulrahman.exercise21.Customer.Controller;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.Customer.Service.CustomerService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v3/")
@RequiredArgsConstructor
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
//    @PutMapping("/customer/{id}")
//    public ResponseEntity updateMovies(@PathVariable String id, @RequestBody @Valid Director customer, Errors errors){
//
//        customerService.editDirector(id,customer);
//        return ResponseEntity.status(200).body("Movie modified!");
//
//    }
//    @DeleteMapping("/customer/{id}")
//    public ResponseEntity deleteMovies(@PathVariable String id){
//
//        customerService.deleteDirector(id);
//        return ResponseEntity.status(200).body("Movie deleted!");
//
//    }
}
