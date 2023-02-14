package com.abdulrahman.project_5.DTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class LocationDTO {

    private Integer store_id;
    private String  area;
    private String street;

}
