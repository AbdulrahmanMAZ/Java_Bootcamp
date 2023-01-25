package com.abdulrahman.assignment13bank.controller;

import com.abdulrahman.assignment13bank.module.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v3")
public class BankController {
    ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("/customers")
    public ArrayList<Customer> getCustomer() {
    return customers;
    }
    @PostMapping("/customers")
    public String addCustomer(@RequestBody Customer customer) {
        customer.setBalance(0);
        customers.add(customer);
        return "Customer has been added successfully";
    }
    @PutMapping("/customers")
    public String UpdateCustomer(@PathVariable int id, @RequestBody Customer customer) {
        customers.set(id,customer);
        return "Customer has been added successfully";
    }
    @DeleteMapping("/customers")
    public String DeleteCustomer(@PathVariable int id) {
        customers.remove(id);
        return "Customer has been added successfully";
    }
    @PostMapping("/customers/deposit/{id}")
    public String DepositToCustomer(@PathVariable int id,@RequestBody Customer customer) {
        Customer tempCust = customers.get(id);
        int newBalance = tempCust.getBalance() + customer.getBalance();
        tempCust.setBalance(newBalance);
        customers.set(id,tempCust);
        return "Deposit has been added successfully";
    }
    @PutMapping("/customers/withdraw/{id}")
    public String WithdrawFromCustomer(@PathVariable int id,@RequestBody Customer customer) {
        Customer tempCust = customers.get(id);
        int newBalance = tempCust.getBalance() - customer.getBalance();
        tempCust.setBalance(newBalance);
        customers.set(id,tempCust);
        return "Deposit has been added successfully";
    }

}
