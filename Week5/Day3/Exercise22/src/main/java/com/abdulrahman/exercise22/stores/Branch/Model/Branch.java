package com.abdulrahman.exercise22.stores.Branch.Model;

import com.abdulrahman.exercise22.stores.Merchant.Model.Merchant;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Branch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY
    )
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "merchant_id")
    @JsonIgnore
    private Merchant merchant;
}
