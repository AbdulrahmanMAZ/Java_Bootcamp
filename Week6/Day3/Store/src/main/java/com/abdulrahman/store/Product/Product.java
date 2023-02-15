package com.abdulrahman.store.Product;

import com.abdulrahman.store.Order.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(max = 40)
    private String name;
    @NotNull
    private Integer price;

    @ManyToOne
    @JsonIgnore
    private Order userOrder;

}
