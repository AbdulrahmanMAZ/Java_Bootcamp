package com.abdulrahman.final_Project.helper;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public record StartUpRegisterFormDAO(@NotEmpty
                                 @NotNull String username,
                                     @NotEmpty
                              @NotNull String password,
                                     @Pattern(regexp = "^.+@.+\\.\\w{2,}$" ,message = "must be in this form XXX@XX.XX")
                              String email,
                                     @NotEmpty
                              @NotNull String name,
                                     @NotEmpty
                                     @NotNull String ownerName,
                                     @NotEmpty
                                     @NotNull String basedIn,
                                     String industry,
                                     @NotEmpty
                              @Pattern(regexp = "^0\\d{9}$",message = "Must be 0XXXXXXXXX")
                              String phoneNumber){}