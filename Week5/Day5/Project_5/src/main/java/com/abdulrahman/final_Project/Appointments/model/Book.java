package com.abdulrahman.final_Project.Appointments.model;

import com.abdulrahman.final_Project.Advisor.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Book {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @PositiveOrZero
    private Integer bookCount;
    @NotNull
    @Pattern(regexp = "^Action||Drama||Comedy||Horror||Romance||Mystery||Thriller$")
    private String genre;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "store_id")
    private Store store;



}
