package com.abdulrahman.assignment14.module;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Employee {
    @NotNull
    @Size(min = 3)
    private String id;
    @NotNull
    @Size(min = 5)
    private  String name;
    @NotNull
    @Positive
    @Min(26)
    private int age;
    @NotNull
    @Pattern(regexp = "^supervisor||coordinator$")
    private String role;
    @NotNull
    private boolean onLeave=false;
    @NotNull
    @Positive
//    @Pattern(regexp = "^[0-9]$")
    @Min(1950)
    @Max(2023)
    private int employeemnetYear;
    @NotNull
    @PositiveOrZero
//    @Digits(integer = 4, fraction = 0)
    private int annualLeave;

}
