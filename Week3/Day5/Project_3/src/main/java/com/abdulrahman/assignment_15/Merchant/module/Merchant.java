package com.abdulrahman.assignment_15.Merchant.module;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Merchant {
    @NotEmpty
    @Size(min = 3)
    private String id;
    @Size(min = 3)
    @NotEmpty
    private String name;

}
