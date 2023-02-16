package com.abdulrahman.store.Order;



import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@Table(name = "Orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Integer quantity;

    private Integer totalPrice;
    @CreationTimestamp
    private Timestamp date_created;
    private LocalDateTime date_received = LocalDateTime.now().plusDays(5);

    @Pattern(regexp = "^new||inProgress||completed$")
    private String status;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private MyUser myUser;

    @OneToMany(mappedBy = "userOrder")
    @JsonIgnore
    private Set<Product> products;


    public void addProdct(Product product){
        this.products.add(product);
    }
}
