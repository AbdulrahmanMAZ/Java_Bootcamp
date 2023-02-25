package com.abdulrahman.final_Project.Advisor.model;

import com.abdulrahman.final_Project.Appointments.model.Book;
import com.abdulrahman.final_Project.Start_up.model.Customer;
import com.abdulrahman.final_Project.Location.model.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @NotNull
    private String name;
    @OneToOne(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "store")
    @PrimaryKeyJoinColumn
    private List<Book> books;

    @ManyToMany(mappedBy = "")
    @JoinTable(name = "customers_stores",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;
    public void addBookToStore(Book book){
        this.books.add(book);
    }
    public void registerCustomerToStore(Customer customer){
        customers.add(customer);
    }
}
