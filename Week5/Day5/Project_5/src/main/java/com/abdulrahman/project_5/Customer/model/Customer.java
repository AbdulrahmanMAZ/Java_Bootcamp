package com.abdulrahman.project_5.Customer.model;

import com.abdulrahman.project_5.Store.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    @NotEmpty
    @Pattern(regexp = "^0\\d{9}$",message = "Must be 0XXXXXXXXX")
    @Column(columnDefinition = "varchar(10) unique not null")
    private String phoneNumber;
    @Pattern(regexp = "^.+@.+\\.\\w{2,}$" , message = "must be in this form XXX@XX.XX")
    @Column(columnDefinition = "varchar(40) unique not null")
    private String email;

    @ManyToMany(mappedBy = "customers")
    @JsonIgnore
    private List<Store> stores;

    public void addStoreToCustomer(Store store){
        stores.add(store);
    }


}
