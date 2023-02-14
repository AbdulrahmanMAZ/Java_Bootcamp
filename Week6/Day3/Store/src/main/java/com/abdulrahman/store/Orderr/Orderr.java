package com.abdulrahman.store.Orderr;



import com.abdulrahman.store.MyUser.MyUser;
import com.abdulrahman.store.Product.Product;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull

    private Integer quantity;
    @NotNull
    private Integer totalPrice;

    private LocalDateTime date_received;

    @Pattern(regexp = "^new||inProgress||completed$")
    private String status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private MyUser myUser;

    @ManyToMany(mappedBy = "userOrders")
    @JsonIgnore
    private Set<Product> products;

}
