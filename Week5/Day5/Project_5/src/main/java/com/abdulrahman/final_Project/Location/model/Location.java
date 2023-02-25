package com.abdulrahman.final_Project.Location.model;

import com.abdulrahman.final_Project.Advisor.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Location {
    @Id
    @JsonIgnore
    private Integer id;
    @NotNull
    @NotEmpty
    private String area;
    @NotNull
    @NotEmpty
    private String street;
    @OneToOne
    @MapsId
    @JsonIgnore
    private Store store;

}
