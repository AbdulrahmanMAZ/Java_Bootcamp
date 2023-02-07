package com.abdulrahman.exercise21.TempDetails.Model;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class TempDetails {
    @Id
    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Customer customer;
}
