package com.abdulrahman.assignment_15.MerchantStock.module;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MerchantStock {
    @NotEmpty
    @Size(min = 3)
    private String id;
    @NotEmpty
    @Size(min = 3)
    private String productID;
    @NotEmpty
    @Size(min = 3)
    private String merchantID;
    @Min(10)
    @NotNull
    private int stock;
}
