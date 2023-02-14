package com.abdulrahman.store.Product;

import com.abdulrahman.store.Orderr.Orderr;
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

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "product_orders",
            joinColumns = @JoinColumn(name = "product_id") ,
            inverseJoinColumns = @JoinColumn(name = "order_id") )
    private Set<Orderr> userOrders;

}
