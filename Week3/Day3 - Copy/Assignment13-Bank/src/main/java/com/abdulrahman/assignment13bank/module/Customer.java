package com.abdulrahman.assignment13bank.module;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Customer {
    int ID;
    String username;
    int balance;
}
