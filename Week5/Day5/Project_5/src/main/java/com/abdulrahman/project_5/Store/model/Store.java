package com.abdulrahman.project_5.Store.model;

import com.abdulrahman.project_5.Book.model.Book;
import com.abdulrahman.project_5.Customer.model.Customer;
import com.abdulrahman.project_5.Location.model.Location;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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
