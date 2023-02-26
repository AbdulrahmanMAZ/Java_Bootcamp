package com.abdulrahman.final_Project.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;

public record AdvisorRegisterFormDTO(@NotEmpty
                                 @NotNull String username,
                                     @NotEmpty
                              @NotNull String password,
                                     @Pattern(regexp = "^.+@.+\\.\\w{2,}$" ,message = "must be in this form XXX@XX.XX")
                              String email,
                                     @NotEmpty
                              @NotNull String speciality,
                                     @PositiveOrZero @NotNull Integer feePerHour, @NotEmpty
                                     @NotNull String gender
                             , @NotEmpty
                                     @NotNull
                                      String firstName,
                                     @NotEmpty
                                             @NotNull
                                              String lastName,

                                     @NotEmpty
                              @Pattern(regexp = "^0\\d{9}$",message = "Must be 0XXXXXXXXX")
                              String phoneNumber){}