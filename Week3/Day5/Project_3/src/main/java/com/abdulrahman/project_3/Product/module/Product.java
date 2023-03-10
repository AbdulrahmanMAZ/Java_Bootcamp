package com.abdulrahman.project_3.Product.module;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class Product {
    @NotEmpty
    @Size(min = 3)
    private String id;
    @Size(min = 3)
    private String name;
    @Positive
    @NotNull
    @Pattern(regexp = "[0-9]+\\.{0,1}[0-9]{0,2}")
    private String price;
    @NotEmpty
    @Size(min = 3)
    private String categoryID;
}
