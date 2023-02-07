package com.abdulrahman.exercise21.CustomerDetails.DTO;

import com.abdulrahman.exercise21.Customer.Model.Customer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
public class CustomerDetailsDTO {

    private Integer customer_id;
    private String name;
    private Integer age;
    private String gender;
}
