package com.abdulrahman.exercise22.stores.Merchant.Model;


import com.abdulrahman.exercise22.stores.Branch.Model.Branch;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "merchant")
    @PrimaryKeyJoinColumn
    private Set<Branch> branches;


    public void addNewBranch(Branch branch) {
        this.branches.add(branch);
    }
}
