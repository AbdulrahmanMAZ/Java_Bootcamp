package com.abdulrahman.project_3.User.module;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class User {
    @NotNull
    @Size(min = 3)
    private String id;
    @NotEmpty
    @Size(min = 5)
    private String userName;
    @NotEmpty
    @Size(min = 6)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$")
    private String password;
    @Email
    @NotNull
    @NotEmpty
    private String email;
    @NotEmpty
    @NotNull
    @Pattern(regexp = "^Admin||Customer$")
    private String role;
//    @Positive
    @NotNull
    @Pattern(regexp = "[0-9]+\\.{0,1}[0-9]{0,2}")
    private String balance;

}
