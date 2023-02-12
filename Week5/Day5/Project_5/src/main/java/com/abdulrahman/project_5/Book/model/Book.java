package com.abdulrahman.project_5.Book.model;

import com.abdulrahman.project_5.Store.model.Store;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
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
    private String name;
    private Integer bookCount;
    private String genre;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "store_id")
    private Store store;



}
