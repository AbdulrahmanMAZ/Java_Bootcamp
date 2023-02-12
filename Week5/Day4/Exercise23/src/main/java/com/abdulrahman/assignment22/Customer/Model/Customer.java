package com.abdulrahman.assignment22.Customer.Model;

import com.abdulrahman.assignment22.Merchant.Model.Merchant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Set;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private String area;

    @ManyToMany
    @JoinTable(
            name = "merchant_customer",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "merchant_id"))
    @JsonIgnore
    private Set<Merchant> merchants;
    public void addMerchant(Merchant merchant){
        this.merchants.add(merchant);
    }
}
