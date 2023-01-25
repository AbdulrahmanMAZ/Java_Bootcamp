package com.abdulrahman.assignment13.module;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    int id;
    String title;
    String description;
    String status = "Not done";

}
