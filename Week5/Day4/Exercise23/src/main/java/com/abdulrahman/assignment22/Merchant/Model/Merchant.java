package com.abdulrahman.assignment22.Merchant.Model;


import com.abdulrahman.assignment22.Customer.Model.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotEmpty
    private String name;


    @NotNull
    @Pattern(regexp = "^.+@.+\\.\\w{2,}$" , message = "must be in this form XXX@XX.XX")
    @Column(columnDefinition = "varchar(40) unique")
    private String email;


    @ManyToMany(mappedBy = "merchants")
    @PrimaryKeyJoinColumn
    private Set<Customer> customers;

    public void addCustomer(Customer course){
        this.customers.add(course);
    }

}
