package com.abdulrahman.project_3.Category.module;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Category {
    @NotEmpty
    @Size(min = 3)
    private String id;
    @Size(min = 3)
    @NotEmpty
    private String name;

}
