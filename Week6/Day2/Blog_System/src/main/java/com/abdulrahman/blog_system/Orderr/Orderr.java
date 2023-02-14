package com.abdulrahman.blog_system.Orderr;


import com.abdulrahman.blog_system.MyUser.MyUser;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Orderr {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull

    private Integer quantity;
    @NotNull
    private Integer totalPrice;

    private LocalDateTime date_received;

    @Pattern(regexp = "^new||inProgress||completed$")
    private String status;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private MyUser myUser;

}
