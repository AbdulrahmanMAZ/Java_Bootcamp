package com.abdulrahman.exercise21.CustomerDetails.Controller;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.abdulrahman.exercise21.CustomerDetails.DTO.CustomerDetailsDTO;
import com.abdulrahman.exercise21.CustomerDetails.Model.CustomerDetails;
import com.abdulrahman.exercise21.CustomerDetails.Service.CustomerDetailsService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v3")
public class CustomerDetailedController {
    private final CustomerDetailsService customerDetailsService;

    @GetMapping("/customerDetails")
    public List<CustomerDetails> readCustomer(){
        return customerDetailsService.getCustomer();
    }

    @PostMapping("/customerDetails")
    public ResponseEntity createCustomers(@RequestBody @Valid CustomerDetailsDTO customerDetails) {

        customerDetailsService.addCustomer(customerDetails);
        return ResponseEntity.status(200).body("Added");
    }
}
