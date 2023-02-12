package com.abdulrahman.project_5.Customer.model;

import com.abdulrahman.project_5.Store.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Customer
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String phoneNumber;
    private String email;

    @ManyToMany
    @JsonIgnore
    private List<Store> stores;

    public void addStoreToCustomer(Store store){
        stores.add(store);
    }


}
