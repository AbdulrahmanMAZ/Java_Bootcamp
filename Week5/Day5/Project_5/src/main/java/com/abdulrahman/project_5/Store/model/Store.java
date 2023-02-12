package com.abdulrahman.project_5.Store.model;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.Location.model.Location;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor


public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    @PrimaryKeyJoinColumn
    private Location location;

    @OneToMany
    private Set<Book> books;

    @ManyToMany
    @JoinTable(
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Customer> customers;
    public void addBookToStore(Book book){
        books.add(book);
    }
    public void registerCustomerToStore(Customer customer){
        customers.add(customer);
    }
}
